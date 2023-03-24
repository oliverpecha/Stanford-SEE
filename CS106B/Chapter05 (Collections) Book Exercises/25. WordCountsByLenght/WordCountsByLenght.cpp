
/*
* File: WordCountsByLenght.cpp
*
* Write a program that prints out a table showing the number of words that
* appear in the English lexicon, sorted by the length of the word. For the
* lexicon in EnglishWords.dat, the output of this program looks like this:
*/

#include <iostream>
#include "lexicon.h"
#include "console.h"
#include "map.h"
#include <iomanip>

using namespace std;

int main() {
    Lexicon english ("EnglishWords.txt");
    Map<int, int> dataCount{};
    for (string stream : english){
        int lenght = stream.length();
        if (dataCount.containsKey(lenght)) dataCount.put(lenght, dataCount.get(lenght) + 1);
        else dataCount.put(lenght, 1);
    }
    for (int counter : dataCount){
        cout << setw(2) << counter << setw(7) << dataCount.get(counter) << endl;
    }
    return 0;
}
