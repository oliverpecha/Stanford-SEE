/*
 * File: Sudoku.cpp
 * --------------
 * In the last several years, a new logic puzzle called Sudoku has become quite popular
 * throughout the world. In Sudoku, you start with a 9!9 grid of integers in which some
 * of the cells have been filled in with digits between 1 and 9. Your job in the puzzle
 * is to fill in each of the empty spaces with a digit between 1 and 9 so that each digit
 * appears exactly once in each row, each column, and each of the smaller 3 ! 3 squares.
 * Each Sudoku puzzle is carefully constructed so that there is only one solution.
 * For example, Figure 5-13 shows a typical Sudoku puzzle on the left and its unique
 * solution on the right.
 *
 *  image
 *
 * Although you won’t discover the algorithmic strategies you need to solve Sudoku
 * puzzles until later in this book, you can easily write a method that checks to
 * see whether a proposed solution follows the Sudoku rules against duplicating values
 * in a row, column, or outlined 3!3 square. Write a function
 *
 *            bool checkSudokuSolution(Grid<int> & puzzle);
 *
 * that performs this check and returns true if the puzzle is a valid solution.
 * Your program should check to make sure thatpuzzlecontains a 9!9 grid of integers
 * and report an error if this is not the case.
 */

#include "console.h"
#include "simpio.h"
#include "grid.h"
using namespace std;

void fillGrid(Grid<int> & grid, Vector<int> & values);
bool checkSudokuSolution(Grid<int> & puzzle);
void fillValues(Vector<int> & values);

bool checkX(Grid<int> square);
bool checkY(Grid<int> square);
bool checkSquares(Grid<int> & square);
bool checkSquare(Grid<int> & square, int xStart, int yStart);



int main() {
    Grid<int> matrix(9, 9);
    Vector<int> values;
    fillValues(values);
    fillGrid(matrix, values);
    if (checkSudokuSolution(matrix)) cout << "Hardcoded Sudoku is Correct!" << endl;
    else cout << "Hardcoded Sudoku is NOT Correct!" << endl;
    return 0;
}

bool checkSudokuSolution(Grid<int> & square){
    if (square.numCols() != square.numRows()) return false;
    if (checkX(square) && checkY(square) && checkSquares(square)) return true;
    else return false;
}

bool checkSquares(Grid<int> & square){
    for (int a = 0; a < 9; a += 3){
        for (int b = 0; b < 9; b += 3){
            if (!checkSquare(square, a, b)) return false;
        }
    }
    return true;
}


bool checkSquare(Grid<int> & square, int xStart, int yStart) {
    Vector<int> numArray(10);
    for (int x = xStart; x < xStart + 3; x++){
        for (int y = yStart; y < yStart + 3; y++){
            int candidate = square.get(x, y);
            if (numArray.get(candidate) == 0) numArray[candidate] = candidate;
            else return false;
        }
    }
    return true;

}
bool checkX(Grid<int> square){
    for (int x = 0; x < square.numCols(); x++){
        Vector<int> numArray(10);
        for (int y = 0; y < square.numRows(); y++){
            int candidate = square.get(y, x);
            if (numArray.get(candidate) == 0) numArray[candidate] = candidate;
            else return false;
        }
    }
    return true;
}

bool checkY(Grid<int> square){
    for (int x = 0; x < square.numRows(); x++){
        Vector<int> numArray(10);
        for (int y = 0; y < square.numCols(); y++){
            int candidate = square.get(x, y);
            if (numArray.get(candidate) == 0) numArray[candidate] = candidate;
            else return false;
        }
    }
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

void fillValues(Vector<int> & values) {
    values += 3, 9, 2, 4, 6, 5, 8, 1, 7;
    values += 7, 4, 1, 8, 9, 3, 6, 2, 5;
    values += 6, 8, 5, 2, 7, 1, 4, 3, 9;

    values += 2, 5, 4, 1, 3, 8, 7, 9, 6;
    values += 8, 3, 9, 6, 2, 7, 1, 5, 4;
    values += 1, 7, 6, 9, 5, 4, 2, 8, 3;

    values += 9, 6, 7, 5, 8, 2, 3, 4, 1;
    values += 4, 2, 3, 7, 1, 9, 5, 6, 8;
    values += 5, 1, 8, 3, 4, 6, 9, 7, 2;
}
