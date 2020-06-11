/*
 * File: FibonacciRecursion.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 14 / Programming Exercise 5
 * -----------------
 */

import java.util.ArrayList;
import acm.program.ConsoleProgram;

public class HanoiTowerRecursion extends ConsoleProgram {
	
	public void run() {
		int n = 4; // Number of disks
		fillHanoi(n);
		printTowers(n);
		towerOfHanoi(n, 'A', 'B', 'C'); // A, B and C are names of rods 
		printTowers(n);
	}

	private void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) { 
		if (n == 1) { 
			println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
			moveDisk(from_rod, to_rod);
			return; 
		} 
		towerOfHanoi(n-1, from_rod, aux_rod, to_rod); 
		printTowers(n);
		moveDisk(from_rod, to_rod);
		towerOfHanoi(n-1, aux_rod, to_rod, from_rod); 
	} 
	
	private void moveDisk(int origin, int destination) {
		int towerOrigin = letterToArray(origin);
		int towerDestination = letterToArray(destination);
		hanoi.get(towerDestination).add(hanoi.get(towerOrigin).get(hanoi.get(towerOrigin).size()-1));
		hanoi.get(towerOrigin).remove(hanoi.get(towerOrigin).size()-1);
	}
	
	private void printTowers(int maxHeight) {
		String result = "";
		for (int r = maxHeight; r > 0; r--) {
			for (int c = 0; c < hanoi.size(); c++) {
				if (hanoi.get(c).size() >= r) {
					result += "" + hanoi.get(c).get(r-1).getWidth();
				}
				else {
					result += " ";
				}
			}
		println("_" + result + "_");
		result = "";
		}	
	}
	
	private int letterToArray(int character) {
		switch (character) {
			case ('A'): return 0;
			case ('B'): return 1;
			case ('C'): return 2;
		}
		return -5;
	}
	
	private void fillHanoi(int height) {
		hanoi = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			hanoi.add(new ArrayList());
		}
		for (int n = height; n > 0; n--) {
			hanoi.get(0).add(new Disk(n));
		}
	}
	
	ArrayList<ArrayList<Disk>> hanoi;
	
private class Disk {
	
	public Disk(int size) {
		width = size;
	}
	
	public int getWidth() {
		return width;
	}
	
	int width;
}

}
