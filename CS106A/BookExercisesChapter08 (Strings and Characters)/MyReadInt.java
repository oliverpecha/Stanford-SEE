
/*
 * File: MyReadInt.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise 12
 * -----------------
 * Suppose that the ConsoleProgram class did not include the readInt method to read an integer from the console and supported only the readString 
 * method. Write a method
 * 		private int myReadInt(String prompt)
 * that simulates the operation of readInt by reading in a line and then translating the characters from that line into an integer. Your 
 * implementation of myReadInt should allow the input to begin with a - character to signal a negative value. Except fot that special case, 
 * however, your implementation should indicate an error if it finds any characters other than the standard decimal digits. As with the readInt 
 * method in acm.io, your implementation should note that error by printing a message and asking the user to enter a new value, as shown in the 
 * following sample run of the Add2Integers program from Chapter2:
 * -----------------
 * This program adds two integers.
 * Enter n1: 17
 * Enter n2: 3.1416
 * Illegal integer format
 * Enter n2:
 * The total is 42.
 * -----------------
 */

import acm.program.*;

public class MyReadInt extends ConsoleProgram{

	public void run() {
		String inputString = "";
		int n1 = 0;
		int n2 = 0;
		int inputInt = 0;
		boolean onlyNumbers = true;
		boolean ready = false;
		
		while (!ready) {
			while (onlyNumbers) {
				inputString = readLine("\nEnter n1: ");	
				onlyNumbers = onlyNumbers(inputString);
				System.out.println("n1 onlyNumbers is " + onlyNumbers);
				if (onlyNumbers) {
					n1 = myReadInt(inputString);
					break;
				}
				else {
					println("Illegal integer format");
					onlyNumbers = true;
				}
			}
			while (onlyNumbers) {
				inputString = readLine("Enter n2: ");
				onlyNumbers = onlyNumbers(inputString);
				System.out.println("n2 onlyNumbers is " + onlyNumbers);
				if (onlyNumbers) {
					n2 = myReadInt(inputString);
					break;
				}
				else {
					println("Illegal integer format");
					onlyNumbers = true;
				}
			}
			
			println("The total is " + (n1 + n2));
		}
		
	}
	private int myReadInt(String inputString) {
		int number = Integer.parseInt(inputString);
		return number;
	}
	
	private boolean onlyNumbers(String inputString) {
		boolean onlyNumbers = true;
		int inputLenght = inputString.length();
		int s = 0;
		boolean isMinus = inputString.charAt(0) == '-';
		if (isMinus) s = 1;
		System.out.println("is it minus? " + isMinus);
		while (onlyNumbers) {
			Character currentChar = new Character(inputString.charAt(s));
			onlyNumbers = Character.isDigit(currentChar);
			if (s == inputLenght-1) break;
			s++;	
		}
		return onlyNumbers;
	}
}
