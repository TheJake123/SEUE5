package arkanoid.model;
/**
 * Die Klasse MultiBrick repräsentiert einen Ziegel im Spiel, welcher 3 mal berührt werden muss um zerstört
 * zu werden.
 */
public class MultiBrick extends Brick {
	
	private int lives = 3;

	public MultiBrick(int x, int y) {
		super(x, y);
	}

	@Override
	public int getPoints() {
		lives--;
		if(lives == 0)
		{
			return (brickPoints+10); //+10 Punkte für einen Treffer mit der Zerstörung des Ziegels
		}
		else
		{
			return 10; //+10 Punkte für einen Treffer
		}
	}

}
