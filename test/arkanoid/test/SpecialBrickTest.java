package arkanoid.test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import arkanoid.model.Ball;
import arkanoid.model.BatSpeedPowerUp;
import arkanoid.model.GameObject;
import arkanoid.model.Level;
import arkanoid.model.Player;
import arkanoid.model.SpecialBrick;
import arkanoid.model.Visitor;

/**
 * class for testing the SpecialBrick
 */
public class SpecialBrickTest
{
	private SpecialBrick brick;
	private Player player;

	/**
	 * things to do BEFORE the test
	 */
	@Before
	public void setUp()
	{
		player = new Player("Tester3");
		brick = new SpecialBrick(132, 456, player, null);
	}
	
	/**
	 * things to do AFTER the test
	 */
	@After
	public void tearDown()
	{
		brick = null;
	}
	
	/**
	 * testing the getName() method
	 */
	@Test
	public void getName()
	{
		assertEquals("Special Brick", brick.getName());
	}
	
	/**
	 * testing the getPoints() method
	 */
	@Test
	public void getPoints()
	{
		assertEquals(30, brick.getPoints());
	}
	
	/**
	 * testing the getPosX() method
	 */
	@Test
	public void getPosX()
	{
		assertEquals(132, brick.getPosX());
	}
	
	/**
	 * testing the getPosY() method
	 */
	@Test
	public void getPosY()
	{
		assertEquals(456, brick.getPosY());
	}
	
	/**
	 * testing the setPosX() method
	 */
	@Test
	public void setPosX()
	{
		brick.setPosX(33);
		assertEquals(33, brick.getPosX());
	}
	
	/**
	 * testing the setPosY() method
	 */
	@Test
	public void setPosY()
	{
		brick.setPosY(44);
		assertEquals(44, brick.getPosY());
	}

	/**
	 * testing the getPowerUp() method
	 */
	@Test
	public void getPowerUp()
	{
		boolean isBatSpeedPowerUp = false;
		
		if(brick.getPowerUp() instanceof BatSpeedPowerUp)
			isBatSpeedPowerUp = true;
		
		assertTrue(isBatSpeedPowerUp);
	}
	
	/**
	 * testing the getLevel() method
	 */
	@Test
	public void getLevel()
	{
		assertNull(brick.getLevel());
	}
	
	/**
	 * testing the setLevel() method
	 */
	@Test
	public void setLevel()
	{
		GameObject[][] gameboard = new GameObject[10][10];
		Level level = new Level(3, gameboard, null);
		
		brick.setLevel(level);
		assertSame(level, brick.getLevel());
	}
	
	/**
	 * testing the accept() method
	 */
	@Test
	public void accept()
	{
		Visitor v = new Ball(131, 455, 1, 1, null);
		boolean failed = false;
		
		try
		{
			brick.accept(v);
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
		GameObject[][] gameboard = new GameObject[150][500];
		Level level = new Level(3, gameboard, null);
		brick.setLevel(level);
		Ball ball = new Ball(131, 455, 1 ,1, null);
		boolean failed = false;
		
		try
		{
			brick.visit(ball);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
			failed = true;
		}
		assertFalse(failed);
		assertEquals(30, player.getScore());
	}
}
