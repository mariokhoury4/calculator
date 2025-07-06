package model;

/**
 * This class implements the Operation interface to perform division.
 */
public class DivisionOperation implements Operation {

    /**
     * Evaluates the division of two Double values.
     * @param a The first argument of the operation.
     * @param b The second argument of the operation.
     * @return The result of dividing a by b as a Double.
     * @throws IllegalArgumentException if b is zero, as division by zero is not allowed.
     */
    public Double eval(final Double a, final Double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
