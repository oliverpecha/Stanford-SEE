/*
 * File: main.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
#include "gwindow.h"

using namespace std;


int main() {
   GWindow gw(500, 500);
   cout << "This program draws a diamond, rectangle, and oval." << endl;
   double width = gw.getWidth();
   double height = gw.getHeight();
   gw.drawLine(0, height / 2, width / 2, 0);
   gw.drawLine(width / 2, 0, width, height / 2);
   gw.drawLine(width, height / 2, width / 2, height);
   gw.drawLine(width / 2, height, 0, height / 2);

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

/*
 *
 gw.setColor("BLUE");
 gw.fillRect(width / 4, height / 4, width / 2, height / 2);
 */
