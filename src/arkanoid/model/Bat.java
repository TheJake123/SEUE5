package arkanoid.model;


/**
 * Die Klasse Bat repräsentiert den Schläger im Spiel, welcher automatisch zwischen dem rechten und linken
 * Spielfeldrand pendelt.
 */
public class Bat extends GameObject implements Moveable, BallVisitor {
	private int speedX;
	private int ballHits;
	private int maxX; //Punkt rechts aussen im Spielfeld

	/**
	 * Bat-Konstruktor
	 * 
	 * @param x x-Position des Schlägers
	 * @param y y-Position des Schlägers
	 * @param fieldwidth Breite des Feldes
	 * @param speedX Horizontale Bewegungsrichtung des Schlägers
	 * 
	 */
	public Bat(int x, int y, int fieldWidth, int speedX) {
		super(x, y);
		this.maxX = fieldWidth - 1;
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
	 * @param hits Aktuelle Ballberührungen.
	 */
	public void setBallHits(int hits) {
		ballHits = hits;

	} // end setBallHits
	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung zurück.
	 * 
	 * @return 0 Eine vertikale Richtungsänderung ist nicht vorgesehen.
	 */
	public int getSpeedY() {
		return 0; //Rückgabewert ist 0 da keine vertikale Bewegungsrichtung des Schlägers vorgesehen ist
	}
	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in horizontaler Richtung zurück.
	 * 
	 * @return speedX Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	public int getSpeedX() {
		return speedX;
	}
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
	 * @deprecated Wird nicht verwendet da keine vertikale Richtungsänderung vorgesehen ist
	 */
	public void setSpeedY(int speedY) {
		
	}
	/**
	 * Die Methode führt die Richtungsänderung des Schlägers in horizontaler Ebene durch.
	 */
	@Override
	public void move() {
		if (posX + speedX > maxX || posX + speedX < 0)
			speedX *= -1;
		posX = posX + speedX;

		System.out.println("Schläger von (" + (posX - speedX) + "," + posY
				+ ") nach (" + posX + "," + posY + ")");

	} // end move
	/**
	 * Visitor Implementierung, welche eine Richtungsänderung des Balles und die erhöhung der Ballberürhrungen
	 * erhöht.
	 */
	public void visit(Ball b) {
		if(b.getPosX() == this.posX && b.getPosY() == this.posY)
		{
			b.setSpeedX((int)(Math.round(Math.random()*2)-1));
			b.setSpeedY(b.getSpeedY()*-1); 
			this.setBallHits((ballHits+1));
			System.out.println("Ball trifft Schläger.");
		}
	}

} // end class Batt
