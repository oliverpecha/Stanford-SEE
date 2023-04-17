/*
 * File: main.cpp
 * --------------
 * In the 18th century, the astronomer Johann Daniel Titius proposed a rule, later recorded by Johann Elert Bode,
 * for calculating the distance from the sun to each of the planets known at that time. To apply that rule,
 * which is now known as the Titius-Bode Law, you begin by writing down the sequence
 * ... b1 = 1 b2 = 3 b3 = 6 b4 = 12 b5 = 24 b6 = 48
 * where each subsequent element in the sequence is twice the preceding one. It turns out that an approximate distance
 * to the ith planet can be computed from this series by applying the formula
 *
 *   di = (4 + bi) /10
 *
 * The distance di is expressed in astronomical units (AU), which correspond to the average distance from the earth
 * to the sun (approximately 93,000,000 miles). Except for a disconcerting gap between Mars and Jupiter, the
 * Titius-Bode law gives reasonable approximations for the distances to the seven planets known at the time:
 *
 * Mercury  .5 AU
 * Venus    .7 AU
 * Earth    1 AU
 * Mars     1.6 AU
 * ?        2.8 AU
 * Jupiter  5.2 AU
 * Saturn   10 AU
 * Uranus   19.6 AU
 *
 * Concern about the gap in the sequence led astronomers to discover the asteroid belt, which they suggested
 * might have been the remains of a planet that had once orbited the sun at distance specified by the missing entry in the table.
 *
 * Write a recursive function getTitiusBodeDistance(k) that calculates the expected distance between the sun and the kth planet,
 * numbering outward from Mercury starting with 1. Test your function by writing a program that displays the distances
 * to each of these planets in tabular form.

 */

#include "console.h"
#include "simpio.h"
#include <iomanip>
using namespace std;


string planetName(int i);
double getTitiusBodeDistance(int k);
int titusBodeLaw(int k);
int doublingSequence(int k, int k0, int k1);




int main() {
    cout <<  endl;
    for (int var = 1; var <= 8; ++var) {
        cout << planetName(var) << "" << setw(4) << getTitiusBodeDistance(var) << " AU" <<  endl;
    }
    return 0;
}



double getTitiusBodeDistance(int k) {
    return (4.0 + titusBodeLaw(k)) /10;
}

int titusBodeLaw(int k) {
    return doublingSequence(k, 1, 3);

}

int doublingSequence(int k, int k0, int k1) {
    if (k == 1) return  k0;
    if (k == 2) return  k1;
    else return doublingSequence(k - 1, k0, k1 * 2);
}

string planetName(int i) {
    switch (i) {
        case 1:
            return "Mercury ";
            break;
        case 2:
            return "Venus   ";
            break;
        case 3:
            return "Earth   ";
            break;
        case 4:
            return "Mars    ";
            break;
        case 5:
            return "?       ";
            break;
        case 6:
            return "Jupiter ";
            break;
        case 7:
            return "Saturn  ";
            break;
        case 8:
            return "Uranus  ";
            break;
        default:
            return "Unknown ";
            break;
    }
}


