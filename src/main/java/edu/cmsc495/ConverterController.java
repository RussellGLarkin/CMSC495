package edu.cmsc495;

public class ConverterController {
    // Set a maximum limit for conversion amount
    private static final double MAX_AMOUNT = 100_000_000_000_000.0;

    public static String validateCurrency(String source, String target, String amountStr) {
        double amount;
        try {
            // Trim whitespace and parse amount
            amount = Double.parseDouble(amountStr.trim());
            // Round to 2 decimal places (with three decimal places in mind for accuracy)
            amount = Math.round(amount * 1000.0) / 1000.0;

        // If source and target are the same, no conversion needed
        if (source.equals(target)) {
            return String.format("Result: %.2f %s = %.2f %s", amount, source, amount, target);
        }

        // Validate number format
        } catch (NumberFormatException ex) {
            return "Error: Please enter a valid number.";
        }

        // Validate positive amount
        if (amount <= 0) {
            return "Error: Please enter a valid positive number.";
        }

        // Validate maximum amount
        if (amount > MAX_AMOUNT) {
            return "Error: Amount exceeds maximum limit of 100 trillion.";
        }
        
        // Perform conversion
        double result = CurrencyConverter.convert(source, target, amount);
        if (result == -1) {
            return "Result: Conversion error occurred.";
        } else {
            return String.format("Result: %.2f %s = %.2f %s", amount, source, result, target);
        }
    }
}
