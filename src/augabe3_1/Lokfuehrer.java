package augabe3_1;

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
