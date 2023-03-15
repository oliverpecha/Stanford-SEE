#include "console.h"
#include "simpio.h"
#include "vector.h"
//#include "hist.h"
#include <fstream>

using namespace std;

Vector<int> scores(11);

string printHead(int i) {
    if (i < 10) return std::to_string(i*10) + "s: ";
    else return "100: ";
}

string printTail(int score, char fill) {
    string result;
    for (int i = 0; i < score; i++) result += fill;
    return result;
}

bool scoreIsRange(int score, Vector<int> param) {
    if (score > param[0] && score < param[1]) return true;
    else return false;
}

void file2vector(string fileName, Vector<int> & scores, Vector<int> param){
    ifstream ifile(fileName);
    if (ifile.is_open()) {
        string buffer;
        while (getline(ifile, buffer)) {
           int score = std::stoi(buffer);
           if (scoreIsRange(score, param)) scores[score/10] +=  1;
        }
    }
    else cerr << "Can't open file" << endl;
}

void printVector(Vector<int> scores, char fill) {
    for (int i = 0; i < scores.size(); i++) {
        cout << printHead(i) << printTail(scores[i], fill) << endl;

    }
}

