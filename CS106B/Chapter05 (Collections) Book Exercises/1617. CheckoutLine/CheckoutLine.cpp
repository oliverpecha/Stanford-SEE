/*
 * File: CheckoutLine.cpp
 * ----------------------
 * 16. The checkout-line simulation in Figure 5-5 can be extended to investigate important
 * practical questions about how waiting lines behave. As a first step, rewrite the simulation
 * so that there are several independent queues, as is usually the case in supermarkets.
 * A customer arriving at the checkout area finds the shortest checkout line and enters that queue.
 * Your revised simulation should calculate the same results as the simulation in the chapter.
 *
 * 17. As a second extension to the checkout-line simulation, change the program from the previous
 * exercise so that there is a single waiting line served by multiple cashiers—a practice that has
 * become more common in recent years. In each cycle of the simulation, any cashier that becomes
 * idle serves the next customer in the queue. If you compare the data produced by this exercise
 * and the preceding one, what can you say about the relative advantages of these two strategies?
*/

/*
 * This program simulates a checkout line, such as one you
 * might encounter in a grocery store. Customers arrive at
 * the checkout stand and get in line. Those customers wait
 * in the line until the cashier is free, at which point
 * they are served and occupy the cashier for some period
 * of time. After the service time is complete, the cashier
 * is free to serve the next customer in the line.
 *
 * In each unit of time, up to the constant SIMULATION_TIME,
 * the following operations are performed:
 *
 * 1. Determine whether a new customer has arrived.
 *   New customers arrive randomly, with a probability
 *   determined by the constant ARRIVAL_PROBABILITY.
 *
 * 2. If the cashier is busy, note that the cashier has
 *   spent another minute with that customer. Eventually,
 *   the customer's time request is satisfied, which frees
 *   the cashier.
 *
 * 3. If the cashier is free, serve the next customer in line.
 *   The service time is taken to be a random period between
 *   MIN_SERVICE_TIME and MAX_SERVICE_TIME.
 *
 * At the end of the simulation, the program displays the
 * simulation constants and the following computed results:
 *
 * o The number of customers served
 * o The average time spent in line
 * o The average number of people in line
 */

#include <iostream>
#include <iomanip>
#include "queue.h"
#include "random.h"
#include "console.h"
using namespace std;

/* Constants */
// default 0.05
const double ARRIVAL_PROBABILITY = 0.05;
// default 5
const int MIN_SERVICE_TIME = 5;
const int MAX_SERVICE_TIME = 15;
// default 2000
const int SIMULATION_TIME = 2000;
const int N_CASHIERS = 1;

/* Function prototypes */
void runSimulation (Vector<int> & nServed, Vector<int> & totalWait, Vector<int> & totalLength, int & cashiers);
void printReport (Vector<int> & nServed, Vector<int> & totalWait, Vector<int> & totalLength, int & cashiers);
int vecAverage(Vector<int> & vector);
int vecSum(Vector<int> & vector);

/* Main program */
int main() {
    int cashiers = N_CASHIERS;
    Vector<int> nServed(cashiers);
    Vector<int> totalWait(cashiers);
    Vector<int> totalLength(cashiers);
    runSimulation (nServed, totalWait, totalLength, cashiers);
    printReport (nServed, totalWait, totalLength, cashiers);
    return 0;
}

/*
 * Function: runSimulation
 * Usage: runSimulation();
 *
 * This function runs the actual simulation. The number of
 * customers served, the sum of the customer waiting times,
 * and the sum of the queue length in each time step are
 * returned through the reference parameters.
*/
int shortestQueue(Vector < Queue<int> > & nQueue){
    int shortestQueue = 0;
    if (nQueue.size() > 2) {
        for (int i = 0; i < nQueue.size(); i++) {
            if (nQueue[i].size() < shortestQueue) shortestQueue = i;
        }
    }
    //else shortest = 0;
    //cout <<nQueue[0].size() << endl;

    //cout <<shortest << endl;
    return shortestQueue;
}
void runSimulation (Vector<int> & nServed, Vector<int> & totalWait, Vector<int> & totalLength, int & cashiers) {

    Vector < Queue<int> > nQueue (cashiers);
    Vector <int> serviceTimeRemaining(cashiers);
    for (int t = 0; t < SIMULATION_TIME; t++) {
        // A customer arrives at a given chance and is assigned to shortest queue
        if (randomChance (ARRIVAL_PROBABILITY)) {
            nQueue[shortestQueue(nQueue)].enqueue(t);
        }
        // discount time for each cashier servicing, if cashier is servicing, will effective loop
        for (int var = 0; var < nQueue.size(); ++var) {
            if (serviceTimeRemaining[var] > 0) {
                serviceTimeRemaining[var]--;
            // if cashier is not servicing & (if) there is people waiting. Totalwait is calculated, new person serviced is counted and a service time is estimated
            } else if (!nQueue[var].isEmpty()) {
                totalWait[var] += t - nQueue[var].dequeue();
                nServed[var]++;
                serviceTimeRemaining[var] = randomInteger(MIN_SERVICE_TIME, MAX_SERVICE_TIME);
            }
            //current queue size is added. Will be average at printing
            totalLength[var] += nQueue[var].size();
        }
    }
}

/*
 * Function: printReport
 * Usage: printReport (nServed, totalWait, totalLength);
 *
 * This function reports the results of the simulation.
*/


void printReport (Vector<int> & nServed, Vector<int> & totalWait, Vector<int> & totalLength, int & cashiers) {
    cout << "Simulation results given the following constants:" << endl;
    cout << fixed << setprecision (2);
    cout << "  SIMULATION_TIME:     " << setw (4)
         << SIMULATION_TIME << endl;
    cout << "  ARRIVAL_PROBABILITY: " << setw (4)
         << ARRIVAL_PROBABILITY << endl;
    cout << "  NUMBER OF CASHIERS:  " << setw (4)
         << N_CASHIERS << endl;
    cout << "  MIN_SERVICE_TIME:    " << setw (4)
         << MIN_SERVICE_TIME << endl;
    cout << "  MAX_SERVICE_TIME:    " << setw (4)
         << MAX_SERVICE_TIME << endl;
    cout << endl;
    cout << "Customers served:      " << setw (4) << vecSum(nServed) << endl;
    cout << "Average waiting time:  " << setw (4)
         << double(vecAverage(totalWait)) / vecAverage(nServed) << endl;
    cout << "Average queue length:  "<< setw (4)
         << double(vecAverage(totalLength)) / SIMULATION_TIME << endl;
}

int vecAverage(Vector<int> & vector) {
    int result = 0;
    for (int var = 0; var < vector.size(); ++var) {
        result += vector[var];
    }
    return result / vector.size();
}

int vecSum(Vector<int> & vector) {
    int result = 0;
    for (int var = 0; var < vector.size(); ++var) {
        result += vector[var];
    }
    return result;
}
