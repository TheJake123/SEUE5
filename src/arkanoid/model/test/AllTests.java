package arkanoid.model.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * JUnit Suite Klasse, welche alle JUnit Tests der angegebenen Klassen ausführt.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ArkanoidAppTest.class,BallTest.class,BatTest.class,BatSpeedPowerUpTest.class,BrickFactoryTest.class,GameTest.class,
	           /*LevelTest.class, WallTest.class,*/ PlayerTest.class, SingleBrickTest.class,SpecialBrickTest.class,TripleBrickTest.class})
public class AllTests {
	
}
