/*
 * File: PerfectNumber.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 12
 * -----------------
 * Greek mathematicians took a special interest in numbers that are equal to the sum of their proper divisors 
 * (a proper divisor of n is any divisor less than n itself). 
 * They called such numbers perfect numbers. 
 * For example, 6 is a perfect number because it is the sum of 1, 2, and 3, which are the integers less than 6 that divide evenly into 6.
 * Similarly, 28 is a perfect number because it is the sum of 1, 2, 4, 7, and 14.
 * -----------------
 * Write a predicate method isPerfect(n) that returns true if the integer n is perfect, and false otherwise. Test your implementation 
 * by writing a main program that uses the isPerfect method to check for perfect numbers in the range 1 to 9999 by testing each number 
 * in turn. Whenever it identifies a perfect number, your program should display that number on the screen. The first two lines of 
 * output should be 6 and 28. Your program should find two other perfect numbers in that range as well.
 */

import acm.program.*;

public class PerfectNumber extends ConsoleProgram {
	
	
	public void run() {
		
		println("This program lists perfect numbers in the range " + START_NUMBER + " to " + END_NUMBER + ".");
		
		for (int i = 1 ; i <= END_NUMBER; i++) {
			if (isPerfect(i)) println(i + " is a perfect number");		
		}

	}
	
	private boolean isPerfect(int n) {
		System.out.println("hello");
		int balance = 0;
		for (int i = n - 1; i >= 1; i--) {
			if (n % i == 0) balance += i ;
			System.out.println("i = " + i);
			System.out.println("balance = " + balance);

		}
		System.out.println("total balance = " + balance);
		return (n == balance);
	}

	private static final int START_NUMBER = 1;
	private static final int END_NUMBER = 9999;
}

