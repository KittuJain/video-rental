package com.twu.refactor;

import java.util.List;

public class HtmlStatement {
    public String getHTMLHeader(Billable billable) {
        return "<H1>Rentals for<EM>"+ billable.getName() +"</EM></H1><P>";
    }

    public String getHTMLFooter(double totalAmount, int frequentRenterPoints) {
        String statement;
        statement = "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM>";
        statement += "<P>On this rental you earned<EM>" + String.valueOf(frequentRenterPoints)
                + "</EM>frequent renter points<P>";
        return statement;
    }

    public String getHtmlStatement(Customer customer, List<Rental> rentalList) {
        String htmlStatement = getHTMLHeader(customer);
        for (Rental rental : rentalList) {
            htmlStatement += customer.getHTMLRentalSubTotal(rental);
        }
        htmlStatement += getHTMLFooter(customer.getTotalAmount(), customer.getTotalFrequentRentalPoints());
        return htmlStatement;
    }
}
