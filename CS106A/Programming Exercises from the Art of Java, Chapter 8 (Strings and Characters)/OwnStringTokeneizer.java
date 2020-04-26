/*
 * File: OwnStringTokeneizer.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 21
 * -------------------
 * Even though the StringTokenizer class is already part of the java.util package, you can learn a great deal about both string 
 * manipulation and class design by reimplementing StringTokenizer on your own. Write a new implementation of this class that 
 * implements the constructors and methods shown in Figure 8-5. The only aspect of the design that you don’t yet know how to 
 * implement is the feature in which calling nextToken when no tokens are available generates an error. To get around that problem, 
 * write your version of nextToken so that it returns null if no additional tokens exist.
 */

/*
Constructor
new StringTokenizer(String str)
Creates a new StringTokenizer object that reads whitespace-separated tokens from str
new StringTokenizer(String str, String delims)
Creates a StringTokenizer that uses the characters in delims as token delimitators.
new StringTokenizer(String str, String delims, boolean returnDelims)
Creates a StringTokenizer that returns delimiters as tokens if the third argument is true.

Methods to read tokens from the token stream
boolean hasMoreTokens()
Returns true if there are more tokens to read from this StringTokenizer.
String nextToken()
Returns the next token from the token stream, signaling an error if no tokens remain.
*/


public class OwnStringTokeneizer {
	
	/**
	 * Creates a new StringTokenizer object that reads whitespace-separated tokens from str
	 * @param String str contains a String including or not different tokens separated by spaces
	 */	
	public OwnStringTokeneizer(String str) {
		fullString = str;
		remainingString = str;
		delimitators = " ";
	}
	
	/**
	 * Creates a StringTokenizer that uses the characters in delims as token delimitators.
	 * @param String delims contains a String including symbols that separate tokens in str
	 */	
	public OwnStringTokeneizer(String str, String delims) {
		this(str);
		delimitators = delimitators + delims;
	}
	
	/**
	 * Creates a StringTokenizer that returns delimiters as tokens if the third argument is true.
	 * @param boolean returnDelims serves to activate when delimitators should be used returned as tokens
	 */	
	public OwnStringTokeneizer(String str, String delims, boolean returnDelims) {
		this(str, delims);
		returnDelimitators = returnDelims;
		System.out.println("Hey Ho, delimitators are: " + delimitators);
	}
	
	/**
	 * Returns true if there are more tokens to read from this StringTokenizer.
	 */	
	public boolean hasMoreTokens() {
		boolean hasMoreTokens = false;
		// If remainingString is null, just skip to the end of method where false is returned
		if (remainingString != null) {
		// Given remainingString has a String, There is two possibilities, depending on the Constructor choosing to pass delimitators as tokens or not
		// A. delimitators are NOT passed as token
		// B. delimitators are passed as token
			remainingStringLenght = remainingString.length();
			for (int i = 0; i < remainingStringLenght; i++) {
				// If character is a delimitator and they should be counted as tokens and should exit as soon as that is found
				if (isDelimitator(remainingString.charAt(i)) && returnDelimitators) {
					hasMoreTokens = true;
					i = remainingStringLenght;
				}
				// If character is NOT a delimitator it means there are more tokens, and should exit as soon as that is found
				else if (!isDelimitator(remainingString.charAt(i))) {
					hasMoreTokens = true;
					i = remainingStringLenght;
				}
				
			}
		}
		return hasMoreTokens;
	}
	
	/**
	 * 	Returns the next token from the token stream, signaling an error if no tokens remain.
	 */	
	public String nextToken() {
		String result = "";
		remainingStringLenght = remainingString.length();
		// As long as there are characters
		for (int i = 0; i < remainingStringLenght; i++) {
			System.out.println("current char \'" + remainingString.charAt(i) + "\' is");
			// If current Character is not a delimitator, then keep adding to result, which will be consolidated and sent back as soon as a delimitator is found
			if (!isDelimitator(remainingString.charAt(i))) {
				result = result + remainingString.charAt(i);
				// When last Char at remaining String has been reached, there are no more tokens, set remainingString to null to be even more explicit
				if (i == remainingStringLenght - 1) {
					remainingString = null;
					System.out.println("remainingString is: \"" + remainingString + "\". btw, fullString is " + fullString);
				}
				// When constructor asked to return delimitators as tokens, this protects: 
				// a) non-delimitators to be reset by operation found below which returns delimitator as token 
				// b) an exception caused by looking for inexistent String index when we are looking at the last char in remainingString
				if (i + 1 <  remainingStringLenght) {
					if (isDelimitator(remainingString.charAt(i + 1)) && returnDelimitators) {
						remainingString = remainingString.substring(i + 1);
						i = remainingStringLenght;
					}
				}
			}
			// When constructor asked to return delimitators as tokens, this returns delimitator character as token, and stores remainingString
			else if (isDelimitator(remainingString.charAt(i)) && returnDelimitators) {
				if (remainingString.charAt(i) != ' ') {
					result = "" + remainingString.charAt(i);
					remainingString = remainingString.substring(i + 1);
					i = remainingStringLenght;
				}
			}
			// When constructor only sends back non-delimitators, delimitators fall here
			else {
			// When last Char at remaining String has been reached, there are no more tokens, set remainingString to null to be even more explicit
				// when last char at remainingString is a delimitator, this makes it explicit that String won't contain more strings and avoid being testing loop to be reseted below
				if (i == remainingStringLenght - 1) {
					remainingString = null;
					System.out.println("tennntion remainingString is: \"" + remainingString + "\"");
				}
				else if (i != 0 ) { 
					System.out.println("result.length() is " + result.length());
					if (isDelimitator(remainingString.charAt(i - 1)) && result.length() < 1) {
						System.out.println("KABOOOOM?");
					}
					else if  (i + 1 <  remainingStringLenght) {
						if (!isDelimitator(remainingString.charAt(i + 1))) {
						// This stores remainingString when testing char is a delimitator and exits
						remainingString = remainingString.substring(i + 1);
						i = remainingStringLenght;
						System.out.println("Attention! remaining String is \"" + remainingString + "\"");
						}
					}
				}
   			}
		}
		return result;
	}
	
	/**
	 * 	Returns true if character being tested is included inside delimitators String.
	 */	
	private boolean isDelimitator(char currentChar) {
		boolean result = false;
		char currentDelim = 0;
		delimitatorsLenght = delimitators.length();
		// test currentChar against delimiators for as many times as there is chars inside delimitators String 
		for (int i = 0; i < delimitatorsLenght; i++) {
			currentDelim = delimitators.charAt(i);
			// whenever a match is found for exit of for loop and return true as result
			if (currentChar == currentDelim) {
				result = true;
				i = delimitatorsLenght;
			}
		}
		return result;
	}
	
	private String fullString = "";
	// private String parsedString = "";
	private String remainingString = "";
	private String delimitators = "";
	private int remainingStringLenght = 0;
	private int delimitatorsLenght = 0;
	private boolean returnDelimitators = false;

}
