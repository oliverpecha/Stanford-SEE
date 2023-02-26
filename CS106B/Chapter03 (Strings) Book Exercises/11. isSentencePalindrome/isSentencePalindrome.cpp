/*
 * File: isSentencePalindrome.cpp
 * --------------
 * The concept of a palindrome is often extended to full sentences by ignoring punctuation
 * and differences in the case of letters. For example, the sentence Madam, I’m Adam. is a sentence palindrome,
 * because if you only look at the letters and ignore any distinction between uppercase and lowercase letters,
 * it reads identically backward and forward.
 *
 * Write a predicate function isSentencePalindrome(str) that returns true if the string str fits this definition
 * of a sentence palindrome. For example, you should be able to use your function to write a main program capable
 * of producing the following sample run:
 *
 */

#include "console.h"
#include "simpio.h"
using namespace std;


const string SENTINEL = "";

bool isSentencePalindrome(string str);

int main() {
    string sentence = " ";
    cout << "This program tests for sentence palindromes. \nIndicate the end of the input with a blank line.. " << endl;
    while (sentence != SENTINEL) {
        sentence = getLine("\nEnter a sentence:");
        if (isSentencePalindrome(sentence)) cout << "This sentence is a palindrome!" << sentence << endl;
        else cout << "This sentence is not a palindrome :(" << endl;
    }
    return 0;
}

bool isSentencePalindrome(string str) {
    int length = str.length();
    int z = length-1;
    for (int a = 0; a < length/2; a++){
        cout << "*** a: " << a << " is " << str[a] << endl;
        cout << "*** z1: " << z << " is " << str[z] << endl;

        while (!isalpha(str[z])) {
            cout << "*** z2: " << z << " is " << str[z] << endl;
            z--;
            cout << "*** z3: " << z << " is " << str[z] << "\n" << endl;

        }
        if (isalpha(str[a]) && str[a] != str[z]) {
            cout << "*pooong*** a: " << a << " is " << str[a] << "*** z1: " << z << " is " << str[z] << endl;
            return false;
        }

    }
    return true;
}

string capitalize(string str) {
    for (int i = 0; i < str.length(); i++){
            str[i] = tolower(str[i]);
    }
    return str;
}
