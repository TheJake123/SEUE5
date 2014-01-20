package arkanoid.model.test;

import arkanoid.model.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *	Testet die Wall-Klasse
 */
public class WallTest {
	private Wall wall;
	private Level level;
	private Player player;
	private Ball ball;
	/**
	 * Initialisieren der Testumgebung
	 */
	@Before
	public void setUp() {
		player = new Player("TestPlayer");
		level = new Level(0, new GameObject[5][5], player);
		wall = new Wall(0, level.getHeight()-1, level, player);
		ball = new Ball(0,level.getHeight()-1,-1,1,level);
	}

	/**
	 * Testet die Position der Wand
	 */
	@Test
	public void testPosition() {
		assertEquals("PosX:", 0, wall.getPosX());
		assertEquals("PosY:", level.getHeight()-1, wall.getPosY());
	}
	/**
	 * Testet den Namen der Wand
	 */
	@Test
	public void testName() {
		assertEquals("Name:","Wand",wall.getName());
	}
	/**
	 * Testet, ob der Level richtig gesetzt wurde
	 */
	@Test
	public void testLevel() {
		assertEquals("Level:",level,wall.getLevel());
	}
	/**
	 * Testet die Kollision mit einem Ball
	 */
	@Test
	public void testBallColision() {
		wall.visit(ball);
		assertEquals("SpeedX:",1,ball.getSpeedX());
		assertEquals("SpeedY:",-1,ball.getSpeedY());
		assertEquals("Lives:",2,player.getLives());
	}
}
