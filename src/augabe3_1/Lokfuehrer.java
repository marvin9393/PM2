package augabe3_1;

public class Lokfuehrer extends Thread {

  private Rangierbahnhof rangierbahnhof;

  public Lokfuehrer(Rangierbahnhof rb) {
    this.rangierbahnhof = rb;
  }

  public void run() {
    int gleis;
    while (true) {
      if (Math.random() > 0.5) {

        gleis=rangierbahnhof.einfahren();
        if (gleis!=0){
          System.out.println("Zug wird eingefahren in Gleis: "+gleis);
        }
      } else {
        
        gleis=rangierbahnhof.ausfahren();
        if(gleis!=0){
        System.out.println("Zug wird ausgefahren aus Gleis: "+gleis);
      
        }
        }
    }
  }

}
