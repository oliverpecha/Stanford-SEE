/*
 * File: filelib_functions.cpp
 * --------------
 * 5. The filelib.h interface exports several functions that make it easy to work with filenames.
 * Two functions that are particularly useful are getRoot and getExtension, which divide a function
 * into its root, which is the identifying part of the filename, and the extension, which indicates
 * its type. For example, given the filename Middlemarch.txt used in the preceding exercise, the root
 * is Middlemarch and the extension is .txt (note that filelib.h defines the extension to includes the dot).
 * Write the code necessary to implement these functions. To find out how to handle special cases,
 * such as filenames that don’t include a dot, consult the filelib.h interface in Appendix A.
 *
 *
 * 6. Another useful function in filelib.h is
 *
 *      string defaultExtension(string filename, string ext);
 *
 * which adds ext to the end of filename if it doesn’t already have an extension. For example,
 *
 *      defaultExtension("Shakespeare", ".txt")
 *
 * would return "Shakespeare.txt". If filename already has an extension, that name is returned unchanged,
 * so that
 *
 *      defaultExtension("library.h", ".cpp")
 *
 * would ignore the specified extension and return "library.h" unchanged.
 * If, however, ext includes a star before the dot, defaultExtension removes any existing extension
 * from filename and adds the new one (minus the star). Thus,
 *
 *      defaultExtension("library.h", "*.cpp")
 *
 * would return "library.cpp". Write the code for defaultExtension so that it behaves as described
 * in this exercise.
 *
 */

#include "console.h"
#include "simpio.h"
#include <iomanip>
using namespace std;

void  printRootNextension(string str);
void  printDefaultxtension(string filename, string ext);
string getRoot(string str);
string getExtension(string str);
string defaultExtension(string filename, string ext);

int main() {
    cout << "The below are test scenarios for getRoot and getExtension." << endl;
        printRootNextension("Middlemarch.txt");
        printRootNextension("Middlemarch.");
        printRootNextension("Middlemarch");
        cout << "\n" << endl;

    cout << "The below are test scenarios for defaultExtension." << endl;
        printDefaultxtension("Shakespeare", ".txt");
        printDefaultxtension("Shakespeare.", ".txt");
        printDefaultxtension("library.h", ".cpp");
        printDefaultxtension("library.h", "*.cpp");
    return 0;
}

void  printRootNextension(string str) {
    cout << "For " << setw(16) << str << " ... root is... " << setw(13) << getRoot(str) << " and extension is... " << setw(4) << getExtension(str) << endl;
}

void  printDefaultxtension(string filename, string ext) {
    cout << "For " << setw(16) << filename << " ... along with " << setw(6) << ext << " ... resulting filename is... " << setw(18) << defaultExtension(filename, ext) << endl;
}

string getRoot(string str) {
    string result;
    int pos = str.find('.');
    if (pos != -1) return str.substr(0, pos);
    return str;
}

string getExtension(string str) {
    string result;
    int pos = str.find('.');
    if (pos != -1 && pos != str.length()-1) result = str.substr(pos);
    return result;
}

string defaultExtension(string filename, string ext){
    int pos = filename.find('.');
    if (pos == -1) return filename + ext;
    else if (pos == filename.length()-1)  return filename.substr(0, pos) + ext;
    else if (pos <= filename.length()-2 && ext[0] == '*') return getRoot(filename) + ext.substr(1);
    else return filename;
}
