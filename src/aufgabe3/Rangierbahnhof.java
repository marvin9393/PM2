package aufgabe3;

import java.util.Observable;

/**
 * 
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe3.1 Verwendete Quellen:
 */
public class Rangierbahnhof extends Observable {

  /**
   * feste Anzahl an Gleisen fuer den Bahnhof
   */
  private Zug[] gleisArray = new Zug[3];

  /**
   * Da immer nur ein Zug einfahren darf, ist diese Methode synchronisiert
   * 
   * @return
   */
  public synchronized int einfahren(int stationsNr) {
    while (gleisArray[stationsNr] != null)
      try {
        wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();

      }

    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    gleisArray[stationsNr]=new Zug();
    setChanged();
    notifyObservers();
    notifyAll();
    return stationsNr + 1;
  }

  public synchronized int ausfahren(int stationsNr) {

    while (gleisArray[stationsNr] == null)
      try {
        wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();

      }

    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    gleisArray[stationsNr]=null;
    setChanged();
    notifyObservers();
    notifyAll();
    return stationsNr + 1;
  }

  /**
   * getter zug
   * 
   * @param i
   * @return
   */
  public Zug getZug(int i) {
    if (i <= 2) {
      return gleisArray[i];
    }
    return null;
  }

}
