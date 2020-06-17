/*
 * File: Calculus.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 2 on chapter 2 of Programming Exercises from the Art of Java.
 */

import acm.graphics.*;
import acm.program.*;

/*
 * This program calculates and displays bla bla bla on the screen.
 */

public class Calculus extends ConsoleProgram {
    public void run() {
    	println("Let's calculate the area of a Triangle");
    	double b = readDouble("Enter height: ");
        double h = readDouble("Enter width: ");
        double a = (b * h) / 2;
        println("The area of the triangle is = " + a);
} 
}
