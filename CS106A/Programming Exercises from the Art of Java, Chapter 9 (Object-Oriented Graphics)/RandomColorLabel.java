/*
 * File: RandomColorLabel.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 3
 * -----------------
 * Write a GraphicsProgram that creates GLabels for each of the color names RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, and MAGENTA, 
 * and then puts those labels up on the screen in a random position. The color of each label, however, should be randomly chosen 
 * from the other colors in this list, so that the GLabel for GREEN is allowed to be any color except green. Some people find it 
 * hard to identify the color of a label when the text says one thing, but the color says another.
 */

import acm.program.*;
import acm.util.RandomGenerator;
import java.awt.Color;
import acm.graphics.*;

public class RandomColorLabel extends GraphicsProgram {

	RandomGenerator luck = new RandomGenerator();

	public void init() {
	    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	public void run() {
		int randomColor = 0;
		int randomXPosition = 0;
		int randomYPosition = 0;
		int LabelWidth = 0;
		int LabelHeight = 0;
		GLabel changingLabel = new GLabel(" ");
			while (true) {
				randomColor = luck.nextInt(1,7);
				changingLabel.setLabel(colorStringAssigner(randomColor));
				changingLabel.setColor(colorAssigner(randomColor));
				changingLabel.setFont((String)"-" + FONT_SIZE);
				LabelWidth = (int) changingLabel.getWidth();
				LabelHeight = (int) changingLabel.getHeight();
				randomXPosition = luck.nextInt(0, SCREEN_WIDTH - LabelWidth);
				randomYPosition = luck.nextInt(0 + LabelHeight, SCREEN_HEIGHT - (int) changingLabel.getAscent());
				add (changingLabel, randomXPosition, randomYPosition);
				pause(PAUSE);
			}
	}
	
	private String colorStringAssigner(int number) {
		String result = null;
		switch (number) {
		case 1: result = RED; break;
		case 2: result = ORANGE; break;
		case 3: result = YELLOW; break;
		case 4: result = GREEN; break;
		case 5: result = CYAN; break;
		case 6: result = BLUE; break;
		case 7: result = MAGENTA; break;
		}
		return result;
	}
	
	private Color colorAssigner(int number) {
		Color result = null;
		Color randomColor = luck.nextColor();
		if (number == 1) {
			while (true) {
				if (randomColor != Color.RED) {
					result = randomColor; break;
				} 
				randomColor = luck.nextColor();
			}
		} else if (number == 2) {
			while (true) {
				if (randomColor != Color.ORANGE) {
					result = randomColor; break;
				} 
				randomColor = luck.nextColor();
			}
		} else if (number == 3) {
			while (true) {
				if (randomColor != Color.YELLOW) {
					result = randomColor; break;
				} 
				randomColor = luck.nextColor();
			}
		} else if (number == 4) {
			while (true) {
				if (randomColor != Color.GREEN) {
					result = randomColor; break;
				} 
				randomColor = luck.nextColor();
			}
		} else if (number == 5) {
			while (true) {
				if (randomColor != Color.CYAN) {
					result = randomColor; break;
				} 
				randomColor = luck.nextColor();
			}
		} else if (number == 6) {
			while (true) {
				if (randomColor != Color.BLUE) {
					result = randomColor; break;
				} 
				randomColor = luck.nextColor();
			}
		} else if (number == 7) {
			while (true) {
				if (randomColor != Color.MAGENTA) {
					result = randomColor; break;
				} 
				randomColor = luck.nextColor();
			}
		}    
		return result;
	}
	
	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 500;
	private static final int PAUSE = 4000; 
	private static final int FONT_SIZE = 160;
	private static final String RED = "Red"; 
	private static final String ORANGE = "Orange"; 
	private static final String YELLOW = "Yellow"; 
	private static final String GREEN = "Green"; 
	private static final String CYAN = "Cyan"; 
	private static final String BLUE = "Blue"; 
	private static final String MAGENTA = "Magenta"; 
	
}
