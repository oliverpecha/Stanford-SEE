/*
 * File: IsEnglishVowel.java
 * -------------------------
 * This program tests the isEnglishVowel method.
 */

import acm.program.*;

public class IsEnglishVowel extends ConsoleProgram {

	public void run() {
		print("The English vowels are \"");
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			if (isEnglishVowel(ch)) {
				print(ch);
			}
		}
		println("\"");
	}

/* Returns true if ch is an English vowel. */
	private boolean isEnglishVowel(char ch) {
		switch (Character.toLowerCase(ch)) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
				return true;
			default:
				return false;
		}
	}

}
