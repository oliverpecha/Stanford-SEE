/*
 * File: IsSortedTest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 1
 * -----------------
 * Write a predicate method isSorted(array) that takes an integer array and returns true if the array is sorted in nondecreasing order.
 */


import acm.program.*;

public class IsSortedTest extends ConsoleProgram {

	public void run() {
		// int [] allNumbers = {1,2,6,2,6,3,4,5,6,7,8,9,10,11};
		int [] allNumbers = {1,2,3,4,5,6,7,8,9,10,11};
		if (isSorted (allNumbers)) println("All numbers in the array are sorted");
		else println("Numbers in the array are not sorted :(");
	}
	
	private boolean isSorted(int [] array) {
		boolean result = false;
		int reference = array[0];
		for (int i = 0; i < array.length; i++) {
			if (reference <= array[i]) {
				result = true;
				reference = array[i];
			}
			else {
				result = false;
				i = array.length;
			}
		}
		return result;
	}
}
