package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class to manage the history of calculations.
 */
public class HistoryManager {
    private final StringBuilder history = new StringBuilder("History: \n");

    /**
     * Adds a new entry to the history with a timestamp.
     * @param line the line of calculation to be added
     * @param result the result of the calculation
     */
    public void add(final String line, final Double result) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        history.append("[").append(timestamp).append("] ").append(line).append(" = ").append(result).append("\n");
    }

    /**
     * Adds a raw string to the history with a timestamp.
     * @param raw the raw string to be added to the history
     */
    public void addRaw(final String raw) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        history.append("[").append(timestamp).append("] ").append(raw);
    }

    /**
     * Prints the history of calculations.
     */
    public void print() {
        System.out.println(history);
    }
}
