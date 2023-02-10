/*
 * File: ReverseInt.cpp
 * --------------
 * Using the digitSum function from the section entitled “The while statement” as a model,
 * write a program that reads in an integer and then displays the number that has the same
 * digits in the reverse order, as illustrated by this sample run:
 */

#include "console.h"
#include "simpio.h"
using namespace std;


int reverseInt(int unit) {
  int sum = 0;
  int piece = 0;
  while (unit > 0) {
     piece = unit % 10;
     unit /= 10;
     sum = sum *10 + piece;
    }
  return sum;
}

int main()
{
    cout << "This program reverses the digits in an integer." << endl;
    int input = getInteger("Enter a positive integer: ");
    cout << "The reverse integer is " << reverseInt(input) << endl;
    return 0;
}


