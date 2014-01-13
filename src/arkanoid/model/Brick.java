package arkanoid.model;
/**
 * Die Klasse Brick ist die abstrakte Superklasse für einen Ziegel.
 */
public abstract class Brick extends GameObject {
	private Player player;
	protected int brickPoints = 20;
	
	/**
	 * Brick-Konstruktor
	 * 
	 * @param x
	 *            x-Position des Ziegels
	 * @param y
	 *            y-Position des Ziegels
	 * @param player
	 *            Aktuelle Spieler des Spieles
	 * @param level
	 *            Aktuelle Level des Spieles
	 * 
	 */
	public Brick(int x, int y, Player player, Level level) {
		super(x, y, level);
		this.player = player;
	} // end Brick
	
	/**
	 * Visitor Implementierung, welches bei einer Ballberührung den Spielstand aktualisiert.
	 * 
	 * @param other Spielobjekt das den Ziegel besucht.
	 */
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
