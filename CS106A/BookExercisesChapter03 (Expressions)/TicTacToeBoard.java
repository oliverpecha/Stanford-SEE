/*
 * File: TicTacToeBoard.java
 * -------------------------
 * This program draws a Tic-Tac-Toe board as an illustration
 * of the GLine class.  The version uses explicit coordinate
 * values which makes the program difficult to extend or
 * maintain.  In Chapter 3, you will learn how to constants
 * and expressions to calculate these coordinate values.
 */

import acm.graphics.*;
import acm.program.*;

public class TicTacToeBoard extends GraphicsProgram {
	
	private static final int BOARD_SIZE = 90;
	private static final int SPACE = 30;
	
	public void run() {
		
		int width = getWidth();
		int height = getHeight();
		int yAxis = width / 2;
		int xAxis = height / 2;
		
		add(new GLine(yAxis - BOARD_SIZE / 2, xAxis - SPACE / 2, yAxis + BOARD_SIZE / 2, xAxis - SPACE / 2));		
		add(new GLine(yAxis - BOARD_SIZE / 2, xAxis + SPACE / 2, yAxis + BOARD_SIZE / 2, xAxis + SPACE / 2));		
		add(new GLine(yAxis - SPACE / 2, xAxis - BOARD_SIZE / 2, yAxis - SPACE / 2, xAxis + BOARD_SIZE / 2));		
		add(new GLine(yAxis + SPACE / 2, xAxis - BOARD_SIZE / 2, yAxis + SPACE / 2, xAxis + BOARD_SIZE / 2));
		
		System.out.println("width is: " + width ); 
		System.out.println("height is: " + height ); 
		System.out.println("xAxis is: " + xAxis );
		System.out.println("yAxis is: " + yAxis );
	}
}
