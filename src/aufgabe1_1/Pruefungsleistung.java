/**
*
*
*
*/
package aufgabe1_1;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
* Verwendete Quellen: */
public class Pruefungsleistung {
	
	/**
	 * Objektvariable die den Namen des Modules speichert
	 */
	private String nameDesModules;
	
	/**
	 * Objektvariable die die Note des Modules speichert
	 */
	private int note;
	
	/**
	 * Konstruktor der alle Objektvariablen zuweist.
	 * @param nameDesModules
	 * @param note
	 */
	public Pruefungsleistung(String nameDesModules, int note){
		this.nameDesModules=nameDesModules;
		this.note=note;
	}
	
	/**
	 * getter fuer den Namen des Modules.
	 * @return
	 */
	public String getNameDesModules(){
		return nameDesModules;
	}
	
	/**
	 * getter fuer die Note
	 * @return
	 */
	public int getNote(){
		return note;
	}
	

}
