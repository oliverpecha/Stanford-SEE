/*
 * File: GCTest.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 7 / Programming Exercise 4
 * -----------------
 *  The Runtime class in the java.lang package includes a few simple methods that may help you get a better sense of 
 *  what Java’s garbage collector does. A Runtime object maintains information about the state of the Java Virtual Machine. 
 *  If you want to look at that information, you can get the current runtime environment by calling the static method getRuntime() 
 *  and storing the result in a variable like this:
 *       Runtime myRuntime = Runtime.getRuntime();
 *  Once you have this variable, you can find out how much free memory is available by calling
 *       myRuntime.freeMemory();
 *  Because memory sizes can be large, the value returned by freeMemory is a long rather than an int and indicates the number of bytes available. You can also explicitly trigger the garbage collector by calling
 *            myRuntime.gc();
 *  Write a program that allocates 10000 Rational objects without saving any of them in variables so that they all become garbage. Once you’ve done so, measure the amount of free memory before and after garbage collection and use the difference to report how many bytes were freed, as shown in the following sample run:
 *  =======================GCTest==================================
 *  Allocating 10000 Rational objects 
 *  Garbage collection freed 94140 bytes
 *  ===============================================================
 */

import acm.program.*;

public class GCTest extends ConsoleProgram {
	
	Runtime myRuntime = Runtime.getRuntime();
	
	public void run() {
		println("Allocating " + MASSIVE + " Rational objects.");
		for (int i = MASSIVE; i > 0; i--) {
			Rational bundle = new Rational(i);
		}
		long availableFirst = myRuntime.freeMemory();
		System.out.println("availableFirst is " + availableFirst);
		myRuntime.gc();
		long availableSecond = myRuntime.freeMemory();
		System.out.println("availableSecond is " + availableSecond);
		long result = availableSecond - availableFirst;
		println("Garbage collection freed "+ result +" bytes.");
	}
	
	private static final int MASSIVE = 10000;
}
