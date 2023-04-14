/*
 * File: digitSum.cpp
 * --------------
 * Write a recursive function digitSum(n) that takes a nonnegative integer and returns the sum
 * of its digits. For example, calling digitSum(1729) should return 1 + 7 + 2 + 9, which is 19.
 * The recursive implementation of digitSum depends on the fact that it is very easy to break
 * an integer down into two components using division by 10. For example, given the integer 1729,
 * you can divide it into two pieces as follows:
 *
 * Each of the resulting integers is strictly smaller than the original and thus represents a simpler case.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

int digitSum(int n);

int main() {
    int n = 0;
    cout << "This program calculates the sum of each digit in a number. " << endl;
    while (n > -1) {
       n = getInteger("What is the number?");
       cout << "sum is " << digitSum(n) << endl;
       cout << "\n " << endl;
    }
    return 0;
}


int digitSum(int n){
    if (n  == 0) return 0;
    return n % 10 + digitSum(n/10);
}
