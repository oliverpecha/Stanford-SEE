/*
 * File: GlobalTemperatures.java
 * -----------------------------
 * This program illustrates filling an arc.
 */

import acm.graphics.*;
import acm.program.*;

public class GlobalTemperatures extends GraphicsProgram {

	public void run() {
		GImage graph = new GImage("TemperatureGraph.gif");
		graph.setSize(getWidth(), getHeight());
		add(graph);
	}

}
