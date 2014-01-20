package arkanoid.model.test;

import static org.junit.Assert.*;
import arkanoid.model.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testet die Level-Klasse
 */
public class LevelTest {

	private Level level;
	private Player player;

	/**
	 * Initialisieren der Testumgebung
	 */
	@Before
	public void setUp() {
		GameObject[][] field = new GameObject[3][3];
		player = new Player("TestPlayer");
		field[0][0] = new TripleBrick(0, 0, player, level);
		level = new Level(0, field, player);
	}

	/**
	 * Testet die grundlegenden Eigenschaften des Levels
	 */
	@Test
	public void testBaseInformation() {
		assertEquals("Level Height:", 14, level.getHeight());
		assertEquals("Level Width:", 5, level.getWidth());
		assertEquals("Level No:", 0, level.getLvlNr());
		assertEquals("BrickCount:", 1, level.getBricksCount());
	}

	/**
	 * Testet das Einfügen eines Objekts sowie dessen Entfernung
	 */
	@Test
	public void testInsertion() {
		Ball b = new Ball(1,1,1,1,null);
		level.addObject(b);
		assertEquals("Ball inserted:",level,b.getLevel());
		level.removeObject(b);
		assertEquals("Ball removed:",null,b.getLevel());
	}
	/**
	 * Würde die step-Methode der Level-Klasse testen
	 */
	@Test
	public void testStep() {
		//Kann nich getestet werden, da die Richtungen der Objekte nicht deterministisch sind.
	}
}
