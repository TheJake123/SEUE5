package arkanoid.model;
/**
 * Die Klasse MultiBrick repr�sentiert einen Ziegel im Spiel, welcher 3 mal ber�hrt werden muss um zerst�rt
 * zu werden.
 */
public class TripleBrick extends Brick {
	
	private int lives = 3;

	public TripleBrick(int x, int y, Player player, Level level) {
		super(x, y, player, level);
	}
	@Override
	public void visit(GameObject other) {
		super.visit(other);
		if (other instanceof Ball) {
			lives--;
			if (lives <= 0)
				getLevel().removeObject(this);
		}
	}
	@Override
	public int getPoints() {
		if(lives <= 0)
		{
			return (brickPoints+10); //+10 Punkte f�r einen Treffer mit der Zerst�rung des Ziegels
		}
		else
		{
			return 10; //+10 Punkte f�r einen Treffer
		}
	}
	public String getName() {
		return "Triple Brick";
	}
}
