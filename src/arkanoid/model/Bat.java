package arkanoid.model;

/**
 * Die Klasse Bat repr�sentiert den Schl�ger im Spiel, welcher automatisch
 * zwischen dem rechten und linken Spielfeldrand pendelt.
 */
public class Bat extends GameObject implements Moveable {
	private int speedX;
	private int ballHits;

	/**
	 * Bat-Konstruktor
	 * 
	 * @param x
	 *            x-Position des Schl�gers
	 * @param y
	 *            y-Position des Schl�gers
	 * @param speedX
	 *            Horizontale Bewegungsrichtung des Schl�gers
	 * 
	 */
	public Bat(int x, int y, int speedX) {
		super(x, y);
		this.speedX = speedX;
		ballHits = 0;

	} // end Bat

	/**
	 * Gibt die Anzahl der Ballber�hungen des Schl�gers zur�ck.
	 * 
	 * @return ballHits Anzahl der Ballber�hrungen
	 */
	public int getBallHits() {
		return ballHits;

	} // end getBallHits

	/**
	 * Setzt die Anzahl der Ballber�hungen des Schl�gers auf den aktuellen Wert.
	 * 
	 * @param hits
	 *            Aktuelle Ballber�hrungen.
	 */
	public void setBallHits(int hits) {
		ballHits = hits;

	} // end setBallHits

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung
	 * zur�ck.
	 * 
	 * @return 0 Eine vertikale Richtungs�nderung ist nicht vorgesehen.
	 */
	public int getSpeedY() {
		return 0; // R�ckgabewert ist 0 da keine vertikale Bewegungsrichtung des
					// Schl�gers vorgesehen ist
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in horizontaler Richtung
	 * zur�ck.
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
	 * @deprecated Wird nicht verwendet da keine vertikale Richtungs�nderung
	 *             vorgesehen ist
	 */
	public void setSpeedY(int speedY) {

	}

	/**
	 * Die Methode f�hrt die Richtungs�nderung des Schl�gers in horizontaler
	 * Ebene durch.
	 */
	@Override
	public void move() {
		setPosX(getPosX() + speedX);

		System.out.println("Schl�ger von (" + (getPosX() - speedX) + ","
				+ getPosY() + ") nach (" + getPosX() + "," + getPosY() + ")");

	} // end move

	
	/**
	 * Visitor Implementierung, welche eine Richtungs�nderung des Balles und die
	 * Anzahl der Ballber�rhrungen erh�ht.
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
			System.out.println("Ball trifft Schl�ger.");
		}
	}

} // end class Batt
