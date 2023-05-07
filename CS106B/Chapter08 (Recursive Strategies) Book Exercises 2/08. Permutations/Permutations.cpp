/*
 * File: main.cpp
 * --------------
 * 8. The recursive decomposition presented in section 8-3 to solve the problem of generating permutations is not the
 * only effective strategy. Another way to look at the problem is to solve the recursive case looks like this:
 * a) Remove the first character from the string and store it in the variable ch.
 * b) Generate the set containing all permutations of the remaining characters.
 * c) Form a new set by inserting ch in every possible position in each of those permutations.
 * Reimplement the Permutations program so that it uses this new strategy.
 *
 * 9. The strategy used to implement the Permutations program in the text is designed to emphasize its recursive
 * character. The resulting code is not particularly efficient, mostly because it ends up generating sets that are
 * later discarded and because it applies methods like substr that require copying the characters in a string. It
 * is possible to eliminate those inefficiencies using the following recursive formulation:
 *
 * a) At each level, pass the entire string along with an index that indicates where the permutation process starts.
 * Characters in the string before this index stay where they are; characters at or after that position must go through
 * all their permutations.
 * b) The simple case occurs when the index reaches the end of the string.
 * c) The recursive case operates by swapping the character at the index position with every other character in the string
 * and then generating every permutation starting with the next higher index and then swapping the characters back to
 * ensure that the original order is restored.
 *
 * Use this strategy to implement a function
 *
 *           void listPermutations(string str);
 *
 * that lists on cout all permutations of the string str without generating any sets at all or applying any string
 * methods other than length or selection. The listPermutations function itself must be a wrapper function for a second
 * function that includes the index.
 * This function is relatively easy to implement if you don’t try to take account of duplicated letters in the string.
 * The interesting challenge comes in adapting the structure of the algorithm so that it lists each unique permutation
 * exactly once without using sets to accomplish that task. You should not, however, worry about the order in which
 * listPermutations delivers its output.

 */

#include "console.h"
#include "simpio.h"
#include "set.h"

using namespace std;

Set<string> generatePermutations(string str);
Set<string> generatePermutationsBis(string str);
void listPermutations(string str);
void listPermutRecurs(string str, int index);



int main() {
    //string name = getLine("Enter starting word: ");
    string name = "happy";
    int count = 0;
    Set<string> perms = generatePermutations(name);
    for (string candidate : perms) {
        count++;
        //cout << "      " << candidate << ". " << candidate.length() << endl;
    }
    cout << "      count: " << count << ".\n" << endl;
    count = 0;
    perms = generatePermutationsBis(name);
    for (string candidate : perms) {
        count++;
        //cout << "      " << candidate << ". " << candidate.length() << endl;
    }
    cout << "      count: " << count << "." << endl;


    listPermutations(name);
    return 0;
}



void listPermutations(string str){
    int index = 0;
    listPermutRecurs(str, index);
}


void listPermutRecurs(string str, int index){
    if (str.length() - 1 == index) {
        //cout << "*** " << str << endl;
        return;
    } else {
        for (int var = 0; var <= index; ++var) {
            for (int t = 0; t < var; ++t) {
                cout << str[t];
            }
            cout << "_";
            ::swap(str[0],str[index]);

            listPermutRecurs(str, index + 1);
        }
        cout << "\n" << endl;
    }

}



Set<string> generatePermutationsBis(string str) {
    Set<string> result;
    if (str.length() == 0) {
        result += str;
    } else {
            char ch = str[0];
            string rest = str.substr(1);
            for (string s : generatePermutations(rest)) {
                for (int var = 0; var <= s.length(); ++var) {
                    result += s.substr(0, var) + ch + s.substr(var);
                }
            }
    }
    return result;
}

Set<string> generatePermutations(string str) {
    Set<string> result;
    if (str.length() == 0) {
        result += str;
    } else {
        for (int i = 0; i < str.length(); i++) {
            char ch = str[i];
            string rest = str.substr(0, i) + str.substr(i + 1);
            for (string s : generatePermutations(rest)) {
                result += ch + s;
            }
        }
    }
    return result;
}
