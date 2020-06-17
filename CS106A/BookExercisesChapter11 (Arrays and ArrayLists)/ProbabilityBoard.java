/*
 * File: ProbabilityBoard.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise bonus 7
 * -----------------
 * The mechanism depicted in the following diagram—which has sometimes been marketed by toy stores as a “probability board”—can be 
 * used to demonstrate important properties of random processes.
 * The mechanism works as follows. You start by dropping a marble in the hole at the top. The marble falls down and hits the uppermost 
 * peg, indicated by the small circle in the diagram. The marble bounces off the peg and falls, with equal probability, to the left 
 * or right. Whichever way it goes, it then hits a peg on the second level and bounces again, one direction or the other. The process 
 * continues until the marble passes all the pegs and drops into one of the channels at the bottom. For example, the dotted line in 
 * the following diagram shows one possible path for the marble:
 * Write a program to simulate the operation of dropping 50 marbles into a probability board with 10 channels along the bottom, as in 
 * the diagram. Your program should display its results pictorially using the acm.graphics package described in Chapter 8. As each 
 * marble lands, the program should draw a circle at the appropriate place on the screen. The following screen image shows one possible 
 * sample run:
 * Note that the marbles tend to cluster in the center channels. The reason for this behavior is that there are many more ways in which 
 * a marble can reach the center columns than the ones on the ends. For example, to reach the leftmost column, the marble must have 
 * bounced to the left nine times in a row. In contrast, there are many paths from the top to the two center columns because the order 
 * of the left and right bounces can be reordered without affecting where the marble ends up. In general, the likelihood that a random 
 * process will end up in a particular state depends on the number of ways of reaching that state.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class ProbabilityBoard extends GraphicsProgram{

	Ball ball;
	int [] ballCount;
	RandomGenerator luck;
	
	public void init() {
		luck = new RandomGenerator();
		ballCount = new int [BALL_COLUMNS];
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		drawBoard();
		startBallthrow();
	}

	private void startBallthrow() {
		for (int i = 0; i < BALLS; i++) {
			int ballAtColumn = movementSimulation();
			displayBallthrow(ballAtColumn);
			ballCount[ballAtColumn] += 1; 
		}
	}
	
	private int movementSimulation() {
		int p = 0;
		for (int i = 0; i < 9; i++) {
			p += luck.nextInt(2);
		}
		return p;
	}
	
	private void displayBallthrow(int ballAtColumn) {
		ball = new Ball();
		add(ball, BOARD_0_X + BOARD_SPACE * ballAtColumn + BALL_MARGIN / 2, SCREEN_HEIGHT - BALL_DIAMETER - ballCount[ballAtColumn] * (BALL_DIAMETER + BALL_MARGIN));
	}

	public void drawBoard() {
		for (int i = 0; i < BALL_COLUMNS + 1; i++) {
			add(new GLine(BOARD_0_X + BOARD_SPACE * i, SCREEN_HEIGHT, BOARD_0_X + BOARD_SPACE * i, BOARD_HEIGHT));
		}
	}
	
	private static final int SCREEN_WIDTH = 600;
	private static final int SCREEN_HEIGHT = 700;
	private static final int BALLS = 50;
	private static final int BALL_COLUMNS = 10;
	private static final int BALL_DIAMETER = 30;
	private static final int BALL_MARGIN = 4;
	private static final int BOARD_SPACE = BALL_MARGIN + BALL_DIAMETER;
	private static final int BOARD_0_X = (SCREEN_WIDTH - BOARD_SPACE * BALL_COLUMNS) / 2;
	private static final int BOARD_HEIGHT = SCREEN_HEIGHT - (SCREEN_HEIGHT / 10 * 9);

private class Ball extends GOval {

	public Ball() {
		super(BALL_DIAMETER, BALL_DIAMETER);
		super.setFilled(true);
	}
	
}

}
