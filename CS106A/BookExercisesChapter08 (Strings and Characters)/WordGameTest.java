/*
 * File: WordGame.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 5
 * -----------------
 *  In most word games, each letter in a word is scored according to its point value, which is inversely proportional to its frequency in English 
 *  words. In ScrabbleTM, the points are allocated as follows:	
 *  	1		A,E,I,L,N,O,R,S,T,U
 *  	2		D,G
 *  	3		B,C,M,P
 *  	4		F,H,V,W,Y
 *  	5		K
 *  	8		J,X
 *  	10		Q,Z
 *  For example, the Scrabble word "FARM" is worth 9 points: 4 for the F, 1 each for the A and the R, and 3 for the M. 
 *  Write a ConsoleProgram that reads in words and prints out their score in Scrabble, not counting any of the other bonuses that occur in the game. 
 *  You should ignore any characters other than uppercase letters in computing the score. In particular, lowercase letters are assumed to represent 
 *  blank tiles, which can stand for any letter but which have a score of 0.
 */

import acm.program.ConsoleProgram;

public class WordGameTest extends ConsoleProgram {

	public void run() {
		while (true) {
			String input = readLine("Enter a word... ");
			WordGame word = new WordGame(input);
			word.setPoints();
			println(word.toString());
		}
	}
}
