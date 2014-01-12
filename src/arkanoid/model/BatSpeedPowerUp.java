package arkanoid.model;

public class BatSpeedPowerUp extends PowerUp {
	private static class BatSpeedThread extends Thread {
		private boolean inEffect = false;
		private Bat bat = null;
		private int origSpeed = 1;
		private int counter = -1;
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
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		public boolean hasBat() {
			return bat != null;
		}
		public void setBat(Bat b) {
			bat = b;
			origSpeed = bat.getSpeedX();
		}

		public void startTimer() {
			inEffect = true;
			bat.setSpeedX(origSpeed * 3);
			counter = 15;
		}
	};
	private static BatSpeedThread t = new BatSpeedThread();
	public BatSpeedPowerUp(int x, int y, Level level, Player player) {
		super(x, y, 1, level, player);
		if (!t.isAlive()) 
			t.start();
	}

	public void visit(GameObject other) {
		super.visit(other);
		if (other instanceof Bat) {
			if (!t.hasBat())
				t.setBat((Bat)other);
			t.startTimer();
			getLevel().removeObject(this);
		}
	}

	@Override
	public String getName() {
		return "BatSpeedPowerUp";
	}
}
