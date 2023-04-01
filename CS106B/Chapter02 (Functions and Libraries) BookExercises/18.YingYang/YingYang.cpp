/*
 * File: CheckerBoard.cpp
 * --------------
 * One of the principles that defines Taoist philosophy is that dichotomies do not have sharp boundaries,
 * and that there is mixing even between categories that most people see as opposites.
 * This idea is captured in the Yin-Yang symbol, in which each region contains a bit of the other color:
 *
 * Write a graphics program to draw this symbol at the center of an empty graphics window.
 * The challenge here is to decompose the drawing in such a way that you can create it using only the methods
 * in Table 2-2, which do not include facilities for drawing and filling arcs and semicircles.
 */

#include "console.h"
#include "simpio.h"
#include "gwindow.h"

using namespace std;


int main() {
   GWindow gw(500, 500);
   double width = gw.getWidth();
   double height = gw.getHeight();

   //base black oval
   gw.setColor("BLACK");
   gw.fillOval(width / 4, height / 4, width / 2, height / 2);

   //fake rectangle
   gw.setColor("WHITE");
   gw.fillRect(width / 4, height / 4, width / 4, height / 2);

   //top white medium oval
   gw.setColor("WHITE");
   gw.fillOval(width / 4 + width / 8, height / 2 - height / 4, width / 4, height / 4);

   //top black medium oval
   gw.setColor("BLACK");
   gw.fillOval(width / 4 + width / 8, height / 2, width / 4, height / 4);

   //exterior Oval
   gw.setColor("BLACK");
   gw.drawOval(width / 4, height / 4, width / 2, height / 2);

   //small black
   gw.setColor("BLACK");
   gw.fillOval(width / 2 - width / 40, height / 8 * 3 - width / 40, width / 20, height / 20);

   //small white
   gw.setColor("WHITE");
   gw.fillOval(width / 2 - width / 40, height / 8 * 5 - width / 40, width / 20, height / 20);


   return 0;
}
