/*
 * File: main.cpp
 * --------------
 * Unlike many programming languages, C++ does not include a predefined operator
 * that raises a number to a power. As a partial remedy for this deficiency, write
 * a recursive implementation of a function
 *           int raiseToPower(int n, int k)
 * that calculates nk. The recursive insight that you need to solve this problem is the mathematical property that
 * 1 if k is 0 nk =
 * n × n k-1 otherwise
 *
 */

#include "console.h"
#include "simpio.h"
using namespace std;

int raiseToPower(int n, int k);

int main() {

    cout << raiseToPower(5, 7) << endl;

    return 0;
}


int raiseToPower(int n, int k) {
    if (k == 0) return 1;
    else {
        return n * raiseToPower(n, k - 1);
    }
    return 0;
}
