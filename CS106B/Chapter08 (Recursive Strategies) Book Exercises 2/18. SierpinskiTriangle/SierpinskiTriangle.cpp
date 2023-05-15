/*
 * File: SierpinskiTriangle.cpp
 * --------------
 * Another interesting fractal is the Sierpinski Triangle, named after its inventor,
 * the Polish mathematician Wac!aw Sierpi"ski (1882–1969). The order-0 Sierpinski
 * Triangle is an equilateral triangle:
 *
 * To create an order-N Sierpinski Triangle, you draw three Sierpinski Triangles
 * of order N – 1, each of which has half the edge length of the original. Those
 * three triangles are placed in the corners of the larger triangle, which means
 * that the order-1 Sierpinski Triangle looks like this:
 *
 * The downward-pointing triangle in the middle of this figure is not drawn explicitly,
 * but is instead formed by the sides of the other three triangles. That area,
 * moreover, is not recursively subdivided and will remain unchanged at every
 * level of the fractal decomposition. Thus, the order-2 Sierpinski Triangle has
 * the same open area in the middle:
 * If you continue this process through three more recursive levels, you get the
 * order-5 Sierpinski Triangle, which looks like this:
 *
 * Write a program that asks the user for an edge length and a fractal order and
 * draws the resulting Sierpinski Triangle in the center of the graphics window.

 */

//#include "console.h"
#include "simpio.h"
#include "gwindow.h"
#include <cmath>



using namespace std;

void drawStructure(GWindow & gw, GPoint c, double size, int order);
void drawTriangle(GWindow & gw, GPoint c, double size);
GPoint defineVertex(GPoint & center, double length, int nVertex);
GPoint defineCenter(GPoint & center, double length, int nVertex);

void drawGuides(GWindow & gw, GPoint center, double length);
double sinInAngles(double angle);
double cosInAngles(double angle);
double tanInAngles(double angle);
double sine(double angle, double length);
double cosine(double angle, double length);
double tangent(double angle, double length);


const int ORDER = 5;
const int SCALE = 300;


GPoint ovalVertex(GPoint center, double size){
    GPoint result;
    result.x = center.x - size / 2;
    result.y = center.y + size / 2;
    return result;
}

int main() {
    GWindow gw(900, 500);
    gw.setColor("BLACK");
    GPoint center(gw.getWidth() / 2, gw.getHeight() / 2);
    //drawGuides(gw, center, SCALE);
    drawStructure(gw, center, SCALE, ORDER);
    return 0;
}


void drawStructure(GWindow & gw, GPoint center, double size, int order) {
    if (order > 1) {
        GPoint c1 = defineCenter(center, size, 1);
        drawStructure(gw, c1, size / 2, order - 1);
            GPoint c1a =  defineCenter(c1, size / 2, 1);
            GPoint c1b = defineCenter(c1, size / 2, 2);
            GPoint c1c =  defineCenter(c1, size / 2, 3);
            drawStructure(gw, c1a, size / 4, order - 1);
            drawStructure(gw, c1b, size / 4, order - 1);
            drawStructure(gw, c1c, size / 4, order - 1);

        GPoint c2 = defineCenter(center, size, 2);
        drawStructure(gw, c2, size / 2, order - 1);
            GPoint c2a =  defineCenter(c2, size / 2, 1);
            GPoint c2b = defineCenter(c2, size / 2, 2);
            GPoint c2c =  defineCenter(c2, size / 2, 3);
            drawStructure(gw, c2a, size / 4, order - 1);
            drawStructure(gw, c2b, size / 4, order - 1);
            drawStructure(gw, c2c, size / 4, order - 1);

        GPoint c3 = defineCenter(center, size, 3);
        drawStructure(gw, c3, size / 2, order - 1);
            GPoint c3a =  defineCenter(c3, size / 2, 1);
            GPoint c3b = defineCenter(c3, size / 2, 2);
            GPoint c3c =  defineCenter(c3, size / 2, 3);
            drawStructure(gw, c3a, size / 4, order - 1);
            drawStructure(gw, c3b, size / 4, order - 1);
            drawStructure(gw, c3c, size / 4, order - 1);
    }
    else {
        drawTriangle(gw, center, size);
    }

}



void drawTriangle(GWindow & gw, GPoint c, double size){
    GPoint first = defineVertex(c, size, 1);
    GPoint second = defineVertex(c, size, 2);
    GPoint third = defineVertex(c, size, 3);
    //gw.setColor("BLACK");
    gw.drawPolarLine(first, size, 0);
    //gw.setColor("YELLOW");
    gw.drawPolarLine(second, size, 120);
    //gw.setColor("BLUE");
    gw.drawPolarLine(third, size, 240);


}

GPoint defineVertex(GPoint & center, double length, int nVertex){
    GPoint result = center;
    double adjacent = length / 2;
    double opposite = tangent(30, adjacent);
    double hypotenuse = sine(30, opposite);
    switch (nVertex) {
        case 1:
            result.y = center.y + opposite;
            result.x = center.x - adjacent;
            break;
        case 2:
            result.y = center.y + opposite;
            result.x = center.x + adjacent;
            break;
        case 3:
            result.y = center.y - hypotenuse;
            break;
    }
    return result;
}

GPoint defineCenter(GPoint & center, double length, int nVertex){
    GPoint result = center;
    double adjacent = length / 2;
    double opposite = tangent(30, adjacent);
    double hypotenuse = sine(30, opposite);
    switch (nVertex) {
        case 1:
            result.x = center.x - adjacent / 2;
            result.y = center.y + opposite / 2;
            break;
        case 2:
            result.x = center.x + adjacent / 2;
            result.y = center.y + opposite / 2;
            break;
        case 3:
            result.y = center.y - hypotenuse / 2;
            break;
    }
    return result;
}



double sine(double angle, double length){
    // sin(angle) = d / length // d: opposite distance
    // d = sin(angle) * lenght
    // https://www.mathsisfun.com/algebra/trig-finding-side-right-triangle.html
    return length / sinInAngles(angle);
}

double cosine(double angle, double length){
    // sin(angle) = d / length // d: adjacent distance
    // d = sin(angle) * lenght
    return cosInAngles(angle) * length;
}

double tangent(double angle, double length){
    // tan(θ) = Opposite / Adjacent
    // tan(angle) = d / length // d: adjacent distance
    // d = tan(angle) * lenght
    return tanInAngles(angle) * length;
}

double sinInAngles(double angle){
    return sin(angle*PI/180);
}

double cosInAngles(double angle){
    return cos(angle*PI/180);
}

double tanInAngles(double angle){
    return tan(angle*PI/180);
}


void drawGuides(GWindow & gw, GPoint center, double length) {
    gw.setColor("RED");
    double adjacent = length / 2;
    double opposite = tangent(30, adjacent);
    double hypotenuse = sine(30, opposite);
    gw.drawOval(center.x - hypotenuse, center.y - hypotenuse, hypotenuse * 2, hypotenuse * 2);

    gw.setColor("GREEN");
    gw.drawLine(gw.getWidth() / 2, 0, gw.getWidth() / 2, gw.getHeight());
    gw.drawLine(0, gw.getHeight() / 2,  gw.getWidth(), gw.getHeight() / 2);
}
