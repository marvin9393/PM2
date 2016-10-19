/**
*
*
*
*/
package aufgabe1_2;

import java.time.LocalDateTime;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
* Verwendete Quellen: */
public class Messung {
	
	/**
	 * Objekt variable die die Temperatur als Wert speichert
	 */
	private double wert;
	
	/**
	 * speichert die Daten wann die die Messung aufgenommen wurden ist
	 */
	private LocalDateTime zeitstempel;
	
	/**
	 * Konstruktor um die Messungen aus XML einzulesen
	 */
	public Messung(String stringWert, String stringZeitstempel){
		stringWert=stringWert.replace(',','.');
		this.wert=Double.parseDouble(stringWert);
		this.zeitstempel=LocalDateTime.parse(stringZeitstempel);
	}
	
	/**
	 * Konstruktor um ein Objekt zu erzeugen ohne XML
	 * @param wert
	 */
	public Messung(double wert){
		this.wert=wert;
		zeitstempel=LocalDateTime.now();
	}
	
	/**
	 * getter fuer den Wert.
	 * @return
	 */
	public double getWert(){
		return wert;
	}
	
	/**
	 * getter fuer den zeitstempel.
	 * @return
	 */
	public LocalDateTime getZeitstempel(){
		return zeitstempel;
	}
	
	/**
	 * getter fuer den Wert als String
	 * @return
	 */
	public String getWertString(){
		return String.valueOf(wert);
	}
	
	public String getZeitstempelString(){
		return zeitstempel.toString();
	}
	
	

}
