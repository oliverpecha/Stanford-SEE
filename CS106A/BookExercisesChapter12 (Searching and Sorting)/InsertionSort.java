/*
 * File: InsertionSort.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 9
 * -----------------
 * Another sorting algorithm—insertion sort—operates as follows. You go through each element in the array in turn, as with the selection sort 
 * algorithm. At each step in the process, however, your goal is not to find the smallest value remaining value and switch it into its correct 
 * position, but rather to ensure that the values you’ve covered so far in the array are correctly ordered with respect to one another. 
 * Although those values may shift as more elements are processed, they form an ordered sequence in and of themselves.
 * For example, if you consider again the data used in the selection sort discussion, the first cycle of the insertion sort algorithm 
 * requires no work because an array of one element is always sorted:
 * 	in order  ->|
 * 				31	41	59	26	53	58	97	93
 * 				0	1	2	3	4	5	6	7
 * -----------------
 * The next two cycles of the main loop also require no rearrangement of the array, because the sequence 31-41-59 forms an ordered subarray.
 * The first significant operation occurs on the next cycle, when you need to fit 26 into this sequence. To find where 26 should go, you need 
 * to move backward through the earlier elements, which you know are in order with respect to each other, looking for the position where 26 
 * belongs. At each step, you need to shift the other elements over one position to make room for the 26, which winds up in position 0. 
 * Thus, the configuration after the fourth cycle is
 * -----------------
 * 				|--in order -|
 * 				26	31	41	59	53	58	97	93
 * 				0	1	2	3	4	5	6	7
 * On each subsequent step, you again insert the next element in the array into its proper position in the initial subarray, which is always 
 * sorted at the end of each step.
 * The insertion sort algorithm is particularly efficient if the array is already more or less in the correct order. It therefore makes sense to 
 * use insertion sort to restore order to a large array in which only a few elements are out of sequence.
 * Reimplement the sortIntegerArray method using the insertion sort algorithm.

 */

import acm.program.*;
import java.util.*;

public class InsertionSort extends ConsoleProgram {

	public void run() {
		println("This program will sort the following array:");
		int [] array =	{100, 95, 47, 88, 86, 92, 75, 89, 81, 70, 55, 80};
		printArray(array);
		sort(array);
		println("\nThat array in sorted order is:");
		printArray(array);
	}

/* Prints out the data from the list, one per line */
	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			println(array[i]);
		}
	}

/*
 * Sorts an integer array into increasing order.  The implementation uses
 * an algorithm called insertion sort, which can be described at the begining of this file
 */
	private void sort(int[] array) {
		// right pointer
		int r = 1;
		// central pointer
		int c = 0;
		// left pointer
		int l = 0;
		// Keep looping until right pointer reaches the end of the array
		while (r <= array.length - 1)
			// if element in the right pointer is greater than the central one, advance both pointers
			if (array[c] < array [r]) {
				c++; r++; 
			}
			else {
				swapElements(array, c, r);
				// element initially pointed by right pointer will need to go as far to the left as needed.
				// As long as central pointer - 1 is not beyond the start of the index, start left pointer at central position - 1
				if (c - 1 >= 0) l = c - 1;
				// As long as element at central location is smaller than the one in the middle pointer, keep swaping them and moving both pointers left until index 0 is reached
				while (array[c] < array [l]) {
					swapElements(array, l, c);
					if (l - 1 >= 0) {
						l--; c--;
					}
				}
				// return central pointer to last know position of right pointer - 1
				c = r - 1; 
			}
	}

/* Exchanges the elements in an array at index positions p1 and p2. */
	private void swapElements(int[] array, int p1, int p2) {
		int temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}

}
