

/*
 * File: DivisibleIntegers.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 4 and 5 on chapter 4 of Programming Exercises from the Art of Java:
 * Write a program that displays the integers between 1 and 100 that are divisible by either 6 or 7.
 */

import acm.program.ConsoleProgram;

public class DivisibleIntegers extends ConsoleProgram {

		public void run () {	
			println("This program can displays the integers between 1 and " + END_NUMBER + " that are divisible by either 6 or 7, or those numbers that are divisible by 6 or 7 but not both.");
			println("");
			int total = readInt("Write 1 to display the numbers that are divisible by " + BOTH + " 6 or 7. \n\nYou may also write 2 to display the numbers that are divisible by " + EITHER + " 6 or 7.\n\n");
			
			switch (total) {
				case 1:
					for (int i = 1; i <= END_NUMBER; i++) {	
						if (i % 6 == 0 || i % 7 == 0 ) {
							println(i + ".");
						}
					}
					break;
				case 2:
					for (int i = 1; i <= END_NUMBER; i++) {	
						if ((i % 6 == 0 || i % 7 == 0 ) && ((i % 6 != 0 ) || (i % 7 != 0 ))) {
							println(i + ".");
						}
					}
					break;
			}
		}
	
		/* Private constants */
		private static final int END_NUMBER = 100;
		private static final String BOTH = "both";
		private static final String EITHER = "either";

}
