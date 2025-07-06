package model;

import model.operation.basic.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static utils.Constants.OPERATION_MAP;


/**
 * The {@code OperationRegistry} class is responsible for evaluating mathematical expressions
 * using defined {@link Operation} implementations.
 *
 * <p>It respects operator precedence:
 * <ul>
 *     <li>First evaluates all multiplication (*) and division (/)</li>
 *     <li>Then evaluates addition (+) and subtraction (-)</li>
 * </ul>
 * </p>
 *
 * <p>Each supported operation is retrieved from a pre-defined map of operations.</p>
 */
public class OperationRegistry {

    /**
     * Evaluates a mathematical expression in two passes to handle operator precedence:
     * first evaluating "*", "/" then "+", "-".
     *
     * @param equationList A list of strings representing numbers and operators in sequence.
     * @return The result of the expression as a {@code Double}.
     * @throws IllegalArgumentException if the expression format is invalid.
     */
    public Double evaluateExpression(final List<String> equationList) {
        final List<String> afterExponential = evaluateExpressionBasedOnSign(equationList, Set.of("^"));
        final List<String> afterModMulDiv = evaluateExpressionBasedOnSign(afterExponential, Set.of("*", "/", "%"));
        return Double.valueOf(evaluateExpressionBasedOnSign(afterModMulDiv, Set.of("+", "-")).get(0));
    }

    /**
     * Retrieves the corresponding {@link Operation} implementation for a given operator symbol.
     *
     * @param operation The operator symbol as a string (e.g., "+", "-", "*", "/").
     * @return The associated {@code Operation} instance.
     * @throws IllegalArgumentException if the operation is not supported.
     */
    private Operation getOperationType(final String operation) {
        if (OPERATION_MAP.containsKey(operation)) {
            return OPERATION_MAP.get(operation);
        }
        throw new IllegalArgumentException("Invalid operation: " + operation + ". Supported operations are: " + OPERATION_MAP.keySet() + ".");
    }


    /**
     * Evaluates the expression by applying operations in the given set (e.g., {"*", "/"}).
     * Operators outside the set are deferred for later evaluation.
     *
     * @param equation The current expression as a list of strings (numbers and operators).
     * @param operationSet The set of operations to evaluate at this stage.
     * @return A new list with evaluated results and remaining operations.
     * @throws IllegalArgumentException if the expression is malformed.
     */
    private List<String> evaluateExpressionBasedOnSign(final List<String> equation, Set<String> operationSet) {
        Double currentValue = Double.valueOf(equation.get(0));
        List<String> newEquation = new ArrayList<>();

        for (int i = 1; i < equation.size(); i += 2) {
            final String currentOperator = equation.get(i);
            if (i + 1 >= equation.size()) {
                throw new IllegalArgumentException("Missing operand after operator: " + currentOperator);
            }

            if (operationSet.contains(currentOperator)) {
                currentValue = getOperationType(currentOperator).eval(currentValue, Double.valueOf(equation.get(i + 1)));
            } else {
                newEquation.add(currentValue.toString());
                newEquation.add(currentOperator);
                currentValue = Double.valueOf(equation.get(i + 1));
            }
        }
        newEquation.add(currentValue.toString());
        return newEquation;
    }
}
