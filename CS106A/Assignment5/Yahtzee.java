/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		/*while (nPlayers <= 0 || nPlayers > 4) {
			nPlayers = dialog.readInt("Enter number of players");
			if (nPlayers <= 0 || nPlayers > 4) dialog.println("There must be between 1 to 4 players");
		}
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {	
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);*/	
		display = new YahtzeeDisplay(getGCanvas(), new String[] {"Oliver",});
		model = new YahtzeeModel(nPlayers);
		playGame();
	}

	private void playGame() {
		while (nTurns > 0) {	
			for (int p = 1; p <= nPlayers; p++) {
				int[] dices = rollDices(p);
				enterCategory(dices, p);
				System.out.println("player " + p + " turn " + nTurns + " finsihed");
			}
			nTurns--;
		}
		computeAndDisplayResults();
	}
	
	private void computeAndDisplayResults() {
		computeScores();
		computeBonus();
		computeTotal();
	}

	private void computeScores() {
		for (int p = 1; p <= nPlayers; p++) {
			int result = 0;
			for (int category = 1; category <= 6; category++) {
				result += model.getScore(p - 1, category);
			}
			model.setScore(p, UPPER_SCORE, result);
			result = 0;
			for (int category = 9; category <= 15; category++) {
				result += model.getScore(p - 1, category);
			}
			model.setScore(p, LOWER_SCORE, result);
		}
	}
	private void computeBonus() {
		for (int p = 1; p <= nPlayers; p++) {
			if (model.getScore(p - 1, UPPER_SCORE) > 62) model.setScore(p, UPPER_BONUS, 35);
			else model.setScore(p, UPPER_BONUS, 0);
		}
	}
	
	private void computeTotal() {
		for (int p = 1; p <= nPlayers; p++) {
			int total = model.getScore(p - 1, UPPER_SCORE) + model.getScore(p - 1, LOWER_SCORE) + model.getScore(p - 1, UPPER_BONUS);
		}
	}
		
	private void enterCategory(int[] dices, int player) {
		YahtzeeMagicStub test = new  YahtzeeMagicStub();
		YahtzeeStub stub = new  YahtzeeStub();
		int category = display.waitForPlayerToSelectCategory();
		int value = 0;
		if (test.checkCategory(dices, category)) {
			System.out.println("good"); 
			value = stub.pointsForCategory(dices, category);
		}
		else System.out.println("bad");
		model.setScore(player - 1, category, model.getScore(player - 1, category) + value);
		display.updateScorecard(category, player, model.getScore(player - 1, category));
	}

	private int[] rollDices(int player) {
		display.waitForPlayerToClickRoll(player);
		int[] dice = dicesAllHacked();
		for (int r = 0; r < 2; r++) {
			display.displayDice(dice);
			display.waitForPlayerToSelectDice();
			int[] diceChanges = reRoll(dice);
			if (diceChanges == null) r = 3;
			else dice = diceChanges;
		}
		return dice;
	}
	
	private int[] reRoll(int[] dices) {
		int changeCount = 0;
		for (int i = 0; i < dices.length; i++) {
			if (display.isDieSelected(i)) {
				dices[i] =  diceSingleHacked(i);
				changeCount++;
			}
		}
		if (changeCount == 0) return null;
		else return dices;
	}
	
	private int diceSingleHacked(int nDice) {
		while (true) {
			IODialog dialog = getDialog();
			while (true) {
				int input = dialog.readInt("Enter desired result for " + (nDice + 1) + " dice");
				if (input <= 6 && input > 0) return input;
				else dialog.println("You may only enter a number between 1 and 5");
			}
		}
	}
	
	private int[] dicesAllHacked() {
		int[] result = new int[N_DICE];
		IODialog dialog = getDialog();
		String input;
		while (true) {
			input = dialog.readLine("Enter 5 desired Dices");
			if (input.length() == 5) break;
			else dialog.println("You may only enter 5 numbers without spaces");
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = Integer.parseInt("" + input.charAt(i));
		}
		return result;
	}
		
/* Private instance variables */
	private int nPlayers = 1;
	private int nTurns = N_SCORING_CATEGORIES;
	private String[] playerNames;
	private int[] dices;
	private YahtzeeDisplay display;
	private YahtzeeModel model;
	private RandomGenerator rgen = new RandomGenerator();


}

/*


while 13 rounds left for each player
	Enter turn -13
		Enter -N_players
			wait user roll dice
				throw dices
				#hack own dices
				Display -3 round Dice
				wait user input (more dices + roll again)
				if input is empty, exit
			wait user to choose category
				check compatibility
					*edge: choose an other category message /////// highlight in notes in green pdf
				compute value
				add value to scoreboard
				update scoreboard
			change player
	compute bonus and final total
	display final results
	
	SCOREBOARD: multidimensional array int [][]
	N_TURNS: int
	N_PLAYERS: int
	DICES: int[]
	
		

*/