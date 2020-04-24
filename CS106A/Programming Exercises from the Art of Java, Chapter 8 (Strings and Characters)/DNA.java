/*
 * File: DNA.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 20
 * -------------------
 * 	The generic code for all living organisms is carried in its DNA -a molecule with the remarkable capacity to replicate its own 
 * structure. The DNA molecule itself consists of a long strand of chemical bases wound together with a similar molecule to form 
 * a double helix pattern. DNA’s ability to replicate comes from the fact that the four bases in 
 * its structure -adenosine, cytosine, guanine, and thymine- combine with each other only in the following ways:
 * 		- Adenosine links only with thymine, and vice versa.
 * 		- Cytosine links only with guanine, and vice versa.
 * Typically, biologists abbreviate the names of the bases so that each is represented by its initial letter: A, C, G, or T.
 * 	Inside the cell, a DNA strands acts as a template to which other DNA strands can attach themselves. As an example, suppose that you have the following DNA strand, in which the position of each base has been numbered as it would be in a Java string:
 * 
 * 		T	A	A	C	G	G	T	A	C	G	T	C
 * 		|	|	|	|	|	|	|	|	|	|	|	|
 * 		_____________________________________________
 * 		0	1	2	3	4	5	6	7	8	9	10	11
 * 
 * One of the problems that biologists need to solve is finding where a short SNA strand can attach itself to a longer one. 
 * f , for example, you are trying to find a math for the strand.
 *	   		__________________
 *	   		|	|	|	|	|
 *	   		T	T	G	C	C
 * 
 * the rules for DNA replication dictate that this strand can bind to the longer one at position 1:
 *			__________________
 *			|	|	|	|	|
 *			T	T	G	C	C
 *		T	A	A	C	G	G	T	A	C	G	T	C
 *		|	|	|	|	|	|	|	|	|	|	|	|
 *		_____________________________________________
 *		0	1	2	3	4	5	6	7	8	9	10	11
 *
 * Write a method findFirstMatchingPosition(shortDNA, longDNA) that takes tow strings of letters representing the bases in DNA 
 * strands. The method should return the first index position at which the first DNA stand would bind onto the second, or -1 
 * if no matching position exists.
 */

import acm.program.ConsoleProgram;

public class DNA extends ConsoleProgram {
	/* 
	 * Original
	 * "TTGCC" > AACGG
	 * "TAACGGTACGTC"
	 * 
	 * 2. More at the front
	 * "TTGCC" > AACGG
	 * "JJJJTACGTCAACGGACGT"
	 *
	 * 3. Bind at the end
	 * "TTGCC" > AACGG
	 * "JJJJTTACGTCAACGG"	 
	 *
	 * 4. Complete new combinations
	 * "CTGCT" > GACGA
	 * "CAGCTTGACCATACGTGACGAG"
	 * 
	 * 5. Check last again
	 * "CTGCT" > GACGA
	 * "CAGCTTGACCATACGTGACG"
	 * */
	String shortDNA = "TTGCC";
	String longDNA = "TAACGGTACGTC";
	int shortDNAlenght = 0;
	int longDNAlenght = 0;
	int shortSpacing = 3;
	int longSpacing = shortSpacing;
	int indexMatch = 0;
	public void run() {
		println("This program takes tow strings of letters representing the bases in DNA strands and return the first index position at which the first DNA strand would bind onto the second.");
		for (int i = 0; i < 2; i++) {
			shortDNAlenght = shortDNA.length();
			longDNAlenght = longDNA.length();
			println("\n1st DNA strand is: " + shortDNA + ", and 2nd is " + longDNA + ".");
			indexMatch = findFirstMatchingPosition(shortDNA, longDNA);
			if (indexMatch < 0) longSpacing += shortDNAlenght + longSpacing;
			if (indexMatch >= 0) println("\nPosition where they bind into each other is: " + indexMatch);
			else println("\nNo position where DNA binds :(");
			println(spaceMatcher(shortSpacing) + spaceMatcher(indexMatch) + visualStructure(shortDNAlenght, -1));
			println(spaceMatcher(shortSpacing) + spaceMatcher(indexMatch) + visualStructure(shortDNAlenght, 1));
			println(spaceMatcher(shortSpacing) + spaceMatcher(indexMatch) + shortDNA);
			println(spaceMatcher(longSpacing) + longDNA);
			println(spaceMatcher(longSpacing) + visualStructure(longDNAlenght, 1));
			println(spaceMatcher(longSpacing) + visualStructure(longDNAlenght, -1));
			shortDNA = "CTGCT";
			longDNA = "CAGCTTGACCATACGTGACG";
		}
	}

