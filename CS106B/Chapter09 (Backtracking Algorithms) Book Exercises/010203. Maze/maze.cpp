/*
 * File: maze.cpp
 * --------------
 * This file implements the Maze class.
 */

#include <fstream>
#include <iostream>
#include <string>
#include "console.h"
#include "direction.h"
#include "error.h"
#include "grid.h"
#include "gwindow.h"
#include "maze.h"

using namespace std;

/* Constants */

static const double SQUARE_SIZE = 25;
static const double MARK_SIZE = 7;

/* Public entries */

Maze::Maze(string filename) {
   gp = NULL;
   readMazeFile(filename);
}

Maze::Maze(string filename, GWindow & gw) {
   gp = &gw;
   readMazeFile(filename);
   x0 = (gw.getWidth() - cols * SQUARE_SIZE) / 2;
   y0 = (gw.getHeight() - rows * SQUARE_SIZE) / 2;
   drawMaze();
}

GPoint Maze::getStartPosition() {
   return startSquare;
}

bool Maze::isOutside(GPoint pt) {
   return !maze.inBounds(pt.x, pt.y);
}

bool Maze::wallExists(GPoint pt, Direction dir) {
   if (pt.x == -1 && dir == EAST) {
      return wallExists(adjacentGPoint(pt, EAST), WEST);
   }
   if (pt.y == -1 && dir == SOUTH) {
      return wallExists(adjacentGPoint(pt, SOUTH), NORTH);
   }
   if (pt.x == cols && dir == WEST) {
      return wallExists(adjacentGPoint(pt, WEST), EAST);
   }
   if (pt.y == rows && dir == NORTH) {
      return wallExists(adjacentGPoint(pt, NORTH), SOUTH);
   }
   if (isOutside(pt)) error("Coordinates are out of range");
   return (maze[pt.y][pt.x].walls[dir]);
}

bool Maze::pathExisted(GPoint pt, Direction dir) {
    if (isPath(pt)) return true;
    else return false;
    }

void Maze::markSquare(GPoint pt, string color) {
   if (isOutside(pt)) error("Coordinates are out of range");
   maze[pt.y][pt.x].marked = true;
   //maze[pt.y][pt.x].path = true;
   if (gp != NULL) drawMark(pt, color);
}

void Maze::unmarkSquare(GPoint pt) {
   if (isOutside(pt)) error("Coordinates are out of range");
   maze[pt.y][pt.x].marked = false;
   if (gp != NULL) eraseMark(pt);
   if (isFlagged(pt) && pt != startSquare) {
        lastFlagged = pt;
   }

}

void Maze::setSquare(GPoint pt, char type) {
   if (isOutside(pt)) error("Coordinates are out of range");

   string color;
   switch (type) {
       case 'B':
           maze[pt.y][pt.x].blocked = true;
           color = "RED";
           break;
       case 'F':
            color = "YELLOW";
            maze[pt.y][pt.x].flagged = true;
           break;
       case 'P':
            color = "BLUE";
            maze[pt.y][pt.x].path = true;
           break;
   }
   if (gp != NULL) blockMark(pt, color);
}

bool Maze::isMarked(GPoint pt) {
   if (isOutside(pt)) error("Coordinates are out of range");
   return maze[pt.y][pt.x].marked;
}

bool Maze::isBlocked(GPoint pt) {
   if (isOutside(pt)) error("Coordinates are out of range");
   return maze[pt.y][pt.x].blocked;
}

bool Maze::isFlagged(GPoint pt) {
   if (isOutside(pt)) error("Coordinates are out of range");
   return maze[pt.y][pt.x].flagged;
}

bool Maze::isPath(GPoint pt) {
   //if (isOutside(pt)) error("Coordinates are out of range");
   if (isOutside(pt)) return false;
   return maze[pt.y][pt.x].path;
}

bool Maze::isAllowedPath(GPoint pt) {
   if (isOutside(pt)) return false;
   if (pathEntries.contains(pt)) return true;
   return false;
}


void Maze::setPathEntry(GPoint pt) {
    pathEntries.add(pt);
}

void Maze::removePathEntry(GPoint pt) {
    pathEntries.remove(pt);
}

GPoint Maze::getLastFlagged() {
   return lastFlagged;
}

/* Private methods */

/*
 * Reads the data file and computes the dimensions
 * of the maze.  The file must then be read a second time to read
 * the actual data.  The values indicating the size of the maze
 * are stored in the private variables cols and rows.
 */

void Maze::readMazeFile(std::string filename) {
   ifstream infile;
   infile.open(filename.c_str());
   if (infile.fail()) error("Can't open " + filename);
   computeMazeSize(infile);
   infile.close();
   maze = Grid<Square>(rows, cols);
   for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
         for (int i = 0; i < 4; i++) {
            maze[row][col].walls[i] = false;
         }
         maze[row][col].blocked = false;
      }
   }
   startSquare = GPoint(-1, -1);
   infile.clear();
   infile.open(filename.c_str());
   if (infile.fail()) error("Can't reopen maze file");
   processMazeFile(infile);
   infile.close();
   if (startSquare.x == -1) error("Maze contains no start square");
}

