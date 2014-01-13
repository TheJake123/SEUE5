package arkanoid.app;

import java.util.ArrayList;

import java.util.Random;

import arkanoid.model.*;
/**
 * Diese Klasse startet das Spiel und erstellt ein Spielfeld
 */
public class ArkanoidApp {
	private final Game game;
	private final Thread gameThread;
	Player player;

	/**
	 * Der ArkanoidApp Konstruktor startet ein Spiel, setzt das Level und Spielfeld und alle nötigen Parameter.
	 * 
	 * @param playerName Name des Spielers
	 */
	public ArkanoidApp(String playerName) {
		player = new Player(playerName);
		ArrayList<Level> levels = new ArrayList<Level>();
		levels.add(new Level(1, createField(10,2), player));
		levels.get(0).displayBoard();
		game = new Game(player, levels);
		gameThread = new Thread(game);
		gameThread.start();
		 
	} // end ArkanoidApp

	public static void main(String[] args) {
		System.out.println("Spiel gestartet.");
		new ArkanoidApp("Slider");
	} // end main
	/**
	 * Die Methode erzeugt das Spielfeld mit den verschiedenen Ziegeln.
	 * 
	 * @param width Breite des Spielfeldes
	 * @param height Höhe des Spielfeldes
	 */
	private GameObject[][] createField(int width, int height) {
		GameObject field[][] = new GameObject[width][height];

		// Create Bricks
        BrickFactory factory = new BrickFactory(player);
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
					double rand = Math.random();
					if(rand < 0.2)
					{
						field[x][y] = factory.getBrick("SingleBrick", x, y);
					}
					else if(rand < 0.3)
					{
						field[x][y] = factory.getBrick("MultiBrick", x, y);
					}
					else if(rand < 0.33)
					{
						field[x][y] = factory.getBrick("SpecialBrick", x, y);
					}
			}
		return field;
	} // end createField
} // end class ArkanoidApp
