/*
* File: Nim.cpp
* ------------------------------------------
* This program simulates a simple variant of the game of Nim. In this
* version, the game starts with a pile of 13 coins on a table.
* Players then take turns removing 1, 2, or 3 coins from the pile.
* The player who takes the last coin loses.
*
* 12. Rewrite the simple Nim game so that it uses the generalized minimax
* algorithm presented in Figure 9-6. Your program should not change the code
* for findBestMove or evaluatePosition. Your job is to come up with an appropriate
* definition of the Move type and the various game-specific methods so that the
* program still plays a perfect game of Nim.
*
* 13. Modify the code for the simple Nim game you wrote for exercise 11 so that
* it plays a different variant of Nim. In this version, the pile begins with 17 coins.
* On each turn, players alternate taking one, two, three, or four coins from the pile.
* In the simple Nim game, the coins the players took away were simply ignored; in this
* game, the coins go into a pile for each player. The player whose pile contains an even
* number of coins after the last coin is taken wins the game.
*
* 14. In the most common variant of Nim, the coins are not combined into a single pile
* but are instead arranged in three rows like this: A move in this game consists of
* taking any number of coins, subject to the condition that all the coins must come from
* the same row. The player who takes the last coin loses.
*
* Write a program that uses the minimax algorithm to play a perfect game of three-pile Nim.
* The starting configuration shown here is a typical one, but your program should be
* general enough so that you can easily change either the number of rows or the number of
* coins in each row.
*/


#include <iostream>
#include <string>
#include "error.h"
#include "simpio.h"
#include "strlib.h"
#include "console.h"


using namespace std;

/*
* Constant: VARIANT
* --------------------------------------------
* G_VARIANT, Indicates which exercise to run. The rest of variants get configurated by InitGame();
*/
const int G_VARIANT = 12;
const int N_COINS = 0;
const int MAX_MOVE = 0;
const int ROWS = 3;
const int MAX_X_ROW = 5;



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
const Player STARTING_PLAYER = HUMAN;


/*
* Type: Move
* --------------------------------------------
* This struct serves the necessary steps to make a move.
*/
struct Move {
          int nTaken;

          string toString() {
              return to_string(nTaken);
          }


};


/*
* Type: Move
* --------------------------------------------
* Overloads operator for printing Moves to the console
*/
std::ostream & operator<<(std::ostream & os, Move p1);

/*
* Class: SimpleNim
* --------------------------------------------
* The SimpleNim class implements the simple version of Nim.
*/

class SimpleNim {


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
            displayGame();
            if (getCurrentPlayer() == HUMAN) {
            makeMove(getUserMove());
            } else {
                Move move = getComputerMove();
                displayMove(move);
                makeMove(move);
            }
            switchTurn();
        }
        announceResult();
    }


    void oldPlay() {
        nCoins = N_COINS;
        whoseTurn = STARTING_PLAYER;
            while (nCoins > 1) {
                cout << "There are " << nCoins << " coins in the pile." << endl;
                if (whoseTurn == HUMAN) {
                    nCoins -= oldGetUserMove();
                } else {
                    int nTaken = oldGetComputerMove();
                    cout << "I'll take " << nTaken << "." << endl;
                    nCoins -= nTaken;
                }
                whoseTurn = opponent(whoseTurn);
            }
            announceResult();
    }

/*
* Method: print Instructions
* Usage: game.print Instructions ();
* --------------------------------------------
* This method explains the rules of the game to the user.
*/
    void printInstructions() {
        cout << "Welcome to the game of Nim!\n" << endl;
        cout << "In this variation of the game (exercise " << G_VARIANT << "), " << endl;
        cout << "we will start with a pile of " << nCoins << " coins on the table." << endl;
        cout << "On each turn, you and I will alternately take between 1 and" << endl;
        cout << maxMove << " coins from the table. The player who" << endl;
        cout << "takes the last coin loses."<< endl << endl;
    }


private:


/*
* Method: getComputerMove
* Usage: int nTaken = getComputerMove ();
* --------------------------------------------
* Figures out what move is best for the computer player and returns
* the number of coins taken. The method first calls findGoodMove
* to see if a winning move exists. If none does, the program takes
* only one coin to give the human player more chances to make a mistake.
*/

    Move getComputerMove() {
        Move result = findBestMove();
        if (result.nTaken == NO_GOOD_MOVE) {
            result.nTaken = 1;
            return result;
        }
        else return result;
        //return (nTaken == NO_GOOD_MOVE) ? result.nTaken = 1 : result.nTaken = nTaken; //<----------------------------------- ADJUST
    }

    int oldGetComputerMove() {
        int nTaken = findGoodMove (nCoins);
        return (nTaken == NO_GOOD_MOVE) ? 1 : nTaken;
    }

