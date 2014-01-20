package arkanoid.model.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import arkanoid.model.Ball;
import arkanoid.model.GameObject;
import arkanoid.model.Level;
import arkanoid.model.Player;
import arkanoid.model.TripleBrick;
import arkanoid.model.Visitor;

/**
 * class for testing the TripleBrick
 */
public class TripleBrickTest
{
	private TripleBrick brick;
	private Player player;
	
	/**
	 * things to do BEFORE the test
	 */
	@Before
	public void setUp()
	{
		player = new Player("Tester2");
		brick = new TripleBrick(99, 42, player, null);
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
	 * testig the getName() method
	 */
	@Test
	public void getName()
	{
		assertEquals("Triple Brick", brick.getName());
	}
	
	/**
	 * testing the getPoints() method
	 */
	@Test
	public void getPoints()
	{
		assertEquals(10, brick.getPoints());
	}
	
	/**
	 * testing the getPosX() method
	 */
	@Test
	public void getPosX()
	{
		assertEquals(99, brick.getPosX());
	}
	
	/**
	 * testing the getPosY() method
	 */
	@Test
	public void getPosY()
	{
		assertEquals(42, brick.getPosY());
	}
	
	/**
	 * testing the setPosX() method
	 */
	@Test
	public void setPosX()
	{
		brick.setPosX(65);
		assertEquals(65, brick.getPosX());
	}
	
	/**
	 * testing the setPosY() method
	 */
	@Test
	public void setPosY()
	{
		brick.setPosY(12);
		assertEquals(12, brick.getPosY());
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
		GameObject[][] gameboard = new GameObject[20][20];
		Level level = new Level(2, gameboard, null);
		
		brick.setLevel(level);
		assertSame(level, brick.getLevel());
	}
	
	/**
	 * testing the accept() method
	 */
	@Test
	public void accept()
	{
		Visitor v = new Ball(98, 41, 1, 1, null);
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
		GameObject[][] gameboard = new GameObject[100][100];
		Level level = new Level(2, gameboard, null);
		brick.setLevel(level);
		Ball ball = new Ball(98, 41, 1 ,1, null);
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
		assertEquals(10, player.getScore());
		
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
		assertEquals(20, player.getScore());
		
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
		assertEquals(60, player.getScore());
	}
}
