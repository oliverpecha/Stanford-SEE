/*
 * File: main.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

//#include "console.h"
#include "simpio.h"
#include "grid.h"
#include "gwindow.h"
#include "direction.h"
#include <fstream>

using namespace std;

const string FILE_NAME = "House01.txt";
const int GRID_WIDTH = 19;
const int PIX_SIZE = 10;
const int T_PAUSE = 900;



void line2Grid(string line, int row, Grid<bool> & allGrid);
void token2Grid(Vector <string> token, int row, Grid<bool> & allGrid);
Grid<bool> file2Grid(string fileName, int gridWidth);
Vector<char> reverseToken(Vector<char> tokenReverser);
void displayGrid(GWindow & display, Grid<bool> allGrid, int pixSize);
void fillRegion(Grid<bool> & pixels, int row, int col);

int main() {
    GWindow gw;
    Grid<bool> pixels = file2Grid(FILE_NAME, GRID_WIDTH);
    displayGrid(gw, pixels, PIX_SIZE);
    fillRegion(pixels, pixels.numRows()/2, pixels.numCols()/2);
    pause(T_PAUSE);
    displayGrid(gw, pixels, PIX_SIZE);
    return 0;
}



void fillRegion(Grid<bool> & pixels, int row, int col){
    //if point is true, stop
    if (pixels.inBounds(row, col)) {
        if (pixels[row][col] != true) {
            pixels[row][col] = true;
            fillRegion(pixels, row + 1, col);
            fillRegion(pixels, row - 1, col);
            fillRegion(pixels, row, col + 1);
            fillRegion(pixels, row, col - 1);
        }
    }

    //else (its false/white) turn black and keep painting
}



void displayGrid(GWindow & gw, Grid<bool> allGrid, int pixSize){
    for (int y = 0; y < allGrid.numRows(); ++y) {
        for (int x = 0; x < allGrid.numCols(); ++x) {


            if (allGrid[y][x] == true) gw.setColor("BLACK");
            else gw.setColor("WHITE");
            //if (y == 20)gw.setColor("GREEN");
            //if (allGrid[20][18] == true) gw.setColor("GREEN");
             gw.fillRect(pixSize * x, pixSize * y, pixSize * x + pixSize, pixSize * y + pixSize);
        }
    }

}

Grid<bool> file2Grid(string fileName, int gridWidth) {
    ifstream infile;
    infile.open(fileName);
    if (infile.fail()) error("Can't open " + fileName);
    string line;
    int row = 0;
    Grid<bool> allGrid(24, 20);
    while (getline(infile, line)) {
        line2Grid(line, row, allGrid);
        row++;

    }
    infile.close();
    return allGrid;
}


void line2Grid(string line, int row, Grid<bool> & allGrid){
    int cutStart = 0;
    int cutEnd = 0;
    Vector <string> token;
    for (int var = 0; var < 2; ++var) {
        cutStart = line.find('"', cutEnd + 1); //<------ test remove
        cutEnd = line.find('"', cutStart + 1);
        token.add(line.substr(cutStart + 1, cutEnd - cutStart - 1));
    }
    token2Grid(token, row, allGrid);
}

void token2Grid(Vector <string> token, int row, Grid<bool> & allGrid) {

    Vector<char> tokenReverser;
    for (int var = 0; var < 3; ++var) {
        if (var == 0) {
            for (int i = 0; i < token.get(var).size(); ++i) {
                if (token.get(var)[i] == 'O') allGrid.set(row, i, false);
                else if (token.get(var)[i] == '*') allGrid.set(row, i, true);
                tokenReverser.add(token.get(var)[i]);
            }
        }
        else if (var == 1) {

                if (token.get(1)[0] == 'O') allGrid.set(row, 9, false);
                else if (token.get(1)[0] == '*') allGrid.set(row, 9, true);
        }
        else if (var == 2) {
            tokenReverser = reverseToken(tokenReverser);
            for (int i = 0; i < tokenReverser.size(); ++i) {
                if (tokenReverser[i] == 'O') allGrid.set(row, 10 + i, false);
                else if (tokenReverser[i] == '*') allGrid.set(row, 10 + i, true);
            }
        }
    }
}


Vector<char> reverseToken(Vector<char> tokenReverser) {
    Vector<char> result;
    for (int var = tokenReverser.size() - 1; var >= 0; --var) {
        result.add(tokenReverser[var]);
    }
    return result;
}
