
/*
* File: tokenscanner.cpp
* ---------------------------
* This file implements the TokenScanner class. Most of the methods
* are straightforward enough to require no additional documentation.
*/

#include <cctype>
#include <iostream>
#include <ostream>
#include <string>
#include "tokenscanner.h"

using namespace std;

TokenScanner::TokenScanner() {
    /* Empty */
}

TokenScanner::TokenScanner (string str) {
    setInput (str);
}


void TokenScanner::setInput (string str) {
    buffer = str;
    cp = 0;
}


bool TokenScanner::hasMoreTokens() {
    skipPreferences();
    return cp < buffer.length();
}

/*
* Implementation notes: next Token
* -----------------------------------
* This method starts by looking at the character at the current character * indicated by the index cp. If that * next Token returns the empty string.
index is past the end of the string, If that character is alphanumeric,
* next Token scans ahead until it finds the end of that word; if not,
* nextToken returns that character as a one-character string.
*/
string TokenScanner::nextToken() {
    skipPreferences();
    if (cp >= buffer.length()) {
        return "";
    } else if (isalpha (buffer[cp])) {
        int start = cp;
        while (cp < buffer.length() && isalpha (buffer[cp])) {
            cp++;
        }
        return buffer.substr(start, cp - start);
    } else {
        return string (1, buffer[cp++]);
    }
}


/*
* Implementation notes: ignoreWhitespace and skipWhitespace
*
*This ignoreWhitespace method simply sets a flag. The private method
* skipWhitespace is called only if that flag is true.
*/


void TokenScanner::ignoreWhitespace () {
    ignoreWhitespaceFlag = true;
}

void TokenScanner::ignorePunctuation () {
    ignorePunctuationFlag = true;
}

void TokenScanner::ignoreNumbers () {
    ignoreNumbersFlag = true;
}

void TokenScanner::skipPreferences() {
    while (cp < buffer.length() &&
          (isdigit(buffer[cp]) || isspace (buffer[cp]) || ispunct (buffer[cp]))) {
        if (ispunct(buffer[cp]) && ignorePunctuationFlag) cp++;
        else if (isdigit(buffer[cp]) && ignoreNumbersFlag) cp++;
        else if (isspace(buffer[cp]) && ignoreWhitespaceFlag) cp++;
        else break;
    }
}

