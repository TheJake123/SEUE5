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
		int levelNo = 1;
		while (levelIterator.hasNext()) {
			player.setCurrentLevel(levelNo);
			player.setScore(0);
			currentLevel = levelIterator.next();
			while (!currentLevel.isOver()) {
				try {
					currentLevel.step();
					Thread.sleep(1);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} // end try/catch
			} // end while
			if (player.getLives() <= 0) {
				System.out.print("Verloren. ");
			} else {
				System.out.print("Gewonnen! ");
			}
			if (player.getScore() > player.getHighScore()) {
				player.setHighScore(player.getScore());
				System.out.print("Neuer High");
			}
			System.out.println("Score: " + player.getScore());
		}
	} // end run

} // end class Gameboard
