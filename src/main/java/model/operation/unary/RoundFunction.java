package model.operation.unary;

/**
 * This class implements the round function, which rounds a given Double value to the nearest integer.
 */
public class RoundFunction implements Function {
    /**
     * Evaluates the rounding of the given Double value.
     *
     * @param number The Double value to evaluate.
     * @return The rounded value as a Double.
     */
    @Override
    public Double apply(final Double number) {
        return Double.valueOf(Math.round(number));
    }
}
