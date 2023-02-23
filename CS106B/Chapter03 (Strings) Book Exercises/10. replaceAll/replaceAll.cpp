/*
 * File: main.cpp
 * --------------
 * Write a function
 *
 * string replaceAll(string str, char c1, char c2);
 *
 * that returns a copy of str with every occurrence of c1 replaced by c2. For example, calling
 *
 * replaceAll("nannies", 'n', 'd');
 *
 * should return "daddies".
 *
 * Once you have coded and tested this function, write an overloaded version
 *
 * string replaceAll(string str, string s1, string s2);
 *
 * that replaces all instances of the string s1 with the replacement string s2.
 */

#include "console.h"
#include "simpio.h"
#include "string"
using namespace std;


const string SENTINEL = "0";

void removeDoubledLetters(string & str);


string replaceAll(string phrase, char occur, char replacement);

string replaceAll(string phrase, string occur, string replacement);



int main() {
    string phrase = "";
    cout << "This program will replace parts of a phrase with a given input \nEnter 0 to exit " << endl;
    while (phrase != SENTINEL) {
        phrase = getLine("\nWhat is the original phrase");
        string occur = getLine("\nWhat parts need to be replace");
        string replacement = getLine("\nWhat to replace it with?");
        if (occur.length() < 2 && replacement.length() < 2) {
            char occurS = occur[0];
            char replacementS = replacement[0];
            phrase = replaceAll(phrase, occurS, replacementS);
        }
        else phrase = replaceAll(phrase, occur, replacement);
        cout << "The resulting phrase is " << phrase << endl;
    }
    return 0;
}

string replaceAll(string phrase, char occur, char replacement){
    string result = phrase;
    for (int i = 0; i < phrase.length(); i++){
        if (result[i] == occur) result[i] = replacement;
    }
    return result;
}

string replaceAll(string phrase, string occur, string replacement){
    int ticker = 0;
    string result = phrase;
    while (ticker != -1) {
        ticker = result.find(occur, ticker);
        if (ticker != -1) {
            result.erase(ticker, occur.length());
            result.insert(ticker, replacement);
            ticker++;
        }
    }
    return result;
}
