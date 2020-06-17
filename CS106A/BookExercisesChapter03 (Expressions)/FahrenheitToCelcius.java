
/*
 * File: FahrenheitToCelcius.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This program converts Fahrenheit to Celcius.
 */

import acm.program.*;

public class FahrenheitToCelcius extends ConsoleProgram {

	public void run() {
		println("This program converts Fahrenheit to Celcius.");
		int fahrenheitTempature = readInt("Enter Fahrenheit tempature: ");
		int celsiusEquivalent = (fahrenheitTempature -32)* (5 / 9);
		println("Celsius equivalent = " + celsiusEquivalent);	
	}

}
