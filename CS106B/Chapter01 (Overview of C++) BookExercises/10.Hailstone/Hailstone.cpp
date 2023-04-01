/*
 * File: Hailstone.cpp
 * --------------
 * In 1979, Douglas Hofstadter, Professor of Cognitive Science at the University of Indiana, wrote Gödel, Escher, Bach,
 * which he described as “a metaphorical fugue on minds and machines in the spirit of Lewis Carroll.”
 * The book won the Pulitzer Prize for Literature and has over the years become one of the classics of computer science.
 * Much of its charm comes from the mathematical oddities and puzzles it contains, many of which can be expressed
 * in the form of computer programs. Of these, one of the most interesting concerns the sequence of numbers formed
 * by repeatedly executing the following rules for some positive integer n:
 * • If n is equal to 1, you’ve reached the end of the sequence and can stop.
 * • If n is even, divide it by two.
 * • If n is odd, multiply it by three and add one.
 * Although it also goes by several other names, this sequence is often called the hailstone sequence because
 * the values tend to go up and down before coming back to 1, much as hailstones do in the clouds in which they form.
 * Write a program that reads in a number from the user and then generates the hailstone sequence from that point,
 * as in the following sample run:
 *
 *
 * As you can see, this program offers a narrative account of the process as it goes along, much as Hofstadter does in his book.
 * One of the fascinating things about the hailstone sequence is that no one has yet been able to prove that the process always stops.
 * The number of steps in the process can get very large, but somehow, it always seems to climb back down to one.
 */

#include "console.h"
#include "simpio.h"
using namespace std;


int main()
{
    int n = getInteger("Enter a number: ");
   while (n != 1) {
      if (n % 2 == 1) {
        cout << n << " is odd, so I multiply it by 3 and add 1 to get to " << n * 3 + 1 << endl;
        n = n * 3 + 1;
      }
      else {
        cout << n << " is even, so I divide it by 2 to get to " << n /2 << endl;
        n /= 2;
      }
    }

    return 0;
}
