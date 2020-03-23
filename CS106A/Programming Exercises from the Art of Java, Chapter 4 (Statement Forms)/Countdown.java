/*
 * File: Countdown.java
 * --------------------
 * This program counts backwards from the value START
 * to zero, as in the countdown preceding a rocket
 * launch.
 */

import acm.program.*;

public class Countdown extends ConsoleProgram {

	public void run() {
		for (int t = START; t >= 0; t--) {
			println(t);
		}
		println("Liftoff!");
	}

/* Private constants */
	private static final int START = 10;   /* Specifies the value from which to start counting down */

}
