/*
 * File: AreaCircle.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This program calculates the area of a circle.
 */

import acm.program.*;

public class AreaCircle extends ConsoleProgram {

	public void run() {
		println("Circle area calculation program.");
		double circleRadius = readDouble("Enter circle radius: ");
		double circleArea = PI_NUMBER * (circleRadius*circleRadius);
		println("Circle area = " + circleArea);	
	}

	/* Private constants */
	private static final double PI_NUMBER = 3.14;
}
