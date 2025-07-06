import model.OperationRegistry;
import model.RecursiveExpressionEvaluator;
import utils.ExpressionValidatorUtils;
import utils.TokenUtils;

import java.util.List;
import java.util.Scanner;

import static utils.Constants.EXIT;

/**
 * Calculator class to evaluate simple mathematical expressions.
 * It reads input from the user, processes it, and outputs the result.
 */
public class Calculator {

    private final Scanner scanner;
    private final OperationRegistry operationRegistry;
    private final ExpressionValidatorUtils validator;
    private final TokenUtils tokenUtils;
    private final RecursiveExpressionEvaluator recursiveExpressionEvaluator;

    /**
     * Constructs a Calculator instance with utility components.
     */
    public Calculator() {
        this.scanner = new Scanner(System.in);
        this.tokenUtils = new TokenUtils();
        this.validator = new ExpressionValidatorUtils(this.tokenUtils);
        this.operationRegistry = new OperationRegistry();
        this.recursiveExpressionEvaluator = new RecursiveExpressionEvaluator(operationRegistry, tokenUtils);
    }

    /**
     * Runs the calculator loop, processing input until the user exits.
     */
    public void run() {
        welcomeMessage();

        while (true) {
            final String equation = scanner.nextLine();

            if (EXIT.equalsIgnoreCase(equation)) {
                System.out.println("Exiting the calculator.");
                break;
            }
            try {
                final List<String> equationList = tokenUtils.tokenizeEquation(equation);
                validator.validateEquation(equationList);
                final Double result = recursiveExpressionEvaluator.evaluate(equationList);
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        scanner.close();
    }

    /**
     * Displays a welcome message and usage instructions to the user.
     */
    private static void welcomeMessage() {
        System.out.println("Welcome to the Java Calculator!");
        System.out.println("Type an expression with spaces (e.g., 2 + 3 * 4)");
        System.out.println("Type 'exit' to quit.\n");
    }

    /**
     * Main method that starts the calculator.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        new Calculator().run();
    }
}
