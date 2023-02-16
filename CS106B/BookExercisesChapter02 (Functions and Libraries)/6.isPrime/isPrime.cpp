/*
 * File: isPrime.cpp
 * --------------
 * An integer greater than 1 is said to be prime if it has no divisors other than itself and one.
 * The number 17, for example, is prime, because there are no numbers other than 1 and 17 that divide evenly into it.
 * The number 91, however, is not prime because it is divisible by 7 and 13. Write a predicate method isPrime(n)
 * that returns true if the integer n is prime, and false otherwise. To test your algorithm, write a main program that
 * lists the prime numbers between 1 and 100.
 */

#include "console.h"
#include "simpio.h"
using namespace std;


const int MAX_NUMBER = 100;

bool isPrime(int n);

int main() {
    cout << "Below are the prime numbers up until " << MAX_NUMBER << endl;
    for (int i = 1; i <= MAX_NUMBER; i++) {
        if (isPrime(i)) {
            cout << i << endl;
        }
    }
    return 0;
}

bool isPrime(int n) {
   int counter = 0;
   for (int i = 2 ; i < n; i++) {
       if (n % i == 0) {
           counter++;
       }
    }
   if (counter > 0) return false;
   else return true;
}
