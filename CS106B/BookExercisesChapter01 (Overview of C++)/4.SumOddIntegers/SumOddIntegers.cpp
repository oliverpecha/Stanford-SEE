/*
 * File: SumOddIntegers.cpp
 * --------------
 * Write a program that reads in a positive integer N and then calculates and displays the sum
 * of the first N odd integers. For example, if N is 4, your program should display
 * the value 16, which is 1 + 3 + 5 + 7.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

int result;

int main() {
    int input = getInteger("Enter a number");

 //1. start x operations with entered #input as limit
    for (int x = 1; x <= input; x++) {

     int partialOdd = 0;

//2. start y operations with current x as limit
        for (int y = 0; y <= x*2; y++){

//3. find an odd number, take note,
            if (y % 2 == 1) {
                partialOdd = y;
            }

//4. keep searching for the next odd number and taking note
//5. until notes counted hit current limit (y)
        }

//6. sum last #partialOdd number to result
    result +=   partialOdd;

    }
//7. keep doing the same until current limit hits entered number */

    cout << "The sum of the first " << input << " odd integers is:" << result << endl;
    return 0;
}
