/*
 * File: ExpressionCalculator.cpp
 * --------------
 * 11. Write a program that implements a simple arithmetic calculator.
 * Input to the calculator consists of lines composed of numbers
 * (either integers or reals) combinedt ogether using the arithmetic
 * operators +, -, *, and /.
 *
 * Foreachline of input, your program should display the result of applying
 * the operators from left to right. You should use the token scanner to
 * read the terms and operators and set up the scanner so that it ignores
 * any whitespace characters. Your program should exit when the user
 * enters a blank line. A sample run of your program might look like this:
 *
 *      image
 *
 * The last line in this sample run is the arithmetic problem the
 * Mathemagician gives to Milo in Norton Juster’s children’s story,
 * The Phantom Tollbooth.
 *
 *
 * 12. Extend the program you wrote for the preceding exercise so that the
 * terms in the expressions can also be variable names assigned earlier in
 * the session by entering simple assignment statements as shown in the
 * following sample run:
 *
 *      image
 */

#include "console.h"
#include "simpio.h"
#include "tokenscanner.h"
#include "stack.h"
#include "map.h"
#include <string>
#include <iomanip>
using namespace std;

bool calculatorFindsResult(string str);
bool isOperator(string token);
void decimalJoin();
double calculateOperator(double d1, double d2, char opera);
void peek2operate();
void validateVariable(string token);



TokenScanner buffer;
Stack<double> processor;
Map<string, double> recorder;
string token;
double displayResult;
int maxPrecision;

const string INPUT_ERROR = "Input can't be processed, review order and content";



int main() {
    string str;
    while (str != " ") {
        str = getLine(">");
        if (str.size() > 0 && str != " ") {
            processor.clear();
            if (calculatorFindsResult(str)) cout << displayResult << endl;
        }
    }
    cout << "Program ended" << endl;
    return 0;
}

bool calculatorFindsResult(string str) {
    buffer.setInput(str);
    buffer.ignoreWhitespace();
    maxPrecision = 0;
    while (buffer.hasMoreTokens()) {
        token = buffer.nextToken();
        if (isalpha(token[0]))
            validateVariable(token);
        else if (!isOperator(token) && token[0] != '.')
            processor.push(std::stod(token));
        else if (token.size() < 2 && token[0] == '.')
            decimalJoin();
        else if (isOperator(token))
            peek2operate();
        cout << processor << endl;
    }
    if (processor.size() > 0) {
        displayResult = processor.pop();
        return true;
    }
    else return false;
}

void validateVariable(string token){
    if (recorder.containsKey(token)) {
        cout << recorder.get(token) << endl;
    }
    else if (buffer.hasMoreTokens() && buffer.peekToken() == "=") {
        buffer.skipToken();
        recorder.put(token, std::stod(buffer.nextToken()));
    }
    else cerr << INPUT_ERROR << endl;

}


void peek2operate() {
    char opera = token[0];
    if (buffer.hasMoreTokens()) {
        token = buffer.nextToken();
        processor.push(std::stod(token));
        if (buffer.hasMoreTokens()) {
            string peek = buffer.nextToken();
            if (peek.size() < 2 && peek[0] == '.') {
                decimalJoin();
            }
            else buffer.reinsertToken(peek);
        }
        double d2 =  processor.pop();
        processor.push(calculateOperator(processor.pop(), d2, opera));
    }
    else cerr << INPUT_ERROR << endl;
}
void decimalJoin() {
    if (buffer.hasMoreTokens()) {
        token = buffer.nextToken();
        double helper = std::stod(token) / pow(10,token.size());
        if (token.size() > maxPrecision) maxPrecision = token.size();
        double temp = processor.pop();
        processor.push(temp + helper);
    }
    else cerr << INPUT_ERROR << endl;
}

double calculateOperator(double d1, double d2, char opera) {
    switch (opera) {
        case '-':
        return d1 - d2;
        case '*': return d1 * d2;
        case '/': return d1 / d2;
        default: return d1 + d2;
    }
}

bool isOperator(string token) {
    switch (token[0]) {
        case '+': return true;
        case '-': return true;
        case '*': return true;
        case '/': return true;
    }
    return false;
}
