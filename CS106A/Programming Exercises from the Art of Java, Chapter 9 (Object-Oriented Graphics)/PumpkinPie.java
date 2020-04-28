/*
 * File: PumpkinPie.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 6
 * -----------------
 * Besides jack-o’-lanterns, one of the things you can make with pumpkins is pumpkin pie. Write a GraphicsProgram program that draws 
 * a picture of a pumpkin pie divided divided into equal wedge-shaped pieces where the number of pieces is indicated by the constant 
 * N_PIECES. Each wedge should be a separate GArc, filled in orange and outlined in black. The following sample run, for example, 
 * shows the diagram when N_PIECES is 6.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class PumpkinPie extends GraphicsProgram {
	
	public void init() {
	    setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	public void run() {
		for (int i = 0; i < N_PIECES; i++) {
			GArc piece = new GArc(2 * RADIUS, 2 * RADIUS, i * (360 / N_PIECES), 360 / N_PIECES);
			piece.setFillColor(Color.ORANGE);
			piece.setFilled(true);
			add(piece, SCREEN_WIDTH / 2 - RADIUS, SCREEN_HEIGHT / 2 - RADIUS);
		}

	}

	private static final int N_PIECES = 6;
	private static final int RADIUS = 100;

	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 500;
}
