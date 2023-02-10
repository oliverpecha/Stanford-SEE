/*
 * File: Factor.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
using namespace std;


int main()
{
    int number, i = 1, j, count;

    cout << "This program factors a number. \nEnter number to be factored ";
    cin >> number;

    while (i <= number)
    {
        count = 0;
        if(number % i == 0)
        {
            j = 1;
            while(j <= i)
            {
                if(i % j == 0)
                {
                    count++;
                }
                j++;
            }
            if(count == 2)
            {
                cout << i << " is a Prime Factor\n";
            }
        }
        i++;
    }

    return 0;
}
