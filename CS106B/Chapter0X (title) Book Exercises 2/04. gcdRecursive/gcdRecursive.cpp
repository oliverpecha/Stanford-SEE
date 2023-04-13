/*
 * File: gcdRecursive.cpp
 * --------------
 * The greatest common divisor (often abbreviated to gcd) of two nonnegative integers is the largest
 * integer that divides evenly into both. In the third century BCE, the Greek mathematician Euclid
 * discovered that the greatest common divisor of x and y can always be computed as follows:
 * • If x is evenly divisible by y, then y is the greatest common divisor.
 * • Otherwise, the greatest common divisor of x and y is always equal to the
 * greatest common divisor of y and the remainder of x divided by y.
 * Use Euclid’s insight to write a recursive function gcd(x, y) that computes the
 * greatest common divisor of x and y.
 *
 */

#include "console.h"
#include "simpio.h"
#include <cmath>
using namespace std;

int gcd(int nx, int y);
int remainder (int x, int y);


int main() {
    int x = 0;
    int y = 0;

    while (x > -1 && y > -1) {
        x = getInteger("What is the 1st number to calculate gcd?");
        y = getInteger("What is the 2nd number to calculate gcd?");
        cout << "gcd is " << gcd(x,y) << endl;
        cout << "\n " << endl;
    }
    return 0;
}


int gcd(int x, int y){
    if (std::fmod(x/(y+0.0), 1) == 0) return y;
    else return gcd(y, remainder(x,y));
}

int remainder (int x, int y){
    return x % y;
}
