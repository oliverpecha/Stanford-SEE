/*
 * File: Roll.cpp
 * --------------
 * The figures in this book are created using PostScript®, a powerful graphics language developed by
 * the Adobe Corporation in the early 1980s. PostScript programs store their data on a stack.
 * Many of the operators available in the PostScript language have the effect of manipulating the
 * stack in some way. You can, for example, invoke the pop operator, which pops the top element off
 * the stack, or the exch operator, which swaps the top two elements.
 *
 * One of the most interesting (and surprisingly useful) PostScript operators is the roll operator,
 * which takes two arguments: n and k. The effect of applying roll(n, k) is to rotate the top n elements
 * of a stack by k positions, where the general direction of the rotation is toward the top of the stack.
 * More specifically, roll(n, k) has the effect of removing the top n elements, cycling the top element
 * to the last position k times, and then replacing the reordered elements back on the stack.
 *
 * Figure 5-14 shows before and after pictures for three different examples of roll.
 *
 *  image
 *
 * Write a function
 *            void roll(Stack<char> & stack, int n, int k)
 * that implements the roll(n, k) operation on the specified stack. Your implementation should check that
 * n and k are both nonnegative and that n is not larger than the stack size; if either of these
 * conditions is violated, your implementation should call error with the message
 *
 *         roll: argument out of range
 *
 * Note, however, that k can be larger than n, in which case the roll operation continues through more than
 * a complete cycle. This case is illustrated in the final example in Figure 5-14, in which the top
 * two elements on the stack are rolled four times, leaving the stack exactly as it started.
 */

#include "console.h"
#include "simpio.h"
#include "stack.h"
#include "vector.h"


using namespace std;

void roll(Stack<char> & stack, int n, int k);
void fillstack(Stack<char> & stack, int n);
void printStack(Stack<char> & stack);

const string ERROR_MSG = " roll: argument out of range";
const int CANDIDATES = 4;
const int N_CHAR = 2;
const int K_TIMES = 7;
const char CHAR_START = 'A';

int main() {
    Stack<char> candidates;
    fillstack(candidates, CANDIDATES);

    //Vector<char> letterCounts(candidates.size());
    //cout << letterCounts << endl;

    if ( N_CHAR < 0 || K_TIMES < 0 || N_CHAR > candidates.size()) {
        cerr << ERROR_MSG;
    }
    else {
        printStack(candidates);
        roll(candidates, N_CHAR, K_TIMES);
        printStack(candidates);
    }
    return 0;
}

void roll(Stack<char> & stack, int n, int k) {
    Vector<char> buffer;
    Vector<char> helper(n);
    // resets k to only the strict positions needed without rolling more times than necessary
    if (k > n) k = k % n;
    if (k != 0) {
        // transfer n values from stack to buffer
        for (int var = 0; var < n; ++var) {
            buffer.add(stack.pop());
        }
        // roll buffer k positions using a helper
        for (int var = 0; var < buffer.size(); ++var) {
            int newpos;
            if (var - k < 0) {
                newpos = var - k + buffer.size();
            }
            else newpos = var - k;
            helper.set(newpos, buffer[var]);
        }
        // return helper (rolled buffer) into stack
        for (int var = helper.size() - 1; var >= 0; --var) {
           stack.push(helper[var]);
        }
    }
}

void fillstack(Stack<char> & stack, int n){
    char start = CHAR_START;
    for (int var = 0; var < n; ++var) {
        stack.push(start + var);
    }
}

void printStack(Stack<char> & stack){
    Stack<char> helper;
    while (!stack.isEmpty()) {
        cout << " | " << stack.peek() << " | " << endl;
        helper.push(stack.pop());
    }
    cout << "  ---  \n" << endl;
    while (!helper.isEmpty()) {
        stack.push(helper.pop());
    }

}
