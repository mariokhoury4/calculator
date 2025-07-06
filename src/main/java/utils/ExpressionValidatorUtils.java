package utils;

import java.util.List;

import static utils.Constants.FUNCTION_MAP;

/**
 * Utility class for validating tokenized expressions.
 */
public class ExpressionValidatorUtils {
    private final TokenUtils tokenUtils;

    /**
     * Constructs a validator with a TokenUtils dependency.
     *
     * @param tokenUtils The token utility to use for numeric checks.
     */
    public ExpressionValidatorUtils(TokenUtils tokenUtils) {
        this.tokenUtils = tokenUtils;
    }

    /**
     * Validates a tokenized mathematical expression.
     *
     * @param equationList The list of tokens.
     * @throws IllegalArgumentException if invalid.
     */
    public void validateEquation(final List<String> equationList) {
        if (equationList.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: No equation provided.");
        }

        final String firstToken = equationList.get(0);
        if (!tokenUtils.isNumeric(firstToken)
                && !firstToken.equals("(")
                && !FUNCTION_MAP.containsKey(firstToken)) {
            throw new IllegalArgumentException("Invalid input: The equation should start with a number, '(', or a supported function.");
        }

        validateParentheses(equationList);
    }

    private void validateParentheses(List<String> tokens) {
        int balance = 0;
        for (String token : tokens) {
            if ("(".equals(token)) {
                balance++;
            }
            else if (")".equals(token)) {
                balance--;
            }
            if (balance < 0) {
                throw new IllegalArgumentException("Mismatched parentheses: extra closing parenthesis.");
            }
        }
        if (balance != 0) {
            throw new IllegalArgumentException("Mismatched parentheses: missing closing parenthesis.");
        }
    }
}
