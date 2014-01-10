package arkanoid.model;

/**
 * Die Klasse f�r einzelne Levelobjekte. Diese Levels laufen Schrittweise ab,
 * diese Schritte m�ssen von au�erhalb der Klasse initiiert werden.
 * 
 */
public class Level {
	private int lvlNr;
	private GameObject[][] gameboard;

	/**
	 * Die Anzahl an verbleibenden Bricks im Level
	 */
	private int bricksCount;

	/**
	 * Ermittelt, wie viele Bricks noch im Level sind
	 * 
	 * @return Die Anzahl an verbleibenden Bricks
	 */
	protected int getBricksCount() {
		return bricksCount;
	}

	/**
	 * Ermittelt, ob das Spiel noch l�uft oder nicht, d.h. ob noch Bricks
	 * bestehen und der Spieler noch Leben hat
	 * 
	 * @return <code>true</code>, wenn das Spiel vorbei ist
	 */
	protected boolean isOver() {
		return bricksCount <= 0;
	}

	/**
	 * Konstruktor f�r einen Level
	 * 
	 * @param nr
	 *            Die Nummer des Levels
	 * @param gameboard
	 */
	public Level(int nr, GameObject[][] gameboard) {
		lvlNr = nr;
		this.gameboard = gameboard;
	} // end Level

	/**
	 * Ermittelt die aktuelle Levelnummer
	 * 
	 * @return Die Levelnummer des Levels
	 */
	public int getLvlNr() {
		return lvlNr;

	} // end getLvlNr

	/**
	 * Interne Methode. Nimmt das Array and Bricks, f�gt unten 10 und an den
	 * anderen Seiten jeweils 1 Zeile an (um Platz zu schaffen f�r die noch
	 * fehlenden Objekte), f�gt den {@link Bat} und {@link Ball} ein und
	 * platziert die W�nde. Ebenfalls z�hlt es die Bricks zu Beginn.
	 * 
	 * @param board
	 *            Das vorzubereitende Spielfeld
	 * @return
	 */
	private int prepareGameboard(GameObject[][] board)
			throws NullPointerException {
		if (board == null) {
			throw new NullPointerException("No board to prepare");
		}
		int height = board[0].length + 11;
		int width = board.length + 2;
		gameboard = new GameObject[width][height];

		// Create Walls
		// south-wall
		for (int x = 0; x < width; x++)
			gameboard[x][0] = new Wall(x, 0);

		// north-wall
		for (int x = 0; x < width; x++)
			gameboard[x][height - 1] = new Wall(x, height - 1);

		// east-wall
		for (int y = 0; y < height; y++)
			gameboard[0][y] = new Wall(0, y);

		// west-wall
		for (int y = 0; y < height; y++)
			gameboard[width - 1][y] = new Wall(width - 1, y);
		int count = 0;
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++)
				if (board[x][y] instanceof Brick) {
					count++;
					gameboard[x + 1][y + 1] = board[x][y];
				}

		}
		return count;
	}

	public void displayBoard() {
		System.out.println("Showing Board" + gameboard[0].length + "*"
				+ gameboard.length);
		for (int x = 0; x < gameboard.length; x++) {
			for (int y = 0; y < gameboard[0].length; y++)
				if (gameboard[x][y] instanceof Brick) {
					System.out.print("x");
				} else if (gameboard[x][y] instanceof Ball) {
					System.out.print("o");
				} else if (gameboard[x][y] instanceof Wall) {
					System.out.print("w");
				} else if (gameboard[x][y] instanceof Bat) {
					System.out.print("-");
				} else {
					System.out.print(" ");
					;
				}
			System.out.println();
		}

	}

	public void step() {
	} // end step

} // end class Level
