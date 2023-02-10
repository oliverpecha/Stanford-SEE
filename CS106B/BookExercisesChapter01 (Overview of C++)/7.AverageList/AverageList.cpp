/*
 * File: AverageList.cpp
 * --------------
 * Using the AddIntegerList program from Figure 1-5 as a model, write a program AverageList
 * that reads in a list of integers representing exam scores and then prints out the average.
 * Because some unprepared student might actually get a score of 0, your program should use !1
 * as the sentinel to mark the end of the input.
 */

#include "console.h"
#include "simpio.h"
using namespace std;


const int SENTINEL = -1;

int students= 0;
double input = 0;
double sum = 0;
double average = 0;

int main() {

    cout << "This program calculates the average of student scores. Enter " << SENTINEL << " to signal the end of the list." << endl;

    while (input != SENTINEL) {
        input = getInteger("? ");
        if (input != SENTINEL) {
        sum += input;
        students++;
cout << "# of students: " << students << endl;
        }
    }
    cout << "The average of scores is " << sum/students << endl;
    return 0;
}
