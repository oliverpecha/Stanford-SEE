/*
 * File: LenghtConverter.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 10 / Programming Exercise 11
 * -----------------
 */

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import acm.graphics.*;
import acm.gui.DoubleField;
import acm.gui.TableLayout;
import acm.program.*;

public class LenghtConverter extends Program {

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLayout(new TableLayout(3,2));
			leftGroup = measurementsComboBox();
			leftGroup.setSelectedItem("Miles");
			add(leftGroup);	
			rightGroup = measurementsComboBox();
			rightGroup.setSelectedItem("Inches");
			add(rightGroup);	
			leftDoubleField = new DoubleField();
			leftDoubleField.setActionCommand("Convert ->");
			leftDoubleField.addActionListener(this);
			add(leftDoubleField);
			rightDoubleField = new DoubleField();
			rightDoubleField.setActionCommand("<- Convert");
			rightDoubleField.addActionListener(this);
			add(rightDoubleField);
			add(new JButton("Convert ->"));
			add(new JButton("<- Convert"));
		addActionListeners();
		getKeyListeners();
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Convert ->")) {
			measureIndexGiven = leftGroup.getSelectedIndex();
			measureIndexWanted = rightGroup.getSelectedIndex();
			doubleGiven = leftDoubleField.getValue();
			doubleWanted = masterConvertor();
			rightDoubleField.setValue(doubleWanted);
		}
		if (cmd.equals("<- Convert")) {
			measureIndexGiven = rightGroup.getSelectedIndex();
			measureIndexWanted = leftGroup.getSelectedIndex();
			doubleGiven = rightDoubleField.getValue();
			doubleWanted = masterConvertor();
			leftDoubleField.setValue(doubleWanted);
		}
	}
	
	private double masterConvertor() {
		double result = 0;
		// Convert value (doubleGiven) given a type of measure (measureIndexGiven) to inches (true)
		double inInches = inchConvertor(doubleGiven, measureIndexGiven, true);
		// convert inches to measureWanted
		result = inchConvertor(inInches, measureIndexWanted, false);
		return result;
	}
	
	private double inchConvertor(double input, int measureIndex, boolean toInches) {
		double convertingValue = 0;
		double result = 0;
		switch (measureIndex) {
			// from Inches to Inches: nothing
			case 0: convertingValue = 1; break;
			// from Feet to Inches: * by 12
			case 1: convertingValue = 12; break;
			// from Yards to Inches: * by 36
			case 2: convertingValue = 36; break;
			// from Fathoms to Inches: * by 72
			case 3: convertingValue = 72; break;
			// from Rods to Inches: * by 198
			case 4: convertingValue = 198; break;
			// from Furlongs to Inches: * by 7920.02
			case 5: convertingValue = 7920.02; break;	
			// from Miles to Inches: * by 63360
			case 6: convertingValue = 63360; break;
		}
		if (toInches) result = input * convertingValue;
		else result = input / convertingValue;
		return result;
	}
	
	private JComboBox measurementsComboBox() {
		JComboBox measurementsList = new JComboBox();
		measurementsList.addItem("Inches");
		measurementsList.addItem("Feet");
		measurementsList.addItem("Yards");
		measurementsList.addItem("Fathoms");
		measurementsList.addItem("Rods");
		measurementsList.addItem("Furlongs");
		measurementsList.addItem("Miles");
		measurementsList.setEditable(false);
		return measurementsList;
	}
	
	int measureIndexGiven;
	int measureIndexWanted;
	
	double doubleGiven;
	double doubleWanted;
	JComboBox leftGroup;
	JComboBox rightGroup;

	DoubleField leftDoubleField;
	DoubleField rightDoubleField;
	
	private static final int SCREEN_WIDTH = 400;
	private static final int SCREEN_HEIGHT = 150;
}
