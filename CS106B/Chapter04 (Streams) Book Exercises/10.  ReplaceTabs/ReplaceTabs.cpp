/*
 * File: BanishLetters.cpp
 * --------------
 * Some files use tab characters to align data into columns. Doing so, however, can cause problems
 * for applications that are unable to work directly with tabs. For these applications, it is
 * useful to have access to a program that replaces tabs in an input file with the number of spaces
 * required to reach the next tab stop. In programming, tab stops are usually set at every eight columns.
 *
 * For example, suppose that the input file contains a line of the form
 * where the   symbol represents the space taken up by a tab, which differs depending on its position
 * in the line. If the tab stops are set every eight spaces, the first tab character must be replaced by
 * five spaces and the second tab character by three.
 *
 * Write a program that copies an input file to an output file, replacing all tab characters by the appropriate number of spaces.
 */

#include "console.h"
#include "simpio.h"
#include <iostream>
#include <fstream>
#include <sstream>

using namespace std;

void copyNReplaceTabs();
string replaceTabs(string str);
string charFill(int pos, bool test);

const int   TAB_WIDTH = 9;
const char  TAB_CAR = ' ';
const bool  TAB_TEST = false;

int main () {
    copyNReplaceTabs();
    return 0;
}

void copyNReplaceTabs() {
    ifstream ifile("Three_columns-original.txt");
    ofstream ofile("Three_columns_edited.txt");
    string buffer;
    if (ifile.is_open() && ofile.is_open()) {
        while (getline(ifile, buffer)) {
            cout << "\n::::Line buffer:::: " << buffer << endl;
            ofile << replaceTabs(buffer) << endl;
        }
        ifile.close();
        ofile.close();
    }
    else cout << "Unable to open files";
}

string replaceTabs(string buffer) {
    int pos = buffer.find('\t');
    int roll = 0;
    if (pos > -1) {
        while (pos != -1) {
            //(pos, n, str2) Replaces the n characters in str starting at pos with a copy of str2
            cout << "= current buffer: " << buffer << endl;
            cout << "  pos entry: " << pos << endl;
            string filling = charFill(TAB_WIDTH - pos + roll, TAB_TEST);
            if (pos - roll < TAB_WIDTH) {
                cout << "  roll: " << roll << ", pos: " << pos << ", filling: " <<  filling << ", lenght: " << filling.length() <<endl;
                buffer.replace(pos, 1, filling);
                cout << "  / edited buffer: " << buffer << endl;
            }
            roll = pos + filling.length();
            pos = buffer.find('\t', roll);
            cout << "  pos exit: " << pos << ", roll: " << roll << endl;
        }
    }
    return buffer;
}

string charFill(int times, bool test){
    string result;
    for (int i = 0; i < times; i++){
        if (test) {
            if (i == 0) result += "_";
            else result += to_string(i);
        }
        else result += TAB_CAR;
    }
    return result;
}
