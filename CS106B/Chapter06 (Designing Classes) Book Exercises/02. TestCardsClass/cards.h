#ifndef CARDS_H
#define CARDS_H

#include <iostream>
#include <string>

namespace constants {
const int ACE = 1;
const int JACK = 11;
const int QUEEN = 12;
const int KING = 13;

}

class Cards {

public:

    enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES, UNRECOGNIZED};

/* Constructors */

    Cards();
    Cards(std::string str);
    Cards(int number, enum Suit);

/* Methods */
    int getRank();
    Suit getSuit();
    void setRank(int n);
    void setSuit(char param);
    std::string toString();
    std::string suit2string();
    std::string rank2string();



private:

/* Instance variables */
    int rank;
    Suit suits;
};

/* Operators */
std::ostream & operator<<(std::ostream & os, Cards p1);
Cards::Suit operator++(Cards::Suit & suit, int);


#endif // CARDS_H
