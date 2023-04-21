/*
 * File: isMesurable.cpp
 * --------------
 * If you are using a limited set of weights, however, you can only measure certain quantities accurately.
 * For example, suppose that you have only two weights: a 1-ounce weight and a 3-ounce weight.
 * With these you can easily measure out 4 ounces, as shown:
 *
 * It is somewhat more interesting to discover that you can also measure out 2 ounces by shifting the 1-ounce
 * weight to the other side, as follows:
 * Write a recursive function
 *
 *              bool isMeasurable(int target, Vector<int> & weights)
 *
 * that determines whether it is possible to measure out the desired target amount with a given set of weights,
 * which is stored in the vector weights.
 *
 * For example, suppose that sampleWeights has been initialized like this: Vector<int> sampleWeights;
 *
 *              sampleWeights += 1, 3;
 *
 * Given these values, the function call
 *
 *        isMeasurable(2, sampleWeights)
 *
 * should return true because it is possible to measure out 2 ounces using the sample weight set as illustrated
 * in the preceding diagram. On the other hand, calling
 *
 *        isMeasurable(5, sampleWeights)
 */

#include "console.h"
#include "simpio.h"
#include "vector.h"

using namespace std;

bool isMeasurable(int target, Vector<int> & weights);
string weightsFound(Vector<int> weights);


int main() {
    Vector<int> sampleWeights;
    sampleWeights += 1, 3;
    int nTest = 2;
    if (isMeasurable(nTest, sampleWeights)) cout << nTest << " can be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
    else cout << nTest << " can not be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
    nTest = 5;
    if (isMeasurable(nTest, sampleWeights)) cout << nTest << " can be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
    else cout << nTest << " can't be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
    sampleWeights += 2;
    if (isMeasurable(nTest, sampleWeights)) cout << nTest << " can be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
    else cout << nTest << " can't be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
        nTest = 6;
    if (isMeasurable(nTest, sampleWeights)) cout << nTest << " can be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
    else cout << nTest << " can't be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
    nTest = 9;
    sampleWeights += 7;
    if (isMeasurable(nTest, sampleWeights)) cout << nTest << " can be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
    else cout << nTest << " can't be accurately weighted using " << weightsFound(sampleWeights) << "." << endl;
    return 0;
}


bool isMeasurable(int target, Vector<int> & weights) {
    if (weights.isEmpty()) return false;
    else {
        int totalWeights = 0;
        for (int var = 0; var < weights.size(); ++var) {
            totalWeights += weights[var];
        }
        if (weights.get(0) == target || totalWeights == target) return true;
        int element = weights.get(0);
        Vector<int> rest = weights;
        rest.remove(0);
        return isMeasurable(target, rest) || isMeasurable(target + element, rest);
    }
}

string weightsFound(Vector<int> weights) {
    string result;
    for (int i : weights) {
        result += to_string(i) + ", ";
    }
    result.erase(result.length() - 2);
    return result;
}
