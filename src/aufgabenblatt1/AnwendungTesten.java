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
public class AnwendungTesten {

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

}
