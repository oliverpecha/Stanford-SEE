/*
 * File: CutStock.cpp
 * --------------
 * Suppose that you have been assigned the job of buying the plumbing pipes for a
 * construction project. Your foreman gives you a list of the varying lengths of pipe
 * needed, but the distributor sells stock pipe only in one fixed size. You can,
 * however, cut each stock pipe in any way needed. Your job is to figure out the minimum
 * number of stock pipes required to satisfy the list of requests, thereby saving money
 * and minimizing waste.
 *
 * Your job is to write a recursive function
 *
 * int cutStock(Vector<int> & requests, int stockLength);
 *
 * that takes two arguments—a vector of the lengths needed and the length of stock pipe
 * that the distributor sells—and returns the minimum number of stock pipes needed to
 * service all requests in the vector.
 *
 * For example, if the vector contains [ 4, 3, 4, 1, 7, 8 ] and the stock pipe length is 10,
 * you can purchase three stock pipes and divide them as follows:
 *
 * Pipe 1: 4, 4, 1 Pipe 2: 3, 7 Pipe 3: 8
 *
 * Doing so leaves you with two small remnants left over. There are other possible
 * arrangements that also fit into three stock pipes, but it cannot be done with fewer.
 */

#include "console.h"
#include "simpio.h"
#include "vector.h"
#include "set.h"

using namespace std;


int cutStock(Vector<int> & requests, int stockLength);
int nPipes(Vector<int> requests, int stockLength);
Set<Vector<int>> generatePermutations(Vector<int> requests);

int main() {
    Vector<int> requests {4, 3, 4, 1, 7, 8};
    int stockLength = 10;
    cout << "For given lenghts of " << requests << ", " << cutStock(requests, stockLength) <<
            " pipes of " << stockLength << " lenght are needed. Combo to use: " << requests << endl;
    return 0;
}


Set<Vector<int>> generatePermutations(Vector<int> requests) {
    Set<Vector<int>> result;
    if (requests.size() == 0) {
        result.add(requests);
        return result;
    }
    else {
        for (int var = 0; var < requests.size(); ++var) {
            int tempUnit = requests[var];
            requests.remove(var);
            for ( Vector<int> s : generatePermutations(requests)) {
                result.add(s + tempUnit);
            }
            requests.insert(var, tempUnit);
        }
    }
    return result;
}


int nPipes(Vector<int> requests, int stockLength){
    int totalPipes = 1;
    int currentPipe = stockLength;
    for (int var = 0; var < requests.size(); ++var) {
        if (currentPipe - requests[var] >= 0) {
            currentPipe -= requests[var];
        }
        else if (currentPipe - requests[var] < 0) {
            totalPipes++;
            currentPipe = stockLength;
            currentPipe -= requests[var];
        }

    }
    return totalPipes;
}

int cutStock(Vector<int> & requests, int stockLength){
    int minNpipes = 0;
    Vector<int> minPipe;
    for (Vector<int> s : generatePermutations(requests)){
        int nPipe = nPipes(s, stockLength);
        if (minNpipes == 0) {
            minNpipes = nPipe;
            minPipe = s;
        }
        if (nPipe < minNpipes) {
            minNpipes = nPipe;
            minPipe = s;
        }
    }
    requests = minPipe;
    return minNpipes;
}
