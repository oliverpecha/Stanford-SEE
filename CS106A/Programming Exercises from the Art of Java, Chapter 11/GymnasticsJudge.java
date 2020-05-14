/*
 * File: GymnasticsJudge.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 1, 2 & 3.
 * -----------------
 * Because individual judges may have some bias, it is common practice to throw out the highest and lowest score 
 * before computing the average. Write a program that reads in scores from a panel of seven judges and then computes 
 * the average of the five scores that remain after discarding the highest and lowest.
 */

import acm.program.*;

public class GymnasticsJudge extends ConsoleProgram {

	public void run() {
		int nJudges = readInt("Enter number of judges: ");
		double[] scores = new double[nJudges];
		for (int i = 0; i < nJudges; i++) {
			scores[i] = readDouble("Score for judge " + (i + 1) + ": ");
		}
		double averageScore =  mean(scores);
		double stdev =  stdev(scores);

		println("The average score is " + averageScore + ". The standard deviation is " + stdev);
	}

	private double mean(double [] array) {
		int lenght = array.length;
		double total = 0;
		double max = array[0];
		double min = array[0];
		for (int i = 0; i < lenght; i++) {
			if (array[i] < min) min = array[i];
			if (array[i] > max) max = array[i];
			total += array[i];
		}
		double mean = (total - max - min) / (lenght - 2);
		return mean;
	}
	
	private double stdev(double [] array) {
		double mean = mean(array);
		int lenght = array.length;
		double total = 0;
		double difference = 0;
		for (int i = 0; i < lenght; i++) {
			difference = mean - array[i];
			difference *= difference;
			total += difference;
		}
		double stdev = Math.sqrt(total / lenght);
		return stdev;
	}
	
}
