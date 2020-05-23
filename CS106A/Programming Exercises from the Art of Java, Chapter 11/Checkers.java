/*
 * File: Checkers.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise bonus 10 & 11
 * -----------------
 * The initial state of a checkers game is shown in the following diagram:
 * The dark squares in the bottom three rows are occupied by red checkers; the dark squares in the top three rows contain black checkers. 
 * The two center rows are unoccupied.
 * If you want to store the state of a checkerboard in a computer program, you need a two-dimensional array indexed by rows and columns. 
 * The elements of the array could be of various different types, but a reasonable approach—as illustrated by the tic-tac-toe example—is 
 * to use characters. For example, you could use the letter r to represent a red checker and the letter b to represent a black checker. 
 * Empty squares can be represented as spaces or hyphens depending on whether the color of the square was light or dark.
 * Implement a method initCheckerboard that initializes a checkerboard array so that it corresponds to the starting position of a 
 * checkers game. Implement a second method displayCheckerboard that displays the current state of a checkerboard on the console, like this:
 * Redesign the data structure for the checkerboard described in the previous exercise so that each of the elements of the checkerboard 
 * array is a GCompound object that draws itself at the appropriate position on the graphics window. For example, the element in the lower 
 * left corner should be a GCompound that contains two graphical objects:
 * • A filled GRect to serve as the background square
 * • A filled red circle to indicate the checker
 */

import acm.program.*;
import java.awt.Color;
import acm.graphics.*;


public class Checkers extends GraphicsProgram {
	
	Checker [][] checkerArray;
	
	public void init() {
		setSize(BOARD_SIZE, BOARD_SIZE);
		checkerArray = new Checker [8][8];
		fillArray();
		printArray();
	}

	private void fillArray() {
		for (int i = 0; i < 8; i++) {
			int remainder = 0;
			if (i % 2 == 0) remainder = 1;
			for (int n = 0; n < 8; n++) {
				if (n % 2 == remainder && n >= 0 && n < 3) checkerArray[i][n] = new Checker(SQUARE_SIZE, Color.BLACK);
				if (n % 2 == remainder && n > 2 && n < 5) checkerArray[i][n] = new Checker(SQUARE_SIZE, null);
				if (n % 2 == remainder && n > 4 && n < 8) checkerArray[i][n] = new Checker(SQUARE_SIZE, Color.RED);
			}
		}
	}
	
	private void printArray() {
		for (int i = 0; i < 8; i++) {
			for (int n = 0; n < 8; n++) {
				if (checkerArray[i][n] != null) add(checkerArray[i][n], i * SQUARE_SIZE, n * SQUARE_SIZE);
			}
		}
	}
	
	private static final int BOARD_SIZE = 520;
	private static final double SQUARE_SIZE = BOARD_SIZE / 8;
	
	private class Checker extends GCompound {
	
		public Checker(double width, Color dot) {
			GRect rect = new GRect(width, width);
			rect.setFilled(true);
			rect.setFillColor(Color.LIGHT_GRAY);
			add(rect);
			if (dot != null) {
				GOval check = new GOval(0.8 * width, 0.8 * width);
				check.setFilled(true);
				check.setFillColor(dot);
				check.setColor(dot);
				add(check, 0.1 * width, 0.1 * width);
			}
		}
	}
	
}
