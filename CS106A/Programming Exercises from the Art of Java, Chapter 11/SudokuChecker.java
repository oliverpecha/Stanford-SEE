/*
 * File: SudokuChecker.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 5.
 * -----------------
 * Write a program to check if a Sudoku is properly filled.
 */

import acm.program.*;

public class SudokuChecker extends ConsoleProgram {
	
	public void run() {
		int [] [] array = {
				{3,9,2,4,6,5,8,1,7},
				{7,4,1,8,9,3,6,2,5},
				{6,8,5,2,7,1,4,3,9},
				{2,5,4,1,3,8,7,9,6},
				{8,3,9,6,2,7,1,5,4},
				{1,7,6,9,5,4,2,8,3},
				{9,6,7,5,8,2,3,4,1},
				{4,2,3,7,1,9,5,6,8},
				{5,1,8,3,4,6,9,7,2}
			};
		if (checkSudokuSolution(array)) println("This sudoku is properly filled");
		else println("This sudoku is not properly filled :(");
	}
	private boolean checkSudokuSolution(int[][] grid) {
		boolean correctSudoku = true;
		// Horizontal.  Calls horizontalCheck method to check that every row contains numbers from 1 to 9, without repeating any.
		if (!horizontalCheck(grid)) correctSudoku = false;
		// Vertical. Calls verticalCheck method to check that every column contains numbers from 1 to 9, without repeating any.
		// Also checks correctSudoku condition, as if correctSudoku was declared false when checking rows, columns don't need to be checked.
		if (correctSudoku && !verticalCheck(grid)) correctSudoku = false;
		// Local grids
		if (correctSudoku && !localGridCheck(grid)) correctSudoku = false;
		return correctSudoku;
	}
	
	private boolean horizontalCheck(int[][] grid) {
		// Declares that the sudoku is correct to begin testing
		boolean correctSudoku = true;
		// Initiates a testingArray which will be filled with incoming numbers until a line is completed or a duplicate is found
		int [] testingArray = new int [9];
		for (int i = 0; i < 9; i++) {
			// correctSudoku condition is constantly being checked, as if any testingArray element is found duplicate, this avoid doing further evaluations
			if (correctSudoku) {
			for (int n = 0; n < 9; n++) {	
				if (correctSudoku) {
				// selects an element in the grid 
				int currentInt =  grid[i][n];
				// if the value is 0 it means that number wasn't used in the line yet, thus is correct. element gets filled with current value
				if (testingArray[currentInt-1] == 0) testingArray[currentInt-1] = grid[i][n];
				// if an element in testingArray was to be duplicated, it means sudoku is not correct
				else correctSudoku = false;
				}	
			}
			// Resets testingArray to begin refilling with new column
			testingArray = new int [9];
			}
		}
		return correctSudoku;
	}
	private boolean verticalCheck(int[][] grid) {
		boolean correctSudoku = true;
		int [] testingArray = new int [9];
		for (int i = 0; i < 9; i++) {
			if (correctSudoku) {
			for (int n = 0; n < 9; n++) {	
				if (correctSudoku) {
				// Same as horizontal check, except that currentInt inverts values in order to change testing direction 
				int currentInt =  grid[n][i];
				if (testingArray[currentInt-1] == 0) testingArray[currentInt-1] = grid[i][n];
				else correctSudoku = false;
				}	
			}
			testingArray = new int [9];
			}
		}
		return correctSudoku;
	}
	
	private boolean localGridCheck(int[][] grid) {
		boolean correctSudoku = true;
		int [] testingArray = new int [9];
		for (int vb = 0; vb < 3; vb++) {
			if (correctSudoku) {
			for (int hb = 0; hb < 3; hb++) {
				if (correctSudoku) {
				for (int v = 0; v + vb * 3 < 3 + vb * 3; v++) {
					if (correctSudoku) {
					for (int h = 0; h + hb * 3 < 3 + hb * 3; h++) {	
						if (correctSudoku) {
						/* 	- Testing value is encapsulated between 3x3 "blocks". 
							- currentInt increments one by one as methods above, but this time columns and rows are limited to 3 values 
						 	instead of 9 (both vertically and horizontally). This achieves testing designated 3x3 blocks.
						 	- Testing block changes horizontally to the right by adding a multiple of 3 to the standard single increments 
							to move within designated grids. To move from block to block, those multiples are initiated as 
							vb (vertical block) and hb (horizontal block). Once first 3 grids have been evaluated from left to right, 
							continues testing to the bottom.  */
						int currentInt =  grid[v + vb * 3][h + hb * 3];
						if (testingArray[currentInt-1] == 0) testingArray[currentInt-1] = grid[v + vb * 3][h + hb * 3];
						else correctSudoku = false;
						}
					}
					}
				}
				}
			testingArray = new int [9];
			}
			}
		}	
		return correctSudoku;
	}
}
