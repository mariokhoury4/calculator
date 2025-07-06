package utils;


import model.operation.basic.ExponentiationOperation;
import model.operation.basic.ModuloOperation;
import model.operation.basic.Operation;
import model.operation.basic.PlusOperation;
import model.operation.basic.MinusOperation;
import model.operation.basic.DivisionOperation;
import model.operation.basic.MultiplicationOperation;
import model.operation.unary.CosFunction;
import model.operation.unary.Function;
import model.operation.unary.SinFunction;
import model.operation.unary.SqrtFunction;

import java.util.Map;

/**
 * Utility class that holds application-wide constant values such as supported operations
 * and special command keywords.
 *
 * <p>This class is not meant to be instantiated.</p>
 */
public class Constants {

    /**
     * A map of supported arithmetic operators to their corresponding {@link Operation} implementations.
     * Keys are operator symbols (e.g., "+", "-", "*", "/", "%", "^").
     */
    public static final Map<String, Operation> OPERATION_MAP = Map.of(
            "+", new PlusOperation(),
            "-", new MinusOperation(),
            "*", new MultiplicationOperation(),
            "/", new DivisionOperation(),
            "%", new ModuloOperation(),
            "^", new ExponentiationOperation()
    );

    /**
     * A map of supported mathematical functions to their corresponding {@link Function} implementations.
     */
    public static final Map<String, Function> FUNCTION_MAP = Map.of(
            "sin", new SinFunction(),
            "cos", new CosFunction(),
            "sqrt", new SqrtFunction()
    );

    /**
     * Command string to exit the calculator application.
     */
    public static final String EXIT = "exit";

    /**
     * Command string to clear the calculator's memory or history.
     */
    public static final String HISTORY = "history";

    // Private constructor to prevent instantiation
    private Constants() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }
}
