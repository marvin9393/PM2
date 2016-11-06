package aufgabe2_3;

import java.util.ArrayList;
import java.util.List;

public class Flughafen extends Thread{
	
	private int anzahlFlugzeuge;
	private List<Flugzeug> flugzeuge;
	private int zeit;
	
	
	public Flughafen(int anzahlFlugzeuge){
		this.anzahlFlugzeuge=anzahlFlugzeuge;
		flugzeuge=new ArrayList<Flugzeug>();
		zeit=0;
		for(int i=0;i<3;i++){
			erzeugeFlugezug();
		}
	}
	
	public void landen(Flugzeug flugzeug){
		flugzeug.istGelandet();
	}
	
	private Flugzeug erzeugeFlugezug(){
		String anzahl=""+anzahlFlugzeuge;
		Flugzeug flugzeug=new Flugzeug(anzahl, 5,zeit);
		flugzeuge.add(flugzeug);
		anzahlFlugzeuge--;
		return flugzeug;
	}
	
	public void run(){
		while(!flugzeuge.isEmpty()){
			zeit++;
			for(int i=0;i<flugzeuge.size();i++){
				if(flugzeuge.get(i)!=null){
					flugzeuge.get(i).run();
					if(flugzeuge.get(i).isGelandet()){
						flugzeuge.remove(i);
						if(anzahlFlugzeuge!=0){
							erzeugeFlugezug();
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		Flughafen flughafen=new Flughafen(10);
		flughafen.start();
	}

}
