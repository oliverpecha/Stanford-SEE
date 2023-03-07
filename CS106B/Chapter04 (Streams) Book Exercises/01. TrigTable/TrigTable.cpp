/*
 * File: TrigTable.cpp
 * --------------
 * The <iomanip> library gives programmers more control over output format, which makes it easy,
 * for example, to create formatted tables. Write a program that displays a table of trigonometric
 * sines and cosines that looks like this:
 *
 */

#include "console.h"
#include "simpio.h"
#include <iomanip>
using namespace std;

void printAngle(int angle) {
    cout << setw(5) << angle << "  |";
    cout << fixed << setprecision(6) << setw(11) << 30.2 / angle << "  |";
    cout << setw(11) << 3.2 / angle << "  |" <<endl;

}

int main()
{

    cout << " theta | sin (theta) | cos (theta) |" << endl;
    cout << "-------+-------------+-------------+" << endl;
    right;
    setprecision(7);
    for (int i = -90; i <= 90; i += 15 ){
        printAngle(i);
    }
    return 0;
}
