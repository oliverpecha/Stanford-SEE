/*
 * File: AddCommas.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise Bonus 11
 * -----------------
 *  When large numbers are written out on paper, it is traditional—at least in the United States—to use commas to separate the digits into groups 
 *  of three. For example, the number one million is usually written in the following form:
 *  		1,000,000
 *  To make it easier for programmers to display numbers in this fashion, implement a method
 *           private String addCommasToNumericString(String digits)
 *  that takes a string of decimal digits representing a number and returns the string formed by inserting commas at every third position, 
 *  starting on the right. For example, if you were to execute the main program
 *     public void run() {
 *        while (true) {
 *           String digits = readLine("Enter a numeric string: ");
 *           if (digits.length() == 0) break;
 *           println(addCommasToNumericString(digits));
 *		  } 
 *		}
 *  your implementation of the addCommasToNumericString method should be able to produce the following sample run:
 * -----------------
 *  Enter a string of digits: 17 17
 *  Enter a string of digits: 1001 1,001
 *  Enter a string of digits: 12345678 12,345,678
 *  Enter a string of digits: 999999999 999,999,999
 *  Enter a string of digits:
 * -----------------
 */

import acm.program.*;

public class AddCommas extends ConsoleProgram {
	
	public void run() {
		while (true) {
	           String digits = readLine("Enter a numeric string: ");
	           System.out.println("*********************************************");
	           if (digits.length() == 0) break;
	           println(addCommasToNumericString(digits));
		}
	}
	
	private String addCommasToNumericString(String digits) {
		// find out how long digits is
		int digitsLenght = digits.length();
		// Counter might not be used, if used it will be 3 digits to extract initially
		int counter = 3;
		int remainderLenght = digitsLenght;
		String remainder = null;
		String sequence = null;
		StringBuilder numWithCommas = new StringBuilder("");

		// if there is only 3 digits, leave them as they are
		if (digitsLenght < 4) numWithCommas = numWithCommas.append(digits);
		
		// otherwise, loop while there is still at least 4 more numbers
		while (remainderLenght > 3) {
			digitsLenght = digits.length();
			System.out.println("digitsLenght is " + digitsLenght);
			// extract last 3 numbers and prepare the remainder 
			sequence = digits.substring(digitsLenght - counter, digitsLenght);
			remainder = digits.substring(digitsLenght - digitsLenght, digitsLenght - counter);
			remainderLenght = remainder.length();
			System.out.println("NEW sequence is " + sequence + ". remainder is " + remainder);
			// If remainder is 4 or more digits, prepare loop to continue extracting sequences of 3 digits
			if (remainderLenght > 3) {
				digits = remainder;
				digitsLenght -= 3;
				numWithCommas = numWithCommas.insert(0,"," + sequence);
			}
			// when remainder is between 1 and 3 digits, finish up numWithCommas as loop will stop
			else numWithCommas = numWithCommas.insert(0,remainder + "," + sequence);	
		}
		// return numWithCommas
		return numWithCommas.toString();
	}
}
