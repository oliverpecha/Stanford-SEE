/*
 * File: ReverseOrder.cpp
 * --------------
 * And the first one now Will later be last For the times they are a-changin’. —Bob Dylan, “The Times They Are a-Changin’,” 1963
 *
 * Following the inspiration from Bob Dylan’s song (which is itself inspired by Matthew 19:30), write a function
 *
 *        void reverseQueue(Queue<string> & queue);
 *
 * that reverses the elements in the queue. Remember that you have no access to the internal representation
 * of the queue and must therefore come up with an algorithm—presumably involving other structures—that accomplishes the task.
 */

#include "console.h"
#include "simpio.h"
#include "stack.h"
#include "queue.h"
#include <sstream>
using namespace std;

void reverseQueue(Queue<string> & queue);

int main() {
    string original = "And the first one now Will later be last For the times they are a-changin";
    cout << original << endl;

    istringstream iss(original);
    Queue<string> queue;
    Stack<string> ledger;
    string buffer;

    while (iss >> buffer) {
        queue.enqueue(buffer);
    }
    while (!queue.isEmpty()) ledger.push(queue.dequeue());
    while (!ledger.isEmpty()) cout << ledger.pop() << endl;

    return 0;
}
