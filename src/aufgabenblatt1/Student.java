package aufgabenblatt1;
import java.util.*;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
* Verwendete Quellen: */
public class Student implements Comparable<Student>{
	
	/**
	 * Objektvariable die den Vornamen speichert.
	 */
	private String vorname;
	
	/**
	 * Objektvariable die den Nachnamen speichert.
	 */
	private String nachname;
	
	/**
	 * Objektvariable die die Matrikelnummer speichert.
	 */
	private int matrikelnummer;
	
	
	
	/**
	 * Objektvariable die eine Liste der Prüfungen speichert.
	 */
	private List<Pruefungsleistung> pruefungsleistung;

	/**
	 * Konstruktor Initialisiert die Objektvariablen
	 */
	public Student(String vorname, String nachname){
		this.vorname=vorname;
		this.nachname=nachname;
		Fachhochschule.anzahlStudenten++;
		matrikelnummer=Fachhochschule.anzahlStudenten;
		pruefungsleistung= new LinkedList<Pruefungsleistung>(); //lernen
	}
	
	/**
	 * Getter Vorname
	 */
	public String getVorname(){
		return vorname;
	}
	
	/**
	 * Getter Nachname
	 */
	public String getNachname(){
		return nachname;
	}
	
	/**
	 * Getter Matrikelnummer
	 */
	public int getMatrikelnummer(){
		return matrikelnummer;
	}
	
	@Override
	public boolean equals(Object anderesObject){
		if(!(anderesObject instanceof Student)){
			return false;
		}
		Student andereStudent=(Student) anderesObject;
		return (matrikelnummer==andereStudent.matrikelnummer);
	}
	
	@Override
	public int hashCode(){
		return matrikelnummer;
	}
	
	@Override
	public int compareTo(Student andererStudent){
		Integer student1=getMatrikelnummer();
		Integer student2=andererStudent.getMatrikelnummer();
		return student1.compareTo(student2);
	}
	
	
	
	
}