/*
* Method: findGoodMove
* Usage: int nTaken = findGoodMove (nCoins);
* --------------------------------------------
* This method looks for a winning move, given the specified number
* of coins. If there is a winning move in that position, the method
* returns that value; if not, the method returns the constant
* NO_GOOD_MOVE. This method depends on the recursive insight that a
* good move is one that leaves your opponent in a bad position and a bad
* position is one that offers no good moves.
*/
    int findGoodMove (int nCoins) {
        int limit = (nCoins < maxMove) ? nCoins: maxMove;
        for (int nTaken = 1; nTaken <= limit; nTaken++) {
            if (isBadPosition (nCoins - nTaken)) return nTaken;
        }
        return NO_GOOD_MOVE;
    }

/*
* Method: isBadPosition
* Usage: if (isBadPosition (nCoins))
* --------------------------------------------
* This method returns true if nCoins is a bad position.
* A bad position is one in which there is no good move.
* Being left with a single coin is clearly a bad position
* and represents the simple case of the recursion.
*/
    bool isBadPosition (int nCoins) {
        if (nCoins == 1) return true;
        return findGoodMove (nCoins) == NO_GOOD_MOVE;
    }


/*
* Method: getUserMove
* Usage: int nTaken = getUserMove();
* --------------------------------------------
* Asks the user to enter a move and returns the number of coins taken.
* If the move is not legal, the user is asked to reenter a valid move.
*/

    Move getUserMove() {
        Move result;
        while (true) {
            int nTaken;
            if (G_VARIANT == 14) nTaken = getInteger("\nHow many would you like to take from the current pile? ");
            else nTaken = getInteger("\nHow many would you like to take? ");
            updateCoinPile();
            int limit = (nCoins < maxMove) ? nCoins : maxMove;
            result.nTaken = nTaken;
            if (nTaken > 0 && nTaken <= limit) return result;
            if (maxMove == 1) cout << "That's cheating! You may only remove 1 coin" << endl;
            else {
                cout << " between 1 and " << limit << "." << endl;
                cout << "That's cheating! Please choose a number";
                cout << " between 1 and " << limit << "." << endl;
            }
            cout << "There are " << nCoins << " coins in the pile." << endl;
        }
        return result;
    }

    int oldGetUserMove() {
        while (true) {
            int nTaken = getInteger("How many would you like? ");
            int limit = (nCoins < maxMove) ? nCoins : maxMove;
            if (nTaken > 0 && nTaken <= limit) return nTaken;
            cout << "That's cheating! Please choose a number";
            cout << " between 1 and " << limit << "." << endl;
            cout << "There are " << nCoins << " coins in the pile." << endl;
        }
            return false;
    }
/*
* Method: announceResult
* Usage: announceResult();
* --------------------------------------------
* This method announces the final result of the game.
*/
    void announceResult () {
        if (nCoins == 0) {
            cout << "That was the last coin. You lose." << endl;
        } else {
            cout << "There is only one coin left." << endl;
        }
        if (G_VARIANT == 13) {
            cout << "You removed total of " << removedPile[0] << " coins. I took: " << removedPile[1] << endl;
            if (whoIsEven() == COMPUTER) {
                cout << "I win." << endl;
            } else if (whoIsEven() == HUMAN) {
                cout << "I lose." << endl;
            } else  cout << "We are even." << endl;

        }
        else if (G_VARIANT == 12 || G_VARIANT == 14) {
            if (whoseTurn == COMPUTER) {
                cout << "I lose." << endl;
            } else if (whoseTurn == HUMAN) {
                cout << "I win." << endl;
            }
        }
    }


