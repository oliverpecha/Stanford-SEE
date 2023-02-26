/*
 * File: createRegularPlural.cpp
 * --------------
 * Write a function createRegularPlural(word) that returns the plural of word formed by
 * following these standard English rules:
 *      a. If the word ends in s, x, z, ch, or sh, add es to the word.
 *      b. If the word ends in a y preceded by a consonant, change the y to ies.
 *      c. In all other cases, add just an s.
 *
 *      Write a test program and design a set of test cases to verify that your program works.
 */

#include "console.h"
#include "simpio.h"
#include "string.h"
using namespace std;


const string SENTINEL = "";

string createRegularPlural(string word);
bool isConsonant(char letter);

int main() {
    string word = " ";
    cout << "This program turns any word into plural. \nIndicate the end of the input with a blank line.. " << endl;
    while (word != SENTINEL) {
       word = getLine("\nEnter a word:");
       cout << "Plural is: " << createRegularPlural(word) << endl;
    }
    return 0;
}

string createRegularPlural(string word) {
    if (word[word.length()-1] == 's' || word[word.length()-1] == 'x' || word[word.length()-1] == 'z') {
        return word += "es";
    }
    if (word[word.length()-1] == 'h') {
        if (word[word.length()-2] == 'c' || word[word.length()-2] == 's') {
             return word += "es";
        }
    }
    if (word[word.length()-1] == 'y') {
        if (isConsonant(word[word.length()-2])) {
             return word.replace(word.length()-1, 1, "ies");
        }
    }
    return word += "s";
}

bool isConsonant(char letter) {
    if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') return false;
    else return true;
}
