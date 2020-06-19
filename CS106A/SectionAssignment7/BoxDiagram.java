/*
 * File: NameCounts.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Section Assignment 7 / Programming Exercise 1
 * -----------------
 */

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.*;

import acm.graphics.*;
import acm.program.*;

public class BoxDiagram extends GraphicsProgram {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_TOTAL_HEIGHT);
		startSouthMenu();
		addActionListeners();
		addMouseListeners();
	}
	
	private void startSouthMenu() {
		JLabel name = new JLabel("Name");
		input = new 	JTextField(15);
		JButton add = new JButton("Add");
		JButton remove = new JButton("Remove");
		JButton clear = new JButton("Clear");
		add(name, SOUTH);
		add(input, SOUTH);
		add(add, SOUTH);
		add(remove, SOUTH);
		add(clear, SOUTH);
	}
	
	JTextField input;
	HashMap<String, BoxedLabel> boxArray = new HashMap<String, BoxedLabel>();
	GObject selectedObj = null;
	
	private static final int SCREEN_WIDTH = 500;
	private static final int SCREEN_HEIGHT = 300;
	private static final int SCREEN_TOTAL_HEIGHT = 320;

	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Add")) {
			boxArray.put(input.getText(), new BoxedLabel(input.getText()));
			add(boxArray.get(input.getText()), SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);
			input.setText("");
		}
		
		if (e.getActionCommand().equals("Remove")) {
			selectedObj = boxArray.get(input.getText());
			if (selectedObj != null) {
				remove(selectedObj);
				boxArray.remove(input.getText());
			}
			input.setText("");
		}
		
		if (e.getActionCommand().equals("Clear")) {
			Iterator bulk = boxArray.keySet().iterator();
			while (bulk.hasNext()) remove(boxArray.get(bulk.next()));
			boxArray.clear();
			input.setText("");
		}
		
	}
	
	public void mousePressed(MouseEvent e) {
		selectedObj = getElementAt(e.getX(), e.getY());
	}
	
	public void mouseDragged(MouseEvent e) {
		if (selectedObj != null) {
			selectedObj.setLocation(e.getX(), e.getY());
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		selectedObj = null;
	}

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * 
 * @author oliverpecha
 */

private class BoxedLabel extends GCompound {
	
	public BoxedLabel(String label) {
		GRect bound = new GRect(BOX_WIDTH, BOX_HEIGHT);
		GLabel name = new GLabel(label);
		name.setFont("-11");
		add(bound, - BOX_WIDTH / 2, - BOX_HEIGHT / 2);
		add(name, - name.getWidth() / 2, name.getAscent() / 3);
	}
		
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
}
}
