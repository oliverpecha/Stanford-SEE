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
using namespace std;

int shortestPathLength(Maze & maze, GPoint start);
bool solveMaze (Maze & maze, GPoint start);
bool findSolutionPath(Maze & maze, GPoint start, Vector<GPoint> & path);
GPoint adjacentPoint (GPoint start, Direction dir);
GPoint previousPoint (GPoint start, Direction dir);


int main() {
    GWindow gw;
    Maze mz("Maze01.txt", gw);
    Vector<GPoint> path;

    /*
    if (solveMaze(mz, mz.getStartPosition())) {
        cout << "_____SOLVED. "  << endl;
    }
    */
    if (findSolutionPath(mz, mz.getStartPosition(), path)) {
        cout << "_____SOLVED. through path: "  << path << endl;
    }
    //cout << "It's shortest path is " << shortestPathLength(mz, mz.getStartPosition()) << " end" << endl;

    return 0;
}


int shortestPathLength(Maze & maze, GPoint start) {
    int result = -1;
    for (int var = 0; var < 6; ++var) {
        for (Direction dir = NORTH; dir <= WEST; dir++) {
            int steps = 0;
            cout << "Starting in dir " << dir << endl;
            if (!maze.wallExists (start, dir)) {
                if (solveMaze(maze, start)) {
                    cout << "_____SOLVED. In: " << start << " in dir " << dir << "... steps found: " << steps << endl;
                }
            }
            else cout << "Starting at: " << start << " in dir " << dir << " results in Wall!" << endl;
        }
    }
    return result;
}


bool findSolutionPath(Maze & maze, GPoint start, Vector<GPoint> & path){
    path.add(start);
    if (maze.isOutside(start)) return true;
    if (maze.isMarked(start)) {
        path.remove(path.size() - 1);
        return false;
    }
    maze.markSquare(start);
    for (Direction dir = NORTH; dir <= WEST; dir++) {
        if (!maze.wallExists(start, dir)) {
            if (findSolutionPath(maze, adjacentPoint(start, dir) , path)) {
                cout << "*" << endl;
                maze.unmarkSquare(start);
                return true;
            }
        }
    }
    path.remove(path.size() - 1);
    maze.unmarkSquare(start);

    return false;
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
    maze.markSquare(start);
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


GPoint previousPoint (GPoint start, Direction dir) {
    switch (dir) {
        case NORTH: return GPoint (start.x, start.y + 1);
        case EAST: return GPoint (start.x - 1, start.y);
        case SOUTH: return GPoint (start.x, start.y - 1);
        case WEST: return GPoint (start.x + 1, start.y);
    }
    return start;
}
