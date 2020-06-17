/*
 * File: Darts.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 6 / Programming Exercise 3
 * -----------------
 *  If you throw darts at this board in a random fashion, some will fall inside the circle, but some will fall outside. 
 *  If the tosses are truly random, the ratio of the number of darts that land inside the circle to the total number of darts 
 *  hitting the square should be roughly equal to the ratio between the two areas. The ratio of the areas is independent of the 
 *  actual size of the dart board, as illustrated by the following formula:
 * -----------------
 *  darts falling inside the circle ≅ area of the circle = π r 2 = π 
 *  darts falling inside the square area of the square 4r 2 4
 * -----------------
 * To simulate this process in a program, imagine that the dart board is drawn in the standard Cartesian coordinate plane you learned 
 * about in high school. The process of throwing a dart randomly at the square can be modeled by generating two random numbers, x and y, 
 * each of which lies between –1 and 1. This (x, y) point always lies somewhere inside the square. The point (x, y) lies inside the circle if
 *  √ x + y < 1
 *  This condition, however, can be simplified considerably by squaring each side of the inequality, which gives the following 
 *  more efficient test:
 *  x2 + y2 < 1
 *  If you perform this simulation many times and compute the fraction of darts that fall within the circle, the result will be somewhere 
 *  in the neighborhood of π/4.
 *  Write a program that simulates throwing 10,000 darts and then uses the simulation technique described in this exercise to generate 
 *  and display an approximate value of π. Don’t worry if your answer is correct only in the first few digits. The strategy used in this 
 *  problem is not particularly accurate, even though it occasionally proves useful as a technique for making rough approximations. 
 *  In mathematics, this technique is called Monte Carlo integration, after the gambling center that is the capital city of Monaco.
 */

import acm.program.*;
import acm.util.RandomGenerator;

	
public class Darts extends ConsoleProgram {
	
	private RandomGenerator luck = RandomGenerator.getInstance();
	
	public void run() {
		
		double y = 0;
		double x = 0;
		double inside = 0;
		double outside = 0;		
		for (int t = 0; t < 10000; t++) {
			x = luck.nextDouble(-1, 1);
			y = luck.nextDouble(-1, 1);
			if (x * 2 + y * 2 < 1) {
				inside++;
			}
			else {
				outside++;
			}
		}
		System.out.println("inside " + inside + ", outside: " + outside);
		System.out.println("inside / outside: " + inside / outside);
		System.out.println("outside / inside: " + outside / inside);

	}

	//
}
