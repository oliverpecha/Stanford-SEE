/*
 * File: RoundoffExample.java
 * --------------------------
 * Program to illustrate roundoff errors with floating-point numbers.
 */

import acm.program.*;

public class RoundoffExample extends ConsoleProgram {

	public void run() {
		double sum = 1.0 / 2.0 + 1.0 / 3.0 + 1.0 / 6.0;
		println("1.0 / 2.0 + 1.0 / 3.0 + 1.0 / 6.0 = " + sum);
	}

}
