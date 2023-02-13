/*
 * File: MetersToImperial.cpp
 * --------------
 * Reimplement the distance-conversion program from exercise 2 in Chapter 1 so that it uses a function.
 * In this case, the function must produce both the number of feet and the number of inches, which means that you need to use
 * call by reference to return these values.
 */

#include "console.h"
#include "simpio.h"
using namespace std;



double meters;
int feet, inches;

void MetersToImperial (double meters, int & feet, int & inches);

string feetOut(int feet), inchesOut(int feet);


int main()
{
    meters = getDouble("How many meters do you want converted to feet and inches? ");
    MetersToImperial (meters,  feet,  inches);
    cout << meters << " meters equals " << feet << " " << feetOut(feet) << " and " << inches << " " << inchesOut(inches) << "." << endl;
    return 0;
}

void MetersToImperial (double meters, int & feet, int & inches) {
    double converter = (meters * 3.28084);
    feet = converter;
    inches = (converter - feet) * 12;
}


string feetOut(int feet) {
    if (feet <=1) {
        return "foot";
    }
    else {
        return "feet";
    }
}

string inchesOut(int inches) {
    if (inches <=1) {
        return "inch";
    }
    else {
        return "inches";
    }
}
