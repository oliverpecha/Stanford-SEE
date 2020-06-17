/*
 * File: HitchhikerImageButton.java
 * --------------------------------
 * This program puts up a button on the screen, which triggers
 * a message taken from the Douglas Adams novel.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program puts up a button on the screen, which triggers a
 * message from Douglas Adams's novel.  This version uses a
 * button with an icon instead of a label.
 */
public class HitchhikerImageButton extends ConsoleProgram {

/* Initialize the user-interface buttons */
	public void init() {
		JButton button = new JButton(new ImageIcon("images/RedSquare.gif"));
		button.setActionCommand("Red");
		add(button, SOUTH);
		addActionListeners();
	}

/* Respond to a button action */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Red")) {
			println("Please do not press this button again.");
		}
	}

}
