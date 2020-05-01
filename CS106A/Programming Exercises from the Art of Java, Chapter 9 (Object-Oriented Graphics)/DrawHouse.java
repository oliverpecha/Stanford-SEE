/*
 * File: DrawHouse.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise Bonus 7
 * -----------------
 * Write a GrpahicsProgram that draws a line drawing of the house shown on the following diagram:
 * Make sure that you use stepwise refinement to decompose this figure into useful pieces. 
 * */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawHouse extends GraphicsProgram {	
	
	
	// Window parameters
	private static final int WINDOW_MODULE_WIDHT = 30;
	private static final int WINDOW_MODULE_HEIGHT = 50;
	private static final int WINDOW_ROWS = 2;
	
	// Door parameters
	private static final int DOOR_WIDTH = WINDOW_MODULE_WIDHT * 4 / 3 * 2;
	private static final int DOOR_HEIGHT = WINDOW_MODULE_HEIGHT * 3;
	private static final int DOOR_HANDLE_RADIUS = 9;
			
	// House parameters
	private static final int LEVEL_HEIGHT = 200;
	private static final int VERTICAL_DIVISIONS = WINDOW_MODULE_WIDHT;
	private static final int HORIZONTAL_DIVISIONS = 60;
	
	
	public void run() {
		
		int windowBottomColuns = 3;
		int windowTopColuns = 2;
		int windowMaxColuns = Math.max(windowBottomColuns, windowTopColuns);
		int totalHouseWidth = windowMaxColuns * WINDOW_MODULE_WIDHT * 2 + DOOR_WIDTH + WINDOW_MODULE_WIDHT * 6;
		
		screen();
		houseStructure(totalHouseWidth, windowTopColuns);
		roof(totalHouseWidth, windowTopColuns);
		windowsBottom(windowBottomColuns, windowMaxColuns);
		windowsTop(windowTopColuns, windowMaxColuns);
		door();
	}
	

	private void windowsBottom(int windowBottomColuns, int windowMaxCouns) {
		windowGenerator(X_AXIS - (windowMaxCouns * WINDOW_MODULE_WIDHT) / 2 - VERTICAL_DIVISIONS - DOOR_WIDTH / 2, yScreenSize - HORIZONTAL_DIVISIONS - (WINDOW_ROWS * WINDOW_MODULE_HEIGHT) / 2, windowBottomColuns, WINDOW_ROWS);
		windowGenerator(X_AXIS + (windowMaxCouns * WINDOW_MODULE_WIDHT) / 2 + VERTICAL_DIVISIONS + DOOR_WIDTH / 2, yScreenSize - HORIZONTAL_DIVISIONS - (WINDOW_ROWS * WINDOW_MODULE_HEIGHT) / 2, windowBottomColuns, WINDOW_ROWS);
	}
	
	private void windowsTop(int windowTopColuns, int windowMaxCouns) {
		windowGenerator(X_AXIS - (windowMaxCouns * WINDOW_MODULE_WIDHT) / 2 - VERTICAL_DIVISIONS - DOOR_WIDTH / 2, yScreenSize - LEVEL_HEIGHT - HORIZONTAL_DIVISIONS - (WINDOW_ROWS * WINDOW_MODULE_HEIGHT) / 2, windowTopColuns, WINDOW_ROWS);
		windowGenerator(X_AXIS + (windowMaxCouns * WINDOW_MODULE_WIDHT) / 2 + VERTICAL_DIVISIONS + DOOR_WIDTH / 2, yScreenSize - LEVEL_HEIGHT - HORIZONTAL_DIVISIONS - (WINDOW_ROWS * WINDOW_MODULE_HEIGHT) / 2, windowTopColuns, WINDOW_ROWS);
	}

	private void windowGenerator(int x, int y, int xModules, int yModules) {
		for (int i = 0; i < yModules ; i++) {
			for (int n = 0; n < xModules ; n++) {
				add(new GRect(x - xModules * WINDOW_MODULE_WIDHT / 2 + WINDOW_MODULE_WIDHT * n, y - yModules * WINDOW_MODULE_HEIGHT / 2 + WINDOW_MODULE_HEIGHT * i, 
						WINDOW_MODULE_WIDHT, WINDOW_MODULE_HEIGHT));
				System.out.println("x" + x + ", y" + y + ", n" + n + ", i" + i);
			}
		}	
	}
	
	private void houseStructure(int totalHouseWidth, int windowTopColuns) {
		if (windowTopColuns == 0) 		add(new GRect(X_AXIS - totalHouseWidth / 2, Y_AXIS * 2 - LEVEL_HEIGHT, totalHouseWidth , LEVEL_HEIGHT));	
		else if (windowTopColuns > 0) 	add(new GRect(X_AXIS - totalHouseWidth / 2, Y_AXIS * 2 - LEVEL_HEIGHT * 2, totalHouseWidth , LEVEL_HEIGHT * 2));	
	}
	
	private void door() {
		add(new GRect(X_AXIS - DOOR_WIDTH / 2, yScreenSize - DOOR_HEIGHT, DOOR_WIDTH, DOOR_HEIGHT));
		add(new GOval(X_AXIS + DOOR_WIDTH / 4, yScreenSize - DOOR_HEIGHT / 2 - DOOR_HANDLE_RADIUS / 2, DOOR_HANDLE_RADIUS, DOOR_HANDLE_RADIUS));
	}

	private void roof(int totalHouseWidth, int windowTopColuns) {
		
		if (windowTopColuns == 0) {
			add(new GLine(X_AXIS - totalHouseWidth / 2, yScreenSize - LEVEL_HEIGHT, X_AXIS, yScreenSize - LEVEL_HEIGHT * 5 / 3));
			add(new GLine(X_AXIS + totalHouseWidth / 2, yScreenSize - LEVEL_HEIGHT, X_AXIS, yScreenSize - LEVEL_HEIGHT * 5 / 3));
		}
			
		else if (windowTopColuns > 0) {
			add(new GLine(X_AXIS - totalHouseWidth / 2, yScreenSize - LEVEL_HEIGHT * 2, X_AXIS, yScreenSize - LEVEL_HEIGHT - LEVEL_HEIGHT * 5 / 3));
			add(new GLine(X_AXIS + totalHouseWidth / 2, yScreenSize - LEVEL_HEIGHT * 2, X_AXIS, yScreenSize - LEVEL_HEIGHT - LEVEL_HEIGHT * 5 / 3));
		}
		
	}

	
	// Solves the centering screen issue due to getHeigh and getWidth only returning a fixed initial screen of 200px x 200px
		// Parameters that define size of the Theoretical Screen Size
		private static final int xScreenSize = 1000;
		private static final int yScreenSize = 700;
		private static final int X_AXIS = xScreenSize / 2;
		private static final int Y_AXIS = yScreenSize / 2;
			
		// Representation of the Theoretical Screen Size
		private void screen() {
			add(new GRect ( 0, 0, xScreenSize, yScreenSize));
		}
				
		// Creates two lines to illustrate xAxis and yAxis
		private void axis() {
			add(new GLine ( X_AXIS, -3000, X_AXIS, 3000));
			add(new GLine ( -3000, Y_AXIS, 3000, Y_AXIS));
		}
		
}
