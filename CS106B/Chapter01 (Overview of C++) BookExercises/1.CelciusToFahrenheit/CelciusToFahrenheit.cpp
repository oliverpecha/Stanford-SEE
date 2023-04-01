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

int main()
{
    celcius = getDouble("What is the Celcius temperature you want converted to Fahrenheit? ");

    fahrenheit = (celcius * 1.8) + 32;

    cout << celcius << " Celcius equals " << fahrenheit << " Fahrenheit."<< endl;

    return 0;
}

