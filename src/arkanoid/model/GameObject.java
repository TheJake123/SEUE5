package arkanoid.model;

/**
 * Abstrakte Superklasse f�r alle Spielobjekte im Spiel.
 */
public abstract class GameObject implements Visitor, Visitable {
	protected java.util.Random Random = new java.util.Random();
	private Level level;
	private int posX;
	private int posY;

	/**
	 * Ball-Konstruktor
	 * 
	 * @param x
	 *            x-Position des Spielobjekts
	 * @param y
	 *            y-Position des Spielobjekts
	 * @param level
	 *            Aktuelle Level des Spiels
	 */
	public GameObject(int x, int y, Level level) {
		posX = x;
		posY = y;
		this.level = level;
	} // end GameObject

	/**
	 * Visitor Implementierung, welches den Besuch ein Visitor Objektes
	 * akzeptiert.
	 * 
	 * @param v
	 *            Visitor Objekt
	 */
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	/**
	 * R�ckgabe des Namens der Spielfigur.
	 * 
	 * @return String
	 */
	public abstract String getName();

	/**
	 * Die Methode gibt die aktuelle Position in horizontaler Richtung zur�ck.
	 * 
	 * @return posX Aktuelle Position in horizontaler Richtung.
	 */
	public int getPosX() {
		return posX;

	} // end getPosX

	/**
	 * Die Methode gibt die aktuelle Position in vertikaler Richtung zur�ck.
	 * 
	 * @return posY Aktuelle Position in vertikaler Richtung.
	 */
	public int getPosY() {
		return posY;

	} // end getPosY

	/**
	 * Die Methode setzt die aktuelle Position in horizontaler Richtung.
	 * 
	 * @param x
	 *            Aktuelle Position in horizontaler Richtung.
	 */
	public void setPosX(int x) {
		posX = x;

	} // end setPosX

	/**
	 * Die Methode setzt die aktuelle Position in vertikaler Richtung.
	 * 
	 * @param y
	 *            Aktuelle Position in vertikaler Richtung.
	 */
	public void setPosY(int y) {
		posY = y;

	} // end setPosY

	/**
	 * Die Methode gibt das aktuelle Level des Spiels, mit dem das Spielobjekt
	 * verbunden ist, zur�ck.
	 * 
	 * @return level Aktuelle Level.
	 */
	protected Level getLevel() {
		return level;
	}

	/**
	 * Die Methode setzt das aktuelle Level des Spiels.
	 * 
	 * @param level
	 *            Aktuelle Level.
	 */
	protected void setLevel(Level level) {
		this.level = level;
	}
} // end class GameObject
