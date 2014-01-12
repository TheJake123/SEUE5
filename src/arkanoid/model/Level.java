package arkanoid.model;

import java.util.ArrayList;

/**
 * Die Klasse für einzelne Levelobjekte. Diese Levels laufen Schrittweise ab,
 * diese Schritte müssen von außerhalb der Klasse initiiert werden.
 * 
 */
public class Level {
	private int lvlNr;
	private GameObject[][] gameboard;
	private ArrayList<Moveable> moveables = new ArrayList<Moveable>();
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private Bat bat = null;
	private ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
	java.util.Random Random = new java.util.Random();

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
	 * Ermittelt, ob das Spiel noch läuft oder nicht, d.h. ob noch Bricks
	 * bestehen und der Spieler noch Leben hat
	 * 
	 * @return <code>true</code>, wenn das Spiel vorbei ist
	 */
	protected boolean isOver() {
		return bricksCount <= 0;
	}

	/**
	 * Konstruktor für einen Level
	 * 
	 * @param nr
	 *            Die Nummer des Levels
	 * @param gameboard
	 */
	public Level(int nr, GameObject[][] gameboard) {
		lvlNr = nr;
		this.bricksCount = prepareGameboard(gameboard);
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
	 * Interne Methode. Nimmt das Array and Bricks, fügt unten 10 und an den
	 * anderen Seiten jeweils 1 Zeile an (um Platz zu schaffen für die noch
	 * fehlenden Objekte), fügt den {@link Bat} und {@link Ball} ein und
	 * platziert die Wände. Ebenfalls zählt es die Bricks zu Beginn.
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
			gameboard[x][0] = new Wall(x, 0, width, height);

		// north-wall
		for (int x = 0; x < width; x++)
			gameboard[x][height - 1] = new Wall(x, height - 1, width, height);

		// east-wall
		for (int y = 0; y < height; y++)
			gameboard[0][y] = new Wall(0, y, width, height);

		// west-wall
		for (int y = 0; y < height; y++)
			gameboard[width - 1][y] = new Wall(width - 1, y, width, height);
		int count = 0;
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++)
				if (board[x][y] instanceof Brick) {
					count++;
					gameboard[x + 1][y + 1] = board[x][y];
				}

		}
		bat = new Bat(width / 2, height - 2, 1);
		Ball ball = new Ball(width / 2, height - 3, Random.nextInt(3) - 1, -1);
		addObject(bat);
		addObject(ball);
		balls.add(ball);
		return count;
	}

	protected void addObject(GameObject o) {
		int x = o.getPosX();
		int y = o.getPosY();
		if (gameboard[x][y] == null) {
			if (o instanceof Ball) {
				balls.add((Ball) o);
			} else if (o instanceof Bat) {
				if (bat != null) {
					gameboard[bat.getPosX()][bat.getPosY()] = null;
					bat.setLevel(null);
				}
				bat = (Bat) o;
			} else if (o instanceof PowerUp) {
				powerups.add((PowerUp) o);
			} else {
				return;
			}
			if (o instanceof Moveable)
				moveables.add((Moveable) o);
			gameboard[x][y] = o;
			o.setLevel(this);
		}
	}

	public void displayBoard() {
		System.out.println("Showing board with dimensions "
				+ gameboard[0].length + "*" + gameboard.length);
		for (int y = 0; y < gameboard[0].length; y++) {
			for (int x = 0; x < gameboard.length; x++)
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
				}
			System.out.println();
		}
	}

	protected void remove(GameObject o) {
		int x = o.getPosX();
		int y = o.getPosY();
		if (gameboard[x][y] == o) {
			gameboard[x][y] = null;
			o.setLevel(null);
		}
	}

	public void step() {
		for (Moveable m : moveables) {
			m.move();
		}
		for (Ball b : balls) {
			int x = b.getPosX();
			int y = b.getPosY();
			GameObject other = gameboard[x][y];
			if (other.getPosX() == x && other.getPosY() == y) {
				b.accept(other);
				other.accept(b);
			}
		}
		
	}
} // end class Level
