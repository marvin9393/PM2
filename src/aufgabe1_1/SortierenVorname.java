/**
*
*
*
*/
package aufgabe1_1;

import java.util.Comparator;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt xx, Aufgabe xx
* Verwendete Quellen: */
public class SortierenVorname implements Comparator<Student>{
	
	/**
	 * Methode compare vergleicht zwei Studenten-Objekte anhand ihrer Vornamen.
	 * Ist der Nachname gleich, so wird der Nachname verglichen.
	 * M�gliche return-Werte= >0, ==0, <0
	 */
	public int compare(Student student1, Student student2){
		String name1=student1.getVorname()+student1.getNachname();
		String name2=student2.getVorname()+student2.getNachname();
		return name1.compareTo(name2);
	}

}
