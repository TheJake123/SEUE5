package arkanoid.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import arkanoid.model.*;

/**
 * Klasse, um das Powerup für den Schläger zu testen
 */
public class BatSpeedPowerUpTest
{
	private BatSpeedPowerUp powerup;
	private Player player;
	
	/**
	 * Dinge, die vor jedem Test passieren
	 */
	@Before
	public void setUp()
	{
		player = new Player("Tester4");
		powerup = new BatSpeedPowerUp(41, 95, null, player);
	}
	
	/**
	 * Dinge, die nach jedem Test passieren
	 */
	@After
	public void tearDown()
	{
		powerup = null;
	}
	
	/**
	 * Testen der getSpeedY() Methode
	 */
	@Test
	public void getSpeedY()
	{
		assertEquals(1, powerup.getSpeedY());
	}
	
	/**
	 * Testen der setSpeedY() Methode
	 */
	@Test
	public void setSpeedY()
	{
		powerup.setSpeedY(3);
		assertEquals(3, powerup.getSpeedY());
	}
	
	/**
	 * Testen der move() Methode
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
	 * Testen der getName() Methode
	 */
	@Test
	public void getName()
	{
		assertEquals("BatSpeedPowerUp", powerup.getName());
	}
	
	/**
	 * Testen der getPosX() Methode
	 */
	@Test
	public void getPosX()
	{
		assertEquals(41, powerup.getPosX());
	}
	
	/**
	 * Testen der getPosY() Methode
	 */
	@Test
	public void getPosY()
	{
		assertEquals(95, powerup.getPosY());
	}
	
	/**
	 * Testen der setPosX() Methode
	 */
	@Test
	public void setPosX()
	{
		powerup.setPosX(7);
		assertEquals(7, powerup.getPosX());
	}
	
	/**
	 * Testen der setPosY() Methode
	 */
	@Test
	public void setPosY()
	{
		powerup.setPosY(8);
		assertEquals(8, powerup.getPosY());
	}
	
	/**
	 * Testen der getLevel() Methode
	 */
	@Test
	public void getLevel()
	{
		assertNull(powerup.getLevel());
	}
	
	/**
	 * Testen der setLevel() Methode
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
	 * Testen der accept() Methode
	 */
	@Test
	public void accept()
	{
		GameObject[][] gameboard = new GameObject[100][100];
		Level level = new Level(4, gameboard, null);
		Visitor bat = new Bat(42,2,1, null);
		Visitor wall = new Wall(42,1, level, null);
		Visitor ball = new Ball(131, 455, 1, 1, null);
		
		try
		{
			powerup.accept(bat);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}
		
		try
		{
			powerup.accept(wall);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}
		
		try
		{
			powerup.accept(ball);
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
		Level level = new Level(4, gameboard, null);
		powerup.setLevel(level);
		Bat bat = new Bat(42, 2, 1, null);
		Wall wall = new Wall(42, 1, level, null);
		Ball ball = new Ball(131, 455, 1 ,1, null);
		
		try
		{
			powerup.visit(wall);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}
		
		assertEquals(0, player.getScore());
		
		try
		{
			powerup.visit(bat);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}

		assertEquals(15, player.getScore());
		
		try
		{
			powerup.visit(ball);
		}
		catch(Exception e)
		{
			fail("No Exception must be thrown here!");
		}
		
		assertEquals(15, player.getScore());
	}
	
	/**
	 * Testen, ob das Powerup nach 15 Sekunden seine Wirkung verliert
	 */
	@Test
	public void powerupExpiration()
	{
		GameObject[][] gameboard = new GameObject[100][100];
		Level level = new Level(4, gameboard, null);
		powerup.setLevel(level);
		Bat bat = new Bat(42, 2, 1, null);
		
		assertEquals(1, bat.getSpeedX());
		
		powerup.visit(bat);
		
		try {
			Thread.sleep(16000); // 1 sekunde mehr als Powerup läuft
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(1, bat.getSpeedX());
	}
}
