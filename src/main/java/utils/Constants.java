package utils;


import model.ExponentiationOperation;
import model.ModuloOperation;
import model.Operation;
import model.PlusOperation;
import model.MinusOperation;
import model.DivisionOperation;
import model.MultiplicationOperation;

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
     * Command string to exit the calculator application.
     */
    public static final String EXIT = "exit";

    // Private constructor to prevent instantiation
    private Constants() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }
}
