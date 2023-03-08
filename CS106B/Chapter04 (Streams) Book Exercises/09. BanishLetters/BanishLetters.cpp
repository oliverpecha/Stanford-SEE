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

void copyStringStreamF2F(ifstream & ifile, ofstream & ofile);
void copyNbanish(string fName, string prohibited);
bool isCensored(char ch, string prohibited);
string addAllCases(string str);
string censor(string str, string prohibited);

const string CENSORED = "AeiOu";

int main () {
    string censoredAll = addAllCases(CENSORED);
    copyNbanish("TheWonderfulO.txt", censoredAll);
    return 0;
}


void copyNbanish(string fName, string prohibited) {
    ifstream ifile(fName);
    ofstream ofile(censor(fName, prohibited));
    string buffer;
    if (ifile.is_open() && ofile.is_open()) {
        while (getline(ifile, buffer)) {
            ofile << censor(buffer, prohibited) << endl;
        }
        ifile.close();
        ofile.close();
    }
    else cout << "Unable to open files";
}

string censor(string str, string prohibited){
    string result;
    for (int i = 0; i < str.length(); i++) {
        if (!isCensored(str[i], prohibited)) result += str[i];
    }
    return result;
}

bool isCensored(char ch, string prohibited){
    for (int i = 0; i < prohibited.length(); i++) {
        if (prohibited[i] == ch) return true;
    }
    return false;
}

string addAllCases(string str){
    string otherCase = "";
    for (int i = 0; i < str.length(); i++){
        if (str[i] >= 'a' && str[i] <= 'z') otherCase += char(str[i] - 32);
        if (str[i] >= 'A' && str[i] <= 'Z') otherCase += char(str[i] + 32);
    }
    return str + otherCase;
}
