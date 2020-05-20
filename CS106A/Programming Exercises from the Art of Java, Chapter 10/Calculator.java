/*
 * File: Calculator.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 10 / Programming Exercise 12
 * -----------------
 * This program implements a calculator as an illustration of the TableLayout
 * class.
 */

import acm.gui.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** This program implements a simple four-function calculator. */
public class Calculator extends Program {

/* Initialize the user interface */
	public void init() {
		setSize(220,320);
		setLayout(new TableLayout(6, 4));
		display = new CalculatorDisplay();
		add(display, "gridwidth=4 height=" + BUTTON_SIZE);
		addButtons();
		addActionListeners();
	}

/* Called in response to an action event */
	public void actionPerformed(ActionEvent e) {
		System.out.println("e.getSource() " + e.getSource());
		((CalculatorButton) e.getSource()).action(display);
	}

/* Adds the buttons to the calculator */
	private void addButtons() {
		String constraint = "width=" + BUTTON_SIZE + " height=" + BUTTON_SIZE;
		String constraintForEquals = "gridwidth=4 height=" + BUTTON_SIZE;
		add(new DigitButton(7), constraint);
		add(new DigitButton(8), constraint);
		add(new DigitButton(9), constraint);
		add(new AddButton(), constraint);
		add(new DigitButton(4), constraint);
		add(new DigitButton(5), constraint);
		add(new DigitButton(6), constraint);
		add(new SubtractButton(), constraint);
		add(new DigitButton(1), constraint);
		add(new DigitButton(2), constraint);
		add(new DigitButton(3), constraint);
		add(new MultiplyButton(), constraint);
		add(new ClearButton(), constraint);
		add(new DigitButton(0), constraint);
		add(new DecimalButton(), constraint);
		add(new DivideButton(), constraint);
		add(new EqualsButton(), constraintForEquals);
	}

/* Private constants */
	private static final int BUTTON_SIZE = 50;

/* Private instance variables */
	private CalculatorDisplay display;
}

/*
 * This class defines the display for the calculator.
 *
 * Implementation notes:
 *   This class does most of the work for the calculator application and keeps
 *   track not only of the number currently in the display but also the previous
 *   operator button (op) and the previous value from the display (memory), which
 *   will become the left operand of the operator.  When a new operator button is
 *   pressed, this class calculates the new value of the display by applying
 *   that operator to the value in memory and the current value in the display.
 *
 *   It is also important to note that the behavior of digit buttons depends on
 *   whether an operator button is clicked.  If the last click was an operator
 *   button, the digit buttons must clear the display to start a new value.  If
 *   not, the digit is added to the end of the existing value.  The code uses the
 *   boolean variable startNewValue to record this state.
 */
class CalculatorDisplay extends DoubleField {

/* Creates a new calculator display that is not directly editable by the user */
	public CalculatorDisplay() {
		setEditable(false);
		setFont(new Font("SansSerif", Font.PLAIN, 18));
		setValue(0);
		startNewValue = false;
		op = null;
	}

/* Adds a digit to the display, clearing the old value if startNewValue is set */
	public void addDigit(double digit) {
		int nonDecimal = 10;
		if (decimals) {
			nonDecimal = 1;
			memoryDecimal = memoryDecimal * 10;
		}
		double value = (startNewValue) ? 0 : getValue();
		setValue(nonDecimal * value + digit / memoryDecimal);
		startNewValue = false;
	}
	
/* Sets a new operator, applying the previous one if one exists */
	public void setOperator(OperatorButton button) {
			if (button != null && button.toString().startsWith("DecimalButton")) {
				startNewValue = false;
				decimals = true;
			}
			else {
				if (op == null) {
				memory = getValue();
				}  
				else {
					memory = op.apply(memory, getValue());
					setValue(memory);
				}
				op = button;
				startNewValue = true;
				memoryDecimal = 1;
				decimals = false;
			}
	}
	
/* Private instance variables */
	private OperatorButton op;      /* The last operator button pressed */
	private double memory;             /* The value to which the operator is applied */
	private double memoryDecimal = 1;
	private boolean decimals;
	private boolean startNewValue;  /* Set after an operator to start a new value */
}

/*
 * This abstract class is the superclass for every calculator button. Every button
 * must define an action method, which is called whenever the button is clicked.
 */
abstract class CalculatorButton extends JButton {

/* Creates a new CalculatorButton with the specified name */
	public CalculatorButton(String name) {
		super(name);
		setFont(new Font("SansSerif", Font.PLAIN, 18));
	}

/* Called when the button is clicked (every subclass must implement this method) */
	public abstract void action(CalculatorDisplay display);
}

/*
 * This class is used for each of the digit buttons.  The action consists of
 * adding the digit used as a label on the button, which is returned by getText.
 */
class DigitButton extends CalculatorButton {

/* Creates a new DigitButton for the digit n */
	public DigitButton(int n) {
		super("" + n);
	}

/* Adds this digit to the display */
	public void action(CalculatorDisplay display) {
		display.addDigit(Integer.parseInt(getText()));
	}
}

/*
 * This abstract class is the superclass of the various operator buttons.
 * Each concrete subclass must override the apply method.
 */

abstract class OperatorButton extends CalculatorButton {

/* Creates a new Operator with the specified name */
	public OperatorButton(String name) {
		super(name);
	}

/* Informs the display that this operator button has been clicked */
	public void action(CalculatorDisplay display) {
		display.setOperator(this);
	}

/* Applies this operator (every subclass must implement this method) */
	public abstract double apply(double lhs, double rhs);
}

/*
 * The classes AddButton, SubtractButton, MultiplyButton, and DivideButton
 * are the same except for their label and the implementation of apply.
 */
class AddButton extends OperatorButton {
	public AddButton() { super("+"); }
	public double apply(double lhs, double rhs) { return lhs + rhs; }
}

class SubtractButton extends OperatorButton {
	public SubtractButton() { super("-"); }
	public double apply(double lhs, double rhs) { return lhs - rhs; }
}

class MultiplyButton extends OperatorButton {
	public MultiplyButton() { super("x"); }
	public double apply(double lhs, double rhs) { return lhs * rhs; }
}

class DivideButton extends OperatorButton {
	
	public DivideButton() { 
		super("/"); 
	}
	
	public double apply(double lhs, double rhs) { 
		return lhs / rhs; 
	}
}

class DecimalButton extends OperatorButton {
	
	public DecimalButton() { 
		super("."); 
	}
	
	public double apply(double lhs, double rhs) { 
		return 0; 
	}
}

/*
 * The EqualsButton class displays the current value.  As it happens, this
 * operation can be implemented simply by setting the operator to null.
 */
class EqualsButton extends CalculatorButton {
	public EqualsButton() {
		super("=");
	}

	public void action(CalculatorDisplay display) {
		display.setOperator(null);
	}
}

/*
 * The ClearButton class resets the calculator by setting the operator to
 * null and the display value to 0.
 */
class ClearButton extends CalculatorButton {

	public ClearButton() {
		super("C");
	}

	public void action(CalculatorDisplay display) {
		display.setOperator(null);
		display.setValue(0);
	}
}
