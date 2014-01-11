package arkanoid.model;
/**
 * Die Klasse Brick repr�sentiert einen Ziegel im Spiel.
 */
public abstract class Brick extends GameObject implements BallVisitor 
{	
	protected int brickPoints = 20;
	
	/**
	 * Ziegel Konstruktor
	 * 
	 * @param x x-Position des Ziegels
	 * @param y y-Position des Ziegels
	 */
	public Brick(int x, int y)
	{
		super(x, y);
	} //end Brick
	

	/**
	 * Visitor Implementierung, welche eine vertikale Richtungs�nderung bewirkt und die Ereignisse auf die Konsole 
	 * schreibt.
	 * 
	 * @param b Ball der den Ziegel besucht.
	 */
	@Override
	public void visit(Ball b) {
		if(b.getPosX() == this.posX && b.getPosY() == this.posY)
		{
			//Punktestand? 10 Punkte dazu?
			//X-Geschwindigkeit wird nicht ver�ndert
			b.setSpeedY(b.getSpeedY()*-1); 
			printConsole();
		}
	}
	
	/**
	 * Die Methode schreibt die ausgel�sten Ereignisse auf den Bildschirm.
	 */
	public void printConsole(){
		System.out.println("Ball trifft Ziegel auf der Position x ("+ posX +") und y (" + posY +").");
		System.out.println("Der Spieler erh�lt " + this.getPoints() + " Punkte.");
	}
	
	/**
	 * R�ckgabe der Punkte des Ziegels.
	 * 
	 * @return brickPoints Punkte f�r den Ziegel
	 */
	public int getPoints() {
		return brickPoints;
	}
	
} //end class Brick
