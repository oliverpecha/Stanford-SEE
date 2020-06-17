/*
 * File: MyIndexOf.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 8 / Programming Exercise Bonus 6
 * -----------------
 *  If the designers of the String class had not defined the version of indexOf that takes a string argument, you could implement it using the 
 *  other methods available in the library. Without calling indexOf directly, implement a method myIndexOf that behaves in exactly the same way.
 */

import acm.program.*;

public class MyIndexOf extends ConsoleProgram {

	
	public void run() {
		String testword = "Tomorrowland Holland";
		String extract = "land";
		int startSearchPosition = 9;
		int landStart = myIndexOf(testword, extract, startSearchPosition);
		if (landStart >= 0)	System.out.println("\n\nIn " + testword + ", " + extract + " is found at " + landStart + "th position.");		
		if (landStart < 0)	System.out.println("\n\n" + extract +  " was not found in " + testword + ".");		

	}
	
	
	
	// Returns the index of the first ocurrence of the character or string, or -1 if it does not appear.
	public int myIndexOf(String testword, String extract){
		int start = 0;
		int index = myIndexOf(testword, extract, start);
		return index;
	}
	
	private int myIndexOf(String testword, String extract, int start){
		// evaluate how long testword is
		// evaluate how long extract is
		// for as long as there are characters
		// isolate n character of extract
		// isolate n character of testword
		// compare them
		// A. 	if equal, return position to index (OR something else)
		// 		check next character of testword and extract
		//		if number of equals is equal to length of extract return first position of equality
		// B. if not equal, go to next position in testword, until testword or extract word are over.
		//		if not equality is found, return -1
		int index = 0;
		int semblanceCounter = 0;
		int extractLenght = extract.length();
		int testWordLenght = testword.length();
		System.out.println("extractLenght is " + extractLenght + ", and testWordLenght is " + testWordLenght);
		for (int i = 0; i < extractLenght; i++) {
			for (int n = start; n < testWordLenght; n++) {
				char extractChar = extract.charAt(i);
				char testwordChar = testword.charAt(n);
				System.out.println("at i " + i + ", n " + n + ", extractChar is " + extractChar + ", testwordChar is " + testwordChar);
				if (extractChar == testwordChar) {
					semblanceCounter++;
					n = testWordLenght;
					System.out.println("*******************************\nSemblance Found!!\nsemblanceCounter is now " + semblanceCounter + "\n*******************************");
				}
			if (semblanceCounter == extractLenght) index = testWordLenght - semblanceCounter;
			else index = -1;
			}
		}
		System.out.println("index will return " + index);
		return index;
	}

}
