/*
 * File: DrawMemorial.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise Bonus 9
 * -----------------
 * Write a GraphicsProgram that draws the following stylized picture of the Lincoln Memorial in Washington, D.C.:
 */

import acm.graphics.*;
import acm.program.*;

public class DrawMemorial extends GraphicsProgram {
	
	public void init() {
	    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	public void run () {	
		// Bottom level
		add(new GRect(SCREEN_WIDTH / 2 - MEMORIAL_WIDTH / 2, Y_AXIS - LEVEL_HEIGHT, MEMORIAL_WIDTH, LEVEL_HEIGHT));
		// Vertical constructor loop
		for (int n = 0; n < COLUMNS; n++) {
			add(new GRect(X_AXIS - MEMORIAL_WIDTH / 2 + n * (COLUMN_WIDTH + MARGIN_WIDTH), Y_AXIS - LEVEL_HEIGHT - COLUMN_HEIGHT, COLUMN_WIDTH, COLUMN_HEIGHT));
			add(new GOval(X_AXIS - MEMORIAL_WIDTH / 2 + COLUMN_WIDTH / 2 - LIGHT_RADIUS + n * (COLUMN_WIDTH + MARGIN_WIDTH), Y_AXIS - 1.5 * LEVEL_HEIGHT - COLUMN_HEIGHT - LIGHT_RADIUS, 2 * LIGHT_RADIUS, 2 * LIGHT_RADIUS));
		// Lincon
		add(new GRect(SCREEN_WIDTH / 2 - 0.8 * COLUMN_WIDTH / 2, Y_AXIS - LEVEL_HEIGHT - 0.3 * COLUMN_HEIGHT, 0.8 * COLUMN_WIDTH , 0.3 * COLUMN_HEIGHT));
		add(new GOval(SCREEN_WIDTH / 2 - LIGHT_RADIUS, Y_AXIS - LEVEL_HEIGHT - 0.32 * COLUMN_HEIGHT - 2 * LIGHT_RADIUS, 2 * LIGHT_RADIUS, 2 * LIGHT_RADIUS));
		// Roof
		add(new GRect(SCREEN_WIDTH / 2 - MEMORIAL_WIDTH / 2, Y_AXIS - 2 * LEVEL_HEIGHT - COLUMN_HEIGHT, MEMORIAL_WIDTH, LEVEL_HEIGHT));
		add(new GRect(SCREEN_WIDTH / 2 - 0.8 * MEMORIAL_WIDTH / 2, Y_AXIS - 3 * LEVEL_HEIGHT - COLUMN_HEIGHT, 0.8 * MEMORIAL_WIDTH, LEVEL_HEIGHT));
		}
	}
	
	private static final int LEVEL_HEIGHT = 25;
	private static final int COLUMN_WIDTH = 21;
	private static final int COLUMN_HEIGHT = 110;
	private static final int MARGIN_WIDTH = 30;
	private static final int MARGINS = 11;
	private static final int COLUMNS = 12;
	private static final double LIGHT_RADIUS = 0.6 * COLUMN_WIDTH / 2;
	private static final int MEMORIAL_WIDTH = MARGIN_WIDTH * MARGINS + COLUMN_WIDTH * COLUMNS;
	
	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 500;
	
	private static final int X_AXIS = SCREEN_WIDTH / 2;
	private static final int Y_AXIS = SCREEN_HEIGHT;
}


