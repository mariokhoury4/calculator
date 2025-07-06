package utils;


import model.operation.basic.ExponentiationOperation;
import model.operation.basic.ModuloOperation;
import model.operation.basic.Operation;
import model.operation.basic.PlusOperation;
import model.operation.basic.MinusOperation;
import model.operation.basic.DivisionOperation;
import model.operation.basic.MultiplicationOperation;
import model.operation.unary.AbsFunction;
import model.operation.unary.CeilFunction;
import model.operation.unary.CosFunction;
import model.operation.unary.ExpFunction;
import model.operation.unary.FloorFunction;
import model.operation.unary.Function;
import model.operation.unary.LnFunction;
import model.operation.unary.LogFunction;
import model.operation.unary.RoundFunction;
import model.operation.unary.SinFunction;
import model.operation.unary.SqrtFunction;
import model.operation.unary.TanFunction;

import java.util.Map;

/**
 * Utility class that holds application-wide constant values such as supported operations
 * and special command keywords.
 *
 * <p>This class is not meant to be instantiated.</p>
 */
public class Constants {

    /**
     * Operator symbols for mathematical expressions.
     */
    public static final String OPEN_PARENTHESIS = "(";
    public static final String CLOSE_PARENTHESIS = ")";
    public static final String ADDITION_SIGN = "+";
    public static final String MINUS_SIGN = "-";
    public static final String MULTIPLICATION_SIGN = "*";
    public static final String DIVISION_SIGN = "/";
    public static final String MODULO_SIGN = "%";
    public static final String EXPONENTIATION_SIGN = "^";
    public static final String PI_CONSTANT = "pi";
    public static final String E_CONSTANT = "e";
    public static final String EQUAL_SIGN = "=";

    public static final String VARIABLE_REGEX = "[a-zA-Z][a-zA-Z0-9]*";

    /**
     * A map of supported arithmetic operators to their corresponding {@link Operation} implementations.
     * Keys are operator symbols (e.g., "+", "-", "*", "/", "%", "^").
     */
    public static final Map<String, Operation> OPERATION_MAP = Map.of(
            ADDITION_SIGN, new PlusOperation(),
            MINUS_SIGN, new MinusOperation(),
            MULTIPLICATION_SIGN, new MultiplicationOperation(),
            DIVISION_SIGN, new DivisionOperation(),
            MODULO_SIGN, new ModuloOperation(),
            EXPONENTIATION_SIGN, new ExponentiationOperation()
    );

    /**
     * A map of supported mathematical functions to their corresponding {@link Function} implementations.
     */
    public static final Map<String, Function> FUNCTION_MAP = Map.ofEntries(
            Map.entry("sin", new SinFunction()),
            Map.entry("cos", new CosFunction()),
            Map.entry("sqrt", new SqrtFunction()),
            Map.entry("tan", new TanFunction()),
            Map.entry("log", new LogFunction()),
            Map.entry("abs", new AbsFunction()),
            Map.entry("exp", new ExpFunction()),
            Map.entry("ln", new LnFunction()),
            Map.entry("ceil", new CeilFunction()),
            Map.entry("floor", new FloorFunction()),
            Map.entry("round", new RoundFunction())
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
