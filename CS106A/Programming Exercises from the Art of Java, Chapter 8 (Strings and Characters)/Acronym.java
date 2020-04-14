/*
 * File: Acronym.java
 * ------------------
 * This file generates acronyms.
 */

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
		String result = str.substring(0, 1);
		int pos = str.indexOf(' ');
		while (pos != -1) {
			result += str.substring(pos + 1, pos + 2);
			pos = str.indexOf(' ', pos + 1);
		}
		return result;
	}

}
