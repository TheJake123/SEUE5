package arkanoid.model;

import java.util.ArrayList;

/**
 * Die Klasse für einzelne Levelobjekte. Diese Levels laufen Schrittweise ab,
 * diese Schritte müssen von außerhalb der Klasse initiiert werden.
 * 
 */
public class Level {
	private Bat bat = null;
	private int bricksCount;
	private GameObject[][] gameboard;
	private int height;
	private int lvlNr;
	private ArrayList<Moveable> moveables = new ArrayList<Moveable>();
	private Player player;
	private java.util.Random Random = new java.util.Random();
	private int width;

	/**
	 * Konstruktor für einen Level
	 * 
	 * @param nr
	 *            Die Nummer des Levels
	 * @param gameboard
	 *            Das Feld mit den Spielobjekten
	 */
	public Level(int nr, GameObject[][] gameboard, Player player) {
		lvlNr = nr;
		this.player = player;
		this.bricksCount = prepareGameboard(gameboard);
	} // end Level

	/**
	 * Schreibt das Spielfeld grafisch in die Konsole.
	 * 
	 */
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

	/**
	 * Ermittelt, wie hoch das Spielfeld ist
	 * 
	 * @return height Höhe des Spielfeldes
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Ermittelt die aktuelle Levelnummer
	 * 
	 * @return Die Levelnummer des Levels
	 */
	public int getLvlNr() {
		return lvlNr;

	} // end getLvlNr

	/**
	 * Ermittelt, wie breit das Spielfeld ist.
	 * 
	 * @return width Breite des Spielfeldes
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Die Methode simuliert einen nächsten Schritt innerhalb eines Spieles,
	 * wodurch alle bewegbaren Spielobjekte die Position verändern und der Score
	 * gegebenfalls erhöht wird.
	 */
	public void step() {
		if (player.getScore() > 0) {
			player.setScore(player.getScore() - 1);
			System.out.println("Score wird um 1 auf " + player.getScore()
					+ " verringert");
		}
		for (Moveable m : moveables) {
			m.move();
		}
		for (Moveable m : moveables) {
			GameObject o = (GameObject) m;
			GameObject other = gameboard[o.getPosX()][o.getPosY()];
			while (other != null && other.getPosX() == o.getPosX()
					&& other.getPosY() == o.getPosY()) {
				o.accept(other);
				other.accept(o);
				System.out.println(o.getName() + " kollidiert mit "
						+ other.getName() + " an der Stelle (" + o.getPosX()
						+ "," + o.getPosY() + ")");
			}
		}
		for (int y = 0; y < gameboard[0].length; y++) {
			for (int x = 0; x < gameboard.length; x++) {
				GameObject o = gameboard[x][y];
				if (o != null && (o.getPosX() != x || o.getPosY() != y)) {
					if (gameboard[o.getPosX()][o.getPosY()] == null) {
						gameboard[o.getPosX()][o.getPosY()] = o;
						gameboard[x][y] = null;
					} else {
						o.setPosX(x);
						o.setPosY(y);
					}
				}
			}
		}
		if (bricksCount <= 0) {

			player.setScore(player.getScore() + 50);
			System.out
					.println("Letzten Brick abgeschossen. Score wird um 50 auf "
							+ player.getScore() + " erhöht");
		}
		// displayBoard();
	}

	/**
	 * Fügt dem Level ein neues Spielobjekt hinzu.
	 * 
	 * @param o
	 *            Spielobjekt das dem Level hinzugefügt werden soll.
	 */
	public void addObject(GameObject o) {
		int x = o.getPosX();
		int y = o.getPosY();
		if (gameboard[x][y] == null) {
			if (o instanceof Ball || o instanceof PowerUp) {
				System.out.println("Neues Objekt: " + o.getName()
						+ " an Stelle (" + o.getPosX() + "," + o.getPosY()
						+ ")");
			} else if (o instanceof Bat) {
				if (bat != null) {
					gameboard[bat.getPosX()][bat.getPosY()] = null;
					bat.setLevel(null);
				}
				bat = (Bat) o;
			} else {
				return;
			}
			if (o instanceof Moveable)
				moveables.add((Moveable) o);
			gameboard[x][y] = o;
			o.setLevel(this);
		}
	}

	/**
	 * Ermittelt, wie viele Bricks noch im Level sind
	 * 
	 * @return Die Anzahl an verbleibenden Bricks
	 */
	public int getBricksCount() {
		return bricksCount;
	}

	/**
	 * Ermittelt, ob das Spiel noch läuft oder nicht, d.h. ob noch Bricks
	 * bestehen und der Spieler noch Leben hat
	 * 
	 * @return <code>true</code>, wenn das Spiel vorbei ist
	 */
	protected boolean isOver() {
		return bricksCount <= 0 || player.getLives() <= 0;
	}

	/**
	 * Entfernt dem Level ein Spielobjekt.
	 * 
	 * @param o
	 *            Spielobjekt das aus dem Level gelöscht werden soll.
	 */
	public void removeObject(GameObject o) {
		int x = o.getPosX();
		int y = o.getPosY();
		if (gameboard[x][y] == o) {
			gameboard[x][y] = null;
			o.setLevel(null);
			if (o instanceof Moveable) {
				moveables.remove(o);
			}
			if (o instanceof Brick) {
				bricksCount--;
			}
		}
	}

	/**
	 * Interne Methode. Nimmt das Array and Bricks, fügt unten 10 und an den
	 * anderen Seiten jeweils 1 Zeile an (um Platz zu schaffen für die noch
	 * fehlenden Objekte), fügt den {@link Bat} und {@link Ball} ein und
	 * platziert die Wände. Ebenfalls zählt es die Bricks zu Beginn.
	 * 
	 * @param board
	 *            Das vorzubereitende Spielfeld
	 * @return Die Anzahl an Bricks im Feld
	 */
	private int prepareGameboard(GameObject[][] board)
			throws NullPointerException {
		if (board == null) {
			throw new NullPointerException("No board to prepare");
		}
		height = board[0].length + 11;
		width = board.length + 2;
		gameboard = new GameObject[width][height];

		// Create Walls
		// south-wall
		for (int x = 0; x < width; x++)
			gameboard[x][0] = new Wall(x, 0, this, player);

		// north-wall
		for (int x = 0; x < width; x++)
			gameboard[x][height - 1] = new Wall(x, height - 1, this, player);

		// east-wall
		for (int y = 0; y < height; y++)
			gameboard[0][y] = new Wall(0, y, this, player);

		// west-wall
		for (int y = 0; y < height; y++)
			gameboard[width - 1][y] = new Wall(width - 1, y, this, player);
		int count = 0;
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++)
				if (board[x][y] instanceof Brick) {
					count++;
					gameboard[x + 1][y + 1] = board[x][y];
					board[x][y].setLevel(this);
				}

		}
		addObject(new Bat(width / 2, height - 2, 1, this));
		addObject(new Ball(width / 2, height - 3, Random.nextInt(3) - 1, -1,
				this));
		return count;
	}
} // end class Level
