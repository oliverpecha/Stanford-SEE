/*
 * File: FindLargest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * Book / Chapter 4 / Programming Exercise 12
 * -----------------
 * Write a ConsoleProgram that reads in a list of integers, one per line, until the user enters a sentinel value of 0 
 * (which you should be able to change easily to some other value). When the sentinel is read, your program should display
 * the largest value in the list, as illustrated in this sample run:
 * -----------------
 * This program finds the largest integer in a list. 
 * Enter values, one per line, using a 0 to signal the end of the list.
 * 17
 * 42
 * 11
 * 19
 * 35
 * 0
 * The largest value is 42
 */


import acm.program.*;

public class FindTwoLargest extends ConsoleProgram {

	public void run () {
		
		int data = 0;
		int min = 0;
		int max = 0;
		
		println("This program finds the largest integer in a list. \n\n" + 
				"Enter values, one per line, using a 0 to signal the end of the list.\n");
		
		while (true) {
			
			data = readInt("Enter an integer ");
			if (data == SENTINEL) {
				break;
			}
			
			else if (true) {
				//if integer is less than current max, turn integer into smallest.
				if (data >= max) {
					
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
			println("The largest value is " + max + ","); 
			
		}
	
	}
	private static final int SENTINEL = 0;
}



