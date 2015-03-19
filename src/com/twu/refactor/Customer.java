package com.twu.refactor;

import java.util.ArrayList;
import java.util.List;

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

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentalList){
            totalAmount += rental.getAmountFor();
        }
        return totalAmount;
    }

    public int getTotalFrequentRentalPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentalList)
            frequentRenterPoints += rental.getFrequentRentalPoints();
        return frequentRenterPoints;
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

    public String getRentalSubTotal(Rental rental) {
        String statement;
        statement = "\t" + rental.movie.getTitle() + "\t"
                + String.valueOf(rental.getAmountFor()) + "\n";
        return statement;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }
}
