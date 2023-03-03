/*
 * File: invertKey.cpp
 * --------------
 * Using the definition of keys for letter-substitution ciphers as described in the preceding problem,
 * write a function invertKey that takes an encryption key and returns the 26-letter key necessary
 * to decrypt a message encoded with that encryption key.
 */

#include "console.h"
#include "simpio.h"
using namespace std;



int main() {
    string str = " ";
    string key;
    cout << "This program finds the encodes a message using a letter substitution cipher. \nIndicate the end of the input with a blank line.. " << endl;

    string tempKey =   "QWERTYUIOPASDFGHJKLZXCVBNM";
    //string tempKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //string strandLong = "TAACGGTACGTC";

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
