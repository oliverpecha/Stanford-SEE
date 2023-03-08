/*
 * File: removeComments.cpp
 * --------------
 * Even though comments are essential for human readers, the compiler simply ignores them.
 * If you are writing a compiler, you therefore need to be able to recognize and eliminate comments that occur in a source file.
 * Write a function
 *
 *    void removeComments(istream & is, ostream & os);
 *
 * that copies characters from the input stream is to the output stream os, except for characters that appear inside
 * C++ comments. Your implementation should recognize both comment conventions:
 *
 * • Any text beginning with * and ending with *, possibly many lines later.
 * • Any text beginning with //and extending through the end of the line.
 *
 * The real C++ compiler needs to check to make sure that these characters are not contained inside quoted strings,
 * but you should feel free to ignore that detail. The problem is tricky enough as it stands.
 */

#include "console.h"
#include "simpio.h"
#include <iostream>
#include <fstream>
#include <sstream>

using namespace std;

void removeComments(istream & is, ostream & os);
void copyCharStreamF2F(ifstream & ifile, ofstream & ofile);
void copyStringStreamF2F(ifstream & ifile, ofstream & ofile);
string removeCommentsStr(string str, bool & commentary);



int main () {
    ifstream ifile("Pregunta_Loca.txt");
    ofstream oAfile("7a.txt");
    ofstream oBfile("9.txt");
    copyStringStreamF2F(ifile, oBfile);
    //copyCharStreamF2F(ifile, oAfile);

    return 0;
}


void copyStringStreamF2F(ifstream & ifile, ofstream & ofile) {
    string iBuffer;
    string oBuffer;
    string savedBuffer = "";
    bool commentary = false;

    if (ifile.is_open() && ofile.is_open()) {
        int counter = 0;
        while (getline(ifile, iBuffer)) {
            counter++;
            cout << setw(2) << counter << " line, " << setw(2) << iBuffer.length() << " char buffer: " << iBuffer << endl;
            if (iBuffer.length() <= 1) ofile << iBuffer << endl;
            else {
                oBuffer = removeCommentsStr(iBuffer, commentary);
                if (oBuffer.length() > 0 && !commentary) {
                    ofile << savedBuffer << oBuffer << endl;
                    savedBuffer = "";
                }
                else if (oBuffer.length() > 0 && commentary) {
                    savedBuffer = oBuffer;
                }
            }
        }
        ifile.close();
        ofile.close();
    }
    else cout << "Unable to open files";
}

string removeCommentsStr(string str, bool & commentary) {
    int pos = 0;
    pos = str.find('/');
    if (pos == -1 && commentary) {
        cout << "   -ignored" << endl;
        return "";
    }
    // be carfeul not exceeding lenght
    else if (str[pos+1] == '/'){
        if (pos == 0) {
            cout << "   scratch all!" << endl;
            return "";
        }
        else {
            cout << "   removed after //" << endl;
            return str.substr(0, pos);
        }
    }
    else if (str[pos+1] == '*'){
        cout << "   /* found" << endl;
        // be carfeul not exceeding lenght
        int posNew = str.find('/', pos+1);
        if (posNew != -1 && str[posNew-1] == '*') {
            cout << "   */ found too. No more ignoring" << endl;
            string head = str.substr(0, pos);
            string tail = str.substr(posNew + 1, str.length() - posNew);
            return head + tail;
        }
        else if (pos > 0) {
            cout << "   ignore from here" << endl;
            commentary = true;
            return str.substr(0, pos);
        }else {
            cout << "   ignore from here" << endl;
            commentary = true;
            return "";
        }
    }
    pos = str.find('*');
    if (commentary && pos != -1 && str[pos+1] == '/'){
        cout << "   */ found" << endl;
        cout << "   stop ignoring" << endl;
        commentary = false;
        return str.substr(pos+2);
    }
    cout << "   found zero" << endl;
    return str;
}


void copyCharStreamF2F(ifstream & ifile, ofstream & ofile) {
    if (!ifile.is_open()) cout << "ifile to be reopened"; ifile.open("Troilus.txt");
    if (!ofile.is_open()) cout << "Unable to open ofile";
    if (ofile.is_open() && ifile.is_open()) {
        ofile << "7a This is a line.\n";
        ofile << "This is another line.\n";
        int ch;
        while ((ch = ifile.get()) != EOF) {

            ofile.put(ch);
        }
        ifile.close();
        ofile.close();
    }
    else cout << "Unable to open files";
}
