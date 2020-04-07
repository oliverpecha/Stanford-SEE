/*
 * File: Target.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 5
 * -----------------
 * Rewrite the Target program given in Chapter 2, exercise 5 so that it uses the createFilledCircle method that appears in Figure 5-3. 
 * In addition, change the program so that the target is always centered in the window and so that the number and dimensions of 
 * the circles are controlled by the following named constants:
 * private static final int N_CIRCLES = 5;
 * private static final int OUTER_RADIUS = 75;
 * private static final int INNER_RADIUS = 10; 
 * */


import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	
	
	
	public void run() {
		
		screen();
		//axis();
		
		for (int i = N_CIRCLES; i > 0; i--) {
			if (i % 2 != 0) add(createFilledCircle(X_AXIS , Y_AXIS, OUTER_RADIUS / N_CIRCLES * i, Color.RED));
			else if (true) add(createFilledCircle(X_AXIS , Y_AXIS, OUTER_RADIUS / N_CIRCLES * i, Color.WHITE));

		}



	}
	// Private constants 
	 private static final int N_CIRCLES = 5;
	 private static final int OUTER_RADIUS = 75;
	 private static final int INNER_RADIUS = 10;
	 

	
	
	//Creates a circular GOval object centered at (x, y) with radius r. The GOval is set to be filled and colored in the specified color.
	private GOval createFilledCircle(double x, double y, double r, Color color) {
		GOval circle = new GOval(x - r, y - r, 2 * r, 2 * r);
		circle.setColor(color);
		circle.setFilled(true);
		return circle;
	}

	// Parameters that define size of the Theoretical Screen Size
	private static final int xScreenSize = 600;
	private static final int yScreenSize = 400;
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
