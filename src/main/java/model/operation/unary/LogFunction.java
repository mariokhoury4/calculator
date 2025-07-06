package model.operation.unary;

/**
 * This class implements the logarithm function as a unary operation.
 */
public class LogFunction implements Function {
    /**
     * Evaluates the logarithm of the given value.
     *
     * @param number The value to compute the logarithm of.
     * @return The logarithm of the value as a Double.
     */
    @Override
    public Double apply(final Double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Logarithm is undefined for non-positive values.");
        }
        return Math.log10(number);
    }
}
