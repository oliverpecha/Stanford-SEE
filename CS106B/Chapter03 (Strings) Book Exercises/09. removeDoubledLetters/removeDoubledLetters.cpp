/*
 * File: removeDoubledLetters.cpp
 * --------------
 * In the early part of the 20th century, there was considerable interest in both
 * England and the United States in simplifying the rules used for spelling English words,
 * which has always been a difficult proposition. One suggestion advanced as part of this
 * movement was to eliminate all doubled letters, so that bookkeeper would be written as bokeper
 * and committee would become comite. Write a function removeDoubledLetters(str) that returns a new
 * string in which any duplicated characters in str have been replaced by a single copy.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

const string SENTINEL = "0";

void removeDoubledLetters(string & str);

int main() {
    string phrase = "";
    cout << "This program will remove all letters that repeat one after another \nEnter 0 to exit " << endl;
    while (phrase != SENTINEL) {
        phrase = getLine("\nWhat is the original phrase");
        removeDoubledLetters(phrase);
        cout << "The resulting phrase is " << phrase << endl;
    }
    return 0;
}

void removeDoubledLetters(string & str) {
    for (int b = 0; b < str.length(); b++){
            if (str[b] == str[b+1]) {
                str.erase(b+1,1);
            }
    }
}
