import logic.ExpressionProcessor;
import model.OperationRegistry;
import model.RecursiveExpressionEvaluator;
import utils.ExpressionValidatorUtils;
import utils.HistoryManager;
import utils.TokenUtils;
import utils.VariableResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static utils.Constants.EXIT;
import static utils.Constants.HISTORY;

/**
 * Calculator class to evaluate simple mathematical expressions.
 * It reads input from the user, processes it, and outputs the result.
 */
public class Calculator {

    private final Scanner scanner;
    private final HistoryManager historyManager;
    private final ExpressionProcessor processor;

    /**
     * Saves the history of calculations.
     */
    private String history = "History: \n";

    /**
     * Saves variables and their values for later use.
     */
    private final Map<String, Double> variableMap = new HashMap<>();


    /**
     * Constructor to initialize the calculator with necessary utilities.
     */
    public Calculator() {
        this.scanner = new Scanner(System.in);

        final Map<String, Double> variableMap = new HashMap<>();
        final TokenUtils tokenUtils = new TokenUtils();
        final ExpressionValidatorUtils validator = new ExpressionValidatorUtils(tokenUtils);
        final OperationRegistry operationRegistry = new OperationRegistry();
        final RecursiveExpressionEvaluator evaluator = new RecursiveExpressionEvaluator(operationRegistry, tokenUtils);
        final VariableResolver resolver = new VariableResolver(variableMap);
        this.historyManager = new HistoryManager();
        this.processor = new ExpressionProcessor(tokenUtils, validator, evaluator, resolver, variableMap);
    }

    /**
     * Runs the calculator loop, processing input until the user exits.
     */
    public void run() {
        welcomeMessage();

        while (true) {
            final String equationInput = scanner.nextLine();
            if (EXIT.equalsIgnoreCase(equationInput)) {
                System.out.println("Exiting the calculator.");
                break;
            }

            if (HISTORY.equalsIgnoreCase(equationInput)) {
                historyManager.print();
                continue;
            }

            try {
                if (processor.tryAssignVariable(equationInput)) {
                    historyManager.addRaw(equationInput + "\n");
                } else {
                    final Double result = processor.evaluateExpression(equationInput);
                    historyManager.add(equationInput, result);
                    System.out.println("Result: " + result);
                }
            } catch (final IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (final Exception e) {
                System.out.println("ERROR: An unexpected error occurred.");
            }
        }
        scanner.close();
    }

    /**
     * Displays a welcome message and usage instructions to the user.
     */
    private static void welcomeMessage() {
        System.out.println("Welcome to the Java Calculator!");
        System.out.println("Type an expression (e.g., 2 + 3 * 4) or assignment (e.g., x = 5)");
        System.out.println("Type 'history' to view calculation history.");
        System.out.println("Type 'exit' to quit.\n");
    }


    /**
     * Main method to start the calculator application.
     * @param args Command line arguments (not used).
     */
    public static void main(final String[] args) {
        new Calculator().run();
    }
}
