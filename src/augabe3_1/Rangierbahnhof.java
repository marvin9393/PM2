package augabe3_1;

import java.util.Observable;

/**
 * 
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 3, Aufgabe 
* Verwendete Quellen:
 */
public class Rangierbahnhof extends Observable{

  /**
   * feste Anzahl an Gleisen f�r den Bahnhof
   */
  private Zug[] gleisArray = new Zug[3];

  public synchronized int einfahren() {
    for (int i = 0; i < gleisArray.length; i++) {
      if (gleisArray[i] == null) {
        gleisArray[i] = new Zug();
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setChanged();
        notifyObservers();
        
        notifyAll();
        return i+1;  
      }
    }
    try {
		wait();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return 0;
  }

  public synchronized int ausfahren() {
    for (int i = 0; i < gleisArray.length; i++) {
      if (gleisArray[i] != null) {
        gleisArray[i] = null;
        try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setChanged();
        notifyObservers();
        notifyAll();
        return i+1;
      }
    }
    try {
		wait();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return 0;
  }
  
 
  
  public Zug getZug(int i){
	  if(i<=2){
		  return gleisArray[i];
		  }
	  return null;
  }

}
