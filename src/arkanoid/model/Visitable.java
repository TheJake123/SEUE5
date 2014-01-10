package arkanoid.model;

public interface Visitable {
	public void accept(BallVisitor visitor);
}
