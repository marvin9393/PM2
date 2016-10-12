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
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
* Verwendete Quellen: */
public class TestAufgabe1 {

	@Test
	public void testErzeugenderFachhochschule(){
		Student s1=new Student("Marvin","Petersen");
		Student s2=new Student("Marvin","Mustermann");
		Student s3=new Student("Sahin","Tekes");
		
		Fachhochschule f1=new Fachhochschule(s1,s2,s3);
		assertEquals("Fehler beim erzeugen und Hinzufuegen",f1.getAnzahlStudentetn(),3);
	}
	@Test
	public void testHinzufuegen() {
		
		Student s1=new Student("Marvin","Petersen");
		Student s2=new Student("Marvin","Mustermann");
		Student s3=new Student("Sahin","Tekes");
		
		Fachhochschule f1=new Fachhochschule(s1,s2,s3);
		Student s4=new Student("Appelin","Ahomas"); 
		f1.studentHinzufuegen(s4);
		assertEquals("Fehler beim Hinzufügen",f1.getAnzahlStudentetn(),4);
		
	}
	@Test
	public void testSortierennachNachnamen(){
		Student s1=new Student("Marvin","Petersen");
		Student s2=new Student("Marvin","Mustermann");
		Student s3=new Student("Sahin","Tekes");
		Student s4=new Student("Marvin","Murtermann");
		
		Fachhochschule f1=new Fachhochschule(s1,s2,s3,s4);
		f1.sortierenNachname();
		assertEquals("Fehler beim Sortieren erste Stelle",f1.getStudenten(0),s4);
		assertEquals("Fehler beim Sortieren zweite Stelle",f1.getStudenten(1),s2);
		assertEquals("Fehler beim Sortieren dritte Stelle",f1.getStudenten(2),s1);
		assertEquals("Fehler beim Sortieren vierte Stelle",f1.getStudenten(3),s3);
		
	}
	@Test
	public void testSortierennachVornamen(){
		Student s1=new Student("Marvin","Petersen");
		Student s2=new Student("Marvin","Mustermann");
		Student s3=new Student("Sahin","Tekes");
		Student s4=new Student("Marvin","Murtermann");
		
		Fachhochschule f1=new Fachhochschule(s1,s2,s3,s4);
		f1.sortierenVornamen();
		assertEquals("Fehler beim Sortieren erste Stelle",f1.getStudenten(0),s4);
		assertEquals("Fehler beim Sortieren zweite Stelle",f1.getStudenten(1),s2);
		assertEquals("Fehler beim Sortieren dritte Stelle",f1.getStudenten(2),s1);
		assertEquals("Fehler beim Sortieren vierte Stelle",f1.getStudenten(3),s3);
		
	}
	@Test
	public void testSortierenNachMatrikelnummer(){
		Student s1=new Student("Marvin","Petersen");
		Student s2=new Student("Marvin","Mustermann");
		Student s3=new Student("Sahin","Tekes");
		Student s4=new Student("Marvin","Murtermann");
		
		Fachhochschule f1=new Fachhochschule(s1,s2,s3,s4);
		f1.sortierenNachname();
		f1.sortierenMatrikelnummer();
		assertEquals("Fehler beim Sortieren an erster Stelle",f1.getStudenten(0),s1);
		assertEquals("Fehler beim Sortieren an zweiter Stelle",f1.getStudenten(1),s2);
		assertEquals("Fehler beim Sortieren an dritter Stelle",f1.getStudenten(2),s3);
		assertEquals("Fehler beim Sortieren an vierter Stelle",f1.getStudenten(3),s4);

	}
	
	

}
