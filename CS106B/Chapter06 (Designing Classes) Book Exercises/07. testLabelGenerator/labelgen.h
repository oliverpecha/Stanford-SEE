#ifndef LABELGEN_H
#define LABELGEN_H

#include <string>

class LabelGen {

private:
    std::string str;
    int n;

public:
    LabelGen();
    LabelGen(std::string iStr, int iN);
    //int getN();
    std::string nextLabel();
};

#endif // LABELGEN_H