void Maze::computeMazeSize(ifstream & infile) {
   int nLines = 0;
   bool trailing = false;
   string line;
   while (getline(infile, line)) {
      int len = line.length();
      if (len == 0) {
         trailing = true;
      } else if (trailing) {
         error("Illegal blank lines in data file");
      } else if (nLines == 0) {
         if (len % 2 != 1) error("Illegal maze width");
         cols = (len - 1) / 2;
         nLines++;
      } else {
         nLines++;
      }
   }
   if (nLines % 2 != 1) error("Illegal maze height");
   rows = (nLines - 1) / 2;
}

/*
 * Method: processMazeFile
 * Usage: processMazeFile(infile);
 * -------------------------------
 * This method reads the actual maze data from the file.  The
 * methods ComputeMazeSize and InitMazeArray must be called
 * prior to calling ProcessMazeFile.  It is also the caller's
 * responsibility to make sure that infile has been set back
 * to the beginning of the file.
 */

void Maze::processMazeFile(ifstream & infile) {
   string line;
   for (int y = 0; y < rows; y++) {
      getline(infile, line);
      processDividerLine(line, y);
      getline(infile, line);
      processPassageLine(line, y);
   }
   getline(infile, line);
   processDividerLine(line, rows);
}

/*
 * Method: processDividerLine
 * Usage: processDividerLine(line, y);
 * -----------------------------------
 * This method reads the odd-numbered lines in the data file,
 * which specify the positions of the horizontal walls.  The
 * line have the form
 *
 *     +-+-+-+-+-+-+-+-+
 *
 * where the - symbols may be replaced by spaces to indicate a
 * corridor square.  The y value gives the index of the squares
 * immediately to the north of this line.
 */

void Maze::processDividerLine(string line, int y) {
   if (line.length() != 2 * cols + 1) {
      error("Divider line has incorrect width");
   }
   for (int x = 0; x < cols; x++) {
      if (line[2 * x] != '+') error("Missing corner symbol");
      switch (line[2 * x + 1]) {
       case ' ': break;
       case '-': setHorizontalWall(GPoint(x, y)); break;
       default:  error("Illegal character in maze file");
      }
   }
   if (line[2 * cols] != '+') error("Missing corner symbol");
}

/*
 * Method: processPassageLine
 * Usage: processPassageLine(line, y);
 * -----------------------------------
 * This method reads the even-numbered lines in the data file,
 * which specify the passageways and locations of the vertical
 * walls.  These lines have the form
 *
 *     | | | | | | | | |
 *
 * where the | symbols may be replaced by spaces to indicate a
 * corridor square.  One of the open passageway squares in the
 * file may also be blocked with an 'S' to indicate the start
 * square.  The y argument gives the index of the squares on
 * this line.
 */

void Maze::processPassageLine(string line, int y) {
   int len = line.length();
   for (int x = 0; x < (len - 1) / 2; x++) {
      if (line[2 * x] == '|') {
         setVerticalWall(GPoint(x, y));
      }
      switch (line[2 * x + 1]) {
       case ' ': case '\0': break;
       case 'S': setStartSquare(GPoint(x, y)); break;
       default:  error("Illegal character in maze file");
      }
   }
   if (len % 2 == 1 && line[len - 1] == '|') {
      setVerticalWall(GPoint((len - 1) / 2, y));
   }
}

/*
 * Method: setHorizontalWall
 * Usage: setHorizontalWall(pt);
 * -----------------------------
 * This method sets a horizontal wall to the north of the square
 * at pt.  To maintain consistency in the data structure, it is
 * usually also necessary to create a wall to the south of the
 * square just north of this one.
 */

void Maze::setHorizontalWall(GPoint pt) {
   if (maze.inBounds(pt.x, pt.y)) {
      maze[pt.y][pt.x].walls[NORTH] = true;
   }
   if (maze.inBounds(pt.x, pt.y - 1)) {
      maze[pt.y - 1][pt.x].walls[SOUTH] = true;
   }
}

/*
 * Method: setVerticalWall
 * Usage: setVerticalWall(pt);
 * ---------------------------
 * This method sets a vertical wall to the west of the square
 * at pt.  To maintain consistency in the data structure, it is
 * usually also necessary to create a wall to the east of the
 * square just west of this one.
 */

void Maze::setVerticalWall(GPoint pt) {
   if (maze.inBounds(pt.x, pt.y)) {
      maze[pt.y][pt.x].walls[WEST] = true;
   }
   if (maze.inBounds(pt.x - 1, pt.y)) {
      maze[pt.y][pt.x - 1].walls[EAST] = true;
   }
}

