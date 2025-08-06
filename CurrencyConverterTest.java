import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CurrencyConverterTest {

    @Test
    public void testMissingArguments() {
        String[] args = {};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        CurrencyConverter.main(args);

        assertTrue(output.toString().contains("Error: Please provide both an amount and a currency type."));
    }

    @Test
    public void testInvalidAmount() {
        String[] args = {"abc", "dollars"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        CurrencyConverter.main(args);

        assertTrue(output.toString().contains("Error: Invalid amount. Please provide a valid numeric value."));
    }

    @Test
    public void testInvalidCurrency() {
        String[] args = {"50", "yen"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        CurrencyConverter.main(args);

        assertTrue(output.toString().contains("Error: Invalid currency type. Please provide one of the following: dollars, pounds, euros."));
    }

    @Test
    public void testCurrencyCaseInsensitivity() {
        String[] args = {"50", "DOLLARS"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        CurrencyConverter.main(args);

        assertTrue(output.toString().contains("50 Dollars = 37.0 Pounds"));
    }

    @Test
    public void testCurrencyConversion() {
        String[] args = {"50", "dollars"};
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        CurrencyConverter.main(args);

        assertTrue(output.toString().contains("50 Dollars = 37.0 Pounds"));
        assertTrue(output.toString().contains("50 Dollars = 44.0 Euros"));
    }
}
