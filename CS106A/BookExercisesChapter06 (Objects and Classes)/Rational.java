
/*
 * File: Rational.java
 * -------------------
 * This file defines a simple class for representing rational numbers.
 */
import java.math.BigInteger;

/**
 * The Rational class is used to represent rational numbers, which
 * are defined to be the quotient of two integers.
 */
public class Rational {

/**
 * Creates a new Rational initialized to zero.
 */
	public Rational() {
		// original
		// this(0);
		BigInteger.valueOf(0);
	}

/**
 * Creates a new Rational from the integer argument.
 * @param n The initial value
 */
	public Rational(BigInteger n) {
		// original
		// this(n, 1);
		BigInteger one = null;
		one.valueOf(1);
		n.divide(one);
	}

/**
 * Creates a new Rational with the value x / y.
 * @param x The numerator of the rational number
 * @param y The denominator of the rational number
 */
	public Rational(BigInteger x, BigInteger y) {

		BigInteger g = gcd(x.abs(), y.abs());
		
		num = x.divide(g);
		den = y.abs().divide(g);	
		int comparevalue = y.compareTo(BigInteger.valueOf(0));
		if (comparevalue < 0) num = num.negate();
		
	}


/**
 * Adds the rational number r to this one and returns the sum.
 * @param r The rational number to be added
 * @return The sum of the current number and r
 */
	public Rational add(Rational r) {
		// original
		// return new Rational(this.num * r.den + r.num * this.den, this.den * r.den);
		// New implementation:
		// BigInteger object to store result 
			BigInteger mult1; 
			BigInteger mult2; 
			BigInteger mult3; 
			BigInteger add; 
        // Convert the string input to BigInteger 
	        BigInteger a  = this.num; 
	        BigInteger b  = r.num; 
	        BigInteger c  = this.den; 
	        BigInteger d  = r.den; 
        // Using multiply() method 
        	mult1 = a.multiply(d); 
        	mult2 = b.multiply(c);
        	mult3 = c.multiply(d); 
        	add = mult1.add(mult2);
    	// return result 
        	return new Rational(add, mult3);	
	}

/**
 * Subtracts the rational number r from this one.
 * @param r The rational number to be subtracted
 * @return The result of subtracting r from the current number
 */
	public Rational subtract(Rational r) {
		// original
		// return new Rational(this.num * r.den - r.num * this.den, this.den * r.den);
		// New implementation:
		// BigInteger object to store result 
			BigInteger mult1; 
			BigInteger mult2; 
			BigInteger mult3; 
			BigInteger substraction; 
        // Convert the string input to BigInteger 
	        BigInteger a  = this.num; 
	        BigInteger b  = r.num; 
	        BigInteger c  = this.den; 
	        BigInteger d  = r.den; 
        // Using multiply() method 
        	mult1 = a.multiply(d); 
        	mult2 = b.multiply(c);
        	mult3 = c.multiply(d); 
        	substraction = mult1.subtract(mult2);
    	// return result 
        	return new Rational(substraction, mult3);	
	}

/**
 * Multiplies this number by the rational number r.
 * @param r The rational number used as a multiplier
 * @return The result of multiplying the current number by r
 */
	public Rational multiply(Rational r) {
		// original
		// return new Rational(this.num * r.num, this.den * r.den);
		// New implementation:
		// BigInteger object to store result 
			BigInteger mult1; 
			BigInteger mult2; 
        // Convert the string input to BigInteger 
	        BigInteger a  = this.num; 
	        BigInteger b  = r.num; 
	        BigInteger c  = this.den; 
	        BigInteger d  = r.den; 
        // Using multiply() method 
        	mult1 = a.multiply(b); 
        	mult2 = c.multiply(d); 
    	// return result 
        	return new Rational(mult1, mult2);
	}

/**
 * Divides this number by the rational number r.
 * @param r The rational number used as a divisor
 * @return The result of dividing the current number by r
 */
	public Rational divide(Rational r) {
		// original
		// return new Rational(this.num * r.den, this.den * r.num); 
		// New implementation:
		// BigInteger object to store result 
			BigInteger mult1; 
			BigInteger mult2; 
	    // Convert the string input to BigInteger 
	        BigInteger a  = this.num; 
	        BigInteger b  = r.num; 
	        BigInteger c  = this.den; 
	        BigInteger d  = r.den; 
	    // Using multiply() method 
	    	mult1 = a.multiply(d); 
	    	mult2 = c.multiply(b); 
    	// return result 
	    	return new Rational(mult1, mult2);
	}

/**
 * Creates a string representation of this rational number.
 * @return The string representation of this rational number
 */
	public String toString() {
		// original
		// if (den == 1) {
		BigInteger one = null;
		one.valueOf(1);
		if (den.equals(one)) {  
			return "" + num;
		} else {
			return num + "/" + den;
		}
	}

/**
 * Calculates the greatest common divisor using Euclid's algorithm.
 * @param x First integer
 * @param y Second integer
 * @return The greatest common divisor of x and y
 */
	private BigInteger gcd(BigInteger x, BigInteger y) {
		BigInteger r = x.mod(y);
		int comparevalue = r.compareTo(BigInteger.valueOf(0));
		while (comparevalue != 0) {
			x = y;
			y = r;
			r = x.mod(y);
		}
		return y;
	}

/* Private instance variables */
	private BigInteger num;     /* The numerator of this Rational   */
	private BigInteger den;     /* The denominator of this Rational */

}
