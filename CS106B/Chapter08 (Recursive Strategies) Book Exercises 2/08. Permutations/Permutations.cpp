/*
 * File: main.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
#include "set.h"

using namespace std;

Set<string> generatePermutations(string str);
Set<string> generatePermutationsBis(string str);


int main() {
    //string name = getLine("Enter starting word: ");
    string name = "happy";
    int count = 0;
    Set<string> perms = generatePermutations(name);
    for (string candidate : perms) {
        count++;
        cout << "      " << candidate << ". " << candidate.length() << endl;
    }
    cout << "      count: " << count << ".\n" << endl;
    count = 0;
    perms = generatePermutationsBis(name);
    for (string candidate : perms) {
        count++;
        cout << "      " << candidate << ". " << candidate.length() << endl;
    }
    cout << "      count: " << count << "." << endl;
    return 0;
}


Set<string> generatePermutationsBis(string str) {
    Set<string> result;
    if (str.length() == 0) {
        result += str;
    } else {
            char ch = str[0];
            string rest = str.substr(1);
            for (string s : generatePermutations(rest)) {
                for (int var = 0; var <= s.length(); ++var) {
                    result += s.substr(0, var) + ch + s.substr(var);
                }
            }
    }
    return result;
}

Set<string> generatePermutations(string str) {
    Set<string> result;
    if (str.length() == 0) {
        result += str;
    } else {
        for (int i = 0; i < str.length(); i++) {
            char ch = str[i];
            string rest = str.substr(0, i) + str.substr(i + 1);
            for (string s : generatePermutations(rest)) {
                result += ch + s;
            }
        }
    }
    return result;
}
