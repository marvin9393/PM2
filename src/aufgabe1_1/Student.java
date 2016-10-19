/**
*
*
*
*/
package aufgabe1_1;

import java.util.*;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
* Verwendete Quellen: */
public class Student implements Comparable<Student>{
	
	/**
	 * Objektvariable die den Vornamen eines Studenten speichert.
	 */
	private String vorname;
	
	/**
	 * Objektvariable die den Nachnamen eines Studenten speichert.
	 */
	private String nachname;
	
	/**
	 * Objektvariable die die Matrikelnummer speichert.
	 */
	private int matrikelnummer;
	
	/**
	 * Objektvariable mit einer Liste von Pruefungsleistungen
	 */
	private List<Pruefungsleistung> pruefungsleistungen;
	
	public static int ANZAHLSTUDENTEN=0;
	/**
	 * Konstruktor der den Namen und die Matrikelnummer an hand der 
	 * Anzahl der Studenten generiert.
	 * @param vorname
	 * @param nachname
	 */
	public Student(String vorname, String nachname){
		this.vorname=vorname;
		this.nachname=nachname;
		ANZAHLSTUDENTEN++;
		matrikelnummer=ANZAHLSTUDENTEN;
		pruefungsleistungen=new ArrayList<Pruefungsleistung>();
		}
	
	/**
	 * Getter fuer den Vornamen.
	 * @return
	 */
	public String getVorname(){
		return vorname;
	}
	
	/**
	 * Getter fuer den Nachnamen.
	 * @return
	 */
	public String getNachname(){
		return nachname;
	}
	
	/**
	 * Getter fuer die Liste der Pruefungsleistungen
	 * @return
	 */
	public List<Pruefungsleistung> getPruefungsleistungen(){
		return pruefungsleistungen;
	}
	@Override
	public boolean equals(Object anderesObject){
		if(!(anderesObject instanceof Student)){
			return false;
		}
		Student andererStudent=(Student) anderesObject;
		return (hashCode()==andererStudent.hashCode());
	}
	
	@Override
	public int hashCode(){
		return matrikelnummer;
	}
	
	@Override
	public int compareTo(Student andererStudent){
		Integer student1=hashCode();
		Integer student2=andererStudent.hashCode();
		
		return student1.compareTo(student2);
	}
	
	/**
	 * Hinzufeugen einer pruefungsleistung.
	 * @param pruefungsleistung
	 */
	public void pruefungsleistungHinzufuegen(Pruefungsleistung pruefungsleistung){
		pruefungsleistungen.add(pruefungsleistung);
	}
	

}
