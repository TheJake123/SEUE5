package arkanoid.model;

public class Brick extends GameObject
{
	private int nr;
	private BrickType type;
	
	public Brick(int nr, int x, int y, BrickType type)
	{
		super(x, y);
		this.nr = nr;
		this.type = type;
		
	} //end Brick
	
	public int getNr()
	{
		return nr;
		
	} //end getNr
	
	public BrickType getBrickType()
	{
		return type;
		
	} //end getBrickType
	
} //end class Brick
