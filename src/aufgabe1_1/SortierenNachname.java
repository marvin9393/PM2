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
public class SortierenNachname implements Comparator<Student>{
	
	public int compare(Student student1, Student student2){
		String name1=student1.getNachname()+student2.getVorname();
		String name2=student2.getNachname()+student2.getVorname();
		return name1.compareTo(name2);
	}
}
