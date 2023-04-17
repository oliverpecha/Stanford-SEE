/*
 * File: Pascal's Triangle.cpp
 * --------------
 * As you know from Chapter 2, the mathematical combinations function c(n, k) is usually defined in terms of factorials, as follows:
 *      c(n, k) =  n! / (k! * (n - k)!)
 *
 * The values of c(n, k) can also be arranged geometrically to form a triangle in which n increases as you move down the triangle and
 *  k increases as you move from left to right. The resulting structure, which is called Pascal’s Triangle after the French
 *  mathematician Blaise Pascal, is arranged like this:
 *
 *          image
 *
 *  Pascal’s Triangle has the interesting property that every entry is the sum of the two entries above it, except along the left and
 *  right edges, where the values are always 1. Consider, for example, the circled entry in the following display of Pascal’s Triangle:
 *
 *          image
 *
 *  This entry, which corresponds to c(6, 2), is the sum of the two entries—5 and 10—that appear above it to either side.
 *  Use this relationship between entries in Pascal’s Triangle to write a recursive implementation of the c(n, k) function that uses
 *  no loops, no multiplication, and no calls to fact.
 *
 */

#include "console.h"
#include "simpio.h"
using namespace std;


void printOriginTriangle(int rows);
void printValuesTriangle(int rows);
string spacesHelper(int column, int rows, int comp);
int fact(int n);
int combinations (int n, int k);
void printRecursTriangle(int rows);
int recursCombs (int n, int k);


const int ROWS = 9;

int main() {
    cout << "Original Combinations Triangle" << endl;
    printOriginTriangle(ROWS);
    cout << endl;
    cout << endl;
    cout << "Pascal Triangle using factorials" << endl;
    printValuesTriangle(ROWS);
    cout << endl;
    cout << endl;
    cout << "Pascal Triangle using recursion" << endl;
    printRecursTriangle(ROWS);
    return 0;
}


void printOriginTriangle(int rows){
    for (int y = 0; y <= rows; ++y) {
        int columns = y;
        cout << spacesHelper(columns, rows, 5);
        for (int x = 0; x <= columns; ++x) {
            cout << "(" << y << "," << x << ")" ;
        }
        cout << endl;
    }
}

void printValuesTriangle(int rows){
    for (int y = 0; y <= rows; ++y) {
        int columns = y;
        cout << spacesHelper(columns, rows, 3);
        for (int x = 0; x <= columns; ++x) {
            if (combinations(y,x) < 10) cout << " " ;
            cout << combinations(y,x) << " " ;
        }
        cout << endl;
    }
}

void printRecursTriangle(int rows){
    for (int y = 0; y <= rows; ++y) {
        int columns = y;
        cout << spacesHelper(columns, rows, 3);
        for (int x = 0; x <= columns; ++x) {
            if (recursCombs(y,x) < 10) cout << " " ;
            cout << recursCombs(y,x) << " " ;
        }
        cout << endl;
    }
}

string spacesHelper(int column, int rows, int comp) {
    string result;
    for (int var = 0; var < (rows-column)*comp/2; ++var) {
        result += " ";
    }
    return result;
}

int fact(int n) {
          if (n == 0) {
             return 1;
          } else {
             return n * fact(n - 1);
          }
}

int combinations (int n, int k) {
    return fact (n) / (fact(k) * fact(n-k));
}

int recursCombs (int n, int k) {
    if (n == 0 || k == 0) return 1;
    if (n == k) return 1;
    else return recursCombs(n - 1, k -1) + recursCombs(n - 1, k);
}

