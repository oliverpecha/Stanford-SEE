/*
 * File: ThisOldManSong.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * This file solves problem 2 on chapter 4 of Programming Exercises from the Art of Java.
 */

import acm.program.ConsoleProgram;

public class ThisOldManSong extends ConsoleProgram {

	
	public void run () {
		
		for (int i = 1; i <= 10 ; i++) {
			switch (i) {
			case 1: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog a " + FIRST + ".");
				println("This old man came rolling home.");
				break;
			case 2: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog a " + SECOND + ".");
				println("This old man came rolling home.");
				break;
			case 3: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog a " + THIRD + ".");
				break;
			case 4: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog a " + FOURTH + ".");
				break;
			case 5: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog a " + FIVETH + ".");
				break;
			case 6: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog a " + SIXTH + ".");
				break;
			case 7: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog a " + SEVENTH + ".");
				break;
			case 8: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog	 " + EIGHT + ".");
				break;
			case 9: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog a " + NINETH + ".");
				break;
			case 10: 
				println("This old man, he played " + i +".");
				println("He played knick-knack on my thumb");
				println("With a knick-knack, paddy-whack, Give your dog a " + TENTH + ".");
				break;
			}
			println("");
		}
	}					
	/* Private constants */
	private static final String FIRST = "thumb";
	private static final String SECOND = "shoe";
	private static final String THIRD = "knee";
	private static final String FOURTH = "door";
	private static final String FIVETH = "hive";
	private static final String SIXTH = "sticks";
	private static final String SEVENTH = "up to heaven";
	private static final String EIGHT = "pate";
	private static final String NINETH = "spine";
	private static final String TENTH = "shin";

}