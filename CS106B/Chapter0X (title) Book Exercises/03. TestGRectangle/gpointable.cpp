#include "gpointable.h"

Gpointable::Gpointable() {
    x = 0;
    y = 0;
}

Gpointable::Gpointable(double xc, double yc) {
    x = xc;
    y = yc;
}


double Gpointable::getX() const {
    return x;
}

double Gpointable::getY() const {
    return y;
}
