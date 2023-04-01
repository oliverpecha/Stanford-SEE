#ifndef DOMINO_H
#define DOMINO_H


#include <iostream>
#include <string>

class Domino {

public:
    Domino();

    Domino(int sL, int sR);

    int getLeftDots();
    int getRightDots();

    std::string toString();

    int l;
    int r;

};

std::ostream & operator<<(std::ostream & os, Domino p1);

bool operator==(Domino p1, Domino p2);
bool operator!=(Domino p1, Domino p2);


#endif // DOMINO_H
