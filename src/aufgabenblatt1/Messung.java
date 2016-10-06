/**
*
*
*
*/
package aufgabenblatt1;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class Messung {

	/**
	 * Speichert die Uhrzeit der Messung in einer Objektvariable
	 */
	private int zeit;
	
	/**
	 * Speichert die Temperatur in Grad Celsius in einer Objektvariable.
	 */
	private int temperatur;
	
	/**
	 * Konstrukor zum zuweisen der Objektvariablen.
	 * @param zeit
	 * @param temperatur
	 */
	public Messung(int zeit, int temperatur){
		this.zeit=zeit;
		this.temperatur=temperatur;
	}
	
	/**
	 * Getter fuer die Zeit
	 * @return
	 */
	public int getZeit(){
		return zeit;
	}
	

	/**
	 * Getter fuer die Temperatur
	 */
	public int getTemperatur(){
		return temperatur;
	}
	
}
