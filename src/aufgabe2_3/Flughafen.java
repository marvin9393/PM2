/**
*
*
*
*/
package aufgabe2_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.3 Verwendete Quellen:
 */
public class Flughafen extends Thread {

  /**
   * speichert die Anzahl an Flugzeugen die gleichzeitig fliegen sollen.
   */
  private int anzahlFlugzeuge;

  /**
   * speichert die Flugzeuge-Objekte die gleichzeitig fliegen in einer Liste.
   */
  private List<Flugzeug> flugzeuge;

  /**
   * speichert die Zeit ab Laufzeit
   */
  private int zeit;

  /**
   * "Schluessel" um Flugzeugen zu ermoeglichen alleine zu landen
   */
  private boolean istLandebahnFrei = true;

  /**
   * Konstruktor weist die Objektvariablen zu.
   * 
   * @param anzahlFlugzeuge
   */
  public Flughafen(int anzahlFlugzeuge) {
    this.anzahlFlugzeuge = anzahlFlugzeuge;
    flugzeuge = new ArrayList<Flugzeug>();
    zeit = 1;
  }

  /**
   * Laesst ein Flugzeug landen.
   * 
   * @param flugzeug
   */
  public synchronized void landen(Flugzeug flugzeug) {
    if (istLandebahnFrei) {
      flugzeug.setLandeAnflug();
      istLandebahnFrei = false;
      try {
        sleep(1500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      flugzeug.istGelandet();
      istLandebahnFrei = true;
      notifyAll();
    } else {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Methode um Flugzeug-Objekte zu erzeugen mit Ausgabe
   * 
   * @param flughafen
   * @return
   */
  private Flugzeug erzeugeFlugzeug(Flughafen flughafen) {
    double zufallsZahl = Math.random() * 6 + 1;
    Flugzeug flugzeug = new Flugzeug(generiereFlugzeugName(), (int) zufallsZahl,
        flughafen, zeit);
    System.out.println("->Neues Flugzeug erzeugt: " + flugzeug.toString());
    return flugzeug;

  }

  /**
   * run()-Methode die ueber die start()-Methode aufgerufen wird. Erzeugt als
   * erstes die angegebene Anzahl an Flugzeug-Objekten. Danach ist die Methode
   * in einer Endlosschleife. Sie gibt den aktuellen Zeitschritt an und
   * verwaltet automatisch ueber die Flugzeug-Objekte. Sie werden automatisch
   * erzeugt und werden bei Statusaenderung und erreichter Bedingung geloescht
   * und ersetzt.
   */
  public void run() {
    for (int i = 0; i < anzahlFlugzeuge; i++) {
      flugzeuge.add(erzeugeFlugzeug(this));
      flugzeuge.get(i).start();
    }
    while (true) {
      System.out.println("Zeit: " + zeit);
      for (int i = 0; i < anzahlFlugzeuge; i++) {
        flugzeuge.get(i).setZeit(zeit);
        System.out.println(flugzeuge.get(i).toString());
        if (flugzeuge.get(i).isGelandet()) {
          flugzeuge.remove(i);
          flugzeuge.add(i, erzeugeFlugzeug(this));
          flugzeuge.get(i).start();
        }

      }

      try {
        sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      zeit++;

    }
  }

  /**
   * Erzeugt einen Flughafen mit zwei Flugzeugen.
   * 
   * @param args
   */
  public static void main(String[] args) {
    Flughafen flughafen = new Flughafen(2);
    flughafen.start();
  }

  /**
   * Implementierung um automatisch eine ID (Name) zu vergeben
   * 
   * @return
   */
  private String generiereFlugzeugName() {
    String stringID = "";
    int zufall = (int) (Math.random() * 6 + 1);
    switch (zufall) {
    case 1:
      stringID = "CONDOR";
      break;
    case 2:
      stringID = "LUFTHANSA";
      break;
    case 3:
      stringID = "EMIRATES";
      break;
    case 4:
      stringID = "AIR BERLIN";
      break;
    case 5:
      stringID = "PLANET EXPRESS";
      break;
    case 6:
      stringID = "TUI FLY";
      break;
    default:
      System.out.println("ID generieren fehlgeschlagen");
      break;
    }
    return stringID;
  }

}
