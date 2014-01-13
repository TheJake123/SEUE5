package arkanoid.model;

/**
 * Die Klasse BatSpeedPowerUp repr�sentiert im Spiel ein PowerUp, welches den
 * Schl�ger f�r eine kurze Zeit beschleunigt.
 */
public class BatSpeedPowerUp extends PowerUp {
	private static class BatSpeedThread extends Thread {
		private Bat bat = null;
		private int counter = -1;
		private int origSpeed = 1;

		public boolean hasBat() {
			return bat != null;
		}

		@Override
		public void run() {
			while (!Thread.interrupted()) {
				try {
					Thread.sleep(1000);
					if (counter > 0) {
						counter--;
					} else if (counter == 0) {
						bat.setSpeedX(origSpeed);
						counter--;
						System.out
								.println("Schl�gerbeschleunigung deaktiviert");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void setBat(Bat b) {
			bat = b;
			origSpeed = bat.getSpeedX();
		}

		public void startTimer() {
			bat.setSpeedX(origSpeed * 3);
			counter = 15;
		}
	};

	private static BatSpeedThread t = new BatSpeedThread();

	/**
	 * BatSpeedPowerUp-Konstruktor, der f�r die Auswirkungen des PowerUp's einen
	 * Thread startet.
	 * 
	 * @param x
	 *            x-Position des PowerUp's.
	 * @param y
	 *            y-Position des PowerUp's.
	 * @param level
	 *            Aktuelle Level des Spiels.
	 * @param player
	 *            Aktuelle Spieler des Spiels.
	 * 
	 */
	public BatSpeedPowerUp(int x, int y, Level level, Player player) {
		super(x, y, 1, level, player);
		if (!t.isAlive())
			t.start();
	}

	/**
	 * R�ckgabe des Namens der Spielfigur.
	 * 
	 * @return String "BatSpeedPowerUp"
	 */
	@Override
	public String getName() {
		return "BatSpeedPowerUp";
	}

	/**
	 * Visitor Implementierung, welche bei einer Kollidierung mit dem Schl�ger
	 * die Auswirkungen f�r diesen startet.
	 * 
	 * @param other
	 *            Spielobjekt mit dem das PowerUp kollidiert
	 */
	@Override
	public void visit(GameObject other) {
		super.visit(other);
		if (other instanceof Bat) {
			if (!t.hasBat())
				t.setBat((Bat) other);
			t.startTimer();
			System.out.println("Schl�gerbeschleunigung aktiviert");
			getLevel().removeObject(this);
		}
	}
}
