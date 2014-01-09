package arkanoid.model;

public class Ball extends GameObject implements Moveable
{
	private int speedX;
	private int speedY;
	public Ball(int x, int y)
	{
		super(x, y);
		speedY = 1;
	} //end Ball
	
	@Override
	public void move()
	{
		
		
	} //end move
	
} //end class Ball
