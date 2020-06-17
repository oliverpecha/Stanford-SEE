/*
 * File: DigitalRoot.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * The digital root of an integer n is defined as the result of summing he digits repeatedly until only a single digit remains. 
 * For example, the digital root of 1729 can be calculates using the following steps:
 * Step 1:	1 + 7 + 2 + 9	->	19
 * Step 2:	1 + 9			->	10
 * Step 3:	1 + 0			->	1
 * Because the total at the end of step 4 is the single digit 1, that value is he digital root.
 * Rewrite the DigitSum program shown in Figure 4-6 so that it calculates the digital root of the input value.
 */


import acm.program.*;

public class DigitalRoot extends ConsoleProgram {

	public void run() {
		println("This program sums the digits in an integer.");
		int n = readInt("Enter a positive integer: ");
		int integer = n;
		int dsum = 0;
		while (n > 0) {
			dsum += n % 10;
			n /= 10;
		}
		int dsum2 = 0;
		while (dsum > 0) {
			dsum2 += dsum % 10;
			dsum /= 10;
		}
		int dsum3 = 0;
		while (dsum2 > 0) {
			dsum3 += dsum2 % 10;
			dsum2 /= 10;
		}
	
		println("The digital root for " + integer + " is " + dsum3);
	}

}
