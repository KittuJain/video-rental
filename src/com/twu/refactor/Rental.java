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
        double rentalAmount = 0.0;
        switch (movie.getPriceCode()) {
            case REGULAR:
                rentalAmount += 2;
                rentalAmount = calculateRentalAmount(rentalAmount,2);
                break;
            case NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case KIDS:
                rentalAmount += 1.5;
                rentalAmount = calculateRentalAmount(rentalAmount,3);
                break;
        }
        return rentalAmount;
    }

    private double calculateRentalAmount(double rentalAmount, double numOfDaysRentedFor) {
        if (daysRented > numOfDaysRentedFor)
            rentalAmount += (daysRented - numOfDaysRentedFor) * 1.5;
        return rentalAmount;
    }

    public String getRentalSubTotal(double rentalAmount) {
        String statement;
        statement = "\t" + movie.getTitle() + "\t"
                + String.valueOf(rentalAmount) + "\n";
        return statement;
    }
}