/*
 * File: IsPalindromeRecursive.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 14 / Programming Exercise 4
 * -----------------
 */

import acm.program.*;

public class IsPalindromeRecursive extends ConsoleProgram {

	public void run() {
		println("A list of words are tested below");
		println(TEST_ONE + isPalindrome(TEST_ONE));
		println(TEST_TWO + isPalindrome(TEST_TWO));
		println(TEST_THREE + isPalindrome(TEST_THREE));
		println(TEST_FOUR + isPalindrome(TEST_FOUR));
		println(TEST_FIVE + isPalindrome(TEST_FIVE));
		println(TEST_SIX + isPalindrome(TEST_SIX));
		println(TEST_SEVEN + isPalindrome(TEST_SEVEN));
		println(TEST_EIGHT + isPalindrome(TEST_EIGHT));
		println(TEST_NINE + isPalindrome(TEST_NINE));	
	}
	
	private String isPalindrome(String str) {
		int strLenght = str.length();
		int l, r;
		l = strLenght / 2 - 1;
		if (strLenght % 2 == 1) r = l + 2;
		else r = l + 1;
		if (recursion(l , r, str))return " is a palindrome!";
		else return " is not a palindrome...";
	}
	
	private boolean recursion(int l, int r, String str) {
		if (str.charAt(l) != str.charAt(r)) return false;
		if (str.charAt(r) == str.charAt(str.length()-1)) return true;
		return recursion(l - 1, r + 1, str);	
	}
	
	private static final String TEST_ONE = "kayak";
	private static final String TEST_TWO = "boss";
	private static final String TEST_THREE = "fuzz";
	private static final String TEST_FOUR = "box";
	private static final String TEST_FIVE = "radar";
	private static final String TEST_SIX = "airplane";
	private static final String TEST_SEVEN = "level";
	private static final String TEST_EIGHT = "racecar";
	private static final String TEST_NINE = "deed";

	
}
