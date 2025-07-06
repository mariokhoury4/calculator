package model;

import utils.TokenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Evaluates mathematical expressions recursively, handling parentheses and implicit multiplication.
 * This class uses an OperationRegistry to evaluate expressions and a TokenUtils for token manipulation.
 */
public class RecursiveExpressionEvaluator {

    private final OperationRegistry registry;
    private final TokenUtils tokenUtils;

    /**
     * Constructs a RecursiveExpressionEvaluator with the specified OperationRegistry and TokenUtils.
     *
     * @param operationRegistry The registry containing operations for evaluation.
     * @param tokenUtils The utility for token manipulation.
     */
    public RecursiveExpressionEvaluator(final OperationRegistry operationRegistry,
                                        final TokenUtils tokenUtils) {
        this.registry = operationRegistry;
        this.tokenUtils = tokenUtils;
    }

    /**
     * Evaluates a list of tokens representing a mathematical expression.
     * This method handles implicit multiplication by adding multiplication operators before parentheses.
     *
     * @param tokens The list of tokens to evaluate.
     * @return The result of the evaluated expression as a Double.
     */
    public Double evaluate(final List<String> tokens) {
        List<String> updateTokensForParenthesis = addMultiplicationOperationBeforeParenthesis(tokens);
        return evaluateRecursive(updateTokensForParenthesis);
    }

    /**
     * Adds multiplication operators before parentheses and between numbers and parentheses
     * to handle implicit multiplication in the expression.
     *
     * @param tokens The list of tokens to process.
     * @return A new list of tokens with implicit multiplication handled.
     */
    private List<String> addMultiplicationOperationBeforeParenthesis(final List<String> tokens) {
        List<String> updatedTokens = new ArrayList<>();

        if (!tokens.isEmpty()) {
            updatedTokens.add(tokens.get(0)); // Add first token
        }

        for (int i = 1; i < tokens.size(); i++) {
            final String prev = tokens.get(i - 1);
            final String curr = tokens.get(i);

            // Add "*" if there's implicit multiplication:
            // 1. number followed by (
            // 2. ) followed by (
            // 3. ) followed by number
            if (("(".equals(curr) && (tokenUtils.isNumeric(prev) || ")".equals(prev))) ||
                    (tokenUtils.isNumeric(curr) && ")".equals(prev))) {
                updatedTokens.add("*");
            }

            updatedTokens.add(curr);
        }
        return updatedTokens;
    }

    /**
     * Recursively evaluates the expression represented by the list of tokens.
     * This method handles nested parentheses by evaluating innermost expressions first.
     *
     * @param tokens The list of tokens to evaluate.
     * @return The result of the evaluated expression as a Double.
     */
    private Double evaluateRecursive(final List<String> tokens) {
        while(tokens.contains("(")) {
            int openIdx = -1;
            int closeIdx = -1;

            for (int i = 0; i < tokens.size(); i++) {
                if ("(".equals(tokens.get(i))) {
                    openIdx = i;
                }

                if (")".equals(tokens.get(i))) {
                    closeIdx = i;
                    break;
                }
            }

            if (openIdx == -1 || closeIdx == -1 || openIdx > closeIdx) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            final List<String> subExpr = tokens.subList(openIdx + 1, closeIdx);
            double result = evaluateRecursive(new ArrayList<>(subExpr));

            // Replace (subExpr) with result
            for (int i = 0; i <= closeIdx - openIdx; i++) {
                tokens.remove(openIdx);
            }
            tokens.add(openIdx, String.valueOf(result));
        }

        return registry.evaluateExpression(tokens);
    }
}
