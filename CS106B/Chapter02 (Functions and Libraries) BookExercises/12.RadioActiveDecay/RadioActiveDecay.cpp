/*
 * File: RadioActiveDecay.cpp
 * --------------
 * A radioactive atom, for example, does not decay for any specific reason that we mortals understand. Instead,
 * that atom has a random probability of decaying within a period of time. Sometimes it does, sometimes it doesn’t,
 * and there is no way to know for sure.
 *
 * Because physicists consider radioactive decay a random process, it is not surprising that random numbers
 * can be used to simulate it. Suppose you start with a collection of atoms, each of which has a certain probability
 * of decaying in any unit of time. You can then approximate the decay process by taking each atom in turn and
 * deciding randomly whether it decays, considering the probability.
 *
 * Write a program that simulates the decay of a sample that contains 10,000 atoms of radioactive material,
 * where each atom has a 50 percent chance of decaying in a year. The output of your program should show the number
 * of atoms remaining at the end of each year, which might look something like this:
 *
 * As the numbers indicate, roughly half the atoms in the sample decay each year. In physics, the conventional way
 * to express this observation is to say that the sample has a half-life of one year.

 */

#include "console.h"
#include "simpio.h"
#include "random.h"
using namespace std;


const int INITIAL_N = 10000;

int main() {
    int remaning_n = INITIAL_N;
    int decayed = 0;
    int year = 1;
    cout << "There are " << INITIAL_N << " atoms inititally" << endl;
    while (remaning_n > 0) {
        for (int i = 0; i < remaning_n; i++) {
            if (randomBool()) decayed++;
        }
        remaning_n -= decayed;
        cout << "There are " << remaning_n << " atoms at the end of year " << year << endl;
        year++;
        decayed = 0;
    }

    return 0;
}
