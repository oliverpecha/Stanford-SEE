/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	// Parameters that define size of the Theoretical Screen Size
	private static final int BOX_WIDTH = 120;
	private static final int BOX_HEIGHT = 30;
	private static final int SEPARATION_WIDTH = BOX_WIDTH / 4;
	private static final int SEPARATION_HEIGHT = BOX_HEIGHT;
	
	// Parameters that define size of the Theoretical Screen Size
	private static final int xScreenSize = 600;
	private static final int yScreenSize = 400;
		
	public void run() {

		int columCentral = xScreenSize / 2;
		int columLeft = columCentral - SEPARATION_WIDTH - BOX_WIDTH;
		int columRight = columCentral + SEPARATION_WIDTH + BOX_WIDTH;
		int yAxis = yScreenSize / 2;
		int topRow = (yScreenSize / 2) - BOX_HEIGHT;
		int bottomRow = (yScreenSize / 2) + BOX_HEIGHT;
		
		screenFrame();
		
		
		add(new GRect (columCentral - BOX_WIDTH / 2, yAxis - BOX_HEIGHT / 2 - BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT));
		GLabel labelProgram = new GLabel("Program");
        add(labelProgram, columCentral - labelProgram.getWidth()/2, topRow + labelProgram.getAscent()/3*1);
		
        add(new GRect (columCentral - BOX_WIDTH / 2, yAxis + BOX_HEIGHT / 2, BOX_WIDTH, BOX_HEIGHT));
		GLabel labelConsoleP = new GLabel("ConsoleProgram");
        add(labelConsoleP, columCentral - labelConsoleP.getWidth()/2, bottomRow + labelConsoleP.getAscent()/3*1);
        
		add(new GRect ( columCentral - BOX_WIDTH / 2 - SEPARATION_WIDTH - BOX_WIDTH, 	yAxis + BOX_HEIGHT / 2, BOX_WIDTH, BOX_HEIGHT));
		GLabel labelGraphicsP = new GLabel("GraphicsProgram");
        add(labelGraphicsP, columLeft - labelGraphicsP.getWidth()/2, bottomRow + labelGraphicsP.getAscent()/3*1);
        
		add(new GRect (columCentral + BOX_WIDTH / 2 + SEPARATION_WIDTH, yAxis + BOX_HEIGHT / 2, BOX_WIDTH, BOX_HEIGHT));
		GLabel labelDialogP = new GLabel("DialogProgram");
        add(labelDialogP, columRight - labelDialogP.getWidth()/2, bottomRow + labelDialogP.getAscent()/3*1);

		add(new GLine (columCentral, yAxis - SEPARATION_HEIGHT / 2, columCentral, yAxis + SEPARATION_HEIGHT / 2));
		add(new GLine (columCentral, yAxis - SEPARATION_HEIGHT / 2, columLeft, yAxis + SEPARATION_HEIGHT / 2));
		add(new GLine (columCentral, yAxis - SEPARATION_HEIGHT / 2, columRight, yAxis + SEPARATION_HEIGHT / 2));
		
		
		
	}

	// Representation of the Theoretical Screen Size
	private void screenFrame() {
		add(new GRect ( 0, 0, xScreenSize, yScreenSize));
	}
			
	
}
