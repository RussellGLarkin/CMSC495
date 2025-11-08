package edu.cmsc495;

/*
 * CMSC 495 7383 Capstone Project - Currency Converter
 * ConverterController.java
 * Russell Larkin  |  Alan Espinosa  |  Jeffrey Meja  |  Mark Trent
 * 
 * Controller for the currency converter application.
 */

public class ConverterController {
    // Set a maximum limit for conversion amount
    // If max or min values are changed, update the corresponding error messages below
    private static final double MAX_AMOUNT = 100_000_000_000_000.0;
    private static final double MIN_AMOUNT = 0.01;

    public static String validateCurrency(String source, String target, String amountStr) {

        final double amount;

        // Trim whitespace and parse amount
        try {
            amount = Math.round(Double.parseDouble(amountStr.trim()) * 1000.0) / 1000.0;
        } catch (NumberFormatException ex) {
            return "Error: Please enter a valid number.";
        }

        // Check amount > MIN_AMOUNT
        if (amount < MIN_AMOUNT) {
            return "Error: Please enter a valid positive number of at least 0.01."; // Update to reflect minimum amount
        }

        // Check amount < MAX_AMOUNT
        if (amount > MAX_AMOUNT) {
            return "Error: Amount exceeds maximum limit of 100 trillion."; // Update to reflect maximum amount
        }

        // If source and target are the same, no conversion needed
        if (source.equals(target)) {
            return String.format("Result: %.2f %s = %.2f %s", amount, source, amount, target);
        }

        // Perform conversion
        double result = CurrencyConverter.convert(source, target, amount);

        // Negative return values indicate specific error conditions
        // Default case handles successful conversion
        switch ((int) result) {
            case -1:
                return "Error: Conversion request was interrupted.";
            case -2:
                return "Error: No internet connection. Please check your network.";
            case -3:
                return "Error: Unexpected response from the currency service.";
            case -4:
                return "Error: Currency API service is unavailable right now.";
            default:
                return String.format("Result: %.2f %s = %.2f %s", amount, source, result, target);
        }
    }
}