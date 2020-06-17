/*
 * File: Add3Integers.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 3 on chapter 2 of Programming Exercises from the Art of Java.
 */
	import acm.program.*;
	
	public class Add3Integers extends ConsoleProgram {
		
	   public void run() {
	      println("This program adds two integers.");
	      int n1 = readInt("Enter first number: ");
	      int n2 = readInt("Enter second number: ");
	      int n3 = readInt("Enter third number: ");
	      int total = n1 + n2 + n3;
	      println("The total is " + total + ".");
	} 
	
}
