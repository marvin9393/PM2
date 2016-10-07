/**
*
*
*
*/
package aufgabenblatt1;

import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.2
* Verwendete Quellen: */
public class Sensoren {

	/**
	 * Speichert den Ort an dem der Sensor steht in einer Objektvariable
	 */
	private String ort;
	
	/**
	 * Speichert die Messungen in einer Liste
	 */
	private List<Messung> messungen;
	
	public Sensoren(String ort){
		this.ort=ort;
	}
	
	/**
	 * Getter für den Ort
	 * @return
	 */
	public String getOrt(){
		return ort;
	}
	
	 DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	
}
