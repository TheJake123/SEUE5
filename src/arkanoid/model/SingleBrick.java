package arkanoid.model;

/**
 * Die Klasse SingleBrick repräsentiert einen einfachen Ziegel im Spiel.
 */
public class SingleBrick extends Brick {

	/**
	 * SingleBrick-Konstruktor
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
	public SingleBrick(int x, int y, Player player, Level level) {
		super(x, y, player, level);
	}
	/**
	 * Visitor Implementierung, welche das Spielobjekt löscht.
	 * 
	 * @param other Spielobjekt das den Ziegel besucht.
	 */
	@Override
	public void visit(GameObject other) {
		super.visit(other);
		if (other instanceof Ball) {
			getLevel().removeObject(this);
		}
	}
	/**
	 * Rückgabe der Punkte des Ziegels.
	 * 
	 * @return brickPoints Punkte für den Ziegel
	 */
	@Override
	public int getPoints() {
		return (brickPoints + 10); // +10 Punkte für einen Treffer
	}
	/**
	 * Rückgabe des Namens der Spielfigur.
	 * 
	 * @return String "Single Brick"
	 */
	public String getName() {
		return "Single Brick";
	}
}
