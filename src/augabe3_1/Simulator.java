/**
*
*
*
*/
package augabe3_1;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class Simulator implements Runnable{

	private Rangierbahnhof bf=new Rangierbahnhof();
	private Thread thread;
	
	public Simulator(){
		thread=new Thread(this);
	}
	@Override
	public void run() {
		while(true){
			Lokfuehrer lk=new Lokfuehrer(bf);
			lk.start();
			try {
				thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Thread getThread(){
		return thread;
	}
	public static void main (String[] args){
		Simulator s=new Simulator();
		s.getThread().start();
	}
}
