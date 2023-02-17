/*
 * File: main.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
#include "combinatorics.h"
using namespace std;


int main() {
    int n, k;
    n = getInteger("Enter the number of objects (n):");
    k = getInteger("Enter the number to be choosen (k):");
    cout << "C(n,k) = " << combinations (n, k) << endl;
    return 0;
}


