/*
 * File: HelloProgram.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 1 on chapter 2 of Programming Exercises from the Art of Java.
 */

import acm.graphics.*;
import acm.program.*;

/*
 * This program displays "hello, world" on the screen.
 * It is inspired by the first program in Brian
 * Kernighan and Dennis Ritchie's classic book,
 * The C Programming Language.
 */

public class HelloProgram extends GraphicsProgram {
	public void run() {
		add(new GLabel("I love Java", 100, 75));
		add(new GLabel("by Oliver Pecha", 400, 175));
	}

}
