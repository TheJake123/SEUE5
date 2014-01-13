package arkanoid.model;

/**
 * Die Klasse Bat repr�sentiert den Schl�ger im Spiel, welcher automatisch
 * zwischen dem rechten und linken Spielfeldrand pendelt.
 */
public class Bat extends GameObject implements Moveable {
	private int ballHits;
	private int speedX;

	/**
	 * Bat-Konstruktor
	 * 
	 * @param x
	 *            x-Position des Schl�gers
	 * @param y
	 *            y-Position des Schl�gers
	 * @param speedX
	 *            Horizontale Bewegungsrichtung des Schl�gers
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
	 * Gibt die Anzahl der Ballber�hungen des Schl�gers zur�ck.
	 * 
	 * @return ballHits Anzahl der Ballber�hrungen
	 */
	public int getBallHits() {
		return ballHits;

	} // end getBallHits

	/**
	 * R�ckgabe des Namens der Spielfigur.
	 * 
	 * @return String "Schl�ger"
	 */
	@Override
	public String getName() {
		return "Schl�ger";
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in horizontaler Richtung
	 * zur�ck.
	 * 
	 * @return speedX Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	@Override
	public int getSpeedX() {
		return speedX;
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung
	 * zur�ck.
	 * 
	 * @return 0 Eine vertikale Richtungs�nderung ist nicht vorgesehen.
	 */
	@Override
	public int getSpeedY() {
		return 0; // R�ckgabewert ist 0 da keine vertikale Bewegungsrichtung des
					// Schl�gers vorgesehen ist
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
	 * Setzt die Anzahl der Ballber�hungen des Schl�gers auf den aktuellen Wert.
	 * 
	 * @param hits
	 *            Aktuelle Ballber�hrungen.
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
	 * @deprecated Wird nicht verwendet da keine vertikale Richtungs�nderung
	 *             vorgesehen ist
	 */
	@Deprecated
	@Override
	public void setSpeedY(int speedY) {

	}

	/**
	 * Visitor Implementierung, welche eine Richtungs�nderung des Balles und die
	 * Anzahl der Ballber�rhrungen erh�ht.
	 * 
	 * @param other
	 *            Spielobjekt mit dem der Schl�ger kollidiert
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
