/*
 * File: PascaleTriangleRecursive.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 14 / Programming Exercise 3
 * -----------------
 */

import acm.program.*;

import java.awt.Color;

import acm.graphics.*;

public class PascaleTriangleRecursive extends GraphicsProgram {

	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
	}
	
	public void run() {
		int topMargin = 10;
		int rowMargin = 55;
		int wrapRadius = 18;
		int rowHeight = rowMargin + 2 * wrapRadius;
		int maxRows = SCREEN_HEIGHT / rowHeight * 2;
		for (int v = 0; v < maxRows - 1 ; v++) {
			int r = -1;
			for (int h = 4; h >= 4 - v; h--) {
				r++;
				int x1 = 30 * v;
				int x2 = 60 * r;
				int xOper = SCREEN_WIDTH / 2 + x2 - x1;
				GLabel  label = new GLabel("" + combinations(v,r));
						label.setFont("-17");
				GOval   wrap = new GOval(2 * wrapRadius, 2 * wrapRadius);
				add(wrap, xOper - wrapRadius, topMargin + rowMargin * v );
		        add(label, xOper - 0.45 * label.getWidth(), topMargin + rowMargin * v + wrapRadius + 0.32 * label.getHeight());
			}
		}
	}

	private int combinations(int n, int k) {
		if (n == 0 || k == 0 || n == k) {
			return 1;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	private static final int SCREEN_WIDTH = 500;
	private static final int SCREEN_HEIGHT = 400;
}








