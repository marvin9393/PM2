/**
*
*
*
*/
package aufgabenblatt1;
import java.util.*;
/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
* Verwendete Quellen: */
public class Fachhochschule {
	
	/**
	 * Statische Objektvariable zählt die Studenten
	 */
	public static int anzahlStudenten=0;
	
	/**
	 * Liste der Studenten an der Fachhochschule
	 */
	private List<Student> studenten;
	
	/**
	 * Konstruktor dem man beliebig viele Studenten mitgeben kann.
	 * @param student
	 */
	public Fachhochschule(Student...student){
		studenten=new LinkedList<Student>();
		for(int i=0;i<student.length;i++){
			studenten.add(student[i]);
		}
	}
	
	/**
	 * Ein Student in die Liste hinzufügen
	 * @param student
	 */
	public void studentHinzufuegen(Student student){
		studenten.add(student);
	}
	
	/**
	 * Sortiermethode über compareTo
	 */
	public void sortieren(){
		for(int i=0;i<studenten.size();i++){
			if(i+1<studenten.size()){
				int vergleich=studenten.get(i).compareTo(studenten.get(i+1));
				if(vergleich<0){
					Student speicher=studenten.get(i);
					studenten.set(i, studenten.get(i+1));
					studenten.set(i+1, speicher);
					i--;
				}
			}
			
		}
	}
	
	/**
	 * ausgeben der einzelnen Studenten in der Liste
	 */
	public void ausgeben(){
		for(int i=0;i<studenten.size();i++){
			System.out.println(studenten.get(i).toString());
		}
	}

}
