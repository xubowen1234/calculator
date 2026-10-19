package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the Calculator class.
 * Covers normal calculations, boundary values and the
 * division-by-zero exception.
 */
class CalculatorTest {

    private static final double DELTA = 1e-9;

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    // ---------- Addition ----------

    @Test
    void testAddPositiveNumbers() {
        assertEquals(5.0, calc.add(2.0, 3.0), DELTA);
    }

    @Test
    void testAddWithZero() {
        assertEquals(3.0, calc.add(3.0, 0.0), DELTA);
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-5.0, calc.add(-2.0, -3.0), DELTA);
    }

    // ---------- Subtraction ----------

    @Test
    void testSubtractPositiveNumbers() {
        assertEquals(2.0, calc.subtract(5.0, 3.0), DELTA);
    }

    @Test
    void testSubtractNegativeResult() {
        assertEquals(-2.0, calc.subtract(3.0, 5.0), DELTA);
    }

    // ---------- Multiplication ----------

    @Test
    void testMultiplyPositiveNumbers() {
        assertEquals(42.0, calc.multiply(6.0, 7.0), DELTA);
    }

    @Test
    void testMultiplyByZero() {
        assertEquals(0.0, calc.multiply(9.0, 0.0), DELTA);
    }

    // ---------- Division ----------

    @Test
    void testDividePositiveNumbers() {
        assertEquals(2.5, calc.divide(5.0, 2.0), DELTA);
    }

    @Test
    void testDivideByOne() {
        assertEquals(7.0, calc.divide(7.0, 1.0), DELTA);
    }

    @Test
    void testDivideByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10.0, 0.0));
    }
}
