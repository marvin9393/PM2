package aufgabe2_3;

import java.util.List;

public class Flughafen {
	
	private int anzahlFlugzeuge;
	private List<Flugzeug> flugzeuge;
	private int zeit;
	
	
	public Flughafen(int anzahlFlugzeuge){
		this.anzahlFlugzeuge=anzahlFlugzeuge;
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
		Flugzeug flugzeug=new Flugzeug(anzahl, 100,zeit);
		flugzeuge.add(flugzeug);
		anzahlFlugzeuge--;
		return flugzeug;
	}
	
	public void run(){
		while(!flugzeuge.isEmpty()){
			zeit++;
			for(int i=)
		}
	}

}
