/*
 * File: Bracketing.cpp
 * --------------
 * Write a program that checks whether the bracketing operators (parentheses, brackets, and curly braces)
 * in a string are properly matched. As an example of proper matching, consider the string
 *
 *        { s = 2 * (a[2] + 3); x = (1 + (2)); }
 *
 * If you go through the string carefully, you discover that all the bracketing operators are correctly nested,
 * with each open parenthesis matched by a close parenthesis, each open bracket matched by a close bracket,
 * and so on. On the other hand, the following strings are all unbalanced for the reasons indicated:
 *
 *   -> ((h)()()()()()()[])
 *
 *      (([]) The line is missing a close parenthesis.                      <- odd # of brackets
 *      )( The close parenthesis comes before the open parenthesis.         <- starts with a closer
 *      {(}) The bracketing operators are improperly nested.                <- doesn't end with a curly
 *
 *   -> {();()})
 *
 *
 */

#include "console.h"
#include "simpio.h"
#include "stack.h"

using namespace std;


bool bracketCheck(string & candidate);
bool isBracket(char letter);
bool isCloseBracket(char letter);
bool isOpenBracket(char letter);
bool curlyEnds(string candidate);
bool vecStrQualifing(string candidate);
bool match(char current, char next);

void sliceByCurly(Vector<string> & candidates);
void splitBySemiColon(Vector<string> & candidates);

void fillStraight(Stack<char> & headBrackets, string candidate);
void fillStackOfCandidates(Stack<char> & tailBrackets, string candidate);

void printVecCandidates(Vector<string> & candidates, int ticker);
void removeEmpty(Vector<string> & candidates);


int main() {
    string candidate = "{ a = (1 * (a[1] + 1)); b = (2 * 2) + (b [2] + 2); } { c = (3 + (3)); } { d = 4 * (d[4] + 4); }";
    cout << candidate << endl;
    if (bracketCheck(candidate))  cout << "Is properly formatted" << endl;
    else cout << "Is NOT properly formatted" << endl;
    return 0;
}


bool vecStrQualifing(string candidate){
    Stack<char> bracketStream;
    Stack<char> bracketBuffer;
    fillStackOfCandidates(bracketStream, candidate);
    char current;
    char next;
    // while brackets to be compared is streaming
    while (!bracketStream.isEmpty()) {
        current = bracketStream.pop();
        // protection in case can't peek at stack due to emptiness
        if (!bracketStream.isEmpty()) {
            next = bracketStream.peek();
            // current open bracket to next matches becuase it is an equivalent closing one.
            // thus, current and next will be poped
            if (isOpenBracket(current) && match(current, next)) {
                bracketStream.pop();
            }
            // current doesn't match the next peeked item, still is an open bracket, thus it could be that will match other bracket in subsequent positions
            // thus it will be pushed into a bufer stack to be evaluated once closing braclets that didn't match directly are found
            else if (isOpenBracket(current)) {
               bracketBuffer.push(current);
            }
            //current is a closing bracket that was not poped at a first compare pass and buffer is filled with other brackets to evaluate against
            else if (!bracketBuffer.isEmpty() && match(bracketBuffer.peek(), current)) {
                bracketBuffer.pop();
            }
            //if doesn't match at first pass or is sucessfully compared against the buffer candidate must not comply
            else return false;
        }
        // Last streamed candidate can only be evaluated against previous brackets that didn't match and were added to the buffer for later evaluation
        else if (!bracketBuffer.isEmpty() && match(bracketBuffer.peek(), current)) {
            bracketBuffer.pop();
        }
        // If didn't hit any of previous cases string must not comply
        else return false;
    }
    // at this point, if there are still items in the buffer, candidate bracket and string can't match/compy
    if (!bracketBuffer.isEmpty()) return false;
    // once cycle reaches here, means canidate string actually complies
    return true;
}

void fillStackOfCandidates(Stack<char> & tailBrackets, string candidate) {
    for (int var = candidate.length() - 1; var > 0; var--) {
        if (isBracket(candidate[var])) tailBrackets.push(candidate[var]);
    }
}

void sliceByCurly(Vector<string> & candidates){
    int start = candidates[0].find('{');
    while (start >= 0) {
        int end = candidates[0].find('}');
        if (end == -1) candidates.clear();
        else {
            candidates.add(candidates[0].substr(start + 1, end-start - 1));
            candidates[0].erase(start, end-start + 1);
            if (candidates[0].length() == 0) candidates.remove(0);
        }
        start = candidates[0].find('{');
    }
    removeEmpty(candidates);
}

void splitBySemiColon(Vector<string> & candidates) {
    int start = 0;
    int end = 0;
    for (int vec = 0; vec < candidates.size(); ++vec) {
        end = candidates[vec].find(';', start);
        while (end >= 0) {
            string temp = candidates[vec].substr(start, end + 1);
            if (temp.length() > 1) {
                candidates.insert(vec, temp);
                candidates[vec + 1].erase(0, end + 1);
            }
            end = candidates[vec].find(';', end + 1);
        }
    }
    removeEmpty(candidates);
}


bool curlyEnds(string candidate) {
    for (int var = candidate.length() - 1; var > 0; var--) {
        cout << "curlyEnds is evaluating: " << candidate[var] << endl;
        if (isBracket(candidate[var])) {
             if (candidate[var] == '}') return true;
             else return false;
        }
    }
    return false;
}

bool bracketCheck(string & input) {
    Vector<string> candidates {input};
    sliceByCurly(candidates);
    splitBySemiColon(candidates);
    for (int i = 0; i < candidates.size(); i++) {
        if (!vecStrQualifing(candidates[i])) return false;
    }
    return true;
}


bool match(char current, char next){
    if (current == '(' && next == ')') return true;
    if (current == '[' && next == ']') return true;
    else return false;
}

bool isBracket(char letter) {
    switch (letter) {
        case '{':
        case '(':
        case '[':
        case '}':
        case ')':
        case ']':return true;
        default: return false;
    }
}

bool isOpenBracket(char letter) {
    switch (letter) {
        case '{':
        case '(':
        case '[':return true;
        default: return false;
    }
}

bool isCloseBracket(char letter) {
    switch (letter) {
        case '}':
        case ')':
        case ']':return true;
        default: return false;
    }
}


void removeEmpty(Vector<string> & candidates){
    for (int var = 0; var < candidates.size(); ++var) {
        int ticker = 0;
        for (int b = 0; b < candidates[var].size(); ++b) {
            if (candidates[var][b] == ' ') ticker++;
        }
        if (ticker == candidates[var].size()) candidates.remove(var);

    }
}

void printVecCandidates(Vector<string> & candidates, int ticker) {
    cout << "\n";
    for (int var = 0; var < candidates.size(); ++var) {
        cout << ticker << ". <<" << candidates[var] << ">> it's lenght: " << candidates[var].size() << endl;
    }
}
