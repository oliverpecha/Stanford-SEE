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


    private:
        Month month;
        int day;
        int year;

};


/*
 * Function: daysInMonth
 * ------------------
 * Returns the number that a given month has.
 */
 int daysInMonth (Month month, int year);

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
