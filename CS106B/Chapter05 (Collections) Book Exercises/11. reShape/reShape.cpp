/*
 * File: reShape.cpp
 * --------------
 * The resize method in the Grid class resets the dimensions of the grid but also
 * initializes every element of the grid to its default value. Write a function
 *
 *          void reshape(Grid<int> & grid, int nRows, int nCols);
 *
 * that resizes the grid but fills in the data from the original grid by copying
 * elements in the standard row-major order (left-to-right/top-to-bottom).
 * For example, if myGrid initially contains the values
 *
 *      image
 *
 * calling the function
 *
 *          reshape(myGrid, 4, 3)
 *
 * should change the dimensions and contents of myGrid as follows:
 *
 *          image
 *
 * If the new grid does not include enough space for all of the original values, the values at the
 * bottom of the grid are simply dropped. For example, if you call
 *
 *        reshape(myGrid, 2, 5)
 *
 * there is no room for the last two elements, so the new grid will look like this:
 *
 *      image
 *
 * Conversely, if there are not enough elements in the original grid to fill the available space,
 * the entries at the end should simply retain their default values.
 */

#include "console.h"
#include "simpio.h"
#include "grid.h"
#include <iomanip>

using namespace std;

void fillValuesIncrease(Vector<int> & values, int size);
void fillGrid(Grid<int> & grid, Vector<int> & values);
void printGrid(Grid<int> & grid);
void reshape(Grid<int> & grid, int nRows, int nCols);


int DEFAULT_FILL = 0;

int main() {
    //3 cols 4 rows
    Grid<int> myGrid(3, 4);
    Vector<int> values;
    fillValuesIncrease(values, myGrid.size());
    fillGrid(myGrid, values);
    printGrid(myGrid);
    reshape(myGrid, 4, 3);
    printGrid(myGrid);
    reshape(myGrid, 2, 5);
    printGrid(myGrid);
    reshape(myGrid, 7, 3);
    printGrid(myGrid);
    return 0;
}


Vector<int> saveGrid(Grid<int> & grid) {
    Vector<int> contents;
    for (int col = 0; col < grid.numCols(); ++col) {
        for (int row = 0; row < grid.numRows(); ++row) {
        contents.add(grid.get(row, col));
        }
    }
    return contents;
}

void reshape(Grid<int> & grid, int nRows, int nCols){
    Vector<int> contents = saveGrid(grid);
    grid.resize(nRows, nCols);
    fillGrid(grid, contents);
}

void fillGrid(Grid<int> & grid, Vector<int> & values){
    int counter = 0;
    for (int col = 0; col < grid.numCols(); col++){
        for (int row = 0; row < grid.numRows(); row++){
            if (counter < values.size()) {
                grid.set(row, col,values[counter]);
                counter++;
            }
            else grid.set(row, col, DEFAULT_FILL);
        }
    }
}

void fillValuesIncrease(Vector<int> & values, int size) {
    for (int i = 1; i <= size; i++) {
        values.add(i);
    }
}

void printGrid(Grid<int> & grid) {
    for (int col = 0; col < grid.numCols(); col++){
        cout << "| ";
        for (int row = 0; row < grid.numRows(); row++){
            cout << setw(2) << grid.get(row,col) << " | ";
        }
        cout << "\n\n" << endl;
    }
    cout << "\n\n" << endl;

}
