/*
 * File: Eratosthenes.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 6.
 * -----------------
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
