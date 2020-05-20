/*
 * File: BitwiseOperatorDemo.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 11.
 * -----------------
 */

import java.awt.Point;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


import acm.gui.*;
import acm.program.*;

public class BitwiseOperatorDemo extends Program {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLayout(new TableLayout(BUTTONS_ROWS, BUTTONS_COLUMNS + 1));
		initJRadioOperator();
		initJButtonArray();
		addActionListeners();
	}
	  
/**
 * Initializer methods
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 	
 */
	private void initJButtonArray() {
		buttonArray = new ArrayList<>(BUTTONS_ROWS);
		for(int i=0; i < BUTTONS_ROWS; i++) {
		    buttonArray.add(new ArrayList());
		}
		fillButtonArray();
		placeButtonArray();
	}

	private void fillButtonArray() {
		for (int v = 0; v < BUTTONS_ROWS; v++) {
		    for (int h = 0; h < BUTTONS_COLUMNS; h++) {
		    	buttonArray.get(v).add(new JButton("0"));
		    }
		}
	}
		
	private void placeButtonArray() {
		String constraint = "width=" + BUTTON_SIZE + " height=" + BUTTON_SIZE;
		for (int v = 0; v < BUTTONS_ROWS; v++) {
		    for (int h = 0; h < BUTTONS_COLUMNS; h++) {
		    	add(buttonArray.get(v).get(h), constraint);
		    }
		}
	}
	
	private void initJRadioOperator() {
		itemListener();
		String itemArray[] = {"&", "^", "|"};
		OperatorChooser = new JComboBox(itemArray);
		OperatorChooser.setName("Bitwise Operator Combo");
		OperatorChooser.addItemListener(itemListener);
		OperatorChooser.setEditable(false);
		OperatorChooser.setSelectedItem(DEFAULT_OPERATOR);
		add(OperatorChooser, "gridheight=3");
	}

/**
 * Operational methods	
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 	
 */
	private Point buttonTriggered(ActionEvent e) {
		int indexV = 0;
		int indexH = -1;
		while (indexH < 0) {
			indexH = buttonArray.get(indexV).indexOf(e.getSource());
			if (indexH == -1) indexV++;
		}
		return new Point(indexV, indexH);
	}
	
	private void buttonValueChange(Point buttonTriggered) {
		JButton button = buttonArray.get(buttonTriggered.x).get(buttonTriggered.y);
		Integer binary = Integer.parseInt(button.getText());
		if (binary == 0) binary = 1;
		else binary = 0;
		button.setText("" + binary);
	}

	private void rowOperator() {
		int zero = Integer.parseInt(rowRetriever(0),2);
		int one = Integer.parseInt(rowRetriever(1),2);
		int result = getCurrentBitWise(zero, one, operator);
		String binaryStr = binaryInConvention(result, BUTTONS_COLUMNS);
		rowReseter(binaryStr, 2);
	}
	
	private int getCurrentBitWise(int zero, int one, char which) {
		int result = 0;
		switch (which) {
		case '&': result = zero&one; break;
		case '^': result = zero^one; break;
		case '|':result = zero|one; break;
		}
		return result;
	}
	
	private String rowRetriever(int rowToRetrive) {
		String result = "";
		for (int i = 0; i < buttonArray.get(rowToRetrive).size(); i++) {
			result += buttonArray.get(rowToRetrive).get(i).getText();
		}
		return result;
	}
	
	private void rowReseter(String binaryStr, int row) {
		for (int i = 0; i < BUTTONS_COLUMNS; i++) {
			char currentChar = binaryStr.charAt(i);
			buttonArray.get(2).get(i).setText("" + currentChar);
		}
	}
	
	private String binaryInConvention(int binary, int desiredLenght) {
		String binaryStr = Integer.toString(binary,2);
		int binaryLength = binaryStr.length();
		int bitsToAdd = desiredLenght - binaryLength;
		String tempStr = "";
		for (int i = 0; i < bitsToAdd; i++) {
			tempStr += "" + 0;
		}
		return tempStr + binaryStr;
	}
	
/**
 * Event handling methods	
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 	
 */
	/** Listen for a button action */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("0") || e.getActionCommand().equals("1")) {
			Point buttonTriggered = buttonTriggered(e);
			if (buttonTriggered.x != 2) {
				buttonValueChange(buttonTriggered);
				rowOperator();
			}
		}
		
	}
	
	private void itemListener() {
		itemListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent event) {
			String rekkk = (String) event.getItem();
			operator =  rekkk.charAt(0);
			rowOperator();
		}
	  };
	}
	  
	
/**
 * Instance	variables and constants
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 	
 */	
	ArrayList<ArrayList<JButton>> buttonArray;
	JComboBox OperatorChooser;
	ItemListener itemListener;
	JComboBox combobox;
	char operator = DEFAULT_OPERATOR;
	int rows = 0;
	int columns = 0;
	
	private static final char DEFAULT_OPERATOR = '&';
	private static final int SCREEN_WIDTH = 600;
	private static final int SCREEN_HEIGHT = 160;
	private static final int BUTTONS_ROWS = 3;
	private static final int BUTTONS_COLUMNS = 8;
	private static final int BUTTON_SIZE = (SCREEN_WIDTH / BUTTONS_COLUMNS) / 2;


}