/*
 * Method: setStartSquare
 * Usage: setStartSquare(pt);
 * --------------------------
 * This method sets the start square to the indicated GPoint and
 * draws a circle on the screen.
 */

void Maze::setStartSquare(GPoint pt) {
   if (startSquare.x != -1) {
      error("Multiple start squares specified");
   }
   startSquare = pt;
}

/*
 * Method: drawMaze
 * Usage: drawMaze();
 * ------------------
 * Draws the maze on the graphics window with its upper left corner
 * at the GPoint (x0, y0).
 */

void Maze::drawMaze() {
   drawMazeGrid();
   drawWalls();
   drawMarks();
}

/*
 * Method: drawMazeGrid
 * Usage: drawMazeGrid();
 * ----------------------
 * This method clears the background to white and then draws a uniform
 * array of 2x2 squares to ensure that all of the corners are clean in
 * the complete display.
 */

void Maze::drawMazeGrid() {
   gp->setColor("WHITE");
   gp->fillRect(x0, y0, cols * SQUARE_SIZE + 1, rows * SQUARE_SIZE + 1);
   gp->setColor("BLACK");
   for (int x = 0; x <= cols; x++) {
      double xc = x0 + x * SQUARE_SIZE;
      for (int y = 0; y <= rows; y++) {
         double yc = y0 + y * SQUARE_SIZE;
         gp->fillRect(xc, yc, 2, 2);
      }
   }
}

void Maze::drawWalls() {
   for (int x = 0; x <= cols; x++) {
      double xc = x0 + x * SQUARE_SIZE;
      for (int y = 0; y <= rows; y++) {
         double yc = y0 + y * SQUARE_SIZE;
         GPoint pt(x, y);
         if (y < rows && wallExists(pt, WEST)) {
            gp->fillRect(xc, yc, 2, SQUARE_SIZE + 1);
         }
         if (x < cols && wallExists(pt, NORTH)) {
            gp->fillRect(xc, yc, SQUARE_SIZE + 1, 2);
         }
      }
   }
}

void Maze::drawMarks() {
   for (int x = 0; x < cols; x++) {
      for (int y = 0; y < rows; y++) {
         GPoint pt(x, y);
         if (isBlocked(pt)) {
            drawMark(pt, "GREEN");
         }
      }
   }
}

void Maze::drawMark(GPoint pt, string color) {
   double x = x0 + (pt.x + 0.5) * SQUARE_SIZE;
   double y = y0 + (pt.y + 0.5) * SQUARE_SIZE;
   double delta = MARK_SIZE / 2;
   gp->setColor(color);
   gp->drawLine(x - delta, y - delta, x + delta, y + delta);
   gp->drawLine(x - delta, y + delta, x + delta, y - delta);
   gp->setColor("BLACK");
   pause(200);
}

void Maze::eraseMark(GPoint pt) {
   double x = x0 + (pt.x + 0.5) * SQUARE_SIZE;
   double y = y0 + (pt.y + 0.5) * SQUARE_SIZE;
   double delta = MARK_SIZE / 2;
   gp->setColor("WHITE");
   gp->fillRect(x - delta - 1, y - delta - 1, MARK_SIZE + 2, MARK_SIZE + 2);
   gp->setColor("BLACK");
   pause(200);
}

void Maze::blockMark(GPoint pt, string color) {
   double x = x0 + (pt.x + 0.5) * SQUARE_SIZE;
   double y = y0 + (pt.y + 0.5) * SQUARE_SIZE;
   double delta = MARK_SIZE / 2;
   gp->setColor(color);
   gp->fillRect(x - delta - 1, y - delta - 1, MARK_SIZE + 2, MARK_SIZE + 2);
   gp->setColor("BLACK");
   pause(200);
}

/*
 * Function: adjacentGPoint
 * Usage: GPoint finish = adjacentGPoint(start, dir);
 * ------------------------------------------------
 * Returns the GPoint that results from moving one square from start
 * in the direction specified by dir.  For example, if pt is the
 * GPoint (1, 1), calling adjacentGPoint(pt, EAST) returns the
 * GPoint (2, 1).  To maintain consistency with the graphics package,
 * the y coordinates increase as you move downward on the screen.  Thus,
 * moving NORTH decreases the y component, and moving SOUTH increases it.
 */

GPoint Maze::adjacentGPoint(GPoint start, Direction dir) {
   int x = start.x;
   int y = start.y;
   switch (dir) {
    case NORTH: return GPoint(x, y - 1);
    case EAST:  return GPoint(x + 1, y);
    case SOUTH: return GPoint(x, y + 1);
    case WEST:  return GPoint(x - 1, y);
   }
   return start;
}
