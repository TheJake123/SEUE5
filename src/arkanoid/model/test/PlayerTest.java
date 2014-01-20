package arkanoid.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import arkanoid.model.Player;

/**
 * PlayerTest zum Testen der PlayerTest Klasse.
 */
public class PlayerTest {
	Player player;
	
	/**
	 * Bevor die Tests ausgef�hrt werden, wird ein Player Objekt initialisiert.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		player = new Player("TestName");
	}
	
	/**
	 * Methode um den R�ckgabewert von getName zu testen.
	 */
	@Test
	public void testName() {
		assertEquals("TestName", player.getName());
	}
	
	/**
	 * Test Methode um die set-/getLives Methoden zu pr�fen.
	 */
	@Test
	public void testLives() {
		player.setLives(3);
		assertEquals("Player - Leben:", 3, player.getLives());
	}
	/**
	 * Test Methode um die set-/getScore Methoden zu pr�fen.
	 */
	@Test
	public void testScore() {
		player.setScore(10);
		assertEquals("Player - Score:", 10, player.getScore());
	}
	/**
	 * Test Methode um die set-/getHighScore Methoden zu pr�fen.
	 */
	@Test
	public void testHighscore() {
		player.setHighScore(10);
		assertEquals("Player - Highscore:", 10, player.getHighScore());
	}
	/**
	 * Test Methode um die set-/getCurrentLevel Methoden zu pr�fen.
	 */
	@Test
	public void testLevels() {
		player.setCurrentLevel(1);
		assertEquals("Player - Aktuelles Level:", 1, player.getCurrentLevel());
	}

}
