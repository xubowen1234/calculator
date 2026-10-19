# Calculator — CI/CD Pipeline (GitHub Actions)

[![CI](https://github.com/OWNER_PLACEHOLDER/REPO_PLACEHOLDER/actions/workflows/ci-calculator.yml/badge.svg)](https://github.com/OWNER_PLACEHOLDER/REPO_PLACEHOLDER/actions/workflows/ci-calculator.yml)

A simple command-line calculator built in Java with Maven, continuously integrated
with **GitHub Actions** (Lab 3–5 project, Software Development Tools).

## Features

- Four basic operations: `add`, `subtract`, `multiply`, `divide`
- Division by zero throws `ArithmeticException` instead of crashing
- JUnit 5 unit tests (10 test cases), JaCoCo coverage report (Lab 4)
- Continuous Integration: every push to `main` (and every pull request)
  compiles the source and runs the full test suite automatically

## Project structure

```
calculator/
├── .github/workflows/ci-calculator.yml   # the CI pipeline definition (YAML)
├── src/main/java/com/example/calculator/ # Calculator.java + Main.java
├── src/test/java/com/example/calculator/ # CalculatorTest.java (JUnit 5)
├── pom.xml                               # Maven project configuration
└── README.md                             # this file
```

## How the CI pipeline works

1. `on: push / pull_request` — the workflow triggers on every push to `main`
   and on every pull request targeting `main`.
2. The job runs on an **ubuntu-latest** GitHub-hosted runner.
3. A **build matrix** runs the job in parallel on **JDK 17 and JDK 21**.
4. Steps: checkout the code → install the JDK → restore the Maven cache →
   `mvn clean compile` → `mvn test`.
5. If any step fails, the run turns **red** and the team is notified immediately.

## Run locally

```bash
mvn clean test        # compile + run all JUnit 5 tests
java -jar target/calculator-1.0.jar   # run the calculator (after mvn package)
```
