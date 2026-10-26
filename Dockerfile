# ============================================================
# Dockerfile for the Java Calculator (Lab 6)
# Multi-stage build:
#   Stage 1 (build)  : full Maven + JDK image, compiles and
#                      packages the jar
#   Stage 2 (runtime): slim JRE image, runs the jar
# The final image only contains the JRE + the jar, so it is
# much smaller than the full Maven image.
# ============================================================

# --- Stage 1: build the application --------------------------
# Official Maven image with OpenJDK 17 (same major version as
# the local project, which targets Java 17 via maven.compiler.release).
FROM maven:3.8-openjdk-17 AS build

# WORKDIR sets the working directory for every following
# instruction; the path is created automatically if missing.
WORKDIR /app

# COPY <host path> <image path>:
# copy only pom.xml first so Maven can cache the dependencies
# layer — this layer only changes when pom.xml changes.
COPY pom.xml .

# dependency:go-offline downloads all plugins and dependencies
# now (once), so the later package step does not download them
# again every time the source code changes.
RUN mvn -B dependency:go-offline

# Copy the whole source tree into the image.
COPY src ./src

# Build the executable jar. -DskipTests is used here because
# the unit tests are already run in Lab 4 and in the GitHub
# Actions CI pipeline; running them again in the image build
# would only slow the build down.
RUN mvn -B package -DskipTests

# --- Stage 2: minimal runtime image --------------------------
# openjdk:17-jre-slim is a Debian-slim image with only the Java
# runtime environment — no Maven, no compiler, no build tools.
FROM openjdk:17-jre-slim

WORKDIR /app

# Copy just the jar produced in stage 1 into the runtime image.
COPY --from=build /app/target/calculator-1.0.jar app.jar

# ENTRYPOINT defines the command that runs when the container
# starts. The array form (no shell) runs java directly.
# "java -jar app.jar" starts the interactive calculator.
ENTRYPOINT ["java", "-jar", "app.jar"]
