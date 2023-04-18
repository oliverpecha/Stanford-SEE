/*
 * File: moveTower.cpp
 * --------------
 * 1. Following the logic of the moveTower function, write a recursive function countHanoiMoves(n)
 * that computes the number of moves required to solve the Towers of Hanoi puzzle for n disks.
 * 2. To make the operation of the program somewhat easier to explain, the implementation of moveTower
 * in this chapter uses
 *          if (n == 1)
 * as its simple case test. Whenever you see a recursive program use 1 as its simple case, it pays
 * to be a little skeptical; in most applications, 0 is a more appropriate choice. Rewrite the Towers
 * of Hanoi program so that the moveTower function checks whether n is 0 instead. What happens to the
 * length of the moveTower implementation?
 */


#include <iostream>
#include "simpio.h"
#include "console.h"

using namespace std;

/* Function prototypes */
void moveTower(int n, char start, char finish, char tmp, int simpleCase);
void moveSingleDisk(char start, char finish);
int countHanoiMoves(int n, int simpleCase);

/* Main program */
    int main() {
        int n = 0;
        while (n > -1) {
            n = getInteger("Enter number of disks: ");
            cout << "With simple case == 0" << endl;
            moveTower (n, 'A', 'B', 'C', 1);
            cout << countHanoiMoves(n, 1) << endl;
            cout << "\n\nWith simple case == 0" << endl;
            moveTower (n, 'A', 'B', 'C', 0);
            cout << countHanoiMoves(n, 0) << endl;
        }

        return 0;
    }

/*
* Function: moveTower
* Usage: moveTower (n, start, finish, tmp);
*
* Moves a tower of size n from the start spire to the finish * spire using the tmp spire as the temporary repository.
*/
    void moveTower (int n, char start, char finish, char tmp,  int simpleCase) {
        if (n == simpleCase) {
            moveSingleDisk(start, finish);
        } else {
            moveTower (n- 1, start, tmp, finish, simpleCase);
            moveSingleDisk(start, finish);
            moveTower (n- 1, tmp, finish, start, simpleCase);
        }
    }

/*
* Function: moveSingleDisk
* Usage: moveSingleDisk (start, finish);
*
* Executes the transfer of a single disk from the start spire to the
* finish spire. In this implementation, the move is simply displayed
* on the console; in a graphical implementation, the code would update * the graphics window to show the new arrangement.
*/
    void moveSingleDisk (char start, char finish) {
        cout << start << " -> " << finish << endl;
    }

/*
* Function: countHanoiMoves
* Usage: countHanoiMoves (n);
*
* computes the number of moves required to solve the Towers of Hanoi puzzle for n disks
*/
    int countHanoiMoves(int n, int simpleCase) {
        int result = 0;
        if (n == simpleCase) return 1;
        else {
            result += countHanoiMoves(n-1, simpleCase);
            result++;
            result += countHanoiMoves(n-1, simpleCase);
            return result;
        }
    }
