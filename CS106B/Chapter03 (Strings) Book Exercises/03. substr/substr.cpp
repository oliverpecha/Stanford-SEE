/*
 * File: substr.cpp
 * --------------
 * Without using the built-in string method substr, implement a free function substr(str, pos, n)
 * that returns the substring of str beginning at position pos and containing at most n characters.
 * Make sure that your function correctly applies the following rules:
 *
 *      • If n is missing or greater than the length of the string, the substring should extend through
 *      the end of the original string.
 *
 *      • If pos is greater than the length of the string, substr should call error with an appropriate message.
 */

#include "console.h"
#include "simpio.h"
#include "error.h"
using namespace std;

string substr(string str, int pos, int n);

int main()
{
    string str = getLine("What is the phrase you want an extract from");
    int n = getInteger("How many characters to extract");
    int pos = getInteger("Enter a number as the position to begin extraction");
    if (pos > str.length()-1) error("... Extraction can not begin after the actual phrase!!!");
    cout << "The extract is... " << substr(str, pos, n) << endl;
    return 0;
}

string substr(string str, int pos, int n) {
    string result;
    for (int i = pos; i < str.length(); i++) {
        cout << "*** i is " << str[i] << endl;
        result += str[i];
        n--;
        if (n == 0) return result;
    }

    return result;
}
