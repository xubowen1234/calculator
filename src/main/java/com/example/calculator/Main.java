package com.example.calculator;

import java.util.Scanner;

/**
 * Command-line entry point of the calculator application.
 */
public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Simple Calculator (Maven project) ===");
            System.out.print("Enter first number: ");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter operator (+, -, *, /): ");
            String op = scanner.nextLine().trim();
            System.out.print("Enter second number: ");
            double b = Double.parseDouble(scanner.nextLine());

            double result;
            switch (op) {
                case "+":
                    result = calc.add(a, b);
                    break;
                case "-":
                    result = calc.subtract(a, b);
                    break;
                case "*":
                    result = calc.multiply(a, b);
                    break;
                case "/":
                    result = calc.divide(a, b);
                    break;
                default:
                    System.out.println("Error: unknown operator '" + op + "'");
                    return;
            }
            System.out.printf("%.2f %s %.2f = %.2f%n", a, op, b, result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: invalid number input.");
        }
    }
}
