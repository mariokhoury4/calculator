package model.operation.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

/**
 * Unit tests for basic operations in the Calculator application.
 */
public class OperationTest {

    @Test
    public void testPlusOperation() {
        final PlusOperation plus = new PlusOperation();
        assertEquals(5.0, plus.eval(2.0, 3.0), 0.0001, "2 + 3 should be 5.0");
        assertEquals(0.0, plus.eval(-2.0, 2.0), 0.0001, "-2 + 2 should be 0.0");
        assertEquals(-5.0, plus.eval(-2.0, -3.0), 0.0001, "-2 + -3 should be -5.0");
    }

    @Test
    public void testMinusOperation() {
        final MinusOperation minus = new MinusOperation();
        assertEquals(-1.0, minus.eval(2.0, 3.0), 0.0001, "2 - 3 should be -1.0");
        assertEquals(4.0, minus.eval(2.0, -2.0), 0.0001, "2 - (-2) should be 4.0");
        assertEquals(1.0, minus.eval(-2.0, -3.0), 0.0001, "-2 - (-3) should be 1.0");
    }

    @Test
    public void testMultiplicationOperation() {
        final MultiplicationOperation multiply = new MultiplicationOperation();
        assertEquals(6.0, multiply.eval(2.0, 3.0), 0.0001, "2 * 3 should be 6.0");
        assertEquals(-6.0, multiply.eval(2.0, -3.0), 0.0001, "2 * (-3) should be -6.0");
        assertEquals(0.0, multiply.eval(2.0, 0.0), 0.0001, "2 * 0 should be 0.0");
    }

    @Test
    public void testDivisionOperation_ValidInput() {
        final DivisionOperation divide = new DivisionOperation();
        assertEquals(2.0, divide.eval(6.0, 3.0), 0.0001, "6 / 3 should be 2.0");
        assertEquals(-2.0, divide.eval(6.0, -3.0), 0.0001, "6 / (-3) should be -2.0");
    }

    @Test
    public void testDivisionOperation_DivisionByZero() {
        final DivisionOperation divide = new DivisionOperation();
        assertThrowsExactly(IllegalArgumentException.class, () -> divide.eval(6.0, 0.0), "Division by zero should throw exception");
    }

    @Test
    public void testModuloOperation_ValidInput() {
        final ModuloOperation modulo = new ModuloOperation();
        assertEquals(1.0, modulo.eval(7.0, 3.0), 0.0001, "7 % 3 should be 1.0");
        assertEquals(-1.0, modulo.eval(-7.0, 3.0), 0.0001, "-7 % 3 should be -1.0");
    }

    @Test
    public void testModuloOperation_DivisionByZero() {
        final ModuloOperation modulo = new ModuloOperation();
        assertThrowsExactly(IllegalArgumentException.class, () -> modulo.eval(7.0, 0.0), "Modulo by zero should throw exception");
    }

    @Test
    public void testExponentiationOperation() {
        final ExponentiationOperation exp = new ExponentiationOperation();
        assertEquals(8.0, exp.eval(2.0, 3.0), 0.0001, "2 ^ 3 should be 8.0");
        assertEquals(0.25, exp.eval(2.0, -2.0), 0.0001, "2 ^ -2 should be 0.25");
        assertEquals(1.0, exp.eval(5.0, 0.0), 0.0001, "5 ^ 0 should be 1.0");
    }
}
