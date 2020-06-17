/*
 * File: DrawHouseOfUsher.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise Bonus 8
 * -----------------
 * If you wanted a house to go along with the Halloween pumpkin you designed in exercise 5, you might want to draw a diagram of the 
 * House of Usher, which Edgar Allen Poe describes as follows:
 * I looked upon the scene before me . . . upon the bleak walls—upon the vacant eye-like windows . . . with an utter desperation 
 * of soul . . .
 * From Poe’s description, you might imagine a house that looks something like this:
 * Write a GrpahicsProgram that draws a line drawing of the house shown on the following diagram:
 * Make sure that you use stepwise refinement to decompose this figure into useful pieces. 
 * */

import acm.graphics.*;
import acm.program.*;

public class DrawHouseOfUsher extends GraphicsProgram {	
	
	public void init() {
	    setSize(xScreenSize, yScreenSize);
	}
	
	public void run() {
		
		int houseWidth = 200;
		int houseHeigth = 230;
		int windowsRadius = 30;		
		house(houseWidth, houseHeigth, windowsRadius);
	}
	
	private void house(int houseWidth, int houseHeigth, int windowsRadius) {
		int defenseTowerWidth = houseWidth / 3;
		int defenseTowerHeight = houseHeigth * 4 / 3;
		int entryGateWidht = houseWidth / 5;
		int entryGateHeight = houseHeigth / 3;
		// Main Compartment
		towerGenerator(HOUSE_CENTER, houseWidth, houseHeigth, houseHeigth / 6 * 4);
		// DefenseTowers
		towerGenerator(HOUSE_CENTER - houseWidth / 2 - defenseTowerWidth / 2, defenseTowerWidth, defenseTowerHeight, defenseTowerHeight / 6 * 2);
		towerGenerator(HOUSE_CENTER + houseWidth / 2 + defenseTowerWidth / 2, defenseTowerWidth, defenseTowerHeight, defenseTowerHeight / 6 * 2);
		// Entry Gate
		towerGenerator(HOUSE_CENTER, entryGateWidht, entryGateHeight, entryGateHeight / 4 * 2);
		// Windows
		add(new GRect(HOUSE_CENTER + houseWidth / 4 - windowsRadius / 2, GROUND - houseHeigth / 4 * 3, windowsRadius, windowsRadius));
		add(new GRect(HOUSE_CENTER - houseWidth / 4 - windowsRadius / 2, GROUND - houseHeigth / 4 * 3, windowsRadius, windowsRadius));
	}
	
	
	private void towerGenerator(int x, int towerWidth, int towerHeight, int roofHeight) {
		add(new GRect(x - towerWidth / 2, GROUND - towerHeight, towerWidth, towerHeight));
		add(new GLine(x - towerWidth / 2, GROUND - towerHeight, x, GROUND - towerHeight - roofHeight));
		add(new GLine(x, GROUND - towerHeight - roofHeight,  x + towerWidth / 2, GROUND - towerHeight));		
	}
	
	// Solves the centering screen issue due to getHeigh and getWidth only returning a fixed initial screen of 200px x 200px
		// Parameters that define size of the Theoretical Screen Size
		private static final int xScreenSize = 700;
		private static final int yScreenSize = 500;
		private static final int HOUSE_CENTER = xScreenSize / 2;
		private static final int GROUND = yScreenSize;
			
		// Representation of the Theoretical Screen Size
		private void screen() {
			add(new GRect ( 0, 0, xScreenSize, yScreenSize));
		}
		
}
