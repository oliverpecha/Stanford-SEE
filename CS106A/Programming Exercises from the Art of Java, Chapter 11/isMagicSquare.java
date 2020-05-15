/*
 * File: isMagicSquare.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 1, 2 & 3.
 * -----------------
 * Because individual judges may have some bias, it is common practice to throw out the highest and lowest score 
 * before computing the average. Write a program that reads in scores from a panel of seven judges and then computes 
 * the average of the five scores that remain after discarding the highest and lowest.
 */

import acm.program.*;

public class isMagicSquare extends ConsoleProgram {

	public void run() {
		
		int [][] magicSquare =  {
				{16,3,2,13},
				{5,10,11,8},
				{9,6,7,12},
				{4,15,14,1},
				};
		boolean isMagic = isMagicSquare(magicSquare);
		if (isMagic) println("This square is magic");
		else println("This square is not magic :(");
	}
	
	public boolean isMagicSquare(int [][] array) {
		int height = array.length;
		int width = array[0].length;
		while (true) {
			// Evaluates the sum of values on first row, assigns it to total and continues evaluating all remaining rows
			for (int i = 0; i < height; i++) {
				for (int n = 0; n < width; n++) {
					currentTotal += array[i][n];
				}
				// Assigns sum of values of initial row to total so that next evaluations have this reference value
				if (total == 0) total = currentTotal;
				// Calls a predicative method to evaluate if currentTotal and total are the same, 
				// if they are not the same loop is exited at this point, as no further evaluating is necessary.
				if (!totalEquality()) break;
			}
			// Evaluates the sum of values of all columns
			for (int i = 0; i < height; i++) {
				for (int n = 0; n < width; n++) {
					currentTotal += array[n][i];
				}
				if (!totalEquality()) break;
			}
			// Evaluates the sum of values of increasing diagonal
			for (int i = 0; i < height; i++) {
				currentTotal += array[i][i];
			}
			if (!totalEquality()) break;
			// Evaluates the sum of values of decreasing diagonal
			for (int i = 0; i < height; i++) {
				currentTotal += array[height -1 - i][i];
			}
			if (!totalEquality()) break;
			// All possible directions have been tested positive, loop is exited and method returns true to caller
			break;
		}	
		return isMagicSquare;
	}
	
	private boolean totalEquality() {
		if (currentTotal == total) {
			isMagicSquare = true;
			currentTotal = 0;
		}
		else isMagicSquare = false; 
		return isMagicSquare;
	}
	
	int total = 0;
	int currentTotal = 0;
	boolean isMagicSquare = false;
	
}

