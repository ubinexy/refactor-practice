package com.twu.refactoring;

class NewlyReleasedMovie extends Movie {
    public NewlyReleasedMovie(String title) {
        super(title);
    }

    @Override
    public double RentCost(int days) {
        double thisAmount = days * 3;
        return thisAmount;
    }

    @Override
    public int getFrequentRenterPoints(int days) {
        if(days > 1)
            return 2;
        return 1;
    }

}

