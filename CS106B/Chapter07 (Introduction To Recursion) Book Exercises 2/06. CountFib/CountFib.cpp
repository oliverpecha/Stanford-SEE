/*
 * File: CountFib.cpp
 * --------------
 * For each of the two recursive implementations of the function fib(n) presented
 * in this chapter, write a recursive function (you can call these countFib1 and
 * countFib2 for the two algorithms) that counts the number of function calls
 * made during the evaluation of the corresponding Fibonacci calculation.
 * Write a main program that uses these functions to display a table showing
 * the number of calls made by each algorithm for various values of n,
 * as shown in the following sample run:
 *
 */

#include "console.h"
#include "simpio.h"
#include <iomanip>
#include "vector.h"
using namespace std;

const int LINES = 13;

int fib1(int n);
int fib2(int n);
int  additiveSequence(int n, int t0, int t1);
void fillFib1(Vector<int> & vec);
void fillFib2(Vector<int> & vec);
void printProgram(Vector<int> vec1, Vector<int> vec2);

int counter = 0;


int main() {
    Vector<int> fib1V(LINES);
    Vector<int> fib2V(LINES);
    fillFib1(fib1V);
    fillFib2(fib2V);
    printProgram(fib1V, fib2V);
    return 0;
}


int fib1(int n){
    if (n < 2) {
        counter++;
        return n;
    }
    else {
        counter++;
        return fib1(n - 1) + fib1(n - 2);
    }
}

int fib2(int n){
    counter++;
    return additiveSequence(n, 0, 1);
}

int  additiveSequence(int n, int t0, int t1){
    if (n == 0) {
        counter++;
        return t0;
    }
    if (n == 1) {
        counter++;
        return t1;
    }
    else {
        counter++;
        return additiveSequence(n - 1, t1, t0 + t1);
    }
}

void fillFib1(Vector<int> & vec){
    for (int var = 0; var < vec.size(); ++var) {
        fib1(var);
        vec.set(var, counter);
        counter = 0;
    }

}

void fillFib2(Vector<int> & vec){
    for (int var = 0; var < vec.size(); ++var) {
        fib2(var);
        vec.set(var, counter);
        counter = 0;
    }

}


void printProgram(Vector<int> vec1, Vector<int> vec2){
    cout << "This program counts the number of calls made by the two \n"
         << "algorithms used to compute the Fibonacci sequence.\n"  << endl;
    cout << "    n      fib1      fib2"  << endl;
    cout << "   --      ----      ----"  << endl;
    for (int var = 0; var < LINES; ++var) {
        cout << setw(5) << var << setw(10) << vec1.get(var) << setw(10) << vec2.get(var) << endl;
    }
}


