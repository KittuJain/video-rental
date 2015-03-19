package com.twu.refactor;

import java.util.List;

public class Statement {
    public static String getFooterLines(double totalAmount, int frequentRenterPoints) {
        String statement;
        statement = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return statement;
    }

    public static String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    public static String getStatement(Customer customer, List<Rental> rentalList) {
        String statement = getHeader(customer);
        for (Rental rental : rentalList){
            statement += customer.getRentalSubTotal(rental);
        }
        statement += getFooterLines(customer.getTotalAmount(), customer.getTotalFrequentRentalPoints());
        return statement;
    }

    public static String getHTMLHeader(Customer customer) {
        return "<H1>Rentals for<EM>"+ customer.getName() +"</EM></H1><P>";
    }

    public static String getHTMLFooter(double totalAmount, int frequentRenterPoints) {
        String statement;
        statement = "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM>";
        statement += "<P>On this rental you earned<EM>" + String.valueOf(frequentRenterPoints)
                + "</EM>frequent renter points<P>";
        return statement;
    }
}
