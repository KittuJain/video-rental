package com.twu.refactor;

public class Rental {

    public Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getFrequentRentalPoints() {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if (movie.isNewRelease() && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public double getAmountFor() {
        return movie.getPriceCode().getCostFor(daysRented);
    }

    public String getRentalSubTotal(double rentalAmount) {
        String statement;
        statement = "\t" + movie.getTitle() + "\t"
                + String.valueOf(rentalAmount) + "\n";
        return statement;
    }
}