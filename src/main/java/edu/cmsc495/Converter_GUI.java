package edu.cmsc495;

/*
 * CMSC 495 7383 Capstone Project - Currency Converter
 * Converter_GUI.java
 * Russell Larkin  |  Alan Espinosa  |  Jeffrey Meja  |  Mark Trent
 * 
 * GUI for the currency converter application.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Converter_GUI implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static final List<String> supportedCurrencies = new ArrayList<>();
    private JComboBox<String> sourceCurrency;
    private JComboBox<String> targetCurrency;
    private JTextField amountField;
    private JButton convertButton;
    private JLabel resultLabel;
    private JFrame frame;

    static {
        String[] currencies = {
            "AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK", "DKK",
            "EUR", "GBP", "HKD", "HUF", "IDR", "ILS", "INR", "ISK", 
            "JPY", "KRW", "MXN", "MYR", "NOK", "NZD", "PHP", "PLN", 
            "RON", "SEK", "SGD", "THB", "TRY", "USD", "ZAR"
        };
        for (String currency : currencies) {
            supportedCurrencies.add(currency);
        }
    }

    private Converter_GUI() {
        frame = new JFrame("Currency Converter v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 225);
        frame.setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));

        inputPanel.add(new JLabel("Source Currency:"));
        sourceCurrency = new JComboBox<>(supportedCurrencies.toArray(new String[0]));
        inputPanel.add(sourceCurrency);

        inputPanel.add(new JLabel("Target Currency:"));
        targetCurrency = new JComboBox<>(supportedCurrencies.toArray(new String[0]));
        inputPanel.add(targetCurrency);

        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        buttonPanel.add(convertButton);

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultLabel = new JLabel("Enter amount and click Convert");
        resultPanel.add(resultLabel);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = (String) sourceCurrency.getSelectedItem();
        String target = (String) targetCurrency.getSelectedItem();
        String amountText = amountField.getText();
        String message = ConverterController.validateCurrency(source, target, amountText);
        resultLabel.setText(message);
    }

    public static void main(String[] args) {
        new Converter_GUI();
    }
}