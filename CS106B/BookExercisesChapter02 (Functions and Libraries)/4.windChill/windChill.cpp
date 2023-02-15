/*
 * File: windChill.cpp
 * --------------
 * If you are unfortunate enough to be outside in winter weather, you know that your perception of the cold
 * is dependent on the wind speed as well as the temperature. The faster the wind blows, the colder you feel.
 * To quantify the how wind affects temperature perception, the National Weather Service reports the wind chill,
 * which is illustrated on their website as shown in Figure 2-17.
 *
 * As you can see at the bottom of Figure 2-17, the National Weather Service calculates wind chill using the formula
 * 35.74 + 0.6215 t – 35.75 v(0.16)+ 0.4275 t v(0.16)
 * where t is the Fahrenheit temperature and v is the wind speed in miles per hour.
 *
 * Write a function windChill that takes the values of t and v and returns the wind chill. In doing so,
 * your function should take account of two special cases:
 * • If there is no wind, windChill should return the original temperature t.
 * • If the temperature is greater than 40° F, the wind chill is undefined, and your function should call error
 * with an appropriate message.
 *
 * Although it will be easier to do so once you learn how to format numeric data in Chapter 4, you already know enough
 * to generate a table that presents the wind-chill data in columns as shown in Figure 2-17. If you’re up for more of
 * a challenge, write a main program that uses windChill to produce that table.
 */

#include "console.h"
#include "simpio.h"
#include "error.h"
#include <cmath>
using namespace std;

// t = Temperature, v=Wind
int windChill(int t, int v);

int main()
{
    int t = getInteger("What is the Fahrenheit temperature");
    if (t > 40 || t < -45) {
        error("Temperatures below -45 F and above 40 F can't be estimated");
    }
    int v = getInteger("What is the Wind Speed ");
    cout << "WindChill is " << windChill(t, v) << endl;
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
