/*
 * File: Pyramid.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Write a GraphicsProgram subclass that draws a pyramid consisting of bricks arranged in horizontal rows, 
 * so that the number of bricks in each row decreases by one as you move up the pyramid, as shown in the following sample run:
 * 
 * The pyramid should be centered at the bottom of the window and should use constants for the following parameters:
 * BRICK_WIDTH		The width of each brick (30 pixels)
 * BRICK_HEIGHT		The height of each brick (12 pixels)
 * BRICKS_IN_BASE	The number of bricks in the base (14)
 * The numbers in parentheses show the values for this diagram, but you must be able to change those values in your program.
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {

	public void run () {
		// Representation of the Theoretical Screen Size
		add(new GRect ( 0, 0, xScreenSize, yScreenSize));
		
		// Space for the Pyramid Base
		int firstRawTotalWidth = BRICKS_IN_BASE * BRICK_WIDTH;
		
		// Where first brick starts
		int xStart = (xScreenSize - firstRawTotalWidth)/2;
		int yStart = (yScreenSize - BRICK_HEIGHT);
		
		// Vertical constructor loop
		for (int n = 0; n < (BRICKS_IN_BASE); n++) {
			
			// Horizontal constructor loop
			for (int i = 0; i < BRICKS_IN_BASE-n; i++) {
				System.out.println(BRICKS_IN_BASE-i);
				add(new GRect (xStart+(i*BRICK_WIDTH)+(BRICK_WIDTH*n)/2, yStart-(n*BRICK_HEIGHT), BRICK_WIDTH, BRICK_HEIGHT));
			}
		}
	}
	
	// Parameters that define size of the Theoretical Screen Size
	private static final int xScreenSize = 600;
	private static final int yScreenSize = 400;

	// Parameters that define size of the pyramid
	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_HEIGHT = 12;
	private static final int BRICKS_IN_BASE = 14;
}


