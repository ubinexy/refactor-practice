package com.twu.refactoring;

class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double RentCost(int days) {
        double thisAmount = 1.5;
        if (days > 3)
            thisAmount += (days - 3) * 1.5;
        return thisAmount;
    }
}