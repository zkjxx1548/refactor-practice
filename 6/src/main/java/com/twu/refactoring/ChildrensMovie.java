package com.twu.refactoring;

public class ChildrensMovie implements Movietype{
    private final static double FIX_CHARGE = 1.5;
    private final static int LIMIT_DAYS = 3;
    private final static double POST_PRICE = 1.5;

    private String movieTitle;
    private int daysRented;
    @Override
    public double getAmount(int daysRented) {
        return daysRented > LIMIT_DAYS ? FIX_CHARGE + (daysRented - LIMIT_DAYS) * POST_PRICE : FIX_CHARGE;
    }

    @Override
    public String getMovieTitle() {
        return movieTitle;
    }

    @Override
    public void setMovieTitle(String title) {
        this.movieTitle = title;
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
