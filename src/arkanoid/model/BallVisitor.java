package arkanoid.model;

interface BallVisitor {

public interface BallVisitor {
	/**
	 * Wenn ein Objekt mit dem Ball in Berührung kommt
	 * @param b Der Ball, mit dem das Objekt in Berührung kommt
	 */
	public void visit(Ball b);
}
