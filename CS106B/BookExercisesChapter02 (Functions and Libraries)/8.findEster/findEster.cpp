/*
 * File: findEster.cpp
 * --------------
 * Although Euclid’s algorithm for calculating the greatest common divisor is one of the oldest to be
 * dignified with that term, there are other algorithms that date back many centuries. In the Middle Ages,
 * one of the problems that required sophisticated algorithmic thinking was determining the date of Easter,
 * which falls on the first Sunday after the first full moon following the vernal equinox. Given this definition,
 * the calculation involves interacting cycles of the day of the week, the orbit of the moon,
 * and the passage of the sun through the zodiac. Early algorithms for solving this problem date back to the third
 * century and are described in the writings of the eighth-century scholar known as the Venerable Bede. In 1800,
 * the German mathematician Carl Friedrich Gauss published an algorithm for determining the date of Easter
 * that was purely computational in the sense that it relied on arithmetic rather than looking up values in tables.
 * His algorithm—translated directly from the German—appears in Figure 2-18.
 *
 * Write a procedure
 *
 * void findEaster(int year, string & month, int & day);
 *
 * that returns the Easter date for year in the reference parameters month and day.
 * Unfortunately, the algorithm in Figure 2-18 only works for years in the 18th and 19th centuries. It is easy,
 * however, to search the web for extensions that work for all years. Once you have completed your implementation
 * of Gauss’s algorithm, undertake the necessary research to find a more general approach.
 *
 *


 */

#include "console.h"
#include "simpio.h"
using namespace std;

int year;
string month;
int day;

void findEaster(int year, string & month, int & day);
bool isEven (int n);

int main() {
    while (year != -1) {
        year = getInteger("What is the year you would like to find out when Easter was?");
        findEaster( year,   month,   day);
        cout << "In year " << year << ", Easter was " << month << " " << day << "\n\n" << endl;
    }
    return 0;
}

void findEaster(int year, string & month, int & day) {
    int a, b, c, d, e;

    a = year % 19;
    b = year % 4;
    c = year % 7;

    if (isEven(a)) a = 0;
    if (isEven(b)) b = 0;
    if (isEven(c)) c = 0;


    d = (19 * a + 23) / 30;
    if (isEven(d)) d = 0;

    if (year >= 1700 && year < 1800) {
        e = (2 * b + 4 * c + 6 * d + 3) / 7;
    }

    if (year >= 1800 && year < 1900) {
        e = (2 * b + 4 * c + 6 * d + 4) / 7;
    }

    if (isEven(e)) e = 0;

    if (d + e > 9) {
        month = "April";
        day = d + e - 9;
    }
    else {
        month = "March";
        day = 22 + d + e;
    }
}

bool isEven (int n) {
    if (n % 2 == 0) return true;
    else return false;
}
