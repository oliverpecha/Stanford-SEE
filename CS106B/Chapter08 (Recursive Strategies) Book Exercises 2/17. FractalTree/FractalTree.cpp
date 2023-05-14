/*
 * File: FractalTree.cpp
 * --------------
 * To celebrate its 550th anniversary in 2008, Magdalen College at Oxford commissioned
 * the English artist Mark Wallinger to create a sculpture called Y that has a decidedly
 * recursive structure. A photograph of the sculpture appears at the left of Figure 8-7
 * and a diagram illustrating its fractal nature appears at the right. Given its
 * branching structure, the underlying pattern in Wallinger’s sculpture is called a
 * fractal tree. The tree begins as a simple trunk indicated by a straight vertical line,
 * as follows:
 *
 * The trunk may branch at the top to form two lines that veer off at an angle, as shown:
 *
 * These branches may themselves split to form new branches, which split to form new ones, and so on.
 * Write a program that uses the graphics library to draw the fractal tree in Wallinger’s
 * sculpture. If you carry this process on to the eighth-order fractal, you get the image
 * on the right of Figure 8-7.
 *
 */

//#include "console.h"
#include "simpio.h"
#include "gwindow.h"
#include <cmath>



using namespace std;

void drawTree(GWindow & gw, GPoint c, double size, int angle, int order);
void drawBranch(GWindow & gw, GPoint c, double size, int angle);
void repositionStartA(GPoint & center, double angle, double length);
void repositionStartB(GPoint & center, double angle, double length);
double sinInAngles(double angle);
double cosInAngles(double angle);
double oppositteD(double angle, double length);
double adjacentD(double angle, double length);

const int ORDER = 8;
const int SCALE = 120;
const double DOWNSIZE = 0.6;
const double UPSIZE = 1.6;


int main() {
    GWindow gw(900, 500);
    gw.setColor("BLACK");
    GPoint center(gw.getWidth() / 2, gw.getHeight() / 2 + SCALE / 3);
    drawTree(gw, center, SCALE, 0, ORDER);
    return 0;
}


void drawTree(GWindow & gw, GPoint center, double size, int angle, int order) {
    GPoint previousCenter = center;
    if (order > 0) {
        drawBranch(gw, center, size, angle);
        repositionStartB(center, angle - 45, size*3);
        drawTree(gw, center, size * DOWNSIZE, angle + 45, order - 1);
        center = previousCenter;
        repositionStartA(center, angle + 45, size*3);
        drawTree(gw, center, size * DOWNSIZE, angle - 45, order - 1);
    }
}


void drawBranch(GWindow & gw, GPoint c, double size, int angle){
    gw.drawPolarLine(c, size, angle + 135);
    gw.drawPolarLine(c, size, angle + 45);
    gw.drawPolarLine(c, size * UPSIZE, angle -90);
}


void repositionStartA(GPoint & center, double angle, double length){
    center.y = center.y - oppositteD(angle, length / 3);
    center.x = center.x + adjacentD(angle, length / 3);
}

void repositionStartB(GPoint & center, double angle, double length){
    center.y = center.y + oppositteD(angle, length / 3);
    center.x = center.x - adjacentD(angle, length / 3);
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
