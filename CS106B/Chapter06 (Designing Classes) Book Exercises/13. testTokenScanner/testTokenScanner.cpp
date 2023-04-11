/*
 * File: main.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
#include "tokenscanner.h"
#include "console.h"
#include "vector.h"
#include "random.h"
#include <string>


using namespace std;

string printVector(Vector<double> vector, bool randomness);
void fillVector(Vector<double> & vector);
TokenScanner printbuffer(TokenScanner buffer);
double str2anyDouble(string str);

const string lotsOfScientificNotation = "3.14159e+000 2006 \"Remember this\" 1e-010 3.450e1 4.000e-3 1.23005e2 1.46e5 1.46000001e5 \'this too'8e-10 3.45000e4 3.45e4";
const double RANDOM_RATIO = .5;


int main() {
    Vector<double> dTester;
    Vector<string> sContainer;
    string one = "3.14159e+000";
    //TokenScanner buffer(oldE);
    TokenScanner buffer(one);

    //fillVector(dTester);
    //string input = printVector(dTester, false);
    buffer.setInput(lotsOfScientificNotation);
    buffer.ignorePunctuation();
    buffer.ignoreWhitespace();
    //buffer.ignoreNumbers();
    buffer.scanNumbers();
    buffer.scanStrings();
    cout << endl;
    cout << endl;
    //cout << "P. input: " << input << endl;
    cout << endl;
    cout << endl;

    while  (buffer.hasMoreTokens()){
        cout << "P. buffer: " << buffer.nextToken() << endl;
    }

    return 0;
}


double str2anyDouble(string str){
    string sFinal;
    int pos = 0;
    if (isnumber(str[pos])) {
        sFinal += str[pos];
        pos++;
    }
    return std::stod(sFinal);
}

void fillVector(Vector<double> & vector){
    //https://cplusplus.com/reference/ios/scientific/
        vector.add(3.14159e+000);
        vector.add(2006);
        vector.add(1e-010);
    //https://www.learncpp.com/cpp-tutorial/introduction-to-scientific-notation/#:~:text=For%20example%2C%201.2%20x%2010%E2%81%B4,be%20written%20as%205.9736e24%20.
        vector.add(3.450e1);
        vector.add(4.000e-3);
        vector.add(1.23005e2);
        vector.add(1.46e5);
        vector.add(1.46000001e5);
        vector.add(8e-10);
        vector.add(3.45000e4);
        vector.add(3.45e4);
}

string printVector(Vector<double> vector, bool randomness){
    string result;

    for (int var = 0; var < vector.size(); ++var) {
        if (randomness) {
            if (randomChance(RANDOM_RATIO)) {
                cout << "scientific: " << scientific << vector.get(var) << endl;
            } else {
                cout << "fixed:      " << fixed << vector.get(var) << endl;
            }
        } else {
            result += " " + std::to_string(vector.get(var));

            cout << "original:   " << vector.get(var) << endl;
            cout << "scientific: " << scientific << vector.get(var) << endl;
            cout << "fixed:      " << fixed << vector.get(var) << endl;
        }
        cout << endl;
    }
    return result;

}

TokenScanner printbuffer(TokenScanner buffer) {
    cout << "p. buffer: " << buffer.peekToken() << endl;
    TokenScanner newBufer;
    string helper;
    while (buffer.hasMoreTokens()) {
        helper = buffer.nextToken();
        cout << helper << endl;
        newBufer.reinsertToken(helper);
    }
    cout << endl;
    cout << endl;
    return newBufer;
}
