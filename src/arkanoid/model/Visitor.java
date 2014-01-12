package arkanoid.model;

/**
 * Das Interface für Objekte, die Wände besuchen können
 */
public interface Visitor {
	/**
	 * Wenn ein Ball einem anderen In Berührung kommt
	 * @param other Die Wand, mit dem das Objekt in Berührung kommt
	 */
	public void visit(GameObject other);
}
