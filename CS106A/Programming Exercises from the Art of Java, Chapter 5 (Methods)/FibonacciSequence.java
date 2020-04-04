/*
 * File: FibonacciSequence.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 2
 * -----------------
 * The Fibonacci sequence, in which each new term is the sum of the preceding two, was introduced in Chapter 4, exercise 9. 
 * Rewrite the program requested in that exercise, changing the implementation so that your program calls a method fibonacci(n) 
 * to calculate the nth Fibonacci number. In terms of the number of mathematical calculations required, is your new implementation 
 * more or less efficient that the one you used in Chapter 4?
 */


import acm.program.ConsoleProgram;

public class FibonacciSequence extends ConsoleProgram {

	public void run() {
		
		/* nth fibonacci number user wishes*/
		int wish = 0;
		/* The resulting number of the nth fibonacci sequence */
		int fib = 0;

		println("This Program will return the Fibonacci number of a given Integer");
		
		wish = readInt("Enter an integer... ");
		fib = fibonacci(wish);
		
		println("Fibonacci number of " + wish + " is " + fib);
		
	}
	
	private int fibonacci(int n) {
		int a = 0;
		int b = 1;
		int total = 0;
		
		for (int i = 0; i < n; i++ ) {
			a =  b;
			b = total;
			total = a+b;
		}
		return total;
	}
	
	
}
