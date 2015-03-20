package com.twu.refactor;

import java.util.List;

public interface Billable {
    String getName();

    double getTotalAmount();

    int getTotalFrequentRentalPoints();

    String getRentalSubTotal(Rental rental);


    List<Rental> getRentalList();
}
