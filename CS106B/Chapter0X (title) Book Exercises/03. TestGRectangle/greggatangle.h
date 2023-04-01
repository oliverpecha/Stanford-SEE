#ifndef GREGGATANGLE_H
#define GREGGATANGLE_H

#include <string>
#include "gpointable.h"

/*
* Class: GRectangle
*
* This class represents a rectangle on the graphics plane and is
* conventionally used to denote the bounding box for an object. */

class GReggatangle {

public:
/*
* Constructor: GRectangle
* Usage: GRectangle empty;
*        Rectangle r(x, y, width, height);
* Creates a GRectangle object with the specified components. If these
* parameters are not supplied, the default constructor sets these fields
* to 0.
*/

GReggatangle();
GReggatangle (double x, double y, double width, double height);


/*
* Method: getX
* Usage: double x = r.getX();
*
* Returns the x component of the rectangle.
*/

double getX() const;

/*
* Method: getY
* Usage: double y = pt.getY();
*
* Returns the y component of the rectangle.
*/

double getY() const;


/*
* Method: getWidth
* Usage: double width = r.getWidth();
* Returns the width component of the rectangle.
*/
double getWidth() const;

/*
* Method: getHeight
* Usage: double height = pt.getHeight();
*
* Returns the height component of the rectangle.
*/

double getHeight() const;

/*
* Method: isEmpty
* Usage: if (r.isEmpty())
*
* Returns true if the rectangle is empty.
*/
bool isEmpty() const;

/*
* Method: contains
* Usage: if (r.contains(pt))
*        if (r.contains(x, y))
* Returns true if the rectangle contains the given point, which may be
* specified either as a point or as distinct coordinates.
*/
bool contains (Gpointable pt) const;
bool contains (double xc, double yc) const;


/*
* Method: toString
* Usage: string str = r.toString () ;
*
* Converts the GRectangle to a string in the form " (x, y, width, height)". */

std::string toString() const;


private:

double x;
double y;
double width;
double height;

};

#endif // GREGGATANGLE_H

