/*
 * File: EuclidGCD.java
 * --------------------
 * This program uses Euclid's algorithm to compute the greatest
 * common divisor of two integers.
 */

import acm.program.*;

public class EuclidGCD extends ConsoleProgram {

	public void run() {
		println("This program computes the gcd of x and y.");
		int x = readInt("Enter x: ");
		int y = readInt("Enter y: ");
		println("gcd(" + x + ", " + y + ") = " + gcd(x, y));
	}

/*
 * Returns the greatest common divisor (gcd) of the two integers,
 * x and y.  This implementation of the gcd method uses Euclid's
 * algorithm.
 */
	private int gcd(int x, int y) {
		int r = x % y;
		while (r != 0) {
			x = y;
			y = r;
			r = x % y;
		}
		return y;
	}

}
