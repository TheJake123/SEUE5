package arkanoid.model;
/**
 * Die Klasse MultiBrick repräsentiert einen Ziegel im Spiel, welcher 3 mal berührt werden muss um zerstört
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
			return (brickPoints+10); //+10 Punkte für einen Treffer mit der Zerstörung des Ziegels
		}
		else
		{
			return 10; //+10 Punkte für einen Treffer
		}
	}
	public String getName() {
		return "Triple Brick";
	}
}
