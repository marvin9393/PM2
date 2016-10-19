/**
*
*
*
*/
package aufgabe1_1;

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
	public void testePruefungsleistungerzeugen(){
		Pruefungsleistung pruefungsleistung=new Pruefungsleistung("PM2",15);
		assertEquals("Konstruktor hat den Namen des Modules nicht oder falsch zugewiesen", pruefungsleistung.getNameDesModules(),"PM2");
		assertEquals("Konstruktor hat die Note des Modules nicht oder falsch zugewiesen", pruefungsleistung.getNote(),15);
	}
	
	@Test
	public void testeStudentenerzeugen(){
		Student student=new Student("Marvin", "Petersen");
		assertEquals("Konstruktor hat den Vornamen des Studenten falsch oder nicht zugewiesen", student.getVorname(),"Marvin");
		assertEquals("Konstruktor hat den Nachnamen des Studenten falsch oder nicht zugewiesen", student.getNachname(),"Petersen");
	}
	
	@Test
	public void testeCompareTo(){
		Student student1=new Student("Marvin", "Petersen");
		Student student2=new Student("Sahin", "Tekes");
		assertEquals("Marvin hat eine kleinere Matrikelnummer als Sahin", student1.compareTo(student2),-1);
		assertEquals("Sahin hat eine Groeßere Matrikelnummer als Marvin", student2.compareTo(student1),1);
		assertEquals("Marvin hat die gleiche Matrikelnummer wie Marvin", student1.compareTo(student1),0);
	}
	
	@Test
	public void testeEquals(){
		Student student1=new Student("Marvin", "Petersen");
		Student student2=new Student("Sahin", "Tekes");
		Object object=new Object();
		
		assertEquals("Equals erkennt nicht das Marvin und Sahin verschiedene Studenten sind", student1.equals(student2),false);
		assertEquals("Equals erkennt nicht das Marvin und Marvin die gleichen Studenten sind", student1.equals(student1),true);
		assertEquals("Equals erkennt nicht das Marvin nicht mit einem Studenten sonder mit einem Object verglichen wird", student1.equals(object),false);
		}
	
	@Test
	public void testHinzufuegenVonPruefungsleistungen(){
		Pruefungsleistung pruefungsleistung=new Pruefungsleistung("PM2",15);
		Student student1=new Student("Marvin", "Petersen");
		student1.pruefungsleistungHinzufuegen(pruefungsleistung);
		assertEquals("Die Pruefungsleistung wurde nicht in die Liste hinzugefuegt", student1.getPruefungsleistungen().get(0).getNameDesModules(),"PM2");
	}
	
	@Test
	public void testSortierenNachname(){
		Student student1=new Student("Sahin", "Tekes");
		Student student2=new Student("Marvin", "Petersen");
		SortierenNachname sort=new SortierenNachname();
		
		assertTrue("T kommt nach dem P", sort.compare(student1, student2)>0);
		assertTrue("P kommt vor dem T", sort.compare(student2, student1)<0);
		assertTrue("Zwei objekte sind gleich", sort.compare(student1, student1)==0);
	}
	
	@Test
	public void testSortierenVorname(){
		Student student1=new Student("Sahin", "Tekes");
		Student student2=new Student("Marvin", "Petersen");
		SortierenVorname sort=new SortierenVorname();
		
		assertTrue("S kommt nach dem M", sort.compare(student1, student2)>0);
		assertTrue("M kommt vor dem S", sort.compare(student2, student1)<0);
		assertTrue("Zwei objekte sind gleich", sort.compare(student1, student1)==0);
		
	}
}
