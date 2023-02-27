/*
 * File: Obenglobish.cpp
 * --------------
 * Most people—at least those in English-speaking countries—have played the Pig Latin game
 * at some point in their lives. There are, however, other invented “languages” in which words
 * are created using some simple transformation of English. One such language is called Obenglobish,
 * in which words are created by adding the letters ob before the vowels (a, e, i, o, and u)
 * in an English word. For example, under this rule, the word english gets the letters ob added before
 * the e and the i to form obenglobish, which is how the language gets its name.
 *
 * In official Obenglobish, the ob characters are added only before vowels that are pronounced,
 * which means that a word like game would become gobame rather than gobamobe because the final e is silent.
 * While it is impossible to implement this rule perfectly, you can do a pretty good job by adopting the rule
 * that the ob should be added before every vowel in the English word except
 *
 * • Vowels that follow other vowels
 * • An e that occurs at the end of the word
 *
 * Write a function obenglobish that takes an English word and returns its Obenglobish equivalent, using the translation rule given above. For example, if you used your function with the main program
 *           int main() {
 *               while (true) {
 *               string word = getLine("Enter a word: ");
 *                          if (word == "") break;
 *                          string trans = obenglobish(word);
 *                          cout << word << " -> " << trans << endl;
 *               }
 *           return 0;
 *           }
 */

#include "console.h"
#include "simpio.h"
using namespace std;


string PigLatin(string word);
string lineToPigLatin (string line);
string wordToObenglobish (string word);
int locateVowel(string word, int vp);
bool isVowel (char ch);
string capitalize(string str);

const string SENTINEL = "";

int main() {
    string word = " ";
    cout << "This program translates English to Obenglish. \nIndicate the end of the input with a blank line.. " << endl;
    while (word != SENTINEL) {
        word = getLine("\nEnter English text:");
        cout << word << " -> " << wordToObenglobish(word) << endl;
    }
    return 0;
}


string wordToObenglobish (string word) {
    string result = word;
    int pos = 0;
    int ticker = 0;
    pos = locateVowel(result, pos);
    while (pos != -1) {
        if (!isVowel(result[pos-1])) {
            if (result[pos] == 'e' && result.length() - 1 == pos) pos = -1;
            else {
                result.insert(pos,"ob");
                if (pos + 3 * ticker < result.length() ) pos += 3;
                else pos = -1;
                ticker++;
            }
        }
        else {
            if (pos + 1 < result.length() ) pos++;
            else pos = -1;
        }
        pos = locateVowel(result, pos);
    }
    return capitalize(result);
}


int locateVowel(string word, int vp) {
    for (int i = vp; i < word.length(); i++) {
        if (isVowel(word[i])) return i;
    }
return -1; }


bool isVowel (char ch) {
        switch (ch) {
            case 'A': case 'E': case 'I': case 'O': case 'U':
        case 'a': case 'e': case 'i': case 'o': case 'u':
            return true;
        default:
            return false;
        }
}

string capitalize(string str) {
    int index = 0;
    for (int i = 0; i < str.length(); i++){
        if (index == 0) {
           str[i] = toupper(str[i]);
           index++;
        }
        else {
            str[i] = tolower(str[i]);
            index++;
        }
        if (isspace(str[i+1])) {
            index = -1;
        }
    }
    return str;
}
