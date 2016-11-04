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

		assertEquals("DoubleMultiplikation fehlgeschlagen",
		    Rechner.multiplikation1.werteAus(5.0, 5.0), (Double) 25.0);		
		
		assertEquals("Nullstelle ermitteln fehlgeschlagen",
				    Rechner.nullstelle.werteAus(2.0, 3.0), (Double) (-1.5));

	}

}
