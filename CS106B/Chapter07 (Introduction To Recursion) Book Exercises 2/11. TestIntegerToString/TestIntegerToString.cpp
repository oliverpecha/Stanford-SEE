/*
 * File: TestIntegerToString.cpp
 * --------------
 * The strlib.h library contains a function integerToString. Reimplement this function without using streams by exploiting the recursive decomposition of an integer outlined in exercise 7.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

std::string integerToString(int n, int radix = 10);


int main() {
    int value = getInteger("What integer to convert to a String?");
    cout << "Integer as String: " << integerToString(value) << endl;
    return 0;
}

std::string converter(int n){
    if (n < 10) return &"" [ n];
    else return &"" [ n % 10] + converter(n / 10);

}

std::string integerToString(int n) {
   return converter(n);
}
