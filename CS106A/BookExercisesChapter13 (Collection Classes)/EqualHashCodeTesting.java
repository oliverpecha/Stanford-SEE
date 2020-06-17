/*
 * File: EqualHashCodeTesting.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 8
 * -----------------
 */

import acm.program.ConsoleProgram;

public class EqualHashCodeTesting extends ConsoleProgram {

	public void run() {
		String[] specialCases = {
				"buzzards", "righto", "crinolines", "hierarch", "fixer"	};	
		for (int n = 0; n < specialCases.length; n++) {
			int hashA = specialCases[n].hashCode();			
			for (int i = 0; i < specialCases.length; i++) {
				int hashB = specialCases[i].hashCode();
				if (i != n && hashA == hashB) {
					System.out.println(specialCases[i] + " and " + specialCases[n] + " have the same Hash Code");
				}
			}
		}
	}
}
