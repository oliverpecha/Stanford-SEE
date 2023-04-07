/*
* File: rational.cpp
* --------------------
* This file implements the Rational class.
*/

#include <string>
#include <cstdlib>
#include "error.h"
#include "rational.h"
#include "strlib.h"
using namespace std;

/* Function prototypes */
int gcd (int x, int y);
int lcm (int a, int b);
void equivalentLCDfraction(Rational & r1, Rational & r2);



/*
* Implementation notes: Constructors
*
* There are three constructors for the Rational class. The default
* constructor creates a Rational with a zero value, the one-argument
* form converts an integer to a Rational, and the two-argument form
* allows specifying a fraction. The constructors ensure that
* the following invariants are maintained:
*
* 1. The fraction is always reduced to lowest terms.
* 2. The denominator is always positive.
* 3. Zero is always represented as 0/1.
*/

Rational:: Rational () {
    num = 0;
    den = 1;
}

Rational:: Rational (int n) {
    num = n;
    den = 1;
}


Rational::Rational (int x, int y) {
    if (y == 0) error("Rational: Division by zero");
    if (x == 0) {
        num = 0;
        den = 1;
    } else {
        int g = gcd (abs(x), abs (y));
        num = x / g;
        den = abs(y) / g;
    }
    if (y < 0) num = -num;
}



/* Implementation of toString and the << operator */
string Rational::toString() {
    if (den == 1) {
        return integerToString (num);
    } else {
        return integerToString(num) + "/" + integerToString (den);
    }
}

ostream & operator<< (ostream & os, Rational rat) {
    return os << rat.toString();
}

/*
* Implementation notes: arithmetic operators
* ---------------------------------------------
* The implementation of the operators follows directly from the definitions.
*/
Rational operator+ (Rational r1, Rational r2) {
    return Rational (r1.num * r2.den + r2.num * r1.den, r1.den * r2.den);
}

Rational operator- (Rational r1, Rational r2) {
    return Rational (r1.num * r2.den - r2.num * r1.den, r1.den * r2.den);
}

Rational operator* (Rational r1, Rational r2) {
    return Rational (r1.num * r2.num, r1.den * r2.den);
}

Rational operator/ (Rational r1, Rational r2) {
    return Rational (r1.num * r2.den, r1.den * r2.num);
}


/*
* Shorthand assignment operators
* ---------------------------------------------
*/
void operator+= (Rational & r1, Rational r2) {
    r1 = r1 + r2;
}

void operator-= (Rational & r1, Rational r2) {
    r1 = r1 - r2;
}

void operator*= (Rational &r1, Rational r2) {
    r1 = r1 * r2;
}

void operator/= (Rational & r1, Rational r2) {
    r1 = r1 / r2;
}

/*
* Relational operators ==, !=, <, <=, >, and >=
* ---------------------------------------------
*/
bool operator== (Rational r1, Rational r2){
    if (r1.den == r2.den && r1.num == r2.num) return true;
    else return false;
}
bool operator!= (Rational r1, Rational r2){
    if (!(r1 == r2)) return true;
    else return false;
}

bool operator< (Rational r1, Rational r2){
    equivalentLCDfraction(r1, r2);
    if (r1.num < r2.num) return true;
    else return false;
}

bool operator<= (Rational r1, Rational r2) {
    equivalentLCDfraction(r1, r2);
    if (r1.num <= r2.num) return true;
    else return false;
}

bool operator> (Rational r1, Rational r2) {
    equivalentLCDfraction(r1, r2);
    if (r1.num > r2.num) return true;
    else return false;
}

bool operator>= (Rational r1, Rational r2){
    equivalentLCDfraction(r1, r2);
    if (r1.num >= r2.num) return true;
    else return false;
}


/*
* Implementation notes: Shorthand assignment operators
* ---------------------------------------------
*/
void operator++ (Rational & r1) {
    r1 = r1 + 1;
}

Rational operator++ (Rational r1, int) {
    return r1 + 1;
}

void operator-- (Rational & r1) {
    r1 = r1 - 1;
}

Rational operator-- (Rational r1, int) {
    return r1 - 1;
}


/*
* Implementation notes: gcd
* ----------------------------------
* This implementation uses Euclid's algorithm to calculate the
greatest common divisor.
*
*/

int gcd (int x, int y) {
    int r = x % y;
    while (r != 0) {
        x = y;
        y = r;
        r = x % y;
    }
    return y;
}

/*
* Implementation notes: lcm
* ----------------------------------
* This implementation calculates the lowest common divisor.
*
*/

int lcm (int a, int b) {
   //int a=7, b=5, lcm;
   int lcm;
   if (a > b) lcm = a;
   else lcm = b;
   while (1) {
      if (lcm % a == 0 && lcm % b == 0) {
        //cout << "The LCM of " << a << " and " << b << " is " << lcm;
        break;
      }
      lcm++;
   }
   return lcm;
}

/*
* Implementation notes: equivalentLCDfraction
* ----------------------------------
* This implementation modifies Rational objects to have an equivalent fraction
* using LCD method.
*
*/
void equivalentLCDfraction(Rational & r1, Rational & r2) {
    int iLcm = lcm(r1.den, r2.den);
    r1.num = r1.num * iLcm / r1.den;
    r1.den = r1.den * iLcm / r1.den;
    r2.num = r2.num * iLcm / r2.den;
    r2.den = r2.den * iLcm / r2.den;
}
