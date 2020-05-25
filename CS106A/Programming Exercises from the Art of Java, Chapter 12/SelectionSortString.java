/*
 * File: SelectionSortString.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 4
 * -----------------
 * Modify the code for the selection sort algorithm to produce a method called alphabetize that sorts an array of strings into 
 * lexicographic order.
 */

/*
 * This program implements the selection sort algorithm for
 * integer arrays, along with a test program that reads in
 * a list of integers, sorts it, and then displays the result.
 */

import acm.program.*;
import java.util.*;

public class SelectionSortString extends ConsoleProgram {

	public void run() {
		println("This program sorts a String array.");
		String[] array = readStringArray();
		sort(array);
		println("That array in sorted order is:");
		printArray(array);
	}

/* Reads an integer array using a blank line as a sentinel */
	private String[] readStringArray() {
		ArrayList<String> list = new ArrayList<String>();
		println("Enter the elements in the array, one per line.");
		println("Use a blank line to signal the end of the array.");
		while (true) {
			String line = readLine();
			if (line.length() == 0) break;
			try {
				list.add(line);
			} catch (NumberFormatException ex) {
				println("Illegal integer format -- retry");
			}
		}
		int nElements = list.size();
		String[] array = new String[nElements];
		for (int i = 0; i < nElements; i++) {
			array[i] = list.get(i);
		}
		return array;
	}

/* Prints out the data from the list, one per line */
	private void printArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			println(array[i]);
		}
	}

/*
 * Sorts a String array into increasing order.  The implementation uses
 * an algorithm called selection sort, which can be described informally
 * in English as follows:
 *
 *   With your left hand, point at each element in the array in turn, starting
 *   at index 0.  At each step in the cycle:
 *
 *     1. Find the smallest element in the range between your left hand and the
 *        end of the array, and point at that element with your right hand.
 *
 *     2. Move that element into its correct index position by switching the
 *        elements indicated by your left and right hands.
 */
	private void sort(String[] array) {
		for (int lh = 0; lh < array.length; lh++) {
			int rh = findLowestReference(array, lh, array.length);
			swapElements(array, lh, rh);
		}
	}

/* Returns the index of the array element that comes earlier between p1 and p2 - 1 */
	private int findLowestReference(String[] array, int p1, int p2) {
		int smallestIndex = p1;
		for (int i = p1 + 1; i < p2; i++) {
			if (comesEarlier(array[smallestIndex], array[i])) smallestIndex = i;
		}
		return smallestIndex;
	}
	
/* Evaluates characters at equivalent positions to determine the order */
	private boolean comesEarlier(String reference, String current) {
		boolean comesEarlier = false;
		int currentIndex = 0;
		char referenceChar = reference.charAt(currentIndex);
		char currentChar = current.charAt(currentIndex);
		// Given both compared chars are the same
		while (referenceChar == currentChar) {
			// find out if both reference and current strings have more chars left for evaluation
			if (currentIndex + 1 <= reference.length() - 1 && (currentIndex + 1 <= current.length() - 1)) {	
				// If posible advance index a position and extract new char then evaluation loop will restart
				currentIndex++;
				referenceChar = reference.charAt(currentIndex);
				currentChar = current.charAt(currentIndex);
			}
			// If one or both of the Strings don't have more chars to evaluate find out
			else {
				// if current is shorter than reference, then force referenceChar to be the highest
				if (current.length() < reference.length()) referenceChar = 'z' + 1;
				// if reference is shorter, for currentCar to be the highest. If both strings are actually the same, current should still be forced in order to exit the loop
				else currentChar = 'z' + 1;	
			}
		}
		// If currentChar is lower than referenceChar, current String should come Earlier
		if (currentChar < referenceChar)  comesEarlier = true;
		// Otherwise comesEarlier was set false by default at local initiation
		return comesEarlier;
	}

/* Exchanges the elements in an array at index positions p1 and p2. */
	private void swapElements(String[] array, int p1, int p2) {
		String temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;

	}

}
