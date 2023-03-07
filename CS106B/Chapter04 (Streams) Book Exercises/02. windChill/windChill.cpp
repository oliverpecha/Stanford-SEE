/*
 * File: windChill.cpp
 * --------------
 * In exercise 4 in Chapter 2, you wrote a function windChill that calculated the wind chill for a given
 * temperature and wind velocity. Write a program that uses this function to display these values
 * in tabular form, as illustrated by the table from the National Weather service shown in Figure 2-17 on page 116.
 */

#include "console.h"
#include "simpio.h"
#include "error.h"
#include <iomanip>
#include <cmath>
using namespace std;

// t = Temperature, v=Wind
int windChill(int t, int v);


void tableHeader();

int main() {
    tableHeader();

    for (int v = 5; v <=60; v += 5) {
        cout << setw(4) << v << " ||";
        for (int t = 40; t >=-45; t -= 5){
            cout <<  right << setw(4) << windChill(t,v);
        }
        cout << endl;
    }
    return 0;
}

int windChill(int t, int v) {
    int w = t;
    string msg = " ";
    if (v != 0) {
            w = 35.74 + (0.6215 * t) - 35.75 * (pow(v,0.16))+ 0.4275 * t * (pow(v,0.16));
    }

    return w;
}

void tableHeader() {
    cout << "Calm ||";
    for (int t = 40; t >=-45; t -= 5){
        cout <<  right << setw(4) << t;
    }
    cout << endl;
    cout << "========";
    for (int t = 40; t >=-45; t -= 5){
        cout <<  "====" ;
    }
    cout << endl;
}
