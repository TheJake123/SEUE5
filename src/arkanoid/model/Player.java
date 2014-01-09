package arkanoid.model;

public class Player
{
	private final String name;
	private int currentLevel;
	private int currentScore;
	private int highScore;
	private int lives;
	
	public Player(String name)
	{
		this.name = name;
		lives = 3;
		currentScore = 0;
		highScore = 0;
		
	} //end Player
	
	public String getName()
	{
		return name;
		
	} //end getName	
	
	public void setCurrentScore(int newCurrentScore)
	{
		currentScore = newCurrentScore;
		
	} //end setCurrentScore
	
	public int getCurrentScore()
	{
		return currentScore;
		
	} //end getCurrentScore
	
	public void setHighScore(int newHighScore)
	{
		highScore = newHighScore;
		
	} //end setHighScore
	
	public int getHighScore()
	{
		return highScore;
		
	} //end getHighScore
	
	public void setLives(int newLives)
	{
		lives = newLives;
		
	} //end setLives
	
	public int getLives()
	{
		return lives;
		
	} //end getLives
	
	public void setCurrentLevel(int currLevel)
	{
		currentLevel = currLevel;
		
	} //end setLives
	
	public int getCurrentLevel()
	{
		return currentLevel;
		
	} //end getLives
	
} //end class Player
