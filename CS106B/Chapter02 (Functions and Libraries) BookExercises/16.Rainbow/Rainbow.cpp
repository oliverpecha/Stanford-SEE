/*
 * File: Rainbow.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
#include "gwindow.h"

using namespace std;



int main() {
   GWindow gw(600, 300);
   int width = gw.getWidth();
   int height = gw.getHeight();
   int tube =  height / 14;
   gw.setColor("CYAN");
   gw.fillRect(0, 0, width, height);

   gw.setColor("RED");
   gw.fillOval(0 - width / 2 , 0 + tube, width * 2, width * 2);

   gw.setColor("ORANGE");
   gw.fillOval(0 - width / 2 + tube, 0 + tube * 2, width * 2 - tube * 2, width * 2 - tube * 2);


   gw.setColor("YELLOW");
   gw.fillOval(0 - width / 2 + tube * 2, 0 + tube * 3, width * 2 - tube * 4, width * 2 - tube * 4);

   gw.setColor("GREEN");
   gw.fillOval(0 - width / 2 + tube * 3, 0 + tube * 4, width * 2 - tube * 6, width * 2 - tube * 6);

   gw.setColor("BLUE");
   gw.fillOval(0 - width / 2 + tube * 4, 0 + tube * 5, width * 2 - tube * 8, width * 2 - tube * 8);

   gw.setColor("MAGENTA");
   gw.fillOval(0 - width / 2 + tube * 5, 0 + tube * 6, width * 2 - tube * 10, width * 2 - tube * 10);

   gw.setColor("CYAN");
   gw.fillOval(0 - width / 2 + tube * 6, 0 + tube * 7, width * 2 - tube * 12, width * 2 - tube * 12);

   return 0;
}
