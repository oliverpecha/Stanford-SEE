/*
 * File: main.cpp
 * --------------
 * Section 3.6 defines the function isPalindrome that checks whether a word reads
 * identically forward and backward. Use that function together with the English
 * lexicon to print out a list of all words that are palindromes.

 */

#include "console.h"
#include "simpio.h"
#include "lexicon.h"

using namespace std;


bool isPalindrome(string str);

int main() {
    Lexicon english ("EnglishWords.txt");
    Map<int, int> dataCount{};
    for (string stream : english){
        if (isPalindrome(stream)) {
        cout << stream << endl;
        }
    }
    return 0;
}

bool isPalindrome(string str) {
   int n = str.length();
   for (int i = 0; i < n / 2; i++) {
      if (str[i] != str[n - i - 1]) return false;
   }
   return true;
}
