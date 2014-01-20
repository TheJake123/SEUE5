package arkanoid.model;

/**
 * Abstrakte Superklasse für alle Spielobjekte im Spiel.
 */
public abstract class GameObject implements Visitor, Visitable {
	private int posX;
	private int posY;
	private Level level;
	protected java.util.Random Random = new java.util.Random();
	
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
	 * Rückgabe des Namens der Spielfigur.
	 * 
	 * @return String 
	 */
	public abstract String getName();
	/**
	 * Die Methode gibt die aktuelle Position in horizontaler Richtung
	 * zurück.
	 * 
	 * @return posX Aktuelle Position in horizontaler Richtung.
	 */
	public int getPosX() {
		return posX;

	} // end getPosX
	
	/**
	 * Die Methode setzt die aktuelle Position in horizontaler Richtung.
	 * 
	 * @param posX Aktuelle Position in horizontaler Richtung.
	 */
	public void setPosX(int x) {
		posX = x;

	} // end setPosX
	/**
	 * Die Methode gibt die aktuelle Position in vertikaler Richtung
	 * zurück.
	 * 
	 * @return posY Aktuelle Position in vertikaler Richtung.
	 */
	public int getPosY() {
		return posY;

	} // end getPosY
	
	/**
	 * Die Methode setzt die aktuelle Position in vertikaler Richtung.
	 * 
	 * @param posY Aktuelle Position in vertikaler Richtung.
	 */
	public void setPosY(int y) {
		posY = y;

	} // end setPosY

	/**
	 * Visitor Implementierung, welches den Besuch ein Visitor Objektes akzeptiert.
	 * 
	 * @param v Visitor Objekt
	 */
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	/**
	 * Die Methode setzt das aktuelle Level des Spiels.
	 * 
	 * @param level Aktuelle Level.
	 */
	public void setLevel(Level level) {
		this.level = level;
	}
	/**
	 * Die Methode gibt das aktuelle Level des Spiels, mit dem das Spielobjekt verbunden ist, zurück.
	 * 
	 * @return level Aktuelle Level.
	 */
	public Level getLevel() {
		return level;
	}
} // end class GameObject
