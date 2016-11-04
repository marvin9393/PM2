package aufgabe2_3;

public class Flugzeug extends Thread {

	private Flughafen flughafen;
	private String id;
	
	//strecke bsp 9
	private int flugdauer;
	
	//aktuelle zeit beim erzeugen, erstes bei 0
	private int startzeit;
	private Status status;
	
	//aktuelle zeit, bsp 0 - 9
	private int zeit;

	public Flugzeug(String id, int flugdauer, Flughafen flughafen, int zeit) {
		this.id = id;
		this.flugdauer = flugdauer;
		this.flughafen = flughafen;
		this.zeit = zeit;

		status = Status.IM_FLUG;
	}

	public void istGelandet() {
		status = Status.GELANDET;
	}

	public String toString() {
		String details = "";
		details += "Flugzeug " + id + "(" + status + ", Zeit bis Ziel: " + "??\n";
		return details;
	}

	public void setZeit(int zeit) {
		this.zeit = zeit;
	}

	public boolean isGelandet() {
		if (flugdauer >= zeit) {
			istGelandet();
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		setZeit(zeit);

	}

}
