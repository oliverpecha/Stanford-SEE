/*
 * File: main.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
#include "set.h"
using namespace std;

bool subsetSumExists(Set<int> & set, int target);
int countSubsetSumWays(Set<int> & set, int target);

int main() {
    Set<int>  set { -2, 1, 3, 8 };
    int target = 7;
    if (subsetSumExists(set, target)) cout << target << " can be found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    else cout << target << " is found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    set.clear();
    set += 1, 3, 4, 5;
    target = 5;
    if (subsetSumExists(set, target)) cout << target << " can be found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    else cout << target << " is found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    target = 6;
    if (subsetSumExists(set, target)) cout << target << " can be found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    else cout << target << " is found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    target = 7;
    if (subsetSumExists(set, target)) cout << target << " can be found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    else cout << target << " is found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    target = 8;
    if (subsetSumExists(set, target)) cout << target << " can be found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    else cout << target << " is found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    target = 9;
    if (subsetSumExists(set, target)) cout << target << " can be found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    else cout << target << " is found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    target = 10;
    if (subsetSumExists(set, target)) cout << target << " can be found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    else cout << target << " is found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    target = 11;
    if (subsetSumExists(set, target)) cout << target << " can be found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;
    else cout << target << " is found " << countSubsetSumWays(set, target) << " times in set: " << set << endl;

    return 0;
}

int countSubsetSumWays(Set<int> & set, int target){
    int result = 0;
    if (set.isEmpty() ) {
       if (target == 0) return 1;
       else return 0;
    } else {
        int element = set.first();
        Set<int> rest = set - element;
        return result += countSubsetSumWays(rest, target)
            + countSubsetSumWays(rest, target - element);
    }

    return result;
}


bool subsetSumExists(Set<int> & set, int target) {
         if (set.isEmpty()) {
            return target == 0;
         } else {
            int element = set.first();
            Set<int> rest = set - element;
            return subsetSumExists(rest, target)
                || subsetSumExists(rest, target - element);
         }
}
