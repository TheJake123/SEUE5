package arkanoid.app;

import java.util.ArrayList;
import java.util.Random;

import arkanoid.model.*;

public class ArkanoidApp {
	private final Game game = null;
	private final Thread gameThread = null;
	Player player;

	public ArkanoidApp(String playerName) {
		player = new Player(playerName);
		ArrayList<Level> levels = new ArrayList<Level>();
		levels.add(new Level(1, createField(50, 50)));
		levels.get(0).displayBoard();
		/*
		 * game = new Game(player, levels); gameThread = new Thread(game);
		 * gameThread.start();
		 */
	} // end ArkanoidApp

	public static void main(String[] args) {
		System.out.println("Spiel gestartet.");
		new ArkanoidApp("Slider");
	} // end main

	private GameObject[][] createField(int width, int height) {
		GameObject field[][] = new GameObject[width][height];

		// Create Bricks
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				if (Math.random() < 1 / width / height)
					field[x][y] = new Brick(x, y, player);
		return field;
	} // end createField
} // end class ArkanoidApp
