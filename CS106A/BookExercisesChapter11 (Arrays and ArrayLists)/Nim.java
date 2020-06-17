/*
 * File: Nim.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 10.
 * -----------------
 */

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.*;
import acm.program.*;

public class Nim extends GraphicsProgram {
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		coinArray = new ArrayList<Coin>();
		fillCoinArray(coinArray);
		startCoinArray(coinArray);
		addMouseListeners();
	}

	private void startCoinArray(ArrayList<Coin> array) {
		double coinSeparation = (SCREEN_WIDTH - 2 * MARGIN_SIDES) / array.size();
		for (int i = 0; i < array.size(); i++) {
			add(array.get(i), MARGIN_SIDES + coinSeparation / 2 + i * coinSeparation, SCREEN_HEIGHT / 2);
		}
	}
	
	private ArrayList<Coin> fillCoinArray(ArrayList<Coin> array) {
		for (int i = 0; i < COINS; i++) {
			array.add(i, new Coin(COIN_RADIUS));
		}
		return array;
	}
	
	private void computerMove() {
		// Calculate how many moves computer should make
		int moves = computerMoveLogic();
		// Signal the number of moves by painting the coins and waiting for 2 seconds
		computerMoveSignaling(moves);		
		pause(2000);
		// Delete coins signaled
		computerMoveDeleting(moves);
		// Track the end of the game
		gameTracker();
	}
	
	private int computerMoveLogic() {
		int moves = 0;
		int x = coinArray.size();
		// If deleting 3 coins would leave player left with at least a coin, but avoids player removing 3 coins to win: Remove 3
		if (x - 3 >= 1 && x - 6 != 1) {
			moves = 3;
		}
		// If deleting 2 coins would leave player left with at least a coin, but avoids player removing 2 coins to win: Remove 2
		else if (x - 2 >= 1 && x - 5 != 1) {
			moves = 2;
		}
		// If deleting 3 coins would leave player left with at least a coin, Remove 1
		else if (x - 1 >= 1) {
			moves = 1;
		}
		// If no other choice is possible, computer has been beaten.
		else {
			computerWins = false;
		}
		return moves;
	}

	private void computerMoveSignaling(int moves) {
		// Pain in yellow as many coins as calculated and received as moves
		for (int i = coinArray.size()-1; i > coinArray.size()-1 - moves; i--) {
			Coin coines = (Coin) coinArray.get(i);
			coines.setPaint(Color.YELLOW);
		}
	}
	
	private void computerMoveDeleting(int moves) {
		// Delete as many coins as calculated and received as moves
		for (int i = moves; i > 0; i--) {
			// removes object from canvas
			remove(coinArray.get(coinArray.size()-1));
			// removes element from array
			coinArray.remove(coinArray.size()-1);
		}
	}
	
	private void gameTracker() {
		// At the point when there is only one coin left
		if (coinArray.size() <= 1) {
			// Start a GLabel to notify that computer has won
			GLabel gameEnds = new GLabel("Game Over, You loose :(");
			// But if predicator computerWins is true, change text to player win before it is added
			if (computerWins == false) {
				gameEnds.setLabel("Game Over, You win!");
			}
			add(gameEnds, SCREEN_WIDTH / 2 - gameEnds.getWidth() / 2, SCREEN_HEIGHT / 2 );
		}
	}
	
	public void mousePressed(MouseEvent e) {
		// Catch mousePressed and create a mouseAt GPoint where mouse has been pressed
		mouseAt = new GPoint(e.getPoint());
		if (getElementAt(mouseAt) != null) {
			// If press has been on top an Object, get the index of the array where this element is held
			indexAt = coinArray.indexOf(getElementAt(mouseAt));
			// As long as the 3 conditions below:
			// 1. index is 3 positions before the end of the array
			// 2. choosing as many as desired would eliminate all the elements of the array
			// 3. at least one element must remain. On this 3 conditions: not 100% sure comments are correct. Recheck if necessary
			int i = indexAt;
			while (i >= coinArray.size() - 3 && coinArray.size() - (coinArray.size() - indexAt) > 0 && i < coinArray.size()) {
				// Paint Coins in red
				Coin coines = (Coin) coinArray.get(i);
				coines.setPaint(Color.RED);
				i++;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		// If the mouse was pressed on top of an element that painted some coins and mouse left those elements, repaint in gray
		while (indexAt >= coinArray.size() - 3 && indexAt < coinArray.size() && coinArray.size() - (coinArray.size() - indexAt) > 0) {
			Coin coines = (Coin) coinArray.get(indexAt);
			coines.setPaint(Color.LIGHT_GRAY);
			indexAt++;
		}
		mouseAt = new GPoint(e.getPoint());
		if (getElementAt(mouseAt) != null) {
			indexAt = coinArray.indexOf(getElementAt(mouseAt));
			// As long as the 3 conditions below which are described above too
			if (indexAt >= coinArray.size() - 3 && coinArray.size() - (coinArray.size() - indexAt) > 0) {
				while (indexAt < coinArray.size()) {
				// removes object from canvas
				remove(coinArray.get(indexAt));
				// removes element from array
				coinArray.remove(indexAt);
			}
			// Call computer to make it's move
			computerMove();
			}
		}
	}
	
	int indexAt;
	GPoint mouseAt;
	GObject selectedObj;
	ArrayList<Coin> coinArray;
	boolean computerWins = true;
	
	private static final int SCREEN_WIDTH = 600;
	private static final int SCREEN_HEIGHT = 160;
	private static final int COINS = 11;
	private static final double MARGIN_SIDES = 0.07 * SCREEN_WIDTH;
	private static final double COIN_RADIUS = 0.3 * (SCREEN_WIDTH / COINS);
	private static final int PAUSE_M = 300;
	private static final int PAUSE_L = 1100;

	
/***********************************************************************************************
 * 	
 * @author oliverpecha
 *
 */
	
private class Coin extends GCompound {
	
	GOval coin;
	
	public Coin(double radius) {
		coin = new GOval(2 * radius, 2 * radius);
		coin.setFillColor(Color.LIGHT_GRAY);
		coin.setFilled(true);
		add(coin, - radius, -radius);
	}

	public void setPaint(Color color) {
		coin.setFillColor(color);
	}
}

}