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

	private Map<Operation, BinaryOperator<Double>> operationen;

	private BinaryOperator<Double> addition = (zahl1, zahl2) -> {
		return zahl1 + zahl2;
	};
	private BinaryOperator<Double> subtraktion = (zahl1, zahl2) -> {
		return zahl1 - zahl2;
	};
	private BinaryOperator<Double> multiplikation = (zahl1, zahl2) -> {
		return zahl1 * zahl2;
	};
	private BinaryOperator<Double> division = (zahl1, zahl2) -> {
		return zahl1 / zahl2;
	};

	private DoubleDoubleZuDouble multiplikation1 = (zahl1, zahl2) -> {
		return zahl1 * zahl2;
	};

	private DoubleDoubleZuDouble nullstelle = (zahl1, zahl2) -> {
		return (zahl2 * -1) / zahl1;
	};

	public Rechner() {
		operationen = new HashMap<Operation, BinaryOperator<Double>>();
		operationen.put(Operation.ADDITION, addition);
		operationen.put(Operation.SUBTRAKTION, subtraktion);
		operationen.put(Operation.MULTIPLIKATION, multiplikation);
		operationen.put(Operation.DIVISION, division);
	}

	public Double berechne(Operation operation, double zahl1, double zahl2) {
		return operationen.get(operation).apply(zahl1, zahl2);
	}

	public static void main(String[] args) {
		Rechner rechner = new Rechner();
		System.out.println(rechner.berechne(Operation.MULTIPLIKATION, 12, 11));
		System.out.println(rechner.multiplikation1.werteAus(5.0, 5.0));
		System.out.println(rechner.nullstelle.werteAus(3.0, 2.0));
	}

}
