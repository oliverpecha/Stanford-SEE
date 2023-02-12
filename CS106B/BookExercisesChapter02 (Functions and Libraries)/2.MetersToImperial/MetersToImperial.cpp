/*
 * File: MetersToImperial.cpp
 * --------------
 * Write a program that converts a distance in meters to the corresponding English distance in feet and inches.
 * The conversion factors you need are
 * 1 inch = 0.0254 meters 1 foot = 12 inches
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
