/*
 * File: removeCharactersInPlace.cpp
 * --------------
 * 7. Write a function
 *
 * string removeCharacters(string str, string remove);
 *
 * that returns a new string consisting of the characters in str after removing all instances
 * of the characters in remove. For example, if you call removeCharacters("counterrevolutionaries", "aeiou")
 * the function should return "cntrrvltnrs", which is the original string after removing all of its vowels.
 *
 *=============
 *
 * 8. Modify your solution to exercise 7 so that, instead of using a function that returns a new string,
 * you define a function removeCharactersInPlace that removes the letters from the string passed as the first argument.
 *
 */

#include "console.h"
#include "simpio.h"
#include "string"
using namespace std;

void removeCharactersInPlace(string & str, string remove);

const string SENTINEL = "0";

int main() {
    string phrase = "";
    cout << "This program will remove all instances of the given characters from an entered phrase \nEnter 0 to exit " << endl;
    while (phrase != SENTINEL) {
        phrase = getLine("\nWhat is the original phrase");
        string instances = getLine("What characters to remove?");
        removeCharactersInPlace(phrase, instances);
        cout << "The resulting phrase is " << phrase << endl;
    }
    return 0;
}

void removeCharactersInPlace(string & str, string remove) {
    for (int a = 0; a < remove.length(); a++){
        for (int b = 0; b < str.length(); b++){
            for (int c = 0; c < remove.length(); c++){
                if (remove[c] == str[b]) {
                    str.erase(b,1);
                }
            }
        }
    }


}

