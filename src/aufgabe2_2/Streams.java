/**
*
*
*
*/
package aufgabe2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.sun.org.apache.xpath.internal.functions.Function;

/**
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.2 Verwendete Quellen:
 */
public class Streams {

	private List<String> stringArray;

	public Streams() {
		stringArray = new ArrayList<String>();
		System.out
		    .println("Bitte geben Sie einen String ein der Verarbeitet werden soll,"
		        + "wenn Sie fertig sind schreiben Sie /fertig");
	}

	/**
	 * Methode um Benutzerdefinierte Eingabe einzulesen
	 * 
	 * @return
	 */
	private String benutzerEingabe() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	/**
	 * fuehre aus und speichert die ergebnisse in der liste
	 * 
	 * @param eingabe
	 */
	public void fuehreaus(String eingabe) {
		if (!(eingabe.equals("/fertig"))) {
			if (eingabe.equals("null")) {
				stringArray.add(null);
				fuehreaus(benutzerEingabe());
			} else {
				stringArray.add(eingabe);
				fuehreaus(benutzerEingabe());
			}

		}
	}

	public void arbeiteMitStream() {
		Stream<String> woerterStream = stringArray.stream();
		// Stream loescht alle null objekte.
		Predicate<String> nichtNull = wort -> (wort != null);
		Predicate<String> mehrAlsAcht = wort -> (wort.length() >= 8);

		woerterStream.filter(nichtNull).map(String::toUpperCase).map(String::trim)
		    .map(wort -> wort.replace("Ä", "AE"))
		    .map(wort -> wort.replace("Ö", "OE"))
		    .map(wort -> wort.replace("Ü", "UE"))
		    .map(wort -> wort.replace("ß", "SS")).map(wort -> wort.length() >= 8
		        ? wort.substring(0, 8) : wort.toUpperCase())
		    .forEach(System.out::println);

	}

	public static void main(String[] args) {
		Streams stream = new Streams();
		stream.fuehreaus("Eingabe");
		stream.fuehreaus("Äußeres  ");
		stream.fuehreaus("null");
		stream.fuehreaus("Straßen-Feger");
		stream.fuehreaus(" ein Haus");
		stream.arbeiteMitStream();
	}

}
