/*
 * File: GStar.java
 * ----------------
 * This file illustrates the strategy of subclassing GPolygon by
 * creating a new GObject class depicting a diamond.
 */

import acm.graphics.*;

/**
 * Defines a new GObject class that appears as a diamond.
 */

public class GDiamond extends GPolygon {

/**
 * Creates a new GDiamond centered at the origin with the indicated
 * horizontal width.
 *
 * @param width The width of the diamond
 */
	public GDiamond(double width) {	
		double height = 1.1 * width;
		width = 0.8 * width;
		addVertex(-width / 2, 0);
		addVertex(0, -height / 2);
		addVertex(width / 2, 0);
		addVertex(0, height / 2);
	}

}
