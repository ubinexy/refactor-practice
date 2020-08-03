package com.twu.refactoring;

public class Movie {

	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public String getTitle () {
		return title;
	}

	public double RentCost(int days) {
		double thisAmount = 2;
		if (days > 2)
			thisAmount += (days - 2) * 1.5;
		return thisAmount;
	}

	public int getFrequentRenterPoints(int days) {
		return 1;
	}
}

