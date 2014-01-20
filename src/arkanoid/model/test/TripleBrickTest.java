package arkanoid.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import arkanoid.model.*;

/**
 * Klasse, um den TripleBrick zu testen
 */
public class TripleBrickTest
{
	private TripleBrick brick;
	private Player player;
	
	/**
	 * Dinge, die vor jedem Test passieren
	 */
	@Before
	public void setUp()
	{
		player = new Player("Tester2");
		brick = new TripleBrick(99, 42, player, null);
	}
	
	/**
	 * Dinge, die nach jedem Test passieren
	 */
	@After
	public void tearDown()
	{
		brick = null;
	}
	
	/**
	 * Testen der getName() Methode
	 */
	@Test
	public void getName()
	{
		assertEquals("Triple Brick", brick.getName());
	}
	
	/**
	 * Testen der getPoints() Methode
	 */
	@Test
	public void getPoints()
	{
		assertEquals(10, brick.getPoints());
	}
	
	/**
	 * Testen der getPosX() Methode
	 */
	@Test
	public void getPosX()
	{
		assertEquals(99, brick.getPosX());
	}
	
	/**
	 * Testen der getPosY() Methode
	 */
	@Test
	public void getPosY()
	{
		assertEquals(42, brick.getPosY());
	}
	
	/**
	 * Testen der setPosX() Methode
	 */
	@Test
	public void setPosX()
	{
		brick.setPosX(65);
		assertEquals(65, brick.getPosX());
	}
	
	/**
	 * Testen der setPosY() Methode
	 */
	@Test
	public void setPosY()
	{
		brick.setPosY(12);
		assertEquals(12, brick.getPosY());
	}

	/**
	 * Testen der getLevel() Methode
	 */
	@Test
	public void getLevel()
	{
		assertNull(brick.getLevel());
	}
	
	/**
	 * Testen der setLevel() Methode
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
	 * Testen der accept() Methode
	 */
	@Test
	public void accept()
	{
		Visitor v = new Ball(98, 41, 1, 1, null);
		
		try
		{
			brick.accept(v);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}
	}
	
	/**
	 * Testen der visit() Methode
	 */
	@Test
	public void visit()
	{
		GameObject[][] gameboard = new GameObject[100][100];
		Level level = new Level(2, gameboard, null);
		brick.setLevel(level);
		Ball ball = new Ball(98, 41, 1 ,1, null);
		
		try
		{
			brick.visit(ball);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}
		
		assertEquals(10, player.getScore());
		
		try
		{
			brick.visit(ball);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}
		assertEquals(20, player.getScore());
		
		try
		{
			brick.visit(ball);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}

		assertEquals(30, player.getScore());
		
		try
		{
			brick.visit(ball);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}
		
		assertEquals(60, player.getScore());
	}
}
