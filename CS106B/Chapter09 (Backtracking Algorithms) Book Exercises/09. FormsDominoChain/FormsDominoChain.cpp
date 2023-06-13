/*
 * File: FormsDominoChain.cpp
 * --------------
 * The game of dominos is played with rectangular pieces composed of two connected squares,
 * each of which is marked with a certain number of dots. For example, each of the
 * following four rectangles represents a domino:
 *
 * Dominos can be connected end-to-end to form chains, subject to the condition that two dominos can be
 * linked together only if the numbers match. For example, you can form a chain consisting of these four
 * dominos by connecting them in the following order:
 *
 * As in the traditional game, dominos can be rotated by 180 ̊ so that their numbers are reversed. In this chain,
 * for example, the 1–6 and 3–4 dominos have been “turned over” so that they fit into the chain.
 * Suppose that you have access to a Domino class (see Chapter 6, exercise 1) that exports the methods
 * getLeftDots and getRightDots. Given this class, write a recursive function
 *
 *          bool formsDominoChain(Vector<Domino> & dominos);
 *
 * that returns true if it possible to build a chain consisting of every domino in
 * the vector.
 */

#include "console.h"
#include "simpio.h"
#include "domino.h"
#include "vector.h"

using namespace std;
Vector<Domino> fillDominoPairs();
bool formsDominoChain(Vector<Domino> & dominos);
bool combineDominos(Vector<Domino> & dominos, int index);
bool allLink(Vector<Domino> dominos);
bool generateAllPairs(Vector<Domino> & dominos);

Vector<Domino> solvedPairs();


int main() {
    Vector<Domino> dominos = fillDominoPairs();
    cout << "Sequence starts as: " << dominos << endl;

    if (formsDominoChain(dominos)) {
        cout << "Sequence with connecting paits is:" << dominos << endl;

    } else cout << "Sequence can't Link" << endl;

    return 0;
}

bool allLink(Vector<Domino> dominos, int pairs){
    int target = pairs - 1;
    for (int var = 0; var < dominos.size() - 1 ; ++var) {
        if (dominos[var].getRightDots() == dominos[var + 1].getLeftDots()) {
            target--;
            if (target == 0) return true;
        }
    }
    return false;
}

bool combineDominos(Vector<Domino> & dominos, int index, int pairs){
    Vector<Domino> duplicatePairs = dominos;
    if (duplicatePairs.size() == pairs && allLink(duplicatePairs, pairs )) return true;
    if (index < 0) return false;
    else {
        for (int var = 0; var < duplicatePairs.size(); ++var) {
               Domino temp = duplicatePairs[var];
               duplicatePairs.remove(var);
               for (int i = 0; i <= duplicatePairs.size(); ++i) {
                   duplicatePairs.insert(i, temp);
                   if (combineDominos(duplicatePairs, index - 1, pairs)) {
                       dominos = duplicatePairs;
                       return true;
                   }
                   duplicatePairs[i].invert(duplicatePairs[i]);
                   if (combineDominos(duplicatePairs, index - 1, pairs)) {
                       dominos = duplicatePairs;
                       return true;
                   }
                   else duplicatePairs.remove(i);
               }
       }
    }
    return false;
}

bool formsDominoChain(Vector<Domino> & dominos){
    if (combineDominos(dominos, dominos.size(), dominos.size())) return true;
    return false;
}


Vector<Domino> fillDominoPairs(){
    Vector<Domino> results;
    Domino one(1,4);
    Domino two(1,6);
    Domino three(2,6);
    Domino four(3,4);
/*  Solved
    Domino one(2,6);
    Domino two(6,1);
    Domino three(1,4);
    Domino four(4,3);
 */
    results.add(two);
    results.add(three);
    results.add(one);
    results.add(four);

    return results;
}

Vector<Domino> solvedPairs(){
    Vector<Domino> results;
    Domino one(2,6);
    Domino two(6,1);
    Domino three(1,4);
    Domino four(4,3);
    results.add(one);
    results.add(two);
    results.add(three);
    results.add(four);
    return results;
}
