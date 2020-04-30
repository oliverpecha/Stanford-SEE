/*
 * File: PascaleTriangle.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 10
 * -----------------
 * Chapter 5 introduced the function combinations (n,k), which returns the number of ways in which one can choose k items out of a 
 * set of n distinct objects. One of the classic ways to visualize the combinations function is called Pascal’s Triangle after the 
 * seventeenth-century French mathematician Blaise Pascal, even tough it was known by Chinese mathematicians over 2000 years ago. 
 * The top row of the triangle contains the entry combinations(0,0). The next row contains combinations(1,0) and combinations(1,1). 
 * The pattern continues from there, with n increasing as you move downward and k increasing as you move across the triangle from 
 * left to right, as shown in the following diagram:
 * -----------------
 * In the triangle, each value along the left or right edge is simply 1, and each value in the interior of the triangle is the sum of 
 * the two values diagonally above it to the left and right.
 * Write a GraphicsProgram that displays the first several rows of Pascal’s Triangle as shown in the following sample run:
 * The top circle should be centered horizontally a few pixels below the top of the window. Your program should then generate additional 
 * rows of the triangle as long as all the circles in the new tow will fit on the canvas. As soon as the circles in a row would extends 
 * past the sides or the bottom of the window, your program should top.
*/

import acm.program.*;

import java.awt.Color;

import acm.graphics.*;

public class PascaleTriangle extends GraphicsProgram {

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}
	public void run() {
		//add( new GLine(SCREEN_WIDTH / 2,3000, SCREEN_WIDTH/2,-3000));
		int topMargin = 10;
		int rowMargin = 55;
		int wrapRadius = 18;
		int rowHeight = rowMargin + 2 * wrapRadius;
		int maxRows = SCREEN_HEIGHT / rowHeight * 2;
		for (int v = 0; v < maxRows - 1 ; v++) {
			int r = -1;
			for (int h = 4; h >= 4 - v; h--) {
				r++;
				int x1 = 30 * v;
				int x2 = 60 * r;
				int xOper = SCREEN_WIDTH / 2 + x2 - x1;
				GLabel  label = new GLabel("" + combinations(v,r));
						label.setFont("-17");
				GOval   wrap = new GOval(2 * wrapRadius, 2 * wrapRadius);
				add(wrap, xOper - wrapRadius, topMargin + rowMargin * v );
		        add(label, xOper - 0.45 * label.getWidth(), topMargin + rowMargin * v + wrapRadius + 0.32 * label.getHeight());
		        
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

	private static final int SCREEN_WIDTH = 500;
	private static final int SCREEN_HEIGHT = 400;
}








