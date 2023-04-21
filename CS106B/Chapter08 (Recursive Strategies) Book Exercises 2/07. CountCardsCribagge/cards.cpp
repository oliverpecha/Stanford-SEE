#include "cards.h"
#include <string>
#include "console.h"
#include <error.h>

using namespace std;


char extractCardConfig(std::string & str);
bool isSuit(char n);
int translateRank(std::string str);
Cards::Suit string2Suit(char param);

/* Constructors */

    Cards::Cards() {
    }

    Cards::Cards(int number, Suit type){
        rank = number;
        suits = type;
    }

    Cards::Cards(std::string str) {
            char param = extractCardConfig(str);
            rank = translateRank(str);
            suits = string2Suit(param);
    }


/* Methods */

    int Cards::getRank() {
        return rank;
    }

    Cards::Suit Cards::getSuit() {
        return suits;
    }

    void Cards::setRank(int n) {
       rank = n;
    }

    void Cards::setSuit(char param) {
       suits = string2Suit(param);
    }

   std::string Cards::suit2string(){
        switch (suits) {
            case UNRECOGNIZED:
                 return "Unrecognized Suit";
            case CLUBS:
                 return "C";
            case DIAMONDS:
                 return "D";
            case HEARTS:
                 return "H";
            case SPADES:
                 return "S";
        }
   }

   std::string Cards::rank2string(){
        switch (rank) {
            case 1:
                 return "A";
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                 return std::to_string(rank);
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                 return "not recognized";
        }
   }

    std::string Cards::toString(){
        return rank2string() + suit2string();
    }


/* Operators */

    std::ostream & operator<<(std::ostream & os, Cards p1){
        return os << p1.toString();
    }

    Cards::Suit operator++(Cards::Suit & suit, int){
        Cards::Suit result = suit;
        //suit = Cards::HEARTS;
        switch (result) {
             case Cards::CLUBS:
                 suit =  Cards::DIAMONDS;
                 break;
             case Cards::DIAMONDS:
                 suit =  Cards::HEARTS;
                 break;
             case Cards::HEARTS:
                 suit = Cards::SPADES;
                 break;
            case Cards::SPADES:
                 suit = Cards::UNRECOGNIZED;
                 break;
             default:
                suit =  Cards::UNRECOGNIZED;
        }
        return result;
    }
  /*
    Colors operator++( Colors &c, int ) {
      Colors result = c;
      ++c;
      return result;
    }*/

/* Functions */
    Cards::Suit string2Suit(char param) {
        switch (param) {
             case 'C':
                 return Cards::CLUBS;
             case 'D':
                 return Cards::DIAMONDS;
             case 'H':
                 return Cards::HEARTS;
             case 'S':
                 return Cards::SPADES;
             default:
                return Cards::UNRECOGNIZED;
        }
    }


    int translateRank(std::string str){
        if (str.size() == 1) {
            switch (str[0]) {
                case 'A':
                    return constants::ACE;
                case 'J':
                    return constants::JACK;
                case 'Q':
                    return constants::QUEEN;
                case 'K':
                    return constants::KING;
                default:
                    return std::stoi(str);
            }
        }
        else if (str[0] == '1' && str[1] == '0') return 10;
        else if (str[0] == '1' && str[1] == '1') return constants::JACK;
        else if (str[0] == '1' && str[1] == '2') return constants::QUEEN;
        else if (str[0] == '1' && str[1] == '3') return constants::KING;
        return -1;
    }

    bool isSuit(char n){
        if (n == 'C' || n == 'D' || n == 'H' || n == 'S') return true;
        else return false;
    }

    char extractCardConfig(std::string & str) {
        char result;
        if (str.length() - 1 > 0 && isSuit(str[str.length() - 1])) {
            result = str[str.length()-1];
        }
        else result = 'X';
        str.erase(str.length()-1);
        return result;
    }
