package logic;

import model.RecursiveExpressionEvaluator;
import utils.ExpressionValidatorUtils;
import utils.TokenUtils;
import utils.VariableResolver;

import java.util.List;
import java.util.Map;

import static utils.Constants.EQUAL_SIGN;
import static utils.Constants.VARIABLE_REGEX;

/**
 * ExpressionProcessor class to handle mathematical expressions,
 */
public class ExpressionProcessor {
    private final TokenUtils tokenUtils;
    private final ExpressionValidatorUtils validator;
    private final RecursiveExpressionEvaluator evaluator;
    private final VariableResolver resolver;
    private final Map<String, Double> variableMap;

    /**
     * Constructor to initialize the ExpressionProcessor with necessary utilities and variable map.
     * @param tokenUtils Utility for tokenizing expressions.
     * @param validator Utility for validating expressions.
     * @param evaluator Evaluator for processing expressions recursively.
     * @param resolver Utility for resolving variables in expressions.
     * @param variableMap A map where keys are variable names and values are their corresponding numeric values.
     */
    public ExpressionProcessor(TokenUtils tokenUtils,
                               ExpressionValidatorUtils validator,
                               RecursiveExpressionEvaluator evaluator,
                               VariableResolver resolver,
                               Map<String, Double> variableMap) {
        this.tokenUtils = tokenUtils;
        this.validator = validator;
        this.evaluator = evaluator;
        this.resolver = resolver;
        this.variableMap = variableMap;
    }

    /**
     * Tries to assign a variable with an expression.
     * @param line The line containing the variable assignment in the format "variable = expression".
     * @return true if the assignment was successful, false if the line does not contain an assignment.
     */
    public boolean tryAssignVariable(final String line) {
        if (!line.contains(EQUAL_SIGN)) {
            return false;
        }

        final String[] parts = line.split(EQUAL_SIGN, 2);
        final String variable = parts[0].trim();
        final String expression = parts[1].trim();

        if (!variable.matches(VARIABLE_REGEX)) {
            System.out.println("ERROR: Invalid variable name.");
            return true;
        }

        final List<String> tokens = tokenUtils.tokenizeEquation(expression);
        resolver.replaceVariables(tokens);
        validator.validateEquation(tokens);
        final Double result = evaluator.evaluate(tokens);
        variableMap.put(variable, result);
        System.out.println(variable + " " + EQUAL_SIGN + " " + result);
        return true;
    }

    /**
     * Evaluates a mathematical expression provided as a string.
     * @param line The mathematical expression to evaluate.
     * @return The result of the evaluation as a Double.
     */
    public Double evaluateExpression(final String line) {
        final List<String> tokens = tokenUtils.tokenizeEquation(line);
        resolver.replaceVariables(tokens);
        validator.validateEquation(tokens);
        return evaluator.evaluate(tokens);
    }
}
