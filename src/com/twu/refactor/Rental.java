package com.twu.refactor;

public class Rental {

    public Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getFrequentRentalPoints() {
        int frequentRenterPoints = 1;
        if (movie.isNewRelease() && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public double getRentalAmount() {
        return movie.getCostForMovie(daysRented);
    }
}