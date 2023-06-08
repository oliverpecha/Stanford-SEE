/*
 * File: InstantInsanity.cpp
 * --------------
 * In the 1960s, a puzzle called Instant Insanity was popular for some years before
 * it faded from view. The puzzle consisted of four cubes whose faces were each
 * painted with one of the colors red, blue, green, and white, represented in the
 * rest of this problem by their initial letter. The goal of the puzzle was to arrange
 * the cubes into a line so that if you looked at the line from any of its edges,
 * you would see no duplicated colors.
 *
 * Cubes are hard to draw in two dimensions, but the following diagram shows what
 * the cubes would look like if you unfolded them and placed them flat on the page:
 *  Write a program that uses backtracking to solve the Instant Insanity puzzle.
 */

#include "console.h"
#include "simpio.h"
#include "cube.h"
#include "set.h"

using namespace std;

// Load the type of Cube to run the main program
Vector<Cube> loadCubeBox(int name);
// Strategy #1
void combinator(Vector<Cube> & cubeBox,  Vector<Vector<Cube>> & combinations, Vector<Cube> & inheritance, int index);
bool isSinglefaceAllColors(Vector<Cube> & cubeBox, char face);
bool isAllfacesAllColors(Vector<Cube> & cubeBox);
// Strategy #2
Vector <Vector<Vector<char>>> listOppositeFacesOfBox (Vector<Cube> cubeBox);
Vector<Vector<char>> listOppositeFacesOfCube(Cube current);
void generatePossibleFaceCombinations(Vector <Vector<Vector<char>>> listOfOpposites, Vector <Vector<Vector<int>>> & candidatePairs, Vector<Vector<int>> inheritance, int indexY);
bool allColorsInGivenPair(Vector<Vector<int>> candidatePairs, Vector<Cube> cubeBox);
// Strategy #0
bool colorInSingleFace(Vector<Cube> & cubeBox, char face, char color);
bool singlefaceAllColors(Vector<Cube> & cubeBox, char face);
// Test rotating functionality
void rotationTester(Vector<Cube> cubeBox);
// Printers
void printCombinations(Vector<Vector<Cube>>combinations);
void printCubeBox(Vector<Cube> cubeBox);
void printOppositeFacesOfCube(Vector <Vector<Vector<char>>> allopositefaces);
void printCandidatePairs(Vector <Vector<Vector<int>>> candidatePairs, Vector<Cube> cubeBox);



int main() {
    // Load the type of Cube to run the main program
    // 1: textbook, 2: YT educative, 4: YT puzzle nerd
    Vector<Cube> cubeBox = loadCubeBox(1);
    cout << "Cube starts as" << endl;
    printCubeBox(cubeBox);
    // Performs a la carte rotations (purpose: test functionality)
    // rotationTester(cubeBox);

    /* Stretegy #1
     * ------------------------------------------------------
     */
    Vector<Vector<Cube>> combinations;
    Vector<Cube> inheritance;
    combinator(cubeBox, combinations, inheritance, 3);
    printCombinations(combinations);

    /* Stretegy #2
     * ------------------------------------------------------
     */
    Vector<Vector<int>> inheritanceInt;
    Vector <Vector<Vector<int>>> candidatePairs;
    Vector <Vector<Vector<char>>> oracle = listOppositeFacesOfBox(cubeBox);
    printOppositeFacesOfCube(oracle);
    generatePossibleFaceCombinations(oracle, candidatePairs, inheritanceInt, oracle.size()-1);
    printCandidatePairs(candidatePairs, cubeBox);

    /* Stretegy #0
     * ------------------------------------------------------
    Vector<Cube> tail;
    if (solvePuzzle(cubeBox, tail, 3)) {
        cout << "Solved Cube:" << endl;
        cubeBox2string(cubeBox);

    } else cout << "Can't solve" << endl;
    */
    return 0;
}



/*
 * Stretegy #1
 * ---------------------------------------------------------------------------
 */


