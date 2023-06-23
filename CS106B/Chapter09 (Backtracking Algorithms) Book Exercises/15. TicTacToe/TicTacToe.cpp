/*
 * File: TicTacToe.cpp
 * --------------
 * The game of tic-tac-toe is played by two players who take turns placing
 * Xs and Os in a 3!3 grid that looks like this:
 *
 * The object of the game is to line up three of your own symbols in a row,
 * horizontally, vertically, or diagonally. In the following game, for example,
 * X has won the game by completing three in a row across the top:
 *
 * If the board fills up without anyone completing a row, the game is a draw,
 * which is called a cat’s game in tic-tac-toe.
 *
 * Write a program that uses the minimax algorithm to play a perfect game of
 * tic-tac-toe. Figure 9-8 shows a sample run against a particularly inept player.
 */

#include "console.h"
#include "simpio.h"
#include "grid.h"

using namespace std;


/* Constants */
const int NO_GOOD_MOVE = -1;    /* Marker indicating there is no good move */
const int MAX_DEPTH = 3;
const int WINNING_POSITION  = 1000;
const int LOSING_POSITION   = -WINNING_POSITION;
/*
* Type: Player
* --------------------------------------------
* This enumerated type differentiates the human and computer players.
*/
enum Player { HUMAN, COMPUTER, EVEN };

/*
* Method: opponent
* Usage: Player other = opponent (player);
* --------------------------------------------
* Returns the opponent of the player. The opponent of the computer
* is the human player and vice versa.
*/
Player opponent (Player player) {
    return (player == HUMAN)? COMPUTER : HUMAN;
}

/*
* Constant: STARTING_PLAYER
* --------------------------------------------
* Indicates which player should start the game.
*/
const Player STARTING_PLAYER = COMPUTER;

/*
* Type: Move
* ----------------------------------------------------------------------------------------
* ----------------------------------------------------------------------------------------
* This struct serves the necessary steps to make a move.
*/
struct Move {
        int nDestination;

        Player turn;

        string toString() {
            return "Move dest: " + to_string(nDestination) + to_string(turn);
        }


};


/*
* Type: Move
* ----------------------------------------------------------------------------------------
* ----------------------------------------------------------------------------------------
* This classs contains all the functions necessary to play TicTacToe
*/

class TicTacToe {


public:

/*
* Method: play
* Usage: game.play();
* --------------------------------------------
* Plays one game of Nim with the human player.
*/

