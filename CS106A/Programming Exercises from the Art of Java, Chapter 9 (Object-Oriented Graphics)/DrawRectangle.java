/*
 * File: DrawRectangle.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 10 / Programming Exercise 4 and Chapter 09 Bonus 12
 * -----------------
 */

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;


public class DrawRectangle extends GraphicsProgram {

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		selectedObj = null;
		mouseAt = new GPoint(e.getPoint());
		selectedObj = getElementAt(mouseAt);
		if (selectedObj == null) {
			rect = new GRect(0,0);
			rect.setFilled(true);
			add(rect,mouseAt);
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		rectCurrent = new GPoint(e.getPoint());
		if (selectedObj != null) {
			GDimension size = selectedObj.getSize();
			selectedObj.setColor(Color.GRAY);
			selectedObj.setLocation(rectCurrent.getX() - size.getWidth() / 2, rectCurrent.getY() - size.getHeight() / 2);
		}
		else {
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
		if (selectedObj != null) selectedObj.setColor(Color.BLACK);
	}
		
	GRect rect;
	GObject selectedObj;
	GPoint mouseAt, rectCurrent, rectEnd;
	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;
}
