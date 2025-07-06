package model;

/**
 * This class implements the Operation interface to perform subtraction.
 */
public class MinusOperation implements Operation {

    /**
     * Evaluates the difference of two Double values.
     * @param a The first argument of the operation.
     * @param b The second argument of the operation.
     * @return The difference of a and b as a Double.
     */
    public Double eval(final Double a, final Double b) {
        return a - b;
    }
}
