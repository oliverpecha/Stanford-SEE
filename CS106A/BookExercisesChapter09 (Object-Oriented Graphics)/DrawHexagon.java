/*
 * File: DrawHexagon.java
 * ----------------------
 * This program illustrates the use of the createHexagon
 * method that creates a regular hexagon.
 */

import acm.graphics.*;
import acm.program.*;

public class DrawHexagon extends GraphicsProgram {

	public void run() {
		add(createHexagon(50), getWidth() / 2, getHeight() / 2);
	}

/* Creates a regular hexagon with the specified side length */
	private GPolygon createHexagon(double side) {
		GPolygon hex = new GPolygon();
		hex.addVertex(-side, 0);
		int angle = 60;
		for (int i = 0; i < 6; i++) {
			hex.addPolarEdge(side, angle);
			angle -= 60;
		}
		return hex;
	}

}
