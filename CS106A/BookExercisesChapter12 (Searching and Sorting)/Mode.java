/*
 * File: Mode.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 12 / Programming Exercise 6
 * -----------------
 * Besides the mean and the median, the third statistical measure designed to indicate the most representative element of a distribution 
 * is the mode, the value that occurs most often in the array. For example, in the array
 * 				65 84 95 75 82 79 82 72 84 94 86 90 84			
 * 				0  1  2  3  4  5  6  7  8  9  10 11 12
 * the mode is the value 84, because it appears three times. The only other value that appears more than once is 82, which only appears twice.
 * Write a method mode(array) that returns the mode of an array of doubles. If there are several values that occur equally often and outnumber 
 * any of the other values (such distributions are called multimodal), your method may return any of those values as the mode. As in the 
 * exercise 4, your implementation may not assume that the array is in sorted order but may change the order of elements doing so makes 
 * the solution easier to write.
 */

import acm.program.*;
import java.util.*;

public class Mode extends ConsoleProgram {
	
/* Initiates an instance variable containing an array of doubles */	
	double[] grades = {2.0, 3.6, 3.6, 8.4, 2.9, 8.5, 8.3, 3.6, 3.6, 4.6, 0.6, 7.2, 5.6, 7.6, 8.4, 3.5, 9.9, 9.9, 9.9, 9.9, 9.9, };
	
/* Prints an intro to the program, initiates a DoubleArraySorter object using entered double array, displays the sorted elements and it's mode */		
	public void run() {
		println("This program takes an array of doubles and displays it's mode");
		DoubleArraySorter sortedGrades = new DoubleArraySorter(grades);
		println("Entered array is " + grades.length + " long and it's elements are below:");
		printDoubleArraySorter(sortedGrades);
		println("Mode is: " + mode(sortedGrades));
	}

/* Calculates and returns the mode as a double distinguishing odd and even arrays */		
	private double mode(DoubleArraySorter array) {
		double frequency = 1;
		double frequencyOfModal = 1;
		double modal = 0;
		double tester = array.getSortedDoubleArrayElement(0);
		for (int i = 1; i < array.getSortedDoubleArrayLenght(); i++) {
			if (array.getSortedDoubleArrayElement(i) == tester) {
				frequency++;
				if (frequency > frequencyOfModal) {
					frequencyOfModal = frequency;
					modal = tester;
				}
			}
			else {
				tester = array.getSortedDoubleArrayElement(i);
				frequency = 1;
			}
		}
		return modal;	
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
