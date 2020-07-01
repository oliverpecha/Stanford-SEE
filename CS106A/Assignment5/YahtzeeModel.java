
public class YahtzeeModel implements YahtzeeConstants {
	
	public YahtzeeModel(int nPlayers) {
		scoreBoard = new int[nPlayers + 1][N_CATEGORIES + 1];
		setToNegatives();
	}
	
	private void setToNegatives() {
		for (int x = 0; x < scoreBoard.length; x++) {
			for (int y = 0; y < scoreBoard[x].length; y++) {
				scoreBoard[x][y] = -1;
			}
		}
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
