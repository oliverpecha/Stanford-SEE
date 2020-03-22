/*
 * File: FeetAndInchesToCentimeters.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This program converts feet and inches to centimeters.
 */

import acm.program.*;

public class FeetAndInchesToCentimeters extends ConsoleProgram {

	public void run() {
		println("This program converts feer and inches to centimeters.");
		double feet = readDouble("Enter value in feet: ");
		double inches = readDouble("Enter value in inches: ");
		double feetInCm = feet * CENTIMETERS_PER_FEET;
		double inchesInCM = inches * CENTIMETERS_PER_INCH;
		double cm = inchesInCM + feetInCm;
		println(feet + "ft and " + inches + "in = " + cm + "cm");
	}

/* Private constants */
	private static final double CENTIMETERS_PER_FEET = 30.48;
	private static final double CENTIMETERS_PER_INCH = 2.54;
}
