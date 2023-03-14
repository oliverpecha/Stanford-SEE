/*
 * File: Histogram.cpp
 * --------------
 * 4. A histogram is a graphical way of displaying data by dividing the data into separate 
 * ranges and then indicating how many data values fall into each range. For example, 
 * given the set of exam scores
 * 
 * 100, 95, 47, 88, 86, 92, 75, 89, 81, 70, 55, 80 
 * 
 * a traditional histogram would have the following form:
 * 
 * The asterisks in the histogram indicate one score in the 40s, one score in the 50s, 
 * five scores in the 80s, and so forth.
 * 
 * When you generate histograms using a computer, however, it is much easier to display 
 * them sideways on the page, as in this sample run:
 *  
 *      image
 *      
 * Write a program that reads in a vector of integers from a data file and then displays 
 * a histogram of those numbers, divided into the ranges 0–9, 10–19, 20–29, and so forth, 
 * up to the range containing only the value 100. Your program should generate output that 
 * looks as much like the sample run as possible.
 * 
 * 5. Extend the flexibility of the previous exercise by defining a hist.h interface that 
 * gives clients more control over the format of the histogram. At a minimum, your interface 
 * should allow clients to specify the minimum and maximum values along with the size of each 
 * histogram range, but you should feel free to provide other capabilities as well. 
 * Use your imagination!
 */

#include "console.h"
#include "simpio.h"
#include "vector.h"
#include "hist.h"
#include <fstream>

using namespace std;

const int MIN_VAL = 0;
const int MAX_VAL = 100;
const int RANGE = 10;
const char FILL = '*';


int main() {
    Vector<int> scores((MIN_VAL + MAX_VAL) / RANGE + 1);
    Vector<int> param = {MIN_VAL, MAX_VAL, RANGE};
    file2vector("Scores.txt", scores, param);
    printVector(scores, FILL);
    return 0;
}

