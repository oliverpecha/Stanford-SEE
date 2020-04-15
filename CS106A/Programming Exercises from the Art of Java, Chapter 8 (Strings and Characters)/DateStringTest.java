/*
 * File: DateString.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 4
 * -----------------
 *  Write a method dateString(day, month, year) that returns a string consisting of the day of the month, a hyphen, the first three letters in the
 *  name of the month, another hyphen, and the last two digits of the year. For example, calling the method
 *  			dateString(22, 11, 1963) 
 *  should return the string "22-Nov-63".		
 */

import acm.program.*;

public class DateStringTest extends ConsoleProgram {

	public void run() {
		while (true) {
			int day = readInt("\nEnter day... ");
			int month = readInt("Enter month... ");
			int year = readInt("Enter year... ");
			DateString questionaire = new DateString(day, month, year);		
			println("Date " + questionaire.toString() + " has been stored.");
		}
		
	}
	
}
