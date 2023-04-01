/*
 * File: YarnPattern.cpp
 * --------------
 * The classes exported by the gtypes.h interface described in the preceding exercise
 * make it simpler to create intricate graphical patterns, in part because they
 * make it easy to store coordinate information inside collection classes and
 * other abstract data types. In this exercise, for example, you get to have
 * some fun with a vector of GPoint objects. Imagine that you start with a
 * rectangular board and then arrange pegs around the edges so that they
 * are evenly spaced along all four edges, with N_ACROSS pegs along the top
 * and bottom and N_DOWN pegs along the left and right edges. To model this
 * process using the graphics window, what you want to do is create a
 * Vector<GPoint> that holds the coordinates of each of these pegs, which
 * are inserted into the vector starting at the upper right and then proceeding
 * clockwise around the edges of the rectangle, as follows:
 *
 * From here, you create a figure by drawing lines between the pegs, starting
 * at peg 0 and then moving ahead a fixed number of spaces on each cycle, as
 * specified by the constant DELTA. For example, if DELTA is 11, the first line
 * goes from peg 0 to peg 11, the second goes from peg 11 to peg 22, and the
 * third—which has to count 11 pegs clockwise past the beginning—goes from
 * peg 22 to peg 5. The process continues in this way until the line returns
 * to peg 0. As usual, implementing the wrap-around feature is much easier if
 * you make use of the % operator.
 *
 * Write a program that simulates this process on the graphics window using
 * larger values for N_ACROSS and N_DOWN. The output of the program with
 * N_ACROSS equal to 50, N_DOWN equal to 30, and DELTA equal to 67 appears
 * in Figure 6-13. By changing those constants, you can create other wonderful
 * patterns composed entirely of straight lines.
 */

#include "console.h"
#include "gwindow.h"
#include "gtypes.h"
#include "vector.h"

using namespace std;

void fillBoard(Vector<GPoint> & board);
void coutBoard(Vector<GPoint> & board);
void drawYarn(Vector<GPoint> & board, GWindow & gw);


const int xScreen = 900;
const int yScreen = 500;
const int DELTA = 67;
const int N_ACROSS = 50;
const int N_DOWN = 30;



int main() {
    GWindow gw(xScreen, yScreen);
    Vector<GPoint> board;
    fillBoard(board);
    //coutBoard(board);
    drawYarn(board, gw);
    return 0;
}

void drawYarn(Vector<GPoint> & board, GWindow & gw) {
    int a = DELTA;
    int b = DELTA * 2;
    GLine init(board[a],board[b]);
    init.setColor("BLUE");
    gw.draw(init);
    while (a != 0) {
        a = (a + DELTA) % board.size();
        b = (b + DELTA) % board.size();
        GLine yarn(board[a],board[b]);
        yarn.setColor("BLUE");
        gw.draw(yarn);
    }

}


void fillBoard(Vector<GPoint> & board){
    for (int y = 0; y <= yScreen; y += yScreen/N_DOWN) {
        for (int x = 0; x <= xScreen; x += xScreen/N_ACROSS) {
            if (y != yScreen && (y == 0 || x == xScreen)) {
                GPoint pt(x,y);
                board.add(pt);
            }
        }
    }
    for (int y = yScreen; y >= 0; y -= yScreen/N_DOWN) {
        for (int x = xScreen; x >= 0; x -= xScreen/N_ACROSS) {
            if (y != 0 && (y == yScreen || x == 0)) {
                GPoint pt(x,y);
                board.add(pt);
            }
        }
    }
}

void coutBoard(Vector<GPoint> & board) {
    for (int var = 0; var < board.size(); ++var) {
        cout << var << ")" << board[var] << endl;
    }
    cout << "board size" << board.size();
}
