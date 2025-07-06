package model.operation.unary;

/**
 * This class implements the Function interface to perform the cosine operation.
 */
public class CosFunction implements Function
{
    /**
     * Applies the cosine function to the given Double number.
     * @param number The number to which the cosine function is applied.
     * @return The cosine of the number as a Double.
     */
    @Override
    public Double apply(final Double number) {
        return Math.cos(Math.toRadians(number)); // Convert degrees to radians
    }
}
