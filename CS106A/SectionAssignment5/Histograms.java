/*
 * File: Histograms.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Section Assignment 5 / Programming Exercise 2
 * -----------------
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;

import acm.program.*;

public class Histograms extends ConsoleProgram {

	ArrayList<Integer> scores;
	ArrayList<ArrayList<String>> graphArray;
	private static final int GRAPH_VALUE_COLUMNS = 11;

	public void run() {
		initGraphArray();
		BufferedReader file = openInputFile("MidTermScores.txt");
		try {
			fileToArray(file);
		} catch (IOException e) {
			println("Something is wrong :(");
			e.printStackTrace();
		}
		fillGraphArray();
		printGraphArray();
	}
	
	private void fileToArray(BufferedReader file) throws IOException {
		scores = new ArrayList<Integer>();
		String line = file.readLine();
		while (line != null) {
			scores.add(Integer.parseInt(line));
			line = file.readLine();
		}
	}
	
	private BufferedReader openInputFile(String prompt) {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				rd = new BufferedReader(new FileReader(prompt));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return rd;
	}
	
	// Starts an ArrayList and turns it into a Multidimensional ArrayList 
	private void initGraphArray() {
		graphArray = new ArrayList<>(GRAPH_VALUE_COLUMNS);
		for(int i=0; i < GRAPH_VALUE_COLUMNS; i++) {
		    graphArray.add(new ArrayList());
		}
	}

	private void fillGraphArray() {
		fillGraphArrayLegend();
		fillGraphArrayAmount();
	}
	
	// Adds the legend to the first element of each row in the Array
	private void fillGraphArrayLegend() {
		String legendCell = "";
		int variable = 0;
		for (int l = 0; l < GRAPH_VALUE_COLUMNS; l++) {
	    	if (variable < 100) legendCell = "" + variable + " - " + (variable + 9);
	    	else legendCell = "" + variable;
	    	// As a graphical display of the results is necessary, adds as many necessary spaces to make all the legends visually equal/in Convention
	    	legendCell = legendInConvention(legendCell, 9);
			graphArray.get(l).add(legendCell);
			variable += 10;	    
		}
	}
	
	private String legendInConvention(String legend, int desiredLenght) {
		int legendLength = legend.length();
		int spacesToAdd = desiredLenght - legendLength;
		for (int i = 0; i < spacesToAdd; i++) {
			legend += " ";
		}
		return legend + "| ";
	}
	
	private void fillGraphArrayAmount() {
		for (int v = 0; v < scores.size(); v++) {
			// Divides each score by 10 to get a single number between 0 and 10, which is enough to fill the array with an extra * per score in such a range
			int columnAssigner = scores.get(v) / 10;
			if (graphArray.get(columnAssigner).size() <= 1) graphArray.get(columnAssigner).add("* ");
			else {
				String currentValue = graphArray.get(columnAssigner).get(1);
				graphArray.get(columnAssigner).set(1, currentValue + "* ");
			}
		}
	}
	
	private void printGraphArray() {
		for (int p = 0; p < GRAPH_VALUE_COLUMNS; p++) {
			if (graphArray.get(p).size() > 1) println(graphArray.get(p).get(0) + graphArray.get(p).get(1));
			else println(graphArray.get(p).get(0));	
		}
	}
}
