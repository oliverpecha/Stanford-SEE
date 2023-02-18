/*
 * File: testCalendar.cpp
 * --------------
 * Using the direction.h interface as an example, design and implement a calendar.h interface that
 * exports the Month type from Chapter 1, along with the functions daysInMonth and isLeapYear,
 * which also appear in that chapter. Your interface should also export a monthToString function
 * that returns the constant name for a value of type Month. Test your implementation by writing
 * a main program that asks the user to enter a year and then writes out the number of days in
 * each month of that year, as in the following sample run:
 */

#include "calendar.h"
#include "console.h"
#include "simpio.h"
using namespace std;


int main() {
    int year = 0;

    while (year != -1) {
        year = getInteger("Enter a year:");
        for (int i = 1; i <= 12; i++){
            cout << monthToString((Month)i) << "has " << daysInMonth((Month)i, year) << " days."<< endl;
        }
        cout<< "\n"<< endl;
    }
    return 0;
}
