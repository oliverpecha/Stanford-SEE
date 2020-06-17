/*
 * File: GArchedDoor.java
 * ----------------------
 * This class illustrates the use of the addArc method by
 * drawing an arched door.
 */

import acm.graphics.*;

/**
 * This class represents a rectangular doorway topped by a
 * semicircular arch.  The reference point is the bottom
 * center of the door.
 */
public class GArchedDoor extends GPolygon {

/** Creates a new ArchedDoor object with the specified dimensions */
	public GArchedDoor(double width, double height) {
		double straightVerticalLength = height - width / 2;
		addVertex(-width / 2, 0);
		addEdge(width, 0);
		addEdge(0, -straightVerticalLength);
		addArc(width, width, 0, 180);
		addEdge(0, straightVerticalLength);
	}

}
