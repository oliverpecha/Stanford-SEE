/*
 * File: NDigits.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 4
 * -----------------
 * Write a method nDigits(n) that returns the number of digits in the integer n, which you may assume is positive. 
 * Design a main program to test your method. For hints about how to write this program, you might want to look back 
 * at the DigitSum program that was given in Figure 4-6.
 */

import acm.program.*;

public class NDigits extends ConsoleProgram {

	public void run() {
		println("This program sums the digits in an integer.");
		int k = readInt("Enter a positive integer: ");
		println("The sum of the digits is " + nDigits(k));
	}
	
	private int nDigits(int n) {

			int dsum = 0;
			while (n > 0) {
				dsum += n % 10;
				n /= 10;
			}
			return dsum;	
	}
}
