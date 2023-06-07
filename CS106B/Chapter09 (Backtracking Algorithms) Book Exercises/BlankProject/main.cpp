/*
 * File: main.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
#include "vector.h"
#include "set.h"


using namespace std;

const int N_FACES = 4;


bool isDiverse(Vector<int> row){
    Set<int> base {1,2,3,4};
     int nRequired = base.size();
    if (row.size() == base.size()) {
        for (int var = 0; var < row.size(); ++var) {
            if (!base.isEmpty() && base.contains(row[var])) {
                nRequired--;
                base.remove(row[var]);
            }
        }
    }
    if (nRequired == 0) return true;
    else return false;
}



void combine(Vector<Vector<int>> boxOfCubes, Vector<Vector<int>> & resultlist, Vector<int> inheritance, int index) {
    if (index < 0);
    else {
        for (int x = 0; x < N_FACES; ++x) {
            int candidate = boxOfCubes.get(index).get(x);
            Vector<int> row;
            row.add(candidate);
            if (!inheritance.isEmpty()) {
                for (int var = 0; var < inheritance.size(); ++var) {
                    row.add(inheritance[var]);
                }
            }
            if (isDiverse(row)) resultlist.add(row);
            combine(boxOfCubes, resultlist, row, index - 1);
        }
    }
}


void printresults(Vector<Vector<int>> resultlist, int targetDigits) {
    int count = 0;
    for (int var = 0; var < resultlist.size(); ++var) {
        if (resultlist[var].size() == targetDigits) {
            count++;
        }
    }
    cout << count << endl;
    count = 0;
    Set<Vector<int>> newlist;
    for (Vector<int> s : resultlist) {
        if (s.size() == targetDigits) {
            newlist.add(s);
        }
    }
    for (Vector<int> s : newlist) {
        count++;
        //cout << "resultlist #" << var + 1<< endl;
        for (int i = 0; i < s.size(); ++i) {
            cout <<            s.get(i);
        }
        cout <<  endl;
    }
    cout << count << endl;


}



int main() {
    Vector<int> one {1,2,3,4};
    Vector<int> two {1,2,3,4};
    Vector<int> three {1,2,3,4};
    Vector<int> four {1,2,3,4};

    Vector<Vector<int>> boxOfCubes {one, two, three, four};
    Vector<Vector<int>> resultlist;
    Vector<int> inheritance;

    combine(boxOfCubes, resultlist, inheritance, boxOfCubes.size()-1);
    printresults(resultlist, 4);

    return 0;
}



