#include "labelgen.h"

LabelGen::LabelGen() {

}

LabelGen::LabelGen(std::string iStr, int iN) {
    str = iStr;
    n = iN;
}

std::string LabelGen::nextLabel() {
   std::string label = str + std::to_string(n);
    n++;
   return label;
}
