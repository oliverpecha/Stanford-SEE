/*
 * File: ConsecutiveHeads.cpp
 * --------------
 * Write a program that simulates flipping a coin repeatedly and continues until three consecutive
 * heads are tossed. At that point, your program should display the total number of coin flips that were made.
 * The following is one possible sample run of the program:
 */

#include "console.h"
#include "simpio.h"
#include "random.h"

using namespace std;

int heads;
int flips;
const int TARGET = 3;

int main()
{
    while (heads < 3) {
        if (randomBool()) {
            cout << "heads" << endl;
            heads++;
        }
        else {
            cout << "tails" << endl;
            heads = 0;
        }
        flips++;
    }
    cout << "It took " << flips << " flips to get " <<  TARGET << " consecutive heads" << endl;
    return 0;
}

