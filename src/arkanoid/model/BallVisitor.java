package arkanoid.model;

public interface BallVisitor {
	/**
	 * Wenn ein Objekt mit dem Ball in Ber�hrung kommt
	 * @param b Der Ball, mit dem das Objekt in Ber�hrung kommt
	 */
	public void visit(Ball b);
}
