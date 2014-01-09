package arkanoid.app;

import arkanoid.model.Game;
import arkanoid.model.Player;


public class ArkanoidApp
{
	private final Game game;
	private final Thread gameThread;
	
	public ArkanoidApp(String player)
	{
		new Player(player);
		game = new Game();
		gameThread = new Thread(game);
		gameThread.start();

	} //end ArkanoidApp
	
	public static void main(String[] args)
	{
		System.out.println("Spiel gestartet.");
		
		new ArkanoidApp("Slider");
		
	} //end main
	
	private void createFieldObjects()
	{
		createWalls();
		createBricks();
		
		int xBat = width/2;
		int yBat = 10;
		int batWidth = 10;
		
		//create Bat
		bat = new Bat(xBat, yBat, batWidth, width, false);
		
		int xBall = width/2;
		int yBall = height/2;
		
		//create Ball
		ball = new Ball(width/2, height/2);
		
		//add both to the field
		field[xBat][yBat] = bat;
		field[xBall][yBall] = ball;
		
	} //end createBricks
	
	private void createWalls()
	{
		//south-wall
		for(int x = 0; x < width; x ++)
		{
			field[x][0] = new Wall(x, 0);
			
		} //end for
		
		//north-wall
		for(int x = 0; x < width; x ++)
		{
			field[x][height-1] = new Wall(x, height-1);
			
		} //end for
		
		//east-wall
		for(int y = 0; y < height; y ++)
		{
			field[0][y] = new Wall(0, y);
			
		} //end for
		
		//west-wall
		for(int y = 0; y < height; y ++)
		{
			field[width-1][y] = new Wall(width-1, y);
			
		} //end for
		
	} //end createWalls
	
	private void createBricks()
	{
		int minX = 3;
		int maxX = width - 4;
		int minY = (height/3) * 2 + 1;
		int maxY = height - 4;
		
		Random r = new Random();
		int rand;
		int maxRand = 8;
		int brickNr = 1;
		
		for(int x = minX; x <= maxX; x++)
		{
			for(int y = minY; y <= maxY; y++)
			{
				if((x * y) % 2 == 0)
				{
					rand = r.nextInt(2);
					
					if(rand == 0)
						field[x][y] = new Brick(brickNr, x, y, BrickType.SB);
				
					else
						field[x][y] = new Brick(brickNr, x, y, BrickType.TB);
				
				} //end if
				else
				{
					rand = r.nextInt(maxRand);
					
					switch(rand)
					{
						case 0:
							field[x][y] = new Brick(brickNr, x, y, BrickType.SBBALL);
							break;
						
						case 1:
							field[x][y] = new Brick(brickNr, x, y, BrickType.SBFALL);
							break;
						
						case 2:
							field[x][y] = new Brick(brickNr, x, y, BrickType.SBENLARGE);
							break;
						
						case 3:
							field[x][y] = new Brick(brickNr, x, y, BrickType.SBSHORTEN);
							break;
						
						case 4:
							field[x][y] = new Brick(brickNr, x, y, BrickType.SBFAST);
							break;
							
						case 5:
							field[x][y] = new Brick(brickNr, x, y, BrickType.SBSLOW);
							break;
							
						case 6:
							field[x][y] = new Brick(brickNr, x, y, BrickType.TBBALL);
							break;
							
						case 7:
							field[x][y] = new Brick(brickNr, x, y, BrickType.TBPORTAL);
							//if the portal already exists, there is one option less to choose
							maxRand = 7;
							break;
					
					} //end switch
					
				} //end else
				
				bricks.add((Brick)(field[x][y]));
				
				brickNr++;
				
			} //end for
			
		} //end for
		
	} //end createBricks
	
} //end class ArkanoidApp
