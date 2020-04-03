/*
 * File: RaiseIntToPower.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 3
 * -----------------
 * Write a method raiseIntToPower that takes two integers, n and k, and returns nk. Use your method to display a table of values 
 * of 2k for all values of k from 0 to 10.
 */

import acm.program.*;

public class RaiseIntToPower extends ConsoleProgram {

	public void run() {
		
		int n = 2;
		
		for (int k = 1; k < 10; k++) {
			println(n + "(" + k + ") = " + raiseIntToPower(n,k));
		}
				
	}
	
	
	private int raiseIntToPower(int n, int k) {
		return (int) Math.pow(n, k);
		
	}
	
}
