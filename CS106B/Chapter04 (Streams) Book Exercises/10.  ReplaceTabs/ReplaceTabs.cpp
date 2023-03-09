/*
 * File: BanishLetters.cpp
 * --------------
 * In James Thurber’s children’s story The Wonderful O, the island of Ooroo is invaded by pirates
 * who set out to banish the letter O from the alphabet. Such censorship would be much easier with
 * modern technology. Write a program that asks the user for an input file, an output file, and a
 * string of letters to be eliminated. The program should then copy the input file to the output file,
 * deleting any of the letters that appear in the string of censored letters, no matter whether
 * they appear in uppercase or lowercase form.
 *
 * As an example, suppose that you have a file containing the first few lines of Thurber’s novel, as follows:
 *
 * If you run your program with the input
 *              image
 * it should write the following file:
 *              image
 * If you try to get greedy and banish all the vowels by entering aeiou in response to the prompt,
 * the contents of the output file would be
 *              image
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
