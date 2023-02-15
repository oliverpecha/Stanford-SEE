/*
 * File: isPerfect.cpp
 * --------------
 * Greek mathematicians took a special interest in numbers that are equal to the sum of their
 * proper divisors (a proper divisor of n is any divisor less than n itself). They called such
 * numbers perfect numbers. For example, 6 is a perfect number because it is the sum of 1, 2, and 3,
 * which are the integers less than 6 that divide evenly into 6. Similarly, 28 is a perfect number
 * because it is the sum of 1, 2, 4, 7, and 14.
 *
 * Write a predicate function isPerfect that takes an integer n and returns true if n is perfect,
 * and false otherwise. Test your implementation by writing a main program that uses the isPerfect function
 * to check for perfect numbers in the range 1 to 9999 by testing each number in turn. When a perfect
 * number is found, your program should display it on the screen. The first two lines of output should be 6 and 28.
 * Your program should find two other perfect numbers in the range as well.
 */

#include "console.h"
#include "simpio.h"
#include <cmath>
using namespace std;

bool isPerfect(int n);

int main() {
    for (int i = 1; i <= 9999; i++) {
        if (isPerfect(i)) {
            cout << i << " is perfect" << endl;
        }
    }
    return 0;
}

bool isPerfect(int n) {
   double total = 0;
   for (int i = 1 ; i < n; i++) {
       if (n % i  == 0) {
           total += i;
       }
    }
   if (total == n) {
       return true;
   }
   else {
       return false;
   }
}

