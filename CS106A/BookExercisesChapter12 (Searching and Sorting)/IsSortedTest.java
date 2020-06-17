/*
 * File: IsSortedTest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 2 & 3
 * -----------------
 * Write a predicate method isSorted(array) that takes an integer array and returns true if the array is sorted in nondecreasing order.
 * -----------------
 * Rewrite the selection sort implementation so that the sort method can also take an ArrayList<Integer> as well as an array of ints. 
 * The ArrayList version of the methods should use only ArrayList penetrations and should not merely convert the ArrayList to an array, 
 * sort it, and then convert it back.
 */


import java.util.ArrayList;

import acm.program.*;

public class IsSortedTest extends ConsoleProgram {

	public void run() {
		 int [] allNumbers = {1,2,6,2,6,3,4,5,6,7,8,9,10,11};
		//int [] allNumbers = {1,2,3,4,5,6,7,8,9,10,11};
		ArrayList<Integer> allNumbersTwo = new ArrayList<Integer>() {
			{ 	add(1);
				add(2);
				add(3);
				add(4);
				add(5);
				add(6);
				add(7);
				add(8);
			}
		};
		if (isSorted (allNumbers)) println("All numbers in the array are sorted");
		else println("Numbers in the array are not sorted :(");
		if (isSorted (allNumbersTwo)) println("\nAll numbers in the ArrayList are sorted");
		else println("\nNumbers in the ArrayList are not sorted :(");
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
	
	private boolean isSorted(ArrayList<Integer> array) {
		boolean result = false;
		int reference = array.get(0);
		for (int i = 0; i < array.size(); i++) {
			if (reference <= array.get(i)) {
				result = true;
				reference = array.get(i);
			}
			else {
				result = false;
				i = array.size();
			}
		}
		return result;
	}
}
