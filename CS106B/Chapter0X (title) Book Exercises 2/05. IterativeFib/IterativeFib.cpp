/*
 * File: IterativeFib.cpp
 * --------------
 * Write an iterative implementation of the function fib(n).
 */

#include "console.h"
#include "simpio.h"
#include "vector.h"
using namespace std;


int fib(int n, int t);


int main() {
    int n = 0;
    int t = 0;
    while (n > -1) {
        n = getInteger("What is the number to calculate fib?");
        t = getInteger("How long until fertile?");
        cout << "fib is " << fib(n, t) << endl;
        cout << "\n " << endl;
    }
    return 0;
}


int fib(int n, int tNursing) {
    Vector<int> nursing(tNursing);
    int nFertile = 1;
    for (int var = 1; var <= n; ++var) {
        nFertile += nursing.get(0);
        for (int var = 0; var < tNursing-1; ++var) {
            nursing.set(var,nursing.get(var+1));
        }
        nursing.set(tNursing-1, nFertile);
        //cout << "month: " << var << " nFertile: " << nFertile << " nursing: " << nursing << endl;
    }
    return nFertile;
}
