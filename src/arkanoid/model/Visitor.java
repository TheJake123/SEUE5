package arkanoid.model;

/**
 * Das Interface f�r Objekte, die W�nde besuchen k�nnen
 */
public interface Visitor {
	/**
	 * Wenn ein Ball einem anderen In Ber�hrung kommt
	 * @param other Die Wand, mit dem das Objekt in Ber�hrung kommt
	 */
	public void visit(GameObject other);
}
