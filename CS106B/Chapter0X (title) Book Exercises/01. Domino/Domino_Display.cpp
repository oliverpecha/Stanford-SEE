/*
 * File: Domino_Display.cpp
 * --------------
 * The game of dominos is played using pieces that are usually black rectangles with
 * some number of white dots on each side. For example, the domino
 * is called the 4-1 domino, with four dots on its left side and one on its right.
 *
 * Define a simple Domino class that represents a traditional domino. Your class should
 * export the following entries:
 *  • A default constructor that creates the 0-0 domino
 *  • A constructor that takes the number of dots on each side
 *  • A toString method that creates a string representation of the domino
 *  • Two getter methods named getLeftDots and getRightDots
 *
 * Write the domino.h interface and the domino.cpp implementation that export this class.
 * As with the examples in the text, all instance variables should be private to the class,
 * and the interface should overload the << operator so that it is possible to
 * print a string representation of a domino.
 *
 * Test your implementation of the Domino class by writing a program that creates a full
 * set of dominos from 0-0 up to 6-6 and then displays those dominos on the console.
 * A full set of dominos contains one copy of each possible domino in that range,
 * disallowing duplicates that result from flipping a domino over. A domino set, therefore,
 * has a 4-1 domino but not a separate 1-4 domino.
 */

#include "console.h"
#include "simpio.h"
#include "domino.h"
#include "vector.h"
using namespace std;

bool hasPiece(Vector<Domino> board, Domino p1);
void fillBoard(Vector<Domino> & board);
void printBoard(Vector<Domino> board);

int main() {
    Vector<Domino> board;
    fillBoard(board);
    printBoard(board);
    return 0;
}

bool hasPiece(Vector<Domino> board, Domino p2) {
    int tester = 0;
    while (p2 != board[tester]) {
        tester++;
        if (tester == board.size()) {
            return false;
        }
    }
    return true;
}

void fillBoard(Vector<Domino> & board){
    for (int y = 0; y <= 6; ++y) {
        for (int x = 0; x <= 6; ++x) {
            Domino test(x,y);
            if (board.size() > 0 && !hasPiece(board, test)){
                board.add(test);
            } else if (board.size() == 0) board.add(test);
        }
    }
}

void printBoard(Vector<Domino> board){
    cout << "Domino board of size: " << board.size() << endl;
    for (int var = 0; var < board.size(); ++var) {
        cout << board[var] << endl;
    }
}