	private int findFirstMatchingPosition(String shortDNA, String longDNA) {
		int matchStart = 0;
		int DNAlenghtLimit = longDNAlenght - shortDNAlenght;
		int currentShort = 0;
		int currentLong = 0;
		boolean pair = false;
		System.out.println("**************************************\nshortDNAlenght is: " + shortDNAlenght + ", longDNAlenght is: " + longDNAlenght);
		System.out.println("************************************** DNAlenghtLimit + 1: " + DNAlenghtLimit );
		// pair first letter for shortDNA for as long as a match with longDNA is found
		// if match if found at first letter, look for matches in subsequent letters until a full-match confirmation is found
		while (currentLong <= DNAlenghtLimit) {
			// Test if the pair currentShort and currenLong bind together.
			pair = structureMatching(shortDNA.charAt(currentShort), longDNA.charAt(currentLong));
			if (pair) System.out.println("\nYEEEY!! 1st");
			System.out.println("pair is: " + pair + ", beacuse tested current Short: " + shortDNA.charAt(currentShort)+ " & tested current Long: " + longDNA.charAt(currentLong));
			// If pair is successful enter loop to continue testing increasing positions.
			while (pair) {
				// Since last paring was positive, currentShort and currenLong need to increase to be tested again. All without exceeding string limits that cause an exception. 
				if (currentShort + 1 < shortDNAlenght) {
					if (currentLong + 1 < longDNAlenght) currentLong++;
					currentShort++;	
				}
				// Given currentShort can't increase, it means all currentShorts has been tested and found positive, therefore exit the loop. 
				else {
					System.out.println("LOOOK AT ME! pair is: " + pair + ", beacuse tested current Short: " + shortDNA.charAt(currentShort)+ " & tested current Long: " + longDNA.charAt(currentLong) + "\ncurrentShort at MATCH: " + currentShort + ". currentLong at MATCH: " + currentLong);
					break;	
				}
				// After currentShort and currenLong have been increased, test if the pair bind.
				pair = structureMatching(shortDNA.charAt(currentShort), longDNA.charAt(currentLong));
				if (pair) System.out.println("\nYEEEY!! loop");
				System.out.println("pair is: " + pair + ", beacuse tested current Short: " + shortDNA.charAt(currentShort)+ " & tested current Long: " + longDNA.charAt(currentLong));
				
				// If no pairing has been found between currentShort and currentLong, currentShort needs to be restarted.
				if (!pair) currentShort = 0;
			}
			// prepare exit of current loop
			System.out.println("currentShort before: " + currentShort + ". currentLong before: " + currentLong);
			// If currentShort is the last char from shortDNA it means a complete bind was found above. Then index where binding starts it's calculated and loop exited in order to return and send method value back
			if (currentShort == shortDNAlenght - 1)	 {
				matchStart = currentLong - currentShort;
				break;
			}
			// If no pair was found above, we need to increase currentLong to test following pair
			if (currentLong + 1 < longDNAlenght) currentLong++;
			System.out.println("currentShort after: " + currentShort + ". currentLong after: " + currentLong);
			
			// if at this point no match has been found, return -1, no need to go until the end.
			if (currentLong == DNAlenghtLimit + 1) {
				System.out.println("apocalysis");
				matchStart = -1;
				break;
			}
		}
		System.out.println(":) matchStart is: " + matchStart);
		return matchStart;
	}

	
	private boolean structureMatching(char shortDNA, char longDNA) {
		boolean result = false;
		switch (shortDNA) {
			case 'A': if (longDNA == 'T') result = true; break;
			case 'T': if (longDNA == 'A') result = true; break;
			case 'C': if (longDNA == 'G') result = true; break;
			case 'G': if (longDNA == 'C') result = true; break;
		}
		return result;
	}
	
	private String spaceMatcher(int indexMatch) {
		String spaces = "";
		for (int i = 0; i < indexMatch; i++) {
			spaces = spaces + " ";
		}
	return spaces;
	}
	
	private String visualStructure(int indexMatch, int topBottom) {
		String result = "";
		String visual = "";
		String vertical = "|";
		String underscore = "_";
		if (topBottom == -1) visual = underscore;
		else visual = vertical;
		for (int i = 0; i < indexMatch; i++) {
			result = result + visual;
		}
	return result;
	}
}



