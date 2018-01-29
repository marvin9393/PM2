/**
*
*
*
*/
package aufgabe2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt xx, Aufgabe xx Verwendete Quellen:
 * 
 * @param <T>
 */
public class StringVerarbeitung<T> {

  public String[] stringArray = new String[0];
  private int anzahlStrings;

  private List<T> stringList = new ArrayList<T>();

  // Eingabe mit Scanner
  //
  // public StringVerarbeitung() {
  // eingabeVonWoertern();
  // }
  //
  // private void eingabeVonWoertern() {
  // Scanner scanner = new Scanner(System.in);
  // String eingabe = "";
  // while (!(eingabe.equals("ENDE"))) {
  // eingabe = scanner.nextLine();
  // if (!(eingabe.equals("ENDE"))) {
  // speichernVonWoertern(eingabe);
  // }
  // }
  // scanner.close();
  // }
  //

  public StringVerarbeitung(String... wort) {
    for (String eingabe : wort)
      speichernVonWoertern(eingabe);
    verarbeiten();
  }

  public void verarbeiten() {

    Predicate<String> nichtNull = wort -> {
      if (wort == null) {
        return false;
      }
      return true;

    };
    Function<String, String> achtStellen = wort -> {
      if (wort.length() >= 8) {
        wort = wort.substring(0, 8);
      }
      return wort;
    };

    Function<String, String> umlauteEntfernen = wort -> {
      return wort.replace("Ä", "AE");
    };

    // Function<String, T> kopieren = wort -> {
    // stringList.add((T)wort);
    // return (T) wort.trim();
    // };

    Stream<String> stringVerarbeitung = Arrays.stream(stringArray);
    stringVerarbeitung.filter(nichtNull).map(String::trim)
        .map(String::toUpperCase).map(umlauteEntfernen).map(achtStellen)
        .forEach(wort -> stringList.add((T) wort));
    ;
  }

  private void speichernVonWoertern(String string) {
    String[] stringArrayKopie = new String[stringArray.length + 1];
    for (int i = 0; i < stringArray.length; i++) {
      stringArrayKopie[i] = stringArray[i];
    }
    stringArray = stringArrayKopie;
    stringArray[stringArray.length - 1] = string;
  }

  public String[] getStringArray() {
    return stringArray;
  }

  public static void main(String[] args) {
    StringVerarbeitung string = new StringVerarbeitung("Eingabe ", "Äußeres ",
        null, "Strassen-Feger", " ein Haus");

    System.out.println(string.stringList + "");
  }

}
