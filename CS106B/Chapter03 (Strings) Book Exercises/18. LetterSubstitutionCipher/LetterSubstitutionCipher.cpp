/*
 * File: LetterSubstitutionCipher.cpp
 * --------------
 * Although they are certainly simple, Caesar ciphers are also extremely easy to break.
 * There are, after all, only 25 values for the number of characters to shift.
 * If you want to break a Caesar cipher, all you have to do is try each of the
 * 25 possibilities and see which one translates the original message into something readable.
 * A better scheme is to allow each letter in the original message to be represented by an arbitrary
 * letter instead of one a fixed distance from the original. In this case, the key for the
 * encoding operation is a translation table that shows what each of the 26 letters becomes
 * in the encrypted form. Such a coding scheme is called a letter-substitution cipher.
 *
 * The key in a letter-substitution cipher is a 26-character string that indicates the translation
 * for each character in the alphabet in order. For example, the key "QWERTYUIOPASDFGHJKLZXCVBNM"
 * indicates that the encoding process should use the following translation rule:
 *
 * Write a program that implements encryption using a letter-substitution cipher.
 * Your program should be able to duplicate the following sample run:
 */

#include "console.h"
#include "simpio.h"
#include "cmath"
using namespace std;


string letterSubstitutionCipher(string str, string key);
char encoder (char alpha, int shift);
int transShift(char alpha, string key);

const string SENTINEL = "";
const int A_SIZE = 26;

const int A = 65;
const int Z = 90;
const int a = 97;
const int z = 122;

int main() {
    string str = " ";
    string key;
    cout << "This program encodes a message using a letter substitution cipher. \nIndicate the end of the input with a blank line.. " << endl;

    string tempKey =   "QWERTYUIOPASDFGHJKLZXCVBNM";
    //string tempKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //string tempKey = "CDEFGHIJKLMNOPQRSTUVWXYZAB";

    string tempText = "WORKERS OF THE WORLD UNITE!";
   // string tempText = "WORKERS";


    cout << "\n" << tempKey << "<- Key" << endl;
    cout << tempText << "<- Message" << endl;
    cout << letterSubstitutionCipher(tempText, tempKey) << "<- My result" << endl;
    cout << "VGKATKL GY ZIT VGKSR XFOZT! <- Teacher's result" << endl;



    while (str != SENTINEL) {
        key = getLine("\nEnter a 26-letter key: ");
        str = getLine("Enter a message: ");
        cout << "Encoded message: " << letterSubstitutionCipher(str, key) << endl;
    }
    return 0;
}

// Takes a entire String, looks for each character, diferences between alphabetic letters and substitutes the letter for an encoded one.
string letterSubstitutionCipher(string str, string key){
    for (int i = 0; i < str.length(); i++) {
        if (isalpha(str[i])) {
            str[i] = transShift(str[i], key);

        }
    }
    return str;
}

// Takes a given key to transform a given character into the target letter and finds the positions to shift
int transShift(char alpha, string key){

    return key[alpha - 65];
}

