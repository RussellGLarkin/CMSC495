package edu.cmsc495;

public class Main {
    public static void main(String[] args) {
        double usdToEur = CurrencyConverter.convert("USD", "EUR", 10.0);
        System.out.println("10 USD in EUR = " + usdToEur);
    }
}
