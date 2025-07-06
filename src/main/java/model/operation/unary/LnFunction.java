package model.operation.unary;

/**
 * This class implements the natural logarithm function as a unary operation.
 */
public class LnFunction implements Function {
    /**
     * Evaluates the natural logarithm of the given value.
     *
     * @param number The value to compute the natural logarithm of.
     * @return The natural logarithm of the value as a Double.
     */
    @Override
    public Double apply(final Double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Natural logarithm is undefined for non-positive values.");
        }
        return Math.log(number);
    }
}
