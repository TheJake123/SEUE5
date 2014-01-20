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
	
	/**
	 * Methode um den Rückgabewert von getName zu testen.
	 */
	@Test
	public void testGetName() {
		assertEquals("Schläger",bat.getName());
	}
	
	/**
	 * Test Methode um die set-/getBallHits Methoden zu prüfen.
	 */
	@Test
	public void testGetBallHits() {
		bat.setBallHits(5);
		assertEquals("Ballberührungen:", 5, bat.getBallHits());
	}
	
	/**
	 * Test Methode um die getSpeedY Methoden zu prüfen, ob diese 0 ist.
	 * 
	 * 
	 */
	@Test
	public void testGetSpeedY() {
		assertEquals("Y Geschwindigkeit:", 0, bat.getSpeedY());
	}
	
	/**
	 * Test Methode um die set-/getSpeedX Methoden zu prüfen.
	 */
	@Test
	public void testGetSpeedX() {
		bat.setSpeedX(1);
		assertEquals("X Geschwindigkeit", 1, bat.getSpeedX());
	}
	
	/**
	 * Test Methode um die set-/getPosY Methoden zu prüfen.
	 */
	@Test
	public void testGetPosY() {
		bat.setPosY(6);
		assertEquals("Y Position:",6, bat.getPosY());
	}
	
	/**
	 * Test Methode um die set-/getPosX Methoden zu prüfen.
	 */
	@Test
	public void testGetPosX() {
		bat.setPosX(6);
		assertEquals("X Position:",6, bat.getPosX());
	}
	
	/**
	 * Unit Test für die move Methode, welches eine Richtungsänderung nur in X Richtung bewirken darf.
	 */
	@Test
	public void testMove() {
		int newXPosition = bat.getPosX() + bat.getSpeedX();
		bat.setPosY(5);

		
		bat.move();
		
		assertEquals("Neue X Position:", newXPosition,bat.getPosX());
		assertEquals("Neue Y Position:", 5,bat.getPosY()); //Keine Richtungsänderung in Y Richtung vorgesehen
	}
	
	/**
	 * Method um die visit Implementierung zu testen
	 * 
	 * Die visit Methode wird mit verschiedenen Aufrufparameter ausgeführt. Nur bei einem Wall Objekt als Aufrufparameter
	 * werden die Positionen und die Geschwindigkeiten von dem Schläger geändert. Sollte die Methode mit einem Ball Objekt
	 * aufgerufen werden, sollen sich dessen Positionen und Geschwindikeiten ändern und zusätzlich die Anzahl an ballHits
	 * vom Schläger erhöht werden.
	 */
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
		assertEquals("Neue X Position:",newXPosition, bat.getPosX());	
		assertEquals("Neue Y Position:",newYPosition, bat.getPosY());	
		assertEquals("Neue X Geschwindigkeit:",newXSpeed, bat.getSpeedX());	
		assertEquals("Neue Y Geschwindigkeit:",newYSpeed, bat.getSpeedY());
		
		//Sowohl Position als auch Geschwindikeit des Schlägers sollten sich nicht geändert haben, die des Balles jedoch schon		
		bat.visit(ball);

		assertEquals("Neue X Position:",newXPosition, bat.getPosX());	
		assertEquals("Neue Y Position:",newYPosition, bat.getPosY());	
		assertEquals("Neue X Geschwindigkeit:",newXSpeed, bat.getSpeedX());	
		assertEquals("Neue Y Geschwindigkeit:",newYSpeed, bat.getSpeedY());
		assertEquals("Neue Anzahl an Balltreffer:",newBallHits, bat.getBallHits());
		assertTrue("Neue X Geschwindigkeit des Balles:", (ball.getSpeedX()<=1 && ball.getSpeedX() >=-1));	
		assertEquals("Neue Y Geschwindigkeit des Balles:",newBallYSpeed, ball.getSpeedY());	

	}

}
