/*
 * File: .cpp
 * --------------
 * 11. Using the functions stringToInteger and integerToString as a model,
 * write the code necessary to implement stringToReal and realToString.
 *
 * 12. Complete the implementation of the simpio.h interface by implementing
 * the functions getReal and getLine.
 */

#include "console.h"
#include <iostream>
#include <sstream>
#include <string>

using namespace std;

string getLine(string str);
int getInteger(string str);
double getReal(string str);

int stringToInteger(string str);
double stringToReal(string str);
string realToString(double real);


int main() {
    string name = getLine("What is your name? ");
    cout << "Hello, " << name << endl;
    int value = getInteger("Enter exponent limit: ");
    cout << "Limit is: " << value << endl;
    double exact = getReal("Enter the PI: ");
    cout << "PI is: " << exact << endl;
    cout << "PI x 2: " << exact * 2 << endl;
    return 0;

}

int stringToInteger(string str) {
    istringstream stream(str);
    int value;
    stream >> value >> ws;
    if (stream.fail() || !stream.eof()) {
        cerr << "stringToInteger: Illegal integer format" << endl;
    }
return value;
}

double stringToReal(string str) {
    istringstream stream(str);
    double value;
    stream >> value >> ws;
    if (stream.fail() || !stream.eof()) {
        cerr << "stringToReal: Illegal integer format" << endl;
    }
return value;

}
string realToString(double real ) {
    return std::to_string(real);
}



string getLine(string str) {
    string line;
    cout << str;
    while (line.length() == 0) {
        cin >> line;
        if (line.length() == 0 || (line.length() == 1 && line[0] == ' ')) cout << "Error: You must enter an input to proceed" << endl;
    }
    return line;
}

int getInteger(string str) {
    int value;
    cout << str;
    cin >> value;
    return value;
}

double getReal(string str) {
    double value;
    string temp;
    cout << str;
    cin >> temp;
    value = std::stod(temp);
    return value;
}
