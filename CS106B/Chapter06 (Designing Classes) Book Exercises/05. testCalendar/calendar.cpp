#include "calendar.h"
#include <iostream>
#include <string>

Month monthSetter(Month month);
Month monthSetter(int month);


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


void Date::setDay(int iDay){
    day = iDay;
}

void Date::setMonth(Month iMonth){
    month = iMonth;
}

void Date::setYear(int iYear){
    year = iYear;
}

// The insertion operator <<.
std::ostream & operator<<(std::ostream & os, Date date){
       return os << date.toString();
}

// The relational operators ==, !=, <, <=, >, and >=

bool operator==(Date d1, Date d2){
    if (d1.getDay() == d2.getDay() &&
        d1.getMonth() == d2.getMonth() &&
        d1.getYear() == d2.getYear()) return true;
    else return false;
}

bool operator!=(Date d1, Date d2){
    if (!(d1 == d2)) return true;
    else return false;
}

bool operator<(Date d1, Date d2){
    if (d1.getYear() < d2.getYear()) return true;
    else if (d1.getYear() == d2.getYear() &&
             d1.getMonth() < d2.getMonth()) return true;
    else if (d1.getYear() == d2.getYear() &&
             d1.getMonth() == d2.getMonth() &&
             d1.getDay() < d2.getDay()) return true;
    else return false;
}

bool operator<=(Date d1, Date d2){
    if (d1.getYear() < d2.getYear()) return true;
    else if (d1.getYear() <= d2.getYear() &&
             d1.getMonth() < d2.getMonth()) return true;
    else if (d1.getYear() <= d2.getYear() &&
             d1.getMonth() <= d2.getMonth() &&
             d1.getDay() < d2.getDay()) return true;
    else if (d1.getYear() == d2.getYear() &&
             d1.getMonth() == d2.getMonth() &&
             d1.getDay() == d2.getDay()) return true;
    else return false;
}

bool operator>(Date d1, Date d2){
    if (d1.getYear() > d2.getYear()) return true;
    else if (d1.getYear() == d2.getYear() &&
             d1.getMonth() > d2.getMonth()) return true;
    else if (d1.getYear() == d2.getYear() &&
             d1.getMonth() == d2.getMonth() &&
             d1.getDay() > d2.getDay()) return true;
    else return false;
}

bool operator>=(Date d1, Date d2){
    if (d1.getYear() > d2.getYear()) return true;
    else if (d1.getYear() >= d2.getYear() &&
             d1.getMonth() > d2.getMonth()) return true;
    else if (d1.getYear() >= d2.getYear() &&
             d1.getMonth() >= d2.getMonth() &&
             d1.getDay() > d2.getDay()) return true;
    else if (d1.getYear() == d2.getYear() &&
             d1.getMonth() == d2.getMonth() &&
             d1.getDay() == d2.getDay()) return true;
    else return false;
}

// The expression date + n, which returns the date n days after date
Date operator+(Date  d1, int n){
    int currentMonthLenght = daysInMonth(d1.getMonth(), d1.getYear());
    while (d1.getDay() + n > currentMonthLenght){
        n -= currentMonthLenght;
        if (d1.getMonth() + 1 > 12) {
            d1.setMonth(JANUARY);
            d1.setYear(d1.getYear() + 1);
        }
        else d1.setMonth(monthSetter(d1.getMonth() + 1));
        currentMonthLenght = daysInMonth(d1.getMonth(), d1.getYear());
    }
    d1.setDay(d1.getDay() + n);
    return d1;
}

// The expression date - n, which returns the date n days before date
Date operator-(Date d1, int n){
    int monthLenght;
    while (d1.getDay() - n < 1){
        if (d1.getMonth() - 1 < 1) {
            d1.setMonth(DECEMBER);
            d1.setYear(d1.getYear() - 1);
        }
        else d1.setMonth(monthSetter(d1.getMonth() - 1));
        monthLenght = daysInMonth(d1.getMonth(), d1.getYear());
        if (n >= daysInMonth(d1.getMonth(), d1.getYear())) {
        n -= monthLenght;
        } else break;
    }
    d1.setDay(daysInMonth(d1.getMonth(), d1.getYear()) - n);
    return d1;
}

