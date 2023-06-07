/*
 * File: main.cpp
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


void cubeBox2string(Vector<Cube> cubeBox);
void faceAllSameColor(Vector<Cube> & cubeBox, char face, char color);
bool colorInSingleFace(Vector<Cube> & cubeBox, char face, char color);
bool singlefaceAllColors(Vector<Cube> & cubeBox, char face);
bool isSinglefaceAllColors(Vector<Cube> & cubeBox, char face);
bool isAllfacesAllColors(Vector<Cube> & cubeBox);

Vector<char> input2instruction(string input);
void combinator(Vector<Cube> & cubeBox,  Vector<Vector<Cube>> & combinations, Vector<Cube> & inheritance, int index);

Vector <Vector<Vector<char>>> listOppositeFacesOfBox (Vector<Cube> cubeBox);
Vector<Vector<char>> listOppositeFacesOfCube(Cube current);
void printOppositeFacesOfCube(Vector <Vector<Vector<char>>> allopositefaces);
void printCombinations(Vector<Vector<Cube>>combinations);



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
bool set2ColorsTo2faces(char c1, char c2, char prominentFace);

bool set2ColorsTo2faces(char c1, char c2, char prominentFace){
    //find c1
    //test c2
    //store c1 face

    //use rotator


    return false;
}

bool magic(Vector<Cube> cubeBox) {

    return false;

}
*/

int main() {
    Cube one('B', 'W', 'B', 'R', 'G', 'G');
    Cube two('G', 'W', 'W', 'B', 'R', 'G');
    Cube three('W', 'R', 'R', 'B', 'W', 'G');
    Cube four('R', 'G', 'R', 'R', 'B', 'W');

    /* Original
    Cube one('B', 'W', 'B', 'R', 'G', 'G');
    Cube two('G', 'W', 'W', 'B', 'R', 'G');
    Cube three('W', 'R', 'R', 'B', 'W', 'G');
    Cube four('R', 'G', 'R', 'R', 'B', 'W');
     * Solved
    Cube one('W', 'B', 'R', 'G', 'G', 'G');
    Cube two('G', 'W', 'B', 'R', 'R', 'G');
    Cube three('B', 'R', 'W', 'B', 'W', 'G');
    Cube four('R', 'G', 'G', 'W', 'B', 'W');
     * Experiment
    Cube one('B', 'W', 'B', 'R', 'W', 'B');
    Cube two('G', 'W', 'W', 'B', 'G', 'W');
    Cube three('W', 'R', 'R', 'B', 'B', 'R');
    Cube four('R', 'G', 'R', 'R', 'R', 'G');
     * YT vertex
    Cube one('G', 'R', 'W', 'B', 'R', 'R');
    Cube two('B', 'R', 'W', 'G', 'R', 'W');
    Cube three('R', 'B', 'B', 'W', 'G', 'G');
    Cube four('R', 'G', 'W', 'G', 'B', 'W');
     * YT gamer
    Cube one('G', 'R', 'W', 'B', 'R', 'R');
    Cube two('B', 'R', 'W', 'G', 'R', 'W');
    Cube three('R', 'B', 'B', 'W', 'G', 'G');
    Cube four('R', 'G', 'W', 'G', 'B', 'W');
    */

    Vector<Cube> cubeBox {one, two, three, four};
    cout << "Cube starts as" << endl;
    cubeBox2string(cubeBox);

    string input = " ";
    while (input != "") {
        input = getLine("How to rotate? Enter: 1st Index, 2nd OriginFace, 3rd TargetFace ");
        if (input.size() == 3) {
             Cube temp = cubeBox[input[0] - 48];
             temp.rotator(temp, input[1], input[2]);
             cubeBox.set(input[0] - 48, temp);
             cubeBox2string(cubeBox);

        } else cerr << "needs to be a 3 character instruction" << endl;
    }





    Vector<Cube> tail;
    Vector<Cube> inheritance;
    Vector<Vector<Cube>> combinations;

//Vector <Vector<Vector<char>>> upora = listOppositeFacesOfBox(cubeBox);
//printOppositeFacesOfCube(upora);



/*
    if (solvePuzzle(cubeBox, tail, 3)) {
        cout << "Solved Cube:" << endl;
        cubeBox2string(cubeBox);

    } else cout << "Can't solve" << endl;
*/
    //combinator(cubeBox, combinations, inheritance, 3);
    //printCombinations(combinations);


    return 0;
}




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

void printOppositeFacesOfCube(Vector <Vector<Vector<char>>> alloppositefaces){
    for (int var = 0; var < alloppositefaces.size(); ++var) {
        Vector<Vector<char>> oppositefaces = alloppositefaces.get(var);
        for (int i = 0; i < oppositefaces.size(); ++i) {
            if (i == 0) {
                cout << "Cube in position " << var + 1 << ". Front/Back: ";
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

Vector <Vector<Vector<char>>> listOppositeFacesOfBox (Vector<Cube> cubeBox) {
    Vector <Vector<Vector<char>>> result;
    for (int var = 0; var < cubeBox.size(); ++var) {
        result.add(listOppositeFacesOfCube(cubeBox.get(var)));
    }
    return result;
}

void cubeBox2string(Vector<Cube> cubeBox) {
    cout << "| FRONT |  BACK | LEFT  | RIGHT |" << endl;
    for (int var = 0; var < cubeBox.size(); ++var) {
        cubeBox[var].toString();
    }
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

bool isAllfacesAllColors(Vector<Cube> & cubeBox){
    int matchCount = 4;
    Vector<char> faces {'F', 'B', 'L', 'R'};
    for (int var = 0; var < 4; ++var) {
        if (isSinglefaceAllColors(cubeBox, faces[var])) {
            matchCount--;
            //cout << "matchCount: " << matchCount << "face: " << faces[var] << endl;
            //cubeBox[var].toString();

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
            //cout << "cube #" << var << " face: " << face << " . " << tempCube.getFace(face) << endl;
            colors.remove(tempCube.getFace(face));
        }
    }
    if (colors.isEmpty()) return true;
    else return false;
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

void faceAllSameColor(Vector<Cube> & cubeBox, char face, char color) {
    for (int var = 0; var < cubeBox.size(); ++var) {
        Cube temp = cubeBox.get(var);
        while (temp.getFace(face) != color) {
            cout << "x" << temp.getFace(face) <<  endl;
            temp.yaw();
        }
        cubeBox.set(var, temp);
    }
}


void printCombinations(Vector<Vector<Cube>>combinations){
    int counter = 0;
    //Set<Vector<Cube>> setOfComb;

    for (Vector<Cube> s : combinations) {
        counter++;
        if (isAllfacesAllColors(s)) {
            cout << "wohoaCube" << endl;
            cubeBox2string(s);
            /*
            for (int var = 0; var < 4; ++var) {
                s[var].yaw();
                s[var].yaw();
            }
            cout << "wohoaCube2" << endl;
            cubeBox2string(s);
            */
        }
    }

    cout << "counter: " << counter << endl;
    /*
    counter = 0;
    for (Vector<Cube> s : setOfComb) {
            counter++;
    }
    cout << "counter: " << counter << endl;
*/
}

