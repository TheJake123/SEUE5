package arkanoid.model;

/**
 * Fabriks-Klasse welche für die Erstellung von Ziegelelementen konzipiert ist.
 */
public class BrickFactory {

	private Player player;

	public BrickFactory(Player player) {
		this.player = player;
	}

	/**
	 * Rückgabemethode für einen Ziegel.
	 * 
	 * @param brickType
	 *            Name des zu erstellenden Ziegels.
	 * @param x
	 *            X-Position des Ziegels.
	 * @param y
	 *            Y-Position des Ziegels.
	 * 
	 * @return ZiegelObjekt
	 */
	public Brick getBrick(String brickType, int x, int y) {
		if (brickType == null) {
			return null;
		}
		if (brickType.equalsIgnoreCase("SINGLEBRICK")) {
			return new SingleBrick(x, y, player, null);
		} else if (brickType.equalsIgnoreCase("MULTIBRICK")) {
			return new TripleBrick(x, y, player, null);
		} else if (brickType.equalsIgnoreCase("SPECIALBRICK")) {
			return new SpecialBrick(x, y, player, null);
		}
		return null;
	}
}
