/*
 * File: fillGrid.cpp
 * --------------
 * A magic square is a two-dimensional grid of integers in which the rows, columns,
 * and diagonals all add up to the same value. One of the most famous magic squares appears
 * in the 1514 engraving “Melencolia I” by Albrecht Dürer shown in Figure5-12, in which a 4!4
 * magic square appears in the upper right, just under the bell. In Dürer’s square, which
 * can be read more easily in the magnified inset shown at the right of the figure, all four rows,
 * all four columns, and both diagonals add up to 34. A more familiar example is the following 3!3
 * magic square in which each of the rows, columns, and diagonals add up to 15, as shown:
 * Implement a function
 *       bool isMagicSquare(Grid<int> & square);
 */

#include "console.h"
#include "simpio.h"
#include "grid.h"
using namespace std;

void fillGrid(Grid<int> & grid, Vector<int> & values);
bool isMagicSquare(Grid<int> & square);
bool checkX(Grid<int> square);
bool checkY(Grid<int> square);
bool checkD(Grid<int> square);


int main() {
    Grid<int> matrix(4, 4);
    Vector<int> values;
    /*
    values += 8, 1, 6;
    values += 3, 5, 7;
    values += 4, 4, 2;
    */
    values += 16, 3, 2, 13;
    values += 5, 10, 11, 8;
    values += 9, 6, 7, 12;
    values += 4, 15, 14, 1;
    fillGrid(matrix, values);
    cout << matrix.get(0,1) << endl;
    cout << matrix.get(1,0) << endl;
    if (isMagicSquare(matrix)) cout << "Hardcoded matrix is a Magic Square!" << endl;
    else cout << "Hardcoded matrix is NOT a Magic Square!" << endl;
    return 0;
}

bool isMagicSquare(Grid<int> & square){
    if (square.numCols() != square.numRows()) return false;
    if (checkX(square) && checkY(square) && checkD(square)) return true;
    else return false;
}

bool checkX(Grid<int> square){
    int result = 0;
    int score = -1;
    for (int a = 0; a < square.numCols(); a++){
        for (int b = 0; b < square.numRows(); b++){
            result += square.get(a,b);
        }
        if (score < 0) score = result;
        else if (result != score) return false;
        result = 0;
    }
    return true;
}

bool checkY(Grid<int> square){
    int result = 0;
    int score = -1;
    for (int a = 0; a < square.numRows(); a++){
        for (int b = 0; b < square.numCols(); b++){
            result += square.get(b,a);
        }
        if (score < 0) score = result;
        else if (result != score) return false;
        result = 0;
    }
    return true;
}

bool checkD(Grid<int> square) {
    int result = 0;
    int score = -1;
    int roller = 0;
    //00, 11, 22
    for (int a = 0; a < square.numCols(); a++){
        result += square.get(a,roller);
        roller++;
    }
    score = result;
    result = 0;
    roller = square.numCols() -1;
    //02,11,20
    for (int a = 0; a < square.numCols(); a++){
        result += square.get(a,roller);
        roller--;
    }
    if (result != score) return false;
    return true;

}

void fillGrid(Grid<int> & grid, Vector<int> & values){
    int x = grid.numCols();
    int y = grid.numRows();
    int counter = 0;
    for (int a = 0; a < x; a++){
        for (int b = 0; b < y; b++){
            grid.set(a,b,values[counter]);
            counter++;
        }
    }
}

