package arkanoid.model;

class Wall extends GameObject implements BallVisitor {
	private final int[][] possibleBallDirections;
	java.util.Random Random = new java.util.Random();
	public Wall(int x, int y, int boardWidth, int boardHeight) {
		super(x, y);
		if (x == boardWidth - 1 && y == boardHeight - 1) {
			possibleBallDirections = new int[1][2];
			possibleBallDirections[0][0] = -1;
			possibleBallDirections[0][1] = -1;
		} else if (x == boardWidth - 1 && y == 0) {
			possibleBallDirections = new int[1][2];
			possibleBallDirections[0][0] = -1;
			possibleBallDirections[0][1] = 1;
		} else if (x == 0 && y == boardHeight - 1) {
			possibleBallDirections = new int[1][2];
			possibleBallDirections[0][0] = 1;
			possibleBallDirections[0][1] = -1;
		} else if (x == 0 && y == 0) {
			possibleBallDirections = new int[1][2];
			possibleBallDirections[0][0] = 1;
			possibleBallDirections[0][1] = 1;
		} else if (x == 0) {
			possibleBallDirections = new int[3][2];
			possibleBallDirections[0][0] = 1;
			possibleBallDirections[0][1] = -1;
			possibleBallDirections[1][0] = 1;
			possibleBallDirections[1][1] = 0;
			possibleBallDirections[2][0] = 1;
			possibleBallDirections[2][1] = 1;
		} else if (x == boardWidth - 1) {
			possibleBallDirections = new int[3][2];
			possibleBallDirections[0][0] = -1;
			possibleBallDirections[0][1] = -1;
			possibleBallDirections[1][0] = -1;
			possibleBallDirections[1][1] = 0;
			possibleBallDirections[2][0] = -1;
			possibleBallDirections[2][1] = 1;
		} else if (y == 0) {
			possibleBallDirections = new int[3][2];
			possibleBallDirections[0][0] = -1;
			possibleBallDirections[0][1] = 1;
			possibleBallDirections[1][0] = 0;
			possibleBallDirections[1][1] = 1;
			possibleBallDirections[2][0] = 1;
			possibleBallDirections[2][1] = 1;
		} else { // if (y == boardHeight - 1)
			possibleBallDirections = new int[3][2];
			possibleBallDirections[0][0] = -1;
			possibleBallDirections[0][1] = -1;
			possibleBallDirections[1][0] = 0;
			possibleBallDirections[1][1] = -1;
			possibleBallDirections[2][0] = 1;
			possibleBallDirections[2][1] = -1;
		}
	} // end Wall

	@Override
	public void visit(Ball other) {
		int index = Random.nextInt(possibleBallDirections.length);
		other.setSpeedX(possibleBallDirections[index][0]);
		other.setSpeedY(possibleBallDirections[index][1]);
	}
	public void accept(WallVisitor visitor) {
		visitor.visit(this);
	}
} // end class Wall
