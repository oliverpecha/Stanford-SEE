/*
 * File: Mnemonic.cpp
 * --------------
 * On a telephone keypad, the digits are mapped onto the alphabet as shown in the diagram below:
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
 */

#include "console.h"
#include "simpio.h"
#include "map.h"
#include "set.h"
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

        //cout << "MAX_TEST:" << keyboard.get(nEntered[1] - '0').substr(1,1) << endl;

        listMnemonics(nEntered);
        mnemonics.clear();
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
    int index = 0;
    for (int key = index; key < n.length(); ++key) {
        for (int pos = 0; pos < keyboard.get(n[key] - '0').length(); ++pos) {
            for (string s : Mnemonics(n, key, pos)) {
                mnemonics.add(s);
            }
        }
    }

    for (string s : mnemonics) {
        if (n.length() == s.length()){
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
