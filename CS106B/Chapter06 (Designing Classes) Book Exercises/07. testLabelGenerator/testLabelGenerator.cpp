/*
 * File: testLabelGenerator.cpp
 * --------------
 * For certain applications, it is useful to be able to generate a series of
 * names that form a sequential pattern. For example, if you were writing a
 * program to number figures in a paper, having some mechanism to return the
 * sequence of strings "Figure1", "Figure2", "Figure3", and so on, would be
 * very handy. However, you might also need to label points in a geometric
 * diagram, in which case you would want a similar but independent set of
 * labels for points such as "P0", "P1", "P2", and so forth.
 *
 * If you think about this problem more generally, the tool you need is a
 * label generator that allows the client to define arbitrary sequences of
 * labels, each of which consists of a prefix string ("Figure " or "P" for
 * the examples in the preceding paragraph) coupled with an integer used
 * as a sequence number. Because the client may want different sequences
 * to be active simultaneously, it makes sense to define the label generator
 * as a LabelGenerator class. To initialize a new generator, the client
 * provides the prefix string and the initial index as arguments to the
 * Label Generator constructor. Oncethegenerator has been created, the
 * client can return new labels in the sequence by calling nextLabel
 * on the LabelGenerator.
 *
 * As an illustration of how the interface works, the main program shown
 * in Figure 6-14 produces the following sample run:
 *
 * Write the files labelgen.h and labelgen.cpp to support this class.
 */

#include "console.h"
#include "simpio.h"
#include "labelgen.h"
using namespace std;




int main() {
    LabelGen figureNumbers ("Figure ", 1);
    LabelGen pointNumbers("P", 0);
    cout << "Figure numbers: ";
    for (int i = 0; i < 3; i++) {
        if (i > 0) cout << ", ";
        cout << figureNumbers.nextLabel();
    }
    cout << endl << "Point numbers: ";
    for (int i = 0; i < 5; i++) {
        if (i > 0) cout << ", ";
        cout << pointNumbers.nextLabel();
    }
    cout << endl << "More figures: ";

    for (int i = 0; i < 3; i++) {
        if (i > 0) cout << ", ";
        cout << figureNumbers.nextLabel();
    }
    cout << endl;
    return 0;
}
