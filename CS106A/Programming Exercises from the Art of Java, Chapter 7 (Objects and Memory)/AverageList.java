/*
 * File: AverageList.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 7 / Programming Exercise 2
 * -----------------
 * The fact that the Integer.parseInt method makes it possible for a program to read user input as a string and then 
 * convert it to an integer makes it possible to write programs that use something other than an integer—such as a 
 * blank line—as a sentinel to signal the end of the input. Rewrite the AverageList program from exercise 4-6 so that 
 * it uses a blank line to mark the end of the input.
 */

import acm.program.*;

public class AverageList extends ConsoleProgram {

	public void run() {
		println("This program reads in a list of integers representing exam scores and then prints out the average." +
				"\nEnter values, one per line, using " + SENTINEL + "to signal the end of the list.");
		int count = 0;
		int total = 0;
		int value = 0;
		while (true) {
			String input = readLine(" ? ");
			if (input.contentEquals(SENTINEL)) {
				break;
				
			}
			value = Integer.parseInt(input);
			count++;
			total += value;
		}
		println("The average of scores is " + total/count + ".");
	}

/* Private constants */
	private static final String SENTINEL = " ";  /* Specifies the end-of-data value */

}
