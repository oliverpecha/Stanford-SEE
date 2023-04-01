/*
 * File: testCalendar.cpp
 * --------------
 * Using the direction.h interface as an example, design and implement a calendar.h interface that
 * exports the Month type from Chapter 1, along with the functions daysInMonth and isLeapYear,
 * which also appear in that chapter. Your interface should also export a monthToString function
 * that returns the constant name for a value of type Month. Test your implementation by writing
 * a main program that asks the user to enter a year and then writes out the number of days in
 * each month of that year, as in the following sample run:
 *
 *
 * Extend the calendar.h interface from Chapter 2, exercise 11 so that it also exports a Date
 * class that exports the following methods:
 * • A default constructor that sets the date to January 1, 1900.
 * • A constructor that takes a month, day, and year and initializes the Date to contain
 * those values. For example, the declaration
 *
 *      Date moonLanding(JULY, 20, 1969);
 *
 * should initialize moonLanding so that it represents July 20, 1969.
 *
 * • An overloaded version of the constructor that takes the first two parameters in the opposite
 * order, for the benefit of clients in other parts of the world. This change allows the
 * declaration of moonLanding to be written as
 *
 *      Date moonLanding(20, JULY, 1969);
 *
 * • The getter methods getDay, getMonth, and getYear.
 * • A toString method that returns the date in the form dd-mmm-yyyy, where dd is a one- or
 * two-digit date, mmm is the three-letter English abbreviation for the month, and yyyy is
 * the four-digit year. Thus, calling toString(moonLanding) should return the string "20-Jul-1969".
 *
 */

#include "calendar.h"
#include "console.h"
#include "simpio.h"
using namespace std;


int main() {
    int year = 0;
    Date empty;
    Date usa(JULY, 20, 1969);
    Date eu(19, DECEMBER, 1985);
    cout << "empty " << empty.toString() << endl;
    cout << "usa   " << usa.toString() << endl;
    cout << "eu    " << eu.toString() << endl;
    Date wtf;
    cout << "wtf   "  << wtf.toString() << endl;

    while (year != -1) {
        year = getInteger("Enter a year:");
        for (int i = 1; i <= 12; i++){
            cout << monthToString((Month)i) << "has " << daysInMonth((Month)i, year) << " days."<< endl;
        }
        cout<< "\n"<< endl;
    }
    return 0;
}
