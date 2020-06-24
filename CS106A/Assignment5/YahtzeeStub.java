
public class YahtzeeStub implements YahtzeeConstants {

	public int pointsForCategory(int [] dices, int category) {
		switch (category) {
			case ONES: return categoryOnes(dices);
			case TWOS: return categoryTwos(dices);
			case THREES: return categoryThrees(dices);
			case FOURS: return categoryFours(dices);
			case FIVES: return categoryFives(dices);
			case SIXES: return categorySixes(dices);
			case THREE_OF_A_KIND: return categoryThreeOfAKind(dices); 
			case FOUR_OF_A_KIND: return categoryFourOfAKind(dices);
			case FULL_HOUSE: return categoryFullHouse(dices);
			case SMALL_STRAIGHT: return categorySmallStraight(dices);
			case LARGE_STRAIGHT: return categoryLargeStraight(dices);
			case YAHTZEE: return categoryYahtzee(dices);
			case CHANCE: return categoryChance(dices);
		}
		return -1;
	}
	
	private int categoryOnes(int [] dices) {
		return 1;
	}
	
	private int categoryTwos(int [] dices) {
		return 2;
	}
	
	private int categoryThrees(int [] dices) {
		return 3;
	}
	
	private int categoryFours(int [] dices) {
		return 4;
	}
	
	private int categoryFives(int [] dices) {
		return 5;
	}
	
	private int categorySixes(int [] dices) {
		return 6;
	}
	
	private int categoryThreeOfAKind(int [] dices) {
		return 33;
	}
	
	private int categoryFourOfAKind(int [] dices) {
		return 44;
	}
	
	private int categoryFullHouse(int [] dices) {
		return 25;
	}
	
	private int categorySmallStraight(int [] dices) {
		return 30;
	}

	private int categoryLargeStraight(int [] dices) {
		return 40;
	}
	
	private int categoryYahtzee(int [] dices) {
		return 50;
	}

	private int categoryChance(int [] dices) {
		return 99;
	}

}
