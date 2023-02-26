/*
 * File: createOrdinalForm.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
using namespace std;


const int SENTINEL = 0;

string createOrdinalForm(int n);

int main() {
    int n = -1;
    cout << "This program turns any cardinal number into an ordinal number. \nIndicate the end of the input with a 0... " << endl;
    while (n != SENTINEL) {
       n = getInteger("\nEnter a number:");
       cout << "It's ordinal number is: " << createOrdinalForm(n) << endl;
    }
    return 0;
}

string createOrdinalForm(int n) {
    string result = std::to_string(n);
    if (n < 21) {
        if (n == 1) return result += "st.";
        if (n == 2) return result += "nd.";
        if (n == 3) return result += "rd.";
        return result += "th.";
    }
    else {
        if (n % 10 == 1) return result += "st.";
        if (n % 10 == 2) return result += "nd.";
        if (n % 10 == 3) return result += "rd.";
        return result += "th.";
    }


}
