/*
* File: rational.h
*
* This interface exports a class for representing rational numbers.
*/
#ifndef _rational_h
#define _rational_h
#include <string>
#include <iostream>




/*
* Class: Rational
*
* The Rational class is used to represent rational numbers, which
* are defined to be the quotient of two integers.
*/

class Rational {

public:


    int num;
    int den;
/*
* Constructor: Rational
* Usage: Rational zero;
*        Rational num (n);
*        Rational r(x, y);
* --------------------------
* Creates a Rational object. The default constructor creates the
* rational number 0. The single-argument form creates a rational
* equal to the specified integer, and the two-argument form creates
* a rational number corresponding to the fraction x/y.
*/

    Rational ();
    Rational (int n);
    Rational (int x, int y);

/* Method: toString()
* Usage: string str = r.toString();
* ---------------------------------
* Returns the string representation of this rational number.
*/
    std::string toString();

/* Declare the operator functions as friends */
    friend Rational operator+ (Rational rl, Rational r2);
    friend Rational operator- (Rational rl, Rational r2);
    friend Rational operator* (Rational rl, Rational r2);
    friend Rational operator/ (Rational rl, Rational r2);

};

/*
* Operator: <<
* -------------
* Overloads the << operator so that it is able to display Rational values.
*/

std::ostream & operator<<(std::ostream & os, Rational rat);

/*
* Operator: +
* Usage: r1 + r2
* ----------------
* Overloads the + operator so that it performs addition on two
* rational numbers.
*/

Rational operator+(Rational r1, Rational r2);

/*
* Operator:
* Usage: r1 - r2
* ---------------
* Overloads the * operator so that it performs subtraction on two
* rational numbers.
*/

Rational operator-(Rational r1, Rational r2);
/*
* Operator: *
* Usage: r1 r2
* ---------------
* Overloads the operator so that it performs multiplication on two
* rational numbers.
*/
Rational operator*(Rational r1, Rational r2);
/*
* Operator: /
* Usage: r1 r2
* -----------------
* Overloads the operator so that it performs division on two
* rational numbers.
*/
Rational operator/(Rational r1, Rational r2);

// Relational operators ==, !=, <, <=, >, and >=
bool operator== (Rational r1, Rational r2);
bool operator!= (Rational r1, Rational r2);
bool operator< (Rational r1, Rational r2);
bool operator<= (Rational r1, Rational r2);
bool operator> (Rational r1, Rational r2);
bool operator>= (Rational r1, Rational r2);

//Shorthand assignment operators +=, -=, *=, and /=
void operator+= (Rational & r1, Rational r2);
void operator-= (Rational & r1, Rational r2);
void operator*= (Rational & r1, Rational r2);
void operator/= (Rational & r1, Rational r2);

// The ++ and -- operators in both their prefix and suffix form.
void operator++ (Rational & r1);
Rational operator++ (Rational r1, int);
void operator-- (Rational & r1);
Rational operator-- (Rational r1, int);


#endif



