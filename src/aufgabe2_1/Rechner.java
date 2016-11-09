/**
*
*
*
*/
package aufgabe2_1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

import javax.management.loading.PrivateClassLoader;

/**
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 2, Aufgabe 2.1 Verwendete Quellen:
 */
public class Rechner {

  /**
   * Im Konstruktor mit Rechenoperationen zu befuellende Map mit erwarteten
   * Parametern
   */
  private Map<Operation, BinaryOperator<Double>> operationen;

  /**
   * Binary-Operator fuer Rechenoperation Addition mit entsprechendem
   * Lambda-Ausdruck
   */
  private BinaryOperator<Double> addition = (zahl1, zahl2) -> {
    return zahl1 + zahl2;
  };

  /**
   * Binary-Operator fuer Rechenoperation Subtraktion mit entsprechendem
   * Lambda-Ausdruck
   */
  private BinaryOperator<Double> subtraktion = (zahl1, zahl2) -> {
    return zahl1 - zahl2;
  };

  /**
   * Binary-Operator fuer Rechenoperation Multiplikation mit entsprechendem
   * Lambda-Ausdruck
   */
  private BinaryOperator<Double> multiplikation = (zahl1, zahl2) -> {
    return zahl1 * zahl2;
  };

  /**
   * Binary-Operator fuer Rechenoperation Division mit entsprechendem
   * Lambda-Ausdruck
   */
  private BinaryOperator<Double> division = (zahl1, zahl2) -> {
    return zahl1 / zahl2;
  };

  /**
   * Eigene implementierung eines funktionalen Interfaces (SAM) mit
   * Rechenoperation Multiplikation und entsprechendem Lambda-Ausdruck
   */
  public static DoubleDoubleZuDouble multiplikationDouble = (zahl1, zahl2) -> {
    return zahl1 * zahl2;
  };

  /**
   * Eigene implementierung eines funktionalen Interfaces (SAM) mit
   * Rechenoperation Nullstelle (linear) und entsprechendem Lambda-Ausdruck
   */
  public static DoubleDoubleZuDouble nullstelle = (zahl1, zahl2) -> {
    return (zahl2 * -1) / zahl1;
  };

  /**
   * Aufzufuehrende Anweisung fuer jeweiligen Rechenoperator.
   * 
   * @param operation
   *          get() holt sich ueber Enum-Eintrag die gewuenschte Operation
   * @param zahl1
   * @param zahl2
   * @return apply() uebergibt den Operationen die benoetigten Werte
   */
  public Double berechne(Operation operation, double zahl1, double zahl2) {
    return operationen.get(operation).apply(zahl1, zahl2);
  }

  /**
   * Erzeugt beim Aufruf HashMap und fuellt diese mit zuvor implementierten
   * Rechenoperationen. Jede Rechenoperation ist nun ueber den entsprechenden
   * Enum-Eintrag aufzurufen.
   */
  public Rechner() {
    operationen = new HashMap<Operation, BinaryOperator<Double>>();
    operationen.put(Operation.ADDITION, addition);
    operationen.put(Operation.SUBTRAKTION, subtraktion);
    operationen.put(Operation.MULTIPLIKATION, multiplikation);
    operationen.put(Operation.DIVISION, division);
  }

}
