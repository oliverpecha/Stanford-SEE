/*
 * File: CaeserCipher.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 11
 * -----------------
 *  One of the simplest types of codes used to make it harder for someone to read a message is a letter-substitution cipher, 
 *  in which each letter in the original message is replaced by some different letter in the coded version of that message. 
 *  A particularly simple type of letter-substitution cipher is a Caesar cipher—so named because the Roman historian Suetonius 
 *  records that Julius Caesar used such a cipher—in which each letter is replaced by its counterpart a fixed distance ahead 
 *  in the alphabet. A Caesar cipher is cyclic in the sense that any operations take shift a letter beyond Z simply circle back 
 *  to the beginning and start over again with A.
 *  
 *  As an example, suppose that you wanted to encode a message by shifting every letter ahead four places. In that Caesar cipher, 
 *  each A becomes an E, B becomes F, Z becomes D (because it cycles back to the beginning), and so on.
 *  
 *  To solve this problem, you should first define a method
 *           private String encodeString(String str, int shift)
 *  that returns a new string formed by shifting every letter in str forward the number of letters indicated by shift, cycling 
 *  back to the beginning of the alphabet if necessary. After you have implemented encodeString, write a ConsoleProgram that 
 *  duplicates the examples shown in the following sample run:
 * -----------------
 *  This program encodes a message using a Caesar cipher. 
 *  Enter the number of character positions to shift: 13 
 *  Enter a message: This is a secret message.
 *  Encoded message: Guvf vf n frperg zrffntr.
 * -----------------
 * Note that the coding operation applies only to letters; any other character is included unchanged in the output. Moreover, 
 * the case of letters is unaffected: lowercase letters come out as lowercase, and uppercase letters come out as uppercase.
 * 
 * Write your program so that a negative value of shift means that letters are shifted toward the beginning of the alphabet 
 * instead of toward the end, as illustrated by the following sample run:
 * -----------------
 *  This program encodes a message using a Caesar cipher. 
 *  Enter the number of character positions to shift: -1 
 *  Enter a message: IBM 9000
 *  Encoded message: HAL 9000
 * -----------------
 */

import acm.program.*;

public class CaeserCipher extends ConsoleProgram {
	
	public void run() {
		while (true) {
		println("\nThis program encodes a message using a Caesar cipher. ");
		int shift = readInt("Enter the number of character positions to shift: ");
		String str = readLine("Enter a message: ");
		println("Encoded message: " + encodeString(str, shift));		
		}
	}
	
	 private String encodeString(String str, int shift) {
		 String cipher = ""; 
		 // Receive and evaluate str lenght
		 int strlenght = str.length();
		 //System.out.println("strlenght " + strlenght);
		 // perform ciphering in as many characters as str lenght is
		 for (int i = 0; i <= (strlenght - 1); i++) {
		 // if character is between a-z or A-Z,
			 char ichar = str.charAt(i);
			 char alphabetStart = 'a';
			 char alphabetEnd = 'z';
			 if (ichar >= 'a' && ichar <= 'z') {
				 alphabetStart = 'a';
				 alphabetEnd = 'z';
			 }
			 else {
				 alphabetStart = 'A';
				 alphabetEnd = 'Z';
			 }
			 if (ichar >= alphabetStart && ichar <= alphabetEnd) {
			 // shift as many positions as shift requested considering edge cases 	
				 	// Else if shift number is negative and current character minus shift is beyond character a,
				 	// will be cycled to the end of alphabet
				 	if (shift < 0 && ichar + shift < alphabetStart) {
						// calculates how much past the begining of alphabet substracting shift to current char goes
				 		int testShift = ichar + shift; 
				 		// calculates how many positions passed the current char independent from value of char in the unicode scalar type
				 		int loppingMechanism = alphabetStart - testShift - 1;
				 		// sets a new ciphered char by deducing the positions calculated above to the last letter of alphabet
				 		ichar = (char) (alphabetEnd - loppingMechanism);
				 	}
				 	//if character added plus shift positions are above alphabet limits, loop to find appropiate position
				 	else if (ichar + shift > alphabetEnd) {
				 		int testShift = ichar + shift; 
				 		int loppingMechanism = testShift - alphabetEnd - 1;
				 		ichar = (char) (alphabetStart + loppingMechanism);
				 	}
				 	// The characters that after adding or deducing the shift don't go beyond the limits of the alphabet
				 	else {
						ichar = (char) (ichar + shift);
				 	}
			 //		return ciphered character by adding it to cipher
				 cipher = cipher.concat("" + ichar);
			 }
		 // else leave character as it is and add it to cipher
			 else cipher = cipher.concat("" + ichar);
		 }
		 // finishing all character ciphering and return completed chipher
		 return cipher;
	}
}
