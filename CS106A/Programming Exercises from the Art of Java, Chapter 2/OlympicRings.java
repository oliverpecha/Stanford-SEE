/*
 * File: OlympicRings.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 8 on chapter 2.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class OlympicRings extends GraphicsProgram {	
	public void run() {
		blueRing();
		yellowRing();
		bigCircle();
	}
	
		//Rainbow
		private void bigCircle() {	
	        GOval blueCircle = new GOval (-200, 100, 1000, 1000);
	        blueCircle.setColor(Color.BLUE);
	        blueCircle.setFilled(true);
	        blueCircle.setFillColor(Color.BLUE);
	        add(blueCircle);
	        
	        GOval yellowCircle = new GOval (-175, 125, 950, 950);
	        yellowCircle.setColor(Color.YELLOW);
	        yellowCircle.setFilled(true);
	        yellowCircle.setFillColor(Color.YELLOW);
	        add(yellowCircle);
		}
		

		//Blue Ring
		private void blueRing() {	
	        GOval OuterCircle = new GOval (200, 100, 100, 100);
	        OuterCircle.setColor(Color.BLUE);
	        OuterCircle.setFilled(true);
	        OuterCircle.setFillColor(Color.BLUE);
	        add(OuterCircle);
	        
	        GOval innerCircle = new GOval (205, 105, 90, 90);
	        innerCircle.setColor(Color.WHITE);
	        innerCircle.setFilled(true);
	        innerCircle.setFillColor(Color.WHITE);
	        add(innerCircle);
		}
		

		//Yellow Ring
			private void yellowRing() {	
		        GOval firstCircle = new GOval (250, 150, 100, 100);
		        firstCircle.setColor(Color.YELLOW);
		        add(firstCircle);
		        GOval secondCircle = new GOval (251, 151, 98, 98);
		        secondCircle.setColor(Color.YELLOW);
		        add(secondCircle);
		        GOval thirdCircle = new GOval (252, 152, 96, 96);
		        thirdCircle.setColor(Color.YELLOW);			        
		        add(thirdCircle);
			}


}
