/*
 * File: DrawRectangle.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 4
 * -----------------
 */

import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;

public class DrawRectangle extends GraphicsProgram {

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		addMouseListeners();
		addCenterTarget();
	}
	
	public void mousePressed(MouseEvent e) {
		rectStart = new GPoint(e.getPoint());
		rect = new GRect(0,0);
		rect.setFilled(true);
		add(rect,rectStart);
	}
	
	public void mouseDragged(MouseEvent e) {
		rectCurrent = new GPoint(e.getPoint());
		double xResize = rectCurrent.getX() - rectStart.getX();
		double yResize = rectCurrent.getY() - rectStart.getY();	
		if (xResize < 0 && yResize < 0) {
			rect.setLocation(rectCurrent);
			rect.setSize(xResize * -1, yResize * -1);
		} 
		else if (xResize < 0) {
			rect.setLocation(rectCurrent.getX(), rectStart.getY());
			rect.setSize(xResize * -1, yResize);
		} 
		else if (yResize < 0) {
			rect.setLocation(rectStart.getX(), rectCurrent.getY());
			rect.setSize(xResize, yResize * -1);
		} 
		else {
			rect.setLocation(rectStart);
			rect.setSize(xResize, yResize);
		}
	}

	public void addCenterTarget() {
		add(new GLine(SCREEN_WIDTH / 2, -2000, SCREEN_WIDTH / 2, 2000));
		add(new GLine(-2000, SCREEN_HEIGHT / 2, 2000, SCREEN_HEIGHT / 2));
	}
	
	GRect rect;
	GPoint rectStart, rectCurrent, rectEnd;
	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;
}
