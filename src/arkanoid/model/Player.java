package arkanoid.model;
/**
 * Die Klasse repräsentiert den Spieler des Spieles.
 */
public class Player
{
	private final String name;
	private int levelNo;
	private int score;
	private int highScore;
	private int lives;
	
	private static final int PLAYERLIVES = 3;
	
	/**
	 * Spieler-Konstruktor welcher den Namen und die verfügbaren Leben des Spielers setzt.
	 * 
	 * @param name Name des Spielers.
	 */
	public Player(String name)
	{
		this.name = name;
		lives = PLAYERLIVES;
		score = 0;
		highScore = 0;
		
	} //end Player
	/**
	 * Methode die den Namen des Spielers zurückgibt.
	 * 
	 * @return name Name des Spielers.
	 */
	public String getName()
	{
		return name;
		
	} //end getName	
	
	/**
	 * Methode die den aktuellen Spielstand setzt.
	 * 
	 * @param newScore Aktuelle Wert des Spielstandes.
	 */
	public void setScore(int newScore)
	{
		score = newScore;
		
	} //end setCurrentScore
	/**
	 * Methode die den aktuellen Spielstand zurückgibt.
	 * 
	 * @return score Aktuelle Wert des Spielstandes.
	 */
	public int getScore()
	{
		return score;
		
	} //end getCurrentScore
	/**
	 * Methode die den höchsten Spielstand dieses Spielers setzt.
	 * 
	 * @param newHighScore Höchster erreichter Wert des Spielers.
	 */
	public void setHighScore(int newHighScore)
	{
		highScore = newHighScore;
		
	} //end setHighScore
	/**
	 * Methode die den höchsten Spielstand dieses Spielers zurückgibt.
	 * 
	 * @param highScore Höchster erreichter Wert des Spielers.
	 */
	public int getHighScore()
	{
		return highScore;
		
	} //end getHighScore
	/**
	 * Methode die die verfügbaren Spielleben des Spielers setzt.
	 * 
	 * @return lives Aktuell verbleibende Leben des Spielers.
	 */
	public void setLives(int newLives)
	{
		lives = newLives;
		
	} //end setLives
	/**
	 * Methode die die verfügbaren Spielleben des Spielers zurückgibt.
	 * 
	 * @return lives Verbleibende Leben des Spielers.
	 */
	public int getLives()
	{
		return lives;
		
	} //end getLives
	/**
	 * Setzen der Nummer des aktuellen Levels des Spielers.
	 * 
	 * param currLevel Die Nummer des aktuelle Levels
	 */
	public void setCurrentLevel(int currLevel)
	{
		levelNo = currLevel;
		
	} //end setLives
	/**
	 * Rückgabe der Nummer des aktuellen Levels des Spielers.
	 * 
	 * @return levelNo Aktuelle Level.
	 */
	public int getCurrentLevel()
	{
		return levelNo;
		
	} //end getLives
	
} //end class Player
