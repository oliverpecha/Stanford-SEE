/*
 * File: Countdown.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Rewrite the Countdown program given in Figure 4-8 so that it uses a while loop instead of a for loop.
 */

import acm.program.*;

public class Countdown extends ConsoleProgram {

	public void run() {
		int t = START;
		println(t);
		while (t >= 1) {
		t = t-1;
			println(t);
		}
		println("Liftoff!");
	}

/* Private constants */
	private static final int START = 10;   /* Specifies the value from which to start counting down */

}
