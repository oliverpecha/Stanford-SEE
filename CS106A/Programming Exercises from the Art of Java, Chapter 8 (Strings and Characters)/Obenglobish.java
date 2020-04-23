/*
 * File: Obenglobish.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 19
 * -------------------
 * 		Most people - at least those in English-speaking countries- have played the Obenglobish game at some point in their lives. There  
 * are, however, other invented “languages” in which words are created using some simple transformation of English. One such language is 
 * Obenglobish, in which the words are created by adding the letters ob before vowels in an English word. For example, given this rule, 
 * the word english is transformed by adding ob before the two vowels to form obenglobish, which is how the language gets its name.
 * 		In official Obenglobish, the letters ob are added only before vowels that are pronounced, which means that a word like game would 
 * become gobame rather than gobamobe because the final e is silent. While it is impossible to implement this rule perfectly, you can do 
 * a pretty good job by adopting the rule that the ob should be added before every vowel in the English word except.
 * 		> Vowels that follow other vowels
 * 		> An e that occurs at the end of the word
 * Write a method obenglobish that takes an English word and returns its Obenglobish equivalent, using the translation rule given above. For example, if you used your function with the run method
 * 		public void run() {
 * 			while (true) {
 * 				String word = readLine(“enter a word: “);
 * 					if (word.equals(“”)) break;
 * 					println(word + “ -> “ + obenglobish(word));
 * 			}
 * 		}
 * You should be able to generate the following sample run:
 * -------------------
 * Enter a word: english
 * english -> obenglobish 
 * Enter a word: hobnob
 * hobnob -> hobobnobob
 * Enter a word: gooiest
 * gooiest -> goboiest 
 * Enter a word: amaze
 * amaze -> obamboaze 
 * Enter a word: rot
 * rot -> robot 
 * Enter a word:  
 * -------------------
 */

import java.util.StringTokenizer;

import acm.program.*;

public class Obenglobish extends ConsoleProgram {

	public void run() {
		while (true) {
		println("\nThis program translates a line into Obenglobish.");
		println("english>obenglobish, hobnob>hobobnobob, gooiest>gobooiest, amaze>obamobaze, rot>robot");
		String word = readLine("Enter a line: ");
		if (word.equals("")) {
			println("Exiting... No more lines will translate to Obenglobish.");
			break;
		}
		println("\"" + translateLine(word) + "\"");
		}
	}

	/* Translates a line to Obenglobish, word by word */
	private String translateLine(String line) {
		String result = "";
		StringTokenizer tokenizer = new StringTokenizer(line, DELIMITERS, true);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (isWord(token)) {
				token = translateWord(token);
			}
			result += token;
		}
		return result;
	}
	

/* Returns true if token is a "word" (all character are letters) */
	private boolean isWord(String token) {
		for (int i = 0; i < token.length(); i++) {
			char ch = token.charAt(i);
			if (!Character.isLetter(ch)) return false;
		}
		return true;
	}
	
/* Translates a word to Obenglobish and returns the translated word */
	private String translateWord(String word) {
		int initialSearch = 0;
		int lastIndexChar = word.length() - 1;
		String result = "";
		String consAdd = "";
		String ob = "ob";
		int vp = findNextVowel(word, initialSearch);
		System.out.println("Word to be translated: " + word + "lastChar is: " + lastIndexChar);
		
		// As long as there are vowels left
		while (vp >= 0) {
			// addition is formed by consonants which don't need to receive manipulations
			consAdd = word.substring(initialSearch, vp);
			// condition to make sure rule "for vowels that follow other vowels" is not applied to words starting with vowel
			if (vp - 1 != -1) {
				// rule for vowels that follow other vowels 
				if (isEnglishVowel(word.charAt(vp - 1))) result = result + consAdd + word.charAt(vp);
				// rule for 'e' at the end of the word
				else if (vp == lastIndexChar && word.charAt(vp) == 'e') result = result + consAdd + word.charAt(vp);

				// standard rule to add ob before a vowel
				else result = result + consAdd + ob + word.charAt(vp);
			}
			// standard rule for words that start with a vowel and that therefore can't be preceded with a vowel
			else result = result + consAdd + ob + word.charAt(vp) ;		
			// preparation to exit loop
			initialSearch = vp + 1;
			vp = findNextVowel(word, initialSearch);
		}
		// for remaining part of word that contains no vowels
		if (vp == -1) {
			if (initialSearch > 0) {
				consAdd = word.substring(initialSearch);
				result = result + consAdd;
			}
			// for cases in which word doesn't contain any vowel at all
			else return word;
		} 
		return result;
	}

/* Returns the index of the first vowel in the word (-1 if none) */
	private int findNextVowel(String word, int z) {
		for (int i = z ; i < word.length(); i++) {
			if (isEnglishVowel(word.charAt(i))) return i;
		}
		return -1;
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

/* Defines the characters that delimit a token */
	private static final String
	  DELIMITERS = "!@#$%^&*()_-+={[}]:;\"'<,>.?/~`|\\ ";

}


