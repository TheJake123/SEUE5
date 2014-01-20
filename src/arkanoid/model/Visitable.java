package arkanoid.model;

/**
 * Das Interface für Objekte, die von einem Besucher besucht werden können.
 */
interface Visitable {
	/**
	 * Akzeptieren eines Besuchers.
	 */
	public void accept(Visitor v);
}
