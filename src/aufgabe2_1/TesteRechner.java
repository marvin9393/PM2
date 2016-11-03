package aufgabe2_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteRechner {

	@Test
	public void testeOperationen() {
		Rechner rechner = new Rechner();
		assertEquals("Addition fehlgeschlagen!",
		    rechner.berechne(Operation.ADDITION, 12.0, 11.0), (Double) 23.0);

		assertEquals("Subtraktion fehlgeschlagen!",
		    rechner.berechne(Operation.SUBTRAKTION, 12.0, 14.0), (Double) (-2.0));

		assertEquals("Multiplikation fehlgeschlagen!",
		    rechner.berechne(Operation.MULTIPLIKATION, 14.0, 11.0), (Double) 154.0);

		assertEquals("Division fehlgeschlagen!",
		    rechner.berechne(Operation.DIVISION, 15.0, 2.0), (Double) 7.5);
	}

	@Test
	public void testeDoubleDoubleZuDouble() {
		Rechner rechner = new Rechner();

		assertEquals("Double Multiplikation fehlgeschlagen!",
		    rechner.berechne(Operation.DMULTIPLIKATION, 2.0, 3.0), (Double) 6.0);

	}

}
