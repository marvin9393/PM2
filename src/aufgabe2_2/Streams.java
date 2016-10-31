/**
*
*
*
*/
package aufgabe2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 2, Aufgabe 2.2
* Verwendete Quellen: */
public class Streams {
	
	private List <String> stringArray;
	
	
	public Streams(){
		stringArray=new ArrayList<String>();
		System.out.println("Bitte geben Sie einen String ein der Verarbeitet werden soll,"
				+ "wenn Sie fertig sind schreiben Sie /fertig");
	}
	
	/**
	 * Methode um Benutzerdefinierte Eingabe einzulesen
	 * @return
	 */
	private String benutzerEingabe(){
		Scanner scanner=new Scanner(System.in);
		return scanner.nextLine();
		}
	
	/**
	 * fuehre aus und speichert die ergebnisse in der liste
	 * @param eingabe
	 */
	private void fuehreaus(String eingabe){
		if(!(eingabe.equals("/fertig"))){
			if(eingabe.equals("null")){
				stringArray.add(null);
				fuehreaus(benutzerEingabe());
			}
			else{
				stringArray.add(eingabe);
				fuehreaus(benutzerEingabe());
			}
			
		}
	}
	

	public void arbeiteMitStream(){
		Stream<String> woerterStream =stringArray.stream();
		
		
		woerterStream.forEach(System.out::println);
	}
	public static void main(String[] args){
		Streams stream =new Streams();
		
		stream.fuehreaus(stream.benutzerEingabe());
		stream.arbeiteMitStream();
		
	}
	

}
