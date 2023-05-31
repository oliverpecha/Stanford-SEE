/*
 * File: NQueens.cpp
 * --------------
 * The most powerful piece in the game of chess is the queen, which can move any number
 * of squares in any direction, horizontally, vertically, or diagonally. For example,
 * the queen shown in this chessboard can move to any of the marked squares:
 *
 * Even though the queen can cover a large number of squares, it is possible to place
 * eight queens on an 8!8 chessboard so that none of them attacks any of the others,
 * as shown in the following diagram:
 *
 * Write a program that solves the more general problem of whether it is possible to
 * place N queens on an N!N chessboard so that none of them can move to a square occupied
 * by any of the others in a single turn. Your program should either display a solution
 * if it finds one or report that no solutions exist.

 */

//#include "console.h"
#include "simpio.h"
#include "grid.h"
#include "gwindow.h"

using namespace std;

const int NQUEENS = 9;
const int PIX_SIZE = 30;
const int T_PAUSE = 300;



void placeQueen(Grid<bool> & chessboard, Grid<bool> & queenPos, int row, int column);
void removeQueen(Grid<bool> & chessboard, Grid<bool> & queenPos, int row, int column);
void blockRails(Grid<bool> & chessboard, int row, int column);
void resetHelpers(int & x, int & y, int row, int column);
void resetRails(Grid<bool> & chessboard, Grid<bool> & queenPos);
void displayChessboard(GWindow & display, Grid<bool> chessboard, Grid<bool> queenPos, int pixSize);
bool fillChessboard(GWindow & display, Grid<bool> & chessboard, Grid<bool> & queenPos, int column);

int main() {
    GWindow gw;
    Grid<bool> chessboard(NQUEENS, NQUEENS);
    Grid<bool> queenPos(NQUEENS, NQUEENS, false);
    displayChessboard(gw, chessboard, queenPos, PIX_SIZE);
    if (fillChessboard(gw, chessboard, queenPos, chessboard.numCols() - 1)) {
        cout << "POSSIBLE" << endl;
    }
    else cout << "NOT POSSIBLE!!!" << endl;
    displayChessboard(gw, chessboard, queenPos, PIX_SIZE);
    return 0;
}


bool fillChessboard(GWindow & gw, Grid<bool> & chessboard, Grid<bool> & queenPos, int column) {
    if (column == 0) {
        for (int var = 0; var < chessboard.numRows(); ++var) {
            if (chessboard[column][var] == false) {
                placeQueen(chessboard, queenPos, column, var);
                displayChessboard(gw, chessboard, queenPos, PIX_SIZE);
                pause(T_PAUSE);
                return true;
            }
        }
        return false;
    }
    else {
        for (int var = 0; var < chessboard.numRows(); ++var) {
            if (chessboard[column][var] == false) {
                placeQueen(chessboard, queenPos, column, var);
                displayChessboard(gw, chessboard, queenPos, PIX_SIZE);
                pause(T_PAUSE);
                if (fillChessboard(gw, chessboard, queenPos, column - 1)) return true;
                else {
                    removeQueen(chessboard, queenPos, column, var);
                    displayChessboard(gw, chessboard, queenPos, PIX_SIZE);
                }
            }
        }
    }
    return false;
}



void resetHelpers(int & x, int & y, int row, int column){
    x = column;
    y = row;
}


void placeQueen(Grid<bool> & chessboard, Grid<bool> & queenPos, int row, int column) {
    queenPos.set(row, column, true);
    blockRails(chessboard, row, column);
}

void removeQueen(Grid<bool> & chessboard, Grid<bool> & queenPos, int row, int column) {
    queenPos.set(row, column, false);
    resetRails(chessboard, queenPos);
}

void resetRails(Grid<bool> & chessboard, Grid<bool> & queenPos) {
    chessboard.fill(false);
    for (int y = 0; y < queenPos.numCols(); ++y) {
        for (int x = 0; x < queenPos.numRows(); ++x) {
            if (queenPos[y][x] == true) {
                blockRails(chessboard, y, x);
            }
        }
    }
}

void blockRails(Grid<bool> & chessboard, int row, int column){
    int x = 0;
    int y = 0;
    // block column
    for (int var = 0; var < chessboard.numRows(); ++var) {
        chessboard.set(var, column, true);
    }
    // block row
    for (int var = 0; var < chessboard.numCols(); ++var) {
        chessboard.set(row, var, true);
    }
    // block SE
    resetHelpers(x, y, row, column);
    while (x < chessboard.numRows() && y < chessboard.numCols()) {
        chessboard.set(y++, x++, true);
    }
    // block SW
    resetHelpers(x, y, row, column);
    while (x > -1 && y < chessboard.numCols()) {
        chessboard.set(y++, x--, true);
    }
    // block NW
    resetHelpers(x, y, row, column);
    while (x > -1 && y > -1) {
        chessboard.set(y--, x--, true);
    }
    // block NE
    resetHelpers(x, y, row, column);
    while (x < chessboard.numRows() && y > -1) {
        chessboard.set(y--, x++, true);
    }
}


void displayChessboard(GWindow & gw, Grid<bool> chessboard, Grid<bool> queenPos, int pixSize){
    for (int y = 0; y < chessboard.numRows(); ++y) {
        for (int x = 0; x < chessboard.numCols(); ++x) {
            if (chessboard[y][x] == true) gw.setColor("BLACK");
            else gw.setColor("GREEN");
             gw.fillRect(pixSize * x, pixSize * y, pixSize * x + pixSize, pixSize * y + pixSize);
        }
    }


    for (int y = 0; y < queenPos.numRows(); ++y) {
        for (int x = 0; x < queenPos.numCols(); ++x) {
            if (queenPos[y][x] == true) {
                gw.setColor("PURPLE");
                gw.fillOval(pixSize * x, pixSize * y, pixSize , pixSize);
            }
        }
    }
    gw.setColor("WHITE");
    gw.fillRect(0 , chessboard.numRows() * pixSize , chessboard.numCols() * pixSize * 2, chessboard.numRows() * pixSize * 2);
    gw.fillRect(chessboard.numCols() * pixSize, 0 , chessboard.numCols() * pixSize * 2, chessboard.numRows() * pixSize * 2);
    gw.setColor("BLACK");
    gw.drawLine(0 , chessboard.numRows() * pixSize , chessboard.numCols() * pixSize, chessboard.numRows() * pixSize);
    gw.drawLine(chessboard.numCols() * pixSize, 0 , chessboard.numCols() * pixSize, chessboard.numRows() * pixSize);

}
