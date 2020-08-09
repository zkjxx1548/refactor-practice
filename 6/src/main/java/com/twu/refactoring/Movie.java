package com.twu.refactoring;

public class Movie {
	public static final int  CHILDRENS = 2;
	public static final int  REGULAR = 0;
	public static final int  NEW_RELEASE = 1;

	private final String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}

	public Movietype returnTypeMovie(int priceCode) {
		if (priceCode == 0) {
			return new RegularMovie();
		} else if (priceCode == 1) {
			return new NewReleaseMovie();
		}
		return new ChildrensMovie();
	}
}

