/*
 * File: Maze.cpp
 * --------------
 * 01. In many mazes, there are multiple paths. For example, Figure 9-7 shows three solutions for
 * the same maze. None of these solutions, however, is optimal. The shortest path through the maze has a path length of 11:
 * Write a function
 *            int shortestPathLength(Maze & maze, Point start);
 * that returns the length of the shortest path in the maze from the specified position to any exit. If there is no solution,
 * shortestPathLength should return –1.
 * --------------
 * 02. As implemented in Figure 9-3, the solveMaze function unmarks each square as it discovers there are no solutions from
 * that point. Although this design strategy has the advantage that the final configuration of the maze shows the solution
 * path as a series of marked squares, the decision to unmark squares as you backtrack has a cost in terms of the overall
 * efficiency of the algorithm. If you’ve marked a square and then backtracked through it, you’ve already explored the
 * possibilities leading from that square. If you come back to it by some other path, you might as well rely on your earlier
 * analysis instead of exploring the same options again.
 *
 * To give yourself a sense of how much these unmarking operations cost in terms of efficiency, extend the solveMaze program
 * so that it records the number of recursive calls as it proceeds. Use this program to calculate how many recursive calls
 * are required to solve the following maze if the call to unmarkSquare remains part of the program:
 *
 * Run your program again, this time without the call to unmarkSquare. What happens to the number of recursive calls?
 * --------------
 * 03. As the result of the preceding exercise makes clear, the idea of keeping track of the path through a maze by using
 * the markSquare facility in the Maze class has a substantial cost. A more practical approach is to change the definition
 * of the recursive function so that it keeps track of the current path as it goes. Following the logic of solveMaze, write
 * a function
 *            bool findSolutionPath(Maze & maze, Point start, Vector<Point> & path);
 * that takes, in addition to the coordinates of the starting position, a vector of Pointvaluescalledpath.
 * Like solveMaze, findSolutionPath returns a Boolean value indicating whether the maze is solvable. In addition, the
 * findSolutionPath function initializes the elements of the path vector to a sequence of coordinates beginning with the
 * starting position and ending with the coordinates of the first square that lies outside the maze. For this exercise,
 * it is sufficient for findPath to find any solution path. It need not find the shortest one.
 */

//#include "console.h"
//#include "simpio.h"
#include "maze.h"
#include "gwindow.h"
#include "vector.h"
#include "set.h"
using namespace std;



/* #1 Strategy Solution prototypes*/
void solveMazeProblemsFirstStrategy(Maze & maze);
int shortestPathLenght(Maze & maze, GPoint start, Vector<Vector<GPoint>> & pathList);
int findAllSolutionPaths(Maze & maze, GPoint start, int & pathCount, Vector<Vector<GPoint>> & pathList, Vector<GPoint> & path, bool & bondBridge, GPoint & bondLoc);
int shortestOfSet(Set<int> shortestPathSet);
void findLostBond(GPoint lostBond, Vector<Vector<GPoint>> pathList, int firstIndex, int & lostListIndex, int & lostPathIndex);
bool allListsTraceStart(Vector<Vector<GPoint>> pathList, GPoint start);
void bondPaths(Vector<Vector<GPoint>> & pathList, GPoint start);
void orderPathList(Vector<Vector<GPoint>> & candidateList);
void printPathList(Vector<Vector<GPoint>> pathList);
void displayPathList(Maze & maze, Vector<Vector<GPoint>> & pathList);

/* #2 Strategy Solution prototypes*/
void solveMazeProblemsSecondStrategy(Maze & maze);
bool findQuestionableSolutionPath(Maze & maze, GPoint start, Vector<GPoint> & path, Vector<Vector<GPoint>> & pathList, int & cleared, bool & blockPathBool);
int shortestQuestionableSolutionPathLength(Maze & maze, GPoint start, Vector<Vector<GPoint>> & pathList);
int shortestPath(Vector<Vector<GPoint>> pathList);
char blockType(string str);
void removeExitPoint(Vector<Vector<GPoint>> & pathList);

/* Template prototypes */
bool solveMaze (Maze & maze, GPoint start);
GPoint adjacentPoint (GPoint start, Direction dir);




int main() {
    GWindow gw;
    Maze maze("Maze01.txt", gw);
    //solveMazeProblemsFirstStrategy(maze);
    solveMazeProblemsSecondStrategy(maze);
    return 0;
}


