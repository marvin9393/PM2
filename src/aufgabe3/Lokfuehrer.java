package aufgabe3;

/**
 * 
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 3, Aufgabe xx
* Verwendete Quellen:
 */
public class Lokfuehrer extends Thread {

  private Rangierbahnhof rangierbahnhof;

  public Lokfuehrer(Rangierbahnhof rb) {
    this.rangierbahnhof = rb;
  }

  public void run() {
    int gleis=0;
    while(gleis==0){
    	if (Math.random() > 0.5) {

            gleis=rangierbahnhof.einfahren();
            if (gleis!=0){
              System.out.println("Zug wird eingefahren in Gleis: "+gleis+" Von Thread"+this.currentThread().toString());
            }
          } else {
            
            gleis=rangierbahnhof.ausfahren();
            if(gleis!=0){
            System.out.println("Zug wird ausgefahren aus Gleis: "+gleis+" Von Thread"+this.currentThread().toString());
            }
            }
          if(gleis==0){
        		System.out.println("nichts zu tun"+" Von Thread"+this.currentThread().toString());
          }
    }
      
    }
  

  }
