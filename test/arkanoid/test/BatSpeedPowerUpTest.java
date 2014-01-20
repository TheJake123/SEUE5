package arkanoid.test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import arkanoid.model.Ball;
import arkanoid.model.Bat;
import arkanoid.model.BatSpeedPowerUp;
import arkanoid.model.GameObject;
import arkanoid.model.Level;
import arkanoid.model.Player;
import arkanoid.model.Visitor;
import arkanoid.model.Wall;

/**
 * class for testing the BatSpeedPowerUp
 */
public class BatSpeedPowerUpTest
{
	private BatSpeedPowerUp powerup;
	private Player player;
	
	/**
	 * things to do BEFORE the test
	 */
	@Before
	public void setUp()
	{
		player = new Player("Tester4");
		powerup = new BatSpeedPowerUp(41, 95, null, player);
	}
	
	/**
	 * things to do AFTER the test
	 */
	@After
	public void tearDown()
	{
		powerup = null;
	}
	
	/**
	 * testing the getSpeedY() method
	 */
	@Test
	public void getSpeedY()
	{
		assertEquals(1, powerup.getSpeedY());
	}
	
	/**
	 * testing the setSpeedY() method
	 */
	@Test
	public void setSpeedY()
	{
		powerup.setSpeedY(3);
		assertEquals(3, powerup.getSpeedY());
	}
	
	/**
	 * testing the move() method
	 */
	@Test
	public void move()
	{
		powerup.move();
		assertEquals(96, powerup.getPosY());
		powerup.setSpeedY(3);
		powerup.move();
		assertEquals(99, powerup.getPosY());
	}
	
	/**
	 * testing the getName() method
	 */
	@Test
	public void getName()
	{
		assertEquals("BatSpeedPowerUp", powerup.getName());
	}
	
	/**
	 * testing the getPosX() method
	 */
	@Test
	public void getPosX()
	{
		assertEquals(41, powerup.getPosX());
	}
	
	/**
	 * testing the getPosY() method
	 */
	@Test
	public void getPosY()
	{
		assertEquals(95, powerup.getPosY());
	}
	
	/**
	 * testing the setPosX() method
	 */
	@Test
	public void setPosX()
	{
		powerup.setPosX(7);
		assertEquals(7, powerup.getPosX());
	}
	
	/**
	 * testing the setPosY() method
	 */
	@Test
	public void setPosY()
	{
		powerup.setPosY(8);
		assertEquals(8, powerup.getPosY());
	}
	
	/**
	 * testing the getLevel() method
	 */
	@Test
	public void getLevel()
	{
		assertNull(powerup.getLevel());
	}
	
	/**
	 * testing the setLevel() method
	 */
	@Test
	public void setLevel()
	{
		GameObject[][] gameboard = new GameObject[5][5];
		Level level = new Level(4, gameboard, null);
		
		powerup.setLevel(level);
		assertSame(level, powerup.getLevel());
	}
	
	/**
	 * testing the accept() method
	 */
	@Test
	public void accept()
	{
		GameObject[][] gameboard = new GameObject[100][100];
		Level level = new Level(4, gameboard, null);
		Visitor bat = new Bat(42,2,1, null);
		Visitor wall = new Wall(42,1, level, null);
		Visitor ball = new Ball(131, 455, 1, 1, null);
		boolean failed = false;
		
		try
		{
			powerup.accept(bat);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
			failed = true;
		}
		assertFalse(failed);
		
		try
		{
			powerup.accept(wall);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
			failed = true;
		}
		assertFalse(failed);
		
		try
		{
			powerup.accept(ball);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
			failed = true;
		}
		assertFalse(failed);
	}

	/**
	 * testing the visit() method
	 */
	@Test
	public void visit()
	{
		GameObject[][] gameboard = new GameObject[100][100];
		Level level = new Level(4, gameboard, null);
		powerup.setLevel(level);
		Bat bat = new Bat(42, 2, 1, null);
		Wall wall = new Wall(42, 1, level, null);
		Ball ball = new Ball(131, 455, 1 ,1, null);
		boolean failed = false;
		
		try
		{
			powerup.visit(wall);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
			failed = true;
		}
		assertFalse(failed);
		assertEquals(0, player.getScore());
		
		try
		{
			powerup.visit(bat);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
			failed = true;
		}
		assertFalse(failed);
		assertEquals(15, player.getScore());
		
		try
		{
			powerup.visit(ball);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
			failed = true;
		}
		assertFalse(failed);
		assertEquals(15, player.getScore());
	}
}
