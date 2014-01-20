package arkanoid.model;

/**
 * Die Klasse Brick ist die abstrakte Superklasse f�r einen Ziegel.
 */
public abstract class Brick extends GameObject {
	protected int brickPoints = 20;
	private Player player;

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
	 * R�ckgabe der Punkte des Ziegels.
	 * 
	 * @return brickPoints Punkte f�r den Ziegel
	 */
	public int getPoints() {
		return brickPoints;
	}

	/**
	 * Visitor Implementierung, welches bei einer Ballber�hrung den Spielstand
	 * aktualisiert.
	 * 
	 * @param other
	 *            Spielobjekt das den Ziegel besucht.
	 */
	@Override
	public void visit(GameObject other) {
		if (other instanceof Ball) {
			player.setScore(player.getScore() + getPoints());
			System.out.println("Score wird um " + getPoints() + " auf "
					+ player.getScore() + " erh�ht");
		}
	}
} // end class Brick
