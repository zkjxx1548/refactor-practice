package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentalList = new ArrayList<Rental>();

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
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		double totalAmount = getTotalAmount(rentalList);


		result += rentalList.stream()
				.map(rental -> {
					Movietype movietype = rental.getMovie().returnTypeMovie(rental.getMovie().getPriceCode());
					movietype.setMovieTitle(rental.getMovie().getTitle());
					movietype.setDaysRented(rental.getDaysRented());
					return movietype;
				})
				.map(movietype1 -> "\t" + movietype1.getMovieTitle() + "\t"
						+ movietype1.getAmount(movietype1.getDaysRented()) + "\n")
				.reduce(String::concat)
				.orElse("");

		frequentRenterPoints += rentalList.size();
		frequentRenterPoints += rentalList.stream()
				.filter(rental -> {
					Movietype movietype = rental.getMovie().returnTypeMovie(rental.getMovie().getPriceCode());
					return movietype instanceof NewReleaseMovie && rental.getDaysRented() > 1;
				})
				.count();

		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	public double getTotalAmount(List<Rental> rentalList) {
		return rentalList.stream()
				.map(rental -> {
					Movietype movietype = rental.getMovie().returnTypeMovie(rental.getMovie().getPriceCode());
					movietype.setMovieTitle(rental.getMovie().getTitle());
					return movietype.getAmount(rental.getDaysRented());
				})
				.reduce(Double::sum).orElse(0d);
	}

}
