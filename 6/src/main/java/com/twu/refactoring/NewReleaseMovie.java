package com.twu.refactoring;

public class NewReleaseMovie implements Movietype{
    private final static double POST_PRICE = 3;
    private String movieTitle;
    private int daysRented;
    @Override
    public double getAmount(int daysRented) {
        return daysRented * POST_PRICE;
    }

    @Override
    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public int getDaysRented() {
        return daysRented;
    }

    @Override
    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }
}
