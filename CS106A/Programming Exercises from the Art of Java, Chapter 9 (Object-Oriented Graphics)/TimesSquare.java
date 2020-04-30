/*
 * File: TimesSquare.java
 * ----------------------
 * This program displays the text of the string HEADLINE
 * on the screen in an animated way that moves it across
 * the display from left-to-right.
 */

import acm.graphics.*;
import acm.program.*;

public class TimesSquare extends GraphicsProgram {

	public void run() {
		GLabel label = new GLabel(HEADLINE);
		label.setFont("Times-72");
		add(label, getWidth(), (getHeight() + label.getAscent()) / 2);
		while (label.getX() + label.getWidth() > 0) {
			label.move(-DELTA_X, 0);
			pause(PAUSE_TIME);
		}
	}

/* Private constants */
	private static final int DELTA_X = 2;  /* Distance to move each cycle (in pixels)     */
	private static final int PAUSE_TIME = 20;  /* Delay time between cycles (in milliseconds) */

/* String to use as the headline label */
	private static final String HEADLINE =
	  "When \nin the course of human events it becomes necessary " +
	  "for one people to dissolve the political bands which " +
	  "connected them with another . . .";

}
