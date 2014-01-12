package arkanoid.model;

class Wall extends GameObject {
	private final int[][] possibleReflections;
	java.util.Random Random = new java.util.Random();
	private Player player;
	public Wall(int x, int y, Level level, Player player) {
		super(x, y, level);
		this.player = player;
		int boardWidth = level.getWidth();
		int boardHeight = level.getHeight();
		if (x == boardWidth - 1 && y == boardHeight - 1) { //SE Corner
			possibleReflections = new int[1][2];
			possibleReflections[0][0] = -1;
			possibleReflections[0][1] = -1;
		} else if (x == boardWidth - 1 && y == 0) { //NE Corner
			possibleReflections = new int[1][2];
			possibleReflections[0][0] = -1;
			possibleReflections[0][1] = 1;
		} else if (x == 0 && y == boardHeight - 1) { //SW Corner
			possibleReflections = new int[1][2];
			possibleReflections[0][0] = 1;
			possibleReflections[0][1] = -1;
		} else if (x == 0 && y == 0) { //NW Corner
			possibleReflections = new int[1][2];
			possibleReflections[0][0] = 1;
			possibleReflections[0][1] = 1;
		} else if (x == 0) { //W Wall
			possibleReflections = new int[3][2];
			possibleReflections[0][0] = 1;
			possibleReflections[0][1] = -1;
			possibleReflections[1][0] = 1;
			possibleReflections[1][1] = 0;
			possibleReflections[2][0] = 1;
			possibleReflections[2][1] = 1;
		} else if (x == boardWidth - 1) { // E Wall
			possibleReflections = new int[3][2];
			possibleReflections[0][0] = -1;
			possibleReflections[0][1] = -1;
			possibleReflections[1][0] = -1;
			possibleReflections[1][1] = 0;
			possibleReflections[2][0] = -1;
			possibleReflections[2][1] = 1;
		} else if (y == 0) { // N Wall
			possibleReflections = new int[3][2];
			possibleReflections[0][0] = -1;
			possibleReflections[0][1] = 1;
			possibleReflections[1][0] = 0;
			possibleReflections[1][1] = 1;
			possibleReflections[2][0] = 1;
			possibleReflections[2][1] = 1;
		} else { // if (y == boardHeight - 1) //S Wall
			possibleReflections = new int[3][2];
			possibleReflections[0][0] = -1;
			possibleReflections[0][1] = -1;
			possibleReflections[1][0] = 0;
			possibleReflections[1][1] = -1;
			possibleReflections[2][0] = 1;
			possibleReflections[2][1] = -1;
		}
	} // end Wall

	@Override
	public void visit(GameObject other) {
		if (other instanceof Ball) {
			Ball b = (Ball) other;
			int index = Random.nextInt(possibleReflections.length);
			b.setSpeedX(possibleReflections[index][0]);
			b.setSpeedY(possibleReflections[index][1]);
			b.setPosX(getPosX() + possibleReflections[index][0]);
			b.setPosY(getPosY() + possibleReflections[index][1]);
			if (getPosY() == getLevel().getHeight()-1) {
				player.setLives(player.getLives()-1);
				System.out.println("Ball berührt unteren Spielfeldrand, es wird ein Leben abgezogen. Neue Leben: " + player.getLives());
			}
		} else if (other instanceof Bat) {
			other.setPosX(getPosX()+possibleReflections[0][0]);
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	public String getName() {
		return "Wand";
	}
} // end class Wall
