/*
 * File: PluralWords.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 8
 * -----------------
 *  Write a method regularPluralForm(word) that returns the plural of word formed by following these standard English rules:
 *  a. If the word ends in s, x, z, ch, or sh, add es to the word.
 *  b. If the word ends in y and the y is preceded by a consonant, change the y to ies.
 *  c. In all other cases, add just an s.
 *  Write a test program and design a set of test cases to verify that your program works.
 */

import acm.program.*;

public class PluralWords extends ConsoleProgram {

	
	public void run() {
		println("a) contitions are tested below");
		println("    The plural for " + LAST_S + " is " + regularPluralForm(LAST_S));
		println("    The plural for " + LAST_X + " is " + regularPluralForm(LAST_X));
		println("    The plural for " + LAST_Z + " is " + regularPluralForm(LAST_Z));
		println("    The plural for " + LAST_CH + " is " + regularPluralForm(LAST_CH));
		println("    The plural for " + LAST_SH + " is " + regularPluralForm(LAST_SH));
		println("    The plural for " + LAST_ONLY_H + " is " + regularPluralForm(LAST_ONLY_H));
		println("\nb) contitions are tested below");
		println("    The plural for " + LAST_Y_SECOND_CONSONANT + " is " + regularPluralForm(LAST_Y_SECOND_CONSONANT));
		println("    The plural for " + LAST_Y_SECOND_VOWEL + " is " + regularPluralForm(LAST_Y_SECOND_VOWEL));
		println("\nc) contitions are tested below");
		println("    The plural for " + OTHERS + " is " + regularPluralForm(OTHERS));

	}
	
	private String regularPluralForm(String word) {
		// find last character
		int wordlenght = word.length();
		char lastChar = word.charAt(wordlenght-1);
		// differ through 3 conditions
		// A. if ends in s, x, z, h

		if (lastChar == 's' || lastChar == 'x' || lastChar == 'z' || lastChar == 'h') {
			if (lastChar == 'h') {
				// if h, also find and check if previous character is a c or s
				lastChar = word.charAt(wordlenght-2);
				if (lastChar == 'c' || lastChar == 's') {
				// in case char before h is c or s, add es to the word
				word = word.concat("es");
				}
				else word = word.concat("s"); 
			}
			// if ends in s, x, z, add es to the word
			else word = word.concat("es");
		}
		// B. if ends in y, also find and check if previous character is a consonant
		else if (lastChar == 'y') {
			lastChar = word.charAt(wordlenght-2);
			// check if it is a consonant
			if (!isEnglishVowel(lastChar)) {
			// remove last two char, then add ies to the word
			//System.out.println("lastChar when consonant is " + lastChar);

			word = word.substring(0,wordlenght-1).concat("ies");
			}
			else word = word.concat("s"); 
		}
		// C. else add s to the word
		else word = word.concat("s");
		return word;
	}
	
	/* Returns true if the character is a vowel */
	private boolean isEnglishVowel(char ch) {
		switch (Character.toLowerCase(ch)) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
				return true;
			default:
				return false;
		}
	}

	
	private static final String LAST_S = "boss";
	private static final String LAST_X = "box";
	private static final String LAST_Z = "fuzz";
	private static final String LAST_Y_SECOND_CONSONANT = "army";
	private static final String LAST_Y_SECOND_VOWEL = "abbey";
	private static final String LAST_CH = "arch";
	private static final String LAST_SH = "blush";
	private static final String LAST_ONLY_H = "bath";
	private static final String OTHERS = "truck";


	
	
}
