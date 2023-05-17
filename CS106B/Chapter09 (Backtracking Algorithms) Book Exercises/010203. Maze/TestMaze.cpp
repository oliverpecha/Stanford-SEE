/*
 * File: Maze.cpp
 * --------------
 * 01. In many mazes, there are multiple paths. For example, Figure 9-7 shows three solutions for
 * the same maze. None of these solutions, however, is optimal. The shortest path through the maze has a path length of 11:
 * Write a function
 *            int shortestPathLength(Maze & maze, Point start);
 * that returns the length of the shortest path in the maze from the specified position to any exit. If there is no solution,
 * shortestPathLength should return –1.
 */

#include "console.h"
#include "simpio.h"
#include "maze.h"
#include "gwindow.h"
using namespace std;


int main() {
    GWindow gw;
    Maze mz("Maze01.txt", gw);
    return 0;
}
