package arkanoid.test;


import arkanoid.app.*;
import arkanoid.model.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ArkanoidAppTest.class,BallTest.class,BatTest.class,BatSpeedPowerUpTest.class,BrickFactoryTest.class,GameTest.class,
	           /*LevelTest.class, WallTest.class,*/ PlayerTest.class, SingleBrickTest.class,SpecialBrickTest.class,TripleBrickTest.class})
public class AllTests {
	
}
