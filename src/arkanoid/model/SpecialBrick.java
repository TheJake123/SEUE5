package arkanoid.model;

/**
 * Die Klasse SpecialBrick repräsentiert einen Spezialziegel im Spiel.
 */
public class SpecialBrick extends Brick {

	private PowerUp powerUp;

	/**
	 * Spezialziegel Konstrukter, welcher Automatisch die Art des PowerUps auswählt.
	 * 
	 * @param x x-Position des Ziegels
	 * @param y y-Position des Ziegels
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
		}
		else if(random < 0.8)
		{
			powerUp = new BatSpeedPowerUp(getPosX(), getPosY(), level, player);
		}
		else
		{
			powerUp = new BatSpeedPowerUp(getPosX(), getPosY(), level, player);
		}	
			
	}
	/**
	 * Rückgabe des PowerUps.
	 * 
	 * @return powerUp Das zu spawnende PowerUp.
	 */
	public PowerUp getPowerUp() {
		return powerUp;
	}
	@Override
	public void visit(GameObject other) {
		super.visit(other);
		if (other instanceof Ball) {
			getLevel().addObject(powerUp);
			getLevel().removeObject(this);
		}
	}
	@Override
	public int getPoints() {
		return (brickPoints+10); //+10 Punkte für einen Treffer
	}
	public String getName() {
		return "Special Brick";
	}

}

