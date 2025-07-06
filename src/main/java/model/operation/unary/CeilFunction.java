package model.operation.unary;

/**
 * This class implements the ceiling function, which returns the smallest integer greater than or equal to a given Double value.
 */
public class CeilFunction implements Function {
    /**
     * Evaluates the ceiling of the given Double value.
     *
     * @param number The Double value to evaluate.
     * @return The ceiling of the value as a Double.
     */
    @Override
    public Double apply(final Double number) {
        return Math.ceil(number);
    }
}
