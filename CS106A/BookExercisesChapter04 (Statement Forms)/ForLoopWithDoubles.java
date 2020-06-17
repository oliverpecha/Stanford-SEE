/*
 * File: ForLoopWithDoubles.java
 * -----------------------------
 * This program demonstrates the problems in using for with doubles.
 */

import acm.program.*;

public class ForLoopWithDoubles extends ConsoleProgram {

	public void run() {
		for (double x = 1.0; x <= 2.0; x += 0.1) {
			println(x);
		}
	}

}
