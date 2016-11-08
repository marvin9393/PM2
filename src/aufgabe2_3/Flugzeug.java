package aufgabe2_3;

/**
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.3
 * Verwendete Quellen:
 */
public class Flugzeug extends Thread {

	/**
	 * Hält die Referenz auf einen Flughafen.
	 */
	private Flughafen flughafen;
	
	/**
	 * speichert den Namen des Flugzeuges
	 */
	private String id;
	
	/**
	 * speichert die Flugzeit die das Flugzeug noch zu fliegen hat.
	 */
	private int flugdauer;
	
	/**
	 * speichert den Status des Flugzeuges
	 */
	private Status status;
	
	/**
	 * Speichert die Zeit vom FLughafen
	 */
	private int zeit;
	
	/**
	 * speichert die startZeit
	 */
	private int startZeit;
	
	/**
	 * Konstruktor der die Objektvariablen zuweist.
	 * @param id
	 * @param flugdauer
	 * @param flughafen
	 */
	public Flugzeug(String id,int flugdauer,Flughafen flughafen,int zeit){
		this.id=id;
		this.flugdauer=flugdauer;
		this.flughafen=flughafen;
		status=Status.IM_FLUG;
		this.zeit=zeit;
		this.startZeit=zeit;
	}
	
	/**
	 * Run Methode
	 */
	public void run(){
		while(!isGelandet()){
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(flugdauer+startZeit<=zeit+1){
				flughafen.landen(this);
			}
		}
	}
	
	public int getFlugdauer(){
		if ((flugdauer+startZeit)<zeit){
			return 0;
		}
		return flugdauer+startZeit-zeit;
		
	}
	public void setLandeAnflug(){
		status=Status.IM_LANDEANFLUG;
	}
	/**
	 * Setzt den Status auf Gelandet
	 */
	public void istGelandet(){
		status=Status.GELANDET;
	}
	
	/**
	 * Prueft ob das Flugzeug gelandet ist.
	 * @return
	 */
	public boolean isGelandet(){
		return status==Status.GELANDET;
	}
	
	public void setZeit(int zeit){
		this.zeit=zeit;
	}
	/**
	 * gibt uns den Zustand eines Flugzeuges zurueck.
	 */
	public String toString(){
		if(isGelandet()){
			return "->Flugzeug gelandet: Flugzeug "+id+" ("+status.toString()+" Zeit bis Ziel: "+getFlugdauer()+")";
		}
		return "Flugzeug "+id+"("+status.toString()+" Zeit bis Ziel: "+getFlugdauer()+")";
	}
	
	
	
}