void combinator(Vector<Cube> & cubeBox,  Vector<Vector<Cube>> & combinations, Vector<Cube> & inheritance, int index){
    if (index < 0);
    else {
        Vector<Cube> currentCubeBox = inheritance;
        currentCubeBox.insert(0, cubeBox.get(index));
        for (int var = 0; var < 4; ++var) {
            currentCubeBox[0].yaw();
            if (currentCubeBox.size() == 4) {
                combinations.add(currentCubeBox);
            }
            combinator(cubeBox, combinations, currentCubeBox, index - 1);
        }
        for (int var = 0; var < 4; ++var) {
            currentCubeBox[0].roll();
            if (currentCubeBox.size() == 4) {
                combinations.add(currentCubeBox);
            }
            combinator(cubeBox, combinations, currentCubeBox, index - 1);
        }
        for (int var = 0; var < 4; ++var) {
            currentCubeBox[0].pitch();
            if (currentCubeBox.size() == 4) {
                combinations.add(currentCubeBox);
            }
            combinator(cubeBox, combinations, currentCubeBox, index - 1);
        }
    }
}




/*
 * Functions to return if the cubeBox's 4 faces contain all the 4 colors
 * Faces required: 'F' Front, 'B' Back, 'T' Top, 'O' Bottom
 * ---------------------------------------------------------------------------
 */

bool isAllfacesAllColors(Vector<Cube> & cubeBox){
    int matchCount = 4;
    Vector<char> faces {'F', 'B', 'T', 'O'};
    for (int var = 0; var < 4; ++var) {
        if (isSinglefaceAllColors(cubeBox, faces[var])) {
            matchCount--;
        }
        if (matchCount == 0) return true;
    }
    return false;
}


bool isSinglefaceAllColors(Vector<Cube> & cubeBox, char face) {
  Set<char> colors {'B', 'W', 'R', 'G'};
    for (int var = 0; var < cubeBox.size(); ++var) {
        Cube tempCube = cubeBox.get(var);
        if (colors.contains(tempCube.getFace(face))) {
            colors.remove(tempCube.getFace(face));
        }
    }
    if (colors.isEmpty()) return true;
    else return false;
}



/*
 * Stretegy #2
 * ---------------------------------------------------------------------------
 * ---------------------------------------------------------------------------
 * ---------------------------------------------------------------------------
 */

Vector <Vector<Vector<char>>> listOppositeFacesOfBox (Vector<Cube> cubeBox) {
    Vector <Vector<Vector<char>>> result;
    for (int var = 0; var < cubeBox.size(); ++var) {
        result.add(listOppositeFacesOfCube(cubeBox.get(var)));
    }
    return result;
}

Vector<Vector<char>> listOppositeFacesOfCube(Cube current) {
    Vector<Vector<char>> result;
    Vector<char> line;
    line.add(current.getFront());
    line.add(current.getBack());
    result.add(line);
    line.clear();
    line.add(current.getLeft());
    line.add(current.getRight());
    result.add(line);
    line.clear();
    line.add(current.getTop());
    line.add(current.getBottom());
    result.add(line);
    line.clear();
    return result;
}


bool allColorsInGivenPair(Vector<Vector<int>> candidatePairs, Vector<Cube> cubeBox) {
    Set<char> first {'B', 'W', 'G', 'R'};
    Set<char> second =  first;
    for (int var = 0; var < candidatePairs.size(); ++var) {
        if (first.contains(cubeBox[var].getFace(candidatePairs[var][1]))) {
            first.remove(cubeBox[var].getFace(candidatePairs[var][1]));
        }
    }
    for (int var = 0; var < candidatePairs.size(); ++var) {
        if (second.contains(cubeBox[var].getFace(candidatePairs[var][1] + 1))) {
            second.remove(cubeBox[var].getFace(candidatePairs[var][1] + 1));
        }
    }
    //cout << "first.size(): " << first.size()<< " second.size(): " << second.size() << endl;
    if (first.isEmpty() && second.isEmpty()) return true;
    return false;
}


void generatePossibleFaceCombinations(Vector <Vector<Vector<char>>> listOfOpposites, Vector <Vector<Vector<int>>> & candidatePairs, Vector<Vector<int>> inheritance, int indexY){
    if (indexY < 0);
    else {
        // x numenclature to follow 0 for Front, 2 for Left (side) 4 for Top (eg: Back is 1 as Cube.cpp convention)
        for (int x = 0; x < 6; x += 2) {
            Vector<Vector<int>> result = inheritance;
            Vector<int> cylinder {indexY, x};
            result.add(cylinder);
            if (result.size() == 4) candidatePairs.add(result);
            generatePossibleFaceCombinations(listOfOpposites, candidatePairs, result, indexY - 1);
        }
    }
}




