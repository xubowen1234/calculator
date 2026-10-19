package com.example.calculator;

/**
 * A simple calculator that supports the four basic arithmetic operations:
 * addition, subtraction, multiplication and division.
 *
 * NOTE: This is the fixed version after the Lab 4 debugging session.
 * The two logical bugs found by the unit tests were:
 *   1. subtract() accidentally returned a + b (fixed to a - b).
 *   2. divide() silently returned 0 when b was zero (fixed to throw
 *      an ArithmeticException).
 */
public class Calculator {

    /**
     * Returns the sum of a and b.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Returns the difference a - b.
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Returns the product of a and b.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Returns the quotient a / b. Throws ArithmeticException when b is zero.
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
