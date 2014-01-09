package arkanoid.app;

import arkanoid.model.Gameboard;
import arkanoid.model.Player;


public class ArkanoidApp
{
	private final Gameboard board;
	private final Thread game;
	
	public ArkanoidApp(String player)
	{
		new Player(player);
		board = new Gameboard(50, 100);
		game = new Thread(board);
		game.start();

	} //end ArkanoidApp
	
	public static void main(String[] args)
	{
		System.out.println("Spiel gestartet.");
		
		new ArkanoidApp("Slider");
		
	} //end main
	
} //end class ArkanoidApp
