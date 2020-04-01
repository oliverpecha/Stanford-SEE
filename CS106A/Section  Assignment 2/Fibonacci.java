/*
 * File: FibonacciSequence.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 1 on CS 106A, Section Handout #2.
 * -----------------
 * In mathematics, there is a famous sequence of numbers called the Fibonacci sequence after the thirteenth-century 
 * Italian mathematician Leonardo Fibonacci. 
 * The first two terms in this sequence are 0 and 1, and every subsequent term is the sum of the preceding two. 
 * Thus the first several numbers in the Fibonacci sequence are as follows:
 * -----------------
 * F0 = 0 	F1 = 1 	F2 = 1 	F3 = 2 	F4 = 3 F5 = 5 	F6 = 8
 * 					(0 + 1) (1 + 1) (1 + 2)(2 + 3) 	(3 + 5)
 * EXERCISE 1: Write a program to display the values in this sequence from F0 through F15.
 * EXCERCISE 2: Modify the program in the preceding exercise so that instead of specifying the index of the final term, 
 * the program displays those terms in the Fibonacci sequence that are less than 10,000.
 */


import acm.program.ConsoleProgram;

public class Fibonacci extends ConsoleProgram {

	public void run() {
		int a = 0;
		int b = 1;
		int term = 0;
		println("F" + a + " = " + term);
		
		for (int i = 1; i > 0; i++ ) {
			a =  b;
			b = term;
			term = a+b;
			if (term >= MAX_TERM_VALUE) break;
			println("F" + i + " = " + term);
		}
		
	}
	
	private static final int MAX_TERM_VALUE = 10000;
	
	
}
