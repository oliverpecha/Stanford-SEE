/*
 * File: DrawStar.java
 * -------------------
 * This program draws a five-pointed star.
 */

import acm.program.*;

public class DrawStar extends GraphicsProgram {

	public void run() {
		add(new GStar(100), getWidth() / 2, getHeight() / 2);
	}

}