/*
* Method: findBestMove
* Usage: Move move = findBestMove();
*        Move move = findBestMove (depth, rating);
* --------------------------------------------
* Finds the best move for the current player and returns that move as the
* value of the function. The second form is used for later recursive calls
* and includes two parameters. The depth parameter is used to limit the
* depth of the search for games that are too difficult to analyze. The
* reference parameter rating is used to store the rating of the best move.
*/

    Move findBestMove() {
        int rating;
        return findBestMove (0, rating);
    }


    Move findBestMove (int depth, int & rating) {
        Vector<Move> moveList;
        Move bestMove;
        int minRating = WINNING_POSITION + 1;
        generateMoveList(moveList);
        if (moveList.isEmpty()) error ("No moves available");
        for (Move move : moveList) {
            makeMove(move);
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

    void generateMoveList(Vector<Move> & moveList){
        updateCoinPile();
        int limit = (nCoins < maxMove) ? nCoins: maxMove;
        for (int nTaken = 1; nTaken <= limit; nTaken++) {
           Move result;
           result.nTaken = nTaken;
           moveList.add(result);
        }
    }

/*
* Method: evaluatePosition
* Usage: int rating = evaluatePosition (depth);
* --------------------------------------------
* Evaluates a position by finding the rating of the best move starting at
* that point. The depth parameter is used to limit the search depth.
*/
    int evaluatePosition(int depth) {
        if (gameIsOver() || depth >= MAX_DEPTH) {
            return evaluateStaticPosition();
        }
        int rating;
        findBestMove(depth, rating);
        return rating;
    }

    int evaluateStaticPosition() {
        if ((G_VARIANT == 12 || G_VARIANT == 14) && nCoins == 1) return -10;
        else if (G_VARIANT == 13 && nCoins == 0 && whoIsEven() == COMPUTER ) return -10;
        //else if (G_VARIANT == 14) {

       // }
        else return 10;
    }



/*
* Methods to help play public function
* --------------------------------------------
* Evaluates a position by finding the rating of the best move starting at
* that point. The depth parameter is used to limit the search depth.
*/
    void initGame(){
        if (G_VARIANT == 11) {
            nCoins = 13;
            maxMove = 3;
        } else if (G_VARIANT == 13) {
            nCoins = 17;
            maxMove = 4;
        } else if (G_VARIANT == 14) {
            int nXrow = MAX_X_ROW - 1 * (ROWS - 1);
            Vector<int> tempRow;
            for (int y = 0; y < ROWS; ++y) {
                int tempColumn = 0;
                for (int x = 0; x < nXrow; ++x) {
                    tempColumn += 1;
                }
                nXrow++;
                tempRow.add(tempColumn);
            }
            coinPile = tempRow;
            updateCoinPile();
        }

        printInstructions();
        whoseTurn = STARTING_PLAYER;
        Vector<int> initializer {0,0};
        removedPile = initializer;
    }


    bool gameIsOver() {
        int playtill = 1 ;
        if (G_VARIANT == 13) playtill = 0;
        if (nCoins > playtill) return false;
        else return true;
    }
    void displayGame(){
        cout << "There are " << nCoins << " coins in the table. " << endl;
        if (G_VARIANT == 13) cout << "So far, you have removed " << removedPile[HUMAN] << " coins, and I have removed " << removedPile[COMPUTER] << ". "<< endl;
        if (G_VARIANT == 14) {
            updateCoinPile();
            cout << "They are distributed in " << coinPile.size() << " piles. " << endl;
            cout <<"You may remove as many as you would like from the last one, \nwhich now holds " << maxMove << " coins."<< endl;
        }
    }
    void displayMove(Move move){
        cout << "I'll take " << move.nTaken << "." << endl;
    }

    void makeMove(Move move) {
        if (getCurrentPlayer() == HUMAN) {
            removedPile[HUMAN] += move.nTaken;
        }
        else removedPile[COMPUTER] += move.nTaken;
        if (G_VARIANT == 14) coinPile[getCurrentRow()] -= move.nTaken;     /// <------------------------------------- POSSIBLE BUG IN EARLIER VARIANTS
        nCoins -= move.nTaken;
    }

    void retractMove(Move move){
        nCoins += move.nTaken;
        removedPile[COMPUTER] -= move.nTaken;
        if (G_VARIANT == 14) {
            int currentRow = getCurrentRow();
            int nExpected = MAX_X_ROW - ROWS + currentRow + 1;
            if (coinPile[getCurrentRow()] == nExpected) {
                // means the last coin is at the end of the current pile, and the revert move should go to the upper pile
                currentRow++;
            }
            coinPile[currentRow] += move.nTaken;
        }


    }

    void updateCoinPile() {
        if (G_VARIANT == 14) {
            nCoins = 0;
            for (int var = 0; var < coinPile.size(); ++var) {
                nCoins += coinPile[var];
            }
            maxMove = coinPile[getCurrentRow()];
        }

    }

    int getCurrentRow() {
        for (int var = coinPile.size() - 1; var >= 0 ; --var) {
            if (coinPile[var] > 0) return var;
        }
        return 0;
    }

    Player getCurrentPlayer() {
        return whoseTurn;
    }

    void switchTurn() {
        whoseTurn = opponent(whoseTurn);
    }

    Player whoIsEven(){
        Player winner = HUMAN;
        if (removedPile[HUMAN] % 2 == 0 && removedPile[COMPUTER] % 2 == 0) winner = EVEN;
        else if (removedPile[HUMAN] % 2 != 0 && removedPile[COMPUTER] % 2 == 0) winner = COMPUTER;
        return winner;
    }

/* Instance variables */
    int nCoins; /* Number of coins left on the table */
    int coinsInRow;
    int maxMove;
    Player whoseTurn; /* Identifies which player moves next */
    Vector<int> removedPile; /* Pile of number of coins each player removed from on the table */
    Vector<int> coinPile;
};

/* Main program */
int main() {
    SimpleNim game;
    //game.printInstructions();
    //int variant = getInteger("What modality of Nim do you wish to play? \n Type 12, 13 or 14 - as descibed by textbook.");
    game.play();
    return 0;
}

/* Overloads operator for printing Moves to the console*/
std::ostream & operator<<(std::ostream & os, Move p1) {
    return os << p1.toString();
}
