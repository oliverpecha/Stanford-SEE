

/*
 * File: SumOfOddIntegers.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 3 on chapter 4 of Programming Exercises from the Art of Java:
 * Write a program that reads in a positive integer N and then calculates and displays the sum of the first N odd 
 * integers. For example, if N is 4, your program should display the value 16, which is 1 + 3 + 5 + 7.
 */

import acm.program.ConsoleProgram;

public class SumOfOddIntegers extends ConsoleProgram {

		public void run () {	
			println("This program sums the first odd integer of a given number");
			int n = readInt("Enter a number: ");
			int total = 0;
			for (int i = 0; i <= n*2; i++) {	
				// if n is an odd number, sum it to total
				if (i % 2 == 1) {
					total += i; 
				}
			}
			println("Total is " + total + ".");
		}
}