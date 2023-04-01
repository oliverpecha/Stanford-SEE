#include "calendar.h"
#include <iostream>
#include <string>


Date::Date(){
    month = JANUARY;
    day = 1;
    year = 1900;
}

Date::Date(Month iMonth, int iDay, int iYear){
    month = iMonth;
    day = iDay;
    year = iYear;
}

Date::Date(int iDay, Month iMonth, int iYear){
    day = iDay;
    month = iMonth;
    year = iYear;
}


int Date::getDay(){
    return day;
}
Month Date::getMonth(){
    return month;
}
int Date::getYear(){
    return year;
}
std::string Date::toString(){
    std::string exitMonth = monthToString(getMonth()).substr(0,3);
    std::transform(exitMonth.begin(), exitMonth.end(), exitMonth.begin(), ::toupper);
    return exitMonth + "-" + std::to_string(day) + "-" + std::to_string(year);
}


/*
 * Function: daysInMonth
 * ------------------
 * Returns the number that a given month has.
 */
int daysInMonth (Month month, int year) {
    switch (month) {
        case 1:
            return 31;
        case 2:
            if (isLeapYear(year))return 29;
            else return 28;
        case 3:
            return 31;
        case 4:
            return 30;
        case 5:
            return 31;
        case 6:
            return 30;
        case 7:
            return 31;
        case 8:
            return 31;
        case 9:
            return 30;
        case 10:
            return 31;
        case 11:
            return 30;
        case 12:
            return 31;
        default:
            return 0;
    }
}

 /*
  * Function: isLeapYear
  * ------------------
  * Returns whether a year is Leap or not
  */
bool isLeapYear (int year) {
    return ((year % 4 == 0) && (year % 100 != 0))
        || (year % 400 == 0);
}


 /*
  * Function: monthToString
  * ------------------
  * Returns the name of a Month as a String
  */
std::string monthToString(Month month) {
    switch (month) {
        case 1:
            return "January ";
        case 2:
            return "February ";
        case 3:
            return "March ";
        case 4:
            return "April ";
        case 5:
            return "May ";
        case 6:
            return "June ";
        case 7:
            return "July ";
        case 8:
            return "August ";
        case 9:
            return "September ";
        case 10:
            return "October ";
        case 11:
            return "November ";
        case 12:
            return "Ducember ";
        default:
            return "Unknown Month ";
    }
}

