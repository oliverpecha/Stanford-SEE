/*
 *  This interface exports a Month type, along with the functions daysInMonth and isLeapYear.
 *  A monthToString function that returns the constant name for a value of type Month is also exported.
 *
 * */


#ifndef _calendar_h
#define _calendar_h
#include <string>
/*
 * Type: Month
 * ------------------
 * This enumerated type is used to represent the twelve months of the year.
 */
enum Month {NONE, JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};


class Date {


    public:
    Date();
    Date(Month iMonth, int iDay, int iYear);
    Date(int iDay, Month iMonth, int iYear);

        int getDay();
        Month getMonth();
        int getYear();
        std::string toString();
        void toUpperCase(std::string& str);

        void setDay(int iDay);
        void setMonth(Month iMonth);
        void setYear(int iYear);



private:
    Month month;
    int day;
    int year;

};

// The insertion operator <<.
std::ostream & operator<<(std::ostream & os, Date date);

// The relational operators ==, !=, <, <=, >, and >=
bool operator==(Date d1, Date d2);
bool operator!=(Date d1, Date d2);
bool operator<(Date d1, Date d2);
bool operator<=(Date d1, Date d2);
bool operator>(Date d1, Date d2);
bool operator>=(Date d1, Date d2);

// The expression date + n, which returns the date n days after date
Date operator+(Date  d1, int n);
// The expression date - n, which returns the date n days before date
Date operator-(Date d1, int n);

// The expression d1 - d2, which returns how many days separate d1 and d2
int operator-(Date d1, Date d2);

// The shorthand assignment operators += and -= with an integer on the right
Date operator+=(Date & d1, int n);
Date operator-=(Date & d1, int n);

// he ++ and -- operators in both their prefix and suffix form.
Date  operator++(Date d1, int);
void operator++(Date & d1);
Date  operator--(Date d1, int);
void operator--(Date & d1);

/*
 * Function: daysInMonth
 * ------------------
 * Returns the number that a given month has.
 */
 int daysInMonth (Month month, int year);
 int daysInMonth (int month, int year);


 /*
  * Function: isLeapYear
  * ------------------
  * Returns whether a year is Leap or not
  */
 bool isLeapYear (int year);

 /*
  * Function: monthToString
  * ------------------
  * Returns the name of a Month as a String
  */
 std::string monthToString(Month month);



#endif // CALENDAR_H
