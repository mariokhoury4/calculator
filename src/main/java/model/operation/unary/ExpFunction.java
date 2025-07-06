package model.operation.unary;

/**
 * This class implements the exponential function e^x as a unary operation.
 */
public class ExpFunction implements Function
{
    /**
     * Evaluates the exponential function e^x for the given value.
     *
     * @param number The value to compute the exponential of.
     * @return The result of e raised to the power of the value as a Double.
     */
    @Override
    public Double apply(final Double number) {
        return Math.exp(number);
    }
}
