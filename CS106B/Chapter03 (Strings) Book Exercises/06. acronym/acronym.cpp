/*
 * File: acronym.cpp
 * --------------
 * An acronym is a new word formed by combining, in order, the initial letters of a series of words.
 * For example, the word scuba is an acronym formed from the first letters in self-contained underwater
 * breathing apparatus. Similarly, AIDS is an acronym for Acquired Immune Deficiency Syndrome. Write a
 * function acronym that takes a string and returns the acronym formed from that string.
 *
 * To ensure that your function treats hyphenated compounds like self-contained as two words,
 * it should define the beginning of a word as any alphabetic character that appears either at the beginning
 * of the string or after a nonalphabetic character.
 *
 */

#include "console.h"
#include "simpio.h"
using namespace std;

string acronym(string str);
string capitalizeAll(string str);

const string SENTINEL = "0";

int main() {
    string wordSeries = "";
    cout << "This program will turn a series of words into an acronym \nEnter 0 to exit " << endl;
    while (wordSeries != SENTINEL) {
        wordSeries = getLine("\nWhat series of words?");
        cout << "The acronym for " << wordSeries << " is: \"" << acronym(wordSeries) <<"\""<< endl;
    }
    return 0;
}

string acronym(string str) {
    string result = "";
    int index = 0;
    for (int i = 0; i < str.length(); i++){
        if (index == 0) {
           result += str[i];
           index++;
        }
        else    index++;
        if (isspace(str[i+1]) || ispunct(str[i+1])) {
            index = -1;
        }
    }
    return capitalizeAll(result);
}

string capitalizeAll(string str) {
    for (int i = 0; i < str.length(); i++){
           str[i] = toupper(str[i]);
    }
    return str;
}
