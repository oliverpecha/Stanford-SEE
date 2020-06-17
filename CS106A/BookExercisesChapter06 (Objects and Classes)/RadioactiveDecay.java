/*
 * File: RadioactiveDecay.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 6 / Programming Exercise 4
 * -----------------
 *  Despite Einstein’s metaphysical objections, the current models of physics, and particularly of quantum theory, are based on the 
 *  idea that nature does indeed involve random processes. A radioactive atom, for example, does not decay for any specific reason that 
 *  we mortals understand. Instead, that atom has a random probability of decaying within a period of time. Sometimes it does, sometimes 
 *  it doesn’t, and there is no way to know for sure.
 *  Because physicists consider radioactive decay a random process, it is not surprising that random numbers can be used to simulate that 
 *  process. Suppose you start with a collection of atoms, each of which has a certain probability of decaying in any unit of time. 
 *  You can then approximate the decay process by taking each atom in turn and deciding randomly whether it decays, considering the 
 *  probability.
 *  Write a program that simulates the decay of a sample that contains 10,000 atoms of radioactive material, where each atom has a 
 *  50 percent chance of decaying in a year. The output of your program should show the number of atoms remaining at the end of each year, 
 *  which might look something like this:
 *  As the numbers indicate, roughly half the atoms in the sample decay each year. In physics, the conventional way to express this observation 
 *  is to say that the sample has a half-life of one year.
 */


import acm.program.*;
import acm.util.RandomGenerator;

	
public class RadioactiveDecay extends ConsoleProgram {
	
	private RandomGenerator luck = RandomGenerator.getInstance();
	
	
	public void run() {
		
		int decayed = RADIOACTIVE_MATERIAL;
		int year = 0;
		
		println("There are " + RADIOACTIVE_MATERIAL + " atoms initially");	
		while (decayed > 0) {
			for (int i = decayed; i > 0; i--) {
				if (luck.nextBoolean()) decayed--;
				if (i == 1) {
					year++;
					println("There are " + decayed + " atoms at the end of year " + year);
				}
			}
		}
	}
	private static final int RADIOACTIVE_MATERIAL = 10000;
}
