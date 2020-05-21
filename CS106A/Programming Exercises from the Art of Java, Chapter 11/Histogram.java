/*
 * File: Histogram.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise bonus 6
 * -----------------
 * A histogram is a graphical representation of a statistical distribution that shows how many elements fall into a set of discrete 
 * ranges. For example, given a set of exam scores that contains the following values
 * 			100, 95, 47, 88, 86, 92, 75, 89, 81, 70, 55, 80 
 * a traditional histogram would look something like this:
 * -----------------
 *		  												*
 *		  												*
 *		  												*
 *		 										  *     *     *
 *								*	   *	      *     *     *    *
 *		0–9 10–19 20–29 30–39 40–49 50–59 60–69 70–79 80–89 90–99 100
 * -----------------
 * The asterisks in the histogram indicate one score in the 40s, one score in the 50s, five scores in the 80s, and so forth.
 * When you generate a histogram using a computer, it is usually easier to display the data sideways on the page, as in this sample run:
 * -----------------
 * Write a program that reads in an array of integers and then displays a histogram of those numbers, divided into the ranges 
 * 0–9, 10–19, 20–29, and so forth, up to the range containing only the value 100. Your program should generate output that looks 
 * as much like the sample run as possible.
 */

import java.util.ArrayList;

import javax.swing.JButton;

import acm.program.*;

public class Histogram extends ConsoleProgram {

	int [] scores =	{100, 95, 47, 88, 86, 92, 75, 89, 81, 70, 55, 80};
	ArrayList<ArrayList<String>> graphArray;
	
	private static final int GRAPH_VALUE_COLUMNS = 11;

	public void run() {
		initGraphArray();
		fillGraphArray();
		printGraphArray();
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
		for (int v = 0; v < scores.length; v++) {
			// Divides each score by 10 to get a single number between 0 and 10, which is enough to fill the array with an extra * per score in such a range
			int columnAssigner = scores[v] / 10;
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
