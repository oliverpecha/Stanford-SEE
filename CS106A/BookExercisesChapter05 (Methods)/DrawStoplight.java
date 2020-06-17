/*
 * File: DrawStoplight.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 6
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

public class DrawStoplight extends GraphicsProgram {

	public void run() {
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		double fx = cx - FRAME_WIDTH / 2;
		double fy = cy - FRAME_HEIGHT / 2;
		double dy = FRAME_HEIGHT / 4 + LAMP_RADIUS / 2;
		
		add(createFilledRect(fx, fy, FRAME_WIDTH, FRAME_HEIGHT, Color.GRAY));
		add(createFilledCircle(cx, cy - dy, LAMP_RADIUS, Color.RED));
		add(createFilledCircle(cx, cy, LAMP_RADIUS, Color.YELLOW));
		add(createFilledCircle(cx, cy + dy, LAMP_RADIUS, Color.GREEN));
	}

/*
 * Creates a circular GOval object centered at (x, y) with radius r.
 * The GOval is set to be filled and colored in the specified color.
 */
	private GOval createFilledCircle(double x, double y, double r, Color color) {
		GOval circle = new GOval(x - r, y - r, 2 * r, 2 * r);
		circle.setColor(color);
		circle.setFilled(true);
		return circle;
	}
/*
 * Creates a vertical GRect object at (x, y) location with size of width and height.
 * The GRect is set to be filled and colored in the specified color.
 */
	private GRect createFilledRect(double x, double y, double width, double height, Color color) {
		GRect rectangle = new GRect(x, y, width, height);
		rectangle.setColor(color);
		rectangle.setFilled(true);
		return rectangle;
	}

/* Private constants */
	private static final double FRAME_WIDTH = 50;
	private static final double FRAME_HEIGHT = 100;
	private static final double LAMP_RADIUS = 10;

}
