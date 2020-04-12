/*
 * File: MathQuiz.java
 * Name: Oliver Pecha
 * Section Leader: Online Learning
 * -----------------
 * Book / Chapter 6 / Programming Exercise 7
 * -----------------
 *  Implement a new class called Card that includes the following entries:
 *  	• Named constants for the four suits (CLUBS, DIAMONDS, HEARTS, SPADES) and the four ranks that are traditionally 
 *  	represented in words (ACE, JACK, QUEEN, KING). The values of the rank constants should be 1, 11, 12, and 13, respectively.
 *  	• A constructor that takes a rank and a suit and returns a Card with those values.
 * 		• Accessor methods getRank and getSuit to retrieve the rank and suit components of a card.
 * 		• An implementation of the toString method that returns the complete name of the card as in exercise 1. Remember that you can 
 * 		use the + operator to connect the different parts of the string together, as shown in the toString implementation for the Rational 
 * 		class in Figure 6-9.
 */

public class Card {

	/**
	 * Creates a new Card object with the specified rank and suit.
	 * @param rank The student's rank an int
	 * @param suit The card's suit as an int
	 */
		public Card(int rank, int suit) {
			cardRank = rank;	
			cardSuit = suit;
		}
		
	/**
	 * Gets the rank of this card.
	 * @return The rank of this card
	 */
		public int getRank() {	
			return cardRank;
		}
		
	/**
	 * Gets the suit of this card.
	 * @return The suit of this card
	 */
		public int getSuit() {	
			return cardSuit;
		}

	/**
	 * Creates a string identifying this card.
	 * @return The string used to display this card
	 */
		public String toString() {
			String rank = null;
			String suit = null;	
			cardRank = getRank();
			cardSuit = getSuit();
			switch (cardRank) {
				case 1: 	rank = (ACE); break;
		        case 2: 	rank = ("Two"); break;
		        case 3: 	rank = ("Three"); break;
		        case 4: 	rank = ("Four"); break;
		        case 5: 	rank = ("Five"); break;
		        case 6: 	rank = ("Six"); break;
		        case 7: 	rank = ("Seven"); break;
		        case 8: 	rank = ("Eight"); break;
		        case 9: 	rank = ("Nine"); break;
		        case 10: 	rank = ("Ten"); break;
		        case 11:	rank = (JACK); break;
		        case 12:	rank = (QUEEN); break;
		        case 13: 	rank = (KING); break; 	 
			}
			switch (cardSuit) {
				case 1: 	suit = (CLUBS); break;
		        case 2: 	suit = (DIAMONDS); break;
		        case 3: 	suit = (HEARTS); break;
		        case 4: 	suit = (SPADES); break;
			}
			return rank + " of " + suit;		
		}
		
	/* Private instance variables */
		private int cardSuit;  		/* The card's Suit      */
		private int cardRank;        	/* The card's Rank      */
	
	/* Private constants for Suits */
		private static final String CLUBS = "Clubs";
		private static final String DIAMONDS = "Diamonds";
		private static final String HEARTS = "Hearts";
		private static final String SPADES = "Spades";

	/* Private constants for Ranks */
		private static final String ACE = "Ace";
		private static final String JACK = "Jack";
		private static final String QUEEN = "Queen";
		private static final String KING = "King";

}
