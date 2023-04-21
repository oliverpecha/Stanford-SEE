/*
 * File: main.cpp
 * --------------
 * In the card game called Cribbage, part of the game consists of adding up the
 *  score from a set of five playing cards. One of the components of the score
 *  is the number of distinct card combinations whose values add up to 15, with
 *  aces counting as 1 and all face cards (jacks, queens, and kings) counting
 *  as 10. Consider, for example, the following cards:
 *
 *  There are three different combinations that sum to 15, as follows:
 *
 *  AD + 10S + 4H AD + 5C + 9C 5C + 10S
 *
 *  As a second example, the cards
 *
 *  contain the following eight different combinations that add up to 15:
 *
 *  5C + JC     5D + JC     5H + JC     5S + JC
 *
 *  5C + 5D + 5H        5C + 5D + 5S    5C + 5H + 5S    5D + 5H + 5S
 *
 *  Write a function
 *
 *             int countFifteens(Vector<Card> & cards);
 *
 *  that takes a vector of Card values (as defined in Chapter 6, exercise 2)
 *  and returns the number of ways you can make 15 from that set of cards.
 *  You don’t need to know much about the Card class to solve this problem.
 *  The only thing you need is the getRank method, which returns the rank of
 *  the card as an integer. You may assume that the card.h interface exports
 *  the constant names ACE, JACK, QUEEN, and KING with the values 1, 11, 12,
 *  and 13, respectively.
 *
 */

#include "console.h"
#include "simpio.h"
#include "cards.h"
#include "vector.h"
#include "set.h"
#include "tokenscanner.h"

using namespace std;

Vector<Cards> input2cards(string input);
int countFifteens(Vector<Cards> & cards, Vector<Vector<Cards>> & cases);
int sumScores(Cards element, Vector<Cards>rest);
bool sameCombo(Vector<Cards> senior, Vector<Cards> candidate);
bool found(Vector<Vector<Cards>> & cases, Vector<Cards> candidate);
void printCases(Vector<Vector<Cards>> cases);


int main() {
    Vector<string> inputGroup {
        "AD + 10S + 4H AD + 5C + 9C 5C + 10S ",
        "5C + JC 5D + JC 5H + JC 5S + JC 5C + 5D + 5H 5C + 5D + 5S 5C + 5H + 5S 5D + 5H + 5S"
    };
    for (string input : inputGroup) {
        Vector<Cards> cards = input2cards(input);
        Vector<Vector<Cards>> cases;
        cout << "There is " << countFifteens(cards, cases) << " combinations that add 15 in set: " << cards << endl;
        cout << "Combinations are: " << endl;
        printCases(cases);
        cout << "\n" << endl;
    }
    return 0;
}


int countFifteens(Vector<Cards> & cards, Vector<Vector<Cards>> & cases) {
    int result = 0;
    if (cards.isEmpty()) return 0;
    else {
        for (int var = 0; var < cards.size(); ++var) {
            Cards element = cards.get(var);
            Vector<Cards> rest = cards;
            rest.remove(var);
            if (sumScores(element, rest) == 15) {
                rest.add(element);
                if (!found(cases, rest)) {
                    cases.add(rest);
                    result += 1;
                }
            }
            else result += countFifteens(rest, cases);
        }
    }
    return result;
}

int sumScores(Cards element, Vector<Cards>rest){
    int total = 0;
    rest.add(element);
    for (Cards s : rest) {
        if (s.getRank() > 9) total += 10;
        else total += s.getRank();
    }
    return total;
}

bool found(Vector<Vector<Cards>> & cases, Vector<Cards> candidate) {
    for (int var = 0; var < cases.size(); ++var) {
        if (cases.get(var).size()  == candidate.size()) {
            if (sameCombo(cases.get(var), candidate)) return true;
        }
    }
    return false;
}

bool sameCombo(Vector<Cards> senior, Vector<Cards> candidate){
    int count = candidate.size();
    for (int y = 0; y < candidate.size(); ++y) {
        Cards c = candidate.get(y);
        for (int x = 0; x < senior.size(); ++x) {
            Cards s = senior.get(x);
            if (c.toString() == s.toString()) {
                count--;
            }
        }
    }
    if (count == 0) return true;
    else return false;
}

Vector<Cards> input2cards(string str) {
    Vector<Cards> result;
    Set<string> temp;
    TokenScanner input(str);
    input.ignoreWhitespace();
    while (input.hasMoreTokens()) {
        string s = input.nextToken();
        if (s != "+") temp.add(s);
    }
    for (string s : temp) result.add(s);
    return result;
}

void printCases(Vector<Vector<Cards>> cases) {
    for (Vector<Cards> v : cases) cout << v << endl;
}
