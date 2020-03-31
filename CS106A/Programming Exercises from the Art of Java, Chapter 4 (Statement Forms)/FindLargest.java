/*
 * File: FindLargest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * Book / Chapter 4 / Programming Exercise 13
 * -----------------
 * Extend the program from the preceding exercise so that it finds both the largest and the second largest values in the list, 
 * as illustrated in this sample run:
 * -----------------
 * This program finds the two largest integers in a list. 
 * Enter values, one per line, using a 0 to signal the end of the list.
 * 17
 * 42
 * 11
 * 19
 * 35
 * 0
 * The largest value is 42
 * The second largest is 35
 */


import acm.program.*;

public class FindLargest extends ConsoleProgram {

	public void run () {
		
		int data = 0;
		int min = 0;
		int max = 0;
		
		println("This program finds the two largest integers in a list \n\n" + 
				"Enter values, one per line, using a 0 to signal the end of the list.\n");
		
		while (true) {
			
			data = readInt("Enter an integer ");
			if (data == SENTINEL) {
				break;
			}
			
			else if (true) {
				//if integer is less than current max, turn integer into smallest.
				if (data < max) {
					if (data > min) min = data;
					System.out.println("2nd L");
					System.out.println("The largest value is " + max + ",");
					System.out.println("The second largest  is " + min + ",");
				}
				//if integer is greater than current max, turn integer into largest.
				else if (data >= max) {
					if (min == 0) min = data;
					//min = max;
					max = data;
					System.out.println("1st L");
					System.out.println("The largest value is " + max + ",");
					System.out.println("The second largest  is " + min + ",");
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
			println("The second largest  is " + min + ","); 
		}
	}	
	private static final int SENTINEL = 0;
}



