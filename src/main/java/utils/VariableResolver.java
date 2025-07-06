package utils;

import java.util.List;
import java.util.Map;

/**
 * Utility class to resolve variables in an expression.
 */
public class VariableResolver {
    private final Map<String, Double> variableMap;

    /**
     * Constructor to initialize the VariableResolver with a map of variables.
     * @param variableMap A map where keys are variable names and values are their corresponding numeric values.
     */
    public VariableResolver(Map<String, Double> variableMap) {
        this.variableMap = variableMap;
    }

    /**
     * Replaces variables in the provided list of tokens with their corresponding values from the variable map.
     * @param tokens A list of tokens representing an expression, where some tokens may be variable names.
     */
    public void replaceVariables(final List<String> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            final String token = tokens.get(i);
            if (variableMap.containsKey(token)) {
                tokens.set(i, String.valueOf(variableMap.get(token)));
            }
        }
    }
}
