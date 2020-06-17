/*
 * File: AverageList.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 6 on chapter 4 of Programming Exercises from the Art of Java.
 * Using the AddIntegerList program from Figure 4-5 as a model, write a program called AverageList 
 * that reads in a list of integers representing exam scores and then prints out the average. 
 * Because some unfortunate student might actually get a score of 0, your program should use –1 
 * as the sentinel to mark the end of the input.
 */


import acm.program.*;

public class AverageList extends ConsoleProgram {

	public void run() {
		println("This program reads in a list of integers representing exam scores and then prints out the average.");
		println("Enter values, one per line, using " + SENTINEL);
		println("to signal the end of the list.");
		int count = 0;
		int total = 0;
		while (true) {
			int value = readInt(" ? ");
			if (value == SENTINEL) break;
			count++;
			total += value;
		}
		println("The average of scores is " + total/count + ".");
	}

/* Private constants */
	private static final int SENTINEL = -1;  /* Specifies the end-of-data value */

}
