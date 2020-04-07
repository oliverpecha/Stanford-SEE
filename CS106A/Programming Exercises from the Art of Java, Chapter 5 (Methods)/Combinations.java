/*
 * File: Combinations.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise Bonus 9
 * -----------------
 * The values of the combinations method used in the text are often displayed in the form of a 
 * triangle using the following arrangement:
 * 								C(0,0)
 * 							C(1,0) C(1,1)
 * 						C(2,0) C(2,1) C(2,2)
 * 					C(3,0) C(3,1) C(3,2) C(3,3) 
 * 				C(4,0) C(4,1) C(4,2) C(4,3) C(4,4)
 * and so on. 
 * This figure is called Pascal’s Triangle after the seventeenth-century French mathematician 
 * Blaise Pascal, who described it, even though it was known by Chinese mathematicians over 2000 years ago. 
 * Pascal’s Triangle has the interesting property that every interior entry is the sum of the two entries above it.
 *  */

import acm.program.*;
import acm.graphics.*;

public class Combinations extends GraphicsProgram {

	public void run() {
			
		for (int v = 0; v <= 4; v++) {
			int r = -1;
			for (int h = 4; h >= 4 - v; h--) {
				r++;
				int x1 = 30 * v;
				int x2 = 60 * r;
				int xOper = 300 + x2 - x1;
				
				GLabel label = new GLabel("C(" + v + "," + r + ")");
		        add(label, xOper, 140 + 30 * v );
		        
				System.out.println("C(" + v + "," + r + ") /// " + "" + x1 + "-" + x2 + "= " + xOper + ", " + (200 + 30 * v));
			}
		}
		
		
	}

/*
 * Returns the mathematical combinations function C(n, k),
 * which is the number of ways of selecting k objects
 * from a set of n distinct objects.
 */
	private int combinations(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}

/*
 * Returns the factorial of n, which is defined as the
 * product of all integers from 1 up to n.
 */
	private int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

}
