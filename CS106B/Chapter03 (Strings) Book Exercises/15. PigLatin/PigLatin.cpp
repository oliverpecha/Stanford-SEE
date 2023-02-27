/*
 * File: PigLatin.cpp
 * --------------
 * As written, the PigLatin program in Figure 3-2 behaves oddly if you enter a string
 * that includes words beginning with an uppercase letter. For example, if you were
 * to capitalize the first word in the sentence and the name of the Pig Latin language,
 * you would see the following output:
 *
 * Rewrite the wordToPigLatin function so that any word that begins with a capital letter
 * in the English line still begins with a capital letter in Pig Latin. Thus, after making
 * your changes in the program, the output should look like this:
 *
 */

#include "console.h"
#include "simpio.h"
using namespace std;


string PigLatin(string word);
string lineToPigLatin (string line);
string wordToPigLatin (string word);
int findFirstVowel(string word);
bool isVowel (char ch);
string capitalize(string str);

const string SENTINEL = "";

int main() {
    string sentence = " ";
    cout << "This program translates Englisg to PigLatin. \nIndicate the end of the input with a blank line.. " << endl;
    while (sentence != SENTINEL) {
        sentence = getLine("\nEnter English text:");
        cout << "PigLatin output: " << lineToPigLatin(sentence) << "." << endl;
    }
    return 0;
}

/*
 * Function: PigLatin
 * Usage: translation = PigLatin(word);
 * ------------------------------------
 * This function translates a word from English to Pig Latin using
 * the rules specified in Chapter 3.  The translated word is
 * returned as the value of the function.

string PigLatin(string word) {
    int vp = findFirstVowel(word);
    if (vp == -1) {
        return word;
    } else if (vp == 0) {
        return word + "way";
    } else {
        string head = word.substr(0, vp);
        string tail = word.substr(vp);
        return tail + head + "ay";
    }
}
 */






/*
* Function: lineToPigLatin
* Usage: string translation = lineToPigLatin (line);
* --------------------------------
* Translates each word in the line to Pig Latin, leaving all other
* characters unchanged. The variable start keeps track of the index
* position at which the current word begins. As a special case,
* the code sets start to -1 to indicate that the beginning of the
* current word has not yet been encountered.
*/
string lineToPigLatin (string line) {
    string result;
    int start = -1;
    for (int i = 0; i < line.length(); i++) {
        char ch = line[i];
        if (isalpha (ch)) {
            if (start == -1) start = i;
        } else {
            if (start >= 0) {
                result += wordToPigLatin(line.substr(start, i - start));
                start = -1;
            }
            result += ch;
            }
    }
    if (start >= 0) result += wordToPigLatin (line.substr(start));
    return result;
}

/*
* Function: wordToPigLatin
* Usage: string translation = wordToPigLatin (word);
* --------------------------------
* This function translates a word from English to Pig Latin using
* the rules specified in the text. The translated word is
* returned as the value of the function.
*/

string wordToPigLatin (string word) {
    int vp = findFirstVowel(word);
    string result;
    if (vp == -1) {
        result = word;
    } else if (vp == 0) {
        result = word + "way";
    } else {
        string head = word.substr(0, vp);
        string tail = word.substr(vp);
        result = tail + head + "ay";
    }
    return capitalize(result);
}


/*
 * Function: FindFirstVowel
 * Usage: k = FindFirstVowel(word);
 * --------------------------------
 * This function returns the index position of the first vowel
 * in word.  If word does not contain a vowel, FindFirstVowel
 * returns -1. The code for IsVowel appears in Chapter 1.
 */
int findFirstVowel(string word) {
    for (int i = 0; i < word.length(); i++) {
        if (isVowel(word[i])) return i;
    }
return -1; }

/*
 * Function: isVowel
 * Usage: if (= FindFirstVowel(word))isVowel(ch)) . . .
 * --------------------------------
 * Returns true if the character ch is a vowel.
 */

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
