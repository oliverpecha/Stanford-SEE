/*
 * File: Initials.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise Bonus 5
 * -----------------
 * Write a GraphicsProgram to draw your initials on the graphics window using only the GArc and GLine classes rather than GLabel. 
 * For example, if I wrote this program, I would want the output to be
 * Think about the best decomposition to use in writing the program. Imagine that you’ve been asked to design a more general letter-drawing library. How would you want the methods in that library to behave in order to make using them as simple as possible for your clients?
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class Initials extends GraphicsProgram {
	
	public void init() {
	    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	public void run () {
		int x = SCREEN_WIDTH / 2;
		int y = SCREEN_HEIGHT / 2;
		// O
		add(new GArc(x - 1.5 * CHAR_WIDTH - MARGIN, y -  CHAR_HEIGHT / 2, CHAR_WIDTH, CHAR_WIDTH, 0, 180));		
		add(new GLine(x - 1.5 * CHAR_WIDTH - MARGIN, y -  CHAR_HEIGHT / 2 + CHAR_WIDTH / 2, x - 1.5 * CHAR_WIDTH - MARGIN, y +  CHAR_HEIGHT / 2 - CHAR_WIDTH / 2));
		add(new GLine(x - 0.5 * CHAR_WIDTH - MARGIN, y -  CHAR_HEIGHT / 2 + CHAR_WIDTH / 2, x - 0.5 * CHAR_WIDTH - MARGIN, y +  CHAR_HEIGHT / 2 - CHAR_WIDTH / 2));
		add(new GArc(x - 1.5 * CHAR_WIDTH - MARGIN, y +  CHAR_HEIGHT / 2 - CHAR_WIDTH, CHAR_WIDTH, CHAR_WIDTH, 0, -180));
		// P
		add(new GLine(x - 0.5 * CHAR_WIDTH, y -  CHAR_HEIGHT / 2, x - 0.5 * CHAR_WIDTH, y +  CHAR_HEIGHT / 2));
		add(new GLine(x - 0.5 * CHAR_WIDTH, y -  CHAR_HEIGHT / 2, x - 0 * CHAR_WIDTH, y -  CHAR_HEIGHT / 2));
		add(new GLine(x - 0.5 * CHAR_WIDTH, y -  CHAR_HEIGHT / 2 + CHAR_WIDTH, x - 0 * CHAR_WIDTH, y -  CHAR_HEIGHT / 2 + CHAR_WIDTH));
		add(new GArc(x - 0.5 * CHAR_WIDTH, y -  CHAR_HEIGHT / 2, CHAR_WIDTH, CHAR_WIDTH, 90, -180));
		// G
		add(new GArc(x + 0.5 * CHAR_WIDTH + MARGIN, y -  CHAR_HEIGHT / 2, CHAR_WIDTH, CHAR_WIDTH, 0, 180));		
		add(new GLine(x + 0.5 * CHAR_WIDTH + MARGIN, y -  CHAR_HEIGHT / 2 + CHAR_WIDTH / 2, x + 0.5 * CHAR_WIDTH + MARGIN, y +  CHAR_HEIGHT / 2 - CHAR_WIDTH / 2));
		add(new GLine(x + 1.5 * CHAR_WIDTH + MARGIN, y + MARGIN / 2, x + 1.5 * CHAR_WIDTH + MARGIN, y +  CHAR_HEIGHT / 2 - CHAR_WIDTH / 2));
		add(new GLine(x + 1 * CHAR_WIDTH + MARGIN, y + MARGIN / 2, x + 1.5 * CHAR_WIDTH + MARGIN, y + MARGIN / 2));
		add(new GArc(x + 0.5 * CHAR_WIDTH + MARGIN, y +  CHAR_HEIGHT / 2 - CHAR_WIDTH, CHAR_WIDTH, CHAR_WIDTH, 0, -180));		
	}
	
	
	private static final int CHAR_WIDTH = 160;
	private static final int CHAR_HEIGHT = 300;

	private static final int MARGIN = 50;

	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 500;
}
