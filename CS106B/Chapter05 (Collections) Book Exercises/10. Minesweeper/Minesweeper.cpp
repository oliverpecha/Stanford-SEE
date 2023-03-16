/*
 * File: Minesweeper.cpp
 * --------------
 * In the game of Minesweeper, a player searches for hidden mines on a rectangular grid that
 * might—for a very small board—look like this:
 *
 *  image
 *
 *  One way to represent that grid in C++ is to use a grid of Boolean values marking mine locations,
 *  where true indicates the location of a mine. In Boolean form, this sample grid therefore looks like this:
 *
 *  Given such a grid of mine locations, write a function
 *
 *          void fixCounts(Grid<bool> & mines, Grid<int> & counts);
 *
 * that creates a grid of integers storing the number of mines in each neighborhood. The neighborhood of a location includes the location itself and the eight adjacent locations, but only if they are inside the boundaries of the grid. The reference parameter counts is used to store the result. Your job in this exercise is to make sure that it has the same size as the mines grid and then to assign to each element an integer between 0 and 9. For example, if mineLocations contains the Boolean grid shown earlier, the code
 *          Grid<int> mineCounts;
 *          fixCounts(mineLocations, mineCounts);
 *
 * should initialize mineCounts as follows:
 *          image
 */

#include "console.h"
#include "simpio.h"
#include "grid.h"
using namespace std;

void fillGrid(Grid<int> & grid, Vector<int> & values);
void fillValues(Vector<int> & values);
void printGrid(Grid<int> & grid);
void fixCounts(Grid<int> & mineLocations, Grid<int> & mineCounts);
int perimeter(int x,int y, Grid<int> & mineLocations);



int main() {
    Grid<int> mineLocations(6, 6);
    Vector<int> values;
    fillValues(values);
    fillGrid(mineLocations, values);
    printGrid(mineLocations);
    Grid<int> mineCounts(6, 6);
    fixCounts(mineLocations, mineCounts);
    cout << "\n\n";
    printGrid(mineCounts);

    return 0;
}


void fixCounts(Grid<int> & mineLocations, Grid<int> & mineCounts) {
    for (int cols = 0; cols < mineLocations.numCols(); cols++){
        for (int rows = 0; rows < mineLocations.numRows(); rows++){
            int score = perimeter(rows,cols, mineLocations);
            mineCounts.set(rows,cols, score);

        }
    }
}

int perimeter(int rowTarget,int colTarget, Grid<int> & mineLocations) {
    int count = 0;
    for (int col = colTarget - 1; col <= colTarget + 1; col++){
        for (int row = rowTarget - 1; row <= rowTarget + 1; row++){
            if (row >= 0 && row <= mineLocations.numRows() -1  &&
                col >= 0 && col <= mineLocations.numCols() -1) {
                count += mineLocations.get(row,col);
            }
        }
    }
    return count;
}



void fillGrid(Grid<int> & grid, Vector<int> & values){
    int counter = 0;
    for (int x = 0; x < grid.numCols(); x++){
        for (int y = 0; y < grid.numRows(); y++){
            grid.set(x,y,values[counter]);
            counter++;
        }
    }
}

void fillValues(Vector<int> & values) {
    values += 1, 0, 0, 0, 0, 1;
    values += 0, 0, 0, 0, 0, 1;
    values += 1, 1, 0, 1, 0, 1;

    values += 1, 0, 0, 0, 0, 0;
    values += 0, 0, 1, 0, 0, 0;
    values += 0, 0, 0, 0, 0, 0;
}

void printGrid(Grid<int> & grid) {
    for (int x = 0; x < grid.numCols(); x++){
        for (int y = 0; y < grid.numRows(); y++){

            cout << grid.get(x,y) << " | ";
        }
        cout << "\n\n";
    }
}
