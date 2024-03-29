#ifndef CUBE_H
#define CUBE_H
#include "vector.h"


class Cube {
public:
    // Constructors
    Cube();
    Cube(char front, char back, char left, char right, char top, char bottom);

     // Rotate
     void moveCube(char type);
     void roll();
     void pitch();
     void yaw();

      // Rotating movements
     void rotator(Cube & element, char originFace, char targetFace);

     void rotator(Vector<Cube> & element, std::string instruction);
     void rotator(Vector<Cube> & element, int index, char originFace, char targetFace);

     void rotateFront2Side(Cube & element);
     void rotateFront2Top(Cube & element);

     void rotateSide2Front(Cube & element);
     void rotateSide2Top(Cube & element);

     void rotateTop2Front(Cube & element);
     void rotateTop2Side(Cube & element);



     // GetState
     char getFace(char face);
     char getFace(int face);
     char getFront();
     char getBack();
     char getLeft();
     char getRight();
     char getTop();
     char getBottom();

     // SetState
     void setFront(char color);
     void setBack(char color);
     void setLeft(char color);
     void setRight(char color);
     void setTop(char color);
     void setBottom(char color);

    // Print
    void toString();


private:

Vector<char> faces;

};


#endif // CUBE_H
