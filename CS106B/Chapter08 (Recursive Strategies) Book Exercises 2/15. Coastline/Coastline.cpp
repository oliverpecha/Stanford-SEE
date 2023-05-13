/*
 * File: Coastline.cpp
 * --------------
 * One of the reasons that fractals have generated so much interest is that they turn out to
 * be useful in some surprising practical contexts. For example, the most successful techniques
 * for drawing computer images of mountains and certain other landscape features involve using
 * fractal geometry.
 * As a simple example of where this issue comes up, consider the problem of connecting two
 * points A and B with a fractal that looks like a coastline on a map. The simplest possible
 * strategy would be to draw a straight line between the two points:
 *
 * This is the order-0 coastline and represents the base case of the recursion.
 * Of course, a real coastline will have small peninsulas or inlets somewhere along its length,
 * so you would expect a realistic drawing of a coastline to jut in or out occasionally like a
 * real one. As a first approximation, you could replace the straight line with the same fractal
 * line used to create the snowflake fractal, as follows:
 * This process gives the order-1 coastline. However, in order to give the feeling of a traditional
 * coastline, it is important for the triangular wedge in this line sometimes to point up and
 * sometimes down, with equal probability.
 * If you then replace each of the straight-line segments in the order-1 fractal with a fractal
 * line in a random direction, you get the order-2 coastline, which might look like this:
 * Continuing this process eventually results in a drawing that conveys a remarkably realistic sense,
 * as in this order-5 coastline:
 * Write a program to draw a fractal coastline on the graphics window.
 */

#include "simpio.h"
#include "gwindow.h"
#include "random.h"
#include <cmath>

//#include "gtypes.h"
using namespace std;


const double LENGTH = 300;
const int ORDER_LIMIT = 5; //5
void drawEdge(GWindow & gw, int order, GPoint start, double length, int angle);
void repositionStart(GPoint & start, double angle, double length);
void repositionAngle(bool changeDirection, int & angle, int pos);
double sinInAngles(double angle);
double cosInAngles(double angle);
double oppositteD(double angle, double length);
double adjacentD(double angle, double length);


int main() {
    GWindow gw;
    GPoint start(gw.getWidth() / 2 - LENGTH /2, gw.getHeight() / 2);
    gw.setColor("BLACK");
    drawEdge(gw, ORDER_LIMIT, start, LENGTH, 0);
    return 0;
}

void drawEdge(GWindow & gw, int order, GPoint start, double length, int angle) {
    bool changeDirection = randomBool();
    if (order > 1) {
        drawEdge(gw, order - 1, start, length / 3,  angle);

        repositionStart(start, angle, length);
        repositionAngle(changeDirection, angle, 1);
        drawEdge(gw, order - 1, start, length / 3, angle);

        repositionStart(start, angle, length);
        repositionAngle(changeDirection, angle, 2);
        drawEdge(gw, order - 1, start, length / 3,  angle);

        repositionStart(start, angle, length);
        repositionAngle(changeDirection, angle, 3);
        drawEdge(gw, order - 1, start, length / 3,  angle);
    }
    else {
        gw.drawPolarLine(start, length / 3 , angle);

        repositionStart(start, angle, length);
        repositionAngle(changeDirection, angle, 1);
        gw.drawPolarLine(start, length / 3 , angle);

        repositionStart(start, angle, length);
        repositionAngle(changeDirection, angle, 2);
        gw.drawPolarLine(start, length / 3, angle);

        repositionStart(start, angle, length);
        repositionAngle(changeDirection, angle, 3);
        gw.drawPolarLine(start, length / 3, angle);
    }
}

void repositionAngle(bool changeDirection, int & angle, int pos){
    switch (pos) {
    case 1:
        if (changeDirection)  angle -= 60;
        else angle += 60;
        break;
    case 2:
        if (changeDirection)  angle += 120;
        else angle -= 120;
        break;
    case 3:
        if (changeDirection)  angle -= 60;
        else angle += 60;
        break;
    }
}


void repositionStart(GPoint & start, double angle, double length){
    start.y = start.y - oppositteD(angle, length / 3);
    start.x = start.x + adjacentD(angle, length / 3);
}

double oppositteD(double angle, double length){
    // sin(angle) = d / length // d: opposite distance
    // d = sin(angle) * lenght
    // https://www.mathsisfun.com/algebra/trig-finding-side-right-triangle.html
    return sinInAngles(angle) * length;
}

double adjacentD(double angle, double length){
    // sin(angle) = d / length // d: opposite distance
    // d = sin(angle) * lenght
    return cosInAngles(angle) * length;
}
double sinInAngles(double angle){
    return sin(angle*PI/180);
}

double cosInAngles(double angle){
    return cos(angle*PI/180);
}
