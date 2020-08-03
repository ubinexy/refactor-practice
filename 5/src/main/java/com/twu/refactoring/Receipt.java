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

        int totalKms = taxi.getTotalKms();

        if(taxi.isAirConditioned()) {
            totalCost += getPreDistance() * PRE_RATE_CHANGE_AC_RATE;
            totalCost += getPostDistance() * POST_RATE_CHANGE_AC_RATE;
        } else {
            totalCost += getPreDistance() * PRE_RATE_CHANGE_NON_AC_RATE;
            totalCost += getPostDistance() * POST_RATE_CHANGE_NON_AC_RATE;
        }

        totalCost *= taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;

        return totalCost * (1 + SALES_TAX_RATE) + FIXED_CHARGE;
    }

    private double getPreDistance(int kms) {
        return Math.min(RATE_CHANGE_DISTANCE, kms);
    }

    private double getPostDistance(int kms) {
        return Math.max(0, kms - RATE_CHANGE_DISTANCE)
    }
}
