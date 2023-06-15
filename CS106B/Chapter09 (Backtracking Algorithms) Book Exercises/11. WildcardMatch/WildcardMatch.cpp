/*
 * File: WildcardMatch.cpp
 * --------------
 * Most operating systems and many applications that allow users to work with
 * files support wildcard patterns, in which special characters are used to create
 * filename patterns that can match many different files. The most common special
 * characters used in wildcard matching are ?, which matches any single character,
 * and *, which matches any sequence of characters. Other characters in a filename
 * pattern must match the corresponding character in a filename.
 *
 * For example,
 * the pattern *.* matches any filename that contains a period, such as
 * EnglishWords.dat or HelloWorld.cpp, but would not match filenames that do not
 * contain a period. Similarly, the pattern test.? matches any filename that consists
 * of the name test, a period, and a single character; thus, test.? matches test.h
 * but not test.cpp. These patterns can be combined in any way you like.
 * For example, the pattern ??* matches any filename containing at least two characters.
 *
 * Write a function
 *
 *      bool wildcardMatch(string filename, string pattern);
 *
 * that takes two strings, representing a filename and a wildcard pattern, and returnstrueifthatfilenamematchesthepattern. Thus,
 *      wildcardMatch("US.txt", "*.*")
 *      wildcardMatch("test", "*.*")
 *      wildcardMatch("test.h", "test.?")
 *      wildcardMatch("test.cpp", "test.?")
 *      wildcardMatch("x", "??*")
 *      wildcardMatch("yy", "??*")
 *      wildcardMatch("zzz", "??*")
 *
 *      returns: true returns false returns true returns false returns false returns true returns true
 */

#include "console.h"
#include "simpio.h"
using namespace std;

//bool wildcardMatch(string filename, string pattern);
bool isMatch(string s, string p);


int main() {


    string str = "baaabab";
    string pattern = "*****ba*****ab";
    // char pattern[] = "ba*****ab";
    // char pattern[] = "ba*ab";
    // char pattern[] = "a*ab";
    // char pattern[] = "a*****ab";
    // char pattern[] = "*a*****ab";
    // char pattern[] = "ba*ab****";
    // char pattern[] = "****";
    // char pattern[] = "*";
    // char pattern[] = "aa?ab";
    // char pattern[] = "b*b";
    // char pattern[] = "a*a";
    // char pattern[] = "baaabab";
    // char pattern[] = "?baaabab";
    // char pattern[] = "*baaaba*";

    if (isMatch(str, pattern))
        cout << "Yes" << endl;
    else
        cout << "No" << endl;


/*
    wildcardMatch("US.txt", "*.*");
    wildcardMatch("test", "*.*");
    wildcardMatch("test.h", "test.?");
    wildcardMatch("test.cpp", "test.?");
    wildcardMatch("x", "??*");
    wildcardMatch("yy", "??*");
    wildcardMatch("zzz", "??*");
*/

    return 0;
}


bool isMatch(string str, string pattern) {
        //dry run this sample case on paper , if unable to understand what soln does
        // p = "a*bc" s = "abcbc"
        int sIdx = 0, pIdx = 0, lastWildcardIdx = -1, sBacktrackIdx = -1, nextToWildcardIdx = -1;
        while (sIdx < str.size()) {
            if (pIdx < pattern.size() && (pattern[pIdx] == '?' || pattern[pIdx] == str[sIdx])) {
                // chars match
                ++sIdx;
                ++pIdx;
            } else if (pIdx < pattern.size() && pattern[pIdx] == '*') {
                // wildcard, so chars match - store index.
                lastWildcardIdx = pIdx;
                nextToWildcardIdx = ++pIdx;
                sBacktrackIdx = sIdx;

                //storing the pidx+1 as from there I want to match the remaining pattern
            } else if (lastWildcardIdx == -1) {
                // no match, and no wildcard has been found.
                return false;
            } else {
                // backtrack - no match, but a previous wildcard was found.
                pIdx = nextToWildcardIdx;
                sIdx = ++sBacktrackIdx;
                //backtrack string from previousbacktrackidx + 1 index to see if then new pidx and sidx have same chars,
                //if that is the case that means wildcard can absorb the chars in b/w and still further we can run the algo,
                // if at later stage it fails we can backtrack
            }
        }
        for(int i = pIdx; i < pattern.size(); i++){
            if(pattern[i] != '*') return false;
        }
        return true;
        // true if every remaining char in p is wildcard
    }
