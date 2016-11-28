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

  /**
   * Objektvariable Varibale fuer die Liste vom Typ String
   */
  private List<String> stringArray;

  public Streams() {
    stringArray = new ArrayList<String>();
    System.out.println(
        "Bitte geben Sie einen String ein der verarbeitet werden soll, wenn Sie fertig sind schreiben Sie /fertig");
  }

  /**
   * fuehrt benutzerEingabe() rekursiv aus und speichert die ergebnisse in der
   * liste
   * 
   * @param eingabe
   */
  public void fuehreaus() {
    Scanner scanner = new Scanner(System.in);
    String eingabe = scanner.nextLine();
    while (!eingabe.equals("/fertig")) {

      if (eingabe.equals("null")) {
        stringArray.add(null);
      } else if (!eingabe.equals("/fertig")) {
        stringArray.add(eingabe);
      }
      eingabe = scanner.nextLine();
    }
    scanner.close();
  }

  /**
   * Methode um im Stream eingelesene Strings zu verarbeiten. Die Methode prueft
   * mit Lambda-Ausdruecken nach null-Eintraegen, entfernt Leerzeichen vor und
   * nach dem String, versetzt alle Zeichen in ihre grossegeschriebene Form,
   * wandelt deutsche Umlaute in ihre Schreibweise um und prueft auf eine Laenge
   * der Strings ueber 8 Zeichen.
   */
  public void arbeiteMitStream() {
    Stream<String> woerterStream = stringArray.stream();

    Predicate<String> nichtNull = wort -> (wort != null);

    woerterStream.filter(nichtNull)
        .map(String::toUpperCase).map(String::trim)
        .map(wort -> wort.replace("Ä", "AE"))
        .map(wort -> wort.replace("Ö", "OE"))
        .map(wort -> wort.replace("Ü", "UE"))
        .map(wort -> wort.replace("ß", "SS")).map(wort -> wort.length() >= 8
            ? wort.substring(0, 8) : wort.toUpperCase())
        .forEach(System.out::println);

  }

  /**
   * Main-Methode mit Beispielen aus aufgabenblatt02.pdf zum Testen der
   * Implementierung
   */
  public static void main(String[] args) {
    Streams stream = new Streams();
    stream.fuehreaus();
    stream.arbeiteMitStream();
  }

}
