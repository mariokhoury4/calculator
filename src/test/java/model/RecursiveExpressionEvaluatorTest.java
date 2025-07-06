package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TokenUtils;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}
