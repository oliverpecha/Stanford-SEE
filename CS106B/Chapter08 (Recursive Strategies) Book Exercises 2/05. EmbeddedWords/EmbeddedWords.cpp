/*
 * File: EmbeddedWords.cpp
 * --------------
 * Write a program EmbeddedWords that finds all English words that can be formed by taking some subset of
 * letters in order from a given starting word. For example, given the starting word happy, you can certainly
 * produce the words a, ha, hap, and happy, in which the letters appear consecutively. You can also produce
 * the words hay and ay, because those letters appear in happy in the correct left-to-right order.
 * You cannot, however, produce the words pa or pap because the letters—even though they appear in
 * the word—don’t appear in the correct order. A sample run of the program might look like this:
 */

#include "console.h"
#include "simpio.h"
#include "lexicon.h"
#include "set.h"

using namespace std;

void findEnbeddedWords(Lexicon english, string name);
Set<string> generatePermutations(string str);
Set<string> combinator(string str);



int main() {
    Lexicon english("Englishwords.txt");
    string name = getLine("Enter starting word: ");
    //string name = "happy";
    findEnbeddedWords(english, name);
    return 0;
}

void findEnbeddedWords(Lexicon english, string name){
    Set<string> candidateSet;
    candidateSet = combinator(name);
    cout << candidateSet << endl;
    for (string candidate : candidateSet) {
        if (english.contains(candidate)) {
            cout << "      " << candidate << " is an english word" << endl;
        }
    }
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

Set<string>  combinator(string str) {
    Set<string> result;
   if (str.length() == 0) result += str;
   else {
       for (int var = 0; var < str.length(); ++var) {
           string tip = str.substr(var,1);
           string head = str.substr(0, str.length() - var);
           string tale = str.substr(var+1);
          //cout << "var: " << var << " tip: " << tip /*<< " head: " << head << ". element: " <<  element */<< " tale: " << tale << endl;
            result += head;
            result += tip;
           for (string nTales : combinator(tale)) {
             //cout << "nTales: " << nTales << endl;
               result += tip + nTales;
           }
       }
   }
    return result;
}

