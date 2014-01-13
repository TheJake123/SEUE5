package arkanoid.model;

/**
 * Die Klasse SpecialBrick repr�sentiert einen Spezialziegel im Spiel.
 */
public class SpecialBrick extends Brick {

	private PowerUp powerUp;

	/**
	 * Spezialziegel Konstrukter, welcher Automatisch die Art des PowerUps ausw�hlt.
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
	public SpecialBrick(int x, int y, Player player, Level level) {
		super(x, y, player, level);
		double random = Math.random();
		if(random < 0.3)
		{
			powerUp = new BatSpeedPowerUp(getPosX(), getPosY(), level, player);
		}
		else if(random < 0.6)
		{
			powerUp = new BatSpeedPowerUp(getPosX(), getPosY(), level, player);
		}		else if(random < 0.8)
		{
			powerUp = new BatSpeedPowerUp(getPosX(), getPosY(), level, player);
		}
		else
		{
			powerUp = new BatSpeedPowerUp(getPosX(), getPosY(), level, player);
		}	
			
	}
	/**
	 * R�ckgabe des PowerUps.
	 * 
	 * @return powerUp Das zu spawnende PowerUp.
	 */
	public PowerUp getPowerUp() {
		return powerUp;
	}
	/**
	 * Visitor Implementierung, welche das Spielobjekt l�scht und ein PowerUp dem Level hinzf�gt.
	 * 
	 * @param other Spielobjekt das den Ziegel besucht.
	 */
	@Override
	public void visit(GameObject other) {
		super.visit(other);
		if (other instanceof Ball) {
			getLevel().addObject(powerUp);
			getLevel().removeObject(this);
		}
	}
	/**
	 * R�ckgabe der Punkte des Ziegels.
	 * 
	 * @return brickPoints Punkte f�r den Ziegel +10 f�r einen Treffer
	 */
	@Override
	public int getPoints() {
		return (brickPoints+10); //+10 Punkte f�r einen Treffer
	}
	/**
	 * R�ckgabe des Namens der Spielfigur.
	 * 
	 * @return String "Special Brick"
	 */
	public String getName() {
		return "Special Brick";
	}

}

