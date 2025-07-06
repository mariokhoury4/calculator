package utils;

import java.util.ArrayList;
import java.util.List;

import static utils.Constants.OPERATION_MAP;

/**
 * Utility class for tokenizing and validating mathematical expressions.
 */
public class TokenUtils {

    /**
     * Splits a string mathematical expression into tokens (numbers and operators).
     *
     * @param equation The expression to tokenize.
     * @return A list of tokens as strings.
     */
    public List<String> tokenizeEquation(String equation) {
        List<String> tokens = new ArrayList<>();
        String sanitized = equation.replaceAll("\\s+", "");
        int i = 0;

        while (i < sanitized.length()) {
            final char ch = sanitized.charAt(i);

            // Handle negative number
            if (ch == '-' && (i == 0 || isOperator(String.valueOf(sanitized.charAt(i - 1))) || sanitized.charAt(i - 1) == '(')) {
                // Start of number with minus
                int j = i + 1;
                while (j < sanitized.length() && (Character.isDigit(sanitized.charAt(j)) || sanitized.charAt(j) == '.')) {
                    j++;
                }
                tokens.add(sanitized.substring(i, j));
                i = j;
            }

            // Handle number
            else if (Character.isDigit(ch)) {
                int j = i;
                while (j < sanitized.length() && (Character.isDigit(sanitized.charAt(j)) || sanitized.charAt(j) == '.')) {
                    j++;
                }
                tokens.add(sanitized.substring(i, j));
                i = j;
            }

            // Handle operator
            else if ("+-*/%^".indexOf(ch) != -1) {
                tokens.add(String.valueOf(ch));
                i++;
            }

            // Handle parentheses
            else if (ch == '(' || ch == ')') {
                tokens.add(String.valueOf(ch));
                i++;
            }

            // Handle function names
            else if (Character.isLetter(ch)) {
                int j = i;
                while (j < sanitized.length() && Character.isLetter(sanitized.charAt(j))) {
                    j++;
                }
                final String func = sanitized.substring(i, j);
                tokens.add(func);
                i = j;
            }

            // Unknown character
            else {
                throw new IllegalArgumentException("Invalid character in expression: " + ch);
            }
        }
        return tokens;
    }

    /**
     * Checks if a string is a valid operator.
     *
     * @param operation The operation to check.
     * @return true if valid, false otherwise.
     */
    public boolean isOperator(final String operation) {
        return OPERATION_MAP.containsKey(operation);
    }

    /**
     * Checks if a string is a valid number.
     *
     * @param value The value to check.
     * @return true if numeric, false otherwise.
     */
    public boolean isNumeric(final String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
