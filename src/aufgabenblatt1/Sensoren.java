/**
*
*
*
*/
package aufgabenblatt1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	private List<String> liste = new ArrayList<String>();

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
	
	 public void lesenEinerXmlDatei(String datei) throws IOException{
		 BufferedReader reader = null; 
		 reader = new BufferedReader(new FileReader(datei+".xml"));
		 String zeile = null;
		 while ((zeile = reader.readLine()) != null){
			 liste.add(zeile);
		 }
		 reader.close();
	 }
	 
	 public static void main(String []args) throws IOException{
		Sensoren sensor=new Sensoren("SahinSexzimmer");
		sensor.lesenEinerXmlDatei("sensorWohnzimmer");
		System.out.println(sensor.liste.toString());
	}
}

	

