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
public class NachVornamenSortieren implements Comparator<Student>{
	/**
	 * Vergleich nach Vorname und nachname
	 */
	@Override
	public int compare(Student student1, Student student2){
		return student1.getVorname().compareTo(student2.getVorname());
	}

}

