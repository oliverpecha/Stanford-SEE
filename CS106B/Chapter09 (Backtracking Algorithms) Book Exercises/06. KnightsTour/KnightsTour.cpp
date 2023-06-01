/*
 * File: KnightsTour.cpp
 * --------------
 * In chess, a knight moves in an L-shaped pattern: two squares in one
 * direction horizontally or vertically, and then one square at right angles
 * to that motion. For example, the white knight in the upper right side of
 * the following diagram can move to any of the eight squares marked with
 * an !:
 * The mobility of a knight decreases near the edge of the board, as
 * illustrated by the black knight in the corner, which can reach only the
 * two squares marked with an o.
 * It turns out that a knight can visit all 64 squares on a knightJourney
 * without ever moving to the same square twice. A path for the knight that
 * moves through all the squares without repeating a square is called a
 * knight’s tour. One such tour is shown in the following diagram, in which
 * the numbers in the squares indicate the order in which they were visited:
 * Write a program that uses backtracking recursion to find a knight’s tour.
 */

#include "console.h"
#include "simpio.h"
#include "grid.h"
#include "gwindow.h"
using namespace std;

const int BOARD_WIDTH = 8;
const int PIX_SIZE = 30;
const int T_PAUSE = 10;

void displayknightJourney(GWindow & gw, Grid<int> knightJourney, int yLast, int xLast, int pixSize) ;
void knightClockWise(int turn, int & y, int & x);
bool knightMove(GWindow & gw, Grid<int> & knightJourney, int & moveCount, int yStart, int xStart);
void undoMove(Grid<int> & knightJourney, int & moveCount, int yDest, int xDest);
void makeMove(Grid<int> & knightJourney, int & moveCount, int yDest, int xDest);

int main(){
    GWindow gw;
    Grid<int> knightJourney(BOARD_WIDTH, BOARD_WIDTH, 0);
    int moveCount = 0;
    if (knightMove(gw, knightJourney, moveCount, 7,0)) cout << " posible " << endl;
    else cout << " not posible " << endl;
    /*
    knightJourney.set(0,0, ++moveCount);
    knightJourney.set(5,5, ++moveCount);
    knightJourney.set(5,2, ++moveCount);
    int clockPos = 1;
    for (; clockPos <= 8; ++clockPos) {
        if (knightMove(knightJourney, moveCount, clockPos, 5, 2)) cout << " clockPos: " << clockPos << endl;
        else undoMove(knightJourney, moveCount, 5,2);
    }
    */


    displayknightJourney(gw, knightJourney, 0, 0, PIX_SIZE);
    return 0;
}



bool knightMove(GWindow & gw, Grid<int> & knightJourney, int & moveCount, int yStart, int xStart){
    moveCount++;
    makeMove(knightJourney, moveCount, yStart, xStart);
    //displayknightJourney(gw, knightJourney, yStart, xStart, PIX_SIZE);
    //cout << "*7,7 " << knightJourney.get(7,7) << endl;
    if (moveCount == knightJourney.size()) {
        //cout << "&^&%^%^865486 completed " << moveCount << endl;
        return true;
    }
    else {
        //cout << "__" << moveCount << endl;
        for (int clockPos = 1; clockPos <= 8; ++clockPos) {
            int yDest = yStart;
            int xDest = xStart;
            knightClockWise(clockPos, yDest, xDest);
            if (knightJourney.inBounds(yDest, xDest) && knightJourney[yDest][xDest] < 1) {

                 //cout << "possible. clockPos: " << clockPos << " yDest: " << yDest << " xDest: " << xDest << " moveCount: " << moveCount << "[][]" << knightJourney[yDest][xDest] << endl;
                if (knightMove(gw, knightJourney, moveCount, yDest, xDest)) {
                    //cout << "true" << endl;


                    return true;
                }
                else {
                    /*
                    return false;
                    */
                    //cout << "false. moveCount: "  << moveCount << endl;
                    undoMove(knightJourney, moveCount, yDest, xDest);
                    /*moveCount--;
                    pause(1000);
                    cout << "1000 pause: " << endl;
                    */
                    //displayknightJourney(gw, knightJourney, -1, -1, PIX_SIZE);
                }
            }
        }
        //cout << "Superfalse" << endl;
        undoMove(knightJourney, moveCount, yStart, xStart);
        moveCount--;
        /*
        pause(1000);
        cout << "1000 pause: " << endl;
        */
        //displayknightJourney(gw, knightJourney, yStart, xStart, PIX_SIZE);
        return false;
    }

}

void makeMove(Grid<int> & knightJourney, int & moveCount, int yDest, int xDest) {
    knightJourney.set(yDest, xDest, moveCount);
    //cout << "[][]...." << knightJourney[yDest][xDest] << endl;
}

void undoMove(Grid<int> & knightJourney, int & moveCount, int yDest, int xDest) {
    knightJourney.set(yDest, xDest, 0);
    //cout << "[][] ---" << knightJourney[yDest][xDest] << endl;

}

void knightClockWise(int turn, int & y, int & x) {
    switch (turn) {
        case 1:
            y -= 2;
            x += 1;
            break;
        case 2:
            y -= 1;
            x += 2;
            break;
        case 3:
            y += 1;
            x += 2;
            break;
        case 4:
            y += 2;
            x += 1;
            break;
        case 5:
            y += 2;
            x -= 1;
            break;
        case 6:
            y += 1;
            x -= 2;
            break;
        case 7:
            y -= 1;
            x -= 2;
            break;
        case 8:
            y -= 2;
            x -= 1;
            break;
    }
}



void displayknightJourney(GWindow & gw, Grid<int> knightJourney, int yLast, int xLast, int pixSize) {

    for (int y = 0; y < knightJourney.numRows(); ++y) {
        for (int x = 0; x < knightJourney.numCols(); ++x) {
            if (knightJourney[y][x] > 0) {
                if (xLast == x && yLast == y) gw.setColor("GREEN");
                else gw.setColor("PURPLE");
                gw.fillOval(pixSize * x, pixSize * y, pixSize , pixSize);
                gw.setColor("BLACK");
                int stringHelper = pixSize / 3;
                if (knightJourney[y][x] < 10) stringHelper = pixSize * 0.4;
                gw.drawString(std::to_string(knightJourney[y][x]), pixSize * x + stringHelper, pixSize * y + pixSize * 0.6);
            }
            else {
                gw.setColor("WHITE");
                gw.fillRect(pixSize * x, pixSize * y, pixSize , pixSize);
            }
        }
    }
    pause(T_PAUSE);
    gw.setColor("WHITE");
    gw.fillRect(0 , knightJourney.numRows() * pixSize , knightJourney.numCols() * pixSize * 2, knightJourney.numRows() * pixSize * 2);
    gw.fillRect(knightJourney.numCols() * pixSize, 0 , knightJourney.numCols() * pixSize * 2, knightJourney.numRows() * pixSize * 2);
    gw.setColor("BLACK");
    gw.drawLine(0 , knightJourney.numRows() * pixSize , knightJourney.numCols() * pixSize, knightJourney.numRows() * pixSize);
    gw.drawLine(knightJourney.numCols() * pixSize, 0 , knightJourney.numCols() * pixSize, knightJourney.numRows() * pixSize);

}
