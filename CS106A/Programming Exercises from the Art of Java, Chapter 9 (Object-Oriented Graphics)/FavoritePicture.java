/*
 * File: FavoritePicture.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 1
 * -----------------
 * Download or scan one of your favorite pictures or cartoons into an image file and then write a GraphicsProgram that
 * displays it on the screen, along with a citation indicating the source.
 */

import acm.graphics.*;
import acm.program.*;

public class FavoritePicture extends GraphicsProgram {

/* Private constants */
	private static final String CITATION_FONT = "SansSerif-10";
	private static final int CITATION_MARGIN = 13;

/* Set the dimensions of the window */
	private static final int APPLICATION_WIDTH = 600;
    private static final int APPLICATION_HEIGHT = 600 + CITATION_MARGIN;
    private static final int PAUSE = 10; 
	
    public void run() {
        this.resize(APPLICATION_WIDTH,APPLICATION_HEIGHT);
        pause(PAUSE);
		add(new GImage("tarantino.jpg"));
		addCitation("Downloaded from the Internet ");
	}

/* Adds a citation label at the lower right of the canvas */
	private void addCitation(String text) {
		GLabel label = new GLabel(text);
		label.setFont(CITATION_FONT);
		double x = getWidth() - label.getWidth();
		double y = getHeight() - CITATION_MARGIN + label.getAscent();
		add(label, x, y);
	}
}
