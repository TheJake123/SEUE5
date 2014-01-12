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
	 *            x-Position des Schlägers
	 * @param y
	 *            y-Position des Schlägers
	 * @param fieldWidth
	 *            Breite des Feldes
	 * @param fieldHeight
	 *            Höhe des Feldes
	 * @param speedY
	 *            Vertikale Bewegungsrichtung des Schlägers
	 * @param speedX
	 *            Horizontale Bewegungsrichtung des Schlägers
	 * 
	 */
	public Ball(int x, int y, int speedX, int speedY, Level level) {
		super(x, y, level);
		setSpeedX(speedX);
		setSpeedY(speedY);
	} // end Ball

	/**
	 * Die Methode führt die Richtungsänderung des Schlägers in horizontaler und
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
	 * @return speedX Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in vertikaler Richtung.
	 * 
	 * @return speedY Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung
	 * zurück.
	 * 
	 * @return speedY Aktuelle Geschwindigkeit in horizontaler Richtung.
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

	@Override
	public void visit(GameObject other) {
		if (other instanceof Brick) {
			setPosX(getPosX() - getSpeedX());
			setPosY(getPosY() - getSpeedY());
			setSpeedX(getSpeedX() * -1);
			setSpeedY(getSpeedY() * -1);
		}
	}
	public String getName() {
		return "Ball";
	}

} // end class Ball
