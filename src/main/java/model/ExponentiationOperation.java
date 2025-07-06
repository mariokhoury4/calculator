package model;

/**
 * This class implements the Operation interface to perform exponentiation.
 */
public class ExponentiationOperation implements Operation {

    /**
     * Evaluates the exponentiation of two Double values.
     * @param a The base value.
     * @param b The exponent value.
     * @return The result of a raised to the power of b as a Double.
     */
    public Double eval(final Double a, final Double b) {
        return Math.pow(a, b);
    }
}
