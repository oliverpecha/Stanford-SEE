/*
 * File: CheckerBoard.cpp
 * --------------
 * Use the graphics library to write a program that draws a checkerboard on the graphics window. Your picture should include the red and black pieces, as they exist at the beginning of the game, like this:
 */

#include "console.h"
#include "simpio.h"
#include "gwindow.h"

using namespace std;

int main() {
   GWindow gw(500, 500);
   double width = gw.getWidth();
   double height = gw.getHeight();

   for (int h = 0; h < 8; h++){
       for (int v = 0; v < 8; v++){
           if ((h % 2 == 0 && v % 2 == 0) || (h % 2 == 1 && v % 2 == 1)) {
               gw.setColor("GRAY");
               gw.fillRect(width/8 * h, height/8 * v, width / 8, height / 8);
               if (v < 3) {
                   gw.setColor("RED");
                   gw.fillOval(width/8 * h + 8, height/8 * v + 8, width / 8 - 16, height / 8 - 16);
                   gw.setColor("BLACK");
                   gw.drawOval(width/8 * h + 8, height/8 * v + 8, width / 8 - 16, height / 8 - 16);
                }
               if (v > 4) {
                   gw.setColor("BLACK");
                   gw.fillOval(width/8 * h + 8, height/8 * v + 8, width / 8 - 16, height / 8 - 16);
                }
           }
       }
   }
   return 0;
}
