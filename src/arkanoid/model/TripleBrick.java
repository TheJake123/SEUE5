package arkanoid.model;

/**
 * Die Klasse MultiBrick repräsentiert einen Ziegel im Spiel, welcher 3 mal
 * berührt werden muss um zerstört zu werden.
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
	 * Rückgabe des Namens der Spielfigur.
	 * 
	 * @return String "Triple Brick"
	 */
	@Override
	public String getName() {
		return "Triple Brick";
	}

	/**
	 * Rückgabe der Punkte des Ziegels und für einen Treffer.
	 * 
	 * @return brickPoints Punkte für den Ziegel
	 */
	@Override
	public int getPoints() {
		if (lives <= 0) {
			return (brickPoints + 10); // +10 Punkte für einen Treffer mit der
										// Zerstörung des Ziegels
		} else {
			return 10; // +10 Punkte für einen Treffer
		}
	}

	/**
	 * Visitor Implementierung, welche das Spielobjekt nach dem letzten Leben
	 * löscht.
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
