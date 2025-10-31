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
        String msg = ConverterController.validateCurrency("USD", "EUR", "   ");
        assertEquals("Error: Please enter a valid number.", msg);
    }

    @Test
    void rejectsZero() {
        String msg = ConverterController.validateCurrency("USD", "EUR", "0");
        assertEquals("Error: Please enter a valid positive number.", msg);
    }

    @Test
    void rejectsNegative() {
        String msg = ConverterController.validateCurrency("USD", "EUR", "-10");
        assertEquals("Error: Please enter a valid positive number.", msg);
    }

    @Test
    void rejectsHugeAmount() {
        String msg = ConverterController.validateCurrency("USD", "EUR", "100000000000001");
        assertEquals("Error: Amount exceeds maximum limit of 100 trillion.", msg);
    }

    @Test
    void sourceEqualsTarget() {
        String msg = ConverterController.validateCurrency("USD", "USD", "25.5678");
        assertEquals("Result: 25.57 USD = 25.57 USD", msg);
    }

    @Test
    void validAmount() {
        String msg = ConverterController.validateCurrency("USD", "EUR", "10.00");
        assertNotNull(msg);
        assertTrue(msg.startsWith("Result:"), "Expected success result but got: " + msg);
    }
}