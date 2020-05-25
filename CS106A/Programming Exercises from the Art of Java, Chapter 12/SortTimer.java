/*
 * File: SortTimer.java
 * --------------------
 * This program measures the running time of the sort method.
 */

import acm.program.*;
import acm.util.*;

/**
 * This program executes a series of timing trials to measure the
 * efficiency of the sorting algorithm.
 */
public class SortTimer extends ConsoleProgram {

/*
 * Runs the trials.  This method should consist of a series of
 * calls to
 *
 *    sortTimer(nElements, nRepetitions, nTrials)
 *
 * in which nElements is the number of elements in the array,
 * nRepetitions is the number of times the array is sorted during
 * each trial, and nTrials is the number of independent trials
 * made for that element count.
 */
	public void run() {
		sortTimer(10, 100000, 10);
		sortTimer(20, 100000, 10);
		sortTimer(30, 100000, 10);
		sortTimer(40, 10000, 10);
		sortTimer(50, 10000, 10);
		sortTimer(100, 1000, 10);
		sortTimer(500, 100, 10);
		sortTimer(1000, 10, 10);
		sortTimer(5000, 10, 10);
		sortTimer(10000, 2, 10);
	}

/* Performs a sort timing experiment */
	private void sortTimer(int nElements, int nRepetitions, int nTrials) {
		double[] timings = new double[nTrials];
		for (int i = 0; i < nTrials; i++) {
			timings[i] = sortTrial(nElements, nRepetitions);
			println("sortTrial(" + nElements + ") = " + timings[i]);
		}
	}

/* Runs one trial of the sort timing experiment */
	private double sortTrial(int nElements, int nRepetitions) {
		int[] initialArray = new int[nElements];
		for (int i = 0; i < nElements; i++) {
			initialArray[i] = rgen.nextInt(1, nElements);
		}
		double overhead = timeTrial(initialArray, nRepetitions, false);
		double total =  timeTrial(initialArray, nRepetitions, true);
		return total - overhead;
	}

/* Performs the actual timing run */
	private double timeTrial(int[] initial, int nRepetitions, boolean doSort) {
		long start = System.currentTimeMillis();
		int[] array = new int[initial.length];
		for (int rep = 0; rep < nRepetitions; rep++) {
			for (int i = 0; i < initial.length; i++) {
				array[i] = initial[i];
			}
			if (doSort) sort(array);
		}
		long elapsed = System.currentTimeMillis() - start;
		return (double) elapsed / nRepetitions;
	}

/*
 * Sorts an integer array into increasing order.  The implementation uses
 * the selection sort, which is described in the text.
 */
	private void sort(int[] array) {
		for (int lh = 0; lh < array.length; lh++) {
			int rh = findSmallest(array, lh, array.length);
			swapElements(array, lh, rh);
		}
	}

/* Returns the index of the smallest array element between p1 and p2 - 1 */
	private int findSmallest(int[] array, int p1, int p2) {
		int smallestIndex = p1;
		for (int i = p1 + 1; i < p2; i++) {
			if (array[i] < array[smallestIndex]) smallestIndex = i;
		}
		return smallestIndex;
	}

/* Exchanges the elements in an array at index positions p1 and p2. */
	private void swapElements(int[] array, int p1, int p2) {
		int temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}

/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