/*
* Function: shortestPathLenght aka Strategy #1
* -------------------------------------------------------
* Explores all the possible paths and records as branches the paths that get to the exit in a list of paths,
* a bonding point is included, which is then used to find it's immediate parent untill all sucessful branches get
* from exit to the start.
*
* This strategy finds 6 paths with the highest acuracy in <100seconds
* Second (the old questionbale)
*/

void solveMazeProblemsFirstStrategy(Maze & maze) {
    Vector<Vector<GPoint>> pathList;
    cout << "Shortest exit path is of " << shortestPathLenght(maze, maze.getStartPosition(), pathList) << " lenght" << endl;
    printPathList(pathList);
    displayPathList(maze, pathList);
}

int shortestPathLenght(Maze & maze, GPoint start, Vector<Vector<GPoint>> & pathList) {
    int pathCount = 0;
    Vector<GPoint> path;
    bool bondBridge = false;
    GPoint bondLoc;
    if (findAllSolutionPaths(maze, start, pathCount, pathList, path, bondBridge, bondLoc) > 0) {
        pathList.add(path);
        bondPaths(pathList, maze.getStartPosition());
        orderPathList(pathList);
        return pathList.get(0).size();
    }
    else return -1;

}

int findAllSolutionPaths(Maze & maze, GPoint start, int & pathCount, Vector<Vector<GPoint>> & pathList, Vector<GPoint> & path, bool & bondBridge, GPoint & bondLoc) {
    int shortestPath = 0;
    Set<int> shortestPathSet;
    if (maze.isOutside(start)) {
        path.add(bondLoc);
        pathList.add(path);
        path.clear();
        pathCount = -1;
        return 2;
    }
    if (maze.isMarked(start)) return - 1;

    maze.markSquare(start, "PURPLE");
    for (Direction dir = NORTH; dir <= WEST; dir++) {
        if (!maze.wallExists(start, dir)) {
            if (bondBridge) {
                bondLoc = start;
                bondBridge = false;
            }
            shortestPathSet.add(findAllSolutionPaths(maze, adjacentPoint(start, dir), pathCount, pathList, path, bondBridge, bondLoc));
        }
    }

    maze.unmarkSquare(start);

    shortestPath = shortestOfSet(shortestPathSet);
    if (shortestPath > -1 ) {
        pathCount += shortestPath;
        path.add(start);
        bondBridge = true;
        return 1;
    }
    else return - 1;
}

int shortestOfSet(Set<int> shortestPathSet) {
    if (shortestPathSet.size() > 1 && shortestPathSet.first() == -1) shortestPathSet.remove(-1);
    if (shortestPathSet.size() > 0 ) return shortestPathSet.first();
    else return -1;
}


void bondPaths(Vector<Vector<GPoint>> & pathList, GPoint start){
    int lostListIndex = -1;
    int lostPathIndex = -1;
    if (pathList.get(0).isEmpty() || pathList.get(0).get(0) == start) pathList.remove(0);
    while (!allListsTraceStart(pathList, start)) {
        for (int var = 0; var < pathList.size(); ++var) {
              GPoint lostBond = pathList.get(var).get(pathList.get(var).size() - 1);
              if (lostBond != start) {
                  findLostBond(lostBond, pathList, var, lostListIndex, lostPathIndex);
                  if (lostListIndex != -1 && lostPathIndex != -1) {
                      Vector<GPoint> tail = pathList.get(lostListIndex);
                      for (int i = 0; i <= lostPathIndex; ++i) {
                          tail.remove(0);
                      }
                      pathList.set(var, pathList.get(var) + tail);
                      lostListIndex = lostPathIndex = -1;
                  }
                  else cerr << "Index for bonding can't be found" << endl;
              }
        }
    }
}

void findLostBond(GPoint lostBond, Vector<Vector<GPoint>> pathList, int firstIndex, int & lostListIndex, int & lostPathIndex){
    for (int var = firstIndex + 1; var < pathList.size(); ++var) {
        for (int i = 0; i < pathList.get(var).size(); ++i) {
            if (pathList.get(var).get(i) == lostBond){
                lostListIndex = var;
                lostPathIndex = i;
                break;
            }
        }
        if (lostListIndex != -1) break;
    }
}

