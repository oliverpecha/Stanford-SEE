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

// Strategy
bool solveGame(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start);

// Helpers to Strategy
int sticksleft(Grid<int> & board);

// Direction and moves
bool makeMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint & mid, GPoint & dest);
bool unMakeMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint mid, GPoint dest, int direction);

bool isLegal(Grid<int> board, GPoint mid, GPoint dest);
void travel(int direction, GPoint & mid, GPoint & dest);
void unTravel(int direction, GPoint & mid, GPoint & dest);


// Fill Board accoording to requirements
Grid<int> startBoard();

// Display Board
void displayBoardState(GWindow & gw, Grid<int> board, double circleScale, int pixSize, int t);
void changeSlot(GWindow & gw, Grid<int> board, double circleScale, int pixSize, int t, int x, int y, int action);


const int BOARD_WIDTH = 7;
const int PIX_SIZE = 30;
const int T_PAUSE = 0;



int main(){
    GWindow gw;
    Grid<int> board = startBoard();
    displayBoardState(gw, board, 0.1, PIX_SIZE, T_PAUSE);
    int moveCount = 0;
    GPoint start(1,3); // x,y


    if (solveGame(gw, board, moveCount, start)) cout << "Completed :)" << sticksleft(board) << moveCount;
    else cout << "Can't complete :(" << moveCount;

    //displayBoardState(gw, board, 0.1, PIX_SIZE, T_PAUSE);
    return 0;
}



/*
 * Stretegy
 * ---------------------------------------------------------------------------
 */
bool solveGame(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start) {
    if (sticksleft(board) == 1) return true;
    else {
        for (int y = 0; y < board.numRows(); ++y) {
            for (int x = 0; x < board.numCols(); ++x) {
                if (board[x][y] != -1 && board[x][y] != 0) {
                    start.x = x;
                    start.y = y;
                    GPoint mid;
                    GPoint dest;
                    for (int direction = 0; direction < 4; ++direction) {
                        mid = start;
                        dest = start;
                        travel(direction, mid, dest);
                        if (isLegal(board, mid, dest)) {
                            //cout << "legal:  " << direction << start << mid << dest << endl;
                            makeMove(gw, board, moveCount, start, mid, dest);
                            if (!solveGame(gw, board, moveCount, start)){
                                unMakeMove(gw, board, moveCount, start, mid, dest, direction);
                                //cout << "unmake: " << direction << start << mid << dest << " ----"<<endl;
                                //++direction;
                                //return false;
                            } else return true;

                        }
                    }

                }
            }
        }
        //cout << "unmake" << endl;
        return false;
    }
    cout << "exit" << endl;
    return false;
}


// Helpers to Strategy
int sticksleft(Grid<int> & board) {
    int result = 0;
    for (int y = 0; y < board.numRows(); ++y) {
        for (int x = 0; x < board.numCols(); ++x) {
            if(board[x][y] == 1) result++;
        }
    }
    return result;
}

/*
 * Direction and moves
 * ---------------------------------------------------------------------------
 */
bool makeMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint & mid, GPoint & dest){

    board[start.x][start.y] = 0;
    board[mid.x][mid.y] = 0;
    board[dest.x][dest.y] = 1;
    /*
    changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/6, start.x, start.y, 4);
    changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/6, start.x, start.y, 1);
    changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/6, mid.x, mid.y, 4);
    changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/6, mid.x, mid.y, 1);
    changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/6, dest.x, dest.y, 4);
    changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/6, dest.x, dest.y, 0);

    board[start.x][start.y] = 0;
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE, start.x, start.y, 2);
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/2, start.x, start.y, 0);
    board[mid.x][mid.y] = 0;
        //changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/4, mid.x, mid.y, 2);
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE, mid.x, mid.y, 0);
    board[dest.x][dest.y] = 1;
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/4, dest.x, dest.y, 2);
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/2, dest.x, dest.y, 1);
    moveCount++;
    pause(T_PAUSE);
    */

    return true;
}

bool unMakeMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint mid, GPoint dest, int direction){
    board[start.x][start.y] = 1;
    board[mid.x][mid.y] = 1;
    board[dest.x][dest.y] = 0;
    /*
    board[start.x][start.y] = 1;
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE, start.x, start.y, 3);
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/2, start.x, start.y, 1);
    board[mid.x][mid.y] = 1;
        //changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/4, mid.x, mid.y, 3);
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE, mid.x, mid.y, 1);
    board[dest.x][dest.y] = 0;
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/4, dest.x, dest.y, 3);
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/2, dest.x, dest.y, 0);
    */
    moveCount--;
    return true;
}

bool isLegal(Grid<int> board, GPoint mid, GPoint dest){

    if (!board.inBounds(mid.x, mid.y) || !board.inBounds(dest.x, dest.y)) return false;
    if (board[mid.x][mid.y] == 1 && board[dest.x][dest.y] == 0){
        return true;
    }
    else return false;
}

void unTravel(int direction, GPoint & mid, GPoint & dest){
    switch (direction) {
        case 0:
            travel(2, mid, dest);
            break;
        case 1:
            travel(3, mid, dest);
            break;
        case 2:
            travel(0, mid, dest);
            break;
        case 3:
            travel(1, mid, dest);
            break;
        default:
            cerr << "direction error";
            break;
        }
}

void travel(int direction, GPoint & mid, GPoint & dest){
    switch (direction) {
        case 0:
            mid.y -= 1;
            dest.y -= 2;
            break;
        case 1:
            mid.x += 1;
            dest.x += 2;
            break;
        case 2:
            mid.y += 1;
            dest.y += 2;
            break;
        case 3:
            mid.x -= 1;
            dest.x -= 2;
            break;
        default:
            cerr << "direction error";
            break;
        }
}

