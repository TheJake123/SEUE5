package arkanoid.model;

/**
 * Die Klasse SingleBrick repräsentiert einen einfachen Ziegel im Spiel.
 */
public class SingleBrick extends Brick {

	public SingleBrick(int x, int y, Player player, Level level) {
		super(x, y, player, level);
	}
	@Override
	public void visit(GameObject other) {
		super.visit(other);
		if (other instanceof Ball) {
			getLevel().removeObject(this);
		}
	}
	@Override
	public int getPoints() {
		return (brickPoints + 10); // +10 Punkte für einen Treffer
	}
	public String getName() {
		return "Single Brick";
	}
}
