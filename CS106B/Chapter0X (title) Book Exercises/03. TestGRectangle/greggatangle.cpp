#include "greggatangle.h"
#include "gpointable.h"
#include <string>
#include "simpio.h"

GReggatangle::GReggatangle(){
    x = 0;
    y = 0;
}

GReggatangle::GReggatangle(double xc, double yc, double widthc, double heightc){
    x = xc;
    y = yc;
    width = widthc;
    height = heightc;
}


double GReggatangle::getX() const {
    return x;
}

double GReggatangle::getY() const {
    return y;
}

double GReggatangle::getWidth() const {
    return width;
}

double GReggatangle::getHeight() const {
    return height;
}

bool GReggatangle::isEmpty() const {
    if (x == 0 || y == 0 || width == 0 || height == 0) return true;
    else return false;
}

bool GReggatangle::contains (double xc, double yc) const {
    if (xc > x && xc < x + width && yc > y && yc < y + height) {
        std::cout << "yes" << std::endl;
       return true;
    }
    else {
         std::cout << "no xc: " << xc << " x: " << x <<
                        " yc: " << yc << "y: " << y <<
                      " width: " << width <<
                      " height: " << height << std::endl;
        return false;
    }
}

bool GReggatangle::contains (Gpointable pt) const {
    if (contains(pt.getX(), pt.getY())) return true;
    else return false;
}

std::string GReggatangle::toString() const{
    return "(" + std::to_string(x) +  std::to_string(y) + std::to_string(width) + std::to_string(height) + ")";
}
