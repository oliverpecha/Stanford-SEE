/*
 * File: Interest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This program calculates earned interest from a entered value.
 */

import acm.program.*;

public class Interest extends ConsoleProgram {

	public void run() {
		println("Interest calculation program.");
		double startingBalance = readDouble("Enter starting balance: ");
		double interestRate = readDouble("Enter interest rate: ");
		double interestedRate = 1 + (interestRate / 100);
		double firstYearBalance = startingBalance * interestedRate;
		double secondYearBalance = firstYearBalance * interestedRate;
		println("Balance after one year = " + firstYearBalance);
		println("Balance after two years = " + secondYearBalance);
	}

}
