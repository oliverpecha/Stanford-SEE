/*
 * File: DutchNationalFlag.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 8
 * -----------------
 * Many algorithmic problems are related to sorting in their solution structure. For example, you can shuffle an array by “sorting” it according 
 * to a random key value.
 * One way to do this is to begin with the selection sort algorithm and then replace the step that finds the position of smallest value with one 
 * that selects a random position. The result is a shuffling algorithm in which each possible output configuration is equally likely.
 * Write a program Shuffle that displays the integers between 1 and 52 in a randomly sorted order.
 */

import acm.program.*;
import acm.util.*;

public class DutchNationalFlag extends ConsoleProgram {
	
	RandomGenerator luck = new RandomGenerator();
	char[] array = new char[15];
	int reds = 5;
	int whites = 5;
	int blues = 5;
	
	public void run() {
		fillArray();
		threeWayPartitioning();	
	}
	
	private void threeWayPartitioning() {
		// as explained in this video https://www.youtube.com/watch?v=fIU1owzZkMU
		// pivot location
		int p = 0;
		// moving location
		int m = 0;
		// limit location
		int l = array.length -1;
		printValues(-1, -1);
		while (m <= l) {
			switch (array[m]) {
			case 'R': 	swap(m,p);
						printValues(m, p);
						m++; p++; 
						break;
			case 'W':	m++; break;
			case 'B':	swap(m,l);
						printValues(m, l);
						l--; break;
			}
		}
	}
	
	private void swap(int p1, int p2) {
		char buffer = array[p1];
		array[p1] = array[p2];
		array[p2] = buffer;
	}
	
	private void fillArray() {
		for (int i = 0; i < array.length; i++) {
				array[i] = nextColor();
		}
	}
	
	private char nextColor() {
		int assigner = luck.nextInt(1,3);
		char result = ' ';
		while (result == ' ') {
			switch (assigner) {
				case 1: if (reds > 0) {
							result = 'R';
							reds--;
						} break;
				case 2: if (whites > 0) {
							result = 'W';
							whites--;
						} break;
				case 3: if (blues > 0) {
							result = 'B';
							blues--;
						} break;
			}
			assigner = luck.nextInt(1,3);
		}	
		return result;
	}
	
/* Prints array one by one */	
	private void printValues(int p1, int p2) {
		if (p1 < 0 || p2 < 0) println("Initial state:");
		else println("\nAfter swaping positions " + p1 + " and " + p2 + ":");
		println(array[0] + " " + array[1] + " " +  array[2] + " " +  array[3] + " " +  array[4] + " " +  array[5] + " " +  array[6] + " " +  array[7] + " " +  array[8] + " " +  array[9] + " " +  array[10] + " " +  array[11] + " " +  array[12] + " " +  array[13] + " " +  array[14]);
	}
	
}
