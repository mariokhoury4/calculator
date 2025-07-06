package model.operation.unary;

/**
 * This class implements the Function interface to perform the square root operation.
 */
public class SqrtFunction implements Function {
    /**
     * Applies the square root function to the given Double number.
     * @param number The number to which the square root function is applied.
     * @return The square root of the number as a Double.
     */
    @Override
    public Double apply(final Double number) {
        return Math.sqrt(number);
    }
}
