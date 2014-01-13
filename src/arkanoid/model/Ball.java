package arkanoid.model;

/**
 * Die Klasse Ball repräsentiert den Ball im Spiel, welcher automatisch zwischen
 * dem rechten und linken Spielfeldrand pendelt.
 */
public class Ball extends GameObject implements Moveable {
	private int speedX;
	private int speedY;

	/**
	 * Ball-Konstruktor
	 * 
	 * @param x
	 *            x-Position des Balles
	 * @param y
	 *            y-Position des Balles
	 * @param speedY
	 *            Vertikale Bewegungsrichtung des Balles
	 * @param speedX
	 *            Horizontale Bewegungsrichtung des Balles
	 * @param level
	 *            Aktuelle Level des Spiels
	 * 
	 */
	public Ball(int x, int y, int speedX, int speedY, Level level) {
		super(x, y, level);
		setSpeedX(speedX);
		setSpeedY(speedY);
	} // end Ball

	/**
	 * Die Methode führt die Richtungsänderung des Balles in horizontaler und
	 * vertikaler Ebene durch.
	 */
	@Override
	public void move() {
		setPosX(getPosX() + getSpeedX());
		setPosY(getPosY() + getSpeedY());
		System.out.println("Ball von (" + (getPosX() - getSpeedX()) + ","
				+ (getPosY() - getSpeedY()) + ") nach (" + getPosX() + ","
				+ getPosY() + ")");
	} // end move

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in horizontaler Richtung.
	 * 
	 * @param speedX Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in vertikaler Richtung.
	 * 
	 * @param speedY Aktuelle Geschwindigkeit in vertikaler Richtung.
	 */
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung
	 * zurück.
	 * 
	 * @return speedY Aktuelle Geschwindigkeit in vertikaler Richtung.
	 */
	public int getSpeedY() {
		return speedY;
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in horizontaler Richtung
	 * zurück.
	 * 
	 * @return speedX Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	public int getSpeedX() {
		return speedX;
	}

	/**
	 * Visitor Implementierung, welche eine Richtungsänderung des Balles bewirkt und die
	 * aktuelle Position neu setzt.
	 * 
	 * @param other Spielobjekt mit dem der Ball kollidiert
	 */
	@Override
	public void visit(GameObject other) {
		if (other instanceof Brick) {
			setPosX(getPosX() - getSpeedX());
			setPosY(getPosY() - getSpeedY());
			setSpeedX(getSpeedX() * -1);
			setSpeedY(getSpeedY() * -1);
		}
	}
	
	/**
	 * Rückgabe des Namens der Spielfigur.
	 * 
	 * @return String "Ball"
	 */
	public String getName() {
		return "Ball";
	}

} // end class Ball
