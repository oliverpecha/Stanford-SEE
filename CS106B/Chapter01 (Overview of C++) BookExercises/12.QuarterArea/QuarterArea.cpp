/*
 * File: main.cpp
 * --------------
 * You can also compute ! by approximating the area bounded by a circular arc. Consider the following quarter circle:
 * which has a radius r equal to two inches. From the formula for the area of a circle, you can easily determine that
 * the area of the quarter circle should be ! square inches. You can also approximate the area computationally by adding
 * up the areas of a series of rectangles, where each rectangle has a fixed width and the height is chosen so that the
 * circle passes through the midpoint of the top of the rectangle. For example, if you divide the area into 10 rectangles
 * from left to right, you get the following diagram:
 * The sum of the areas of the rectangles approximates the area of the quarter circle. The more rectangles there are, the closer the approximation.
 * For each rectangle, the width w is a constant derived by dividing the radius by the number of rectangles.
 * The height h, on the other hand, varies depending on the position of the rectangle. If the midpoint of the rectangle
 * in the horizontal direction is given by x, the height of the rectangle can be computed using the sqrt function to express the distance formula
 * h= sq r(2)-x(2)
 * The area of each rectangle is then simply h " w.
 * Write a program to compute the area of the quarter circle by dividing it into 10,000 rectangles.
 */

#include "console.h"
#include "simpio.h"
#include <cmath>
using namespace std;

double areaRect;
double areaTotal;
double height;
const double RADIUS = 2.0;
const int TIMES = 10000;
double X = RADIUS / TIMES;

int main() {

    for (int i = 0 ; i < TIMES; i++) {
        height = sqrt(pow(RADIUS,2) - pow((X * i),2));
        areaTotal += height * X;
    }
    cout << "The area of a 2 inch radius quarter circle is " << areaTotal << endl;
    return 0;
}
