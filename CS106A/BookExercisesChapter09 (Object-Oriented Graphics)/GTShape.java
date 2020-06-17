/*
 * File: GStar.java
 * ----------------
 * This file illustrates the strategy of subclassing GPolygon by
 * creating a new GObject class depicting a a T shape.
 */

import acm.graphics.*;

/**
 * Defines a new GObject class that appears as a T shape.
 */

public class GTShape extends GPolygon {

/**
 * Creates a new GTShape shape centered at the origin with the indicated
 * horizontal width.
 *
 * @param width The width of the T shape
 */
	public GTShape(double width) {	
		double height = 1.1 * width;
		double edge = width / 3;
		addVertex(-width / 2, -height / 2);
		addVertex(width / 2, -height / 2);
		addVertex(width / 2, -height / 2 + edge);
		addVertex(0 + edge / 2, -height / 2 + edge);
		addVertex(0 + edge / 2, height / 2);
		addVertex(0 - edge / 2, height / 2);
		addVertex(0 - edge / 2, -height / 2 + edge);
		addVertex(-width / 2, -height / 2 + edge );

	}

}
