/*
 * File: GoldenRatio.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise Bonus 1
 * -----------------
 * Write a predicate method isPerfectSquare(n) that returns true if the integer n is a perfect square. Remember that the method 
 * Math.sqrt returns a double, which is therefore only an approximation of the actual square root.
 */

import acm.program.ConsoleProgram;

public class GoldenRatio extends ConsoleProgram {

	public void run() {
		println("This is the golden ratio: " + GOLDEN_RATIO);
	}
	
	private static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;
	
}
