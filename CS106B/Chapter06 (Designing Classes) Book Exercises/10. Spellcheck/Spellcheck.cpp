/*
 * File: main.cpp
 * --------------
 * Write a program that checks the spelling of all words in a file.
 * Your program should use the TokenScanner class to reads tokens from an input file and then look up each word in the lexicon stored in the file EnglishWords.dat introduced in Chapter 5. If the word does not appear in the lexicon, your program should print a message to that effect. If, for example, you run the program on a file containing the text of this paragraph, the SpellCheck program would produce the following output:
 */

#include "console.h"
#include "simpio.h"
#include "lexicon.h"
#include "tokenscanner.h"
#include <fstream>
using namespace std;

const string FILE_NAME = "SampleParagraph.txt";
int main() {
    Lexicon english ("EnglishWords.txt");
    ifstream ifile(FILE_NAME);
    string ibuffer;
    cout << "Input file: " << FILE_NAME << endl;
    if (ifile.is_open()) {
        while (getline(ifile, ibuffer)) {
            TokenScanner line(ibuffer);
            line.ignoreWhitespace();
            line.ignorePunctuation();
            line.ignoreNumbers();
            while (line.hasMoreTokens()) {
                string word = line.nextToken();
                if (!(english.contains(word))) cout << "\"" << word << "\" is not in the dictionary" << endl;
            }
        }

    }
    else cerr << "Issue opening input file" << endl;

  /*
    for (string stream : english){

        cout << stream << endl;
    } */
    return 0;
}
