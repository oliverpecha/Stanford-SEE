/*
 * File: FindRange.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Write a ConsoleProgram that reads in a list of integers, one per line, until a sentinel value of 0 
 * (which you should be able to change easily to some other value). When the sentinel is read, 
 * your program should display the smallest and largest values in the list, as illustrated in this sample run:
 * -----------------
 * Your program should handle the following special cases:
 * • If the user enters only one value before the sentinel, the program should report that value 
 * as both the largest and smallest.
 * • If the user enters the sentinel on the very first input line, then no values have been entered, 
 * and your program should display a message to that effect.
 */


import acm.program.*;

public class FindRange extends ConsoleProgram {

	public void run () {
		
		int data = 0;
		int min = 0;
		int max = 0;
		
		println("This program finds the largest and smallest numbers.");
		
		while (true) {
			
			data = readInt("Enter an integer ");
			if (data == SENTINEL) {
				break;
			}
			
			else if (true) {
				//if integer is less than current max, turn integer into smallest.
				if (data < max) {
					if (data < min) min = data;
				}
				//if integer is greater than current max, turn integer into largest.
				else if (data >= max) {
					if (min == 0) min = data;
					max = data;
				}
			}
		}
		if (min == 0 && max == 0) {
			println("No values were entered");
			println(""); 
		}
		else if (true) {
			println(""); 
			println("Smallest integer is " + min + ","); 
			println("Largest integer is " + max + ".");
		}
	
	}
	private static final int SENTINEL = 0;
}
