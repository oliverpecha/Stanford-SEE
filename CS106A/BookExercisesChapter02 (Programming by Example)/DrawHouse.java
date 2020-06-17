/*
 * File: DrawHouse.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 4 on chapter 2 of Programming Exercises from the Art of Java.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawHouse extends GraphicsProgram {	
	public void run() {

		//roof
		add(new GLine(300, 100, 150, 200 ));
		add(new GLine(300, 100, 450, 200 ));
		
		//main structure
		add(new GRect(150, 200, 300, 200 ));
		
		//door
		add(new GRect(270, 300, 60, 100 ));
		add(new GOval(315, 350, 10, 10 ));
		
		//windows
		add(new GRect(170, 250, 80, 80 ));
		add(new GRect(350, 250, 80, 80 ));


	}
}
