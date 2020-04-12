/*
 * File: HexToDecimalConverter.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 7 / Programming Exercise 1
 * -----------------
 * Use the static methods Integer.parseInt and Integer.toString to write a program that converts hexadecimal values 
 * into their decimal equivalents. Your program should continue to read hexadecimal values until the user enters a 0. 
 * A sample run of this program might look like this:
 */

import acm.program.*;

public class HexToDecimalConverter extends ConsoleProgram {

	public void run() {
		String values = null;
		println("This program converts hexadecimal to decimal.\nEnter " + SENTINEL + " to stop.");
		while (true) {
			values = readLine("Enter a hexadecimal number: ");
			if (values.equals(SENTINEL)) {
				println("Program stoped.");
				break;
			}
			int result  = Integer.parseInt(values, 16); 
			String printable =  Integer.toString(result);
			println(values + " hex = " + printable + " decimal");
		}
	}
	
	private static final String SENTINEL = "0";
}
