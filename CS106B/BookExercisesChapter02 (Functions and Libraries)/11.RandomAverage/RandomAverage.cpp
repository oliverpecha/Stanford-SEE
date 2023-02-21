/*
 * File: RandomAverage.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
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
