/*
 * File: trim.cpp
 * --------------
 * The strlib.h function exports a function trim(str) that returns a new string formed by
 * removing all whitespace characters from the beginning and end of str.
 * Write the corresponding implementation.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

string trim(string str);

int main() {
    string line = getLine("Enter a line of text");
   cout << "Spaces have been removed from the line entered: " << trim(line) << endl;
    return 0;
}

string trim(string str) {
    string result;
    for (int i = 0; i < str.length(); i++) {
        if (!isspace(str[i])) result += str[i];
    }
    return result;
}