    void play() {
        initGame();
        while (!gameIsOver()) {
            //displayGame();
            if (getCurrentPlayer() == HUMAN) {
                makeMove(getUserMove(), HUMAN);
            } else {
                Move move = getComputerMove();
                makeMove(move, COMPUTER);
                displayMove(move);
            }
            switchTurn();
        }
        announceResult();
    }

private:

/*
* General Mechanics
* ----------------------------------------------------------------------------------------
*/

void initGame(){
    printInstructions();
    whoseTurn = STARTING_PLAYER;
    Grid<int> initializer {{-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1}};
    board = initializer;
}

bool gameIsOver() {
    //int playtill = 1 ;
    if (lineFound() || fullBoard()) return true;
    else {
        //cout << "go..";
        return false;
    }
}


void displayBoard(){
    cout << "The game now looks like this: " << endl << endl;
    printBoard();
}

void displayMove(Move move){
    displayBoard();
}


Player getCurrentPlayer() {
    return whoseTurn;
}

void switchTurn() {
    whoseTurn = opponent(whoseTurn);
}

bool fullBoard(){
    int target = 9;
    for (int y = 0; y < 3; ++y) {
        for (int x = 0; x < 3; ++x) {
            if (board[x][y] == 1 || board[x][y] == 0) {
                target--;
            }
            if (target == 0) return true;
        }
    }
    return false;
}

bool lineFound() {
    int targetA = 3;
    int targetB = 3;
    Player winner;
    if (lineFound(winner, targetA, targetB)) return true;
    else return false;
}

bool lineFound(Player & winner, int & targetA, int & targetB) {

    for (int y = 0; y < 3; ++y) {
        for (int x = 0; x < 3; ++x) {
            if (board[x][y] == 1) targetA--;
            else if (board[x][y] == 0) targetB--;
        }
        if (targetA == 0) {
            winner = COMPUTER;
            return true;
        } else if (targetB == 0) {
            winner = HUMAN;
            return true;
        }
        else {
            targetA = 3;
            targetB = 3;
        }
    }
    for (int x = 0; x < 3; ++x) {
        for (int y = 0; y < 3; ++y) {
            if (board[x][y] == 1) targetA--;
            else if (board[x][y] == 0) targetB--;
        }
        if (targetA == 0) {
            winner = COMPUTER;
            return true;
        } else if (targetB == 0) {
            winner = HUMAN;
            return true;
        }
        else {
            targetA = 3;
            targetB = 3;
        }
    }
    int y;
    int x;
    int n = 0;
    Vector<int> dL2Right {1,5,9};
    for (int var = 0; var < 3; ++var) {
        pos2Axis(dL2Right[n], y, x);
        if (board[x][y] == 1) targetA--;
        else if (board[x][y] == 0) targetB--;
        n++;
    }
    if (targetA == 0) {
        winner = COMPUTER;
        return true;
    } else if (targetB == 0) {
        winner = HUMAN;
        return true;
    }
    else {
        targetA = 3;
        targetB = 3;
    }
    n = 0;
    Vector<int> dR2Left {3,5,7};
    for (int var = 0; var < 3; ++var) {
        pos2Axis(dR2Left[n], y, x);
        if (board[x][y] == 1) targetA--;
        else if (board[x][y] == 0) targetB--;
        n++;
    }
    if (targetA == 0) {
        winner = COMPUTER;
        return true;
    } else if (targetB == 0) {
        winner = HUMAN;
        return true;
    }
    return false;
}

void announceResult () {
    cout << "The final position looks like this: " << endl;
    printBoard();
    int targetA = 3;
    int targetB = 3;
    Player winner;
    lineFound(winner, targetA, targetB);
    if (winner == HUMAN) {
        cout << "I lose." << endl;
    } else if (winner == COMPUTER) {
        cout << "I win." << endl;
    } else cout <<"Board is full without a winner";
}

void printBoard(){
    cout << " " << list2gridContent(1) << " | " << list2gridContent(2) << " | " << list2gridContent(3) << endl;
    cout << "___+___+___" << endl;
    cout << " " << list2gridContent(4) << " | " << list2gridContent(5) << " | " << list2gridContent(6) << endl;
    cout << "___+___+___" << endl;
    cout << " " << list2gridContent(7) << " | " << list2gridContent(8) << " | " << list2gridContent(9) << endl << endl;
}
void printInstructions() {
    cout << "Welcome to TicTacToe, the game of three in a row." << endl;
    cout << "I'll be X, and you'll be O. \nThe squares are numbered like this:" << endl << endl;
    cout << " 1 | 2 | 3" << endl;
    cout << "___+___+___" << endl;
    cout << " 4 | 5 | 6" << endl;
    cout << "___+___+___" << endl;
    cout << " 7 | 8 | 9" << endl << endl;
}



/*
* Helpers to mechanics
* ----------------------------------------------------------------------------------------
*/

bool isLegal(int n){
    int y;
    int x;
    pos2Axis(n, y, x);
    if (x < 0 || y < 0 || x > board.numCols() - 1 || y > board.numCols() - 1) {
        return false;
    }
    int content = board[x][y];
    if (content == 0 || content == 1) return false;
    else return true;

}
char list2gridContent(int n) {
    int y;
    int x;
    pos2Axis(n, y, x);
    int content = board[x][y];
    //if (n == 6) cout << "cc" << board[x][y] << board << endl;
    //if (content == 0 && n == 6) return '!';

    if (content == 0) return 'O';
    else if (content == 1) return 'X';
    else if (content == -1) return ' ';
    else return 'e';
}

void pos2Axis(int pos, int & y, int & x) {
    switch (pos) {
        case 1:
            y = 0;
            x = 0;
            break;
        case 2:
            y = 0;
            x = 1;
            break;
        case 3:
            y = 0;
            x = 2;
            break;
        case 4:
            y = 1;
            x = 0;
            break;
        case 5:
            y = 1;
            x = 1;
            break;
        case 6:
            y = 1;
            x = 2;
            break;
        case 7:
            y = 2;
            x = 0;
            break;
        case 8:
            y = 2;
            x = 1;
            break;
        case 9:
            y = 2;
            x = 2;
            break;
    }
}


int axis2pos(int y, int x){
    if (y == 0 && x == 0) return 1;
    else if (y == 0 && x == 1) return 2;
    else if (y == 0 && x == 2) return 3;
    else if (y == 1 && x == 0) return 4;
    else if (y == 1 && x == 1) return 5;
    else if (y == 1 && x == 2) return 6;
    else if (y == 2 && x == 0) return 7;
    else if (y == 2 && x == 1) return 8;
    else if (y == 2 && x == 2) return 9;
    else return -1;
}

int clockHandHelp(int pos, int dir) {
    int dest = -1;
    int y;
    int x;
    pos2Axis(pos, y, x);
    switch (dir) {
        case 1:
            y -= 1;
            break;
        case 2:
            y -= 1;
            x += 1;
            break;
        case 3:
            x += 1;
            break;
        case 4:
            y += 1;
            x += 1;
            break;
        case 5:
            y += 1;
            break;
        case 6:
            y += 1;
            x -= 1;
            break;
        case 7:
            x -= 1;
            break;
        case 8:
            y -= 1;
            x -= 1;
            break;
    }
    if (isLegal(axis2pos(y, x))) dest = axis2pos(y, x);
    return dest;
}


/*
* Get Moves, from User & computer
* ----------------------------------------------------------------------------------------
*/

Move getUserMove() {
    Move result;
    cout << "Your move." << endl;
    while (true) {
        int nDestination;
        nDestination = getInteger("What square? ");
        if (nDestination < 1 ||  nDestination > 9){
            cout << "That is not a square in this board. Choose another one." << endl;
        } else if (isLegal(nDestination)) {
            result.nDestination = nDestination;
            return result;
        } else cout << nDestination << " is already filled. Choose another square." << endl;
    }
    return result;
}



Move getComputerMove() {
    Move result = findBestMove();
    if (result.nDestination == NO_GOOD_MOVE) {
        result.nDestination = 1;
        return result;
    } else return result;
}

/*
* Make and retract moves
* ----------------------------------------------------------------------------------------
*/

void makeMove(Move move, Player turn) {
    int y;
    int x;
    pos2Axis(move.nDestination, y, x);
    if (move.turn == HUMAN || turn == HUMAN) {
        board[x][y] = 0;
    }
    else {
        board[x][y] = 1;
    }
}

void retractMove(Move move){
    int y;
    int x;
    pos2Axis(move.nDestination, y, x);
    board[x][y] = -1;
}



/*
* Return Best Move for the computer, by finding best ranked move out of all movements allowed
* ----------------------------------------------------------------------------------------
*/

