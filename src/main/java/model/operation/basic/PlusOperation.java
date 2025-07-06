package model.operation.basic;

/**
 * This class implements the Operation interface to perform addition.
 */
public class PlusOperation implements Operation {

    /**
     * Evaluates the sum of two Double values.
     * @param a The first Double value.
     * @param b The second Double value.
     * @return The sum of a and b as a Double.
     */
    public Double eval(final Double a, final Double b) {
        return a + b;
    }
}
