/**
*
*
*
*/
package aufgabe1_3;

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
	public void testHinzufuegen(){
		ArrayListe a=new ArrayListe();
		a.hinzufuegen(11.3);
		a.hinzufuegen(33);
		a.hinzufuegen(15.2);
		
		assertEquals("Fehler beim hinzufuegen", a.getAnzahElemente(), 3);
	}
	
	@Test
	public void testeLoeschenAnStelle(){
		ArrayListe a=new ArrayListe();
		a.hinzufuegen(11.3);
		a.hinzufuegen(33);
		a.hinzufuegen(15.2);
		a.entferneElementAnIndex(1);
		
		
		assertEquals("Fehler beim löschen und Anzahl der Elemente anpassen", a.getAnzahElemente(), 2);
	}
	
	@Test
	public void testeToString(){
		ArrayListe a=new ArrayListe();
		a.hinzufuegen(11.3);
		a.hinzufuegen(15.2);
		assertEquals("Fehler beim toString",a.toString(),"11.3, 15.2");
	}
	
	@Test
	public void TestegetKleinsteElement(){
		ArrayListe a=new ArrayListe();
		a.hinzufuegen(15.2);
		a.hinzufuegen(9.1);
		assertEquals("Fehler beim toString",a.getKleinstesElement(),9.1);
	}
	
	@Test
	public void testeEntferneElement(){
		ArrayListe a=new ArrayListe();
		a.hinzufuegen(15.2);
		a.hinzufuegen(9.1);
		a.entferne(15.2);
		assertEquals("Fehler beim entfernen", a.getAnzahElemente(), 1);
	}
	
	@Test
	public void testeElementeSucher(){
		ArrayListe a=new ArrayListe();
		a.hinzufuegen(15.2);
		a.hinzufuegen(9);
		assertEquals("Fehler beim suchen kleinstes Element",ElementenSucher.istErstesElementZahl(a),false);
		a.entferneElementAnIndex(0);
		assertEquals("Fehler beim loeschen und hochschieben",ElementenSucher.istErstesElementZahl(a),true);
	}

}
