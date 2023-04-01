/*
 * File: PiAproximattion.cpp
 * --------------
 * The German mathematician Leibniz (1646–1716) discovered the rather remarkable fact that the mathematical constant PI
 * can be computed using the following mathematical relationship:
 * "1–+–+–+...
 * The formula to the right of the equal sign represents an infinite series; each fraction represents a term in that series.
 * If you start with 1, subtract one-third, add one-fifth, and so on, for each of the odd integers, you get a number that gets closer and closer
 * to the value of !/4 as you go along.
 * Write a program that calculates an approximation of ! consisting of the first 10,000 terms in Leibniz’s series.
 */

#include <cmath>
#include "console.h"
#include "simpio.h"
using namespace std;

double terms = 10000;

int main()
{
    if (terms > 0){

            double partial = 0;

            for (int i = 0; i < terms; i++)
                if (i % 2 == 0)
                    partial += 1/((2.0 * i) + 1);
                else
                    partial -= 1/((2.0 * i) + 1);

            double newPi = 4 * partial;

            cout << "The approximation is " << newPi << " using " << terms << " terms.\n";

    }
return 0;
}
