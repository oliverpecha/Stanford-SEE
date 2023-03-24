/*
 * File: AreaCodes.cpp
 * --------------
 * Telephone numbers in the United States and Canada are organized into various three-digit area codes. 
 * A single state or province will often have many area codes, but a single area code will not 
 * cross a state boundary. This rule makes it possible to list the geographical locations of 
 * each area code in a data file. For this problem, assume that you have access to the file AreaCodes.txt, 
 * which lists all the area codes paired with their locations as illustrated by the first few lines 
 * of that file:
 * 
 *  image
 *
 * Using the AirportCodes program as a model, write the code necessary to read this file into a Map<int,string>,
 * where the key is the area code and the value is the location. Once you’ve read in the data, write a main
 * program that repeatedly asks the user for an area code and then looks up the corresponding location,
 * as illustrated in the following sample run:
 *
 *  image
 *
 * As the prompt suggests, however, your program should also allow users to enter the name of a state or province
 * and have the program list all the area codes that serve that area, as illustrated by the following sample run:
 */



/*
* File: AirportCodes.cpp
*
* This program looks up a three-letter airport code in a Map object.
*/
#include <iostream>
#include <fstream>
#include <string>
#include <cctype>
#include "console.h"
#include "error.h"
#include "map.h"
#include "grid.h"
#include "strlib.h"

using namespace std;

/* Function prototypes */
void readAreaCodesFile (string filename, Map<string, Map<int, string>> & map);
void printStateCodes(string input, Map<string, Map<int, string>> & map);
void printCode(string input, Map<string, Map<int, string>> & map);
bool stateLine(string str);
bool valuesLine(string str, int & code, string & timezone, string & area);
void removeSpaces(string & str);
bool inputIsCode(string input);

/* Main program */
int main() {
    Map<string, Map<int, string>> areaCodes;
    readAreaCodesFile("AreaCodes2.txt", areaCodes);
    //cout << areaCodes << endl;
    while (true) {
        string input;
        cout << "Enter an Area code or State name: ";
        getline (cin, input);
        if (input == "") break;

        if (areaCodes.containsKey(input)) {
            printStateCodes(input, areaCodes);
        } else if (inputIsCode(input)){
            //cout << "code will translate: " << endl;
            printCode(input, areaCodes);
        }
        else {
        cout << "\n   Such code or name wasn't found" << endl; cout << endl;
        }
    }
    return 0;
}

void readAreaCodesFile(string filename, Map<string, Map<int, string>> & map) {
    string state;
    int code;
    string timezone;
    string area;
    ifstream infile;
    infile.open(filename.c_str());
    if (infile.fail()) error("Can't read the data file");
    string line;
    while (getline(infile, line)) {
        if (stateLine(line)) state = line.substr(0, line.size()-1);
        // keep stateLine as key and add Vector with Number, timezone and city
        else if (valuesLine(line, code, timezone, area)) {
        // add a Vector with n, t, loc (0,1,2)
            if (map.get(state).isEmpty()) {
                Map<int, string> temp;
                temp.put(code, area);
                map.put(state, temp);
            } else if (!map.get(state).isEmpty()){
                Map<int, string> temp = map.get(state);
                temp.put(code, area);
                map.put(state, temp);
            }
        }
        else error("Illegal data line:" + line);
    }
    infile.close();

}

bool inputIsCode(string input){
    if (input.size() == 3) {
        for (int var = 0; var < 3; ++var) {
            if (!isdigit(input[var])) return false;
        }
    } else return false;
    return true;
}

bool stateLine(string str){
    int var = 0;
    while (var > -1 && var < str.size()) {
        if (isdigit(str[var])) return false;
        var++;
    }
    return true;
}

void removeSpaces(string & str) {
    for (int var = 0; var < str.length(); ++var) {
        if (isspace(str[var])) str.erase(var, 1);
        else if (isalpha(str[var])) var = str.length();
    }
}

bool valuesLine(string str, int & code, string & timezone, string & area) {
    int start = 0;
    int end = str.find(' ');
    if (end != -1) {
        code = stringToInteger(str.substr(start, 3));
        start = end;
        end = str.find(' ', start + 1);
        timezone = str.substr(start, end - start);
        removeSpaces(timezone);
        area = str.substr(end);
        removeSpaces(area);
    }
    return true;

}

void printStateCodes(string input, Map<string, Map<int, string>> & map){
    cout << "\nArea codes in "<< input << " are: " << endl;
    Map<int, string> temp = map.get(input);
    for (int codes : temp) {
        cout << setw(6) << codes << endl;
    }
    cout << endl; cout << endl;
}

void printCode(string input, Map<string, Map<int, string>> & map){
    string state;
    int code = stringToInteger(input);
    for (string states : map) {
        Map<int, string> temp = map.get(states);
        for (int codes : temp) {
            if (codes == code) {
                state = states;
                temp.clear();
                break;
            }
        }
        if (temp.isEmpty()) break;
    }
    cout << "\nThis area codes belongs to "<< state << endl;
    cout << endl; cout << endl;
}

