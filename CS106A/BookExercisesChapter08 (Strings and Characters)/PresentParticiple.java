/*
 * File: PresentParticiple.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 9
 * -----------------
 *  In English, the notion of a present action that is continuing into the future is expressed using the present progressive tense, which involves 
 *  the addition of an ing suffix to the verb. For example, the sentence I think conveys a sense that one is capable of thinking; by contrast, the 
 *  sentence I am thinking conveys the impression that one is actually in the process of thinking. The ing form of the verb is called the present 
 *  participle.
 *  Unfortunately, creating the present participle is not always as simple as adding the ing ending. One common exception is words that end in a 
 *  silent e, such as cogitate. In such cases, the e is usually dropped, so that the participle form becomes cogitating. Another common exception 
 *  involves words that end with a single consonant, which typically gets doubled in the participle form. For example, the verb program becomes 
 *  programming.
 *  Although there are many exceptions, you can construct a large fraction of the legal participle forms in English by applying the following rules:
 *  	a. If the word ends in an e preceded by a consonant, take the e away before adding the ing suffix. Thus, move should become moving. If the 
 *  	e is not preceded by a consonant, it should remain in place, so that see becomes seeing.
 *  	b. If the word ends in a consonant preceded by a vowel, insert an extra copy of that consonant before adding the ing suffix. Thus, jam should 
 *  	become jamming. If, however, there is more than one consonant at the end of the word, no such doubling takes place, so that walk becomes walking.
 *  	c. In all other circumstances, simply add the ing suffix.
 *  Write a method presentParticiple that takes an English verb, which you may assume is entirely lowercase and at least two characters long, and forms 
 *  the participle using these rules. Write a ConsoleProgram to test your method
 */

import acm.program.*;

public class PresentParticiple extends ConsoleProgram {

	public void run() {
		println("a) contitions are tested below");
		println("    The past participle for " + ENDS_E_PRECEDES_CONSONANT + " is " + presentParticiple(ENDS_E_PRECEDES_CONSONANT));
		println("    The past participle for " + ENDS_E_PRECEDES_VOWEL + " is " + presentParticiple(ENDS_E_PRECEDES_VOWEL));
		println("    The past participle for " + OTHERS_FOUR + " is " + presentParticiple(OTHERS_FOUR));
		println("\nb) contitions are tested below");
		println("    The past participle for " + ENDS_CONSONANT_PRECEDES_VOWEL + " is " + presentParticiple(ENDS_CONSONANT_PRECEDES_VOWEL));
		println("    The past participle for " + ENDS_CONSONANT_PRECEDES_CONSONANT + " is " + presentParticiple(ENDS_CONSONANT_PRECEDES_CONSONANT));
		println("    The past participle for " + OTHERS_FIVE + " is " + presentParticiple(OTHERS_FIVE));
		println("    The past participle for " + OTHERS_SIX + " is " + presentParticiple(OTHERS_SIX));
		println("\nc) contitions are tested below");
		println("    The past participle for " + OTHERS_ONE + " is " + presentParticiple(OTHERS_ONE));
		println("    The past participle for " + OTHERS_TWO + " is " + presentParticiple(OTHERS_TWO));
		println("    The past participle for " + OTHERS_THREE + " is " + presentParticiple(OTHERS_THREE));


	}
	
	private String presentParticiple(String word) {

		int wordlenght = word.length();
		char lastChar = word.charAt(wordlenght-1);
		// Condition a)
		if (lastChar == 'e') {
			lastChar = word.charAt(wordlenght-2);
			if (!isEnglishVowel(lastChar)) {
				word = word.substring(0,wordlenght-1).concat("ing");			}
			else word = word.concat("ing");
		}
		// Condition b)
		else if (!isEnglishVowel(lastChar)) {
			lastChar = word.charAt(wordlenght-2);
			if (isEnglishVowel(lastChar)) {
			lastChar = word.charAt(wordlenght-1);
			word = word.concat("" + lastChar).concat("ing");
			}
			else word = word.concat("ing");
		}
		// Condition c)
		else word = word.concat("ing");
		// Returns Present Participle
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

	private static final String ENDS_E_PRECEDES_CONSONANT = "move";
	private static final String ENDS_E_PRECEDES_VOWEL = "see";
	private static final String ENDS_CONSONANT_PRECEDES_VOWEL = "jam";
	private static final String ENDS_CONSONANT_PRECEDES_CONSONANT = "walk";
	private static final String OTHERS_ONE = "go";
	private static final String OTHERS_TWO = "echo";
	private static final String OTHERS_THREE = "blush";
	private static final String OTHERS_FOUR = "increase";
	private static final String OTHERS_FIVE = "book";
	private static final String OTHERS_SIX= "obey";


}
