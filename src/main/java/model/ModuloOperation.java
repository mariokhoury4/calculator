package model;

/**
 * This class implements the Operation interface to perform modulo operation.
 */
public class ModuloOperation implements Operation {

    /**
     * Evaluates the modulo of two Double values.
     * @param a The first argument of the operation.
     * @param b The second argument of the operation.
     * @return The result of a modulo b as a Double.
     */
    public Double eval(final Double a, final Double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a % b;
    }
}
