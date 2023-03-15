/*
 * File: main.cpp
 * --------------
 * In the third century B.C.E., the Greek astronomer Eratosthenes developed an algorithm
 * for finding all the prime numbers up to some upper limit N. To apply the algorithm,
 * you start by writing down a list of the integers between 2 and N. For example, if N were 20,
 * you would begin by writing the following list:
 * You then circle the first number in the list, indicating that you have found a prime.
 * Whenever you mark a number as a prime, you go through the rest of the list and cross off
 * every multiple of that number, since none of those multiples can itself be prime. Thus,
 * after executing the first cycle of the algorithm, you will have circled the number 2 and
 * crossed off every multiple of 2, as follows:
 * To complete the algorithm, you simply repeat the process by circling the first number in the
 * list that is neither crossed off nor circled, and then crossing off its multiples. In this example,
 * you would circle 3 as a prime and cross off all multiples of 3 in the rest of the list,
 * which results in the following state:
 * Eventually, every number in the list will either be circled or crossed out, as shown in this diagram:
 * The circled numbers are the primes; the crossed-out numbers are composites. This algorithm is called the sieve of Eratosthenes.
 * Write a program that uses the sieve of Eratosthenes to generate a list of the primes between 2 and 1000.
 */

#include "console.h"
#include "simpio.h"
#include "vector.h"
#include <cmath>

using namespace std;

void fill(Vector<int> & list, int start, int end);
void keepPrimes(Vector<int> & list);
void print(Vector<int> list);

const int START = 2;
const int END = 1000;


int main() {
    Vector<int> list;
    fill(list, START, END);
    keepPrimes(list);
    print(list);
    return 0;
}

void fill(Vector<int> & list, int start, int end) {
    for (int i = start; i <= end; i++) {
        list.add(i);
    }
}

void keepPrimes(Vector<int> & list){
    for (int a = 0; a < list.size(); a++) {
        for (int b = 1; b < list.size(); b++) {
            if (list[a] != list[b] && remainder(list[b], list[a]) == 0 ) {
                list.remove(b);
                b--;
            }
        }
    }
}

void print(Vector<int> list) {
    for (int buffer : list) {
        cout << buffer << endl;
    }
}

