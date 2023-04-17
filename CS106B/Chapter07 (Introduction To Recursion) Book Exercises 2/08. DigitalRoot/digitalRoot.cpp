/*
 * File: digitalRoot.cpp
 * --------------
 * The digital root of an integer n is defined as the result of summing the digits repeatedly
 * until only a single digit remains. For example, the digital root of 1729 can be calculated
 * using the following steps:
 * Step 1: Step 2: Step 3:
 * 1 + 7 + 2 + 9 1 + 9
 * 1 + 0
 * 19  10  1
 * Because the total at the end of step 3 is the single digit 1, that value is the digital root.
 * Write a function digitalRoot(n) that returns the digital root of its argument. Although it is
 * easy to implement digitalRoot using the digitSum function from exercise 6 and a while loop,
 * part of the challenge of this problem is to write the function recursively without using any
 * explicit loop constructs.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

int digitSum(int n);
int digitalRoot(int n);


int main() {
    int n = 0;
    cout << "This program calculates the sum of each digit in a number. " << endl;
    while (n > -1) {
       n = getInteger("What is the number?");
       cout << "Sum is " << digitSum(n) << endl;
       cout << "Digital Root is " << digitalRoot(n) << endl;
       cout << "\n " << endl;
    }
    return 0;
}


int digitalRoot(int n){
    if (digitSum(n) < 10) {
        return digitSum(n);
    }
    else return digitalRoot(n % 10 + digitSum(n/10));
}


int digitSum(int n){
    if (n  == 0) return 0;
    return n % 10 + digitSum(n/10);
}
