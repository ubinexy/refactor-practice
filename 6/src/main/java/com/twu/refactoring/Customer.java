package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;

		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + name + "\n";
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			double thisAmount = each.getRentCost();
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		int frequentRenterPoints = getFrequentRenterPoints();
		result += addFooter(totalAmount, frequentRenterPoints, result);
		return result;
	}

	private String addFooter(double totalAmount, int frequentRenterPoints, String result) {
		result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}


	public int getFrequentRenterPoints() {
		Iterator<Rental> rentals = rentalList.iterator();
		int frequentRenterPoints = 0;
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			frequentRenterPoints += each.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}


}
