/*
 * File: FlipAndRotateTest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 12 & 13.
 * -----------------
 */

import acm.program.*;
import acm.graphics.*;

public class FlipAndRotateTest extends GraphicsProgram {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		GImage woman = new GImage("vermeer.gif");
		woman.scale(0.5);
		GImage womanFlipped = flipHorizontal(woman);
		womanFlipped.scale(0.5);
		GImage womanRotated = rotateLeft(woman);
		womanRotated.scale(0.5);
		add(woman, 20,20);
		add(womanFlipped, 40 + woman.getWidth(),20);
		add(womanRotated, 60 + woman.getWidth() * 2,20);
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
	
	private GImage rotateLeft(GImage image) {
		int [][] array_origin = image.getPixelArray();
		int vertical = array_origin.length;
		int horizontal = array_origin[0].length;
		int [][] array_destination = new int [horizontal][vertical];
		for (int v = 0; v < vertical; v++) {
			for (int h = 0; h < horizontal; h++) {
				int origin = array_origin[v][h];
				array_destination[h][v] = origin;
			}
		}		
		return new GImage(array_destination);
	}
	
	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;
	

}
