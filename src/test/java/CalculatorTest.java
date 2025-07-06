import model.OperationRegistry;
import model.RecursiveExpressionEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ExpressionValidatorUtils;
import utils.TokenUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the Calculator class.
 */
public class CalculatorTest {

    private Calculator calculator;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        // Mock dependencies
        final TokenUtils tokenUtils = new TokenUtils();
        final ExpressionValidatorUtils validator = new ExpressionValidatorUtils(tokenUtils);
        final OperationRegistry operationRegistry = new OperationRegistry();
        final RecursiveExpressionEvaluator evaluator = new RecursiveExpressionEvaluator(operationRegistry, tokenUtils);
        
        // Redirect System.in and System.out for testing
        final String input = "2 + 3\nexit\n";
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        final Scanner scanner = new Scanner(inputStream);
        
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        calculator = new Calculator();
    }

    @Test
    public void testRun_BasicAddition() {
        calculator.run();
        final String output = outputStream.toString();
        assertTrue(output.contains("Result: 5.0"), "Calculator should correctly evaluate 2 + 3 as 5.0");
        assertTrue(output.contains("Exiting the calculator."), "Calculator should exit on 'exit' command");
    }
}
