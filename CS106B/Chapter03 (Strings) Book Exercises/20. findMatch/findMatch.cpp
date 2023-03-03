/*
 * File: findMatch.cpp
 * --------------
 * The genetic code for all living organisms is carried in its DNA—a molecule with the
 * remarkable capacity to replicate its own structure. The DNA molecule itself consists
 * of a long strand of chemical bases wound together with a similar strand in a double helix.
 * DNA’s ability to replicate comes from the fact that its four constituent bases—adenosine,
 * cytosine, guanine, and thymine—combine with each other only in the following ways:
 *
 * • Cytosine on one strand links only with guanine on the other, and vice versa.
 * • Adenosine links only with thymine, and vice versa.
 *
 * Biologists abbreviate the names of the bases by writing only the initial letter: A, C, G, or T.
 *
 * Inside the cell, a DNA strand acts as a template to which other DNA strands can attach themselves.
 *
 * As an example, suppose that you have the following DNA strand, in which the position of each base
 * has been numbered as it would be in a C++ string:
 *
 * Your mission in this exercise is to determine where a shorter DNA strand can attach itself to the
 * longer one. If, for example, you were trying to find a match for the strand the rules for
 * DNA dictate that this strand can bind to the longer one only at position 1:
 *    TTGCC
 *   TAACGGTACGTC
 *
 * By contrast, the strand
 *
 * TGC
 *
 * matches at either position 2 or position 7. Write a function
 *
 *          int findDNAMatch(string s1, string s2, int start = 0);
 *
 * that returns the first position at which the DNA strand s1 can attach to the strand s2.
 * As in the find method for the string class, the optional start parameter indicates the index position
 * at which the search should start. If there is no match, findDNAMatch should return –1.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

int findDNAMatch(string strand, string strandLong, int start = 0);
bool attaches(char a, char b);


//string strandLong = "TAACGGTACGTC";
string strandLong = "TAACGGTACGTCTAACGGTACGTC";
string strandA = "TTGCC";
string strandB = "TGC";




int main() {
    int start = 4;
    int attachment = 0;
    cout << "\nWill " << strandA << " attach to " << strandLong << "?" << endl;
    attachment = findDNAMatch(strandA, strandLong);
    cout << strandA << " will attach to " << strandLong << " in " << attachment << " position of Strand" << endl;

    cout << "\nWill " << strandB << " attach to " << strandLong << "?" << endl;
    attachment = findDNAMatch(strandB, strandLong, start);
    cout << strandB << " will attach to " << strandLong << " in " << attachment << " position of Strand" << endl;




    /*
    for (int i = 0; i < strandB.length(); i++ ) {
       if (findDNAMatch(strandB, strandLong, i) != -1 ) {
       cout << strandB << " will attach to " << strandLong << " in " << attachment << " position of Strand" << endl;
        }
    }
    */
    return 0;
}

// C <> G
// A <> T

int findDNAMatch(string strand, string strandLong, int start) {
    int index = 0;
    int matches = 0;
    int next = 0;

    for (int a = start; a < strandLong.length(); a++) {

        if (matches == 0) index = a;

        cout << a << " starts (" << strandLong[a] << ")" << endl;

        for (int b = next; b < strand.length(); b++){

            cout << "       _________" << strandLong[a] << " being tested to " << strand[b] << endl;

            if (attaches(strandLong[a], strand[b])) {
                cout << "      ...." << strandLong[a] << " attaches with " << strand[b] << "!!!" << endl;
                matches++;
                next = b + 1;
                b = strand.length();
            }
            else {
                cout << "      %%%%" << strandLong[a] << " does NOT attache with " << strand[b] << " %%%" << endl;
                if (matches > 0) {
                    //next = 0;
                    b = -1;
                    index = a;
                }
                else {
                    b = strand.length();
                    cout << "      &&&& " << endl;

                }
                matches = 0;
            }

            cout << "       " << strandLong[a] << " + " << strand[b] << " result in match " << matches << endl;

            if (matches == strand.length()) return index;
        }
    }
    return -1;
}

bool attaches(char a, char b) {
    if (a == 'C' && b == 'G') return true;
    if (a == 'G' && b == 'C') return true;
    if (a == 'A' && b == 'T') return true;
    if (a == 'T' && b == 'A') return true;
    return false;
}
