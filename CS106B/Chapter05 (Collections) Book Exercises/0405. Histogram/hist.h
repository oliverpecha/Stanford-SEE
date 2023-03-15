#ifndef hist_h
#define hist_h

#include "vector.h"

using namespace std;


void file2vector(string fileName, Vector<int> & scores, Vector<int> param);
void printVector(Vector<int> scores, char fill);
//string printHead(int i);
//string printTail(int score);

#endif

