/*
 * File: GymnasticsJudge.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 11 / Programming Exercise 1
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
		double total = 0;
		double max = scores[0];
		double min = scores[0];
		for (int i = 0; i < nJudges; i++) {
			if (scores[i] < min) min = scores[i];
			if (scores[i] > max) max = scores[i];
			total += scores[i];
		}
		double averageScore = (total - max - min) / (nJudges - 2);
		println("The average score is " + averageScore);
	}

}
