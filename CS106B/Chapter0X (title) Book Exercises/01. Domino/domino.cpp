#include "domino.h"
#include "strlib.h"

Domino::Domino() {
    l = 0;
    r = 0;
}

Domino::Domino(int sL, int sR) {
    l = sL;
    r = sR;
}

int Domino::getLeftDots() {
    return l;
}

int Domino::getRightDots() {
    return r;
}

std::string Domino::toString(){
    return "[" + integerToString(l) + "][" + integerToString(r) + "]";
}

std::ostream & operator<<(std::ostream & os, Domino p1){
    return os << p1.toString();
}


bool operator==(Domino p1, Domino p2){
    return (p1.l == p2.l && p1.r == p2.r) || (p1.l == p2.r && p1.r == p2.l);
}

bool operator!=(Domino p1, Domino p2){
    return !(p1==p2);
}
