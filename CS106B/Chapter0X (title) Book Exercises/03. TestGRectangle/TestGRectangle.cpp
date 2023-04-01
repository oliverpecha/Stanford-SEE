/*
 * File: TestGRectanlge.cpp
 * --------------
 * The gtypes.h interface included in Appendix A exports a few useful classes designed
 * to work together with the graphics library. The simplest of these classes is GPoint,
 * which is identical to the Point class from this chapter except for the fact that
 * it uses floating-point numbers for the coordinates instead of integers.
 * Another useful class is GRectangle, which represents a rectangular region defined
 * by the x and y coordinates of its upper left corner along with a width and a height.
 * Using the description of the GRectangle class in Appendix A for reference,
 * implement the GRectangle class.
 */

#include "console.h"
#include "simpio.h"
#include "greggatangle.h"
#include "gpointable.h"

using namespace std;


int main(){
    GReggatangle one;
    if (one.isEmpty()) cout << "one empty!"<< endl;
    else cout << "one filled!"<< endl;
    cout << endl;

    GReggatangle two(30,30,60,60);
    if (two.isEmpty()) cout << "two empty!"<< endl;
    else cout << "two filled!"<< endl;
    cout << endl;

    Gpointable ptOne (45,45);
    Gpointable ptTwo (5,5);

    if (two.contains(ptOne)) cout << "two contains ptOne"<< endl;
    else cout << "two doesn't contain ptOne"<< endl;
    cout << endl;

    if (two.contains(ptTwo)) cout << "two contains ptTwo"<< endl;
    else cout << "two doesn't contain ptTwo"<< endl;
    cout << endl;

    if (two.contains(45,45)) cout << "two contains 5,5"<< endl;
    else cout << "two doesn't contain 45, 45"<< endl;
    cout << endl;


    return 0;
}
