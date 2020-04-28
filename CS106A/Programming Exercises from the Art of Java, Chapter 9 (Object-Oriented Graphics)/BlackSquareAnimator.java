/*
 * File: BlackSquareAnimator.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 9 / Programming Exercise 2
 * -----------------
 * Write a GraphicsProgram that draws a filled black square in the center of the canvas. Once you have that part of the program 
 * working, animate your program so that the color of the square changes once a second to a new color chosen randomly by calling 
 * the nextColor method in the RandomGenerator class.
 */

import acm.program.*;
import acm.util.RandomGenerator;
import java.awt.Color;

import acm.graphics.*;

public class BlackSquareAnimator extends GraphicsProgram {

	public void run() {
		double xC = getWidth() / 2;
		double xY = getHeight() / 2;
		RandomGenerator luck = new RandomGenerator();
		Color randomColor = luck.nextColor();
		GRect changingSquare = new GRect(SQUARE_SIZE, SQUARE_SIZE);
		changingSquare.setFillColor(Color.BLACK);
		changingSquare.setFilled(true);
		add (changingSquare, xC - SQUARE_SIZE / 2, xY - SQUARE_SIZE / 2);
		while (true) {
			pause(PAUSE);
			randomColor = luck.nextColor();
			changingSquare.setFillColor(randomColor);
		}
	}
	
	private static final double SQUARE_SIZE = 80;
    private static final int PAUSE = 1000; 
}
