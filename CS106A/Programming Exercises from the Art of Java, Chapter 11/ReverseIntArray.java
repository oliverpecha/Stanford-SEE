/*
 * File: ReverseIntArray.java
 * --------------------------
 * This file reads in an array of five integers and then displays
 * those elements in reverse order.
 */

import acm.program.*;

public class ReverseIntArray extends ConsoleProgram {

	public void run() {
		int[] array = new int[N_VALUES];
		println("This program reverses an integer array.");
		readArray(array);
		reverseArray(array);
		printArray(array);
	}

/* Reads the data into the array */
	private void readArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = readInt(" ? ");
		}
	}

/* Prints out the data from the array, one per line */
	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			println(array[i]);
		}
	}

/* Reverses the data in the array */
	private void reverseArray(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			swapElements(array, i, array.length - i - 1);
		}
	}

/* Exchanges two elements in an array */
	private void swapElements(int[] array, int p1, int p2) {
		int temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}

/* Private constants */
	private static final int N_VALUES = 5;

}
