/*
 * File: capitalize.cpp
 * --------------
 * Implement a function capitalize(str) that returns a string in which the initial character is capitalized
 * (if it is a letter) and all other letters are converted to lowercase. Characters other than letters are not affected.
 * For example, both capitalize("BOOLEAN") and capitalize("boolean") should return the string "Boolean".
 */

#include "console.h"
#include "simpio.h"
using namespace std;


string capitalize(string str);

int main()
{
    string str = getLine("What is the phrase you want to convert to Capitalize Case");
    cout << "The Capitalized Case phrase is... " << capitalize(str) << endl;
    return 0;
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
