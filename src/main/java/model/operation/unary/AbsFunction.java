package model.operation.unary;

/**
 * This class implements the absolute value function as a unary operation.
 */
public class AbsFunction implements Function {

    /**
     * Evaluates the absolute value of the given Double argument.
     *
     * @param number The argument for which to compute the absolute value.
     * @return The absolute value of the argument as a Double.
     */
    @Override
    public Double apply(final Double number) {
        return Math.abs(number);
    }
}