/*
 * Fill Board accoording to requirements
 * ---------------------------------------------------------------------------
 */
Grid<int> startBoard(){
    Grid<int> result(BOARD_WIDTH, BOARD_WIDTH, -1);
    for (int y = 2; y < 5; ++y) {
        for (int x = 0; x < BOARD_WIDTH; ++x) {
            result[x][y] = 1;
        }
    }
    for (int y = 0; y < BOARD_WIDTH; ++y) {
        for (int x = 2; x < 5; ++x) {
            result[x][y] = 1;
        }
    }
    result[3][3] = 0;
    return result;
}

/*
 * Display Board
 * ---------------------------------------------------------------------------
 */
void displayBoardState(GWindow & gw, Grid<int> board, double circleScale, int pixSize, int t) {
    for (int y = 0; y < board.numRows(); ++y) {
        for (int x = 0; x < board.numCols(); ++x) {
            if (board[x][y] == 1) {
                gw.setColor("WHITE");
                gw.fillRect(pixSize * x + pixSize * circleScale - 1, pixSize * y + pixSize * circleScale - 1, pixSize - pixSize * circleScale  +2, pixSize - pixSize * circleScale +2);

                gw.setColor("BLACK");
                gw.fillOval(pixSize * x + pixSize * circleScale, pixSize * y + pixSize * circleScale, pixSize - pixSize * circleScale , pixSize - pixSize * circleScale );
            }
            else if (board[x][y] == 0){
                gw.setColor("WHITE");
                gw.fillRect(pixSize * x + pixSize * circleScale - 1, pixSize * y + pixSize * circleScale - 1, pixSize - pixSize * circleScale  +2, pixSize - pixSize * circleScale +2);

                gw.setColor("GRAY");
                gw.fillOval(pixSize * x + pixSize * circleScale, pixSize * y + pixSize * circleScale, pixSize - pixSize * circleScale , pixSize - pixSize * circleScale );
            }
        }
    }
    pause(t);
    /*gw.setColor("WHITE");
    gw.fillRect(0 , board.numRows() * pixSize , board.numCols() * pixSize * 2, board.numRows() * pixSize * 2);
    gw.fillRect(board.numCols() * pixSize, 0 , board.numCols() * pixSize * 2, board.numRows() * pixSize * 2);
    gw.setColor("BLACK");
    gw.drawLine(0 , board.numRows() * pixSize , board.numCols() * pixSize, board.numRows() * pixSize);
    gw.drawLine(board.numCols() * pixSize, 0 , board.numCols() * pixSize, board.numRows() * pixSize);*/

}


void changeSlot(GWindow & gw, Grid<int> board, double circleScale, int pixSize, int t, int x, int y, int action) {
    if (action == 1) {
        gw.setColor("WHITE");
        gw.fillRect(pixSize * x + pixSize * circleScale - 1, pixSize * y + pixSize * circleScale - 1, pixSize - pixSize * circleScale  +2, pixSize - pixSize * circleScale +2);
        gw.setColor("BLACK");
        gw.fillOval(pixSize * x + pixSize * circleScale, pixSize * y + pixSize * circleScale, pixSize - pixSize * circleScale , pixSize - pixSize * circleScale );
    } else if (action == 0) {
        gw.setColor("WHITE");
        gw.fillRect(pixSize * x + pixSize * circleScale - 1, pixSize * y + pixSize * circleScale - 1, pixSize - pixSize * circleScale  +2, pixSize - pixSize * circleScale +2);
        gw.setColor("GRAY");
        gw.fillOval(pixSize * x + pixSize * circleScale, pixSize * y + pixSize * circleScale, pixSize - pixSize * circleScale , pixSize - pixSize * circleScale );
    } else if (action == 2) {
        gw.setColor("WHITE");
        gw.fillRect(pixSize * x + pixSize * circleScale - 1, pixSize * y + pixSize * circleScale - 1, pixSize - pixSize * circleScale  +2, pixSize - pixSize * circleScale +2);
        gw.setColor("GREEN");
        gw.fillOval(pixSize * x + pixSize * circleScale, pixSize * y + pixSize * circleScale, pixSize - pixSize * circleScale , pixSize - pixSize * circleScale );
    } else if (action == 3) {
        gw.setColor("WHITE");
        gw.fillRect(pixSize * x + pixSize * circleScale - 1, pixSize * y + pixSize * circleScale - 1, pixSize - pixSize * circleScale  +2, pixSize - pixSize * circleScale +2);
        gw.setColor("PURPLE");
        gw.fillOval(pixSize * x + pixSize * circleScale, pixSize * y + pixSize * circleScale, pixSize - pixSize * circleScale , pixSize - pixSize * circleScale );
    } else if (action == 4) {
        gw.setColor("WHITE");
        gw.fillRect(pixSize * x + pixSize * circleScale - 1, pixSize * y + pixSize * circleScale - 1, pixSize - pixSize * circleScale  +2, pixSize - pixSize * circleScale +2);
        gw.setColor("YELLOW");
        gw.fillOval(pixSize * x + pixSize * circleScale, pixSize * y + pixSize * circleScale, pixSize - pixSize * circleScale , pixSize - pixSize * circleScale );
    }
    pause(t);
}


/* test unmake
    GPoint mid = start;
    GPoint dest = start;
    int direction = 1;
    travel(direction, mid, dest);
    cout << "can?:  " << direction << start << mid << dest << board[dest.x][dest.y] << endl;
    if (isLegal(board, mid, dest)) {
        cout << "legal:  " << direction << start << mid << dest << endl;
        makeMove(gw, board, moveCount, start, mid, dest);
        unMakeMove(gw, board, moveCount, start, mid, dest, direction);
        cout << "unmake: " << direction << start << mid << dest << " ----"<<endl;
    }
*/
