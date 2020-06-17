/*
 * File: ObjectParameterTest.java
 * ------------------------------
 * This program demonstrates that object values are shared
 * when passed on the stack.
 */

import acm.program.*;

public class ObjectParameterTest extends ConsoleProgram {

	public void run() {
		EmbeddedInteger x = new EmbeddedInteger(17);
		increment(x);
		println("x = " + x);
	}

/* Add one to and display the argument */
	private void increment(EmbeddedInteger n) {
		n.setValue(n.getValue() + 1);
		println("n = " + n);
	}

}
