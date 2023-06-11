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
#include "set.h"
#include "gwindow.h"
using namespace std;

// Strategy
bool solveGame(GWindow & gw, Grid<int> & board, Set<Grid<int>> & boardRecord, int & moveCount, GPoint start);

// Helpers to Strategy
bool solvedBoard(Grid<int> board);
bool isNewBoard(Set<Grid<int>> & boardRecord, Grid<int> board);

// Direction and moves
bool isLegal(Grid<int> board, GPoint mid, GPoint dest);
void travel(int direction, GPoint & mid, GPoint & dest);
bool makeMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint & mid, GPoint & dest);
bool unMakeMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint mid, GPoint dest, int direction);
bool unInvisibleMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint mid, GPoint dest, int direction);
bool invisibleMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint & mid, GPoint & dest);


// Fill Board accoording to requirements
Grid<int> startBoard();
Grid<int> invertBoard(Grid<int> board);

// Display Board
void displayBoardState(GWindow & gw, Grid<int> board, double circleScale, int pixSize, int t);
void changeSlot(GWindow & gw, Grid<int> board, double circleScale, int pixSize, int t, int x, int y, int action);


const int BOARD_WIDTH = 7;
const int PIX_SIZE = 30;
const int T_PAUSE = 5;



int main(){
    GWindow gw;
    Grid<int> board = startBoard();
    displayBoardState(gw, board, 0.1, PIX_SIZE, T_PAUSE);
    int moveCount = 0;
    GPoint start(1,3); // x,y
    Set<Grid<int>> boardRecord;
    if (solveGame(gw, board, boardRecord, moveCount, start)) cout << "Completed :)" ;
    else cout << "Can't complete :(" << moveCount;

    displayBoardState(gw, board, 0.1, PIX_SIZE, T_PAUSE);
    return 0;
}



/*
 * Stretegy
 * ---------------------------------------------------------------------------
 */


bool solveGame(GWindow & gw, Grid<int> & board, Set<Grid<int>> & boardRecord, int & moveCount, GPoint start) {
    if (solvedBoard(board)) return true;
    else {
        for (int y = 0; y < board.numRows(); ++y) {
            for (int x = 0; x < board.numCols(); ++x) {
                if (board[x][y] == 1) {
                    for (int direction = 0; direction < 4; ++direction) {
                        start.x = x;
                        start.y = y;
                        GPoint mid = start;
                        GPoint dest = start;
                        travel(direction, mid, dest);
                        if (isLegal(board, mid, dest)) {
                           cout << "legal:  " << direction << start << mid << dest << endl;
                           makeMove(gw, board, moveCount, start, mid, dest);
                           invisibleMove(gw, board, moveCount, start, mid, dest);
                           if (isNewBoard(boardRecord, board)) {
                               if (!solveGame(gw, board, boardRecord, moveCount, start)){
                                   unMakeMove(gw, board, moveCount, start, mid, dest, direction);
                                   //unInvisibleMove(gw, board, moveCount, start, mid, dest, direction);
                                   cout << "unmake1: " << direction << start << mid << dest << " ----"<<endl;
                               } else return true;
                            } else {
                               unMakeMove(gw, board, moveCount, start, mid, dest, direction);
                               //unInvisibleMove(gw, board, moveCount, start, mid, dest, direction);
                               cout << "unmake2: " << direction << start << mid << dest << " ----"<<endl;
                            }
                        }
                    }
                }
            }
        }
    }
    return false;
}




// Helpers to Strategy


bool isNewBoard(Set<Grid<int>> & boardRecord, Grid<int> board) {
    if (boardRecord.contains(board)) {
        cout << "board already seen"<< endl;
       return false;
    }
    else boardRecord.add(board);
    cout << "new board #"<< boardRecord.size() << endl;
    return true;
}

bool solvedBoard(Grid<int> board) {
    Grid<int> solvedBoard = invertBoard(board);
    if (board == solvedBoard) return true;
    else return false;
}

/*
 * Direction and moves
 * ---------------------------------------------------------------------------
 */
bool makeMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint & mid, GPoint & dest){
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
    return true;
}


bool invisibleMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint & mid, GPoint & dest){
    board[start.x][start.y] = 0;
    board[mid.x][mid.y] = 0;
    board[dest.x][dest.y] = 1;
    moveCount++;
    return true;
}

bool unMakeMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint mid, GPoint dest, int direction){

    board[start.x][start.y] = 1;
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE, start.x, start.y, 3);
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/2, start.x, start.y, 1);
    board[mid.x][mid.y] = 1;
        //changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/4, mid.x, mid.y, 3);
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE, mid.x, mid.y, 1);
    board[dest.x][dest.y] = 0;
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/4, dest.x, dest.y, 3);
        changeSlot(gw, board, 0.1, PIX_SIZE, T_PAUSE/2, dest.x, dest.y, 0);
    moveCount--;
    return true;
}

bool unInvisibleMove(GWindow & gw, Grid<int> & board, int & moveCount, GPoint start, GPoint mid, GPoint dest, int direction){
    board[start.x][start.y] = 1;
    board[mid.x][mid.y] = 1;
    board[dest.x][dest.y] = 0;
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
Grid<int> invertBoard(Grid<int> board){
    Grid<int> result = board;
    for (int y = 0; y < result.numRows(); ++y) {
        for (int x = 0; x < result.numCols(); ++x) {
            if (result[x][y] == 1) result[x][y] = 0;
            else if (result[x][y] == 0) result[x][y] = 1;
        }
    }
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
