/*
 * File: MorseCode.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 8.
 * -----------------
 * In May of 1844, Samuel F. B. Morse sent the message “What hath God wrought!” by telegraph from Washington to Baltimore, heralding 
 * the beginning of the age of electronic communication. To make it possible to communicate information using only the presence or 
 * absence of a single tone, Morse designed a coding system in which letters and other symbols are represented as coded sequences of 
 * short and long tones, traditionally called dots and dashes. In Morse code, the 26 letters of the alphabet are represented by the 
 * following codes:
 * A• J• S••• B•••K•T C••L•••U•• D••MV••• E•N•W• F•••OX•• G•P••Y• H•••• Q• Z•• I•• R••
 * You can easily store these codes in a program by declaring an array with 26 elements and storing the sequence of characters 
 * corresponding to each letter in the appropriate array entry.
 * Write a program that reads in a string from the user and translates each letter in the string to its equivalent in Morse code, 
 * using periods to represent dots and hyphens to represent dashes. Separate words in the output by calling println whenever you 
 * encounter a space in the input, but ignore all other punctuation characters. Your program should be able to generate the following 
 * sample run:
 */

import java.util.StringTokenizer;

import acm.program.*;

	public class MorseCode extends ConsoleProgram {
		
		String [] alphabet = { 
				"•-","-•••","-•-•","-••","•","••-•","--•","••••","••",
				"•---","-•-","•-••","--","-•","---","•--•","--•-","•-•",
				"•••","-","••-","---•","•--","-••-","-•--","--••",	
		};
		
		public void run() {
			println("This program translates a line into Morse code.");
			/* Prototyping purposes:
			 String enteredText = "What hath God wrought";
			 String enteredText = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
			 println("Enter English text: " + enteredText);
			 */
			String enteredText = readLine("Enter English text: ");
			StringTokenizer allTokens = new StringTokenizer(enteredText);
			while (allTokens.hasMoreTokens()) {
				// Print the result of extracting next token and translating to Morse. Add a blank line after.
				String temp = allTokens.nextToken().toUpperCase();
				println(temp + " " + tokenToMorse(temp));
				println("");
			}	
		}
		
		private String tokenToMorse(String token) {
			String morseToken = "";
			// extract each char, convert to morse and add a space until no more chars in token
			for (int i = 0; i < token.length(); i++) {
				char currentChar = token.charAt(i);
				morseToken += charToMorse(currentChar) + "  ";
			}
			return morseToken;
		}
		
		private String charToMorse(char currentChar) {
			String morseEquivalent = alphabet[currentChar - 'A'];
			return morseEquivalent;
		}
}
	
