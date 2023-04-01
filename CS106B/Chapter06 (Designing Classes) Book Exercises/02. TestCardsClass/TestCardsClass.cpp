/*
 * File: main.cpp
 * --------------
 * Blank C++ project configured to use Stanford cslib and Qt
 */

#include "console.h"
#include "simpio.h"
#include "cards.h"
using namespace std;


int main() {

    for (Cards::Suit suit = Cards::CLUBS; suit < Cards::UNRECOGNIZED; suit++) {
        for (int rank = constants::ACE; rank <= constants::KING; rank++) {
            Cards temp(rank, suit);
            cout << " " << Cards(rank, suit);
        }
        cout << endl;
    }


    return 0;
}
