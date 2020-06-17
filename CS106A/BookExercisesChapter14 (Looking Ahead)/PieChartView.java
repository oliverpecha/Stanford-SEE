/*
 * File: PieChartView.java
 * -----------------------
 * This class represents a concrete implementation of the
 * GraphView class that builds a pie chart.  The details
 * of the implementation are left to you as an exercise.
 */
import java.awt.Color;

import acm.graphics.*;

public class PieChartView extends HousePointsView {

/** Creates a new PieChartView */
	public PieChartView(double width, double height) {
		super(width, height);
	}

	public void createGraph(int[] data) {
		int totalPoints = arrayToTotalPoints(data);
		int referenceAxis = (int) Math.min(this.getWidth(), this.getHeight());
		double lastSweep = 90;
		double x = this.getWidth() / 2;
		double y = this.getHeight() / 2;
		for (int i = 0; i < data.length; i++) {
			double segmentSweep = data[i] * 360.0 / totalPoints;
			GArc segment = new GArc(x - referenceAxis / 2, y - referenceAxis / 2, referenceAxis, referenceAxis, lastSweep, segmentSweep);
			segment.setFilled(true);
			segment.setFillColor(getColorForIndex(i));
			add(segment);
			lastSweep += segmentSweep;
		}
	}

	private int arrayToTotalPoints(int[] data) {
		int total = 0;
		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}
		return total;
	}
	
}
