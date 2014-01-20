package arkanoid.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import arkanoid.model.Ball;
import arkanoid.model.GameObject;
import arkanoid.model.Level;
import arkanoid.model.Player;
import arkanoid.model.SingleBrick;
import arkanoid.model.Wall;


public class BallTest {
	
	private Ball ball;
	private Level level;

	@Before
	public void setUp() throws Exception {
		level = new Level(1, new GameObject[5][5], new Player("test"));
		ball = new Ball(5,5,1,1,level);
	}

	@Test
	public void testSpeedX() {
		ball.setSpeedX(1);
		assertEquals("Speed X:", 1, ball.getSpeedX());
	}
	
	@Test
	public void testSpeedY() {
		ball.setSpeedY(1);
		assertEquals("Speed Y:", 1, ball.getSpeedY());	
	}
	
	@Test
	public void testPosX() {
		ball.setPosX(4);
		assertEquals("Position X:", 4, ball.getPosX());
	}
	
	@Test
	public void testPosY() {
		ball.setPosY(4);
		assertEquals("Position Y:", 4, ball.getPosY());	
	}
	
	@Test
	public void testGetName() {
		assertEquals("Ball", ball.getName());	
	}
	
	@Test
	public void testMove() {
		int newXPosition = ball.getPosX() + ball.getSpeedX();
		int newYPosition = ball.getPosY() + ball.getSpeedY();
		
		ball.move();

		assertEquals("Neue X Position:",newXPosition, ball.getPosX());	
		assertEquals("Neue Y Position:",newYPosition, ball.getPosY());	
	}
	
	@Test
	public void testVisit() {
		SingleBrick brick = new SingleBrick(5,5,new Player("testName"),null);
		Wall wall = new Wall(5,5,level,null);
		
		int newXPosition = ball.getPosX() - ball.getSpeedX();
		int newYPosition = ball.getPosY() - ball.getSpeedY();
		int newXSpeed = ball.getSpeedX()*-1;
		int newYSpeed = ball.getSpeedY()*-1;
		
		ball.visit(brick);

		assertEquals("Neue X Position:", newXPosition, ball.getPosX());	
		assertEquals("Neue Y Position:", newYPosition, ball.getPosY());	
		assertEquals("Neue X Geschwindigkeit:", newXSpeed, ball.getSpeedX());	
		assertEquals("Neue Y Geschwindigkeit:", newYSpeed, ball.getSpeedY());	
		
		ball.visit(wall); //Position darf sich nicht geändert haben
		
		assertEquals("Neue X Position:", newXPosition, ball.getPosX());	
		assertEquals("Neue Y Position:", newYPosition, ball.getPosY());	
		assertEquals("Neue X Geschwindigkeit:", newXSpeed, ball.getSpeedX());	
		assertEquals("Neue Y Geschwindigkeit:", newYSpeed, ball.getSpeedY());	

		
	}

}
