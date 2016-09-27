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
public class Fachhochschule{
	
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
	 * Sortieren nach Matrikelnummer
	 */
	public void sortierenMatrikelnummer(){
		Collections.sort(studenten);
	}
	
	/**
	 *Studenten sortieren nach Nachnamen
	 */
	public void sortierenNachname(){
		Collections.sort(studenten, new StudentenNachNamenSortieren());
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
