package utils;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the TokenUtils class.
 */
public class TokenUtilsTest {

    private final TokenUtils tokenUtils = new TokenUtils();

    @Test
    public void testTokenizeEquation_SimpleExpression() {
        final String equation = "2 + 3";
        final List<String> tokens = tokenUtils.tokenizeEquation(equation);
        assertEquals(3, tokens.size(), "Should tokenize into 3 parts");
        assertEquals("2", tokens.get(0), "First token should be 2");
        assertEquals("+", tokens.get(1), "Second token should be +");
        assertEquals("3", tokens.get(2), "Third token should be 3");
    }

    @Test
    public void testTokenizeEquation_WithNegativeNumber() {
        final String equation = "-2 + 3";
        final List<String> tokens = tokenUtils.tokenizeEquation(equation);
        assertEquals(3, tokens.size(), "Should tokenize into 3 parts");
        assertEquals("-2", tokens.get(0), "First token should be -2");
        assertEquals("+", tokens.get(1), "Second token should be +");
        assertEquals("3", tokens.get(2), "Third token should be 3");
    }

    @Test
    public void testTokenizeEquation_WithParentheses() {
        final String equation = "( 2 + 3 ) * 4";
        final List<String> tokens = tokenUtils.tokenizeEquation(equation);
        assertEquals(7, tokens.size(), "Should tokenize into 7 parts");
        assertEquals("(", tokens.get(0), "First token should be (");
        assertEquals("2", tokens.get(1), "Second token should be 2");
        assertEquals("+", tokens.get(2), "Third token should be +");
        assertEquals("3", tokens.get(3), "Fourth token should be 3");
        assertEquals(")", tokens.get(4), "Fifth token should be )");
        assertEquals("*", tokens.get(5), "Sixth token should be *");
        assertEquals("4", tokens.get(6), "Seventh token should be 4");
    }

    @Test
    public void testTokenizeEquation_WithDecimal() {
        final String equation = "2.5 + 3.7";
        final List<String> tokens = tokenUtils.tokenizeEquation(equation);
        assertEquals(3, tokens.size(), "Should tokenize into 3 parts");
        assertEquals("2.5", tokens.get(0), "First token should be 2.5");
        assertEquals("+", tokens.get(1), "Second token should be +");
        assertEquals("3.7", tokens.get(2), "Third token should be 3.7");
    }

    @Test
    public void testIsNumeric_ValidNumber() {
        assertTrue(tokenUtils.isNumeric("123"), "Should recognize 123 as numeric");
        assertTrue(tokenUtils.isNumeric("123.456"), "Should recognize 123.456 as numeric");
        assertTrue(tokenUtils.isNumeric("-123"), "Should recognize -123 as numeric");
    }

    @Test
    public void testIsNumeric_InvalidNumber() {
        assertFalse(tokenUtils.isNumeric("abc"), "Should not recognize abc as numeric");
        assertFalse(tokenUtils.isNumeric("12.34.56"), "Should not recognize 12.34.56 as numeric");
    }

    @Test
    public void testIsOperator_ValidOperator() {
        assertTrue(tokenUtils.isOperator("+"), "Should recognize + as an operator");
        assertTrue(tokenUtils.isOperator("-"), "Should recognize - as an operator");
        assertTrue(tokenUtils.isOperator("*"), "Should recognize * as an operator");
    }

    @Test
    public void testIsOperator_InvalidOperator() {
        assertFalse(tokenUtils.isOperator("a"), "Should not recognize a as an operator");
        assertFalse(tokenUtils.isOperator("++"), "Should not recognize ++ as an operator");
    }
}
