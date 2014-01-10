package arkanoid.model;

/**
 * Die Klasse Ball repräsentiert den Ball im Spiel, welcher automatisch zwischen dem rechten und linken
 * Spielfeldrand pendelt.
 */
public class Ball extends GameObject implements Moveable, Visitable
{
	private int speedX;
	private int speedY;
	private int maxX;//Wert des rechtesten Punkt im Spielfeld
	private int maxY;//Wert des vertikal höchsten Punkt im Spielfeld


	/**
	 * Ball-Konstruktor
	 * 
	 * @param x x-Position des Schlägers
	 * @param y y-Position des Schlägers
	 * @param fieldWidth Breite des Feldes
	 * @param fieldHeight Höhe des Feldes
	 * @param speedY Vertikale Bewegungsrichtung des Schlägers
	 * @param speedX Horizontale Bewegungsrichtung des Schlägers
	 * 
	 */
	public Ball(int x, int y, int fieldWidth, int fieldHeight, int speedY, int speedX)
	{
		super(x, y);
		this.speedX = speedX;
		this.speedY = speedY;
		this.maxX = fieldWidth;
		this.maxY = fieldHeight;
	} //end Ball
	
	/**
	 * Die Methode führt die Richtungsänderung des Schlägers in horizontaler und vertikaler Ebene durch.
	 */
	@Override
	public void move() {
		if (posX + speedX > maxX || posX + speedX < 0)
		{
			speedX *= -1;
			System.out.println("Ball trifft auf Begrenzung.");
		}
		
		posX = posX + speedX;
		
		if (posY + speedY > maxY || posY + speedY < 0)
		{
			if(posY + speedY < 0)
			{
				System.out.println("Ball trifft auf unteren Spielfeldrand. -1 Leben.");
			}
			else
			{
				System.out.println("Ball trifft auf obere Begrenzung.");
			}
			speedY *= -1;
		}
		
		posY = posY + speedY;

		System.out.println("Ball von (" + (posX - speedX) + "," + (posY - speedY)
				+ ") nach (" + posX + "," + posY + ")");

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
	 * Die Methode gibt die aktuelle Geschwindigkeit in vertikaler Richtung zurück.
	 * 
	 * @return speedY Aktuelle Geschwindigkeit in horizontaler Richtung.
	 */
	public int getSpeedY() {
		return speedY;
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
	 * Akzeptanz des BallVisitor.
	 */
	public void accept(BallVisitor visitor)
	{
		visitor.visit(this);
	}


	
} //end class Ball