    Move findBestMove() {
        int rating;
        return findBestMove (0, rating);
    }


    Move findBestMove (int depth, int & rating) {
        Vector<Move> moveList;
        Move bestMove;
        int minRating = WINNING_POSITION + 1;
        Player player = COMPUTER;
        if (depth % 2 != 0) player = HUMAN;
        generateMoveList(moveList, player);
        if (moveList.isEmpty()) error ("No moves available");
        for (Move move : moveList) {
            makeMove(move, COMPUTER);
            int moveRating = evaluatePosition(depth + 1);
            if (moveRating < minRating) {
                bestMove = move;
                minRating = moveRating;
            }
            retractMove (move) ;
        }
        rating = -minRating;
        return bestMove;
    }

    void generateMoveList(Vector<Move> & moveList, Player player){
        for (int var = 1; var <= 9; ++var) {
            int y, x;
            pos2Axis(var, y, x);
            if (board[x][y] == -1) {
                Move result;
                result.nDestination = var;
                result.turn = player;
                moveList.add(result);
            }

        }
    }

    int evaluatePosition(int depth) {
        if (gameIsOver() || depth >= MAX_DEPTH) {
            return evaluateStaticPosition();
        }
        int rating;
        findBestMove(depth, rating);
        return rating;
    }

    int evaluateStaticPosition() {
        if (lineFound()) return -10;
        else return 10;
    }



/*
* Instance variables
* ----------------------------------------------------------------------------------------
*/

    Player whoseTurn; /* Identifies which player moves next */
    Grid<int> board;
};


int main() {
    TicTacToe game;
    game.play();
    return 0;
}
