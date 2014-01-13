package arkanoid.model;

/**
 * Das Interface f�r Objekte, die im Spiel bewegt werden k�nnen.
 */
public interface Moveable {
	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung
	 * zur�ck.
	 */
	public int getSpeedX();

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung
	 * zur�ck.
	 */
	public int getSpeedY();

	/**
	 * Die Methode f�hrt die Richtungs�nderung vor.
	 */
	public void move();

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in horizontaler Richtung.
	 * 
	 * @param speedX
	 *            Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	public void setSpeedX(int speedX);

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in vertikaler Richtung.
	 * 
	 * @param speedY
	 *            Aktuelle Geschwindigkeit in vertikaler Richtung.
	 */
	public void setSpeedY(int speedY);
} // end interface Moveable
