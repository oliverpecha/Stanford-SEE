#include "console.h"
#include "simpio.h"
#include "combinatorics.h"
using namespace std;


int fact (int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    cout << "### result " << result << endl;
    return result;
}

int combinations (int n, int k) {
    return fact (n) / (fact(k) * fact(n-k));
}
