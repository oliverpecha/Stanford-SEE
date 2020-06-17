/*
 * File: SimpleDraw.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 10 / Programming Exercise 5
 * -----------------
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.MouseEvent;

public class SimpleDraw extends GraphicsProgram {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		addMouseListeners();
		for (int i = 0; i <= 4; i++) {
			GObject button = buttonAssigner(i);
			add(button, MARGIN_M, MARGIN_M + ICON_FRAME * i + MARGIN_S * i);
		}
	}
	
/*
 * Helper method to initiate and assign corresponding buttons to the canvas
 */	
	private GObject buttonAssigner(int order) {
		GObject buttonReturned = null;
		switch (order) {
			case 0: buttonReturned = new ButtonRectFilled(ICON_FRAME); break;
			case 1: buttonReturned = new ButtonRect(ICON_FRAME); break;
			case 2: buttonReturned = new ButtonOvalFilled(ICON_FRAME); break;
			case 3: buttonReturned = new ButtonOval(ICON_FRAME); break;
			case 4: buttonReturned = new ButtonLine(ICON_FRAME); break;
		}
		return buttonReturned;
	}

/*
 * MouseListeners
 */
	public void mouseClicked(MouseEvent e) {
		current = new GPoint(e.getPoint());
		currentObj = getElementAt(current);
		if (currentObj != null) {
			String toolHelper = "" + currentObj;
			int p1 = toolHelper.indexOf('$');
			if (p1 >= 0) {
				int p2 = toolHelper.indexOf('[');
				tool = toolHelper.substring(p1 + 1, p2);
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		start = new GPoint(e.getPoint());
		if (tool != null) {
			if (tool.equals("ButtonRectFilled")) {
				rect = new GRect(0,0);
				rect.setFilled(true);	
			}
			else if (tool.equals("ButtonRect")) {
				rect = new GRect(0,0);
				rect.setFilled(false);
			}
			else if (tool.equals("ButtonOvalFilled")) {
				oval = new GOval(0,0);
				oval.setFilled(true);
			}
			else if (tool.equals("ButtonOval")) {
				oval = new GOval(0,0);
				oval.setFilled(false);
			}
			else if (tool.equals("ButtonLine")) {
				line = new GLine(start.getX(), start.getY(), start.getX(), start.getY());
			}
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		current = new GPoint(e.getPoint());
		if (tool != null) {
			if (tool.equals("ButtonRectFilled") || tool.equals("ButtonRect")) {
				double xResize = current.getX() - start.getX();
				double yResize = current.getY() - start.getY();	
				add(rect, start);
				if (xResize < 0 && yResize < 0) {
					rect.setLocation(current);
					rect.setSize(xResize * -1, yResize * -1);
				} 
				else if (xResize < 0) {
					rect.setLocation(current.getX(), start.getY());
					rect.setSize(xResize * -1, yResize);
				} 
				else if (yResize < 0) {
					rect.setLocation(start.getX(), current.getY());
					rect.setSize(xResize, yResize * -1);
				} 
				else {
					rect.setLocation(start);
					rect.setSize(xResize, yResize);
				}
			}
			else if (tool.equals("ButtonOvalFilled") || tool.equals("ButtonOval")) {
				double xResize = current.getX() - start.getX();
				double yResize = current.getY() - start.getY();	
				add(oval, start);
				if (xResize < 0 && yResize < 0) {
					oval.setLocation(current);
					oval.setSize(xResize * -1, yResize * -1);
				} 
				else if (xResize < 0) {
					oval.setLocation(current.getX(), start.getY());
					oval.setSize(xResize * -1, yResize);
				} 
				else if (yResize < 0) {
					oval.setLocation(start.getX(), current.getY());
					oval.setSize(xResize, yResize * -1);
				} 
				else {
					oval.setLocation(start);
					oval.setSize(xResize, yResize);
				}
			}
			else if (tool.equals("ButtonLine")) {
				add(line);
				line.setEndPoint(current.getX(), current.getY());
			}
		}
	} 
	
/*
 * This classes define the aspect and positions of functional buttons that represent a set of drawing functions.
 * 
 * Original class is a Button, which draws a frame with a given size around it.
 * 
 * Rest of classes draw an icon inside the button, and the ones ending in "Filled" make the icon filled
 */
	
	class Button extends GCompound {
		public Button(double size) {
			GRect frame = new GRect (size, size);
			add(frame, 0, 0);
		}
	}
	
	class ButtonRect extends Button {
		public ButtonRect(double size) {
			super(size);
			iconRect = new GRect (size * ICON_WIDTH, size * ICON_HEIGHT);
			add(iconRect, (size - iconRect.getWidth()) / 2,  (size -iconRect.getHeight()) / 2);
		}
	}
	
	class ButtonRectFilled extends ButtonRect {
		public ButtonRectFilled(double size) {
			super(size);
			iconRect.setFilled(true);
		}
	}
	
	class ButtonOval extends Button {
		public ButtonOval(double size) {
			super(size);
			iconOval = new GOval (size * ICON_WIDTH, size * ICON_HEIGHT);
			add(iconOval, (size - iconOval.getWidth()) / 2,  (size -iconOval.getHeight()) / 2);
		}
	}
	
	class ButtonOvalFilled extends ButtonOval {
		public ButtonOvalFilled(double size) {
			super(size);
			iconOval.setFilled(true);
		}
	}
	
	class ButtonLine extends Button {
		public ButtonLine(double size) {
			super(size);
			add (new GLine ((size - size * ICON_WIDTH) / 2 + size * ICON_WIDTH, (size - size * ICON_HEIGHT) / 2, 
							(size - size * ICON_WIDTH) / 2, ((size - size * ICON_HEIGHT) / 2) + size * ICON_HEIGHT));
		}
	}
	
/*
 * Instance variables and constants
 */	
	String tool;
	GRect rect, iconRect;
	GOval oval, iconOval;
	GLine line;
	GPoint start, current;
	GObject currentObj;
	private static final int SCREEN_WIDTH = 900;
	private static final int SCREEN_HEIGHT = 500;
	private static final double MARGIN_S = 0.02 * SCREEN_HEIGHT;
	private static final double MARGIN_M = 0.03 * SCREEN_HEIGHT;
	private static final double ICON_FRAME = 0.1 * SCREEN_HEIGHT;
	private static final double ICON_WIDTH = 0.7;
	private static final double ICON_HEIGHT = 0.4;




	
}
