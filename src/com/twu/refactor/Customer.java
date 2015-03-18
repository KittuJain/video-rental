package com.twu.refactor;

import java.util.ArrayList;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String getStatement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String statement = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentalList){
			double rentalAmount = 0;
            rentalAmount += rental.getAmountFor();
            frequentRenterPoints += rental.getFrequentRentalPoints();
            statement += rental.getRentalSubTotal(rentalAmount);
            totalAmount += rentalAmount;
		}
        statement += getSummary(totalAmount, frequentRenterPoints);
		return statement;
	}

    private String getSummary(double totalAmount, int frequentRenterPoints) {
        String statement;
        statement = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return statement;
    }

    public String getHtmlStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String htmlStatement = "<H1>Rentals for<EM>"+ getName() +"</EM></H1><P>";
        for (Rental rental : rentalList) {
            double rentalAmount = 0;
            rentalAmount += rental.getAmountFor();
            frequentRenterPoints += rental.getFrequentRentalPoints();
            htmlStatement += getHTMLRentalSubTotal(rentalAmount, rental);
            totalAmount += rentalAmount;
        }
        htmlStatement += getHTMLSummary(totalAmount, frequentRenterPoints);
        return htmlStatement;
    }

    private String getHTMLRentalSubTotal(double rentalAmount, Rental rental) {
        String statement;
        statement = rental.movie.getTitle() + ": "
                + String.valueOf(rentalAmount) + "<BR>";
        return statement;
    }

    private String getHTMLSummary(double totalAmount, int frequentRenterPoints) {
        String statement;
        statement = "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM>";
        statement += "<P>On this rental you earned<EM>" + String.valueOf(frequentRenterPoints)
                + "</EM>frequent renter points<P>";
        return statement;
    }
}
