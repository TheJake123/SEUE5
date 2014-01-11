package arkanoid.model;
/**
 * Die Klasse MultiBrick repr�sentiert einen Ziegel im Spiel, welcher 3 mal ber�hrt werden muss um zerst�rt
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
			return (brickPoints+10); //+10 Punkte f�r einen Treffer mit der Zerst�rung des Ziegels
		}
		else
		{
			return 10; //+10 Punkte f�r einen Treffer
		}
	}

}
