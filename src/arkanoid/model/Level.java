package arkanoid.model;

public class Level {
	private int lvlNr;
	private GameObject[][] gameboard;
	private int bricksCount;

	public int getBricksCount() {
		return bricksCount;
	}
	public boolean isOver() {
		return bricksCount <= 0;
	}
	public Level(int nr, GameObject[][] gameboard) {
		lvlNr = nr;
		this.gameboard = gameboard;
		bricksCount = countBricks(gameboard);
	} // end Level

	public int getLvlNr() {
		return lvlNr;

	} // end getLvlNr

	private static int countBricks(GameObject[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int a = 0; a < board[0].length; a++) {
				if (board[i][a] instanceof Brick)
					count++;
			}
		}
		return count;
	}
} // end class Level
