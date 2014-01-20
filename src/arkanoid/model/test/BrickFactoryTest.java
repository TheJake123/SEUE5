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

public class BrickFactoryTest {
	
	BrickFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new BrickFactory(new Player("test"));
	}

	@Test
	public void testGetBrick() {
		assertTrue("Single Brick:", (factory.getBrick("SingleBRick", 10, 10) instanceof SingleBrick));
		assertTrue("Triple Brick:", (factory.getBrick("MultiBRick", 10, 10) instanceof TripleBrick));
		assertTrue("Special Brick:", (factory.getBrick("SpecialBRick", 10, 10) instanceof SpecialBrick));
		assertTrue("No match:", (factory.getBrick("No Match", 10, 10) == null));
	}

}
