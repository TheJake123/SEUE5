package arkanoid.model;

public abstract class Brick extends GameObject {
	private Player player;
	protected int brickPoints = 20;

	public Brick(int x, int y, Player player, Level level) {
		super(x, y, level);
		this.player = player;
	} // end Brick

	@Override
	public void visit(GameObject other) {
		if (other instanceof Ball) {
			player.setScore(player.getScore() + getPoints());
			System.out.println("Score wird um " + getPoints() + " auf "
					+ player.getScore() + " erhöht");
		}
	}

	/**
	 * Rückgabe der Punkte des Ziegels.
	 * 
	 * @return brickPoints Punkte für den Ziegel
	 */
	public int getPoints() {
		return brickPoints;
	}
} // end class Brick
