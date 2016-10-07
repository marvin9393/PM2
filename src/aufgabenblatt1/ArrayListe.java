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
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.3
* Verwendete Quellen: */
public class ArrayListe <T>{
	
	/**
	 * Objektvariable die die Anzahl der Elemente in einer Liste speichert.
	 */
	private int anzahlElemente;
	
	
	/**
	 * Array die Verschiedene Objekte speichertn kann
	 */
	private Object[] elemente;
	
	public ArrayListe(){
		elemente=new Object[0];
	}
	
	public int getAnzahlElemente(){
		return anzahlElemente;
	}
	public void hinzufuegen(T element){
		 Object[] elementeNeu=new Object[elemente.length+1];
		 
		 for(int i=0;i<elemente.length;i++){
			 elementeNeu[i]=elemente[i];
		 }
		 elemente=elementeNeu;
		 elemente[elemente.length-1]=element;
		 anzahlElemente++;
	}
	

}