bool allListsTraceStart(Vector<Vector<GPoint>> pathList, GPoint start) {
    int targetPositives = pathList.size();
    for (int var = 0; var < pathList.size(); ++var) {
        if (pathList.get(var).get(pathList.get(var).size()-1) == start){
            targetPositives--;
        }
    }
    if (targetPositives == 0) return true;
    else return false;
}


void orderPathList(Vector<Vector<GPoint>> & candidateList){
    Vector<Vector<GPoint>> newList;
    if (candidateList.size() > 0) {
        int minSize = 0;
        for (int var = 0; var < candidateList.size(); ++var) {
            if (candidateList.get(var).size() > 0) {
                if (newList.isEmpty()){
                    newList.add(candidateList.get(var));
                    minSize = candidateList.get(var).size();
                } else if (candidateList.get(var).size() <= minSize) {
                    newList.insert(0, candidateList.get(var));
                    minSize = candidateList.get(var).size();
                } else if (candidateList.get(var).size() > minSize) {
                    int index = newList.size()-1;
                    while (candidateList.get(var).size() < newList.get(index).size() ) {
                        index--;
                    }
                    newList.insert(index+1, candidateList.get(var));
                }
            }
        }
    }
    candidateList = newList;
}


void printPathList(Vector<Vector<GPoint>> pathList){
    Set<Vector<GPoint>> pathSet;
    int count = 0;
    cout << "\n" << endl;
    for (Vector<GPoint> s : pathList) {
        pathSet.add(s);
    }
    for (Vector<GPoint> s : pathSet) {
        cout << "Path #" << ++count << " with " << s.size() << " lenght found in points: " << s << endl;
    }
}

void displayPathList(Maze & maze, Vector<Vector<GPoint>> & pathList){
        for (Vector<GPoint> path : pathList) {
            for (int var = path.size() - 1; var >= 0; --var) {
                maze.markSquare(path.get(var), "GREEN");
            }
            for (int var = 0; var < path.size(); var++) {
                maze.unmarkSquare(path.get(var));
            }
        }
}


/*
* Function: shortestQuestionableSolutionPathLength aka Strategy #2
* -------------------------------------------------------
* Finds the shortest path by closing paths that lead to dead ends and marking them in red
* and paths that have already been explored and sucesful in blue. Once no more paths can be explored as
* most ways have been marked, sucesful path blocks start getting unlocked starting in the exit maze and
* towards the start always checking for the currently closesth path.
* Flows:
* - It takes a number of unkwown attempts to reach a path that is predimetaded knwon as the closest path,
* thus, a number of aproximated attempts is needed to be hardcoded or calculated arbitraily without any
* assurance of the number of attemps to be accurated
* - Not all paths are actually explored
*/

void solveMazeProblemsSecondStrategy(Maze & maze) {
    Vector<Vector<GPoint>> pathList;
    cout << "Shortest exit path is of " << shortestQuestionableSolutionPathLength(maze, maze.getStartPosition(), pathList) << " lenght" << endl;
    removeExitPoint(pathList);
    printPathList(pathList);
}


int shortestQuestionableSolutionPathLength(Maze & maze, GPoint start, Vector<Vector<GPoint>> & pathList) {
    int result = -1;
    int cleared = 1;
    bool blockPathBool;
    Vector<GPoint> path;
    for (int var = 0; var < 20; ++var) {
        if (findQuestionableSolutionPath(maze, start, path, pathList, cleared, blockPathBool)) {
            pathList.add(path);
            path.clear();
        }
        else cleared++;
    }
    if (!pathList.isEmpty()) result = pathList.get(shortestPath(pathList)).size() - 1;
    return result;
}


