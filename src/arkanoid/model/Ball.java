package arkanoid.model;

class Ball extends GameObject implements Moveable
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

	@Override
	public int getSpeedX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpeedY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSpeedX(int speedX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpeedY(int speedY) {
		// TODO Auto-generated method stub
		
	}
	
} //end class Ball
