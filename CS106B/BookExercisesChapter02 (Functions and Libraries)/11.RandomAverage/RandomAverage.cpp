/*
 * File: RandomAverage.cpp
 * --------------
 * Write a program RandomAverage that repeatedly generates a random real number between 0 and 1 and
 * then displays the average after a specified number of trials entered by the user.
 */

#include "console.h"
#include "simpio.h"
#include "random.h"

using namespace std;

const int N = 3;
const double MIN = 0;
const double MAX = 1;

int main()
{
    int entries = 0;
    double result = 0;
    double value = 0;

    cout << "This program will calculate the average of " << N << " random points between " << MIN << " and " << MAX << endl;

    while (entries < N) {
        value = randomReal(MIN, MAX);
        entries++;
        result = (result + value) / entries;
         cout << "Random value entry  was " << value << endl;
    }
    cout << "Average of " << N << " points entered is " << result << endl;

       return 0;
}
