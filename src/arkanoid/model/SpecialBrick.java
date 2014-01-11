package arkanoid.model;

/**
 * Die Klasse SpecialBrick repr�sentiert einen Spezialziegel im Spiel.
 */
public class SpecialBrick extends Brick {

	private String powerUp;

	/**
	 * Spezialziegel Konstrukter, welcher Automatisch die Art des PowerUps ausw�hlt.
	 * 
	 * @param x x-Position des Ziegels
	 * @param y y-Position des Ziegels
	 */
	public SpecialBrick(int x, int y) {
		super(x, y);
		double random = Math.random();
		if(random < 0.3)
		{
			setPowerUp("Apfel");
		}
		else if(random < 0.6)
		{
			setPowerUp("Erdbeere");
		}
		else if(random < 0.8)
		{
			setPowerUp("Banane");
		}
		else
		{
			setPowerUp("Kirsche");
		}	
			
	}
	/**
	 * R�ckgabe der Art des PowerUp's.
	 * 
	 * @return powerUp Name des PowerUp's.
	 */
	public String getPowerUp() {
		return powerUp;
	}
	/**
	 * Setzen der Art des PowerUp's.
	 * 
	 * @param powerUp Art des PowerUp's.
	 */
	public void setPowerUp(String powerUp) {
		this.powerUp = powerUp;
	}
	
	@Override
	public void printConsole(){
		super.printConsole();
		System.out.println(getPowerUp()+" PowerUp ist erstellt worden.");
	}
	@Override
	public int getPoints() {
		return (brickPoints+10); //+10 Punkte f�r einen Treffer
	}

}

