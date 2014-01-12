package arkanoid.model;

public class Brick extends GameObject {
	private Player player;
	public Brick(int x, int y, Player player) {
		super(x, y);
		this.player = player;
	} // end Brick

	@Override
	public void visit(GameObject other) {
		if (other instanceof Ball) {
			player.setScore(player.getScore() + 20);
			getLevel().remove(this);
		}
	}
} // end class Brick
