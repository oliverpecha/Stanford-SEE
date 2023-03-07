/*
 * File: FileCounts.cpp
 * --------------
 * Write a program that reads a file and reports how many lines, words, and characters appear in it.
 * For the purposes of this program, a word consists of a consecutive sequence of any characters
 * except whitespace characters. As an example, suppose that the file Lear.txt contains the
 * following passage from Shakespeare’s King Lear,
 *
 * The counts in the output should be displayed in a column that is aligned on the right
 * but which expands to fit the data. For example, if you have a file containing the full
 * text of George Eliot’s Middlemarch, the output of your program should look like this:
 */

#include "console.h"
#include "simpio.h"
#include <fstream>
#include <string>
#include<sstream>

using namespace std;

const string SENTINEL = "";

void countNprint(string fName);
int countWords(string str);
void printResults(int chars, int words, int lines);
int findMaxNum(int chars, int words, int lines);

int main() {
    string fName = " ";
    while (fName != SENTINEL) {
        fName = getLine("Input file: ");
        countNprint(fName);
    }
    return 0;
}

void countNprint(string fName) {
    ifstream infile;
    infile.open(fName);
    int chars = 0, words = 0, lines = 0;
    string str;
        while (getline(infile, str)) {
            lines++;
            chars += str.length();
            words += countWords(str);
        }
    printResults(chars, words, lines);
}

int countWords(string str) {
    int words = 0;
    // word variable to store word
    string word;

    // making a string stream
    stringstream iss(str);

    // Read and print each word.
    while (iss >> word) {
        words++;
    }
    return words;
}

void printResults(int chars, int words, int lines) {
    int maxNum = findMaxNum(chars, words, lines);
    int maxDigits = 0; do { maxNum /= 10; maxDigits++; } while (maxNum != 0);
    cout << "Chars: " << setw(maxDigits) << chars << endl;
    cout << "Words: " << setw(maxDigits) << words << endl;
    cout << "Lines: " << setw(maxDigits) << lines << endl;
    cout << "\n " << endl;

}

int findMaxNum(int chars, int words, int lines) {
    if (chars > words && chars > lines) return chars;
    else if (words > lines) return words;
    else return lines;
}

