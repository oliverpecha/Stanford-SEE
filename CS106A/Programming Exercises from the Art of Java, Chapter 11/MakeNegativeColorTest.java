/*
 * File: MakeNegativeColorTest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 15.
 * -----------------
 */

import acm.program.*;
import acm.graphics.*;

public class MakeNegativeColorTest extends GraphicsProgram {
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		GImage landscape = new GImage("StarryNight.gif");
		GImage landscapeNegative = makeNegativeColor(landscape);
		add(landscape, 20,20);
		landscape.scale(0.5);
		landscapeNegative.scale(0.5);
		add(landscapeNegative, 40 + landscape.getWidth(), 20);
	}
	
	private GImage makeNegativeColor(GImage image) {
		int [][] array = image.getPixelArray();
		int vertical = array.length;
		int horizontal = array[0].length;
		for (int v = 0; v < vertical; v++) {
			for (int h = 0; h < horizontal; h++) {
				// pixel with current position
				int pixel = array[v][h];
				// color inverter operator
				array[v][h] = colorInverter(pixel);
			}
		}		
		return new GImage(array);
	}

	private int colorInverter(int pixel) {
		int red = (pixel >> 16) & 0xFF;
		int green = (pixel >> 8) & 0xFF;
		int blue = pixel & 0xFF;
		red = valueManipulation(red);
		green = valueManipulation(green);
		blue = valueManipulation(blue);
		return (0xFF << 24) | (red << 16) | (green << 8) | blue;
	}
	
	private int valueManipulation(int value) {
		value -= 255;
		if (value < 0) value *= -1;
		return value;
	}
	
	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;
	

}
