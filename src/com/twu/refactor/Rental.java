package com.twu.refactor;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getFrequentRentalPoints() {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if (isNewRelease() && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private boolean isNewRelease() {
        return (getMovie().getPriceCode() == Movie.NEW_RELEASE);
    }

    public double getAmountFor() {
        double rentalAmount = 0.0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (daysRented > 2)
                    rentalAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case Movie.CHILDREN:
                rentalAmount += 1.5;
                if (daysRented > 3)
                    rentalAmount += (daysRented - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }
}