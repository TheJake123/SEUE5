package arkanoid.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import arkanoid.model.Player;

public class PlayerTest {
	Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new Player("TestName");
	}
	
	@Test
	public void testName() {
		assertTrue("Player name", "TestName" == player.getName());
	}
	
	/*
	 * Note: set*-Methoden sind nicht Verfügbar aufgrund der eingeschränkten Sichtbarkeit (protected).
	 */
	
	@Test
	public void testLives() {
		player.setLives(3);
		assertTrue("Player - Leben:", 3 == player.getLives());
	}
	@Test
	public void testScore() {
		player.setScore(10);
		assertTrue("Player - Score:", 10 == player.getScore());
	}
	@Test
	public void testHighscore() {
		player.setHighScore(10);
		assertTrue("Player - Highscore:", 10 == player.getHighScore());
	}
	@Test
	public void testLevels() {
		player.setCurrentLevel(1);
		assertTrue("Player - Aktuelles Level:", 1 == player.getCurrentLevel());
	}

}
