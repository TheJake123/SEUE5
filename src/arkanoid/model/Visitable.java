package arkanoid.model;

/**
 * Das Interface f�r Objekte, die von einem Besucher besucht werden k�nnen.
 */
interface Visitable {
	/**
	 * Akzeptieren eines Besuchers.
	 */
	public void accept(Visitor v);
}
