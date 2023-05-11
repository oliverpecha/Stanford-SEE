/*
* File: Mondrian.cpp
* ------------------------------------------
* This program creates a line drawing in a style reminiscent of Mondrian.
*/

//#include "console.h"
#include "simpio.h"
#include <iostream>
#include "gwindow.h"
#include "gtypes.h"
#include "random.h"

using namespace std;



/* Constants */
const double MIN_AREA = 10000; /* Smallest square that will be split */
const double MIN_EDGE = 20;  /* Smallest edge length allowed */

const int xScreen = 900;
const int yScreen = 500;

/* Function prototypes */
void subdivideCanvas (GWindow & gw, double x, double y, double width, double height);
void growToCanvas (GWindow & gw, double x, double y, double width, double height);
string randomColor(int n);
int whyNot();



/* Main program */
int main() {
    GWindow gw;
    gw.setColor("BLACK");
    subdivideCanvas(gw, 0, 0, gw.getWidth(), gw.getHeight ());
    //growToCanvas(gw, 0, 0, gw.getWidth(), gw.getHeight ());

    cout << "gw.getWidth() " << gw.getWidth() << ", gw.getHeight() " << gw.getHeight() << endl;
    return 0;
}

/* Function: subdivideCanvas
* Usage: subdivideCanvas (gw, x, y, width, height);
* ---------------------------------------------------------------------------
* Decomposes the specified rectangular region on the canvas recursively
* by splitting that rectangle randomly along its larger dimension. The
* recursion continues until the area falls below the constant MIN_AREA.
*/
void subdivideCanvas (GWindow & gw, double x, double y, double width, double height) {
    if (width * height >= MIN_AREA) {
        if (width > height) {
            double mid = randomReal (MIN_EDGE, width - MIN_EDGE);
            gw.setColor(randomColor(randomInteger(1, 8)));
            gw.fillRect(x, y, mid, height);
            gw.setColor("BLACK");
            gw.drawRect(x, y, mid, height);
            subdivideCanvas(gw, x, y, mid, height);
            subdivideCanvas(gw, x + mid, y, width - mid, height);
        } else {
            double mid = randomReal (MIN_EDGE, height - MIN_EDGE);
            gw.drawLine(x, y + mid, x + width, y + mid);
            subdivideCanvas(gw, x, y, width, mid);
            subdivideCanvas(gw, x, y + mid, width, height - mid);



        }
    }
}



string randomColor(int n){
    switch (n) {
        case 1:
            return "YELLOW";
        case 2:
        case 3:
            return "RED";
        case 4:
        case 5:
            return "BLUE";
        case 6:
            return "GRAY";
        default:
            return "WHITE";
    }
}
