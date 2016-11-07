/**
*
*
*
*/
package aufgabe2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class Flughafen extends Thread{
	
	private int anzahlFlugzeuge;
	private List<Flugzeug>flugzeuge;
	private int zeit;
	private boolean landebahnFrei=true;

	
	public Flughafen(int anzahlFlugzeuge){
		this.anzahlFlugzeuge=anzahlFlugzeuge;
		flugzeuge=new ArrayList<Flugzeug>();
		
	}
	
	
	
	public void landen(Flugzeug flugzeug){
		flugzeug.istGelandet();
	}
	
	public boolean getIstLandebahnFrei(){
		return landebahnFrei;
	}
	public void run(){
		for(int i=0;i<anzahlFlugzeuge;i++){
			flugzeuge.add(erzeugeFlugzeug(this, zeit));
			flugzeuge.get(i).start();
		}
		while(true){
			System.out.println("Zeit: "+zeit);
			for(int i=0;i<flugzeuge.size();i++){
				System.out.println(flugzeuge.get(i).toString());
				if(flugzeuge.get(i).isGelandet()){
					flugzeuge.remove(i);
					flugzeuge.add(i,erzeugeFlugzeug(this,zeit));
				}
				if(flugzeuge.get(i).getFlugzeit()>0){
					flugzeuge.get(i).setZeit(zeit);
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
	
	public Flugzeug erzeugeFlugzeug(Flughafen flughafen, int Zeit){
		return new Flugzeug(generiereID(),generiereFlugdauer(),this,zeit);
	}
	
	
	public static void main(String[] args){
		Flughafen flughafen=new Flughafen(5);
		flughafen.start();
	}
	
	private String generiereID(){
		int zahl=(int) (Math.random()*10);
		switch(zahl){
		case 1: return "Turkish Airlines 132";
		case 2: return "TUI 32";
		case 3: return "Planet Express 2";
		case 4: return "Air Berlin 1111";
		case 5: return "German Wings 6666";
		case 6: return "Euro Wings 12345";
		case 7: return "Turkish Airlines 631243789";
		case 8: return "British Airlines 13204i";
		case 9: return "Fly Emirates 12347";
		case 10: return "HVV Airlines 132";
		default: return "Lufthansa 2297";
		
		}
	}
	private int generiereFlugdauer(){
		int zahl=(int) (Math.random()*10);
		switch(zahl){
		case 1: return 5;
		case 2: return 10;
		case 3: return 15;
		case 4: return 20;
		case 5: return 25;
		case 6: return 30;
		case 7: return 35;
		case 8: return 40;
		case 9: return 18;
		case 10: return 9;
		default: return 12;
		
		}
	}
	
	

}
