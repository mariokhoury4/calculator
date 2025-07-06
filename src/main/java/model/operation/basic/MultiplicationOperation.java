package model.operation.basic;

/**
 * This class implements the Operation interface to perform multiplication.
 */
public class MultiplicationOperation implements Operation {

    /**
     * Evaluates the product of two Double values.
     * @param a The first argument of the operation.
     * @param b The second argument of the operation.
     * @return The product of a and b as a Double.
     */
    public Double eval(final Double a, final Double b) {
        return a * b;
    }
}
