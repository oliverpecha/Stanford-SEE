/*
 * File: main.cpp
 * --------------
 * If you did not do so the first time around, rewrite the Celsius-to-Fahrenheit program from exercise 1
 * in Chapter 1 so that it uses a function to perform the conversion.
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
