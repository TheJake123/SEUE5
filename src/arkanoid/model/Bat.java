package arkanoid.model;

/**
 * Die Klasse Bat repräsentiert den Schläger im Spiel, welcher automatisch
 * zwischen dem rechten und linken Spielfeldrand pendelt.
 */
public class Bat extends GameObject implements Moveable {
	private int ballHits;
	private int speedX;

	/**
	 * Bat-Konstruktor
	 * 
	 * @param x
	 *            x-Position des Schlägers
	 * @param y
	 *            y-Position des Schlägers
	 * @param speedX
	 *            Horizontale Bewegungsrichtung des Schlägers
	 * @param level
	 *            Aktuelle Level des Spiels
	 * 
	 */
	public Bat(int x, int y, int speedX, Level level) {
		super(x, y, level);
		this.speedX = speedX;
		ballHits = 0;

	} // end Bat

	/**
	 * Gibt die Anzahl der Ballberühungen des Schlägers zurück.
	 * 
	 * @return ballHits Anzahl der Ballberührungen
	 */
	public int getBallHits() {
		return ballHits;

	} // end getBallHits

	/**
	 * Rückgabe des Namens der Spielfigur.
	 * 
	 * @return String "Schläger"
	 */
	@Override
	public String getName() {
		return "Schläger";
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in horizontaler Richtung
	 * zurück.
	 * 
	 * @return speedX Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	@Override
	public int getSpeedX() {
		return speedX;
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung
	 * zurück.
	 * 
	 * @return 0 Eine vertikale Richtungsänderung ist nicht vorgesehen.
	 */
	@Override
	public int getSpeedY() {
		return 0; // Rückgabewert ist 0 da keine vertikale Bewegungsrichtung des
					// Schlägers vorgesehen ist
	}

	/**
	 * Die Methode führt die Richtungsänderung des Schlägers in horizontaler
	 * Ebene durch.
	 */
	@Override
	public void move() {
		setPosX(getPosX() + speedX);

		System.out.println("Schläger von (" + (getPosX() - speedX) + ","
				+ getPosY() + ") nach (" + getPosX() + "," + getPosY() + ")");

	} // end move

	/**
	 * Setzt die Anzahl der Ballberühungen des Schlägers auf den aktuellen Wert.
	 * 
	 * @param hits
	 *            Aktuelle Ballberührungen.
	 */
	public void setBallHits(int hits) {
		ballHits = hits;

	} // end setBallHits

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in horizontaler Richtung.
	 * 
	 * @param speedX
	 *            Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	@Override
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in vertikaler Richtung.
	 * 
	 * @deprecated Wird nicht verwendet da keine vertikale Richtungsänderung
	 *             vorgesehen ist
	 */
	@Deprecated
	@Override
	public void setSpeedY(int speedY) {

	}

	/**
	 * Visitor Implementierung, welche eine Richtungsänderung des Balles und die
	 * Anzahl der Ballberürhrungen erhöht.
	 * 
	 * @param other
	 *            Spielobjekt mit dem der Schläger kollidiert
	 */
	@Override
	public void visit(GameObject other) {
		if (other instanceof Wall) {
			setSpeedX(getSpeedX() * -1);
		} else if (other instanceof Ball) {
			Ball ball = (Ball) other;
			ball.setSpeedX(Random.nextInt(3) - 1);
			ball.setSpeedY(-1 * ball.getSpeedY());
			setBallHits(getBallHits() + 1);
			System.out.println("Ball trifft Schläger.");
		}
	}

} // end class Batt