// The expression d1 - d2, which returns how many days separate d1 and d2
int operator-(Date d1, Date d2){
    int counter = 0;
    if (d1 == d2) {
        return 0;
    } else if (d1 > d2) {
        Date temp;
        temp = d2;
        d2 = d1;
        d1 = temp;
    }
    counter += daysInMonth(d1.getMonth(), d1.getYear()) - d1.getDay();
    while (d1.getYear() < d2.getYear() ||
          (d1.getYear() == d2.getYear() && d1.getMonth() < d2.getMonth()) ){
            if (d1.getMonth() + 1 > 12) {
                          d1.setMonth(JANUARY);
                          d1.setYear(d1.getYear() + 1);
            }
            else d1.setMonth(monthSetter(d1.getMonth() + 1));
            counter += daysInMonth(d1.getMonth(), d1.getYear());
    }
    counter -= daysInMonth(d1.getMonth(), d1.getYear()) - d2.getDay();
    return counter;
}

// The shorthand assignment operators += and -= with an integer on the right
Date operator+=(Date & d1, int n){
    d1 = d1 + n;
    return d1;
}

Date operator-=(Date & d1, int n){
    d1 = d1 - n;
    return d1;
}

// he ++ and -- operators in both their prefix and suffix form.
Date operator++(Date d1, int) {
    int currentMonthLenght = daysInMonth(d1.getMonth(), d1.getYear());
    if (d1.getDay() + 1 > currentMonthLenght) {
        d1.setDay(1);
        if (d1.getMonth()+1 < 13) d1.setMonth(monthSetter(d1.getMonth()+1));
        else {
            d1.setMonth(monthSetter(1));
            d1.setYear(d1.getYear() + 1);
        }
    }
    else {
        d1.setDay(d1.getDay() + 1);
    }
    return d1;
}

void operator++(Date & d1) {
    d1 = d1++;
}

Date operator--(Date d1, int) {
    if (d1.getDay() - 1 < 1) {
        if (d1.getMonth() - 1 > 1) d1.setMonth(monthSetter(d1.getMonth()-1));
        else {
            d1.setMonth(monthSetter(12));
            d1.setYear(d1.getYear() - 1);
        }
        int previousMonthLenght = daysInMonth(d1.getMonth(), d1.getYear());
        d1.setDay(previousMonthLenght);
    }
    else {
        d1.setDay(d1.getDay() - 1);
    }
    return d1;
}

void operator--(Date & d1) {
    d1 = d1--;
}

Month monthSetter(Month month) {
    switch (month) {
        case 1:
            return JANUARY;
        case 2:
            return FEBRUARY;
        case 3:
            return MARCH;
        case 4:
            return APRIL;
        case 5:
            return MAY;
        case 6:
            return JUNE;
        case 7:
            return JULY;
        case 8:
            return AUGUST;
        case 9:
            return SEPTEMBER;
        case 10:
            return OCTOBER;
        case 11:
            return NOVEMBER;
        case 12:
            return DECEMBER;
        default:
            return NONE;
    }
}


Month monthSetter(int month) {
    switch (month) {
        case 0:
            return DECEMBER;
        case 1:
            return JANUARY;
        case 2:
            return FEBRUARY;
        case 3:
            return MARCH;
        case 4:
            return APRIL;
        case 5:
            return MAY;
        case 6:
            return JUNE;
        case 7:
            return JULY;
        case 8:
            return AUGUST;
        case 9:
            return SEPTEMBER;
        case 10:
            return OCTOBER;
        case 11:
            return NOVEMBER;
        case 12:
            return DECEMBER;
        default:
            return NONE;
    }
}

/*
Month monthSetter(int n) {
    return monthSetter(n);
}*/

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
        std::cout << "^^^^#%#" << std::endl;

            return 31;
    }
}

int daysInMonth (int month, int year) {
    switch (month) {
        case 0:
            return 31;
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
            return "December ";
        default:
            return "Unknown Month ";
    }
}

