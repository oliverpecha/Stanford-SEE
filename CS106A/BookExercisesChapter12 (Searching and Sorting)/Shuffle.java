/*
 * File: Shuffle.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 7
 * -----------------
 * Many algorithmic problems are related to sorting in their solution structure. For example, you can shuffle an array by “sorting” it according 
 * to a random key value.
 * One way to do this is to begin with the selection sort algorithm and then replace the step that finds the position of smallest value with one 
 * that selects a random position. The result is a shuffling algorithm in which each possible output configuration is equally likely.
 * Write a program Shuffle that displays the integers between 1 and 52 in a randomly sorted order.
 */

import acm.program.*;
import acm.util.*;

public class Shuffle extends ConsoleProgram {
	
	private static final int RANGE = 52;
	int [] values = new int[RANGE];
	RandomGenerator luck = new RandomGenerator();
	
	public void run() {
		fillValues();
		while (true) {
			String input = readLine("\nThis program displays numbers from 1 to " + RANGE + " randomly after you hit enter\n");
			shuffleValues();
			printRandomValues();
		}
	}

/* Prints array one by one */	
	private void shuffleValues() {
		// for as many times as elements in the array
		for (int i = 0; i < values.length - 1; i++) {
			// pick a random element in the array
			int target = luck.nextInt(i, values.length - 1);
			// swap it to the lower position in the array still not manipulated (starting by 0)
			swapElements(i, target);	
		}
	}
	
	private void swapElements(int receiver, int target) {
		int holder = values[receiver];
		values[receiver] = values[target];
		values[target] = holder;
	}
	
/* Prints array one by one */	
	private void fillValues() {
		for (int i = 0; i < values.length; i++) {
			values[i] = i + 1;
		}
	}

/* Prints array one by one */	
	private void printRandomValues() {
		for (int i = 0; i < values.length; i++) {
			println(values[i]);
		}
	}

}
