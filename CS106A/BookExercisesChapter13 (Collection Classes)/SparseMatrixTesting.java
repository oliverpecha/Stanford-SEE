/*
 * File: SparseMatrixTesting.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 13 / Programming Exercise 10
 * -----------------
 */

import acm.program.*;

public class SparseMatrixTesting extends ConsoleProgram {

	public void run() {
		SparseMatrix matrix = new SparseMatrix();
		boolean sentinel = false;
		while (!sentinel) {
			String input = readLine("<-");
			if (input.length() == 0) break;
			else {
				String[] arrOfStr = input.split(", ");
				if (arrOfStr.length == 2) {
					matrix.put(Double.parseDouble(arrOfStr[0]),Double.parseDouble(arrOfStr[1]));
				}
				if (arrOfStr.length == 3) {
					SparseMatrix.Index received = matrix.get(Double.parseDouble(arrOfStr[0]),Double.parseDouble(arrOfStr[1]));
					if (received != null) {
						println(received + " is present in the Sparse Matrix");
					}
					else println(Double.parseDouble(arrOfStr[0]) + ", " + Double.parseDouble(arrOfStr[1]) + " is not found in the Sparse Matrix");
				}
			}

		}
	}
	
}
