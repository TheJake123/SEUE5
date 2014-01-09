package arkanoid.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Game implements Runnable
{
	private ArrayList<Level> levels;
	Iterator<Level> levelIterator;
	Level currentLevel;
	
	public Game(Player player, ArrayList<Level> levels)
	{
		this.levels = levels;		
		levelIterator = levels.iterator();
		currentLevel = levelIterator.next();
	} //end Gameboard
	
	
	
	@Override
	public void run()
	{
		while(!Thread.interrupted())
		{
			try
			{
				bat.move();
				Thread.sleep(1000);

			} catch(InterruptedException e)
			{
				Thread.currentThread().interrupt();
				
			} //end try/catch
			
		} //end while
		
	} //end run
	
} //end class Gameboard
