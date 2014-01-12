package arkanoid.model;

public class PowerUp extends GameObject implements Moveable, WallVisitor {

	public PowerUp(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(Wall other) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

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

}
