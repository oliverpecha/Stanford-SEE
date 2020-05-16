/*
 * File: Eratosthenes.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 6.
 * -----------------
 * In the third century B.C.E., the Greek astronomer Eratosthenes developed an algorithm for finding all the prime numbers up to 
 * some upper limit N. To apply the algorithm, you start by writing down a list of the integers between 2 and N. For example, 
 * if N were 20, you would begin by writing down the following list:
 * 2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20
 * You then begin by circling the first number in the list, indicating that you have found a prime. You then go through the rest of 
 * the list and cross off every multiple of the value you have just circled, since none of those multiples can be prime. 
 * Thus, after executing the first step of the algorithm, you will have circled the number 2 and crossed off every multiple of two, 
 * as follows:
 *  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20
 * []     x     x     x      x      x        x       x       x       x
 * From here, you simply repeat the process by circling the first number in the list that is neither crossed off nor circled, and 
 * then crossing off its multiples. In this example, you would circle 3 as a prime and cross off all multiples of 3 in the rest 
 * of the list, which would result in the following state:
 *  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20
 * [] []  x     x     x  x   x      x        x   x   x       x       x
 * Eventually, every number in the list will either be circled or crossed out, as shown in this diagram:
 *  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20
 * [] []  x []  x []  x  x   x  []  x   []   x  x   x  []   x  []   x
 * The circled numbers are the primes; the crossed-out numbers are composites. This algorithm for generating a list of primes is 
 * called the sieve of Eratosthenes.
 * Write a program that uses the sieve of Eratosthenes to generate a list of the primes
 * between 2 and 1000.
 */

import acm.program.*;

public class Eratosthenes extends ConsoleProgram {

	private static final int VALUE_START = 2;
	private static final int VALUE_END = 1000;
	
	public void run() {
		// Initialize array
		int [] array = new int [VALUE_END + 1];
		// fill array
		array = fillArray(array);
		// Discard multiples of currentPrime by picking an initial prime, 
		// then keep discarding it's multiples and choosing following prime numbers until array finished
		array = discardingMultiples(array);
		// Extract remaining values and print
		printPrimeNumbers(array);
	}
	
	private int [] fillArray(int [] array) {
		for (int i = VALUE_START; i < array.length; i++) {
			array[i] = i;
		}
		return array;
	}
	
	private int [] discardingMultiples(int [] array) {
		int currentPrime = 0;
		for (int i = VALUE_START; i <= VALUE_END; i++) {
			if (array[i] != 0) {
				currentPrime = array[i];
				for (int n = currentPrime + 1; n <= VALUE_END; n++) {
					if (array[n] != 0 && array[n] % currentPrime == 0) array[n] = 0;
				}
			}
		}
		return array;
	}
	
	private void printPrimeNumbers(int [] array) {
		println("Below are the prime numbers from " + VALUE_START+ " to " + VALUE_END + ":");
		for (int i = VALUE_START; i <= VALUE_END; i++) {
			if (array[i] != 0) println("• " + array[i]);
		}
	}
	
}
