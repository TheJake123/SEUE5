package arkanoid.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import arkanoid.model.*;

/**
 * Klasse, um den SpecialBrick zu testen
 */
public class SpecialBrickTest
{
	private SpecialBrick brick;
	private Player player;

	/**
	 * Dinge, die vor jedem Test passieren
	 */
	@Before
	public void setUp()
	{
		player = new Player("Tester3");
		brick = new SpecialBrick(132, 456, player, null);
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
		assertEquals("Special Brick", brick.getName());
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
		assertEquals(132, brick.getPosX());
	}
	
	/**
	 * Testen der getPosY() Methode
	 */
	@Test
	public void getPosY()
	{
		assertEquals(456, brick.getPosY());
	}
	
	/**
	 * Testen der setPosX() Methode
	 */
	@Test
	public void setPosX()
	{
		brick.setPosX(33);
		assertEquals(33, brick.getPosX());
	}
	
	/**
	 * Testen der the setPosY() Methode
	 */
	@Test
	public void setPosY()
	{
		brick.setPosY(44);
		assertEquals(44, brick.getPosY());
	}

	/**
	 * Testen der getPowerUp() Methode
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
		GameObject[][] gameboard = new GameObject[10][10];
		Level level = new Level(3, gameboard, null);
		
		brick.setLevel(level);
		assertSame(level, brick.getLevel());
	}
	
	/**
	 * Testen der accept() Methode
	 */
	@Test
	public void accept()
	{
		Visitor v = new Ball(131, 455, 1, 1, null);
		
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
		GameObject[][] gameboard = new GameObject[150][500];
		Level level = new Level(3, gameboard, null);
		brick.setLevel(level);
		Ball ball = new Ball(131, 455, 1 ,1, null);
		
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
