/*
 * File: RadixSort.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 10
 * -----------------
 * Complete the implementation of the radix sort algorithm that will sort an array of nonnegative integers up to ten digits in length. 
 * A pseudocode version of the algorithm appears on page 480.
 */

import acm.program.*;
import acm.util.*;
import java.util.*;

public class RadixSort extends ConsoleProgram {
	
	private static final int MAX_DIGITS = 9;
	RandomGenerator luck = new RandomGenerator();
	int[] array = new int[24];
	ArrayList<ArrayList<Integer>> radix = new ArrayList<ArrayList<Integer>>();
	
	public void init() {
		setSize(300, 900);
	}
	public void run() {
		println("This program will sort the following array:");
		fillArray();
		fillArrayList();
		printArray();
		println("\nThat array in sorted order is:");
		sort();
		printArray();
	}
	
	private void sort() {
		// Number of sorted elements that have less digits that the remaining larger elements still to be be ordered (total - assigned) 
		// Eg: After 2 rounds 3, 5, 68 and 89 don't need to be send back from the array to the radix because the elements left to be ordered
		// have more than 2 digits, eg: 121, 7890, 432, 5673, 2456, 3627284, 3637, 47483839
		int assigned = 0;
		// For as many rounds / times as the maximum number of digit an element at the array may have
		for (int round = 1; round <= MAX_DIGITS; round++) {
			// Move elements from the array to the Radix, starting at the assigned / position. In the example above only elements after index 
			// 3 will be sent as 3 (index 0), 5 (index 1), 68 (index 2) and 89 (index 3) are already well positioned.
			assigned =	arrayToRadix(round, assigned);
			// Removes all the elements from each bucket in the radix and arranges them back to the array. Respecting the particular order from each
			// bucket in the array makes the algorithm be effective. Regardless, elements received in the array from the radix need to be placed right
			// after the assigned / position which as explained above shouldn't be manipulated anymore.
			radixToArray(assigned);
		}
		// Array is sorted as soon as all rounds have been completed
	}
	
/* Array will be thrown into corresponding radix buckets starting after position of elements that have already been (assigned / i) an order.
 * While elements are being trown,  */
	private int arrayToRadix(int round, int assigned) {
		for (int i = assigned; i < array.length; i++) {
			// receive element
			int element = array[i];
			// find out element's length
			int lenght = (int)(Math.log10(element)+1);			
			// If round is greater than length, element doesn't need to be thrown into any bucket, instead, it should be put back at the array
			// at the last know available location to be assigned. Assigned will be incremented one position so next sorted value doesn't override this one
			if (round > lenght) {
				array[assigned] = element;
				assigned++;
			}
			// In other case, element needs to find a bucket 
			else {
				// get value from the last digit
				int digit = intAt(round, element);
				// throw element into radix bucket
				radix.get(digit).add(element);
			}
		}
		return assigned;
	}
	
/* Goes through the multidimensional radix in order to extract the elements and return back to the array, taking in consideration where the unassigned positions start */
	private void radixToArray(int assigned) {
		// for as many digits as the largest value has
		int movedfromRadix = 0;
		for (int i = 0; i < radix.size(); i++) {
			for (int n = 0; n < radix.get(i).size(); n++) {
				// receive element
				int element = radix.get(i).get(n);
				array[assigned + movedfromRadix] = element;
				movedfromRadix++;
			}
			radix.get(i).clear();
		}
	}
	
/* Returns the number from an element at the position of a round. Eg: for element 4781 in round 3, method will return a 7  */
	private int intAt(int round, int element) {
		int revExp = 1;
		if (round > 1) revExp = (int) Math.pow(10, round);
		return (element/revExp) % 10;
	}
	
/* Fills an array with random numbers of 1 to 9 digits */
	private void fillArray() {
		// for each array element to be filled
		for (int i = 0; i < array.length; i++) {
			// Picks a n number between 1 and 9
			int n = luck.nextInt(1, MAX_DIGITS);
			// Generates a limit n times long filled with 9s
			int randomNumber = generateLimit(n);
			// Requests a number with a range from 1 and randomNumber and assigns it to the array at position i
			array[i] = luck.nextInt(1, randomNumber);
		}
	}
	
/* Generates a number n times long filled with 9s */
	private int generateLimit(int n) {
		int result = 9;
		for (int i = 1; i < n; i++) {
			result += 9 * Math.pow(10, i);
		}
		return result;
	}
	
/* Prints out the data from the list, one per line */
	private void printArray() {
		for (int i = 0; i < array.length; i++) {
			println(array[i]);
		}
	}
	
/* Helper method to turn radix into a multidimensional ArrayList of Integers */	
	private void fillArrayList() {
		for (int i = 0; i < 10; i++) {
			radix.add(new ArrayList<Integer>());
		}
	}
}
