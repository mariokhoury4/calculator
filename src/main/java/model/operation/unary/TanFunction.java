package model.operation.unary;

/**
 * This class implements the Function interface to perform the tangent operation.
 */
public class TanFunction implements Function {
    /**
     * Applies the tangent function to the given Double number.
     * @param number The number to which the tangent function is applied.
     * @return The tangent of the number as a Double.
     */
    @Override
    public Double apply(final Double number) {
        return Math.tan(Math.toRadians(number)); // Convert degrees to radians
    }
}