/*
 * Mini-program to input rotation instructions from the main function
 * ---------------------------------------------------------------------------
 */

void rotationTester(Vector<Cube> cubeBox) {
    string input = " ";
    while (input != "") {
        input = getLine("How to rotate? Enter: 1st Index, 2nd OriginFace, 3rd TargetFace ");
        if (input.size() == 3) {
             Cube temp = cubeBox[input[0] - 48];
             temp.rotator(temp, input[1], input[2]);
             cubeBox.set(input[0] - 48, temp);
             printCubeBox(cubeBox);
        } else cerr << "needs to be a 3 character instruction" << endl;
    }
}


/*
 * Printing Functions
 * ---------------------------------------------------------------------------
 */

void printCombinations(Vector<Vector<Cube>>combinations){
    int counter = 0;
    for (Vector<Cube> s : combinations) {
        counter++;
        if (isAllfacesAllColors(s)) {
            cout << "wohoaCube" << endl;
            printCubeBox(s);

        }
    }

    cout << "Combinations Counter: " << counter << endl;

}

void printCubeBox(Vector<Cube> cubeBox) {
    cout << "| FRONT |  BACK || LEFT  | RIGHT ||  TOP  | BOTTOM|" << endl;
    for (int var = 0; var < cubeBox.size(); ++var) {
        cubeBox[var].toString();
    }
}



void printOppositeFacesOfCube(Vector <Vector<Vector<char>>> alloppositefaces){
    for (int var = 0; var < alloppositefaces.size(); ++var) {
        Vector<Vector<char>> oppositefaces = alloppositefaces.get(var);
        for (int i = 0; i < oppositefaces.size(); ++i) {
            if (i == 0) {
                cout << "Cube in position " << var << ". Front/Back: ";
            }
            if (i == 1) {
                cout << ". Left/Right: ";
            }
            if (i == 2) {
                cout << ". Top/Bottom: ";
            }
            for (int n = 0; n < oppositefaces.get(i).size(); ++n) {
                            cout << oppositefaces.get(i).get(n);
            }
        }
        cout << endl;

    }
}



void printCandidatePairs(Vector <Vector<Vector<int>>> candidatePairs, Vector<Cube> cubeBox) {
    for (int var = 0; var < candidatePairs.size(); ++var) {

        if (allColorsInGivenPair(candidatePairs[var], cubeBox)) {
                 cout << candidatePairs[var] << endl;
        }
    }
}



/*
 * Loads one of the cubes
 * // 1: textbook, 2: YT educative, 4: YT puzzle nerd
 * ---------------------------------------------------------------------------
 */

Vector<Cube> loadCubeBox(int control) {
    Cube one;
    Cube two;
    Cube three;
    Cube four;
    switch (control) {
        //Textbook
        case 1:
            one.setFront('B');
            one.setBack('W');
            one.setLeft('B');
            one.setRight('R');
            one.setTop('G');
            one.setBottom('G');

            two.setFront('G');
            two.setBack('W');
            two.setLeft('W');
            two.setRight('B');
            two.setTop('R');
            two.setBottom('G');

            three.setFront('W');
            three.setBack('R');
            three.setLeft('R');
            three.setRight('B');
            three.setTop('W');
            three.setBottom('G');

            four.setFront('R');
            four.setBack('G');
            four.setLeft('R');
            four.setRight('R');
            four.setTop('B');
            four.setBottom('W');
            break;

        // YT Educational
        case 2:
            one.setFront('G');
            one.setBack('R');
            one.setLeft('W');
            one.setRight('B');
            one.setTop('R');
            one.setBottom('R');

            two.setFront('B');
            two.setBack('R');
            two.setLeft('W');
            two.setRight('G');
            two.setTop('R');
            two.setBottom('W');

            three.setFront('R');
            three.setBack('B');
            three.setLeft('B');
            three.setRight('W');
            three.setTop('G');
            three.setBottom('G');

            four.setFront('R');
            four.setBack('G');
            four.setLeft('W');
            four.setRight('G');
            four.setTop('B');
            four.setBottom('W');
            break;

        // YT Puzzle nerd
        case 3:
            one.setFront('W');
            one.setBack('G');
            one.setLeft('B');
            one.setRight('R');
            one.setTop('G');
            one.setBottom('R');

            two.setFront('G');
            two.setBack('R');
            two.setLeft('B');
            two.setRight('W');
            two.setTop('W');
            two.setBottom('R');

            three.setFront('B');
            three.setBack('W');
            three.setLeft('G');
            three.setRight('G');
            three.setTop('R');
            three.setBottom('B');

            four.setFront('R');
            four.setBack('B');
            four.setLeft('W');
            four.setRight('W');
            four.setTop('G');
            four.setBottom('W');
            break;

        default:
            break;
        }
        // Others used
         /* Solved
        Cube one('W', 'B', 'R', 'G', 'G', 'G');
        Cube two('G', 'W', 'B', 'R', 'R', 'G');
        Cube three('B', 'R', 'W', 'B', 'W', 'G');
        Cube four('R', 'G', 'G', 'W', 'B', 'W');
         * Experiment
        Cube one('B', 'W', 'B', 'R', 'W', 'B');
        Cube two('G', 'W', 'W', 'B', 'G', 'W');
        Cube three('W', 'R', 'R', 'B', 'B', 'R');
        Cube four('R', 'G', 'R', 'R', 'R', 'G');
        */

    Vector<Cube> result {one, two, three, four};
    return result;
}



