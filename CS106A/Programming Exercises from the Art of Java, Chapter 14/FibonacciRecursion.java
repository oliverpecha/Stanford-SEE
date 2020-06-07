/*
 * File: FibonacciRecursion.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 14 / Programming Exercise 1
 * -----------------
 */

import acm.program.*;

public class FibonacciRecursion extends ConsoleProgram {

	public void run() {
		int n = 6;
		int fibonacci = finonacci(n);
		System.out.println(fibonacci);
	}
	
	private int finonacci(int n) {
		if (n >= 0 && n < 3) {
			return 1;
		}
		else {
			return finonacci(n - 2) + finonacci(n -1);
		}
	}
}
