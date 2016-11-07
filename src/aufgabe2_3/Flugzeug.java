package aufgabe2_3;

/**
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt xx, Aufgabe xx Verwendete Quellen:
 */
public class Flugzeug extends Thread {
	private Flughafen flughafen;
	private String id;
	private int flugdauer;
	private int startzeit;
	private int zeit;
	private Status status;

	public Flugzeug(String id, int flugdauer, Flughafen flughafen, int zeit) {
		this.id = id;
		this.flugdauer = flugdauer;
		this.flughafen = flughafen;
		startzeit = zeit;
		this.zeit = zeit;
		status = Status.IM_FLUG;
	}

	public int getFlugzeit() {
		return flugdauer + startzeit - zeit;
	}

	public void run() {
		while (!isGelandet()) {
			istGelandet();
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void istGelandet() {
		if (zeit == flugdauer + startzeit) {
			status = Status.IM_LANDEANFLUG;
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			status = Status.GELANDET;

		}
	}

	public String toString() {
		return "Flugzeug" + id + "(" + status.toString() + ", Zeit bis Ziel: " + (startzeit + flugdauer - zeit);
	}

	public void setZeit(int zeit) {
		this.zeit = zeit;
	}

	public boolean isGelandet() {
		return status == Status.GELANDET;
	}
}
