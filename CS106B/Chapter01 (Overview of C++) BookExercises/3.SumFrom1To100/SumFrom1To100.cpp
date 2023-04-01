/*
 * File: SumFrom1To100.cpp
 * --------------
 * As mathematical historians have told the story, the German mathematician Carl Friedrich Gauss
 * (1777-1855) began to show his mathematical talent at a very early age. When he was in elementary school,
 * Gauss was asked by his teacher to compute the sum of the numbers between 1 and 100. Gauss is said to have
 * given the answer instantly: 5050. Write a program that computes the answer to the question Gauss’s teacher posed.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

const int MINIMUM = 1;
const int MAXIMUM = 100;

int result;

int main()
{
    for (int i = MINIMUM;  i <= MAXIMUM; i++) {
        result += i;
    }
    cout << "The sum of the numbers between 1 and 100 is " << result << endl;
    return 0;
}
