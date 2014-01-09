package arkanoid.model;

public abstract class GameObject
{
	protected int posX;
	protected int posY;
	
	public GameObject(int x, int y)
	{
		posX = x;
		posY = y;
		
	} //end GameObject
	
	public int getPosX()
	{
		return posX;		
		
	} //end getPosX
	
	public void setPosX(int x)
	{
		posX = x;
		
	} //end setPosX
	
	public int getPosY()
	{
		return posY;
		
	} //end getPosY
	
	public void setPosY(int y)
	{
		posY = y;
		
	} //end setPosY
	
} //end class GameObject
