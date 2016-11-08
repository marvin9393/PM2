/**
*
*
*
*/
package aufgabe2_3;

import java.util.ArrayList;
import java.util.List;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 2, Aufgabe 2.3
* Verwendete Quellen: */
public class Flughafen extends Thread{

	/**
	 * speichert die Anzahl an FLugzeuge die gleichzeitig fliegen sollen.
	 */
	private int anzahlFlugzeuge;
	
	/**
	 * speichert die Flugzeuge die gleichzeitig fliegen in einer Liste.
	 */
	private List<Flugzeug> flugzeuge;
	
	/**
	 * speichert die Zeit
	 */
	private int zeit;
	
	/**
	 * 
	 */
	
	private boolean istLandebahnFrei=true;
	/**
	 * Konstruktor weist die Objektvariablen zu.
	 * @param anzahlFlugzeuge
	 */
	public Flughafen(int anzahlFlugzeuge){
		this.anzahlFlugzeuge=anzahlFlugzeuge;
		flugzeuge=new ArrayList<Flugzeug>();
		zeit=1;
		}
	
	/**
	 * lässt ein Flugzeug landen.
	 * @param flugzeug
	 */
	public synchronized void landen(Flugzeug flugzeug){
		if(istLandebahnFrei){
			flugzeug.setLandeAnflug();
			istLandebahnFrei=false;
			try {
				//flughafen oder flugzeug
				sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flugzeug.istGelandet();
			istLandebahnFrei=true;
			notifyAll();
			}else{
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
	}
		
	
	private Flugzeug erzeugeFlugzeug(Flughafen flughafen){
		double zufallsZahl = Math.random() * 6 + 1;
		Flugzeug flugzeug =new Flugzeug(generiereFlugzeugName(), (int)zufallsZahl, flughafen, zeit);
		System.out.println("->Neues Flugzeug erzeugt: "+flugzeug.toString());
		return flugzeug;
		
	}
	
	public void run(){
		for(int i=0;i<anzahlFlugzeuge;i++){
			flugzeuge.add(erzeugeFlugzeug(this));
			flugzeuge.get(i).start();
		}
		while(true){
			System.out.println("Zeit: "+zeit);
			for(int i=0;i<anzahlFlugzeuge;i++){
				flugzeuge.get(i).setZeit(zeit);
				System.out.println(flugzeuge.get(i).toString());
				if(flugzeuge.get(i).isGelandet()){
					flugzeuge.remove(i);
					flugzeuge.add(i,erzeugeFlugzeug(this));
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
	
	
	
	public static void main(String[] args){
		Flughafen flughafen=new Flughafen(2);
		flughafen.start();
	}
	
	private String generiereFlugzeugName()
	  {
	    String s = "";
	    int random = (int) (Math.random() * 6 + 1);
	    switch (random)
	    {
	    case 1:
	      s = "CONDOR";
	      break;
	    case 2:
	      s = "LUFTHANSA";
	      break;
	    case 3:
	      s = "EMIRATES";
	      break;
	    case 4:
	      s = "AIR BERLIN";
	      break;
	    case 5:
	      s = "PLANET EXPRESS";
	      break;
	    case 6:
	      s = "TUI FLY";
	      break;
	    default:
	      System.out.println("Failed");
	      break;
	    }
	    return s;
	  }
	
	
}
