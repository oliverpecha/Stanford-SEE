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
Creates a StringTokenizer that uses the characters in delims as token separators.
new StringTokenizer(String str, String delims, boolean returnDelims)
Creates a StringTokenizer that returns delimiters as tokens if the third argument is true.

Methods to read tokens from the token stream
boolean hasMoreTokens()
Returns true if there are more tokens to read from this StringTokenizer.
String nextToken()
Returns the next token from the token stream, signaling an error if no tokens remain.
*/

import acm.program.ConsoleProgram;

public class OwnStringTokeneizerTest extends ConsoleProgram {
	
	
	String testingStringOne = " .   The man,:  with the  red face.";
	String testingDelimeters = "!&?()_-+={[}]:;.|\\/`<,>$%";
	String inputReader = "";
	String currentToken = "";
	
	
	public void run() {
		// Creates the testingObject. Given parameters will be used to choose constructor and class behavior of the class will be affected
		OwnStringTokeneizer testingObject = new OwnStringTokeneizer(testingStringOne, testingDelimeters, true);
		
		println("This program tests OwnStringTokeneizer. \nDefault String to be tested is \"" + testingStringOne + "\"");
		if (testingObject.hasMoreTokens()) {
			while (testingObject.hasMoreTokens()) {
				inputReader = readLine("Enter yes to extract next Token. ");
				if (inputReader.contentEquals("yes")) {
					currentToken = testingObject.nextToken();
					println("\"" + currentToken + "\"");
					
				}
				if (testingObject.hasMoreTokens()) println("String still has Tokens to extract...");
			}
		}
		if (!testingObject.hasMoreTokens() && testingStringOne.length() > 0) println("String doesn't have any more Tokens to be extracted :'(");
		if (!testingObject.hasMoreTokens() && testingStringOne.length() == 0) println("This String has no Tokens to be extracted :'(");	

	}
	
	
	
	public void runOld() {
		OwnStringTokeneizer testingObject = new OwnStringTokeneizer(testingStringOne);
		println("This program tests OwnStringTokeneizer. \nDefault String to be tested is \"" + testingStringOne + "\"");
		if (testingObject.hasMoreTokens()) {
			println("String still has Tokens to extract!");
		}
		else println("String doesn't have Tokens left to extract :(");
		while (testingObject.hasMoreTokens()) {
			inputReader = readLine("Enter yes to extract more Tokens.");
			if (inputReader.contentEquals("yes")) {
				currentToken = testingObject.nextToken();
				println(currentToken);
			}
			if (testingObject.hasMoreTokens()) {
				println("String still has Tokens to extract!");
			}
		}
		
	}
	
	

}
