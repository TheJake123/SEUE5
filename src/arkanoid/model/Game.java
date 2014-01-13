package arkanoid.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Die Klasse Game repräsentiert das Spiel und beherbergt u.a die verschiedenen
 * Levels und den aktuellen Spieler.
 */
public class Game implements Runnable {
	Level currentLevel;
	Iterator<Level> levelIterator;
	Player player;
	private ArrayList<Level> levels;

	/**
	 * Game-Konstruktor
	 * 
	 * @param player
	 *            Der aktuelle Spieler des Spieles.
	 * @param levels
	 *            Die verschiedenen Level Klassen innerhalb des Spieles.
	 * 
	 */
	public Game(Player player, ArrayList<Level> levels) {
		this.player = player;
		this.levels = levels;
		levelIterator = levels.iterator();
	} // end Gameboard

	/**
	 * Die Methode setzt die Spielparameter und gibt dem Spieler den Highscore
	 * aus.
	 * 
	 */
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
