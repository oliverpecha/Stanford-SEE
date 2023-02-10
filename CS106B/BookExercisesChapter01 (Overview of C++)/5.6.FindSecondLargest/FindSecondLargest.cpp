/*
 * File: main.cpp
 * --------------
 * BWrite a program that reads in a list of integers from the user until the user enters the
 * value 0 as a sentinel. When the sentinel appears, your program should display the largest
 * value in the list, as illustrated in the following sample run:
 *
 * Be sure to define the sentinel value as a constant in a way that makes it easy to change.
 * You should also make sure that the program works correctly if all the input values are negative.
 *
 * For a slightly more interesting challenge, write a program that finds both the largest and the
 * second-largest number in a list, prior to the entry of a sentinel. Once again using 0 as the
 * sentinel, a sample run of this program might look like this:
 *
 * The values in this sample run are the number of pages in the British hardcover editions of
 * J. K. Rowling’s Harry Potter series. The output therefore tells us that the longest book
 * (Harry Potter and the Order of the Phoenix) has 766 pages and the second-longest book
 * (Harry Potter and the Goblet of Fire) weighs in at a mere 636 pages.
 */

#include "console.h"
#include "simpio.h"
using namespace std;

const int SENTINEL = 0;

int main() {
    int input, largest, secondLargest;

    cout << "This program finds the largest integer in a list. Enter " << SENTINEL << " to signal the end of the list." << endl;

    input = getInteger("? ");
    if (input != SENTINEL) {
        largest = input;
        secondLargest = input;
    }

    while (input != SENTINEL) {
        input = getInteger("? ");
        if (input != SENTINEL) {
            if (input > largest && input > secondLargest){
                secondLargest = largest;
                largest = input;
            }
            if (input < largest && input > secondLargest){
                 secondLargest = input;
            }
        }
    }
    cout << "The largest value was " << largest << endl;
    cout << "The second largest value was " << secondLargest << endl;

    return 0;

}
