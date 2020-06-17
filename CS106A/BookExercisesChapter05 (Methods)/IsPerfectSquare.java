/*
 * File: IsPerfectSquare.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise Bonus 7
 * -----------------
 * Write a predicate method isPerfectSquare(n) that returns true if the integer n is a perfect square. Remember that the method 
 * Math.sqrt returns a double, which is therefore only an approximation of the actual square root.
 */

import acm.program.*;

public class IsPerfectSquare extends ConsoleProgram {

	public void run() {
		
		println("This Program will return if the integer n is a perfect square");
		
		double perfect = 0;
		int exchange = 0;
		int n = readInt("Enter an integer... ");
		
		perfect = Math.sqrt(n);
		System.out.println(perfect);
		exchange = (int) perfect;
		perfect = perfect - exchange;
		System.out.println(perfect);
		
		while (true) {
			if (perfect <= 0) {
				println(n + " is a perfect square");
				break;
			}
			else if (true){ 
				println(n + " is not a perfect square, try an other one");
				n = readInt("Enter an integer... ");
				perfect = Math.sqrt(n);
				System.out.println(perfect);
				exchange = (int) perfect;
				perfect = perfect - exchange;
				System.out.println(perfect);
			}		
		}
	}
	
}
