/*
 * File: Cannonball.cpp
 * --------------
 * Spherical objects, such as cannonballs, can be stacked to form a pyramid with one cannonball
 * at the top, sitting on top of a square composed of four cannonballs, sitting on top of a
 * square composed of nine cannonballs, and so forth. Write a recursive function cannonball
 * that takes as its argument the height of the pyramid and returns the number of cannonballs
 * it contains. Your function must operate recursively and must not use any iterative constructs,
 * such as while or for.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

int cannonball(int n);

int main() {
    cout << "This program will answer how many balls "
            "are needed to achieve a cannonball piramide "
            "given a number of levels." << endl;
    int levels = 0;
    while (levels > -1) {
        levels = getInteger("\nHow many levels? ");
        int balls = cannonball(levels);
        cout << balls << " are needed to fill a piramide of " << levels << " levels" << endl;
    }

    return 0;
}

int cannonball(int n) {
    if (n == 1) return 1;
    else {
        return n * n + cannonball(n - 1);
    }
}
