package aufgabe2_3;

import java.util.Formatter;

/**
 * 
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.3 Verwendete Quellen:
 */

public class Flugzeug extends Thread {

	/**
	 * Objektvariable die eine Referenz auf ein flughafen speichert.
	 */
	private Flughafen flughafen;

	/**
	 * Objektvariable die den Namen festlegt
	 */
	private String id;

	/**
	 * Objektvariable die die Flugdauer speichert
	 */
	private final int flugdauer;

	/**
	 * Objektvariable die die Zeit speichert
	 */
	private final int startzeit;

	/**
	 * speichert den Status
	 */
	private Status status;

	/**
	 * speichert die zeit die das flugzeug noch fliegen muss bis es den
	 * flughafen erreicht.
	 */
	private int zeit;

	/**
	 * 
	 * @param flughafen
	 * @param id
	 * @param flugdauer
	 */
	public Flugzeug(String id, int flugdauer, int startzeit) {
		this.id = id;
		this.flugdauer = flugdauer;
		this.startzeit = startzeit;
		this.zeit = flugdauer;
		status = Status.IM_FLUG;
	}

	public Flugzeug(Flughafen flughafen, String id, int flugdauer, int startzeit) {
		this.flughafen = flughafen;
		this.flughafen = flughafen;
		this.id = id;
		this.flugdauer = flugdauer;
		this.startzeit = startzeit;
		this.zeit = startzeit + flugdauer;
		status = Status.IM_FLUG;
	}

	/**
	 * gibt uns zurueck ob das flugzeug gelandet ist.
	 * 
	 * @return
	 */
	public boolean isGelandet() {
		return status == Status.GELANDET;
	}

	/**
	 * setzt den Status auf die Landung.
	 */
	public void setStatus() {
		if (status == Status.IM_FLUG && zeit <= 0) {
			status = Status.IM_LANDEANFLUG;
			System.out.println(toString());
			try {
				sleep(1500);
				status = Status.GELANDET;
				System.out.println("-> Flugzeug gelandet: " + toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String toString() {

		return "Flugzeug" + id + "(" + status.toString() + "), Zeit bis Ziel: " + zeit;
	}

	public void setZeit(int zeit) {
		this.zeit = zeit;
	}

	@Override
	public void run() {
		System.out.println(toString());
		setZeit(zeit - 1);
	}

	// public static void main(String[] args){
	// Flugzeug flugzeug=new Flugzeug("Air Berlin 112", 20, 0);
	// Flugzeug flugzeug1=new Flugzeug("Tui 1", 20, 0);
	// flugzeug.start();
	// flugzeug1.start();
	//
	// }

}
