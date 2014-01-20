package arkanoid.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import arkanoid.model.Game;
import arkanoid.model.GameObject;
import arkanoid.model.Level;
import arkanoid.model.Player;

public class GameTest {

	private Game game;
	private Level level1;
	private Player player;
	private ArrayList<Level> levels;
	
	@Before
	public void setUp() throws Exception {
		level1 = new Level(1, new GameObject[5][5], new Player("test"));
		levels = new ArrayList<Level>();
		levels.add(level1);
		
		player = new Player("testName");
		game = new Game(player,levels);
	}

	@Test
	public void testRun() {
		game.run();
	}

}
