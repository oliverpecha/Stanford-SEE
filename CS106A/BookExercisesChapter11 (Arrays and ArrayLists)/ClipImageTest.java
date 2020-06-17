/*
 * File: ClipImageTest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 14.
 * -----------------
 */


import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;

public class ClipImageTest extends GraphicsProgram {

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		woman = new GImage("vermeer.gif");
		add(woman, MARGIN, MARGIN);
		addMouseListeners();
	}
	
	public GImage getClippedImage(GImage image, GRect clippingRect) {
		int [][] array_origin = image.getPixelArray();
		
		int verticalNew = (int) clippingRect.getHeight();
		int horizontalNew = (int) clippingRect.getWidth();
		
		int verticalStart = (int) clippingRect.getY();
		int horizontalStart = (int) clippingRect.getX();

		int [][] array_destination = new int [verticalNew][horizontalNew];
		
		for (int v = verticalStart - MARGIN; v < verticalStart - MARGIN + verticalNew - 1; v++) {
			for (int h = horizontalStart - MARGIN; h < horizontalStart - MARGIN + horizontalNew - 1; h++) {

				int origin = array_origin[v][h];
				int verticalFormula = v-verticalStart + MARGIN;
				int horizontalFormula = h-horizontalStart + MARGIN;
				
				array_destination[verticalFormula][horizontalFormula] = origin;
			}
		}		
		return new GImage(array_destination);
	}

	public void mousePressed(MouseEvent e) {
		selectedObj = null;
		mouseAt = new GPoint(e.getPoint());
		selectedObj = getElementAt(mouseAt);
		if (selectedObj != null) {
			rect = new GRect(0,0);
			rect.setColor(Color.GREEN);
			add(rect,mouseAt);
		}
	}

	public void mouseDragged(MouseEvent e) {
		rectCurrent = new GPoint(e.getPoint());
		if (selectedObj != null) {
			double xResize = rectCurrent.getX() - mouseAt.getX();
			double yResize = rectCurrent.getY() - mouseAt.getY();	
			if (xResize < 0 && yResize < 0) {
				rect.setLocation(rectCurrent);
				rect.setSize(xResize * -1, yResize * -1);
			} 
			else if (xResize < 0) {
				rect.setLocation(rectCurrent.getX(), mouseAt.getY());
				rect.setSize(xResize * -1, yResize);
			} 
			else if (yResize < 0) {
				rect.setLocation(mouseAt.getX(), rectCurrent.getY());
				rect.setSize(xResize, yResize * -1);
			} 
			else {
				rect.setLocation(mouseAt);
				rect.setSize(xResize, yResize);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		rectEnd = rect.getLocation();
		remove(rect);
		if (rect.getWidth() > 0 && rect.getHeight() > 0) {
			remove(woman);
			GImage clippedWoman = getClippedImage(woman, rect);
			add(clippedWoman, MARGIN, MARGIN);
		}
	}
	
	GRect rect, testRect;
	GImage woman;
	GObject selectedObj;
	GPoint mouseAt, rectCurrent, rectEnd;
	private static final int MARGIN = 20;
	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;

}
