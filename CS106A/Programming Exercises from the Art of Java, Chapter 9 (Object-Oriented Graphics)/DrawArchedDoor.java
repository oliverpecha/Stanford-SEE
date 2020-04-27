/*
 * File: DrawArchedDoor.java
 * -------------------------
 * This program tests the GArchedDoor class.
 */

import acm.program.*;

public class DrawArchedDoor extends GraphicsProgram {

	public void run() {
		add(new GArchedDoor(40, 75), getWidth() / 2, (getHeight() + 75) / 2);
	}

}
