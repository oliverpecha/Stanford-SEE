/*
 * File: Mnemonic.cpp
 * --------------
 * 10. On a telephone keypad, the digits are mapped onto the alphabet as shown in the diagram below:
 * In order to make their phone numbers more memorable, service providers like to find numbers that s
 * pell out some word (called a mnemonic) appropriate to their business that makes that phone number
 * easier to remember.
 * Imagine that you have just been hired by a local telephone company to write a function listMnemonics
 * that will generate all possible letter combinations that correspond to a given number, represented as
 * a string of digits. For example, the call
 *            listMnemonics("723")
 * should list the following 36 possible letter combinations that correspond to that prefix:
 *           PAD PBD PCD QAD QBD QCD RAD RBD RCD SAD SBD SCD
 *           PAE PBE PCE QAE QBE QCE RAE RBE RCE SAE SBE SCE
 *           PAF PBF PCF QAF QBF QCF RAF RBF RCF SAF SBF SCF
 *
 *
 * 11. Rewrite the program from exercise 4 so that it uses the Lexicon class and the EnglishWords.dat
 * file so that the program only lists mnemonics that are valid English words.
 *
 * 12. These days, the letters on a telephone keypad are not used for mnemonics as much as they are for
 * texting. Entering text using a keypad is problematic, because there are fewer keys than there are letters
 * in the alphabet. Some cell phones use a “multi-tap” user interface, in which you tap the 2 key once for
 * a, twice for b, and three times for c, which can get tedious. A streamlined alternative is to use a
 * predictive strategy in which the cell phone guesses which of the possible letter you intended, based
 * on the sequence so far and its possible completions.
 *
 * For example, if you type the digit sequence 72, there are 12 possibilities: pa, pb, pc, qa, qb, qc, ra,
 * rb, rc, sa, sb, and sc. Only four of these letter pairs—pa, ra, sa, and sc—seem promising because they
 * are prefixes of common English words like party, radio, sandwich, and scanner. The others can be ignored
 * because there are no common words that begin with those sequences of letters. If the user enters 9956,
 * there are 144 (4 x 4 x 3 x 3) possible letter sequences, but you can be assured the user meant xylo
 * since that is the only sequence that is a prefix of any English words.
 *
 * Write a function
 *            void listCompletions(string digits, Lexicon & lex);
 * that prints all words from the lexicon that can be formed by extending the given digit sequence.
 * For example, calling
 *            listCompletions("72547", english)
 * should generate the following sample run:
 * If your only concern is getting the answer, the easiest way to solve this problem is to iterate through
 * the words in the lexicon and print out each word that matches the specified digit string. That solution
 * requires no recursion and very little thinking. Your managers, however, believe that looking through every
 * word in the dictionary is slow and insist that your code use the lexicon only to test whether a given
 * string is a word or a prefix of an English word. With that restriction, you need to figure out how to
 * generate all possible letter sequences from the string of digits. That task is easiest to solve recursively.
 */


#include "console.h"
#include "simpio.h"
#include "map.h"
#include "set.h"
#include "lexicon.h"

using namespace std;

void fillKeyboard();
void listMnemonics(string n);

Map <int, string> keyboard;
Set<string> mnemonics;


int main() {
    fillKeyboard();
    string nEntered;
    while (nEntered != "-") {
        nEntered = getLine("What number to translate to Mnemonic?");
        listMnemonics(nEntered);
        mnemonics.clear();
        cout << endl;
    }
    cout << "the end" << endl;
    return 0;
}


Set<string> Mnemonics(string n, int index, int pos) {
    Set<string> result;
    if (n.length() == index){
        result += "";
    } else {
        for (int var = 0; var <= keyboard.get(n[index] - '0').length(); ++var) {
            string head = keyboard.get(n[index] - '0').substr(var,1);
            for (string s : Mnemonics(n, index + 1, pos)) {
                result += head + s;
            }
        }
    }
    return result;
}


void listMnemonics(string n) {
    Lexicon english("Englishwords.txt");
    int index = 0;
    for (int key = index; key < n.length(); ++key) {
        for (int pos = 0; pos < keyboard.get(n[key] - '0').length(); ++pos) {
            for (string s : Mnemonics(n, key, pos)) {
                if (s.length() == n.length()) {
                    transform(s.begin(), s.end(), s.begin(), ::tolower);
                    mnemonics.add(s);
                }
            }
        }
    }

    for (string s : english) {
        if (mnemonics.contains(s.substr(0, n.length()))) {
            cout << s << endl;
        }
    }
}


void fillKeyboard() {
    keyboard.put(2, "ABC");
    keyboard.put(3, "DEF");
    keyboard.put(4, "GHI");
    keyboard.put(5, "JKL");
    keyboard.put(6, "MNO");
    keyboard.put(7, "PQRS");
    keyboard.put(8, "TUV");
    keyboard.put(9, "WXYZ");
}
