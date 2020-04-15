/*
 * File: isEnglishConsonant.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 1
 * -----------------
 *  Implement the method isEnglishConsonant(ch), which returns true if ch is a consonant in English: that is, any letter except one of
 *   the five vowels: 'a', 'e', 'i', 'o', and 'u'. Like isEnglishVowel, your method should recognize consonants of both cases. 
 *   Write a ConsoleProgram that displays all the uppercase consonants.
 */

import acm.program.*;

public class isEnglishConsonant extends ConsoleProgram {
	
	public void run() {
		println("Below are all the uppercase consonants...");
		for (char i = 'a'; i < 'z'; i++) {
			if (isEnglishConsonant(i)) println(i);
		}
	}

	private boolean isEnglishConsonant(char letter) {
		letter = Character.toLowerCase(letter);
		if (letter == 'a'|| letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
			return false;
		}
		else return true;
	}
	
	private static final String VOWELS = "aeiou";
}
