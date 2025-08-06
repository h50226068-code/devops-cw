import java.util.*;
import java.text.DecimalFormat;

public class CurrencyConverter {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Please provide both an amount and a currency type.");
            return;
        }

        double amount = 0;
        try {
            amount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid amount. Please provide a valid numeric value.");
            return;
        }

        String currency = args[1].toLowerCase(); // Convert currency input to lowercase for case insensitivity

        if (!(currency.equals("dollars") || currency.equals("pounds") || currency.equals("euros"))) {
            System.out.println("Error: Invalid currency type. Please provide one of the following: dollars, pounds, euros.");
            return;
        }

        DecimalFormat f = new DecimalFormat("##.##");
        double dollar, pound, euro;

        // For amounts Conversion
        switch (currency) {
            case "dollars":
                // For Dollar Conversion
                pound = amount * 0.74;
                System.out.println(amount + " Dollars = " + f.format(pound) + " Pounds");
                euro = amount * 0.88;
                System.out.println(amount + " Dollars = " + f.format(euro) + " Euros");
                break;
            case "pounds":
                // For Pound Conversion
                dollar = amount * 1.36;
                System.out.println(amount + " Pounds = " + f.format(dollar) + " Dollars");
                euro = amount * 1.19;
                System.out.println(amount + " Pounds = " + f.format(euro) + " Euros");
                break;
            case "euros":
                // For Euro Conversion
                dollar = amount * 1.13;
                System.out.println(amount + " Euros = " + f.format(dollar) + " Dollars");
                pound = amount * 0.84;
                System.out.println(amount + " Euros = " + f.format(pound) + " Pounds");
                break;
        }
        System.out.println("Thank you for using the converter.");
    }
}

