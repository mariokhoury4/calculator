package utils;

/**
 * Utility class to manage the history of calculations.
 */
public class HistoryManager {
    private final StringBuilder history = new StringBuilder("History: \n");

    /**
     * Adds a new entry to the history.
     * @param line the line of calculation to be added
     * @param result the result of the calculation
     */
    public void add(final String line, final Double result) {
        history.append(line).append(" = ").append(result).append("\n");
    }

    /**
     * Adds a raw string to the history.
     * @param raw the raw string to be added to the history
     */
    public void addRaw(final String raw) {
        history.append(raw);
    }

    /**
     * Prints the history of calculations.
     */
    public void print() {
        System.out.println(history);
    }
}
