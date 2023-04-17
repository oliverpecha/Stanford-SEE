/*
 * File: ReverseString.cpp
 * --------------
 * Write a recursive function that takes a string as argument and returns the reverse of that string. The prototype for this function should be
 *            string reverse(string str);
 * and the statement
 *            cout << reverse("program") << endl;
 * should display
 *
 *  image
 *
 * Your solution should be entirely recursive and should not use any iterative constructs such as while or for.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

string reverse(string str);

//const string STR = "program";
const string STR = "five";

int main() {
    cout << STR.substr(2) << endl;
    cout << STR.substr(0,2) << endl;
    cout << STR[STR.length()-1] << endl;
    cout << reverse(STR) << endl;
    return 0;
}

string reverseHelper(string str, int start, int end) {
if (str.length() < 2) return str;
else return reverseHelper(str.substr(start + 1), start, end + 1) + str[start];
}


string reverse(string str) {
   if (str.length() < 2) return str;
   else return reverseHelper(str, 0, str.length() - 1);
}

