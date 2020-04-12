/*
 * File: RationalTest.java
 * -----------------------
 * Simple test of the Rational class.
 */

import acm.program.*;
import java.math.BigInteger;

public class RationalTest extends ConsoleProgram {

	public void run() {
		BigInteger one  = new BigInteger("1"); 
		BigInteger two  = new BigInteger("2"); 
		BigInteger three = new BigInteger("3"); 
		BigInteger six  = new BigInteger("6"); 

		Rational a = new Rational(one, two);
		Rational b = new Rational(one, three);
		Rational c = new Rational(one, six);
		Rational sum = a.add(b).add(c);
		println(a + " + " + b + " + " + c + " = " + sum);
		testDoubles();
	}

	public void testDoubles() {
		double a = 1.0 / 2.0;
		double b = 1.0 / 3.0;
		double c = 1.0 / 6.0;
		double sum = a + b + c;
		println(a + " + " + b + " + " + c + " = " + sum);
	}

}
