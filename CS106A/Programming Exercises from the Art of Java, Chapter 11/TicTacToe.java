/*
 * File: TicTacToe.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise bonus 9
 * -----------------
 * Using the declaration of the tic-tac-toe board given in this chapter, write a method isWinningPosition(board, player) that returns 
 * true if the specified player, which is either the character 'X' or the character 'O', has won the tic-tac-toe game. A winning 
 * position is one in which three identical symbols are lined up horizontally, vertically, or diagonally. Test your method by writing 
 * a main program that reads in the current contents of the board array and then reports whether either player has won the game, as 
 * illustrated by this following sample run:
 */

import acm.program.*;

public class TicTacToe extends ConsoleProgram {

	char[][] board; 
	/*= { 
			{'x','x','o'}, 
			{'x','x','x'}, 
			{'o','-','x'} };*/
	
	public void run() {
		board = new char [3][3];
		println("This program tests the isWinningPosition method. Enter the state of the board, row by row.");
		dataCaptureAndStoring();
		char winner = findWinner();
		if (winner == 'x' || winner == 'o') println("\n" + winner + " has won");
		else println("\nNo winner found in this board");
	}

	private void dataCaptureAndStoring() {
		for (int i = 0; i < 3; i++) {
			String clientEntry = readLine();
			for (int n = 0; n < 3; n++) {
				char currentChar = clientEntry.charAt(n);
				 board[i][n] = currentChar;
			}
		}
	}
	
	private char findWinner() {
		char winner = 'x';
		if (isWinner(winner)) return winner;
		else winner = 'o';
		if (isWinner(winner)) return winner;
		return winner = '-';
		
	}
	
	private boolean isWinner(char winner) {
		if (checkColumnsVertical(winner)) return true;
		else if (checkColumnsHorizontal(winner)) return true;
		else if (checkDiagonal(winner, "topBottom")) return true;
		else if (checkDiagonal(winner, "bottomUp")) return true;
		else return false;
	}

	private boolean checkColumnsVertical(char winner) {
		boolean result = true;
		for (int i = 0; i < 3; i++) {
			int winnerCount = 0;
			for (int n = 0; n < 3; n++) {
				if (result && board[n][i] == winner) {
					winnerCount++;
					if (winnerCount == 3) return true;
				}
			}
		} 
		return false;
	}
	
	private boolean checkColumnsHorizontal(char winner) {
		boolean result = true;
		for (int i = 0; i < 3; i++) {
			int winnerCount = 0;
			for (int n = 0; n < 3; n++) {
				if (result && board[i][n] == winner) {
					winnerCount++;
					if (winnerCount == 3) return true;
				}
			}
		} 
		return false;
	}
	
	private boolean checkDiagonal(char winner, String direction) {
			int winnerCount = 0;
			if (direction.contentEquals("topBottom")) {
				for (int i = 0; i < 3; i++) {
					if (board[i][i] == winner) {
						winnerCount++;
						if (winnerCount == 3) return true;
					}
				}
			}
			if (direction.contentEquals("bottomUp")) {
				int i = 2;
				for (int n = 0; n < 3; n++) {
					if (board[n][i] == winner) {
						winnerCount++;
						if (winnerCount == 3)  return true;
					}
					i--;
				}
				
			}
			return false;
		}
	
}