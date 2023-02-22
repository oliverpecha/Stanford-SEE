/*
 * File: scrable.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
using namespace std;

int score(string word);
bool hasSpaces(string word);
bool isUpperLetter(char t);
int pointsFor(char t);

const string SENTINEL = "0";

int main() {
    string word = "";
    cout << "This program will calculate the amount of points per each word entered. \nLowercases and non letters get 0 points per character. \nEnter 0 to exit " << endl;
    while (word != SENTINEL) {
        word = getLine("\nWhat word?");
        if (!hasSpaces(word)) cout << word << " gets " << score(word) << " points" << endl;
        else cout << "text entered contains spaces, please enter a single word without spaces" << endl;
    }
    return 0;
}

int score(string word) {
    int points = 0;

    for (int i = 0; i < word.length(); i++) {
        if (isUpperLetter(word[i])) {
            points += pointsFor(word[i]);
        }
    }
    return points;
}

int pointsFor(char t) {
    switch(t){
        case 'A': case 'E': case 'I': case 'L': case 'N': case 'O': case 'R': case 'S': case 'T': case 'U':
        return 1;
        case 'D': case 'G':
        return 2;
        case 'B': case 'C': case 'M': case 'P':
        return 3;
        case 'F': case 'H': case 'V': case 'W': case 'Y':
        return 4;
        case 'K':
        return 5;
        case 'J': case 'X':
        return 8;
        case 'Q': case 'Z':
        return 10;
        default: return 0;
    }
}

bool isUpperLetter(char t){
   if (isalpha(t) && isupper(t)) return true;
   else return false;
}

bool hasSpaces(string word) {
    for (int i = 0 ; i < word.length(); i++) {
        if (isspace(word[i])) return true;
    }
    return false;
}
