package arkanoid.model;

public abstract class GameObject implements Visitor, Visitable {
	private int posX;
	private int posY;
	private Level level;
	protected java.util.Random Random = new java.util.Random();
	public GameObject(int x, int y) {
		posX = x;
		posY = y;

	} // end GameObject

	public int getPosX() {
		return posX;

	} // end getPosX

	public void setPosX(int x) {
		posX = x;

	} // end setPosX

	public int getPosY() {
		return posY;

	} // end getPosY

	public void setPosY(int y) {
		posY = y;

	} // end setPosY

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	protected void setLevel(Level l) {
		this.level = l;
	}
	protected Level getLevel() {
		return level;
	}
} // end class GameObject
