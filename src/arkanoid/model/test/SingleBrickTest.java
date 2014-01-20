package arkanoid.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import arkanoid.model.*;

/**
 * Klasse, um den SingleBrick zu testen
 */
public class SingleBrickTest	
{
	private SingleBrick brick;
	private Player player;

	/**
	 * Dinge, die vor jedem Test passieren
	 */
	@Before
	public void setUp()
	{
		player = new Player("Tester1");
		brick = new SingleBrick(10, 8, player, null);
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
		assertEquals("Single Brick", brick.getName());
	}
	
	/**
	 * Testen der getPoints() Methode
	 */
	@Test
	public void getPoints()
	{
		assertEquals(30, brick.getPoints());
	}
	
	/**
	 * Testen der getPosX() Methode
	 */
	@Test
	public void getPosX()
	{
		assertEquals(10, brick.getPosX());
	}
	
	/**
	 * Testen der getPosY() Methode
	 */
	@Test
	public void getPosY()
	{
		assertEquals(8, brick.getPosY());
	}
	
	/**
	 * Testen der setPosX() Methode
	 */
	@Test
	public void setPosX()
	{
		brick.setPosX(22);
		assertEquals(22, brick.getPosX());
	}
	
	/**
	 * Testen der setPosY() Methode
	 */
	@Test
	public void setPosY()
	{
		brick.setPosY(28);
		assertEquals(28, brick.getPosY());
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
		GameObject[][] gameboard = new GameObject[40][40];
		Level level = new Level(1, gameboard, null);
		
		brick.setLevel(level);
		assertSame(level, brick.getLevel());
	}
	
	/**
	 * Testen der accept() Methode
	 */
	@Test
	public void accept()
	{
		Visitor v = new Ball(9, 7, 1, 1, null);
		
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
		GameObject[][] gameboard = new GameObject[40][40];
		Level level = new Level(1, gameboard, null);
		brick.setLevel(level);
		Ball ball = new Ball(9, 7, 1 ,1, null);
		
		try
		{
			brick.visit(ball);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}
		
		assertEquals(30, player.getScore());
	}
}
