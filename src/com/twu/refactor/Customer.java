package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

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
		Iterator<Rental> rentals = rentalList.iterator();
		String statement = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double rentalAmount = 0;
			Rental rental = rentals.next();
            rentalAmount += getAmountFor(rental);
            frequentRenterPoints += getFrequentRentalPoints(rental);
            statement += getRentalSubTotal(rentalAmount, rental);
            totalAmount += rentalAmount;
		}
        statement += getSummary(totalAmount, frequentRenterPoints);
		return statement;
	}

    private double getAmountFor(Rental rental) {
        double rentalAmount = 0.0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (rental.getDaysRented() > 2)
                    rentalAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    rentalAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }

    private int getFrequentRentalPoints(Rental rental) {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && rental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private String getRentalSubTotal(double rentalAmount, Rental rental) {
        String statement;
        statement = "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(rentalAmount) + "\n";
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
        Iterator<Rental> rentals = rentalList.iterator();
        String htmlStatement = "<H1>Rentals for<EM>"+ getName() +"</EM></H1><P>";
        while (rentals.hasNext()) {
            double rentalAmount = 0;
            Rental rental = rentals.next();
            rentalAmount += getAmountFor(rental);
            frequentRenterPoints += getFrequentRentalPoints(rental);
            htmlStatement += getHTMLRentalSubTotal(rentalAmount, rental);
            totalAmount += rentalAmount;
        }
        htmlStatement += getHTMLSummary(totalAmount, frequentRenterPoints);
        return htmlStatement;
    }
    private String getHTMLRentalSubTotal(double rentalAmount, Rental rental) {
        String statement;
        statement = rental.getMovie().getTitle() + ": "
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
