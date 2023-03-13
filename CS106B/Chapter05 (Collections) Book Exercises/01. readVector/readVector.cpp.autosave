/*
 * File: readVector.cpp
 * --------------
 * Write the overloaded functions
 *
 *          void readVector(istream & is, Vector<int> & vec);
 *          void readVector(istream & is, Vector<double> & vec);
 *          void readVector(istream & is, Vector<string> & vec);
 *
 * each of which reads lines from the input stream specified by is into the vector vec.
 * In the input stream, each element of the vector appears on a line of its own.
 * The function should read elements until it encounters a blank line or the end of the file.
 *
 * To illustrate the operation of this function, suppose that you have the data file and that
 * you have opened infile as an ifstream on that file. In addition, suppose that you have
 * declared the variable roots as follows:
 *            Vector<double> roots;
 *
 * The first call to readVector(infile, roots) should initialize roots so that it contains
 * the four elements shown at the beginning of the file. The second call should change the
 * value of roots so that it contains the eight elements shown at the end of the file.
 * Calling readVector a third time should set roots to an empty vector.
 */

#include "console.h"
#include "simpio.h"
#include "vector.h"
#include <fstream>
#include <string>


using namespace std;

void readVector(istream & is, Vector<int> & vec);
void readVector(istream & is, Vector<double> & vec);
void readVector(istream & is, Vector<string> & vec);



int main() {
    Vector<double> roots;
    Vector<string> sequence;
    string fileNam = "SquareAndCubeRoots.txt";
    ifstream is(fileNam);
    string input = "";
    cout << "This program will look for entries in file \"" << fileNam << "\" "<< endl;
    if (is.is_open()) {
        while (input != "Q") {
            input = getLine("Enter C to continue or Q to quit");
            if (input == "C") {
                readVector(is, roots);
            }
        }
    }
    else cout << "Unable to open files";
    cout << "Program ended" << endl;
    return 0;
}

void readVector(istream & is, Vector<double> & vec) {
    cout << "\n" << endl;
    string buffer;
    int count = 0;
    if (!is) cout << "file of doubles ended" << endl;;
    while (getline(is, buffer)) {
       if (buffer.length() < 1) {
           vec.clear();
           return;
       }
       vec.add(std::stod(buffer));
       cout << vec[count] << endl;
       count++;
    }
}

void readVector(istream & is, Vector<string> & vec) {
    cout << "\n" << endl;
    string buffer;
    int count = 0;
    if (!is) cout << "file of strings ended" << endl;;
    while (getline(is, buffer)) {
       if (buffer.length() < 1) {
           vec.clear();
           return;
       }
       vec.add(buffer);
       cout << vec[count] << endl;
       count++;
    }
}
