/*
 * File: HFractal.cpp
 * --------------
 * If you search the web for fractal designs, you will find many intricate wonders beyond
 * the Koch snowflake illustrated in this chapter. H-fractal, in which the repeated pattern
 * is shaped like an elongated letter H in which the horizontal bar and vertical lines on
 * the sides have the same length. Thus, the order-0 H- fractal looks like this:
 * To create the order-1 fractal, all you do is add four new H-fractals—each one half of the
 * original size—at each open end of the order-0 fractal, like this:
 * To create the order-2 fractal, all you have to do is add even smaller H-fractals (again half
 * the size of the fractal to which they connect) to each of the open endpoints. This process
 * gives rise to the following order-2 fractal:
 *
 * Write a recursive function
 *            drawHFractal(GWindow & gw, double x, double y, double size, int order);
 * where x and y are the coordinates of the center of the H-fractal, size specifies the width
 * and the height, and order indicates the order of the fractal. As an example, the main program
 *            int main() {
 *               GWindow gw;
 *               double xc = gw.getWidth() / 2;
 *               double yc = gw.getHeight() / 2;
 *               drawHFractal(gw, xc, yc, 100, 3);
 *               return 0;
 *            }
 * would draw an order-3 H-fractal at the center of the graphics window, like this:
 */

//#include "console.h"
#include "simpio.h"
#include "gwindow.h"

using namespace std;

void drawHFractal(GWindow & gw, double x, double y, double size, int order);
void drawH(GWindow & gw, double x, double y, double size);


const int ORDER = 1;
const int PERIMETER = 100;
const double DOWNSIZE = 0.5;

int main() {
    GWindow gw;
    gw.setColor("BLACK");
    drawHFractal(gw, gw.getWidth() / 2, gw.getHeight() / 2, PERIMETER, ORDER);
    return 0;
}


void drawHFractal(GWindow & gw, double x, double y, double size, int order) {
    if (order > 0) {
        drawHFractal(gw, x - size / 2, y - size / 2, size * DOWNSIZE, order - 1);
        drawHFractal(gw, x - size / 2, y + size / 2, size * DOWNSIZE, order - 1);
        drawHFractal(gw, x + size / 2, y - size / 2, size * DOWNSIZE, order - 1);
        drawHFractal(gw, x + size / 2, y + size / 2, size * DOWNSIZE, order - 1);
        drawH(gw, x, y, size);

    }

}


void drawH(GWindow & gw, double x, double y, double size){
    gw.drawLine(x - size / 2, y, x + size / 2, y);
    gw.drawLine(x - size / 2, y - size / 2, x - size / 2, y + size / 2);
    gw.drawLine(x + size / 2, y - size / 2, x + size / 2, y + size / 2);
}
