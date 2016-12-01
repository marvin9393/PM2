package aufgabe3;

/**
 * 
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 3, Aufgabe xx Verwendete Quellen:
 */
public class Lokfuehrer extends Thread {

  private Rangierbahnhof rangierbahnhof;

  private int gleisEinfahrt;
  public Lokfuehrer(Rangierbahnhof rb) {
    this.rangierbahnhof = rb;
    this.gleisEinfahrt=(int)(Math.random()*3);
  }

  public void run() {
    int gleis = 0;
      if (Math.random() > 0.5) {
        
        
        gleis = rangierbahnhof.einfahren(gleisEinfahrt);
        if (gleis != 0) {
          System.out.println("Zug wird eingefahren in Gleis: " + gleis + " Von "
              + this.currentThread().toString());
        }
      } else {

        gleis = rangierbahnhof.ausfahren(gleisEinfahrt);
        if (gleis != 0) {
          System.out.println("Zug wird ausgefahren aus Gleis: " + gleis
              + " Von " + this.currentThread().toString());
        }
      }
      if (gleis == 0) {
        System.out.println(
            "Nichts zu tun!" + " Von " + this.currentThread().toString());
      }
    }

}
