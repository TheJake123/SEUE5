package arkanoid.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import arkanoid.model.Ball;
import arkanoid.model.Bat;
import arkanoid.model.GameObject;
import arkanoid.model.Level;
import arkanoid.model.Player;
import arkanoid.model.SingleBrick;
import arkanoid.model.Wall;

public class BatTest {
	
	private Bat bat;
	private Level level;

	@Before
	public void setUp() throws Exception {
		level = new Level(1, new GameObject[5][5], new Player("test"));
		bat = new Bat(5,5,1,level);
	}

	@Test
	public void testGetName() {
		assertTrue("Schläger Name:", "Schläger".equals(bat.getName()));
	}

	@Test
	public void testGetBallHits() {
		bat.setBallHits(5);
		assertTrue("Schläger Name:", bat.getBallHits() == 5);
	}

	@Test
	public void testGetSpeedY() {
		assertTrue("Schläger Name:", bat.getSpeedY() == 0);
	}

	@Test
	public void testGetSpeedX() {
		bat.setSpeedX(1);
		assertTrue("Schläger Name:", bat.getSpeedX() == 1);
	}
	
	@Test
	public void testGetPosY() {
		bat.setPosY(6);
		assertTrue("Schläger Name:", bat.getPosY() == 6);
	}

	@Test
	public void testGetPosX() {
		bat.setPosX(6);
		assertTrue("Schläger Name:", bat.getPosX() == 6);
	}

	@Test
	public void testMove() {
		int newXPosition = bat.getPosX() + bat.getSpeedX();
		bat.setPosY(5);

		
		bat.move();
		
		assertTrue("Neue X Position:", newXPosition == bat.getPosX());
		assertTrue("Neue Y Position:", 5 == bat.getPosY()); //Keine Richtungsänderung in Y Richtung vorgesehen
	}

	@Test
	public void testVisit() {
		Ball ball = new Ball(5,5,1,1,level);
		Wall wall = new Wall(5,5,level,null);
		
		
		//Position darf sich nicht geändert haben, nur die X Geschwindigkeit sollte sich umgedreht haben
		int newXPosition = bat.getPosX();
		int newYPosition = bat.getPosY();
		int newXSpeed = bat.getSpeedX()*-1;
		int newYSpeed = bat.getSpeedY();
		int newBallYSpeed = ball.getSpeedY()*-1;
		int newBallHits = bat.getBallHits()+1;
		
		bat.visit(wall); 
		assertTrue("Neue X Position:", bat.getPosX() == newXPosition);	
		assertTrue("Neue Y Position:", bat.getPosY() == newYPosition);	
		assertTrue("Neue X Geschwindigkeit:", bat.getSpeedX() == newXSpeed);	
		assertTrue("Neue Y Geschwindigkeit:", bat.getSpeedY() == newYSpeed);
		
		//Sowohl Position als auch Geschwindikeit des Schlägers sollten sich nicht geändert haben, die des Balles jedoch schon		
		bat.visit(ball);

		assertTrue("Neue X Position:", bat.getPosX() == newXPosition);	
		assertTrue("Neue Y Position:", bat.getPosY() == newYPosition);	
		assertTrue("Neue X Geschwindigkeit:", bat.getSpeedX() == newXSpeed);	
		assertTrue("Neue Y Geschwindigkeit:", bat.getSpeedY() == newYSpeed);
		assertTrue("Neue Anzahl an Balltreffer:", bat.getBallHits() == newBallHits);
		assertTrue("Neue X Geschwindigkeit:", (ball.getSpeedX()<=1 && ball.getSpeedX() >=-1));	
		assertTrue("Neue Y Geschwindigkeit des Balles:", ball.getSpeedY() == newBallYSpeed);	

	}

}
