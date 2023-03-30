/*
 * File: main.cpp
 * --------------
 * 23. In Scrabble, knowing the two-letter word list is important because those short words
 * make it easy to “hook” a new word into tiles already on the board. Another list that
 * Scrabble experts memorize is the list of three-letter words that can be formed by adding
 * a letter to the front or back of a two-letter word. Write a program that generates this list.
 *
 * 24. One of the most important strategic principles in Scrabble is to conserve your S tiles,
 * because the rules for English plurals mean that many words take an S-hook at the end.
 * Some words, of course, allow an S tile to be added at the beginning, but it turns out
 * that there are 680 words—including, for example, both the words cold and hot—that allow
 * S-hooks on either end. Write a program that uses the English lexicon to make a list of all such words.
 */

#include "console.h"
#include "simpio.h"
#include "lexicon.h"

using namespace std;



// (3)2(3)
int main() {
    Lexicon english ("EnglishWords.txt");
    Lexicon twoLetter;
    Lexicon threeLetter;
    cout << "List of two-letter words that exists with three-letter words hooked at the front or end" << endl;
    for (string stream : english){
        if (stream.length() == 2) twoLetter.add(stream);
        if (stream.length() == 3) threeLetter.add(stream);
    }
    for (string twoWord : twoLetter){
        for (string threeWord : threeLetter){
            if (english.contains(threeWord + twoWord + threeWord)){
                cout << threeWord + twoWord + threeWord << " contructed with " << threeWord << " & " <<  twoWord<< endl;
            }
        }
    }
    cout << "\nList of words that exists with and without and 's' at the front or end" << endl;
    for (string stream : english){
        if (stream[0] == 's' && stream[stream.length()-1] == 's') {
            if (english.contains(stream.substr(1, stream.length()-2))) {
                cout << "a) " << stream << " b) " <<  stream.substr(1, stream.length()-2) << endl;
            }
        }
    }
    return 0;
}
