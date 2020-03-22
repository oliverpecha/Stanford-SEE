
/*
 * File: KilogramsToPoundsAndOunces.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This Program Converts Kilograms To Pounds And Ounces.
 */

import acm.program.*;

public class KilogramsToPoundsAndOunces extends ConsoleProgram {

	public void run() {
		println("This Program Converts Kilograms To Pounds And Ounces");
		double kilos = readDouble("Enter Kilograms: ");
		double pounds = kilos * POUNDS;
		int singlePound = (int) pounds;
		double poundCalculation = pounds - singlePound;
		double ounces = poundCalculation * OUNCES;
		double ouncesCalculation = Math.round(ounces * 100);
		double roundedOunces = ouncesCalculation/100;
		println("Result is = " + singlePound + " Pounds and " + roundedOunces + " Ounces");	
	}

	private static final double POUNDS = 2.2046226218;
	private static final double OUNCES = 16;
}
