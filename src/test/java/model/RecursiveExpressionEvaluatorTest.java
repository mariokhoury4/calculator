package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TokenUtils;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;


/**
 * Unit tests for the RecursiveExpressionEvaluator class.
 */
public class RecursiveExpressionEvaluatorTest {

    private RecursiveExpressionEvaluator evaluator;
    private TokenUtils tokenUtils;

    @BeforeEach
    public void setUp() {
        final OperationRegistry registry = new OperationRegistry();
        tokenUtils = new TokenUtils();
        evaluator = new RecursiveExpressionEvaluator(registry, tokenUtils);
    }

    @Test
    public void testEvaluate_SimpleAddition() {
        final List<String> tokens = Arrays.asList("2", "+", "3");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(5.0, result, "2 + 3 should equal 5.0");
    }

    @Test
    public void testEvaluate_MultiplicationPrecedence() {
        final List<String> tokens = Arrays.asList("2", "+", "3", "*", "4");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(14.0, result, "2 + 3 * 4 should equal 14.0 due to precedence");
    }

    @Test
    public void testEvaluate_Parentheses() {
        final List<String> tokens = Arrays.asList("(", "2", "+", "3", ")", "*", "4");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(20.0, result, "(2 + 3) * 4 should equal 20.0");
    }

    @Test
    public void testEvaluate_ImplicitMultiplication() {
        final List<String> tokens = Arrays.asList("2", "(", "3", "+", "4", ")");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(14.0, result, "2 (3 + 4) should equal 14.0 with implicit multiplication");
    }

    @Test
    public void testEvaluate_NestedParentheses() {
        final List<String> tokens = Arrays.asList("(", "1", "+", "(", "2", "*", "3", ")", ")", "*", "4");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(28.0, result, "(1 + (2 * 3)) * 4 should equal 28.0");
    }

    @Test
    public void testEvaluate_Exponentiation() {
        final List<String> tokens = Arrays.asList("2", "^", "3");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(8.0, result, "2 ^ 3 should equal 8.0");
    }

    @Test
    public void testEvaluate_UnaryFunction_Sqrt() {
        final List<String> tokens = Arrays.asList("sqrt", "(", "4", ")");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(2.0, result, "sqrt(4) should equal 2.0");
    }

    @Test
    public void testEvaluate_UnaryFunction_Sin() {
        final List<String> tokens = Arrays.asList("sin", "(", "0", ")");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(0.0, result, 0.0001, "sin(0) should equal 0.0");
    }

    @Test
    public void testEvaluate_ComplexExpressionWithFunctions() {
        final List<String> tokens = Arrays.asList("2", "*", "sin", "(", "0", ")", "+", "sqrt", "(", "9", ")");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(3.0, result, 0.0001, "2 * sin(0) + sqrt(9) should equal 3.0");
    }

    @Test
    public void testEvaluate_MismatchedParentheses() {
        final List<String> tokens = Arrays.asList("(", "2", "+", "3");
        assertThrowsExactly(IllegalArgumentException.class, () -> evaluator.evaluate(tokens), "Mismatched parentheses should throw exception");
    }

    @Test
    public void testEvaluate_DivisionByZero() {
        final List<String> tokens = Arrays.asList("6", "/", "0");
        assertThrowsExactly(IllegalArgumentException.class, () -> evaluator.evaluate(tokens), "Division by zero should throw exception");
    }

    @Test
    public void testEvaluate_LargeExpression() {
        final List<String> tokens = Arrays.asList("1", "+", "2", "*", "3", "+", "4", "*", "5", "+", "6", "*", "7");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(69.0, result, "1 + 2 * 3 + 4 * 5 + 6 * 7 should equal 69.0");
    }

    @Test
    public void testEvaluate_NestedFunctions() {
        final List<String> tokens = Arrays.asList("sqrt", "(", "abs", "(", "-4", ")", ")");
        final Double result = evaluator.evaluate(tokens);
        assertEquals(2.0, result, "sqrt(abs(-4)) should equal 2.0");
    }

    @Test
    public void testEvaluate_InvalidFunctionArgument() {
        final List<String> tokens = Arrays.asList("sqrt", "(", "-4", ")");
        assertThrowsExactly(IllegalArgumentException.class, () -> evaluator.evaluate(tokens), "sqrt(-4) should throw exception for invalid argument");
    }
}
