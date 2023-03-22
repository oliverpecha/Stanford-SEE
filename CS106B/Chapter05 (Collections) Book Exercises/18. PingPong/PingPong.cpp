/*
 * File: PingPong.cpp
 * --------------
 * Write a program to simulate the following experiment, which was included in the 1957 Disney
 * film Our Friend the Atom, to illustrate the chain reactions involved in nuclear fission.
 * The setting for the experiment is a large cubical box, the bottom of which is completely
 * covered with 625 mousetraps arranged to form a square grid 25 mousetraps on a side.
 * Each of the mousetraps is initially loaded with two ping-pong balls. At the beginning of the
 * simulation, an additional ping-pong ball is released from the top of the box and falls on one
 * of the mousetraps. That mousetrap springs and shoots its two ping-pong balls into the air.
 * The ping-pong balls bounce around the sides of the box and eventually land on the floor,
 * where they are likely to set off more mousetraps.
 *
 * In writing this simulation, you should make the following simplifying assumptions:
 *
 *  • Every ping-pong ball that falls always lands on a mousetrap, chosen randomly by selecting
 * a random row and column in the grid. If the trap is loaded, its balls are released into the air.
 * If the trap has already been sprung, having a ball fall on it has no effect.
 *
 *  • Once a ball falls on a mousetrap—whether or not the trap is sprung—that ball stops and
 * takes no further role in the simulation.
 *
 *  • Balls launched from a mousetrap bounce around the room and land again after a random number
 * of simulation cycles have gone by. That random interval is chosen independently for each ball
 * and is always between one and four cycles.
 *
 * Your simulation should run until there are no balls in the air. At that point, your program
 * should report how many time units have elapsed since the beginning, what percentage of the traps
 * have been sprung, and the maximum number of balls in the air at any time in the simulation.
 */

#include <iostream>
#include <iomanip>
#include "vector.h"
#include "random.h"
#include "console.h"
using namespace std;



/* Function prototypes */
void runSimulation ();
void tRuns(int & ballActionT, Vector <int> & ballsInAirVec, int & ballsInAirMax);
void throwNballs(Vector<int> & ballsInAirVec, int n);
void printReport();
int loadedTrapCount();
int ballsToLand(Vector<int> & ballsInAirVec);
void loadTrapVec(Vector<Vector<bool>> & trapVec);

/* Constants */
const int MIN_AIR_TIME = 1;
const int MAX_AIR_TIME = 5;
const int GRID_SIZE = 25;
const int BALLS_X_TRAP = 2;
int ballActionT = 0;
int ballsInAirMax = 0;
int tTargets = 0;
int tTargetsMax = 0;
bool ballAction;
Vector <int> ballsInAirVec;
Vector<Vector<bool>> trapVec(GRID_SIZE, Vector<bool>(GRID_SIZE)); // <------ improve with Grid

int trapActivated = 0;

/* Main program */
int main() {
    for (int var = 0; var < 4; ++var) {
        runSimulation();
        printReport();
        random();
        cout<< endl;
    }
    return 0;
}



void runSimulation(){
    loadTrapVec(trapVec);
    throwNballs(ballsInAirVec, 1);
    if (ballsInAirVec.size() > 0) ballAction = true;
    while (ballAction) {
        tTargets = ballsToLand(ballsInAirVec);
        for (int i = tTargets; i > 0; i--){
            Vector<int> pos { randomInteger(0, GRID_SIZE - 1), randomInteger(0, GRID_SIZE - 1) };
            if (trapVec[pos[0]][pos[1]]) {
                throwNballs(ballsInAirVec, BALLS_X_TRAP);
                trapVec[pos[0]][pos[1]] = false;
                trapActivated++;
            }
        }
        if (tTargets > tTargetsMax) tTargetsMax = tTargets;
        tRuns(ballActionT, ballsInAirVec, ballsInAirMax);
        if (ballsInAirVec.size() < 1) ballAction = false;
    }
}


void tRuns(int & ballActionT, Vector <int> & ballsInAirVec, int & ballsInAirMax){
    /*for (int airball : ballsInAirVec) {
        if (ballsInAirVec[airball] - 1 >= 0) ballsInAirVec[airball] -= 1;
        else ballsInAirVec.remove(airball);
    }*/
    if (ballsInAirVec.size() > ballsInAirMax) ballsInAirMax = ballsInAirVec.size();
    for (int i = 0; i < ballsInAirVec.size(); i++) {
        if (ballsInAirVec[i] - 1 >= 0) ballsInAirVec[i] -= 1;
        else ballsInAirVec.remove(i);
    }
    if (ballsInAirVec.size() > 0) ballActionT++;
}

void throwNballs(Vector<int> & ballsInAirVec, int n) {
    for (int var = 0; var < n; ++var) {
        ballsInAirVec.add(randomInteger(MIN_AIR_TIME, MAX_AIR_TIME));
    }
}

int ballsToLand(Vector <int> & ballsInAirVec){
    int ballsToLand = 0;
    for (int i = 0; i < ballsInAirVec.size(); i++) {
        if (ballsInAirVec[i] == 0) ballsToLand++;
    }
    return ballsToLand;
}

void loadTrapVec(Vector<Vector<bool>> & trapVec){
    for (int y = 0; y < trapVec.size(); ++y) {
        for (int x = 0; x < trapVec[0].size(); ++x) {
            trapVec[y][x] = true;
        }
    }
}


//----
// Print simulation results. NEED:
//- Lenght of ballAction
//- percentage of the traps have been sprung
//- maximum number of balls in the air at any time in the simulation

void printReport() {
    cout << "\nRESULT... It took " << ballActionT << " deciseconds for balls to stop simulation" << endl;
    cout << "Out of a total of " << GRID_SIZE * GRID_SIZE << " traps, " << loadedTrapCount() << " (" << 100 * loadedTrapCount() / (GRID_SIZE * GRID_SIZE) << "%) were not hit." << endl;
    cout << "The maximum balls in the air at a given time were " << ballsInAirMax << endl;
    cout << tTargetsMax << " were the maximum balls to hit traps at the same time" << endl;
}

int loadedTrapCount(){
    int loaded = 0;
    for (int y = 0; y < trapVec.size(); ++y) {
        for (int x = 0; x < trapVec[0].size(); ++x) {
            if (trapVec[y][x]) loaded++;
        }
    }
    return loaded;
}
