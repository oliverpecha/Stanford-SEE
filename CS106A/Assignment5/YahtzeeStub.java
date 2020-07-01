import java.util.Arrays;

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
		return categoryAll(dices, 1);
	}
	
	private int categoryTwos(int [] dices) {
		return categoryAll(dices, 2);
	}
	
	private int categoryThrees(int [] dices) {
		return categoryAll(dices, 3);
	}
	
	private int categoryFours(int [] dices) {
		return categoryAll(dices, 4);
	}
	
	private int categoryFives(int [] dices) {
		return categoryAll(dices, 5);
	}
	
	private int categorySixes(int [] dices) {
		return categoryAll(dices, 6);
	}
	
	private int categoryAll(int [] dices, int value) {
		int result = 0;
		for (int i = 0; i < dices.length; i++) {
			if ( dices[i] == value) {
				result += dices[i];
			}	
		}
		return result;
	}
	
	private int categoryThreeOfAKind(int [] dices) {
		int repeating = findRepeating(dices, 3, 0);
		return repeating * 3;
	}
	
	private int categoryFourOfAKind(int [] dices) {
		int repeating = findRepeating(dices, 4, 0);
		return repeating * 4;
	}
	
	private int findRepeating(int [] dices, int goal, int exception) {
		for (int i = 0; i < dices.length; i++) {
			if (dices[i] != exception) {
				int count = 1;
				int repeating = dices[i];
				for (int u = 0; u < dices.length; u++) {
					if (u != i && dices[u] == repeating) count++; 
					if (count == goal) return repeating;	
				}	
			}
		}
		return 0;
	
	}
	
	private int categoryFullHouse(int [] dices) {
		int repeatingFirst = findRepeating(dices, 3, 0);
		int repeatingSecond = 0;
		if (repeatingFirst > 0) {
			repeatingSecond = findRepeating(dices, 2, repeatingFirst);
		}
		if (repeatingSecond > 0) return 25;
		else return 0;
	}
	
	private int categorySmallStraight(int [] dices) {
		int consecutive = 4;
		return straighValues(dices, consecutive);
	}
	
	private int categoryLargeStraight(int [] dices) {
		int consecutive = 5;
		return straighValues(dices, consecutive);
	}
	
	private int straighValues(int [] dices, int consecutive) {
		Arrays.sort(dices);
		int testValue = dices[0] + 1;
		int remaining = consecutive - 1;
		int lowestAccepted =  6 - consecutive + 1 + 1 + 1;
		if (testValue < lowestAccepted) {  
			for (int i = 0; i < dices.length; i++) {
				if (hasNextValue(dices, testValue)) {
					remaining--;
					if (remaining == 0 && consecutive == 5) return 40;
					if (remaining == 0 && consecutive == 4) return 30;
					testValue++;
				}
				else break;
			}	
		}
		return 0;
	}
	
	private boolean hasNextValue(int [] dices, int target) {
		for (int i = 0; i < dices.length; i++) {
			if (dices[i] == target) return true;
		}
		return false;
	}
	
	private int categoryYahtzee(int [] dices) {
		int reference = dices[0];
		for (int i = 1; i < dices.length; i++) {
			if (dices[i] != reference) return 0;
		}
		return 50;
	}

	private int categoryChance(int [] dices) {
		int result = 0;
		for (int i = 0; i < dices.length; i++) {
			result += dices[i];
		}
		return result;
	}

}
