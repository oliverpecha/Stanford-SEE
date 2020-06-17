/*
 * File: DrawDiamond.java
 * ----------------------
 * This program draws a diamond-shaped polygon.
 */

import acm.graphics.*;
import acm.program.*;

public class DrawDiamond extends GraphicsProgram {

	public void run() {
		GPolygon diamond = new GPolygon();
		diamond.addVertex(-DIAMOND_WIDTH / 2, 0);
		diamond.addVertex(0, DIAMOND_HEIGHT / 2);
		diamond.addVertex(DIAMOND_WIDTH / 2, 0);
		diamond.addVertex(0, -DIAMOND_HEIGHT / 2);
		add(diamond, getWidth() / 2, getHeight() / 2);
	}

	private static final double DIAMOND_WIDTH = 44;
	private static final double DIAMOND_HEIGHT = 72;

}
