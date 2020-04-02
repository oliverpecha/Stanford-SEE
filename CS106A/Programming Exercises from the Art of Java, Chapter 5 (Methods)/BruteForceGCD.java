/*
 * File: BruteForceGCD.java
 * ------------------------
 * This program uses a brute force approach to compute the
 * greatest common divisor of two integers.
 */

import acm.program.*;

public class BruteForceGCD extends ConsoleProgram {

	public void run() {
		println("This program computes the gcd of x and y.");
		int x = readInt("Enter x: ");
		int y = readInt("Enter y: ");
		println("gcd(" + x + ", " + y + ") = " + gcd(x, y));
	}

/*
 * Returns the greatest common divisor (gcd) of the two integers,
 * x and y.  This implementation of the "brute force" approach of
 * trying every possibility.
 */
	public int gcd(int x, int y) {
		int guess = Math.min(x, y);
		while (x % guess != 0 || y % guess != 0) {
			guess--;
		}
		return guess;
	}

}
