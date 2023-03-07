/*
 * File: Greek.cpp
 * --------------
 * On occasion, publishers find it useful to evaluate layouts and stylistic designs
 * without being distracted by the actual words. To do so, they sometimes typeset sample
 * pages in such a way that all of the original letters are replaced with random letters.
 * The resulting text has the spacing and punctuation structure of the original, but no longer
 * conveys any meaning that might get in the way of the design. The publishing term for
 * text that has been replaced in this way is greek, presumably after the old saying
 * “It’s all Greek to me,” which is itself adapted from a line from Julius Caesar.
 *
 * Write a program that reads characters from an input file and displays them on the console
 * after making the appropriate random substitutions. Your program should replace every uppercase
 * character in the input by a random uppercase character and every lowercase character by a random
 * lowercase one. Nonalphabetic characters should remain unchanged. For example, if the input file
 * Troilus.txt contains the text from Troilus and Cressida,
 *
 * your program should generate output that looks something like this:
 *
 */

#include "console.h"
#include "simpio.h"
#include <fstream>
#include "random.h"
//#include <string>
//#include <sstream>
using namespace std;

void cypherNprint(string fName);

const string I_FILE = "Troilus.txt";

int main() {
    cout << "Input file is: " << I_FILE << endl;
    cypherNprint(I_FILE);
    return 0;
}

void cypherNprint(string fName) {
    ifstream infile;
    infile.open(fName);
    int ch;
    while ((ch = infile.get()) != EOF) {
        if (ch >= 'a' && ch <= 'z') ch = randomInteger('a', 'z');
        if (ch >= 'A' && ch <= 'Z') ch = randomInteger('A', 'Z');
        cout << char(ch);
    }

}
