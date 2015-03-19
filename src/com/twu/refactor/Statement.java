package com.twu.refactor;

import java.util.List;

public class Statement {
    public String getFooterLines(double totalAmount, int frequentRenterPoints) {
        String statement;
        statement = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return statement;
    }

    public String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    public String getStatement(Customer customer, List<Rental> rentalList) {
        String statement = getHeader(customer);
        for (Rental rental : rentalList){
            statement += customer.getRentalSubTotal(rental);
        }
        statement += getFooterLines(customer.getTotalAmount(), customer.getTotalFrequentRentalPoints());
        return statement;
    }
}