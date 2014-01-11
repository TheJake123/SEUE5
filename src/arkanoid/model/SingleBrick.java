package arkanoid.model;
/**
 * Die Klasse SingleBrick repr�sentiert einen einfachen Ziegel im Spiel.
 */
public class SingleBrick extends Brick {

	public SingleBrick(int x, int y) {
		super(x, y);
	}
	
	@Override
	public int getPoints() {
		return (brickPoints+10); //+10 Punkte f�r einen Treffer
	}

}
