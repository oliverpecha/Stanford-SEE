/*
 * File: LongestLine.cpp
 * --------------
 * Write a program that prints the longest line in a file chosen by the user.
 * If several lines are all equally long, your program should print the first such line.

 */

#include "console.h"
#include "simpio.h"
#include <fstream>

using namespace std;

const string F_NAME = "Middlemarch.txt";

string printLongest(string fileName);

int main() {
    cout << "The longest line for file \"" << F_NAME << "\" is: " << endl;
    cout << printLongest(F_NAME) << endl;
    return 0;
}

string printLongest(string fileName) {
    ifstream inFile;
    inFile.open(fileName);
    string str;
    int strLenght = 0;
    string longestStr;
    while (getline(inFile, str)) {
        if (str.length() > strLenght) {
            strLenght = str.length();
            longestStr = str;
        }
    }
    return longestStr;

}
