package model.operation.unary;

/**
 * This class implements the Function interface to perform the sine operation.
 */
public class SinFunction implements Function {
    /**
     * Applies the sine function to the given Double number.
     * @param number The number to which the sine function is applied.
     * @return The sine of the number as a Double.
     */
    @Override
    public Double apply(final Double number) {
        return Math.sin(Math.toRadians(number)); // Convert degrees to radians
    }
}