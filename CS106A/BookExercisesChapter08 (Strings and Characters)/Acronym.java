/*
 * File: Acronym.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 16
 * -----------------
 * Rewrite the acronym method described in the section on “Searching within a string” so that it uses the StringTokenizer class to separate 
 * the words in the argument. This change will allow the acronym to return the correct result even if the words are not separated by spaces. 
 * As an example, your implementation should be able to form the acronym scuba from the string self-contained underwater breathing apparatus, 
 * even though the first two words are separated by a hyphen rather than a space.
 */

import java.util.StringTokenizer;

import acm.program.*;

public class Acronym extends ConsoleProgram {

	public void run() {
		while (true) {
			String line = readLine("Enter a string: ");
			if (line.length() == 0) break;
			String acronym = acronym(line);
			println(acronym);
		}
	}
/*
 * Returns the factorial of n, which is defined as the
 * product of all integers from 1 up to n.
 */
	
	private String acronym(String str) {
		String result = "";
		StringTokenizer strTokenizer = new StringTokenizer(str, DELIMS);
		
		while (strTokenizer.hasMoreTokens()) {
			String currentToken = strTokenizer.nextToken();
			result += currentToken.substring(0, 1);
		}
		return result;
	}
	
	private String oldAcronym(String str) {
		String result = str.substring(0, 1);
		int pos = str.indexOf(' ');
		while (pos != -1) {
			System.out.println("\npost entry loop" +pos);
			result += str.substring(pos + 1, pos + 2);
			pos = str.indexOf(' ', pos + 1);
			System.out.println("post exit loop" +pos);
		}
		return result;
	}

	private static final String DELIMS = "-: <>@#$%^&*";
}
