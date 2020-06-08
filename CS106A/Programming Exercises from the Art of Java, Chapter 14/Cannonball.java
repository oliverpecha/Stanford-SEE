/*
 * File: Cannonball.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 14 / Programming Exercise 2
 * -----------------
 */

import acm.program.*;

public class Cannonball extends ConsoleProgram {

	public void run() {
		int n = 4;
		int balls = cannonBalls(n);
		System.out.println(balls);
	}

	private int cannonBalls(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return n * n + cannonBalls(n - 1);
		}
	}
}
