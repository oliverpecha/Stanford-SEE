/*
 * File: maze.h
 * ------------
 * This interface exports the Maze class.
 */

#ifndef _maze_h
#define _maze_h

#include <string>
#include "grid.h"
#include "gwindow.h"
#include "direction.h"
#include "set.h"

//#include "GPoint.h"

/*
 * Class: Maze
 * -----------
 * This class represents a two-dimensional maze contained in a rectangular
 * grid of squares.  The maze is read in from a data file in which the
 * characters '+', '-', and '|' represent corners, horizontal walls, and
 * vertical walls, respectively; spaces represent open passageway squares.
 * The starting position is indicated by the character 'S'.  For example,
 * the following data file defines a simple maze:
 *
 *       +-+-+-+-+-+
 *       |     |
 *       + +-+ + +-+
 *       |S  |     |
 *       +-+-+-+-+-+
 */

class Maze {

public:


/*
 * Constructor: Maze
 * Usage: Maze maze(filename);
 *        Maze maze(filename, gw);
 * -------------------------------
 * Constructs a new maze by reading the specified data file.  If the
 * second argument is supplied, the maze is displayed in the center
 * of the graphics window.
 */

   Maze(std::string filename);
   Maze(std::string filename, GWindow & gw);

/*
 * Method: getStartPosition
 * Usage: GPoint start = maze.getStartPosition();
 * ---------------------------------------------
 * Returns a GPoint indicating the coordinates of the start square.
 */

   GPoint getStartPosition();

/*
 * Method: isOutside
 * Usage: if (maze.isOutside(pt)) . . .
 * ------------------------------------
 * Returns true if the specified GPoint is outside the boundary of the maze.
 */

   bool isOutside(GPoint pt);

/*
 * Method: wallExists
 * Usage: if (maze.wallExists(pt, dir)) . . .
 * ------------------------------------------
 * Returns true if there is a wall in direction dir from the square at pt.
 */

   bool wallExists(GPoint pt, Direction dir);

/*
* Method: wallExists
* Usage: if (maze.wallExists(pt, dir)) . . .
* ------------------------------------------
* Returns true if there is a wall in direction dir from the square at pt.
*/

  bool pathExisted(GPoint pt, Direction dir);

/*
 * Method: markSquare
 * Usage: maze.markSquare(pt);
 * ---------------------------
 * Marks the specified square in the maze.
 */

   void markSquare(GPoint pt);

/*
 * Method: unmarkSquare
 * Usage: maze.unmarkSquare(pt);
 * -----------------------------
 * Unmarks the specified square in the maze.
 */

   void unmarkSquare(GPoint pt);

/*
* Method: blockedSquare
* Usage: maze.blockSquare(pt);
* -----------------------------
* Sets the specified square in the maze as blocked.
*/

  void setSquare(GPoint pt, char type);

/*
* Method: isMarked
* Usage: if (maze.isMarked(pt)) . . .
* -----------------------------------
* Returns true if the specified square is marked.
*/

bool isMarked(GPoint pt);

/*
 * Method: isBlocked
 * Usage: if (maze.isBlocked(pt)) . . .
 * -----------------------------------
 * Returns true if the specified square is marked.
 */

   bool isBlocked(GPoint pt);

/*
* Method: isFlagged
* Usage: if (maze.isFlagged(pt)) . . .
* -----------------------------------
* Returns true if the specified square is flagged.
*/

  bool isFlagged(GPoint pt);

/*
* Method: isPath
* Usage: if (maze.isFlagged(pt)) . . .
* -----------------------------------
* Returns true if the specified square is flagged.
*/

    bool isPath(GPoint pt);

/*
* Method: isAllowedPath
* Usage: if (maze.isFlagged(pt)) . . .
* -----------------------------------
* Returns true if the specified square is flagged.
*/

bool isAllowedPath(GPoint pt);


/*
* Method: lastFlagged
* Usage:
* -----------------------------------
*
*/

   GPoint getLastFlagged();



void setPathEntry(GPoint pt);

void removePathEntry(GPoint pt);



/* Private section */

private:

/* Structure representing a single square */

   struct Square {
      bool flagged;
      bool blocked;
      bool path;
      bool marked;
      bool walls[4];
   };

/* Instance variables */

   Grid<Square> maze;
   GPoint startSquare;
   GPoint lastFlagged;
   GWindow *gp;
   double x0;
   double y0;
   int rows;
   int cols;
   Set<GPoint> pathEntries;

/* Private functions */

   void readMazeFile(std::string filename);
   void computeMazeSize(std::ifstream & infile);
   void processMazeFile(std::ifstream & infile);
   void processDividerLine(std::string line, int y);
   void processPassageLine(std::string line, int y);
   void setHorizontalWall(GPoint pt);
   void setVerticalWall(GPoint pt);
   void setStartSquare(GPoint pt);
   void drawMaze();
   void drawMazeGrid();
   void drawWalls();
   void drawMarks();
   void drawMark(GPoint pt);
   void eraseMark(GPoint pt);
   void blockMark(GPoint pt, std::string color);
   GPoint adjacentGPoint(GPoint start, Direction dir);

};

#endif
