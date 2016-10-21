/**
*
*
*
*/
package aufgabe1_3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Praktikum TIPM2, WS16-17 Gruppe: Marvin Petersen
 * (marvin.petersen@haw-hamburg.de), Sahin Tekes (sahin.tekes@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt xx, Aufgabe xx Verwendete 
 * Quellen: http://tinyurl.com/hm92uay
 */
public class TestAufgabe3 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testHinzufuegen() {
		ArrayListe a = new ArrayListe();
		a.hinzufuegen(11.3);
		a.hinzufuegen(33);
		a.hinzufuegen(15.2);

		assertEquals("Fehler beim hinzufuegen", a.getAnzahElemente(), 3);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testeLoeschenAnStelle() {
		ArrayListe a = new ArrayListe();
		a.hinzufuegen(11.3);
		a.hinzufuegen(33);
		a.hinzufuegen(15.2);
		a.entferneElementAnIndex(1);

		assertEquals("Fehler beim löschen und Anzahl der Elemente anpassen", a.getAnzahElemente(), 2);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testeToString() {
		ArrayListe a = new ArrayListe();
		a.hinzufuegen(11.3);
		a.hinzufuegen(15.2);
		assertEquals("Fehler beim toString", a.toString(), "11.3, 15.2");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void TestegetKleinsteElement() {
		ArrayListe a = new ArrayListe();
		a.hinzufuegen(15.2);
		a.hinzufuegen(9.1);
		assertEquals("Fehler beim toString", a.getKleinstesElement(), 9.1);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testeEntferneElement() {
		ArrayListe a = new ArrayListe();
		a.hinzufuegen(15.2);
		a.hinzufuegen(9.1);
		a.entferne(15.2);
		assertEquals("Fehler beim entfernen", a.getAnzahElemente(), 1);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testeElementeSucher() {
		ArrayListe a = new ArrayListe();
		a.hinzufuegen(15.2);
		a.hinzufuegen(8);
		a.hinzufuegen("Hallo, ich bin ein String");
		assertEquals("Fehler: Erstes Element ist keine Zahl", ElementenSucher.istErstesElementZahl(a), true);
		a.entferneElementAnIndex(0); // entfernt double 15.2
		assertEquals("Fehler: Erstes Element ist keine Zahl", ElementenSucher.istErstesElementZahl(a), true);
		a.entferneElementAnIndex(0); // entfernt int 8, hinterlässt String
		assertEquals("Fehler: Erstes Element ist keine Zahl", ElementenSucher.istErstesElementZahl(a), false);

	}

}
