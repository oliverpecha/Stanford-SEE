/*
 * File: BuildHouse.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 11 on chapter 3 of Programming Exercises from the Art of Java.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class BuildHouse extends GraphicsProgram {	
	
	private static int HEIGHT = 330;
	private static int WIDHT = 460; 
	
	public void run() {
		
		int xAxis = 300;
		int yAxis = 360;
		int DOOR_HEIGHT = (HEIGHT/3)*2; 
		int DOOR_WIDTH = (WIDHT/5)*1;  
		int DOOR_HANDLE = (DOOR_WIDTH/8)*1; 
		int ROOF_HEIGHT = (HEIGHT/3)*1; 
		int WINDOW_HEIGHT = (HEIGHT/4)*1; 
		double WINDOW_WIDTH = (WIDHT/6)*1.25; 

		//roof
		add(new GLine(xAxis, yAxis-HEIGHT/2-ROOF_HEIGHT, xAxis-WIDHT/2, yAxis-HEIGHT/2));
		add(new GLine(xAxis, yAxis-HEIGHT/2-ROOF_HEIGHT, xAxis+WIDHT/2, yAxis-HEIGHT/2));
		
		//main structure
		//add(new GRect(150, 200, 300, 200 ));
		add(new GRect(xAxis-WIDHT/2, yAxis-HEIGHT/2, WIDHT, HEIGHT));
		
		//door
		add(new GRect(xAxis-DOOR_WIDTH/2, (yAxis+HEIGHT/2)-DOOR_HEIGHT, DOOR_WIDTH, DOOR_HEIGHT));
		add(new GOval(xAxis+DOOR_WIDTH/4, (yAxis+HEIGHT/2)-(DOOR_HEIGHT/3)*2, DOOR_HANDLE, DOOR_HANDLE ));
		
		//windows
		add(new GRect(
				xAxis-WIDHT/2+((WIDHT/5)*2-WINDOW_WIDTH)/2,
				yAxis-WINDOW_HEIGHT,
				WINDOW_WIDTH,
				WINDOW_HEIGHT));
		add(new GRect(
				xAxis+((WIDHT/5)*3-WINDOW_WIDTH)/2,
				yAxis-WINDOW_HEIGHT, 
				WINDOW_WIDTH, 
				WINDOW_HEIGHT ));
		
		// X and Y axis Guide
		// add(new GLine(xAxis, -1000, xAxis, +1000 ));
		// add(new GLine(-1000, yAxis, +1000, yAxis));
	}
	
}
