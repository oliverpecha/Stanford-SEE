/*
 * File: MorseCode.cpp
 * --------------
 * In May of 1844, Samuel F. B. Morse sent the message “What hath God wrought!” by telegraph
 * from Washington to Baltimore, heralding the beginning of the age of electronic communication.
 * To make it possible to communicate information using only the presence or absence of a single tone,
 * Morse designed a coding system in which letters and other symbols are represented as coded
 * sequences of short and long tones, traditionally called dots and dashes. In Morse code, the
 * 26 letters of the alphabet are represented by the codes shown in Figure 5-15.
 *
 * Write a program that reads in lines from the user and translates each line either to or from
 * Morse code depending on the first character of the line:
 *      • If the line starts with a letter, you want to translate it to Morse code.
 *      Any characters other than the 26 letters should simply be ignored.
 *      • If the line starts with a period (dot) or a hyphen (dash), it should be read as a series
 *      of Morse code characters that you need to translate back to letters. Each sequence of dots
 *      and dashes is separated by spaces, but any other characters should be ignored. Because there
 *      is no encoding for the space between words, the characters of the translated message will be
 *      run together when your program translates in this direction.
 * The program should end when the user enters a blank line. A sample run of this program (taken from
 * the messages between the Titanic and the Carpathia in 1912) might look like this:
 */

#include "console.h"
#include "simpio.h"
#include "map.h"
#include <cctype>
#include <strlib.h>
using namespace std;
const string SENTINEL = " ";

string translateToWords(string line);
string translateToMorse(string line);
void fillTranslator(Map<string, string> & translator);
string translateChar(char var, Map<string, string> translator);
string getTranslationFromMap(string buffer, Map<string, string> translator);
bool allLetters(string & line);
bool allMorse(string line);


int main() {
    string line = "";
    cout << "Morse code translator" << endl;
    while (line != SENTINEL) {
        line = getLine("\n>");
        if (allLetters(line)) {
            cout << translateToMorse(line) << endl;

        } else if (allMorse(line)) {
            cout << translateToWords(line) << endl;
        }
        else cout << "Only periods (dots), hyphens (dashes) or letters allowed" << endl;
    }
    return 0;
}


string translateToMorse(string line) {
    string result;
    Map<string, string> translator;
    fillTranslator(translator);
    for (int var = 0; var < line.size(); ++var) {
        result += translateChar(line[var], translator);
        if (var < line.size() - 1) result += " ";
    }
    return result;
}


string translateChar(char var, Map<string, string> translator) {
    return translator.get(to_string(var));
}

// turn string of morse into a word
string getTranslationFromMap(string buffer, Map<string, string> translator) {
    int pos = 0;
    while (pos < 26 && buffer != translator.get(to_string(u_char('A' + pos)))) {
        pos++;
    }
    if (pos == 26) return "?";
    return to_string(u_char('A' + pos));
}

string translateFromMorse(string buffer, Map<string, string> translator) {
    string result = getTranslationFromMap(buffer, translator);
    return "\"" + result + "\"" + " ";
}

string translateToWords(string line) {
    string result;
    Map<string, string> translator;
    fillTranslator(translator);
    string buffer;
    for (int var = 0; var < line.size(); ++var) {
        // only one char morse code
        // process translation without using a buffer
        if (line.size() == 1){
            result += translateFromMorse(to_string(line[0]), translator);
        }
        // last char of the string of words
        // add it to the buffer and process it
        else if (var == line.size() - 1) {
            buffer += line[var];
            result += translateFromMorse(buffer, translator);
        }
        // almost last case to consider!!!!!
        // current char is not a space && is not a one char morse code
        // add to the buffer (addition)
        else if (line[var] != ' ' && line.size() != 1) {
            buffer += line[var];
        }
        // buffer is forced to be processed, cleared before it was
        // translated and added to the result;
        else {
            result += translateFromMorse(buffer, translator);
            buffer.clear();
        }
    }
    return result;
}


bool allLetters(string & line){
    line = toUpperCase(line);
    for (int var = 0; var < line.size(); ++var) {
        if (!isalpha(line[var]) && line[var] != ' ') return false;
    }
    return true;
}


bool allMorse(string line){
    for (int var = 0; var < line.size(); ++var) {
        if (line[var] != '.' && line[var] != '-' && line[var] != ' ') return false;
    }
    return true;
}


void fillTranslator(Map<string, string> & translator) {
    translator.put("A", ".-");
    translator.put("B", "-...");
    translator.put("C", "-.-.");
    translator.put("D", "-..");
    translator.put("E", ".");
    translator.put("F", "..-.");
    translator.put("G", "--.");

    translator.put("H", "....");
    translator.put("I", "..");
    translator.put("J", ".---");
    translator.put("K", "-.-");
    translator.put("L", ".-..");
    translator.put("M", "--");
    translator.put("N", "-.");

    translator.put("O", "---");
    translator.put("P", ".--.");
    translator.put("Q", "--.-");
    translator.put("R", ".-.");
    translator.put("S", "...");
    translator.put("T", "-");
    translator.put("U", "..-");

    translator.put("V", "...-");
    translator.put("W", ".--");
    translator.put("X", "-..-");
    translator.put("Y", "-.--");
    translator.put("Z", "--..");
}

