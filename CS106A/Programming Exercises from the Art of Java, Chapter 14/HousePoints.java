/*
 * File: HousePoints.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 14 / Programming Exercise 8
 * -----------------
 * This program displays the house points for the Hogwarts houses
 * in both a bar graph and a pie chart view.  The purpose of the
 * program is to illustrate the model/view/controller pattern
 * described in Chapter 14.  This version, however, is unfinished;
 * completion of the program appears as exercise 7.
 */

import acm.program.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;

public class HousePoints extends GraphicsProgram {

	int[] initialData = {312, 352, 426, 472,};
	HousePointsModel model = new HousePointsModel();
	JTextField input = new JTextField(MAX_CHAR_FIELD);
	BarGraphView barGraph;
	PieChartView pieChart;
	
	public void init() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		startFrame();
		startModel();
		startBarGraphView();
		startPieChartView();
		addActionListeners();
	}
	
	private void startModel() {
		model.setHousePoints(initialData);
	}
	
	private void startBarGraphView() {
		barGraph = new BarGraphView(SCREEN_WIDTH / 2 - 2 * HORIZONTAL_MARGIN, SCREEN_HEIGHT - SOUTH_BAR - 2 * VERTICAL_MARGIN);
		barGraph.update(model);
		add(barGraph, HORIZONTAL_MARGIN, VERTICAL_MARGIN);
	}
	
	private void startPieChartView() {
		pieChart = new PieChartView(SCREEN_WIDTH / 2 - 2 * HORIZONTAL_MARGIN, SCREEN_HEIGHT - SOUTH_BAR - 2 * VERTICAL_MARGIN);
		pieChart.update(model);
		add(pieChart, 3 * HORIZONTAL_MARGIN + barGraph.getWidth(), VERTICAL_MARGIN);
	}
	
	
	private void startFrame() {
		JLabel points = new JLabel("Points");
		add(points, SOUTH);
		add(input, SOUTH);
		JButton graph = new JButton("Graph");
		add(graph, SOUTH);
	}

	private int[] inputToArray(String input) {
		StringTokenizer tokens = new StringTokenizer(input, " ,");
		int[] array = new int[4];
		for (int i = 0; i < 4; i++) {
			array[i] = Integer.parseInt(tokens.nextToken());
		}
		return array;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Graph")) {
			model.setHousePoints(inputToArray(input.getText()));
			barGraph.update(model);
			pieChart.update(model);
		}
	}
	
	private static final int MAX_CHAR_FIELD = 20;
	private static final int SOUTH_BAR = 50;
	private static final int SCREEN_WIDTH = 320;
	private static final int SCREEN_HEIGHT = 330;
	private static final int HORIZONTAL_MARGIN = SCREEN_WIDTH / 8;
	private static final int VERTICAL_MARGIN = SCREEN_HEIGHT / 10;

}
