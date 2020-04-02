/*
 * File: MonthName.java
 * --------------------
 * This program tests the monthName method.
 */

import acm.program.*;

public class MonthName extends ConsoleProgram {

	public void run() {
		int month = 7;
		int day = 20;
		int year = 1969;
		println(monthName(month) + " " + day + ", " + year);
	}

/* Translates a numeric month into a string */
	private String monthName(int month) {
		switch (month) {
			case  1: return ("January");
			case  2: return ("February");
			case  3: return ("March");
			case  4: return ("April");
			case  5: return ("May");
			case  6: return ("June");
			case  7: return ("July");
			case  8: return ("August");
			case  9: return ("September");
			case 10: return ("October");
			case 11: return ("November");
			case 12: return ("December");
			default: return ("Illegal month");
		}
	}

}
