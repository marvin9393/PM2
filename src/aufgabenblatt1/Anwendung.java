/**
*
*
*
*/
package aufgabenblatt1;
/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.1
* Verwendete Quellen: */
public class Anwendung {
	
	public static void main(String[] args){
		Student s1=new Student("Marvin","Petersen");
		Student s2=new Student("Max","Mustermann");
		Student s3=new Student("Sahin","Tekes");
		Student s4=new Student("Appelin","Ahomas");
		
		
		
		Fachhochschule f1=new Fachhochschule(s1,s2,s3,s4);
		f1.sortierenMatrikelnummer();
		f1.ausgeben();
		f1.sortierenNachname();
		f1.ausgeben();
		
		
		
	}

}
