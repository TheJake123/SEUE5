package arkanoid.model;

public class Player
{
	private final String name;
	private int levelNo;
	private int score;
	private int highScore;
	private int lives;
	
	public Player(String name)
	{
		this.name = name;
		lives = 3;
		score = 0;
		highScore = 0;
		
	} //end Player
	
	public String getName()
	{
		return name;
		
	} //end getName	
	
	protected void setScore(int newScore)
	{
		score = newScore;
		
	} //end setCurrentScore
	
	public int getScore()
	{
		return score;
		
	} //end getCurrentScore
	
	protected void setHighScore(int newHighScore)
	{
		highScore = newHighScore;
		
	} //end setHighScore
	
	public int getHighScore()
	{
		return highScore;
		
	} //end getHighScore
	
	protected void setLives(int newLives)
	{
		lives = newLives;
		
	} //end setLives
	
	public int getLives()
	{
		return lives;
		
	} //end getLives
	
	protected void setCurrentLevel(int currLevel)
	{
		levelNo = currLevel;
		
	} //end setLives
	
	public int getCurrentLevel()
	{
		return levelNo;
		
	} //end getLives
	
} //end class Player
