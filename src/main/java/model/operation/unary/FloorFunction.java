package model.operation.unary;

/**
 * This class implements the floor function, which returns the largest integer less than or equal to a given Double value.
 */
public class FloorFunction implements Function {
    /**
     * Evaluates the floor of the given Double value.
     *
     * @param a The Double value to evaluate.
     * @return The floor of the value as a Double.
     */
    @Override
    public Double apply(final Double a) {
        return Math.floor(a);
    }
}
