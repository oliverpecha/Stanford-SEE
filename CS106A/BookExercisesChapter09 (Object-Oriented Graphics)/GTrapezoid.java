/*
 * File: GTrapezoid.java
 * ----------------
 * This file illustrates the strategy of subclassing GPolygon by
 * creating a new GObject class depicting a trapezoid.
 */

import acm.graphics.*;

/**
 * Defines a new GObject class that appears as a trapezoid.
 */

public class GTrapezoid extends GPolygon {

/**
 * Creates a new GTrapezoid centered at the origin with the indicated
 * horizontal width.
 *
 * @param width The width of the trapezoid
 */
	public GTrapezoid(double width) {	
		double height = 0.6 * width;
		addVertex(-width / 4, -height/2);
		addVertex(width / 4, -height/2);
		addVertex(width / 2, height/2);
		addVertex(-width / 2, height/2);
}

}
