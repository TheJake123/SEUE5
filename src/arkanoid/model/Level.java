package arkanoid.model;

public class Level
{
	private int lvlNr;
	private int nrOfBricks;
	private int nrOfPUBricks;
	private int nrOfEnlargePU;
	private int nrOfShortenPU;
	private int nrOfSpeedPU;
	private int nrOfSlowPU;
	
	public Level(int nr, int bricks, int enlargePU, int shortenPU, int speedPU, int slowPU)
	{
		lvlNr = nr;
		nrOfBricks = bricks;
		nrOfEnlargePU = enlargePU;
		nrOfShortenPU = shortenPU;
		nrOfSpeedPU = speedPU;
		nrOfSlowPU = slowPU;
		nrOfPUBricks = enlargePU + shortenPU + speedPU + slowPU;
		
	} //end Level
	
	public int getLvlNr()
	{
		return lvlNr;
		
	} //end getLvlNr
	
	public int getNrOfBricks()
	{
		return nrOfBricks;
		
	} //end getNrOfBricks
	
	public int getNrOfPUBricks()
	{
		return nrOfPUBricks;
		
	} //end getNrOfPUBricks
	
	public int getNrOfEnlargePU()
	{
		return nrOfEnlargePU;
		
	} //end getNrOfEnlargePU
	
	public int getNrOfShortenPU()
	{
		return nrOfShortenPU;
		
	} //end getNrOfShortenPU
	
	public int getNrOfSpeedPU()
	{
		return nrOfSpeedPU;
		
	} //end getNrOfSpeedPU
	
	public int getNrOfSlowPU()
	{
		return nrOfSlowPU;
		
	} //end getNrOfSlowPU
	
} //end class Level
