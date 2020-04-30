/*
 * File: PatchworkQuilt.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 5 / Programming Exercise 11
 * -----------------
 * Write a GraphicsProgram that draws a sampler quilt that looks like this:
 * This quilt consists of three different block types, as follows:
 * -----------------
 * - Log cabin block. The first block in the quilt uses a pattern that is popular in traditional quilting. The log cabin block is composed 
 * of a series of frames, each of which is nested inside the next larger one. Each frame is in turn composed of four rectangles - colored 
 * green in this example - laid out to from a square.
 * - Nested square block. The second block also follows a traditional pattern in which squares in alternating colors are stacked so that 
 * each new square is rotated 45’ from the preceding one and then resized so that it fits entirely inside its predecessor. In this diagram, 
 * the squares are filled in cyan and magenta.
 * - I love Java block. While this block is anything but traditional, it gives you a chance to work with more GObject classes. Each quilt 
 * square in this pattern contains a red heart superimposed on a pink background. Centered on each heart is the message “I Love Java” with 
 * one word per line.
 * -----------------
 * One particularly effective way to organize the implementation is to define an abstract class named QuiltBlock that extends GCompound. 
 * Each of the quilt blocks can then be defined as subclasses of QuickBlock, in much the same way that the individual train cars are 
 * subclasses of a more general abstract class.
 */

import acm.graphics.*;
import acm.program.*;

public class PatchworkQuilt extends GraphicsProgram {

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}
	public void run() {
		int width = SCREEN_WIDTH / 5;
		int x = 0;
		int y = 0;
		int n = 0;
		while (x * width < SCREEN_WIDTH && y * width < SCREEN_HEIGHT) {
			add(blockAssigner(n, width), x * width + width / 2, y * width + width / 2);
			n++;
			if (n == 3) n = 0;
			x++;
			if (x * width >= SCREEN_WIDTH) {
				y++;
				x = 0;
			}	
		}
	}
	
	private GObject blockAssigner(int n, int width) {
		GObject assignedObject = null;
		switch (n) {
		case 0: assignedObject = new BlockLogCabin(width); break;
		case 1: assignedObject = new BlockNestedSquare(width); break; 
		case 2:  assignedObject = new BlockILoveJava(width); break;		
		}
		return assignedObject;
	}

	private static final int SCREEN_WIDTH = 600;
	private static final int SCREEN_HEIGHT = 360;
}

