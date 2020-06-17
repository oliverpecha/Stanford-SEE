/*
 * File: Rainbow.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 9 on chapter 2 of Programming Exercises from the Art of Java.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Rainbow extends GraphicsProgram {	
	public void run() {
		bigCircle();
	}
		
		//Rainbow
		private void bigCircle() {	

			GRect sky = new GRect (-500, -500, 3000, 3000);
		    sky.setColor(Color.CYAN);
		    sky.setFilled(true);
		    sky.setFillColor(Color.CYAN);
	        add(sky);
		        
		    GOval redCircle = new GOval (-275, 25, 1150, 1150);
		    redCircle.setColor(Color.RED);
		    redCircle.setFilled(true);
		    redCircle.setFillColor(Color.RED);
	        add(redCircle);
	        
		    GOval orangeCircle = new GOval (-250, 50, 1100, 1100);
		    orangeCircle.setColor(Color.ORANGE);
		    orangeCircle.setFilled(true);
		    orangeCircle.setFillColor(Color.ORANGE);
	        add(orangeCircle);
	        
	        GOval yellowCircle = new GOval (-225, 75, 1050, 1050);
	        yellowCircle.setColor(Color.YELLOW);
	        yellowCircle.setFilled(true);
	        yellowCircle.setFillColor(Color.YELLOW);
	        add(yellowCircle);
			
			GOval blueCircle = new GOval (-200, 100, 1000, 1000);
	        blueCircle.setColor(Color.BLUE);
	        blueCircle.setFilled(true);
	        blueCircle.setFillColor(Color.BLUE);
	        add(blueCircle);
	        
	        GOval magentaCircle = new GOval (-175, 125, 950, 950);
	        magentaCircle.setColor(Color.MAGENTA);
	        magentaCircle.setFilled(true);
	        magentaCircle.setFillColor(Color.MAGENTA);
	        add(magentaCircle);
	        
	        GOval skyCircle = new GOval (-150, 150, 900, 900);
	        skyCircle.setColor(Color.CYAN);
	        skyCircle.setFilled(true);
	        skyCircle.setFillColor(Color.CYAN);
	        add(skyCircle);
		}
		


}
