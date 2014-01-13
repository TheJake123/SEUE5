package arkanoid.model;

/**
 * Die Klasse PowerUp ist die abstrakte Superklasse f�r ein spezielles PowerUp.
 */
public abstract class PowerUp extends GameObject implements Moveable {
	private Player player;
	private int speedY;

	/**
	 * SingleBrick-Konstruktor
	 * 
	 * @param x
	 *            x-Position des PowerUp's
	 * @param y
	 *            y-Position des PowerUp's
	 * @param speedY
	 *            Y-Geschwindigkeit des PowerUp's
	 * @param level
	 *            Aktuelle Level des Spieles
	 * @param player
	 *            Aktuelle Spieler des Spieles
	 * 
	 */
	public PowerUp(int x, int y, int speedY, Level level, Player player) {
		super(x, y, level);
		this.speedY = speedY;
		this.player = player;
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in horizontaler Richtung
	 * zur�ck.
	 * 
	 * @return 0 Keine horizontale Richtungs�nderung vorgesehen.
	 * @deprecated
	 */
	@Deprecated
	@Override
	final public int getSpeedX() {
		return 0; // Keine horizontale Bewegung
	}

	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung
	 * zur�ck.
	 * 
	 * @return speedY Aktuelle Geschwindigkeit in vertikaler Richtung.
	 */
	@Override
	public int getSpeedY() {
		return speedY;
	}

	/**
	 * Die Methode f�hrt die Richtungs�nderung des PowerUp's in vertikaler Ebene
	 * durch.
	 */
	@Override
	public void move() {
		setPosY(getPosY() + getSpeedY());
	}

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in horizontaler Richtung.
	 * 
	 * @param speedX
	 *            Aktuelle Geschwindigkeit in horizontaler Richtung.
	 * @deprecated Keine horizontale Geschwindigkeits�nderung.
	 */
	@Deprecated
	@Override
	final public void setSpeedX(int speedX) {
	}

	/**
	 * Die Methode setzt die aktuelle Geschwindigkeit in vertikaler Richtung.
	 * 
	 * @param speedY
	 *            Aktuelle Geschwindigkeit in vertikaler Richtung.
	 */
	@Override
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	/**
	 * Visitor Implementierung, welche das Spielobjekt l�scht und bei Ber�hrung
	 * mit dem Schl�ger die Punktezahl erh�ht.
	 */
	@Override
	public void visit(GameObject other) {
		if (other instanceof Wall) {
			getLevel().removeObject(this);
		} else if (other instanceof Bat) {
			player.setScore(player.getScore() + 15);
			System.out.println("Score wird um 15 auf " + player.getScore()
					+ " erh�ht");
			// L�schung des Objektes?
		}
	}

}
