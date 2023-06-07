#include "cube.h"
#include "vector.h"

std::string charToColor(char color);
int charFace2index(char face);
Vector<char> input2instruction(std::string input);

Cube::Cube() {

}



Cube::Cube(char front, char back, char left, char right, char top, char bottom) {
    faces.add(front);
    faces.add(back);
    faces.add(left);
    faces.add(right);
    faces.add(top);
    faces.add(bottom);
}


/*
 * Rotate
 * ------------------------------------------------------------
 * Movemenets as: https://i.stack.imgur.com/FS7OG.png
 */

void Cube::moveCube(char type){
    switch (type) {
    case 'R':
        roll();
        break;
    case 'P':
        pitch();
        break;
    case 'Y':
        yaw();
        break;
    }
}

void Cube::roll(){
    char tempTop = getTop();
    setTop(getFront());
    setFront(getBottom());
    setBottom(getBack());
    setBack(tempTop);
}

void Cube::pitch(){
    char tempTop = getTop();
    setTop(getRight());
    setRight(getBottom());
    setBottom(getLeft());
    setLeft(tempTop);
}
void Cube::yaw(){
    char tempFront = getFront();
    setFront(getLeft());
    setLeft(getBack());
    setBack(getRight());
    setRight(tempFront);
}

/*
 * Rotating movements
 * ------------------------------------------------------------
 */

void Cube::rotator(Vector<Cube> & element, int index, char originFace, char targetFace){
    Cube temp = element[index];
    temp.rotator(temp, originFace, targetFace);
    element.set(index, temp);
}

void rotator(Vector<Cube> & element, std::string instruction){
    Vector<char> dothis = input2instruction(instruction);
    Cube temp = element[dothis[0]];
    temp.rotator(temp, dothis[1], dothis[2]);
    element.set(dothis[0], temp);
}


void Cube::rotator(Cube & element, char originFace, char targetFace){
    if (originFace == 'F' && targetFace == 'S') rotateFront2Side(element);
    else if (originFace == 'F' && targetFace == 'T') rotateFront2Top(element);

    else if (originFace == 'S' && targetFace == 'F') rotateSide2Front(element);
    else if (originFace == 'S' && targetFace == 'T') rotateSide2Top(element);

    else if (originFace == 'T' && targetFace == 'F') rotateTop2Front(element);
    else if (originFace == 'T' && targetFace == 'S') rotateTop2Side(element);
}


void Cube::rotateFront2Side(Cube & element){
    for (int var = 0; var < 3; ++var) {
        element.yaw();
    }
}

void Cube::rotateFront2Top(Cube & element){
    element.roll();
}

void Cube::rotateSide2Front(Cube & element){
    element.yaw();
}
void Cube::rotateSide2Top(Cube & element){
    for (int var = 0; var < 3; ++var) {
        element.pitch();
    }
}

void Cube::rotateTop2Front(Cube & element){
    for (int var = 0; var < 3; ++var) {
        element.roll();
    }
}
void Cube::rotateTop2Side(Cube & element){
    element.pitch();
}


/*
 * GetState
 * ------------------------------------------------------------
 */
char Cube::getFace(char face) {
    return faces.get(charFace2index(face));
}

char Cube::getFront() {
    return faces.get(0);
}
char Cube::getBack() {
    return faces.get(1);
}
char Cube::getLeft() {
    return faces.get(2);
}
char Cube::getRight() {
    return faces.get(3);
}
char Cube::getTop() {
    return faces.get(4);
}
char Cube::getBottom() {
    return faces.get(5);
}



/*
 * SetState
 * ------------------------------------------------------------
 */
void Cube::setFront(char color) {
    faces.set(0, color);
}
void Cube::setBack(char color) {
    faces.set(1, color);
}
void Cube::setLeft(char color) {
    faces.set(2, color);
}
void Cube::setRight(char color) {
    faces.set(3, color);
}
void Cube::setTop(char color) {
    faces.set(4, color);
}
void Cube::setBottom(char color) {
    faces.set(5, color);
}

/*
 * Print
 * ------------------------------------------------------------
 */

void Cube::toString() {
    std::cout << "| " << charToColor(Cube::getFront()) << " | "
                      << charToColor(Cube::getBack())  << " | "
                      << charToColor(Cube::getLeft())  << " | "
                      << charToColor(Cube::getRight()) << " | "
                      << std::endl;
}


std::string charToColor(char color){
    switch (color) {
    case 'B':
        return " Blue";
    case 'W':
        return "White";
    case 'R':
        return " Red ";
    case 'G':
        return "Green";
    default:
        return "error";
    }
}

int charFace2index(char face){
    switch (face) {
        case 'F':
            return 0;
        case 'B':
            return 1;
        case 'L':
            return 2;
        case 'R':
            return 3;
        case 'T':
            return 4;
        case 'O':
            return 5;
        default:
            return -1;
    }
}

Vector<char> input2instruction(std::string input){
    Vector<char> result;
    for (int var = 0; var < 3; ++var) {
        result.add(input[var]);
    }
    return result;
}

