/*
 * File: ImageProcessing.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Section Assignment 6 / Programming Exercise 3
 * -----------------
 */

import acm.program.*;
import acm.graphics.*;

public class ImageProcessing extends GraphicsProgram {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		GImage woman = new GImage("vermeer.gif");
		GImage womanFlipped = flipHorizontal(woman);
		add(woman, 20,20);
		add(womanFlipped, 40 + woman.getWidth(),20);
	}
	
	private GImage flipHorizontal(GImage image) {
		int [][] array = image.getPixelArray();
		int vertical = array.length;
		int horizontal = array[0].length;
		for (int v = 0; v < vertical; v++) {
			for (int h = 0; h < horizontal/2; h++) {
				int origin = array[v][h];
				int temporary = array[v][horizontal - 1 - h];
				array[v][horizontal - 1 - h] = origin;
				array[v][h] = temporary;
			}
		}		
		return new GImage(array);
	}
	

	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;
	

}
