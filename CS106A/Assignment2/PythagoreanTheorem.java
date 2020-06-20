/*
 * File: PythagoreanTheorem.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
	
		int a = 0;
		int b = 0;		
		double c = 0;
		
		println("Enter values to compute Pythagorean theorem.");
		a = readInt("a: ");
		b = readInt("b: ");
		c = Math.sqrt(a * a + b * b);
		println("c =  " + c);
	}
}
