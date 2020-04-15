/*
 * File: Capitalize.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 3
 * -----------------
 *  Implement a method capitalize(str) that returns a string in which the initial character is capitalized (if it is a letter) and all other letters 
 *  are converted so that they appear in lowercase form. Characters other than letters are not affected. For example, capitalize("BOOLEAN") and 
 *  capitalize("boolean") should each return the string "Boolean".
 */

public class Capitalize {
	
	public Capitalize(String str) {
		word = str;
	}

	public void setCapitalize() {
		String str = toLowercases(word);
		word = firstCapital(str);
		return;
	}
	
	public String toLowercases(String str) {
		str = str.toLowerCase();
		return str;
	}
	
	private String firstCapital(String str) {
		String first = "" + str.charAt(0);
		first = first.toUpperCase();
		String remainder = str.substring(1); 
		return first + remainder;
	}
	
	public String toString() {
		return "" + word;
	}
	
	private String word = "";
}
