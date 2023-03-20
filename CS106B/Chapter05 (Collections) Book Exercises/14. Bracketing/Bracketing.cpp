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
bool qualifies(string candidate);

Vector<string> onlyQualifying(string candidate);

void sliceByCurly(Vector<string> & candidates);
void splitBySemiColon(Vector<string> & candidates);

void fillStraight(Stack<char> & headBrackets, string candidate);
void fillReverse(Stack<char> & tailBrackets, string candidate);

void printVecCandidates(Vector<string> & candidates, int ticker);
void removeEmpty(Vector<string> & candidates);



/*
{ ( [2] + 3); x = (1 + (2
} ) )

/////////

{
}

(
)
[
]
(1 + (2))



////////////

(()();[]) OK
{();()}) OK
(((;)))
{();} {;}
H (()();[])
T )][;)()((

H (((;)))
T )));(((

////////////

<{>([]); <> [];()([]);<}> <> {(());}


*/

int main() {
    //string candidate = "{ s = 2 * (a[2] + 3); r = (4 * 3) + (a [2] + 1);}{ x = (1 + (2)); }";
    string candidate = "{ a = 1 * (a[1] + 1); b = (2 * 2) + (b [2] + 2); } { c = (3 + (3)); } { d = 4 * (d[4] + 4); }";

    cout << candidate << endl;
/*    Vector<string> fuckery {"one", "two"};
    cout << "fuckery: " << fuckery << ", it's lenght: " << fuckery.size() << endl;
    fuckery.remove(0);
    cout << "fuckery: " << fuckery << ", it's lenght: " << fuckery.size() << endl;
*/
    if (bracketCheck(candidate))  cout << "Is properly formatted" << endl;
    else cout << "Is NOT properly formatted" << endl;
    return 0;
}

bool bracketCheck(string & input) {
    //Vector<string> candidates = onlyQualifying(input);
    Vector<string> candidates {input};
    sliceByCurly(candidates);
    splitBySemiColon(candidates);

    return true;
}

void sliceByCurly(Vector<string> & candidates){
    int ticker = 0;
    int start = candidates[0].find('{');
    while (start >= 0) {
        int end = candidates[0].find('}');
        if (end == -1) candidates.clear();
        else {
            candidates.add(candidates[0].substr(start + 1, end-start - 1));
            candidates[0].erase(start, end-start + 1);
            if (candidates[0].length() == 0) candidates.remove(0);
            //printVecCandidates(candidates, ticker);
            ticker++;
        }
        start = candidates[0].find('{');
    }
    removeEmpty(candidates);
    printVecCandidates(candidates, ticker);
}



void splitBySemiColon(Vector<string> & candidates) {
    int start = 0;
    int end = 0;

    for (int vec = 0; vec < candidates.size(); ++vec) {
        //while (start >= 0) {
            end = candidates[vec].find(';', start);
            cout << "from vec: " << vec << ", end: " << end << endl;
            while (end >= 0) {
                string temp = candidates[vec].substr(start, end + 1); // <-- could be removed
                if (temp.length() > 1) {

                    candidates.insert(vec, temp);
                    cout << "will be removed from vec: " << vec + 1 << candidates[vec] << endl;
                    candidates[vec + 1].erase(0, end + 1);
                }
                end = candidates[vec].find(';', end);
                //start = end;

                /*
                string temp = candidates[vec].substr(0, end + 1);
                if (temp.length() > 1) {
                    candidates.insert(0, temp);
                    candidates[1].erase(0, end + 1);
                    if (!qualifies(candidates[vec])) candidates.remove(vec); // <---- check
                    else {
                        cout << "will be removed from 0: " << candidates[0] << endl;
                        candidates.remove(0);
                        if (candidates[vec].length() == 0) candidates.remove(0);
                        cout << "whats in 0: " << candidates[vec] << ", it's lenght: " << candidates[0].size() << endl;
                    }
                }
                cout << "2 all candidates: " << candidates << ", it's lenght: " << candidates.size() << endl;
                end = candidates[vec].find(';'); */
            }
        //}
    }
    printVecCandidates(candidates, 99);

}


bool qualifies(string candidate){
    Stack<char> straightBrackets;
    Stack<char> reversedBrackets;
    fillStraight(straightBrackets, candidate);
    fillReverse(reversedBrackets, candidate);
    cout << "\nfake qualification = " << candidate << endl;
    //cout << "print straightBrackets = " << straightBrackets << endl;
    //cout << "print reversedBrackets = " << reversedBrackets << endl;
    return true; // < -------------------------------------------------------- fix
}

Vector<string> onlyQualifying(string candidate){
    Vector<string> result;
    string buffer;
    for (int var = 0; var < candidate.length(); var++) {
        if (isBracket(candidate[var]) || candidate[var] == ';') buffer += candidate[var];
    }
    result.add(buffer);
    return result;
}
void fillStraight(Stack<char> & headBrackets, string candidate) {
    for (int var = 0; var < candidate.length(); var++) {
        if (isBracket(candidate[var]) || candidate[var] == ';') headBrackets.push(candidate[var]);
    }
}

void fillReverse(Stack<char> & tailBrackets, string candidate) {
    for (int var = candidate.length() - 1; var > 0; var--) {
        if (isBracket(candidate[var]) || candidate[var] == ';') tailBrackets.push(candidate[var]);
    }
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

void printVecCandidates(Vector<string> & candidates, int ticker) {
    cout << "\n";
    for (int var = 0; var < candidates.size(); ++var) {
        cout << ticker << ". <<" << candidates[var] << ">> it's lenght: " << candidates[var].size() << endl;
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
