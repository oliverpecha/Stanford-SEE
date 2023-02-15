/*
 * File: roundToNearestInt.cpp
 * --------------
 * When a floating-point number is converted to an integer in C++, the value is truncated by throwing away
 * any fraction. Thus, when 4.99999 is converted to an integer, the result is 4. In many cases, it would be useful
 * to have the option of rounding a floating-point value to the nearest integer. Given a positive floating-point number x,
 * you can round it to the closest integer by adding 0.5 and then truncating the result to an integer.
 * Because truncation always moves toward zero, rounding negative numbers requires you to subtract 0.5, rather than adding it.
 *
 * Write a function roundToNearestInt(x) that rounds the floating-point number x to the nearest integer.
 * Show that your function works by writing a suitable main program to test it.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

int roundToNearestInt (double n);

int main() {
    double n = getDouble("What number do you want to round?");
    cout << "Rounded number is " << roundToNearestInt(n) << endl;
    return 0;
}

int roundToNearestInt (double n) {
    if (n < 0) {
        return n - .5;
    }
    else {
        return n + .5;
    }
}
