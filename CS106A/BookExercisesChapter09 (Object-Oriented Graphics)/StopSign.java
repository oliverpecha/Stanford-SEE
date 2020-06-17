/*
 * File: StopSign.java
 * -------------------
 * This program draws a stop sign.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class StopSign extends GraphicsProgram {

	public void run() {
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		GPolygon sign = createOctagon(EDGE_LENGTH);
		sign.setFilled(true);
		sign.setColor(Color.RED);
		add(sign, cx, cy);
		GLabel stop = new GLabel("STOP");
		stop.setFont("SansSerif-bold-36");
		stop.setColor(Color.WHITE);
		add(stop, cx - stop.getWidth() / 2, cy + stop.getAscent() / 2);
	}

/* Creates a regular octagon with the specified side length */
	private GPolygon createOctagon(double side) {
		GPolygon octagon = new GPolygon();
		octagon.addVertex(-side / 2, side / 2 + side / Math.sqrt(2));
		int angle = 0;
		for (int i = 0; i < 8; i++) {
			octagon.addPolarEdge(side, angle);
			angle += 45;
		}
		return octagon;
	}

/* Private constants */
	private static final double EDGE_LENGTH = 50;

}
