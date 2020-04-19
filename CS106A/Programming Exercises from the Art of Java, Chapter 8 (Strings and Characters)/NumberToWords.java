/*
 * File: NumberToWords.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 14
 * -----------------
 * When you write a check, it is conventional to record the amount of the check both in figures and in words. This, if you were writing a check 
 * for $1,729 dollars, you would write the amount out in words like this:
 * 		one thousand seven hundred and twenty-nine
 * Implement a method
 * 		private String numberTowWords (int n)
 * that takes an integer - which you may assume is between 0 and 999,999 - and returns a string that represents that number in words. Test your 
 * method by writing a run method that repeatedly reads in an integer and converts that number into words, stopping when a negative number is 
 * entered, as illustrated in the following sample run:
 * -----------------
 * This program converts numbers to words.
 * Enter a number: 17
 * seventeen
 * Enter a number: 2001
 * two thousand one
 * Enter a number: 136211
 * one hundred thirty-six thousand two hundred eleven
 * Enter a number: 0
 * zero
 * Enter a number: -1
 * -----------------
 * Note that there is no magical way to convert a digit like 1 into the English word one. To implement that correspondence, you will need to 
 * include explicit code - probably in the form of a switch statement - that converts each digit to its English equivalent. The important thing 
 * to think about in this assignment is how to decompose the problem so that you can reuse the same methods to translate different parts of 
 * the number. 
 */

import acm.program.*;

public class NumberToWords extends ConsoleProgram {

	public void run() {
		int n = 0;
		println("This program converts numbers to words.");
		println("To finish, enter a negative number.");
			while (true) {
				n = readInt("Enter a number: ");
				if (n < 0) {
					println("Ok, no more numbers will be converted.");
					break;
				}
				if (n < 999999) {
				println(numberToWords (n));
				}
				else println("Please enter a number bellow 1,000,000.");
			}
	}
	
	private String numberToWords (int n) {
		String numberInWords = null;
		if (n >= 0 && n <100) {
			numberInWords = zeroToHundred(n);
		}
		if (n >= 100 && n <1000) {
			numberInWords = hundredToThousand(n);
		}		
		if (n >= 1000 && n <1000000) {
			numberInWords = thousandToMillion(n);
		}
		return numberInWords;
	}
	
	private String zeroToHundred (int n) {
		String numberInWords = null;
		if (n < 10) {
			switch (n) {
				case 0:  numberInWords = ZERO; break;
				case 1:  numberInWords = ONE; break;
				case 2:  numberInWords = TWO; break;
				case 3:  numberInWords = THREE; break;
				case 4:  numberInWords = FOUR; break;
				case 5:  numberInWords = FIVE; break;
				case 6:  numberInWords = SIX; break;
				case 7:  numberInWords = SEVEN; break;
				case 8:  numberInWords = EIGHT; break;
				case 9:  numberInWords = NINE; break;
			}
		}
		else if (n >= 10 && n <14) {
			switch (n) {
				case 10:  numberInWords = TEN; break;
				case 11:  numberInWords = ELEVEN; break;
				case 12:  numberInWords = TWELVE; break;
				case 13:  numberInWords = THIRTEEN; break;
			}	
		}	
		else if (n >= 14 && n <20) { 
			numberInWords = zeroToHundred(n-10) + TEEN;
		}
		else if (n == 20 || n == 30 || n == 40 || n == 50 || n == 60 || n == 70 || n == 80 || n == 90) {
			switch (n) {
				case 20:  numberInWords = TWENTY; break;
				case 30:  numberInWords = THIRTY; break;
				case 40:  numberInWords = FOURTY; break;
				case 50:  numberInWords = FIFTY; break;
				case 60:  numberInWords = SIXTY; break;
				case 70:  numberInWords = SEVENTY; break;
				case 80:  numberInWords = EIGHTY; break;
				case 90:  numberInWords = NINETY; break;
			}	
		}
		else {
			numberInWords = zeroToHundred((n / 10) * 10) + "-" + zeroToHundred(n - (n / 10) * 10);
		}
		return numberInWords;
	}
	
	private String hundredToThousand (int n) {
		String numberInWords = null;
		if (n < 100) {
			numberInWords = zeroToHundred(n);
		}
		else if (n == 100 || n == 200 || n == 300 || n == 400 || n == 500 || n == 600 || n == 700 || n == 800 || n == 900) {
			numberInWords = zeroToHundred(n/100) + " " + HUNDRED;
		}
		else {
			numberInWords = hundredToThousand((n / 100) * 100) + AND + zeroToHundred(n - (n / 100) * 100);
		}	
		return numberInWords;
	}

	private String thousandToMillion (int n) {
		String numberInWords = null;
		numberInWords = hundredToThousand(n/1000) + " " + THOUSAND + ", " + hundredToThousand(n - (n / 1000) * 1000);
		return numberInWords;
	}
	
	private static final String ZERO = "zero";
	private static final String ONE = "one";
	private static final String TWO = "two";
	private static final String THREE = "three";
	private static final String FOUR = "four";
	private static final String FIVE = "five";
	private static final String SIX = "six";
	private static final String SEVEN = "seven";
	private static final String EIGHT = "eight";
	private static final String NINE = "nine";
	private static final String TEN = "ten";
	private static final String ELEVEN = "eleven";
	private static final String TWELVE = "twelve";
	private static final String THIRTEEN = "thirteen";
	private static final String TEEN = "teen";
	
	private static final String TWENTY = "twenty";
	private static final String THIRTY = "thirty";
	private static final String FOURTY = "fourty";
	private static final String FIFTY = "fifty";
	private static final String SIXTY = "sixty";
	private static final String SEVENTY = "seventy";
	private static final String EIGHTY = "eighty";
	private static final String NINETY = "ninety";
	
	private static final String HUNDRED = "hundred";
	private static final String THOUSAND = "thousand";
	private static final String AND = " and ";


}
