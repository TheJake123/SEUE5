package arkanoid.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Game implements Runnable {
	private ArrayList<Level> levels;
	Iterator<Level> levelIterator;
	Level currentLevel;
	Player player;

	public Game(Player player, ArrayList<Level> levels) {
		this.player = player;
		this.levels = levels;
		levelIterator = levels.iterator();
	} // end Gameboard

	@Override
	public void run() {
		while (levelIterator.hasNext()) {
			player.setScore(0);
			currentLevel = levelIterator.next();
			while (!currentLevel.isOver()) {
				try {
					currentLevel.step();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} // end try/catch
			} // end while
		}
	} // end run

} // end class Gameboard
