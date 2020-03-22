/*
 * File: KilogramsToPoundsAndOunces.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This program calculates the average of four integers.
 */

import acm.program.*;

public class AverageOfFourIntegers extends ConsoleProgram {

	public void run () {
		int firstInt = readInt("Enter first Integer: ");
		int secondInt = readInt("Enter second Integer: ");
		int thirdInt = readInt("Enter third Integer: ");
		int fourthInt = readInt("Enter fourth Integer: ");
		double averageInt = (firstInt + secondInt + thirdInt + fourthInt) / 4.0;
		println("Average of the four integers is: " + averageInt);
	}
}
