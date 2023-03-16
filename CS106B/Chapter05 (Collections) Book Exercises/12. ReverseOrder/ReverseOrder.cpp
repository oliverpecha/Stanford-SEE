/*
 * File: ReverseOrder.cpp
 * --------------
 * Write a program that uses a stack to reverse a sequence of integers read
 * from the console one number per line, as shown in the following sample run:
 */

#include "console.h"
#include "simpio.h"
#include "stack.h"
using namespace std;


int main() {
    cout << "Enter a list of integers, ending with 0: " << endl;
    int value = -1;
    Stack<int> ledger;
    while (value != 0) {
        value = getInteger("? ");
        if (value != 0) ledger.push(value);
    }
    cout << "Those integers in reverse order are: " << endl;
    while (!ledger.isEmpty()) cout << " " <<    ledger.pop() << endl;
    return 0;
}
