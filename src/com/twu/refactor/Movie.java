package com.twu.refactor;

public class Movie {

    private String title;
	private MoviePricingCategory priceCode;

	public Movie(String title, MoviePricingCategory priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public MoviePricingCategory getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(MoviePricingCategory newMoviePricingCode) {
    	priceCode = newMoviePricingCode;
	}

	public String getTitle () {
		return title;
	}

    public boolean isNewRelease() {
        return getPriceCode() == MoviePricingCategory.NEW_RELEASE;
    }
}

