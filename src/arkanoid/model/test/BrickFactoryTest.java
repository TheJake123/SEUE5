package arkanoid.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import arkanoid.model.BrickFactory;
import arkanoid.model.Player;
import arkanoid.model.SingleBrick;
import arkanoid.model.SpecialBrick;
import arkanoid.model.TripleBrick;


/**
 * Diese Klasse testet die Methoden von BrickFactory.
 *
 */
public class BrickFactoryTest {
	
	BrickFactory factory;

	/**
	 * Initialisierung von einem neuen BrickFactory objektes.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		factory = new BrickFactory(new Player("test"));
	}

	/**
	 * Hier werden die zurückgegebenen Objekte nach ihrer Richtigkeit Überprüft und je nach ÜbergabeString werden 
	 * verschiedene Objekte zurückgeliefert.
	 */
	@Test
	public void testGetBrick() {
		assertTrue("Single Brick:", (factory.getBrick("SingleBRick", 10, 10) instanceof SingleBrick));
		assertTrue("Triple Brick:", (factory.getBrick("MultiBRick", 10, 10) instanceof TripleBrick));
		assertTrue("Special Brick:", (factory.getBrick("SpecialBRick", 10, 10) instanceof SpecialBrick));
		assertEquals("No match:", null, (factory.getBrick("No Match", 10, 10)));
	}

}