bool findQuestionableSolutionPath(Maze & maze, GPoint start, Vector<GPoint> & path, Vector<Vector<GPoint>> & pathList, int & cleared, bool & blockPathBool){
    path.add(start);
    if (maze.isOutside(start)) return true;
    if (maze.isMarked(start)) {
        path.remove(path.size() - 1);
        return false;
    }
    if (maze.isBlocked(start)) {
           path.remove(path.size() - 1);
           return false;
    }
    maze.markSquare(start, "PURPLE");
    for (Direction dir = NORTH; dir <= WEST; dir++) {
        if (!maze.wallExists(start, dir)) {
            GPoint exception(3,5);
            if (!(maze.isAllowedPath(adjacentPoint(start, dir))) && maze.isPath(adjacentPoint(start, dir))) {
                if (!maze.wallExists(start, dir)) {
                    dir++;
                    for (Direction subDir = dir; subDir <= WEST; subDir++) {
                        if (!maze.wallExists(start, subDir)) {
                            blockPathBool = true;
                            if (findQuestionableSolutionPath(maze, adjacentPoint(start, subDir), path, pathList, cleared, blockPathBool)) {
                                maze.unmarkSquare(start);
                                if (start != maze.getStartPosition()) {
                                    maze.setSquare(start, blockType("PATH"));
                                }
                                return true;
                            }
                        }
                    }
                    path.remove(path.size() - 1);
                    maze.unmarkSquare(start);
                    blockPathBool = false;
                    Vector<GPoint> shortestExitPath = pathList.get(shortestPath(pathList));
                    maze.setPathEntry(shortestExitPath.get(shortestExitPath.size()-cleared));
                    return false;
                }
            }
            if (findQuestionableSolutionPath(maze, adjacentPoint(start, dir), path, pathList, cleared, blockPathBool)) {
                maze.unmarkSquare(start);
                if (start != maze.getStartPosition()) {
                    maze.setSquare(start, blockType("PATH"));
                }
                return true;
            }
        }
    }
    path.remove(path.size() - 1);
    maze.unmarkSquare(start);
    if (start != maze.getStartPosition() && blockPathBool && !maze.isPath(start)) {
        maze.setSquare(start, blockType("BLOCK"));
    }
    return false;
}

void removeExitPoint(Vector<Vector<GPoint>> & pathList){
    for (int var = 0; var < pathList.size(); ++var) {
       Vector<GPoint> path = pathList.get(var);
       path.remove(path.size()-1);
       pathList.set(var, path);
    }
}


/*
* Function: shortestPath
* Usage: shortestPath (pathList);
* -------------------------------------------------------
* Returns the position of the shortest list found in a list of paths
*/
int shortestPath(Vector<Vector<GPoint>> pathList){
    if (pathList.isEmpty()) return -1;
    int nSize = pathList.get(0).size();
    int result = 0;
    if (pathList.size() > 1) {
        for (int var = 0; var < pathList.size(); ++var) {
            if (pathList.get(var).size() < nSize) {
                nSize = pathList.get(var).size();
                result = var;
            }
        }
    }
    return result;
}




/*
* Function: adjacentPoint
* Usage: Point finish = adjacentPoint (start, dir);
* -------------------------------------------------------
* Returns the point that results from moving one square from start
* in the direction specified by dir. For example, if pt is the
* point (1, 1), calling adjacentPoint (pt, EAST) returns the
* point (2, 1). To maintain consistency with the graphics package,
* the y coordinates increase as you move downward on the screen. Thus,
* moving NORTH decreases the y component, and moving SOUTH increases it.
*/
GPoint adjacentPoint (GPoint start, Direction dir) {
    switch (dir) {
        case NORTH: return GPoint (start.x, start.y - 1);
        case EAST: return GPoint (start.x + 1, start.y);
        case SOUTH: return GPoint (start.x, start.y + 1);
        case WEST: return GPoint (start.x - 1, start.y);
    }
    return start;
}



char blockType(string str){
    if (str == "BLOCK") return 'B';
    else if (str == "FLAG") return 'F';
    else if (str == "PATH") return 'P';

    return '\0';
}


/*
* Function: solveMaze
* Usage: solveMaze (maze, start);
* -------------------------------------------------------
* Attempts to generate a solution to the current maze from the specified
* start point. The solveMaze function returns true if the maze has a
* solution and false otherwise. The implementation uses recursion
* to solve the submazes that result from marking the current square
* and moving one step along each open passage.
*/
bool solveMaze (Maze & maze, GPoint start) {
    if (maze.isOutside(start)) return true;
    if (maze.isMarked(start)) return false;
    maze.markSquare(start, "GREEN");
    for (Direction dir = NORTH; dir <= WEST; dir++) {
        if (!maze.wallExists(start, dir)) {
            if (solveMaze(maze, adjacentPoint(start, dir))) {
                maze.unmarkSquare(start);
                cout << "*" << endl;
                return true;
            }
        }
    }
    maze.unmarkSquare(start);

    return false;
}



