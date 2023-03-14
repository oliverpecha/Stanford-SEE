/*
 * File: meanAndStandardDeviation.cpp
 * --------------
 * 02. In statistics, a collection of data values is often referred to as a distribution.
 * One of the primary goals of statistical analysis is to find ways to compress the complete
 * set of data into summary statistics that express properties of the distribution as a whole.
 * The most common statistical measure is the mean, which is simply the traditional average.
 * For the distribution x1, x2, x3, . . . , xn, the mean is usually represented by the symbol.
 * Write a function
 *
 *      double mean(Vector<double> & data);
 *
 *      that returns the mean of the data in the vector.
 *
 * 03.Another common statistical measure is the standard deviation, which provides an indication
 * of how much the values in a distribution x1, x2, x3, . . . , xn differ from the mean.
 * In mathematical form, the standard deviation (!) is expressed as follows, at least if you are
 * computing the standard deviation of a complete distribution as opposed to a sample:
 *
 * The Greek letter sigma (!) indicates a summation of the quantity that follows, which in this
 * case is the square of the difference between the mean and each individual data point.
 * Write a function
 *
 *      double stddev(Vector<double> & data);
 *
 *      that returns the standard deviation of the data distribution.
 */

#include "console.h"
#include "simpio.h"
#include "vector.h"
#include <cmath>


using namespace std;



double mean(Vector<double> & data);
double stddev(Vector<double> & data);
double sumDataRoll(Vector<double> dataRoll);
void valAgainstMean(Vector<double> data, Vector<double> & dataRoll);


double x = 0;


Vector<double> meanVec;

int main() {
    cout << "Enter a set of values and program will display: \na) it's mean. \nb) it's standard deviation. \nEnter -1 to finish entering\n"<< endl;
    while (x != -1) {
        x = getReal("Input value ");
        if (x != -1) meanVec.add(x);
    }
    cout << "\nThe mean is: " << mean(meanVec) << endl;
    cout << "\nThe standard deviation is: " << stddev(meanVec) << endl;

    return 0;
}

double sumAll(Vector<double> data){
    double result = 0;
    for (double entry : data) {
        result += entry;
    }
    return result;
}

double mean(Vector<double> & data) {
    int entries = data.size();
    double result = sumAll(data);
    return result / entries;
}

double stddev(Vector<double> & data) {
    Vector<double> dataRoll;
    //N	=	the size of the population
    int n = data.size();
    valAgainstMean(data, dataRoll);
    return sqrt(sumDataRoll(dataRoll)/n);
}

void valAgainstMean(Vector<double> data, Vector<double> & dataRoll) {
    //mu	=	the population mean
    double mu = mean(data);
    for (double value : data) {
        dataRoll.add(pow(value - mu, 2));
    }
}

double sumDataRoll(Vector<double> dataRoll) {
 //x_i	=	each value from the population
    double total = 0;
    for (double result : dataRoll) {
        total += result;
    }
    return total;
}
