package model.operation.unary;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

/**
 * Unit tests for unary functions in the Calculator application.
 */
public class FunctionTest {

    @Test
    public void testSqrtFunction_ValidInput() {
        final SqrtFunction sqrt = new SqrtFunction();
        assertEquals(2.0, sqrt.apply(4.0), 0.0001, "Square root of 4 should be 2.0");
        assertEquals(0.0, sqrt.apply(0.0), 0.0001, "Square root of 0 should be 0.0");
    }

    @Test
    public void testSqrtFunction_NegativeInput() {
        final SqrtFunction sqrt = new SqrtFunction();
        assertThrowsExactly(IllegalArgumentException.class, () -> sqrt.apply(-4.0), "Square root of negative number should throw exception");
    }

    @Test
    public void testAbsFunction() {
        final AbsFunction abs = new AbsFunction();
        assertEquals(5.0, abs.apply(-5.0), 0.0001, "Absolute value of -5 should be 5.0");
        assertEquals(5.0, abs.apply(5.0), 0.0001, "Absolute value of 5 should be 5.0");
        assertEquals(0.0, abs.apply(0.0), 0.0001, "Absolute value of 0 should be 0.0");
    }

    @Test
    public void testSinFunction() {
        final SinFunction sin = new SinFunction();
        assertEquals(0.0, sin.apply(0.0), 0.0001, "Sine of 0 should be 0.0");
        assertEquals(1.0, sin.apply(Math.PI / 2), 0.0001, "Sine of PI/2 should be 1.0");
        assertEquals(0.0, sin.apply(Math.PI), 0.0001, "Sine of PI should be 0.0");
    }

    @Test
    public void testCosFunction() {
        final CosFunction cos = new CosFunction();
        assertEquals(1.0, cos.apply(0.0), 0.0001, "Cosine of 0 should be 1.0");
        assertEquals(0.0, cos.apply(Math.PI / 2), 0.0001, "Cosine of PI/2 should be 0.0");
        assertEquals(-1.0, cos.apply(Math.PI), 0.0001, "Cosine of PI should be -1.0");
    }

    @Test
    public void testTanFunction() {
        final TanFunction tan = new TanFunction();
        assertEquals(0.0, tan.apply(0.0), 0.0001, "Tangent of 0 should be 0.0");
        assertThrowsExactly(IllegalArgumentException.class, () -> tan.apply(Math.PI / 2), "Tangent of PI/2 should throw exception due to undefined value");
    }

    @Test
    public void testLnFunction() {
        final LnFunction ln = new LnFunction();
        assertEquals(0.0, ln.apply(1.0), 0.0001, "Natural log of 1 should be 0.0");
        assertThrowsExactly(IllegalArgumentException.class, () -> ln.apply(0.0), "Natural log of 0 should throw exception");
        assertThrowsExactly(IllegalArgumentException.class, () -> ln.apply(-1.0), "Natural log of negative number should throw exception");
    }

    @Test
    public void testLogFunction() {
        final LogFunction log = new LogFunction();
        assertEquals(0.0, log.apply(1.0), 0.0001, "Log base 10 of 1 should be 0.0");
        assertEquals(1.0, log.apply(10.0), 0.0001, "Log base 10 of 10 should be 1.0");
        assertThrowsExactly(IllegalArgumentException.class, () -> log.apply(0.0), "Log base 10 of 0 should throw exception");
        assertThrowsExactly(IllegalArgumentException.class, () -> log.apply(-1.0), "Log base 10 of negative number should throw exception");
    }

    @Test
    public void testExpFunction() {
        final ExpFunction exp = new ExpFunction();
        assertEquals(1.0, exp.apply(0.0), 0.0001, "Exponential of 0 should be 1.0");
        assertEquals(Math.E, exp.apply(1.0), 0.0001, "Exponential of 1 should be e");
    }

    @Test
    public void testFloorFunction() {
        final FloorFunction floor = new FloorFunction();
        assertEquals(3.0, floor.apply(3.7), 0.0001, "Floor of 3.7 should be 3.0");
        assertEquals(-4.0, floor.apply(-3.2), 0.0001, "Floor of -3.2 should be -4.0");
        assertEquals(0.0, floor.apply(0.0), 0.0001, "Floor of 0 should be 0.0");
    }

    @Test
    public void testCeilFunction() {
        final CeilFunction ceil = new CeilFunction();
        assertEquals(4.0, ceil.apply(3.2), 0.0001, "Ceiling of 3.2 should be 4.0");
        assertEquals(-3.0, ceil.apply(-3.7), 0.0001, "Ceiling of -3.7 should be -3.0");
        assertEquals(0.0, ceil.apply(0.0), 0.0001, "Ceiling of 0 should be 0.0");
    }

    @Test
    public void testRoundFunction() {
        final RoundFunction round = new RoundFunction();
        assertEquals(4.0, round.apply(3.6), 0.0001, "Round of 3.6 should be 4.0");
        assertEquals(3.0, round.apply(3.4), 0.0001, "Round of 3.4 should be 3.0");
        assertEquals(-4.0, round.apply(-3.6), 0.0001, "Round of -3.6 should be -4.0");
        assertEquals(0.0, round.apply(0.0), 0.0001, "Round of 0 should be 0.0");
    }
}
