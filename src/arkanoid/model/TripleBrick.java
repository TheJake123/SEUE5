package arkanoid.model;

/**
 * Die Klasse MultiBrick repr�sentiert einen Ziegel im Spiel, welcher 3 mal
 * ber�hrt werden muss um zerst�rt zu werden.
 */
public class TripleBrick extends Brick {

	private int lives = 3;

	/**
	 * TripleBrick-Konstruktor
	 * 
	 * @param x
	 *            x-Position des Ziegels
	 * @param y
	 *            y-Position des Ziegels
	 * @param player
	 *            Aktuelle Spieler des Spieles
	 * @param level
	 *            Aktuelle Level des Spieles
	 * 
	 */
	public TripleBrick(int x, int y, Player player, Level level) {
		super(x, y, player, level);
	}

	/**
	 * R�ckgabe des Namens der Spielfigur.
	 * 
	 * @return String "Triple Brick"
	 */
	@Override
	public String getName() {
		return "Triple Brick";
	}

	/**
	 * R�ckgabe der Punkte des Ziegels und f�r einen Treffer.
	 * 
	 * @return brickPoints Punkte f�r den Ziegel
	 */
	@Override
	public int getPoints() {
		if (lives <= 0) {
			return (brickPoints + 10); // +10 Punkte f�r einen Treffer mit der
										// Zerst�rung des Ziegels
		} else {
			return 10; // +10 Punkte f�r einen Treffer
		}
	}

	/**
	 * Visitor Implementierung, welche das Spielobjekt nach dem letzten Leben
	 * l�scht.
	 * 
	 * @param other
	 *            Spielobjekt das den Ziegel besucht.
	 */
	@Override
	public void visit(GameObject other) {
		super.visit(other);
		if (other instanceof Ball) {
			lives--;
			if (lives <= 0)
				getLevel().removeObject(this);
		}
	}
}
