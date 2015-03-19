package com.twu.refactor;

import java.util.List;

public interface Billable {
    String getName();

    double getTotalAmount();

    int getTotalFrequentRentalPoints();

    List<Rental> getRentalList();
}