/*
 * Stretegy #0
 * ---------------------------------------------------------------------------
 * ---------------------------------------------------------------------------
 * ---------------------------------------------------------------------------
 */

/*
bool solvePuzzle(Vector<Cube> & cubeBox, Vector<Cube> & tail, int index){
    Vector<Cube> head = cubeBox.subList(0, index + 1);
    Vector<Cube> box = head + tail;
    cout << "TRY______________________________ with " <<  box.size() << " cubes. head: " << head.size() << ". tail: " << tail.size() << ". index " << index << endl;
    //cubeBox2string(box);
    if (box.size() == 4 && isAllfacesAllColors(box)) {
        cubeBox = box;
        return true;
    }
    if (index < 1) {
        //cout << "DONEEEE!(((((((((((((((((((((((((((((((((((" << endl;
        return false;
    }
    else {
        Cube cylinder = cubeBox.get(index);
        Vector<Cube> sub  = cubeBox.subList(index-1, 3 - index);
        cout << sub.size() << endl;
        for (int var = 0; var < 4; ++var) {
            //Vector<Cube> sub = tail;
            cylinder.yaw();
            cubeBox.set(index, cylinder);
            //sub.insert(0, cylinder);
            //cout << "i1" << index - 1<<  endl;
            if (solvePuzzle(cubeBox, sub, index - 1)) return true;


        }
    }
    return false;
}
*/



/*


bool colorInSingleFace(Cube & current, char face, char color) {
    Cube temp = current;
    if (temp.getFace(face) == color) {
        current = temp;
        return true;
    }
    else {
        for (int var = 0; var < 4; ++var) {
            temp.yaw();
            if (temp.getFace(face) == color) {
                current = temp;
                return true;
            }
        }
        for (int var = 0; var < 3; ++var) {
            temp.roll();
            if (temp.getFace(face) == color) {
                current = temp;
                return true;
            }
        }

    }
    return false;
}


bool colorInSingleFace(Cube & current, char face, char color) {
    Cube temp = current;
    if (temp.getFace(face) == color) {
        current = temp;
        return true;
    }
    else {
        for (int var = 0; var < 4; ++var) {
            temp.yaw();
            if (temp.getFace(face) == color) {
                current = temp;
                return true;
            }
        }
        for (int var = 0; var < 3; ++var) {
            temp.roll();
            if (temp.getFace(face) == color) {
                current = temp;
                return true;
            }
        }

    }
    return false;
}

bool singlefaceAllColors(Vector<Cube> & cubeBox, char face) {
    int matchCount = 4;
    Vector<char> colors {'B', 'W', 'R', 'G'};
    Vector<Cube> tempCubeBox = cubeBox;
    for (int var = 0; var < tempCubeBox.size(); ++var) {
        Cube tempCube = cubeBox.get(var);
        if (colorInSingleFace(tempCube, face, colors.get(var))){
            tempCubeBox.set(var, tempCube);
            matchCount--;
            if (matchCount == 0) {
                cubeBox = tempCubeBox;
                return true;
            }
        }
    }
    return false;
}
*/


