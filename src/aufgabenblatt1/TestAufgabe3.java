/**
*
*
*
*/
package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class TestAufgabe3 {

	@Test
	public void testhinzufuegen() {
		ArrayListe a1=new ArrayListe();
		a1.hinzufuegen(1);
		a1.hinzufuegen(2);
		assertEquals("Anzahl der Elemente stimmt mit den Elementen ueberein",a1.getAnzahlElemente(),2);
		
	}

}
