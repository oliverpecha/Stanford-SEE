/*
 * File: ReverseDigits.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Rewrite the DigitSum program given in Figure 4-6 so that instead of adding the digits in the number, 
 * it generates the number that has the same digits in the reverse order, as illustrated by this sample run:
 * -----------------
 * This program reverses the digits in an integer. 
 * Enter a positive integer: 1729
 * The reversed number is 9271
 */

import acm.program.*;

public class ReverseDigits extends ConsoleProgram {

	/* known bugs: 
	- "0" integers at the start or end are lost in the operations
	- integers of over 9 digits will return incorrect results as low accuracy of "n /= 10;" operation beyond that point compounds.
	*/
	
	public void run() {
		println("This program reverses the digits in an integer.");
		int n = readInt("Enter a positive integer: "); 
		int dsum = 0;
		while (n >  0) {
			dsum += (n % 10);
			dsum *= 10;
			n /= 10;
		}
		dsum /= 10;
		println("The reversed number is " + dsum);
	}

}
