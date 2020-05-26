/*
 * File: Median.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 5
 * -----------------
 * In the exercises for Chapter 10, you had the chance to write two programs to compute common statistical measures: the mean and the 
 * standard deviation. Another important statistical measure is the median, the data value that occupies the central element position 
 * in a distribution whose values have been sorted from lowest to highest. If the distribution contains an even number of values and 
 * therefore has no central element, the standard convention is to average the two values that fall closest to the midpoint.
 * Write a method median(array) that returns the median of an array of doubles. Your implementation may not assume that the array is in 
 * sorted order but may change the order of elements as it runs.
 */

import acm.program.*;
import java.util.*;

public class Median extends ConsoleProgram {
	
/* Initiates an instance variable containing an array of doubles */	
	double[] grades = {2.0, 3.6, 2.9, 8.5, 8.3, 4.6, 0.6, 7.2, 5.6, 7.6, 8.4, 3.5, 9.9};
	
/* Prints an intro to the program, initiates a DoubleArraySorter object using entered double array, displays the sorted elements and it's median */		
	public void run() {
		println("This program takes an array of doubles and displays it's median");
		DoubleArraySorter sortedGrades = new DoubleArraySorter(grades);
		println("Entered array is " + grades.length + " long and it's elements are below:");
		printDoubleArraySorter(sortedGrades);
		println("Median is: " + median(sortedGrades));
	}

/* Calculates and returns the median as a double distinguishing odd and even arrays */		
	private double median(DoubleArraySorter array) {
		double result = 0;
		if (array.getSortedDoubleArrayLenght() % 2 == 1) {
			// Because array is odd, result is the element in the middle of the array (the -1 serves to compensate array index starting at 0)
			result = array.getSortedDoubleArrayElement((array.getSortedDoubleArrayLenght() + 1) / 2 - 1);
		}
		else {
			// Because array is even, result is the average of the two elements in the middle of the array (the -1 serves to compensate array index starting at 0)
			double t1 = array.getSortedDoubleArrayElement(array.getSortedDoubleArrayLenght() / 2 - 1);
			double t2 = array.getSortedDoubleArrayElement(array.getSortedDoubleArrayLenght() / 2 + 1 - 1);
			result = (t1 + t2) / 2;
		}
		return result;
	}

/* Prints the sorted values of entered array one by one */	
	private void printDoubleArraySorter(DoubleArraySorter array) {
		for (int i = 0; i < array.getSortedDoubleArrayLenght(); i++) {
			println(array.getSortedDoubleArrayElement(i));
		}
	}

/* Private class that creates an object containing an ArrayList of values passed as double array
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  */	
	
private class DoubleArraySorter {

/* Constructs an ArrayList on top of object's initialized array, fills it with argument passed as values in an array and sorts them */		
	public DoubleArraySorter(double[] array) {
		arrayOfDoubles = new ArrayList<Double>();
		fillArrayList(array);
		sort();
	}
	
/* Getter method that returns the complete ArrayList<Double> */	
	public ArrayList<Double> getSortedDoubleArray() {
		return arrayOfDoubles;
	}

/* Getter method that returns an int value representing the length/size of the ArrayList */	
	public int getSortedDoubleArrayLenght() {
		return arrayOfDoubles.size();
	}

/* Getter method that returns double value at the requested index number */	
	public double getSortedDoubleArrayElement(int index) {
		return arrayOfDoubles.get(index);
	}

/* Fills the ArrayList with the elements from the double array in the constructor */
	private void fillArrayList(double[] array) {
		for (int i = 0; i < array.length; i++) {
			arrayOfDoubles.add(array[i]);
		}
	}
	
/* Sorts the array using the Selection sort method which consists of finding the smallest element in the array, swaping it to the  
 * first position of the array and continue doing so until all elements have been compared and swaped */
	private void sort() {
		for (int lh = 0; lh < arrayOfDoubles.size(); lh++) {
			int rh = findSmallest(arrayOfDoubles, lh, arrayOfDoubles.size());
			swapElements(arrayOfDoubles, lh, rh);
		}
	}

/* Returns the index of the smallest array element between p1 and p2 - 1 */
	private int findSmallest(ArrayList<Double> array, int p1, int p2) {
		int smallestIndex = p1;
		for (int i = p1 + 1; i < p2; i++) {
			if (array.get(i) < array.get(smallestIndex)) smallestIndex = i;
		}
		return smallestIndex;
	}

/* Exchanges the elements in an array at index positions p1 and p2. */
	private void swapElements(ArrayList<Double> array, int p1, int p2) {
		double temp = array.get(p1);
		array.set(p1, array.get(p2));
		array.set(p2, temp);
	}
/* Initializes and keeps the object array in the memory*/	
	ArrayList<Double> arrayOfDoubles;
}

}
