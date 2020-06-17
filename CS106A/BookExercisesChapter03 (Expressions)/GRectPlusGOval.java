/*
 * File: GRectPlusGOval.java
 * -------------------------
 * This program creates a red GRect and a green GOval using
 * the same parameters.  The example illustrates that the
 * GOval fills the boundary set by the enclosing rectangle.
 * This version takes the width and height of the figure from
 * named constants and computes the location of the figure so
 * that it is centered in the window.  Changing the value of the
 * constants changes the dimension of the figure on the screen.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class GRectPlusGOval extends GraphicsProgram {

	public void run() {
		double x = (getWidth() - FIGURE_WIDTH) / 2;
		double y = (getHeight() - FIGURE_HEIGHT) / 2;
		GRect rect = new GRect(x, y, FIGURE_WIDTH, FIGURE_HEIGHT);
		rect.setFilled(true);
		rect.setColor(Color.RED);
		add(rect);
		GOval oval = new GOval(x, y, FIGURE_WIDTH, FIGURE_HEIGHT);
		oval.setFilled(true);
		oval.setFillColor(Color.GREEN);
		add(oval);
	}

/* Private constants */
	private static final double FIGURE_WIDTH = 125;
	private static final double FIGURE_HEIGHT = 75;

}
