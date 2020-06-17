/*
 * File: RaiseIntToPowerNegatives.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise Bonus
 * -----------------
 * Write a method raiseRealToPower that takes a floating-point value x and an integer k and returns xk. Implement your method so that 
 * it can correctly calculate the result when k is negative, using the relationship:
 * x(-k) = 1 / x(k)
 */

import acm.program.*;

public class RaiseIntToPowerNegatives extends ConsoleProgram {

	public void run() {
		
		double n = Math.PI;
		
		for (int k = -4; k <= 4; k++) {
			println(n + "(" + k + ") = " + raiseIntToPower(n,-k));
		}
				
	}
	
	
	private double raiseIntToPower(double x, int k) {		
		return 1 / Math.pow(x, k);
		
	}
	
}
