package arkanoid.model;

/**
 * Die Klasse Bat repräsentiert den Schläger im Spiel, welcher automatisch
 * zwischen dem rechten und linken Spielfeldrand pendelt.
 */
public class Bat extends GameObject implements Moveable {
	private int speedX;
	private int ballHits;

	/**
	 * Bat-Konstruktor
	 * 
	 * @param x
	 *            x-Position des Schlägers
	 * @param y
	 *            y-Position des Schlägers
	 * @param speedX
	 *            Horizontale Bewegungsrichtung des Schlägers
	 * 
	 */
	public Bat(int x, int y, int speedX) {
		super(x, y);
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
	 * Setzt die Anzahl der Ballberühungen des Schlägers auf den aktuellen Wert.
	 * 
	 * @param hits
	 *            Aktuelle Ballberührungen.
	 */
	public void setBallHits(int hits) {
		ballHits = hits;

	} // end setBallHits

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung
	 * zurück.
	 * 
	 * @return 0 Eine vertikale Richtungsänderung ist nicht vorgesehen.
	 */
	public int getSpeedY() {
		return 0; // Rückgabewert ist 0 da keine vertikale Bewegungsrichtung des
					// Schlägers vorgesehen ist
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
	 * Die Methode setzt die aktuelle Geschwindigkeit in horizontaler Richtung.
	 * 
	 * @param speedX
	 *            Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in vertikaler Richtung.
	 * 
	 * @deprecated Wird nicht verwendet da keine vertikale Richtungsänderung
	 *             vorgesehen ist
	 */
	public void setSpeedY(int speedY) {

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
	 * Visitor Implementierung, welche eine Richtungsänderung des Balles und die
	 * Anzahl der Ballberürhrungen erhöht.
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
