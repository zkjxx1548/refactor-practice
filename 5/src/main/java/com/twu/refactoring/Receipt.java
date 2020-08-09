package com.twu.refactoring;

public class Receipt {
    private static final int FIXED_CHARGE = 50;
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;
    private static final double SALES_TAX_RATE = 0.1;

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        double totalCost = 0;

        // taxi charges
        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;
        if(taxi.isAirConditioned()) {
            totalCost += getPreCost(totalKms, PRE_RATE_CHANGE_AC_RATE);
            totalCost += getPostCost(totalKms, POST_RATE_CHANGE_AC_RATE);
        } else {
            totalCost += getPreCost(totalKms, PRE_RATE_CHANGE_NON_AC_RATE);
            totalCost += getPostCost(totalKms, POST_RATE_CHANGE_NON_AC_RATE);
        }
        totalCost *= peakTimeMultiple;

        // fixed charges
        totalCost += FIXED_CHARGE;

        return totalCost * (1 + SALES_TAX_RATE);
    }

    public int getPreCost(int totalKms, int ifACPrice) {
        return Math.min(RATE_CHANGE_DISTANCE, totalKms) * ifACPrice;
    }

    public int getPostCost(int totalKms, int ifACPrice) {
        return Math.max(0, totalKms - RATE_CHANGE_DISTANCE) * ifACPrice;
    }

}
