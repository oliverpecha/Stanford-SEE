/*
 * File: CheckerBoardOwn.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * Book / Chapter 4 / Programming Exercise 14
 * -----------------
 * Enhance the Checkerboard program so that it centers the Checkerboard horizontally and draws the set 
 * of red and black SQUARES corresponding to the initial state of the game, which looks like this:
 * -----------------
 * The other change in this program is that the color of the dark squares has been changed from back to gray 
 * so that the black SQUARES are not lost against the background.
 */


import acm.program.*;

import java.awt.Color;

import acm.graphics.*;
							
public class CheckerBoardOwn extends GraphicsProgram {
			
	// Parameters that define size of the Theoretical Screen Size
	private static final int xScreenSize = 600;
	private static final int yScreenSize = 400;

	// Parameters that define size of the CheckerBoard
	private static final int SQUARES_X = 8;	
	private static final int SQUARES_SIZE = yScreenSize / SQUARES_X ;
	private static final int CHECKERS_SIZE = SQUARES_SIZE / 5 * 4;
	private static final int CHECKER_ROWS = 3;	
	
	// Position calculation for initial checker		
	int xStart = (xScreenSize - SQUARES_SIZE * SQUARES_X)/2;
	int yStart = 0;
	
	public void run () {
		
		screenLimits();
		Squares();
		redCheckers();
		blackCheckers();
	
	}
	
	private void screenLimits() {
		// Representation of the Theoretical Screen Size
		add(new GRect ( 0, 0, xScreenSize, yScreenSize));
	}
	
	private void Squares() {
		// Controller for SQUARES in Y row (vertical)
		for (int n = 0; n < SQUARES_X; n++) {	
			// Controller for SQUARES in X row (horizontal)
			for (int i = 0; i < SQUARES_X; i++) {
				GRect square = new GRect(xStart + SQUARES_SIZE * i, yStart + SQUARES_SIZE * n,SQUARES_SIZE ,SQUARES_SIZE );
				square.setFilled((i + n) % 2 != 0);
				square.setFillColor(Color.LIGHT_GRAY);
			    add(square);
			}
		}
	}
	
	private void redCheckers() {
		// Controller for RED checkers in Y row (vertical)
		for (int n = 0; n < CHECKER_ROWS; n++) {
			// Controller for RED checkers in X row (horizontal)
			for (int i = 0; i < SQUARES_X; i++) {
				if ((i + n) % 2 != 0) {
				GOval checker = new GOval((xStart + SQUARES_SIZE * i) + (SQUARES_SIZE / 5 * 1) / 2 , (yStart + SQUARES_SIZE * n) + (SQUARES_SIZE / 5 * 1) / 2 ,CHECKERS_SIZE ,CHECKERS_SIZE );
				checker.setFilled(true);
				checker.setFillColor(Color.RED);
			    add(checker);
				}
			}
		}
	}
	
	private void blackCheckers() {
		// Controller for BLACK checkers in Y row (vertical)
		for (int n = 0; n < CHECKER_ROWS; n++) {
			// Controller for BLACK checkers in X row (horizontal)
			for (int i = 0; i < SQUARES_X; i++) {
				if ((i + n) % 2 == 0) {
				GOval checker = new GOval((xStart + SQUARES_SIZE * i) + (SQUARES_SIZE / 5 * 1) / 2 , ((yStart + SQUARES_SIZE * 5)  + SQUARES_SIZE * n) + (SQUARES_SIZE / 5 * 1) / 2 ,CHECKERS_SIZE ,CHECKERS_SIZE );
				checker.setFilled(true);
				checker.setFillColor(Color.BLACK);
			    add(checker);
				}
			}
		}
	}	
}
