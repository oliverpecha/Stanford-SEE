/*
 * File: RandomDarts.cpp
 * --------------
 * Random numbers offer yet another strategy for approximating the value of !. Imagine that you have a
 * dartboard hanging on your wall that consists of a circle painted on a square backdrop,
 * as in the following diagram:
 *
 * What happens if you throw a whole bunch of darts completely randomly, ignoring any darts that
 * miss the board altogether? Some of the darts will fall inside the gray circle, but some will be outside
 * the circle in the white corners of the square. If the darts are random, the ratio of the number of darts
 * landing inside the circle to the total number of darts hitting the square should be approximately equal
 * to the ratio between the two areas. The ratio of the areas is independent of the actual size of the dartboard,
 * as illustrated by the formula
 *
 * To simulate this process in a program, imagine that the dart board is drawn on the standard Cartesian coordinate
 * plane with its center at the origin and a radius of 1 unit. The process of throwing a dart randomly at the square
 * can be modeled by generating two random numbers, x and y, each of which lies between –1 and +1. This (x, y) point
 * always lies somewhere inside the square. The point (x, y) lies inside the circle if
 *
 * This condition, however, can be simplified considerably by squaring each side of the inequality, which gives
 * the following more efficient test:
 *
 * If you perform this simulation many times and compute the fraction of darts that fall within the circle,
 * the result will be an approximation of "/4.
 *
 * Write a program that simulates throwing 10,000 darts and then uses the simulation technique described in this
 * exercise to generate and display an approximate value of ". Don’t worry if your answer is correct only in the first
 * few digits. The strategy used in this problem is not particularly accurate, even though it occasionally proves useful
 * as an approximation technique. In mathematics, this technique is called Monte Carlo integration, after the
 * capital city of Monaco.

 */

#include "console.h"
#include "simpio.h"
#include "random.h"
using namespace std;

const int DARTS_N = 10000;

double x, y;
double pi;
double inside;

bool formula (double x, double y);


int main() {

    for (int i = 0; i < DARTS_N; i++){
        x = randomReal(-1, 1);
        y = randomReal(-1, 1);
        if (formula(x,y)) inside++;
    }
    pi = DARTS_N / inside;
    cout << "Estimate for Pi number is " << pi << endl;
    return 0;
}

bool formula(double x, double y) {
    if (x * 2 + y * 2 < 1) return true;
    else return false;
}
