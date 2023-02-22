/*
 * File: endsWith.cpp
 * --------------
 * Implement the function endsWith(str,suffix), which returns true if str ends with suffix.
 * Like its startsWith counterpart, the endsWith function should allow the second argument to be either a string or a character.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

bool endsWith(string str, string sufix);

int main() {
    string word = getLine("Enter a word");
    string sufix = getLine("Enter a sufix");

    if (endsWith(word, sufix)) {
        cout << word << " does end with " << sufix << endl;
    }
    else cout << word << " doesn't end with " << sufix << endl;
    return 0;
}


bool endsWith(string str, string sufix) {
          if (str.length() < sufix.length()) return false;
          for (int i = str.length() -1 ; i > str.length() - sufix.length(); i--) {
             if (str[i] != sufix[i - str.length() + sufix.length()]) return false;
          }
          return true;
       }

