package model.operation.unary;

/**
 * This interface defines a mathematical function that takes a single Double argument
 */
public interface Function {
    /**
     * Applies the function to the given Double number.
     * @param number The number to which the function is applied.
     * @return The result of the function as a Double.
     */
    Double apply(final Double number);
}
