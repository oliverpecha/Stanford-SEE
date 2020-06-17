/*
 * File: OrdinalNumbers.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 10
 * -----------------
 *  Like most other languages, English include two types of numbers: cardinal numbers (such as one, two, three, and four) that are used in counting, 
 *  and ordinal numbers (such as first, second, third, and fourth) that are used to indicate a position in a sequence. In numeric form, ordinals 
 *  are usually indicated by writing the digits in the number, followed by the last two letters of the English word that names the corresponding 
 *  ordinal. Thus, the ordinal numbers first, second, third, and fourth often appear in print as 1st, 2nd, 3rd, and 4th.
 *  The general rule for determining the suffix of an ordinal can be defined as follows:
 *  Numbers ending in the digit 1, 2, and 3, take the suffixes "st", "nd", and "rd", respectively, unless the number ends with the two- digit 
 *  combination 11, 12, or 13. Those numbers, and any numbers not ending with a 1, 2, or 3, take the suffix "th".
 *  Your task in this problem is to write a function ordinalForm(n) that takes an integer n and returns a string indicating the corresponding 
 *  ordinal number. For example, your function should return the following values:
 *  		ordinalForm(1)		returns the string		"1st"
 *  		ordinalForm(2)		returns the string		"2nd"
 *  		ordinalForm(3)		returns the string		"3rd"
 *  		ordinalForm(10)		returns the string		"10th"
 *  		ordinalForm(11)		returns the string		"11th"
 *  		ordinalForm(12)		returns the string		"12th"
 *  		ordinalForm(21)		returns the string		"21st"
 *  		ordinalForm(42)		returns the string		"42nd"
 *  		ordinalForm(101)	returns the string		"101st"	
 *  		ordinalForm(111)	returns the string		"111th"	
 */

import acm.program.*;

public class OrdinalNumbers extends ConsoleProgram {

	public void run() {
		println(ordinalForm(1));
		println(ordinalForm(2));
		println(ordinalForm(3));
		println(ordinalForm(8));
		println(ordinalForm(10));
		println(ordinalForm(11));
		println(ordinalForm(12));
		println(ordinalForm(21));
		println(ordinalForm(42));
		println(ordinalForm(101));
		println(ordinalForm(111));
		
	}
	
	private String ordinalForm(int cardinal) {
		// cast int cardinal into String
		String ordinal = "" + cardinal;
		// find last character
		int cardinalLenght = ordinal.length();
		int lastIndex = cardinalLenght - 1;
		int beforeLastIndex = cardinalLenght - 2;
		char lastChar = ordinal.charAt(lastIndex);
		// A. if 1, 2 or 3
		if (lastChar == '1' || lastChar == '2' || lastChar == '3') {
		//		check previous character if cardinal had more than one digit
				if (cardinalLenght > 1) {
					lastChar = ordinal.charAt(beforeLastIndex);
					if (lastChar != '1') {
						lastChar = ordinal.charAt(lastIndex);
						switch (lastChar) {
						case '1': ordinal = ordinal.concat("st"); break;
						case '2': ordinal = ordinal.concat("nd"); break;
						case '3': ordinal = ordinal.concat("rd"); break;
						}
					}
					else ordinal = ordinal.concat("th");
				}
		//		Aa. if it is a 1 add "th"
		//		Ab. else, to 1, add "st", to 2, add "nd", to 3, add "rd"
				else 	{
					lastChar = ordinal.charAt(lastIndex);
					switch (lastChar) {
					case '1': ordinal = ordinal.concat("st"); break;
					case '2': ordinal = ordinal.concat("nd"); break;
					case '3': ordinal = ordinal.concat("rd"); break;
					}
				}
		}
		// B. all other cases
		// 		add "th" at the end of the string
		else ordinal = ordinal.concat("th");
		return ordinal;
	}
}
