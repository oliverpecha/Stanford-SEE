/*
 * File: PrimeNumber.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 11
 * -----------------
 * An integer greater than 1 is said to be prime if it has no divisors other than it self and one. The number 17, for example, is prime, 
 * because it is divisible only by 1 and 17. The number 91, however, is not prime because it is divisible by 7 and 13. 
 * Write a predicate method isPrime(n) that returns true if the integer n is prime, and false otherwise. 
 * As an initial strategy,implement isPrime using a brute-force algorithm that simply tests every possible divisor. 
 * Once you have that version working, try to come up with improvements to your algorithm that increase its efficiency without 
 * sacrificing its correctness.
 */

import acm.program.*;

public class PrimeNumber extends ConsoleProgram {
	
	
	public void run() {
		
		println("This program tests if an integer is a Prime Number");
		int n = readInt("Enter integer ");
		// YES prime
		if (isPrime(n)) println(n + " is a prime number");
		// NOT prime
		else if (!(isPrime(n))) println(n + " is not a prime number");	
	}
	
	private boolean isPrime(int n) {
		int i = n - 1;
		while (n % i != 0) {
			i--;
			System.out.println("i = " + i);
		}
		return (i == 1);
	}

}
