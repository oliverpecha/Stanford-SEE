/*
 * File: SimpleParameterTest.java
 * ------------------------------
 * This program demonstrates that primitive values are copied
 * when passed on the stack.
 */

import acm.program.*;

public class SimpleParameterTest extends ConsoleProgram {

	public void run() {
		int x = 17;
		increment(x);
		println("x = " + x);
	}

/* Add one to and display the argument */
	private void increment(int n) {
		n++;
		println("n = " + n);
	}

}
