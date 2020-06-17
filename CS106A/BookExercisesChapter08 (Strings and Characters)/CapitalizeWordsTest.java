/*
 * File: Capitalize.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 3
 * -----------------
 *  Implement a method capitalize(str) that returns a string in which the initial character is capitalized (if it is a letter) and all other letters 
 *  are converted so that they appear in lowercase form. Characters other than letters are not affected. For example, capitalize("BOOLEAN") and 
 *  capitalize("boolean") should each return the string "Boolean".
 */

import acm.program.*;

public class CapitalizeWordsTest extends ConsoleProgram {

	public void run() {
		while (true) {
			String input = readLine("Enter a word... ");
			Capitalize word = new Capitalize(input);
			word.setCapitalize();
			println(word.toString());
		}
	}
}