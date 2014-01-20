package arkanoid.test;


import arkanoid.app.*;
import arkanoid.model.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ArkanoidApp.class,Ball.class,Bat.class,BatSpeedPowerUp.class,BrickFactory.class,Game.class,
	           Level.class, Player.class, SingleBrick.class,SpecialBrick.class,TripleBrick.class})
public class AllTests {
	
}
