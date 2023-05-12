/*
 * File: Inches.cpp
 * --------------
 * In countries like the United States that still use the traditional English system of measurement,
 * each inch on a ruler is marked off into fractions using tick marks that look like this:
 * The longest tick mark falls at the half-inch position, two smaller tick marks indicate the
 * quarter inches, and even smaller ones are used to mark the eighths and sixteenths. Write a
 * recursive program that draws a 1-inch line at the center of the graphics window and then draws the
 * tick marks shown in the diagram. Assume that the length of the tick mark indicating the half-inch
 * position is given by the constant definition
 *            const double HALF_INCH_TICK = 0.2;
 * and that each smaller tick mark is half the size of the next larger one.
 */

#include "simpio.h"
#include "gwindow.h"
using namespace std;

const int INCH = 100;
const int FRACTION = 8;

const double HALF_INCH_TICK = 0.3;

void drawVertical(GWindow & gw, int xCenter, int yCenter, double standard);
void drawVerticalInch(GWindow & gw, double xStart, double xEnd, double y, double yLenght);


int main() {
    GWindow gw;
    gw.setColor("BLACK");
    gw.drawLine(gw.getWidth() / 2 - INCH / 2, gw.getHeight() / 2, gw.getWidth() / 2 + INCH / 2 , gw.getHeight() / 2);
    drawVerticalInch(gw, gw.getWidth() / 2 - INCH / 2, gw.getWidth() / 2 + INCH / 2, gw.getHeight() / 2, INCH * HALF_INCH_TICK);
    return 0;
}

void drawVerticalInch(GWindow & gw, double xStart, double xEnd, double y, double yLenght) {
    double xLenght = xEnd - xStart;
    double xHalf = xLenght / 2 + xStart;
    if (xLenght > INCH / FRACTION) {
        gw.drawLine(xHalf, y, xHalf, y - yLenght);
        drawVerticalInch(gw, xStart, xStart + xLenght / 2, y, yLenght / 2);
        drawVerticalInch(gw, xHalf, xEnd, y, yLenght / 2);
    }
}
