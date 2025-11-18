package edu.cmsc495;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CurrencyConverterTest {

    @Test
    void rejectsNonNumeric() {
        String msg = ConverterController.validateCurrency("USD", "EUR", "abc");
        assertEquals("Error: Please enter a valid number.", msg);
    }

    @Test
    void rejectsEmptyOrSpaces() {
        String msg = ConverterController.validateCurrency("USD", "BGN", "   ");
        assertEquals("Error: Please enter a valid number.", msg);
    }

    @Test
    void rejectsZero() {
        String msg = ConverterController.validateCurrency("USD", "BRL", "0");
        assertEquals("Error: Please enter a valid positive number of at least 0.01.", msg);
    }

    @Test
    void rejectsNegative() {
        String msg = ConverterController.validateCurrency("USD", "AUD", "-10");
        assertEquals("Error: Please enter a valid positive number of at least 0.01.", msg);
    }

    @Test
    void rejectsHugeAmount() {
        String msg = ConverterController.validateCurrency("USD", "CNY", "100000000000001");
        assertEquals("Error: Amount exceeds maximum limit of 100 trillion.", msg);
    }

    @Test
    void sourceEqualsTarget() {
        String msg = ConverterController.validateCurrency("USD", "USD", "25.5678");
        assertEquals("Result: 25.57 USD = 25.57 USD", msg);
    }

    @Test
    void validAmount() {
        String msg = ConverterController.validateCurrency("USD", "CZK", "10.00");
        assertNotNull(msg);
        assertTrue(msg.startsWith("Result:"), "Expected success result but got: " + msg);
    }

    // Stress test does not hit the network or API.
    @Test
    void stressTestSameCurrencyNoNetwork() {
        for (int i = 1; i < 10_000; i++) {
            // varying the amount to make sure rounding keeps working
            double amount = 1.1 + (i % 10000) / 1000;
            String msg = ConverterController.validateCurrency("USD", "USD", String.valueOf(amount));
            assertNotNull(msg);
            assertTrue(msg.startsWith("Result:"),
                    "Iteration " + i + " failed with message: " + msg);
        }
    }
}