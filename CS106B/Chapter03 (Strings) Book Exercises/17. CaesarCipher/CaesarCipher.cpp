/*
 * File: CaesarCipher.cpp
 * --------------
 * If you played around with codes and ciphers as a child, the odds are
 * good that you at some point used a cyclic cipher—which is often called a
 * Caesar cipher because the Roman historian Suetonius records that Julius Caesar
 * used this technique—in which you replace each letter in the original message
 * by the letter that appears a fixed distance ahead in the alphabet. As an example,
 * suppose that you wanted to encode a message by shifting every letter ahead
 * three places. In this cipher, each A becomes an D, B becomes E, and so on.
 * If you reach the end of the alphabet, the process cycles around to the beginning,
 * so that X becomes A, Y becomes B, and Z becomes C.
 *
 * To implement a Caesar cipher, you should first define a function
 *
 *           string encodeCaesarCipher(string str, int shift);
 *
 * that returns a new string formed by shifting every letter in str forward
 * the number of letters indicated by shift, cycling back to the beginning of the
 * alphabet if necessary. After you have implemented encodeCaesarCipher,
 * write a program that generates the following sample run:
 *
 * Note that the transformation applies only to letters; any other characters
 * are copied unchanged to the output. Moreover, the case of letters is unaffected:
 * lowercase letters come out as lowercase, and uppercase letters come out as uppercase.
 * You should also write your program so that a negative value of shift means that
 * letters are shifted toward the beginning of the alphabet instead of toward the end,
 * as illustrated by the following sample run:
 */

#include "console.h"
#include "simpio.h"
#include "cmath"
using namespace std;

string encodeCaesarCipher(string str, int shift);
char encoded (char alpha, int shift);
int fitShift(int shift);

const string SENTINEL = "";
const int A_SIZE = 26;

const int A = 65;
const int Z = 90;
const int a = 97;
const int z = 122;

int main() {
    string str = " ";
    int shift;
    cout << "This program encodes a message using a Caesar cipher. \nIndicate the end of the input with a blank line.. " << endl;
    while (str != SENTINEL) {
        shift = getInteger("\nEnter the number of character positions to shift: ");
        str = getLine("Enter a message: ");
        cout << "Encoded message: " << encodeCaesarCipher(str, shift) << endl;
    }
    return 0;
}

string encodeCaesarCipher(string str, int shift){
    for (int i = 0; i < str.length(); i++) {
        if (isalpha(str[i])) {
            str[i] = encoded((str[i]), shift);
        }
    }
    return str;
}

char encoded (char letter, int shift) {

    if (shift > A_SIZE || shift < A_SIZE * -1) shift = fitShift(shift);

    if (letter >= A && letter <= Z) {
        if (letter + shift < A) letter += shift + A_SIZE;
        else if (letter + shift > Z ) letter += shift - A_SIZE;
        else letter += shift;
        return letter;
    }
    else if (letter >= a && letter <= z) {
        if (letter + shift < a) letter += shift + A_SIZE;
        else if (letter + shift > z ) letter += shift - A_SIZE;
        else letter += shift;
        return letter;
    }
    else return letter;

}

int fitShift(int shift) {
    double rounds = (double)shift / A_SIZE;
    if (fmod(rounds,1) == 0) return 0;
    else return shift - (int)rounds * A_SIZE;
}
