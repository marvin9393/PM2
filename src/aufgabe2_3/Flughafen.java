package aufgabe2_3;

import java.util.ArrayList;
import java.util.List;

public class Flughafen extends Thread {

	private int anzahlFlugzeuge;
	private List<Flugzeug> flugzeuge;
	private int zeit;
	private List<String> stringArray;
	private boolean landebahnFrei = true;

	public Flughafen(int anzahlFlugzeuge) {
		this.anzahlFlugzeuge = anzahlFlugzeuge;
		flugzeuge = new ArrayList<Flugzeug>();
		stringArray = new ArrayList<String>();
		zeit = 0;

		for (int i = 0; i < 3; i++) {
			erzeugeFlugezug();
		}
	}

	public void landen(Flugzeug flugzeug) {
		flugzeug.setStatus();
	}

	private Flugzeug erzeugeFlugezug() {
		String anzahl = " " + anzahlFlugzeuge + "";
		Flugzeug flugzeug = new Flugzeug(anzahl, 5, zeit);
		flugzeuge.add(0, flugzeug);
		anzahlFlugzeuge--;
		return flugzeug;
	}

	public synchronized void run() {
		while (!flugzeuge.isEmpty()) {
			zeit++;
			System.out.println("Zeit: " + zeit);
			for (int i = 0; i < flugzeuge.size(); i++) {
				if (flugzeuge.get(i) != null) {
					flugzeuge.get(i).run();
					if (flugzeuge.get(i).isGelandet()) {
						flugzeuge.remove(i);

						if (anzahlFlugzeuge != 0) {
							erzeugeFlugezug();

						}
					}
				}
			}
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Flughafen flughafen = new Flughafen(10);
		flughafen.start();
	}

}
