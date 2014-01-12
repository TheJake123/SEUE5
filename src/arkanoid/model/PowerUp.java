package arkanoid.model;

public abstract class PowerUp extends GameObject implements Moveable {
	private int speedY;
	private Player player;

	public PowerUp(int x, int y, int speedY, Level level, Player player) {
		super(x, y, level);
		this.speedY = speedY;
		this.player = player;
	}

	@Override
	public void visit(GameObject other) {
		if (other instanceof Wall) {
			getLevel().removeObject(this);
		} else if (other instanceof Bat) {
			player.setScore(player.getScore() + 15);
			System.out.println("Score wird um 15 auf " + player.getScore()
					+ " erhöht");
		}
	}

	@Override
	public void move() {
		setPosY(getPosY() + getSpeedY());
	}

	@Override
	final public int getSpeedX() {
		return 0; // Keine horizontale Bewegung
	}

	@Override
	public int getSpeedY() {
		return speedY;
	}

	@Override
	final public void setSpeedX(int speedX) {
	}

	@Override
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}
