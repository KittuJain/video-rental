package com.twu.refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Billable {

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
        for (Rental rental : rentalList)
            totalAmount += rental.getRentalAmount();
        return totalAmount;
    }

    public int getTotalFrequentRentalPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentalList)
            frequentRenterPoints += rental.getFrequentRentalPoints();
        return frequentRenterPoints;
    }

    public String getHTMLRentalSubTotal(Rental rental) {
        String statement;
        statement = rental.movie.getTitle() + ": "
                + String.valueOf(rental.getRentalAmount()) + "<BR>";
        return statement;
    }

    public String getRentalSubTotal(Rental rental) {
        String statement;
        statement = "\t" + rental.movie.getTitle() + "\t"
                + String.valueOf(rental.getRentalAmount()) + "\n";
        return statement;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }
}
