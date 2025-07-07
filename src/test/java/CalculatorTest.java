import logic.ExpressionProcessor;
import model.OperationRegistry;
import model.RecursiveExpressionEvaluator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ExpressionValidatorUtils;
import utils.TokenUtils;
import utils.VariableResolver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
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
        final Map<String, Double> variableMap = new HashMap<>();
        final VariableResolver resolver = new VariableResolver(variableMap);
        final ExpressionProcessor processor = new ExpressionProcessor(tokenUtils, validator, evaluator, resolver, variableMap);
        
        // Redirect System.out for testing
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        calculator = new Calculator();
    }

    @Test
    public void testRun_BasicAddition() {
        final String input = "2 + 3\nexit\n";
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        final Scanner scanner = new Scanner(inputStream);
        // Override the scanner in Calculator for testing
        Field scannerField;
        try {
            scannerField = Calculator.class.getDeclaredField("scanner");
            scannerField.setAccessible(true);
            scannerField.set(calculator, scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }

        calculator.run();
        final String output = outputStream.toString();
        assertTrue(output.contains("Result: 5.0"), "Calculator should correctly evaluate 2 + 3 as 5.0");
        assertTrue(output.contains("Exiting the calculator."), "Calculator should exit on 'exit' command");
    }

    @Test
    public void testRun_VariableAssignment() {
        final String input = "x = 10\nx + 5\nexit\n";
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        final Scanner scanner = new Scanner(inputStream);
        // Override the scanner in Calculator for testing
        Field scannerField;
        try {
            scannerField = Calculator.class.getDeclaredField("scanner");
            scannerField.setAccessible(true);
            scannerField.set(calculator, scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }

        calculator.run();
        final String output = outputStream.toString();
        assertTrue(output.contains("x = 10.0"), "Calculator should assign variable x to 10");
        assertTrue(output.contains("Result: 15.0"), "Calculator should evaluate x + 5 as 15.0 after assignment");
    }

    @Test
    public void testRun_HistoryCommand() {
        final String input = "2 + 3\nhistory\nexit\n";
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        final Scanner scanner = new Scanner(inputStream);
        // Override the scanner in Calculator for testing
        Field scannerField;
        try {
            scannerField = Calculator.class.getDeclaredField("scanner");
            scannerField.setAccessible(true);
            scannerField.set(calculator, scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }

        calculator.run();
        final String output = outputStream.toString();
        assertTrue(output.contains("History:"), "Calculator should display history when 'history' is typed");
        assertTrue(output.contains("2 + 3 = 5.0"), "History should contain the calculation 2 + 3 = 5.0");
    }

    @Test
    public void testRun_InvalidInput() {
        final String input = "2 + \nexit\n";
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        final Scanner scanner = new Scanner(inputStream);
        // Override the scanner in Calculator for testing
        java.lang.reflect.Field scannerField;
        try {
            scannerField = Calculator.class.getDeclaredField("scanner");
            scannerField.setAccessible(true);
            scannerField.set(calculator, scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }

        calculator.run();
        final String output = outputStream.toString();
        assertTrue(output.contains("ERROR:"), "Calculator should display an error for invalid input");
    }

    @Test
    public void testRun_ComplexExpression() {
        final String input = "(2 + 3) * 4\nexit\n";
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        final Scanner scanner = new Scanner(inputStream);
        // Override the scanner in Calculator for testing
        Field scannerField;
        try {
            scannerField = Calculator.class.getDeclaredField("scanner");
            scannerField.setAccessible(true);
            scannerField.set(calculator, scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }

        calculator.run();
        final String output = outputStream.toString();
        assertTrue(output.contains("Result: 20.0"), "Calculator should correctly evaluate (2 + 3) * 4 as 20.0");
    }
}
