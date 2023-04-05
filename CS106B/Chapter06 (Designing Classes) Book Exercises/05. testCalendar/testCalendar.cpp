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


    Date electionDay(6, NOVEMBER, 2012);
    Date inaugurationDay(21, JANUARY, 2013);

    if (electionDay < inaugurationDay) cout << "electionDay < inaugurationDay is true" << endl;
    else cout << "electionDay < inaugurationDay negative" << endl;

    cout << endl;
    cout << "**** electionDay NOV-06-2012 inaugurationDay JAN-21-2013. ? days until election day" << endl;
    cout << inaugurationDay - electionDay << " days until election day" << endl;

    cout << endl;
    cout << "**** for loop: (Date d = electionDay; d <= inaugurationDay; ++d)" << endl;
    int count = 0;
    for (Date d = electionDay; d <= inaugurationDay; ++d) {
        if (d == inaugurationDay) cout << count << " " << d << endl;
        count++;

    }



    cout << endl;
    cout << endl;
    cout << endl;
    int year = 0;
    Date empty;
    Date emptyTwo;
    cout << "**** constructors and ++ and -- operators suffix and prefix form" << endl;
    cout << "empty " << empty << endl;
    cout << endl;
    Date usa(FEBRUARY, 28, 1987);
    cout << "usa   " << usa << endl;
    usa++;
    cout << "usa++  " << usa << endl;
    ++usa;
    cout << "++usa  " << usa << endl;
    usa--;
    cout << "usa--  " << usa << endl;
    --usa;
    cout << "--usa  " << usa << endl;
    cout << endl;

    Date usaBis(FEBRUARY, 28, 1988);
    cout << "usaB  " << usaBis << endl;
    usaBis++;
    cout << "usaB++ " << usaBis << endl;
    usaBis--;
    cout << "usaB-- " << usaBis << endl;
    cout << endl;

    Date eu(31, DECEMBER, 1985);
    cout << "eu    " << eu << endl;
    eu++;
    cout << "eu++  " << eu << endl;
    eu--;
    cout << "eu--  " << eu << endl;
    cout << endl;
    cout << endl;
    cout << endl;


    cout << "**** relational operators" << endl;
    if (empty == emptyTwo) cout << "empty == emptyTwo" << endl;
    else cout << "empty == emptyTwo negative" << endl;

    if (usa == usaBis) cout << "usa == usaBis" << endl;
    else cout << "usa == usaBis negative" << endl;

    if (usa != usaBis) cout << "usa != usaBis" << endl;
    else cout << "usa != usaBis negative" << endl;

    if (empty != emptyTwo) cout << "empty != emptyTwo" << endl;
    else cout << "empty != emptyTwo negative" << endl;

    if (eu < usaBis) cout << "eu < usaBis" << endl;
    else cout << "eu < usaBis negative" << endl;

    if (eu > usaBis) cout << "eu > usaBis" << endl;
    else cout << "eu > usaBis negative" << endl;

    if (usaBis > eu) cout << "usaBis > eu" << endl;
    else cout << "usaBis > eu negative" << endl;

    if (eu >= usaBis) cout << "usa > usaBis" << endl;
    else cout << "usa >= usaBis negative" << endl;

    if (empty <= emptyTwo) cout << "empty <= emptyTwo" << endl;
    else cout << "empty <= emptyTwo negative" << endl;
    cout << endl;
    cout << endl;
    cout << endl;

/*
    cout << "**** expression date + n, which returns the date n days after date" << endl;
    cout << "eu         " << eu << endl;
    cout << "eu + 5     " << eu + 5 << endl;
    cout << "eu + 365   " << eu + 365 << endl;
    eu += 365;
    cout << "eu += 365  " << eu << endl;
    cout << "eu + 365   " << eu + 365 << endl;
    cout << "eu         " << eu << endl;
    cout << "eu + 365*5 " << eu + 1825 << endl;
    cout << endl;
    cout << endl;
    cout << endl;


    cout << "**** expression date - n, which returns the date n days after date" << endl;
    cout << "eu         " << eu << endl;
    cout << "eu - 5     " << eu - 5 << endl;
    cout << "eu - 365   " << eu - 365 << endl;
    eu -= 365;
    cout << "eu -= 365  " << eu << endl;
    cout << "eu - 365   " << eu - 365 << endl;
    cout << "eu         " << eu << endl;
    cout << "eu - 365*5 " << eu - 1825 << endl;
    cout << endl;
    cout << "empty - 2  " << empty - 2 << endl;
    cout << endl;
    cout << endl;
    cout << endl;

*/
    cout << "**** The expression d1 - d2, which returns how many days separate d1 and d2" << endl;
    cout << "eu               " << eu << endl;
    cout << "usa              " << usa << endl;
    cout << "empty            " << empty << endl;
    cout << "eu - usa         " << eu - usa << endl;
    cout << "usa - eu         " << usa - eu << endl;
    cout << "empty - emptyTwo " << empty - emptyTwo << endl;
    //cout << "empty - eu       " << empty - eu << endl;

    cout << endl;
    cout << "**** for loop: (Date d = eu; d <= usa; ++d)" << endl;
    count = 0;
    for (Date d = eu; d <= usa; ++d) {
        if (d == usa) cout << count << " " << d << endl;
        count++;

    }


    cout << endl;
    cout << endl;
    cout << endl;
    while (year != -1) {
        year = getInteger("Enter a year:");
        for (int i = 1; i <= 12; i++){
            cout << monthToString((Month)i) << "has " << daysInMonth((Month)i, year) << " days."<< endl;
        }
        cout<< "\n"<< endl;
    }
    return 0;
}
