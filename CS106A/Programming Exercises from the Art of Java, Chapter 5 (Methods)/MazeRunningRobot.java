/*
 * File: MazeRunningRobot.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 13
 * -----------------
 * Although Euclid’s algorithm and the problem of finding perfect numbers from the preceding exercise are both drawn from the domain 
 * of mathematics, the Greeks were fascinated with algorithms of other kinds as well. In Greek mythology, for example, Theseus of Athens 
 * escapes from the Minotaur’s labyrinth by taking in a ball of string, unwinding it as he goes along, and then following the path of 
 * string back to the exit. Theseus’s strategy represents an algorithm for escaping from a maze, but it is not the only algorithm he could 
 * have used to solve this problem. For example, if a maze has no internal loops, you can always escape by keeping your right hand against 
 * a wall at all times. This algorithm is called the right-hand rule.
 * -----------------
 * For example, imagine that Theseus is in the maze shown below at the position marked by the Greek letter theta (Θ):
 * -----------------
 * To get out, Theseus walks along the path shown by the dotted line in the next diagram, which he can do without taking his right 
 * hand off the wall.
 * -----------------
 * Suppose you have been asked to write a program for a robot named Theseus to escape from a maze. You have access to a library that 
 * contains these methods:
 * 			void moveForward();		// Move forward to the next square
 * 			void turnRight();		// Turn right without moving
 * 			void turnLeft();		// Turn left without moving 
 * 			boolean isFacingWall(); // True if Theseus is facing a wall
 * 			boolean isOutside();    // True if Theseus has left the maze
 * 
 * -----------------
 * Use these methods to write an algorithmic method solveMaze that implements the right-hand rule.
 */

public class MazeRunningRobot {

	private void solveMaze(MazeRunningRobot robot) {
		
		while (isOutside()) {
			turnRight();
			if (isFacingWall()) {
				turnLeft();
				if (!isFacingWall()) moveForward();
				else if (isFacingWall()) {
					turnLeft();
					moveForward();
				}
			}
			else if (!isFacingWall()) moveForward();
			
		}
		
		
	}

	private void moveForward() {
		// TODO Auto-generated method stub
		
	}
	
	private void turnRight() {
		// TODO Auto-generated method stub
		
	}

	private void turnLeft() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean isFacingWall() {
		// TODO Auto-generated method stub
		return true;
	}
	
	private boolean isOutside() {
		// TODO Auto-generated method stub
		return true;
	}
}
