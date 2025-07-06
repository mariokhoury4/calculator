package model;

/**
 * This interface defines a mathematical operation that takes two Double arguments
 * and returns a Double result.
 */
public interface Operation {
    /**
     * Evaluates the operation with the given two Double arguments.
     *
     * @param a The first argument of the operation.
     * @param b The second argument of the operation.
     * @return The result of the operation as a Double.
     */
    Double eval(final Double a, final Double b);
}
