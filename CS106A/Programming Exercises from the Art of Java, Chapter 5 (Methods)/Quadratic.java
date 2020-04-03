/*
 * File: Quadratic.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 1
 * -----------------
 * In high-school algebra, you learned that the standard quadratic equation
 * ax2 + bx + c = 0
 * has two solutions given by the formula
 * x=–b± √ b2  – 4ac / 2a
 * The first solution is obtained by using + in place of ±; the second is obtained by using – in place of ±.
 * Write a Java program that accepts values for a, b, and c, and then calculates the two solutions. 
 * If the quantity under the square root sign is negative, the equation has no real solutions, and your program should display 
 * a message to that effect. You may assume that the value for a is non zero. Your program should be able to duplicate 
 * the following sample run:
 */

import acm.program.*;

public class Quadratic extends ConsoleProgram {

	double a = 0;
	double b = 0;
	double c = 0;
	double xPos = 0;
	double xNeg = 0;
	
	public void run() {
		println("Enter coefficients for the quadratic equation: ");
		
		a = readInt("a: ");
		b = readInt("b: ");
		c = readInt("c: ");
		
		if (Math.sqrt(b * b - 4 * a * c) > 0) {
			xPos = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
			xNeg = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

			println("The first solution is " + xPos + "\nThe second solution is " + xNeg);
		}
		
		else if (true) {
			println("The equation has no real solutions");
		}

		
	}
}
