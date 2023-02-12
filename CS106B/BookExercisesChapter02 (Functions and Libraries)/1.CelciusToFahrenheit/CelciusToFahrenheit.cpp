/*
 * File: main.cpp
 * --------------
 * Write a program that reads in a temperature in degrees Celsius and displays the corresponding temperature
 * in degrees Fahrenheit. The conversion formula is
 * F = (9/5)C + 32
 */

#include "console.h"
#include "simpio.h"
using namespace std;


double celcius, fahrenheit;

double convertCtoF(double celcius);

int main()
{
    celcius = getDouble("What is the Celcius temperature you want converted to Fahrenheit? ");

    cout << celcius << " Celcius equals " << convertCtoF(celcius) << " Fahrenheit."<< endl;

    return 0;
}

double convertCtoF(double celcius) {
    return fahrenheit = (celcius * 1.8) + 32;
}
