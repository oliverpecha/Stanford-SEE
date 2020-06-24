
public class YahtzeeModel implements YahtzeeConstants {
	
	public YahtzeeModel(int nPlayers) {
		scoreBoard = new int[nPlayers][N_CATEGORIES];
	}
	
	public void setScore(int player, int category, int value) {
		scoreBoard[player][category] = value;
	}
	
	public int getScore(int player, int category) {
		return scoreBoard[player][category];
	}
	
	public int[][] getscoreBoard() {
		return scoreBoard;
	}
	
	int[][] scoreBoard;
}
