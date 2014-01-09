package arkanoid.model;

public class Bat extends GameObject implements Moveable, BallVisitor {
	// width is just a relative size
	private int width;
	private int speedX;
	private int ballHits;
	private int maxX; //right border

	public Bat(int x, int y, int width, int fieldWidth, int speedX) {
		super(x, y);
		this.width = width;
		this.maxX = fieldWidth - 1;
		this.speedX = speedX;
		ballHits = 0;

	} // end Bat

	public int getBallHits() {
		return ballHits;

	} // end getBallHits

	public void setBallHits(int hits) {
		ballHits = hits;

	} // end setBallHits

	public int getWidth() {
		return width;

	} // end getLength

	public int getSpeedY() {
		return 0; // Only horizontal movement
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedX) {
		// No vertical movement can be overwritten)
	}
	
	@Override
	public void move() {
		if (posX + speedX > maxX || posX + speedX < 0)
			speedX *= -1;
		posX = posX + speedX;

		System.out.println("Schläger von (" + (posX - speedX) + "," + posY
				+ ") nach (" + posX + "," + posY + ")");

	} // end move

	public void visit(Ball b) {
		b.setSpeedX = Math.round(Math.random()*2)-1;
	}
} // end class Batt
