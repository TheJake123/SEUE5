package arkanoid.model;


/**
 * Die Klasse Bat repr�sentiert den Schl�ger im Spiel, welcher automatisch zwischen dem rechten und linken
 * Spielfeldrand pendelt.
 */
public class Bat extends GameObject implements Moveable, BallVisitor {
	private int speedX;
	private int ballHits;
	private int maxX; //Punkt rechts aussen im Spielfeld

	/**
	 * Bat-Konstruktor
	 * 
	 * @param x x-Position des Schl�gers
	 * @param y y-Position des Schl�gers
	 * @param fieldwidth Breite des Feldes
	 * @param speedX Horizontale Bewegungsrichtung des Schl�gers
	 * 
	 */
	public Bat(int x, int y, int fieldWidth, int speedX) {
		super(x, y);
		this.maxX = fieldWidth - 1;
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
	 * @param hits Aktuelle Ballber�hrungen.
	 */
	public void setBallHits(int hits) {
		ballHits = hits;

	} // end setBallHits
	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung zur�ck.
	 * 
	 * @return 0 Eine vertikale Richtungs�nderung ist nicht vorgesehen.
	 */
	public int getSpeedY() {
		return 0; //R�ckgabewert ist 0 da keine vertikale Bewegungsrichtung des Schl�gers vorgesehen ist
	}
	/**
	 * Die Methode gibt die aktuelle Geschwindigkeit in horizontaler Richtung zur�ck.
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
	 * @deprecated Wird nicht verwendet da keine vertikale Richtungs�nderung vorgesehen ist
	 */
	public void setSpeedY(int speedY) {
		
	}
	/**
	 * Die Methode f�hrt die Richtungs�nderung des Schl�gers in horizontaler Ebene durch.
	 */
	@Override
	public void move() {
		if (posX + speedX > maxX || posX + speedX < 0)
			speedX *= -1;
		posX = posX + speedX;

		System.out.println("Schl�ger von (" + (posX - speedX) + "," + posY
				+ ") nach (" + posX + "," + posY + ")");

	} // end move
	/**
	 * Visitor Implementierung, welche eine Richtungs�nderung des Balles und die erh�hung der Ballber�rhrungen
	 * erh�ht.
	 */
	public void visit(Ball b) {
		if(b.getPosX() == this.posX && b.getPosY() == this.posY)
		{
			b.setSpeedX((int)(Math.round(Math.random()*2)-1));
			b.setSpeedY(b.getSpeedY()*-1); 
			this.setBallHits((ballHits+1));
			System.out.println("Ball trifft Schl�ger.");
		}
	}

} // end class Batt
