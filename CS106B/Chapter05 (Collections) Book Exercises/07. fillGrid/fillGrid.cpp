/*
 * File: fillGrid.cpp
 * --------------
 * One of the problems in using the Grid class is that it isn’t as easy to set up a particular set of
 * initial values as it is with a vector, where you can add the elements you want with the += operator.
 * One way to streamline the process of initializing a grid is to define a function
 *
 * void fillGrid(Grid<int> & grid, Vector<int> & values);
 *
 * that fills the elements of the grid from the values in the vector. For example, the code
 *            Grid<int> matrix(3, 3);
 *            Vector<int> values;
 *            values += 1, 2, 3;
 *            values += 4, 5, 6;
 *            values += 7, 8, 9;
 *            fillGrid(matrix, values);
 *
 * initializes the variable matrix to be a 3 ! 3 grid containing the values
 */

#include "console.h"
#include "simpio.h"
#include "grid.h"
using namespace std;

void fillGrid(Grid<int> & grid, Vector<int> & values);

int main() {
    Grid<int> matrix(3, 3);
    Vector<int> values;
    values += 1, 2, 3;
    values += 4, 5, 6;
    values += 7, 8, 9;
    fillGrid(matrix, values);
    cout << matrix.get(0,1) << endl;
    cout << matrix.get(1,0) << endl;
    return 0;
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

